package edu.moduloalumno.service.mse;

import java.util.List;

import edu.moduloalumno.entity.mse.Correo;
import edu.moduloalumno.entity.mse.EjercicioProfesionalDocente;

public interface IEjercicioProfesionalDocenteService {
	public void agregar(EjercicioProfesionalDocente ejerprodoc);
	public void eliminar(Correo correo);
	public List<EjercicioProfesionalDocente> listar(Integer id);
}
