package edu.moduloalumno.service.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.mse.IPersonaDao;
import edu.moduloalumno.entity.mse.AperturaConcepto;
import edu.moduloalumno.entity.mse.Formacion;
import edu.moduloalumno.entity.mse.Institucion;
import edu.moduloalumno.entity.mse.Nivel;
import edu.moduloalumno.entity.mse.Persona;
import edu.moduloalumno.entity.mse.TipoInstitucion;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaDao personaDao;
	
	@Override
	public Persona findOne(String codigo) {
		return personaDao.findOne(codigo);
	}

	@Override
	public void updatePersona(Persona persona) {
		personaDao.updatePersona(persona);
		
	}

	@Override
	public AperturaConcepto findOneConcepto(Integer id) {
		return personaDao.findOneConcepto(id);
		
	}

	@Override
	public void saveFormacion(Formacion formacion) {
		personaDao.saveFormacion(formacion);
		
	}

	@Override
	public List<Formacion> findFormacion(Integer id) {
		
		return personaDao.findFormacion(id);
	}

	@Override
	public List<Nivel> findNivel() {
		
		return personaDao.findNivel();
	}

	@Override
	public void deleteFormacion(Integer formacion) {
		personaDao.deleteFormacion(formacion);
		
	}

	@Override
	public void saveInstitucion(Institucion institucion) {
		personaDao.saveInstitucion(institucion);
		
	}

	@Override
	public List<TipoInstitucion> listarTipos() {
		
		return personaDao.listarTipos();
	}

}
