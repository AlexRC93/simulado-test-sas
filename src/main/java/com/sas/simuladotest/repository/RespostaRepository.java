package com.sas.simuladotest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sas.simuladotest.entity.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long> {
	
	@Query("select r from Resposta r where r.questao.prova.simulado.id = :idSimulado")
	public List<Resposta> buscarRespostasPeloIdDoSimulado(@Param("idSimulado") Long idSimulado);

}
