package edu.moduloalumno.rowmapper.mse;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.TipoInstitucion;

public class TipoInstitucionRowMapper implements RowMapper<TipoInstitucion>{

	@Override
	public TipoInstitucion mapRow(ResultSet rs, int rowNum) throws SQLException {
		TipoInstitucion inst=new TipoInstitucion();
		inst.setId(rs.getInt("tipo_inst_id"));
		inst.setDescripcion(rs.getString("tipo_inst_desc"));
		inst.setIniciales(rs.getString("tipo_inst_ini"));
		return inst;
	}

}
