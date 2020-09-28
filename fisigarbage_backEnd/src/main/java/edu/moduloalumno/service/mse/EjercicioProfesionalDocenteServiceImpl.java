package edu.moduloalumno.service.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.mse.IEjercicioProfesionalDocenteDao;
import edu.moduloalumno.entity.mse.Correo;
import edu.moduloalumno.entity.mse.EjercicioProfesionalDocente;
@Service
public class EjercicioProfesionalDocenteServiceImpl implements IEjercicioProfesionalDocenteService {

	@Autowired
	private IEjercicioProfesionalDocenteDao ejerprodocDao;
	@Override
	public void agregar(EjercicioProfesionalDocente ejerprodoc) {
		ejerprodocDao.agregar(ejerprodoc);
		
	}

	@Override
	public void eliminar(Correo correo) {
		ejerprodocDao.eliminar(correo);
		
	}

	@Override
	public List<EjercicioProfesionalDocente> listar(Integer id) {
		
		return ejerprodocDao.listar(id);
	}

}
