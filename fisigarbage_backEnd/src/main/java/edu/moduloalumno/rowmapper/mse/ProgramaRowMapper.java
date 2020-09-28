package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.Programa;

public class ProgramaRowMapper implements RowMapper<Programa>{

	@Override
	public Programa mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Programa programa=new Programa();
		programa.setId(rs.getInt("id_programa"));
		programa.setNombre(rs.getString("nom_programa"));
		programa.setSigla(rs.getString("sigla_programa"));
		programa.setTipoGrado(rs.getString("id_tip_grado"));
		programa.setVigencia(rs.getBoolean("vigencia_programa"));
		programa.setPrioridad(rs.getInt("n_prioridad"));
		
		return programa;
	}
	

}
