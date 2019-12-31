package com.sas.simuladotest.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "simulado")
public class Simulado {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	private String titulo;

	@Temporal(TemporalType.DATE)
	private Date data;

	@OneToMany(mappedBy = "simulado")
	private List<Prova> provas;
	
	public Simulado() {
		// TODO Auto-generated constructor stub
	}

	public Simulado(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

}
