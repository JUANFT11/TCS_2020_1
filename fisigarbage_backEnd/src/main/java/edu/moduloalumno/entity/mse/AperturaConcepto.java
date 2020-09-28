package edu.moduloalumno.entity.mse;

public class AperturaConcepto {
	private String estadoConcepto;

	public AperturaConcepto() {
		super();
	}

	public AperturaConcepto(String estadoConcepto) {
		super();
		this.estadoConcepto = estadoConcepto;
	}

	public String getEstadoConcepto() {
		return estadoConcepto;
	}

	public void setEstadoConcepto(String estadoConcepto) {
		this.estadoConcepto = estadoConcepto;
	}

	@Override
	public String toString() {
		return "AperturaConcepto [estadoConcepto=" + estadoConcepto + "]";
	}
	
	
}
