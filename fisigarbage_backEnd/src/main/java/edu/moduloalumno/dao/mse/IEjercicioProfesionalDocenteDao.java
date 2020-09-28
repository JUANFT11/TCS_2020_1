package edu.moduloalumno.dao.mse;

import java.util.List;

import edu.moduloalumno.entity.mse.Correo;
import edu.moduloalumno.entity.mse.EjercicioProfesionalDocente;

public interface IEjercicioProfesionalDocenteDao {
	public void agregar(EjercicioProfesionalDocente ejerprodoc);
	public void eliminar(Correo correo);
	public List<EjercicioProfesionalDocente> listar(Integer id);
}
