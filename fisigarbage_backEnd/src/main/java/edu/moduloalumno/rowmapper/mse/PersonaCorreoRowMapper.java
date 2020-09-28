package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.PersonaCorreo;

public class PersonaCorreoRowMapper implements RowMapper<PersonaCorreo> {

	@Override
	public PersonaCorreo mapRow(ResultSet row, int rowNum) throws SQLException {
		PersonaCorreo personaCorreo=new PersonaCorreo();
		personaCorreo.setId(row.getInt("persona_id"));
		personaCorreo.setIdTipoCorreo(row.getInt("id_tipocorreo"));
		personaCorreo.setCorreo(row.getString("correo"));
		return personaCorreo;
	}

}
