package edu.moduloalumno.entity.mse;

import java.io.Serializable;
import java.sql.Date;

public class EjercicioProfesionalDocente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3788006976218351970L;

	private Integer entidad;
	private String tipoEntidad;
	private String cargo;
	private String princFunc;
	private String tipoVincLab;
	private Date fechInic;
	private Date fechaFin;
	private String nomJefInmSup;
	private String corrJefInmSup;
	public EjercicioProfesionalDocente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EjercicioProfesionalDocente(Integer entidad, String tipoEntidad, String cargo, String princFunc,
			String tipoVincLab, Date fechInic, Date fechaFin, String nomJefInmSup, String corrJefInmSup) {
		super();
		this.entidad = entidad;
		this.tipoEntidad = tipoEntidad;
		this.cargo = cargo;
		this.princFunc = princFunc;
		this.tipoVincLab = tipoVincLab;
		this.fechInic = fechInic;
		this.fechaFin = fechaFin;
		this.nomJefInmSup = nomJefInmSup;
		this.corrJefInmSup = corrJefInmSup;
	}
	public Integer getEntidad() {
		return entidad;
	}
	public void setEntidad(Integer entidad) {
		this.entidad = entidad;
	}
	public String getTipoEntidad() {
		return tipoEntidad;
	}
	public void setTipoEntidad(String tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getPrincFunc() {
		return princFunc;
	}
	public void setPrincFunc(String princFunc) {
		this.princFunc = princFunc;
	}
	public String getTipoVincLab() {
		return tipoVincLab;
	}
	public void setTipoVincLab(String tipoVincLab) {
		this.tipoVincLab = tipoVincLab;
	}
	public Date getFechInic() {
		return fechInic;
	}
	public void setFechInic(Date fechInic) {
		this.fechInic = fechInic;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getNomJefInmSup() {
		return nomJefInmSup;
	}
	public void setNomJefInmSup(String nomJefInmSup) {
		this.nomJefInmSup = nomJefInmSup;
	}
	public String getCorrJefInmSup() {
		return corrJefInmSup;
	}
	public void setCorrJefInmSup(String corrJefInmSup) {
		this.corrJefInmSup = corrJefInmSup;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "EjercicioProfesionalDocente [entidad=" + entidad + ", tipoEntidad=" + tipoEntidad + ", cargo=" + cargo
				+ ", princFunc=" + princFunc + ", tipoVincLab=" + tipoVincLab + ", fechInic=" + fechInic + ", fechaFin="
				+ fechaFin + ", nomJefInmSup=" + nomJefInmSup + ", corrJefInmSup=" + corrJefInmSup + "]";
	}
	
	
}
