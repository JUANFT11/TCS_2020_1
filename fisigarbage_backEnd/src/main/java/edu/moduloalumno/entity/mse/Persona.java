package edu.moduloalumno.entity.mse;

import java.io.Serializable;
import java.sql.Date;

public class Persona implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7611789879989997102L;
	
	private Integer id;
	private String dni;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private Date fechaNac;
	private Integer edad;
	private String ubigeo;
	private Integer numHijos;
	private Integer estadoCivil;
	private String ultimo;
	private Integer estado_id;
	
	private String codigoAlumnoPrograma;
	
	public String getCodigoAlumnoPrograma() {
		return codigoAlumnoPrograma;
	}
	public void setCodigoAlumnoPrograma(String codigoAlumnoPrograma) {
		this.codigoAlumnoPrograma = codigoAlumnoPrograma;
	}
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Persona(Integer id, String dni, String apellidoPaterno, String apellidoMaterno, String nombres,
			Date fechaNac, Integer edad, String ubigeo, Integer numHijos, Integer estadoCivil, String ultimo,
			Integer estado_id, String codigoAlumnoPrograma) {
		super();
		this.id = id;
		this.dni = dni;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.fechaNac = fechaNac;
		this.edad = edad;
		this.ubigeo = ubigeo;
		this.numHijos = numHijos;
		this.estadoCivil = estadoCivil;
		this.ultimo = ultimo;
		this.estado_id = estado_id;
		this.codigoAlumnoPrograma = codigoAlumnoPrograma;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getUbigeo() {
		return ubigeo;
	}
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}
	public Integer getNumHijos() {
		return numHijos;
	}
	public void setNumHijos(Integer numHijos) {
		this.numHijos = numHijos;
	}
	public Integer getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getUltimo() {
		return ultimo;
	}
	public void setUltimo(String ultimo) {
		this.ultimo = ultimo;
	}
	public Integer getEstado_id() {
		return estado_id;
	}
	public void setEstado_id(Integer estado_id) {
		this.estado_id = estado_id;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", dni=" + dni + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", nombres=" + nombres + ", fechaNac=" + fechaNac + ", edad=" + edad + ", ubigeo="
				+ ubigeo + ", numHijos=" + numHijos + ", estadoCivil=" + estadoCivil + ", ultimo=" + ultimo
				+ ", estado_id=" + estado_id + ", codigoAlumnoPrograma=" + codigoAlumnoPrograma + "]";
	}
	
	
	
	
	
}
