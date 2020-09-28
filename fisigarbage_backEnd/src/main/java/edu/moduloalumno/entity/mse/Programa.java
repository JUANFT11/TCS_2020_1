package edu.moduloalumno.entity.mse;

import java.io.Serializable;

public class Programa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8148498937759494089L;
	
	private Integer id;
	private String nombre;
	private String sigla;
	private String tipoGrado;
	private Integer facultadId;
	private boolean vigencia;
	private Integer prioridad;
	public Programa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Programa(Integer id, String nombre, String sigla, String tipoGrado, Integer facultadId, boolean vigencia,
			Integer prioridad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.sigla = sigla;
		this.tipoGrado = tipoGrado;
		this.facultadId = facultadId;
		this.vigencia = vigencia;
		this.prioridad = prioridad;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getTipoGrado() {
		return tipoGrado;
	}
	public void setTipoGrado(String tipoGrado) {
		this.tipoGrado = tipoGrado;
	}
	public Integer getFacultadId() {
		return facultadId;
	}
	public void setFacultadId(Integer facultadId) {
		this.facultadId = facultadId;
	}
	public boolean isVigencia() {
		return vigencia;
	}
	public void setVigencia(boolean vigencia) {
		this.vigencia = vigencia;
	}
	public Integer getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(Integer prioridad) {
		this.prioridad = prioridad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Programa [id=" + id + ", nombre=" + nombre + ", sigla=" + sigla + ", tipoGrado=" + tipoGrado
				+ ", facultadId=" + facultadId + ", vigencia=" + vigencia + ", prioridad=" + prioridad + "]";
	}
	
	
}
