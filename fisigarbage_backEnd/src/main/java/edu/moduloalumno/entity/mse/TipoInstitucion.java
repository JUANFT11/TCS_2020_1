package edu.moduloalumno.entity.mse;

import java.io.Serializable;

public class TipoInstitucion implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4014087573633311702L;
	
	private Integer id;
	private String descripcion;
	private String iniciales;
	public TipoInstitucion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipoInstitucion(Integer id, String descripcion, String iniciales) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.iniciales = iniciales;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIniciales() {
		return iniciales;
	}
	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}
	@Override
	public String toString() {
		return "TipoInstitucion [id=" + id + ", descripcion=" + descripcion + ", iniciales=" + iniciales + "]";
	}
	
	
}
