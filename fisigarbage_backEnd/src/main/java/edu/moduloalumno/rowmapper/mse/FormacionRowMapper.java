package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.Formacion;
import edu.moduloalumno.entity.mse.PersonaCorreo;

public class FormacionRowMapper implements RowMapper<Formacion>{

	@Override
	public Formacion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Formacion formacion=new Formacion();
		formacion.setFormacion_id(rs.getInt("formacion_id"));
		formacion.setModalidad(rs.getInt("modalidad_id"));
		formacion.setPersona_id(rs.getInt("persona_id"));
		formacion.setId_programa(rs.getInt("id_programa"));
		formacion.setNivel_id(rs.getInt("nivel_id"));
		formacion.setCodigoPersona(rs.getString("formacion_calumno"));
		formacion.setInstitucion_desc(rs.getString("institucion_desc"));
		formacion.setNombrePrograma(rs.getString("nom_programa"));
		formacion.setSiglaPrograma(rs.getString("sigla_programa"));
		formacion.setFormacion_fingreso(rs.getDate("formacion_fingreso"));
		formacion.setFormacion_fegreso(rs.getDate("formacion_fegreso"));
		
		return formacion;
	}

}
