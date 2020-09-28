package edu.moduloalumno.model;

import java.io.Serializable;




public class RecaudacionesEnviosJSON implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id_envio;
    private Integer n_semana;
    private String desc_semana;
    private Integer n_mes;
    private Integer n_anio;


    public RecaudacionesEnviosJSON() {

    }

    public RecaudacionesEnviosJSON(Integer id_envio) {
        this.id_envio=id_envio;

    }

    public RecaudacionesEnviosJSON(Integer id_envio, Integer n_mes, Integer n_anio) {
        this.id_envio=id_envio;
        this.n_anio=n_anio;
        this.n_mes= n_mes;

    }

    public Integer getIdEnvio() {
        return id_envio;
    }

    public void setIdEnvio(Integer id_envio) {
        this.id_envio = id_envio;
    }

    public Integer getNsemana() {
        return n_semana;
    }

    public void setNsemana(Integer  n_semana) {
        this.n_semana = n_semana;
    }

    public String getDesc_semana() {
        return desc_semana;
    }

    public void setDesc_semana(String desc_semana) {
        this.desc_semana = desc_semana;
    }

    public Integer getNmes() {
        return n_mes;
    }

    public void setNmes(Integer n_mes) {
        this.n_mes = n_mes;
    }

    public Integer getNanio() {
        return n_anio;
    }

    public void setNanio(Integer n_anio) {
        this.n_anio = n_anio;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_envio == null) ? 0 : id_envio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecaudacionesEnviosJSON other = (RecaudacionesEnviosJSON) obj;
		if (id_envio == null) {
			if (other.id_envio != null)
				return false;
		} else if (!id_envio.equals(other.id_envio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Envio [id_envio=" + id_envio + ", n_semana=" + n_semana + ", desc_semana=" + desc_semana + ", n_mes=" + n_mes
				+ ", n_anio=" + n_anio + "]";
	}


}