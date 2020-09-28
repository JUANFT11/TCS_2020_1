package edu.moduloalumno.rowmapper.mse;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.AlumnoDomicilio;;

public class AlumnoDomicilioRowMapper implements RowMapper<AlumnoDomicilio>{

    @Override
    public AlumnoDomicilio mapRow(ResultSet row, int rowNum) throws SQLException {
        AlumnoDomicilio alumnoDomicilio=new AlumnoDomicilio();
        alumnoDomicilio.setId(row.getInt("persona_id"));
        alumnoDomicilio.setDomicilio(row.getString("persona_direccion"));
        alumnoDomicilio.setUbigeo(row.getString("persona_ubigeo"));
        return alumnoDomicilio;
    }
    
}