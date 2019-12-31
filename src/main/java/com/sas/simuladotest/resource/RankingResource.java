package com.sas.simuladotest.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sas.simuladotest.bo.RankingBO;
import com.sas.simuladotest.entity.Ranking;

@RestController
@RequestMapping("/ranking")
public class RankingResource {
	
	@Autowired
	private RankingBO rankingBO;
	
	@GetMapping("/{idSimulado}")
	public List<Ranking> buscarCincoPrimeirosColocadosPorSimulado(@PathVariable("idSimulado") Long idSimulado) {
		return rankingBO.buscarCincoPrimeirosColocadosPorSimulado(idSimulado);
	}
	
	@PostMapping("salvar/{idSimulado}")
	public void gerarRankingPorSimulado(@PathVariable("idSimulado") Long idSimulado) {
		rankingBO.salvarRanking(idSimulado);
	}

}
