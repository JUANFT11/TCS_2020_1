package edu.moduloalumno.entity.mse;

import java.io.Serializable;

import edu.moduloalumno.entity.Facultad;
import edu.moduloalumno.entity.Usuario;

public class ConProgramaPorAlumno implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codAlumno;

	private String anioIngreso;

	private String anioEgreso;

	private String nomPrograma;

	private String siglaPrograma;

	private Integer id_programa;

	public ConProgramaPorAlumno() {
	}

	public String getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}

	public String getAnioIngreso() {
		return anioIngreso;
	}

	public void setAnioIngreso(String anioIngreso) {
		this.anioIngreso = anioIngreso;
	}

	public String getAnioEgreso() {
		return anioEgreso;
	}

	public void setAnioEgreso(String anioEgreso) {
		this.anioEgreso = anioEgreso;
	}

	public String getNomPrograma() {
		return nomPrograma;
	}

	public void setNomPrograma(String nomPrograma) {
		this.nomPrograma = nomPrograma;
	}

	public String getSiglaPrograma() {
		return siglaPrograma;
	}

	public void setSiglaPrograma(String siglaPrograma) {
		this.siglaPrograma = siglaPrograma;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getId_programa() {
		return id_programa;
	}

	public void setId_programa(Integer id_programa) {
		this.id_programa = id_programa;
	}

	@Override
	public String toString() {
		return "ConProgramaPorAlumno [codAlumno=" + codAlumno + ", anioIngreso=" + anioIngreso + ", anioEgreso="
				+ anioEgreso + ", nomPrograma=" + nomPrograma + ", siglaPrograma=" + siglaPrograma + ", id_programa="
				+ id_programa + "]";
	}

	

}
