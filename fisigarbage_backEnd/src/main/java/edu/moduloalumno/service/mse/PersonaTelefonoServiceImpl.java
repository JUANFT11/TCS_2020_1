package edu.moduloalumno.service.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.mse.IPersonaTelefonoDao;
import edu.moduloalumno.dao.mse.ITipoTelefonoDao;
import edu.moduloalumno.entity.mse.PersonaTelefono;
import edu.moduloalumno.entity.mse.TipoTelefono;

@Service
public class PersonaTelefonoServiceImpl implements IPersonaTelefonoService{

	@Autowired
	private IPersonaTelefonoDao personaTelefonoDao;
	
	@Autowired
	private ITipoTelefonoDao tipoTelefonoDao;
	
	@Override
	public void save(PersonaTelefono personaTelefono) {
		personaTelefonoDao.save(personaTelefono);
		
	}

	@Override
	public PersonaTelefono findOne(Integer id) {
		
		return personaTelefonoDao.findOne(id);
	}

	@Override
	public void update(PersonaTelefono personaTelefono) {
		personaTelefonoDao.update(personaTelefono);
		
	}

	@Override
	public void delete(Long n_telefono) {
		personaTelefonoDao.delete(n_telefono);
		
	}

	@Override
	public List<TipoTelefono> findAll() {
		
		return tipoTelefonoDao.findAll();
	}

	@Override
	public List<PersonaTelefono> findAll(Long id) {
		
		return personaTelefonoDao.findAll(id);
	}

}
