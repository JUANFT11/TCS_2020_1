package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.TipoCorreo;

public class TipoCorreoRowMapper implements RowMapper<TipoCorreo>{

	@Override
	public TipoCorreo mapRow(ResultSet row, int rowNum) throws SQLException {
		TipoCorreo tipoCorreo=new TipoCorreo();
		tipoCorreo.setId(row.getInt("id_tipoCorreo"));
		tipoCorreo.setTipoCorreo(row.getString("tipocorreo_desc"));
		return tipoCorreo;
	}
	

}
