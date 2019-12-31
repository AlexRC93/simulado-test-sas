package com.sas.simuladotest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sas.simuladotest.enums.Peso;

@Entity
@Table(name = "questao")
public class Questao {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	private String enunciado;
	
	@Column(name = "item_a")
	private String itemA;
	
	@Column(name = "item_b")
	private String itemB;
	
	@Column(name = "item_c")
	private String itemC;

	@Column(name = "item_d")
	private String itemD;
	
	@Enumerated(EnumType.STRING)
	private Peso peso;
	
	@ManyToOne
	@JoinColumn(name = "prova_id")
	private Prova prova;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getItemA() {
		return itemA;
	}

	public void setItemA(String itemA) {
		this.itemA = itemA;
	}

	public String getItemB() {
		return itemB;
	}

	public void setItemB(String itemB) {
		this.itemB = itemB;
	}

	public String getItemC() {
		return itemC;
	}

	public void setItemC(String itemC) {
		this.itemC = itemC;
	}

	public String getItemD() {
		return itemD;
	}

	public void setItemD(String itemD) {
		this.itemD = itemD;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Peso getPeso() {
		return peso;
	}

	public void setPeso(Peso peso) {
		this.peso = peso;
	}

}
