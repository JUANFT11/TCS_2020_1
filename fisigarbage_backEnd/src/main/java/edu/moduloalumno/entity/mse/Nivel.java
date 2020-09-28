package edu.moduloalumno.entity.mse;

import java.io.Serializable;

public class Nivel implements Serializable {

	private Integer nivel_id;
	private String nivel_desc;
	private String nivel_ini;
	public Nivel(Integer nivel_id, String nivel_desc, String nivel_ini) {
		super();
		this.nivel_id = nivel_id;
		this.nivel_desc = nivel_desc;
		this.nivel_ini = nivel_ini;
	}
	public Nivel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getNivel_id() {
		return nivel_id;
	}
	public void setNivel_id(Integer nivel_id) {
		this.nivel_id = nivel_id;
	}
	public String getNivel_desc() {
		return nivel_desc;
	}
	public void setNivel_desc(String nivel_desc) {
		this.nivel_desc = nivel_desc;
	}
	public String getNivel_ini() {
		return nivel_ini;
	}
	public void setNivel_ini(String nivel_ini) {
		this.nivel_ini = nivel_ini;
	}
	@Override
	public String toString() {
		return "Nivel [nivel_id=" + nivel_id + ", nivel_desc=" + nivel_desc + ", nivel_ini=" + nivel_ini + "]";
	}
	
	
}
