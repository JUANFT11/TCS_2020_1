package edu.moduloalumno.entity.mse;

import java.io.Serializable;

public class PersonaTelefono implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3137218832177769022L;
	
	private Integer idPersona;
	private Integer idTipoTelefono;
	private Integer numeroTelefonico;
	
	public PersonaTelefono() {
		
	}
	
	public PersonaTelefono(Integer idPersona, Integer idTipoTelefono, Integer numeroTelefonico) {
		super();
		this.idPersona = idPersona;
		this.idTipoTelefono = idTipoTelefono;
		this.numeroTelefonico = numeroTelefonico;
	}
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public Integer getIdTipoTelefono() {
		return idTipoTelefono;
	}
	public void setIdTipoTelefono(Integer idTipoTelefono) {
		this.idTipoTelefono = idTipoTelefono;
	}
	public Integer getNumeroTelefonico() {
		return numeroTelefonico;
	}
	public void setNumeroTelefonico(Integer numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}

	@Override
	public String toString() {
		return "PersonaTelefono [idPersona=" + idPersona + ", idTipoTelefono=" + idTipoTelefono + ", numeroTelefonico="
				+ numeroTelefonico + "]";
	}
	
	
}
