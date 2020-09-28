package edu.moduloalumno.dao.mse;

import java.util.List;

import edu.moduloalumno.entity.mse.Facultad;
import edu.moduloalumno.entity.mse.Programa;
import edu.moduloalumno.entity.mse.TipoGrado;

public interface IProgramaDao {
	void agregarPrograma(Programa programa);
	List<Programa> listarProgramas();
	void agregarFacultad(Facultad facultad);
	List<TipoGrado> listarTipoGrado();
	

}
