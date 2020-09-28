package edu.moduloalumno.entity.mse;

import java.io.Serializable;
import java.sql.Date;

public class Formacion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9196886506242402566L;
	
	private Integer formacion_id;
	private Integer modalidad;
	private Integer persona_id;
	private String codigoPersona;
	private Integer id_programa;
	private String nombrePrograma;
	private String siglaPrograma;
	private Integer nivel_id;
	private Integer institucion_id;
	private String institucion_desc;
	private String formacion_calumno;
	private Date formacion_fingreso;
	private Date formacion_fegreso;
	private Date formacion_fexped_grado;
	//Continuar tipeando las propiedades segun se requirea y segun se vaya avanzando con el proyecto
	
	
	
	
	
	public Integer getModalidad() {
		return modalidad;
	}
	public String getInstitucion_desc() {
		return institucion_desc;
	}
	public void setInstitucion_desc(String institucion_desc) {
		this.institucion_desc = institucion_desc;
	}
	public Formacion() {
	
	}
	
	
	public Formacion(Integer formacion_id, Integer modalidad, Integer persona_id, String codigoPersona,
			Integer id_programa, String nombrePrograma, String siglaPrograma, Integer nivel_id, Integer institucion_id,
			String institucion_desc, String formacion_calumno, Date formacion_fingreso, Date formacion_fegreso,
			Date formacion_fexped_grado) {
		super();
		this.formacion_id = formacion_id;
		this.modalidad = modalidad;
		this.persona_id = persona_id;
		this.codigoPersona = codigoPersona;
		this.id_programa = id_programa;
		this.nombrePrograma = nombrePrograma;
		this.siglaPrograma = siglaPrograma;
		this.nivel_id = nivel_id;
		this.institucion_id = institucion_id;
		this.institucion_desc = institucion_desc;
		this.formacion_calumno = formacion_calumno;
		this.formacion_fingreso = formacion_fingreso;
		this.formacion_fegreso = formacion_fegreso;
		this.formacion_fexped_grado = formacion_fexped_grado;
	}
	public Integer getFormacion_id() {
		return formacion_id;
	}
	public void setFormacion_id(Integer formacion_id) {
		this.formacion_id = formacion_id;
	}
	
	
	
	
	public String getSiglaPrograma() {
		return siglaPrograma;
	}
	public void setSiglaPrograma(String siglaPrograma) {
		this.siglaPrograma = siglaPrograma;
	}
	public String getCodigoPersona() {
		return codigoPersona;
	}
	public void setCodigoPersona(String codigoPersona) {
		this.codigoPersona = codigoPersona;
	}
	public String getNombrePrograma() {
		return nombrePrograma;
	}
	public void setNombrePrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;
	}
	public void setModalidad(Integer modalidad) {
		this.modalidad = modalidad;
	}
	public Integer getPersona_id() {
		return persona_id;
	}
	public void setPersona_id(Integer persona_id) {
		this.persona_id = persona_id;
	}
	public Integer getId_programa() {
		return id_programa;
	}
	public void setId_programa(Integer id_programa) {
		this.id_programa = id_programa;
	}
	public Integer getNivel_id() {
		return nivel_id;
	}
	public void setNivel_id(Integer nivel_id) {
		this.nivel_id = nivel_id;
	}
	public Integer getInstitucion_id() {
		return institucion_id;
	}
	public void setInstitucion_id(Integer institucion_id) {
		this.institucion_id = institucion_id;
	}
	
	
	
	public String getFormacion_calumno() {
		return formacion_calumno;
	}
	public void setFormacion_calumno(String formacion_calumno) {
		this.formacion_calumno = formacion_calumno;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getFormacion_fingreso() {
		return formacion_fingreso;
	}
	public void setFormacion_fingreso(Date formacion_fingreso) {
		this.formacion_fingreso = formacion_fingreso;
	}
	public Date getFormacion_fegreso() {
		return formacion_fegreso;
	}
	public void setFormacion_fegreso(Date formacion_fegreso) {
		this.formacion_fegreso = formacion_fegreso;
	}
	public Date getFormacion_fexped_grado() {
		return formacion_fexped_grado;
	}
	public void setFormacion_fexped_grado(Date formacion_fexped_grado) {
		this.formacion_fexped_grado = formacion_fexped_grado;
	}
	@Override
	public String toString() {
		return "Formacion [formacion_id=" + formacion_id + ", modalidad=" + modalidad + ", persona_id=" + persona_id
				+ ", codigoPersona=" + codigoPersona + ", id_programa=" + id_programa + ", nombrePrograma="
				+ nombrePrograma + ", siglaPrograma=" + siglaPrograma + ", nivel_id=" + nivel_id + ", institucion_id="
				+ institucion_id + ", institucion_desc=" + institucion_desc + ", formacion_calumno=" + formacion_calumno
				+ ", formacion_fingreso=" + formacion_fingreso + ", formacion_fegreso=" + formacion_fegreso
				+ ", formacion_fexped_grado=" + formacion_fexped_grado + "]";
	}
	
	
	
	
	

	
	
}
