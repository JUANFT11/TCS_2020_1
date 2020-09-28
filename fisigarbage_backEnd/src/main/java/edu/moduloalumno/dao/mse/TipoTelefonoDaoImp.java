package edu.moduloalumno.dao.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.entity.mse.PersonaTelefono;
import edu.moduloalumno.entity.mse.TipoTelefono;
import edu.moduloalumno.rowmapper.mse.PersonaTelefonoRowMapper;
import edu.moduloalumno.rowmapper.mse.TipoTelefonoRowMapper;

@Transactional
@Repository
public class TipoTelefonoDaoImp implements ITipoTelefonoDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	

	@Override
	public List<TipoTelefono> findAll() {
		String sql="SELECT id_tipoTelefono ,tipotelefono_desc FROM tipo_telefono ;" ;
        System.out.println("la consulta es:"+sql);
        RowMapper<TipoTelefono> rowMapper=new TipoTelefonoRowMapper();
        List<TipoTelefono> tipoTelefono= this.jdbcTemplate.query(sql,rowMapper);
        System.out.println(tipoTelefono);
        return tipoTelefono;
	}

	

}
