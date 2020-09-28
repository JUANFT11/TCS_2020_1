package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.TipoTelefono;;

public class TipoTelefonoRowMapper implements RowMapper<TipoTelefono> {

	@Override
	public TipoTelefono mapRow(ResultSet row, int rowNum) throws SQLException {
		
		TipoTelefono tipoTelefono=new TipoTelefono(); 
		tipoTelefono.setIdTipoTelefono(row.getInt("id_tipoTelefono"));
		tipoTelefono.setTipoTelefono(row.getString("tipotelefono_desc"));
		
        return tipoTelefono;
		
	}
	
}