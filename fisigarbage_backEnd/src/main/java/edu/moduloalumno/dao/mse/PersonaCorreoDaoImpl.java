package edu.moduloalumno.dao.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.entity.mse.Correo;
import edu.moduloalumno.entity.mse.PersonaCorreo;
import edu.moduloalumno.entity.mse.PersonaTelefono;
import edu.moduloalumno.entity.mse.TipoCorreo;
import edu.moduloalumno.entity.mse.TipoTelefono;
import edu.moduloalumno.rowmapper.mse.PersonaCorreoRowMapper;
import edu.moduloalumno.rowmapper.mse.PersonaTelefonoRowMapper;
import edu.moduloalumno.rowmapper.mse.TipoCorreoRowMapper;
import edu.moduloalumno.rowmapper.mse.TipoTelefonoRowMapper;

@Transactional
@Repository
public class PersonaCorreoDaoImpl implements IPersonaCorreoDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public void save(PersonaCorreo personaCorreo) {
		 String sql = "INSERT into PERSONA_CORREO(persona_id,id_tipocorreo,correo) VALUES(?,?,?)";
        System.out.println("La consulta es: "+sql);
        try {
            jdbcTemplate.update(sql,personaCorreo.getId(),personaCorreo.getIdTipoCorreo(),personaCorreo.getCorreo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
	}

	@Override
	public PersonaCorreo findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Correo correoEliminar) {
	String sql="DELETE FROM PERSONA_CORREO WHERE correo= ?";
	System.out.println(sql);
	jdbcTemplate.update(sql,correoEliminar.getCorreo());
		
	}

	@Override
	public List<PersonaCorreo> findAll(Long id) {
		String sql="SELECT persona_id,id_tipocorreo,correo FROM PERSONA_CORREO WHERE persona_id="+id+";" ;
		System.out.println(sql);
		RowMapper<PersonaCorreo> rowMapper=new PersonaCorreoRowMapper();
		List<PersonaCorreo> personaCorreo=jdbcTemplate.query(sql, rowMapper);
		System.out.println(personaCorreo);
		
		return personaCorreo;
	}

	@Override
	public List<TipoCorreo> findAll() {
		String sql="SELECT id_tipocorreo ,tipocorreo_desc FROM tipo_correo ;" ;
        System.out.println("la consulta es:"+sql);
        RowMapper<TipoCorreo> rowMapper=new TipoCorreoRowMapper();
        List<TipoCorreo> tipoCorreo= jdbcTemplate.query(sql,rowMapper);
        System.out.println(tipoCorreo);
        return tipoCorreo;
	}

}
