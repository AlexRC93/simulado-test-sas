package com.sas.simuladotest;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sas.simuladotest.bo.RankingBO;
import com.sas.simuladotest.entity.Ranking;
import com.sas.simuladotest.repository.GabaritoRepository;
import com.sas.simuladotest.repository.RankingRepository;



@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class SimuladotestApplicationTests {

	@Autowired
	private RankingBO rankingBO;
	
	@Autowired
	private RankingRepository rankingRepository;
	
	@Autowired
	private GabaritoRepository gabaritoRepository;
	
	@Test
	public void listarGabaritoDeUmaProva() {
		assertEquals(10, gabaritoRepository.buscarGabaritoPeloIdDaProva(1L).size());
	}
	
	@Test
	public void listarGabaritoDeUmSimulado() {
		assertEquals(30, gabaritoRepository.buscarGabaritoPeloIdDoSimulado(1L).size());
	}

	@Test
	public void gerarRanking() {
		rankingBO.salvarRanking(1L);
		List<Ranking> ranking = rankingBO.buscarCincoPrimeirosColocadosPorSimulado(1L);
		assertEquals(5, ranking.size());
		assertEquals(new Long(1), ranking.get(0).getAluno().getId());
		assertEquals(new Integer(1), ranking.get(0).getColocacao());
		assertEquals(670D, ranking.get(0).getNota(), 000.1);
		
		assertEquals(new Long(5), ranking.get(4).getAluno().getId());
		assertEquals(new Integer(4), ranking.get(4).getColocacao());
		assertEquals(640D, ranking.get(4).getNota(), 000.1);
	}
	
	@AfterEach
	public void limparRanking() {
		rankingRepository.deleteAll();
	}

}
