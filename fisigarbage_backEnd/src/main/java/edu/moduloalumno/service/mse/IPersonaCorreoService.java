package edu.moduloalumno.service.mse;

import java.util.List;

import edu.moduloalumno.entity.mse.Correo;
import edu.moduloalumno.entity.mse.PersonaCorreo;
import edu.moduloalumno.entity.mse.TipoCorreo;

public interface IPersonaCorreoService {
	public void save(PersonaCorreo personaTelefono);
	public PersonaCorreo findOne(Integer id);	
	public void delete(Correo correo);
	public List<PersonaCorreo> findAll(Long id);
	public List<TipoCorreo> findAll();
}
