package edu.moduloalumno.entity.mse;

import java.io.Serializable;

public class Facultad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6323747997565273411L;
	
	private Integer id;
	private String nombre;
	public Facultad() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facultad(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Facultad [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
}
