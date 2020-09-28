package edu.moduloalumno.dao.mse;

import java.util.List;

import edu.moduloalumno.entity.mse.Correo;
import edu.moduloalumno.entity.mse.PersonaCorreo;
import edu.moduloalumno.entity.mse.TipoCorreo;

public interface IPersonaCorreoDao {
	
	
	public void save(PersonaCorreo personaCorreo);
	public PersonaCorreo findOne(Integer id);	
	public void delete(Correo correo);
	public List<PersonaCorreo> findAll(Long id);
	public List<TipoCorreo> findAll();
}
