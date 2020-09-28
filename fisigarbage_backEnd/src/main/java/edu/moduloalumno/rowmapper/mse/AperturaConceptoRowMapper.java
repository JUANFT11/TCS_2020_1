package edu.moduloalumno.rowmapper.mse;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.moduloalumno.entity.mse.AperturaConcepto;;

public class AperturaConceptoRowMapper implements RowMapper<AperturaConcepto> {

	@Override
	public AperturaConcepto mapRow(ResultSet row, int rowNum) throws SQLException {
		AperturaConcepto aperturaConcepto=new AperturaConcepto();
		aperturaConcepto.setEstadoConcepto(row.getString("estado"));
		return aperturaConcepto;
	}
	

}
