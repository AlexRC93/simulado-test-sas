package com.sas.simuladotest.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "prova")
public class Prova {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	private String disciplina;
	
	@ManyToOne
	@JoinColumn(name = "simulado_id")
	private Simulado simulado;
	
	@OneToMany(mappedBy = "prova")
	private List<Questao> questoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

}
