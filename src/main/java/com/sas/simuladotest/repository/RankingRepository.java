package com.sas.simuladotest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sas.simuladotest.entity.Ranking;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
	
	@Query(value = "select * from ranking where simulado_id = :idSimulado order by colocacao asc limit 5", nativeQuery = true)
	public List<Ranking> buscarCincoPrimeirosPeloIdDoSimulado(@Param("idSimulado") Long idSimulado);

}
