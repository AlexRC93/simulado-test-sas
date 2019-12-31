package com.sas.simuladotest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ranking")
@SequenceGenerator(name = "ranking_sequence", sequenceName = "ranking_id_seq", initialValue = 1, allocationSize = 1)
public class Ranking {
	
	public Ranking() {
	}
	
	public Ranking(Aluno aluno, Double nota, Integer colocacao, Simulado simulado) {
		this.aluno = aluno;
		this.nota = nota;
		this.colocacao = colocacao;
		this.simulado = simulado;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	private Aluno aluno;

	private Double nota;

	private Integer colocacao;
	
	@OneToOne
	private Simulado simulado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Integer getColocacao() {
		return colocacao;
	}

	public void setColocacao(Integer colocacao) {
		this.colocacao = colocacao;
	}

}
