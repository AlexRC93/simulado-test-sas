package com.sas.simuladotest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.sas.simuladotest.entity.Gabarito;

public interface GabaritoRepository extends JpaRepository<Gabarito, Long> {
	
	@Query("select g from Gabarito g where g.questao.prova.simulado.id = :idSimulado")
	public List<Gabarito> buscarGabaritoPeloIdDoSimulado(@PathVariable("idSimulado") Long idSimulado);
	
	@Query("select g from Gabarito g where g.questao.prova.id = :idProva")
	public List<Gabarito> buscarGabaritoPeloIdDaProva(@PathVariable("idProva") Long idProva);


}
