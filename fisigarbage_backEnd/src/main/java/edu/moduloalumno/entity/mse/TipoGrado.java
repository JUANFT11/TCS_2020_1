package edu.moduloalumno.entity.mse;

import java.io.Serializable;

public class TipoGrado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2472094005982315078L;
	private String id;
	private String nombre;
	public TipoGrado() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipoGrado(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "TipoGrado [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
