package com.sas.simuladotest.bo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.simuladotest.entity.Aluno;
import com.sas.simuladotest.entity.Gabarito;
import com.sas.simuladotest.entity.Ranking;
import com.sas.simuladotest.entity.Resposta;
import com.sas.simuladotest.entity.Simulado;
import com.sas.simuladotest.enums.Peso;
import com.sas.simuladotest.repository.GabaritoRepository;
import com.sas.simuladotest.repository.RankingRepository;
import com.sas.simuladotest.repository.RespostaRepository;

@Service
public class RankingBO {
	
	@Autowired
	private RankingRepository rankingRepository;
	
	@Autowired
	private RespostaRepository respostaRepository;
	
	@Autowired
	private GabaritoRepository gabaritoRepository;
	
	public void salvarRanking(Long idSimulado) {
		Integer contadorColocacao = 1;
		List<Aluno> alunosComNotasFinais = incrementarNP(idSimulado);
		alunosComNotasFinais = alunosComNotasFinais.stream().sorted(Comparator.comparingDouble(Aluno::getNota).reversed())
				.collect(Collectors.toList());
		for (int i = 0; i < alunosComNotasFinais.size(); i++) {
			Ranking ranking = new Ranking(alunosComNotasFinais.get(i), alunosComNotasFinais.get(i).getNota(), contadorColocacao, new Simulado(idSimulado));
			rankingRepository.save(ranking);
			if (i != (alunosComNotasFinais.size() - 1) &&
					Double.compare(alunosComNotasFinais.get(i+1).getNota(), alunosComNotasFinais.get(i).getNota()) < 0 ) {
				contadorColocacao++;
			}
		}
	}
	
	private List<Aluno> incrementarNP(Long idSimulado) {
		List<Resposta> respostas = respostaRepository.buscarRespostasPeloIdDoSimulado(idSimulado); 
		List<Aluno> alunos = retornarAlunosParticipantes(respostas);
		for (Aluno aluno : alunos) {
			List<Resposta> respostasCertasDoAluno = retornarRespostasCertasDeUmAluno(aluno, respostas, idSimulado);
			aluno.setNota(calculoNP(respostasCertasDoAluno));
		}
		return alunos;
	}
	
	private List<Resposta> retornarRespostasCertasDeUmAluno(Aluno aluno, List<Resposta> respostas, Long idSimulado) {
		List<Resposta> respostasCertas = new ArrayList<Resposta>();
		List<Resposta> respostasDoAluno = 
				(List<Resposta>) respostas.stream().filter(resposta -> resposta.getAluno().getId().equals(aluno.getId())).collect(Collectors.toList());
		List<Gabarito> gabaritos = gabaritoRepository.buscarGabaritoPeloIdDoSimulado(idSimulado);
		for (Resposta resposta : respostasDoAluno) {
			for (Gabarito gabarito : gabaritos) {
				if (resposta.getQuestao().getId().equals(gabarito.getQuestao().getId()) &&
						resposta.getItemResposta().equals(gabarito.getItemResposta())) {
					respostasCertas.add(resposta);
				}
			}
		}
		return respostasCertas;
	}

	private List<Aluno> retornarAlunosParticipantes(List<Resposta> respostas) {
		List<Aluno> alunos = new ArrayList<Aluno>();
		respostas.stream().forEach(resposta -> alunos.add(resposta.getAluno()));
		return alunos.stream().distinct().collect(Collectors.toList());
	}
	
	private Double calculoNP(List<Resposta> respostas) {
		Long qtdQuestoesFaceis = respostas.stream().filter(resposta -> resposta.getQuestao().getPeso().equals(Peso.FACIL)).count();
		Long qtdQuestoesMedias = respostas.stream().filter(resposta -> resposta.getQuestao().getPeso().equals(Peso.MEDIA)).count();
		Long qtdQuestoesDificeis = respostas.stream().filter(resposta -> resposta.getQuestao().getPeso().equals(Peso.DIFICIL)).count();
		Long np = (qtdQuestoesFaceis * Peso.FACIL.getPontos()) + (qtdQuestoesMedias * Peso.MEDIA.getPontos()) 
				+ (qtdQuestoesDificeis * Peso.DIFICIL.getPontos()) + 600;
		return np.doubleValue();
	}
	
	public List<Ranking> buscarCincoPrimeirosColocadosPorSimulado(Long idSimulado) {
		return rankingRepository.buscarCincoPrimeirosPeloIdDoSimulado(idSimulado);
	}

}
