package edu.moduloalumno.service.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.mse.IPersonaCorreoDao;
import edu.moduloalumno.dao.mse.IPersonaDao;
import edu.moduloalumno.entity.mse.Correo;
import edu.moduloalumno.entity.mse.PersonaCorreo;
import edu.moduloalumno.entity.mse.TipoCorreo;

@Service
public class PersonaCorreoServiceImpl implements IPersonaCorreoService {

	@Autowired
	private IPersonaCorreoDao personaCorreoDao;
	
	@Override
	public void save(PersonaCorreo personaCorreo) {
		personaCorreoDao.save(personaCorreo);
		
	}

	@Override
	public PersonaCorreo findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Correo correo) {
		personaCorreoDao.delete(correo);
		
	}

	@Override
	public List<PersonaCorreo> findAll(Long id) {
		
		return personaCorreoDao.findAll(id);
	}

	@Override
	public List<TipoCorreo> findAll() {
		
		return personaCorreoDao.findAll();
	}

}
