package com.sas.simuladotest.enums;

public enum Peso {
	
	FACIL(8), MEDIA(12), DIFICIL(15);
	
	private int pontos;
	
	Peso(int pontos) {
		this.pontos = pontos;
	}
	
	public int getPontos() {
		return pontos;
	}

}
