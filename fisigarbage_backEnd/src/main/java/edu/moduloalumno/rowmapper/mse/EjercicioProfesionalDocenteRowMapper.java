package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.EjercicioProfesionalDocente;

public class EjercicioProfesionalDocenteRowMapper implements RowMapper<EjercicioProfesionalDocente>{

	@Override
	public EjercicioProfesionalDocente mapRow(ResultSet rs, int rowNum) throws SQLException {
		EjercicioProfesionalDocente ejerprodoc=new EjercicioProfesionalDocente();
		ejerprodoc.setEntidad(rs.getInt("entidad"));
		ejerprodoc.setTipoEntidad(rs.getString("tipo_entidad"));
		ejerprodoc.setCargo(rs.getString("cargo"));
		ejerprodoc.setPrincFunc(rs.getString("princ_func"));
		ejerprodoc.setTipoVincLab(rs.getString("tipo_vinc_lab"));
		ejerprodoc.setFechInic(rs.getDate("fecha_inicio"));
		ejerprodoc.setFechaFin(rs.getDate("fecha_fin"));
		ejerprodoc.setNomJefInmSup(rs.getString("nom_jef_inm_sup"));
		ejerprodoc.setCorrJefInmSup(rs.getString("correo_jef_inm_sup"));
		
		return ejerprodoc;
	}

}
