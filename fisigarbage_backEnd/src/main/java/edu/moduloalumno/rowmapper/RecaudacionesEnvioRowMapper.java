package edu.moduloalumno.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.RecaudacionesEnvio;

public class RecaudacionesEnvioRowMapper implements RowMapper<RecaudacionesEnvio> {
	@Override
	public RecaudacionesEnvio mapRow(ResultSet row, int rowNum) throws SQLException {
		RecaudacionesEnvio recaudacionesEnvio = new RecaudacionesEnvio();
		recaudacionesEnvio.setIdEnvio(row.getInt("id_envio"));
		recaudacionesEnvio.setNsemana(row.getInt("n_semana"));
		recaudacionesEnvio.setDesc_semana(row.getString("desc_semana"));
		recaudacionesEnvio.setNmes(row.getInt("n_mes"));
		recaudacionesEnvio.setNanio(row.getInt("n_anio"));		
		return recaudacionesEnvio;
	}
}