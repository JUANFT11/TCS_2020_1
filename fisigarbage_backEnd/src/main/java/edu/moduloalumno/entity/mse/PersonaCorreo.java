package edu.moduloalumno.entity.mse;

import java.io.Serializable;

public class PersonaCorreo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8873550700983531796L;
	
	private Integer id;
	private Integer idTipoCorreo;
	private String correo;
	public PersonaCorreo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonaCorreo(Integer id, Integer idTipoCorreo, String correo) {
		super();
		this.id = id;
		this.idTipoCorreo = idTipoCorreo;
		this.correo = correo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdTipoCorreo() {
		return idTipoCorreo;
	}
	public void setIdTipoCorreo(Integer idTipoCorreo) {
		this.idTipoCorreo = idTipoCorreo;
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
		return "PersonaCorreo [id=" + id + ", idTipoCorreo=" + idTipoCorreo + ", correo=" + correo + "]";
	}
	
	
	
}
