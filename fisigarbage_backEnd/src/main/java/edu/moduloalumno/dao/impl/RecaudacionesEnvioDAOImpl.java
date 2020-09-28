package edu.moduloalumno.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;

import edu.moduloalumno.dao.IRecaudacionesEnvioDAO;
import edu.moduloalumno.entity.RecaudacionesEnvio;
import edu.moduloalumno.entity.Recaudaciones;
import edu.moduloalumno.rowmapper.RecaudacionesEnvioRowMapper;

@Transactional
@Repository
public class RecaudacionesEnvioDAOImpl implements IRecaudacionesEnvioDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*@Override
	public void addRecaudacionesEnvio(RecaudacionesEnvio reacaudacionesEnvio) { }

	@Override
	public int updateRecaudaciones(RecaudacionesEnvio reacaudacionesEnvio) {return 0;}

	@Override
	public void deleteRecaudaciones(int id_envio) { }*/
	
	@Override
	public int updateRecaudacionesEnvio(RecaudacionesEnvio reacaudacionesEnvio) {return 0;}

	@Override
	public void updateRecaudacionesEnvio( char cod_alumno, char numero, int id_envio) {
		
		String sql = "UPDATE recaudaciones SET id_envio =?  WHERE cod_alumno =? AND numero=?";
		String sql2 = "UPDATE recaudaciones SET id_envio = "+id_envio+" WHERE cod_alumno = "+cod_alumno+ "AND numero="+numero;
		System.out.println(sql2);
		int i =jdbcTemplate.update(sql, cod_alumno, numero, id_envio);
		System.out.println("Se modificaron " + i + " filas");
	}
    


	@Override
	public List<RecaudacionesEnvio> getAllRecaudacionesEnvio() {
		String sql = "SELECT id_envio, n_semana, desc_semana, n_mes, n_anio FROM recaudaciones_envios";		
		RowMapper<RecaudacionesEnvio> rowMapper = new RecaudacionesEnvioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}

	
	
	@Override
	public List<RecaudacionesEnvio> getRecaudacionesEnvioById_envio(int id_envio) {
		String sql = "SELECT id_envio, n_semana, desc_semana, n_mes, n_anio FROM recaudaciones_envios WHERE id_envio = ?";
		RowMapper<RecaudacionesEnvio> rowMapper = new RecaudacionesEnvioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, id_envio);
		
	}


	@Override
	public List<RecaudacionesEnvio> getRecaudacionesEnvioByMesAnio(int n_mes, int n_anio) {
		String sql = "SELECT * FROM recaudaciones_envios WHERE n_mes=? AND n_anio=?";
		RowMapper<RecaudacionesEnvio> rowMapper = new RecaudacionesEnvioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, n_mes, n_anio);
	}

	@Override
	public List<RecaudacionesEnvio> getRecaudacionesEnvioByMes(int n_mes) {
		String sql = "SELECT * FROM recaudaciones_envios WHERE n_mes = ?";
		RowMapper<RecaudacionesEnvio> rowMapper = new RecaudacionesEnvioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, n_mes);
	}

	@Override
	public List<RecaudacionesEnvio> getRecaudacionesEnvioByAnio(int n_anio) {
		String sql = "SELECT * FROM recaudaciones_envios WHERE n_anio = ?";
		RowMapper<RecaudacionesEnvio> rowMapper = new RecaudacionesEnvioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, n_anio);
	}

	@Override
	public List<RecaudacionesEnvio> getEnviobyId(int id_envio) {
		String sql = "select id_envio, n_semana, desc_semana, n_mes, n_anio from recaudaciones_envios where id_envio = ?";
		RowMapper<RecaudacionesEnvio> rowMapper = new RecaudacionesEnvioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, id_envio);
	
	}

	@Override
	public List<RecaudacionesEnvio> getFechaEnvio(String numero) {
		String sql = "select  re.id_envio, re.n_semana, re.desc_semana, re.n_mes, re.n_anio from recaudaciones_envios re join recaudaciones r on re.id_envio=r.id_envio where r.numero= ?";
		RowMapper<RecaudacionesEnvio> rowMapper = new RecaudacionesEnvioRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper, numero);
	
	}



	
    
}