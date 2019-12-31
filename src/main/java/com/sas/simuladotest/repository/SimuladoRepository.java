package com.sas.simuladotest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.simuladotest.entity.Simulado;

public interface SimuladoRepository extends JpaRepository<Simulado, Long> {

}
