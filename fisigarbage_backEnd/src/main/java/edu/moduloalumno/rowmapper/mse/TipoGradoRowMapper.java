package edu.moduloalumno.rowmapper.mse;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.TipoGrado;


public class TipoGradoRowMapper implements RowMapper<TipoGrado>{

	@Override
	public TipoGrado mapRow(ResultSet rs, int rowNum) throws SQLException {
		TipoGrado tipo=new TipoGrado();
		tipo.setId(rs.getString("id_tip_grado"));
		tipo.setNombre(rs.getString("nom_tip_grado"));
		return tipo;
	}

}
