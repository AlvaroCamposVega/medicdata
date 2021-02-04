package com.sinensia.medicdata.backend.business.model;

public class PresionArterial {

	private int presionMinima;
	private int presionMaxima;
	
	public PresionArterial() {
	
	}

	public int getPresionMinima() {
		return presionMinima;
	}

	public void setPresion_minima(int presionMinima) {
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
		return "PresionArterial [presion_minima=" + presionMinima + ", presion_maxima=" + presionMaxima + "]";
	}
	
	
}
