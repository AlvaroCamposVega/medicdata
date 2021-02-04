package com.medicdata.integration.model;

import javax.persistence.Embeddable;

@Embeddable
public class PresionArterialPL {
	
	private int presionMinima;
	private int presionMaxima;

	public PresionArterialPL() {
		
	}

	public int getPresionMinima() {
		return presionMinima;
	}

	public void setPresionMinima(int presionMinima) {
		this.presionMinima = presionMinima;
	}

	public int getPresionMaxima() {
		return presionMaxima;
	}

	public void setPresionMaxima(int presionMaxima) {
		this.presionMaxima = presionMaxima;
	}

	@Override
	public String toString() {
		return "PresionArterialPL [presionMinima=" + presionMinima + ", presionMaxima=" + presionMaxima + "]";
	}
	
}
