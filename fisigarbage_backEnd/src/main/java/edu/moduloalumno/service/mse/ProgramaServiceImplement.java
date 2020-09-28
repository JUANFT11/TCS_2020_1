package edu.moduloalumno.service.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.moduloalumno.dao.mse.IProgramaDao;
import edu.moduloalumno.entity.mse.Facultad;
import edu.moduloalumno.entity.mse.Programa;
import edu.moduloalumno.entity.mse.TipoGrado;

@Service
public class ProgramaServiceImplement implements IProgramaService{
	@Autowired
	private IProgramaDao programaDao;
	
	@Override
	public void agregarPrograma(Programa programa) {
		programaDao.agregarPrograma(programa);
		
	}

	@Override
	public List<Programa> listarProgramas() {
		
		return programaDao.listarProgramas();
	}

	@Override
	public void agregarFacultad(Facultad facultad) {
		programaDao.agregarFacultad(facultad);
		
	}

	@Override
	public List<TipoGrado> listarTipoGrado() {
		
		return programaDao.listarTipoGrado();
	}

}
