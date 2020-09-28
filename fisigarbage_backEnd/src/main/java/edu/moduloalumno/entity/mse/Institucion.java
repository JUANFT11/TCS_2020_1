package edu.moduloalumno.entity.mse;

import java.io.Serializable;

public class Institucion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6081458505609376949L;
	private Integer id;
	private Integer idEconomico;
	private Integer idTipoInst;
	private String instDesc;
	private String instDescMin;
	private String instIni;
	public Institucion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Institucion(Integer id, Integer idEconomico, Integer idTipoInst, String instDesc, String instDescMin,
			String instIni) {
		super();
		this.id = id;
		this.idEconomico = idEconomico;
		this.idTipoInst = idTipoInst;
		this.instDesc = instDesc;
		this.instDescMin = instDescMin;
		this.instIni = instIni;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdEconomico() {
		return idEconomico;
	}
	public void setIdEconomico(Integer idEconomico) {
		this.idEconomico = idEconomico;
	}
	public Integer getIdTipoInst() {
		return idTipoInst;
	}
	public void setIdTipoInst(Integer idTipoInst) {
		this.idTipoInst = idTipoInst;
	}
	public String getInstDesc() {
		return instDesc;
	}
	public void setInstDesc(String instDesc) {
		this.instDesc = instDesc;
	}
	public String getInstDescMin() {
		return instDescMin;
	}
	public void setInstDescMin(String instDescMin) {
		this.instDescMin = instDescMin;
	}
	public String getInstIni() {
		return instIni;
	}
	public void setInstIni(String instIni) {
		this.instIni = instIni;
	}
	@Override
	public String toString() {
		return "Institucion [id=" + id + ", idEconomico=" + idEconomico + ", idTipoInst=" + idTipoInst + ", instDesc="
				+ instDesc + ", instDescMin=" + instDescMin + ", instIni=" + instIni + "]";
	}
	
	
}
