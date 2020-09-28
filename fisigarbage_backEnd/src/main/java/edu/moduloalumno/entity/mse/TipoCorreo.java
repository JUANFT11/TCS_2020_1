package edu.moduloalumno.entity.mse;

import java.io.Serializable;

public class TipoCorreo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5027984497942884076L;
	
	private Integer id;
	private String tipoCorreo;
	public TipoCorreo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipoCorreo(Integer id, String tipoCorreo) {
		super();
		this.id = id;
		this.tipoCorreo = tipoCorreo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoCorreo() {
		return tipoCorreo;
	}
	public void setTipoCorreo(String tipoCorreo) {
		this.tipoCorreo = tipoCorreo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TipoCorreo [id=" + id + ", tipoCorreo=" + tipoCorreo + "]";
	}
	
	
	
}
