package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.Persona;

public class PersonaRowMapper implements RowMapper<Persona> {

	@Override
	public Persona mapRow(ResultSet row, int rowNum) throws SQLException {
		Persona persona=new Persona();
		persona.setId(row.getInt("persona_id"));
		persona.setDni(row.getString("persona_dni"));
		persona.setApellidoPaterno(row.getString("persona_apaterno"));
		persona.setApellidoMaterno(row.getString("persona_amaterno"));
		persona.setNombres(row.getString("persona_nombres"));
		persona.setFechaNac(row.getDate("persona_fnacimiento"));
		persona.setEdad(row.getInt("persona_edad"));
		persona.setUbigeo(row.getString("persona_ubigeo_nac"));
		persona.setNumHijos(row.getInt("persona_nhijos"));
		persona.setEstadoCivil(row.getInt("ecivil_id"));
		persona.setUltimo(row.getString("persona_ultimo"));
		persona.setEstado_id(row.getInt("estado_id"));
		return persona;
	}
	
	
}
