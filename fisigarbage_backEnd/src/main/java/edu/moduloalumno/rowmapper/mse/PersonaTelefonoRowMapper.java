package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import edu.moduloalumno.entity.mse.PersonaTelefono;;

public class PersonaTelefonoRowMapper implements RowMapper<PersonaTelefono> {

	@Override
	public PersonaTelefono mapRow(ResultSet row, int rowNum) throws SQLException {
		//Hace falta cambiar los parametros de retorno
		PersonaTelefono personaTelefono=new PersonaTelefono(); 
		personaTelefono.setIdPersona(row.getInt("persona_id"));
		personaTelefono.setIdTipoTelefono(row.getInt("id_tipotelefono"));
		personaTelefono.setNumeroTelefonico(row.getInt("n_telefono"));
        return personaTelefono;
		
	}
	
	

}
