package edu.moduloalumno.entity.mse;

public class TipoTelefono {

	private Integer idTipoTelefono;
	private String tipoTelefono;
	
	public TipoTelefono() {
		
	}
	
	public TipoTelefono(Integer idTipoTelefono, String tipoTelefono) {
		super();
		this.idTipoTelefono = idTipoTelefono;
		this.tipoTelefono = tipoTelefono;
	}

	public Integer getIdTipoTelefono() {
		return idTipoTelefono;
	}

	public void setIdTipoTelefono(Integer idTipoTelefono) {
		this.idTipoTelefono = idTipoTelefono;
	}

	public String getTipoTelefono() {
		return tipoTelefono;
	}

	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	@Override
	public String toString() {
		return "TipoTelefono [idTipoTelefono=" + idTipoTelefono + ", tipoTelefono=" + tipoTelefono + "]";
	}
	
	
}
