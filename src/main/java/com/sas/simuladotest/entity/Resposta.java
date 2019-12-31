package com.sas.simuladotest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
@SequenceGenerator(name = "resposta_sequence", sequenceName = "resposta_id_seq", initialValue = 1, allocationSize = 1)
public class Resposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Questao questao;

	private String itemResposta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getItemResposta() {
		return itemResposta;
	}

	public void setItemResposta(String itemResposta) {
		this.itemResposta = itemResposta;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

}
