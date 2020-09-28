package edu.moduloalumno.rowmapper.mse;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import edu.moduloalumno.entity.mse.Nivel;


public class NivelRowMapper implements RowMapper<Nivel>{

	@Override
	public Nivel mapRow(ResultSet rs, int rowNum) throws SQLException {
		Nivel nivel=new Nivel();
		nivel.setNivel_id(rs.getInt("nivel_id"));
		nivel.setNivel_desc(rs.getString("nivel_desc"));
		nivel.setNivel_ini(rs.getString("nivel_ini"));
		
		return nivel;
	}
	

}
