package edu.moduloalumno.dao.mse;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import edu.moduloalumno.entity.mse.PersonaTelefono;
import edu.moduloalumno.rowmapper.mse.PersonaTelefonoRowMapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Transactional
@Repository
public class PersonaTelefonoDaoImpl implements IPersonaTelefonoDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(PersonaTelefono personaTelefono) {
		 String sql = "INSERT into PERSONA_TELEFONO(persona_id,id_tipotelefono,n_telefono) VALUES(?,?,?)";
	        System.out.println("La consulta es: "+sql);
	        try {
	            jdbcTemplate.update(sql,personaTelefono.getIdPersona(),personaTelefono.getIdTipoTelefono(),personaTelefono.getNumeroTelefonico());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
					
		
	}

	@Override
	public PersonaTelefono findOne(Integer id) {
		String sql="SELECT persona_id,id_tipotelefono,n_telefono FROM  PERSONA_TELEFONO WHERE n_telefono = "+id+";" ;
        System.out.println("la consulta es:"+sql);
        RowMapper<PersonaTelefono> rowMapper=new PersonaTelefonoRowMapper();
        PersonaTelefono personaTelefono= jdbcTemplate.query(sql,rowMapper).get(0);
        System.out.println(personaTelefono);
        return personaTelefono;
	}

	@Override
	public void update(PersonaTelefono personaTelefono) {
		String sql= "UPDATE persona_telefono SET"
                + " persona_id = ?" 
                + ", id_tipotelefono = ?" 
                +" WHERE n_telefono = "+personaTelefono.getNumeroTelefonico()+";";
               
        jdbcTemplate.update(sql,personaTelefono.getIdPersona(),personaTelefono.getIdTipoTelefono());
		
	}

	@Override
	public void delete(Long n_telefono) {
		String sql="DELETE FROM PERSONA_TELEFONO WHERE N_TELEFONO=?";
		
		jdbcTemplate.update(sql,n_telefono);
		
	}

	@Override
	public List<PersonaTelefono> findAll(Long id) {
		String sql="SELECT persona_id,id_tipotelefono,n_telefono FROM PERSONA_TELEFONO WHERE persona_id="+id+";" ;
		System.out.println(sql);
		RowMapper<PersonaTelefono> rowMapper=new PersonaTelefonoRowMapper();
		List<PersonaTelefono> personaTelefono=jdbcTemplate.query(sql, rowMapper);
		System.out.println(personaTelefono);
		
		return personaTelefono;
		
	}

}
