package com.sinensia.medicdata.backend.business.model;

public class PresionArterial {

	private int presion_minima;
	private int presion_maxima;
	
	public PresionArterial() {
	
	}

	public int getPresion_minima() {
		return presion_minima;
	}

	public void setPresion_minima(int presion_minima) {
		this.presion_minima = presion_minima;
	}

	public int getPresion_maxima() {
		return presion_maxima;
	}

	public void setPresion_maxima(int presion_maxima) {
		this.presion_maxima = presion_maxima;
	}

	@Override
	public String toString() {
		return "PresionArterial [presion_minima=" + presion_minima + ", presion_maxima=" + presion_maxima + "]";
	}
	
	
}
