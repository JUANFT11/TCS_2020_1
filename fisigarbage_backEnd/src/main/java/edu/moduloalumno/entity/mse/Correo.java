package edu.moduloalumno.entity.mse;

import java.io.Serializable;

public class Correo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4124233721777887072L;
	private String correo;
	public Correo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Correo(String correo) {
		super();
		this.correo = correo;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Correo [correo=" + correo + "]";
	}
	
	
	
}
