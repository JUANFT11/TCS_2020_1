package edu.moduloalumno.service.mse;

import java.util.List;

import edu.moduloalumno.entity.mse.PersonaTelefono;
import edu.moduloalumno.entity.mse.TipoTelefono;

public interface IPersonaTelefonoService {

	public void save(PersonaTelefono personaTelefono);
	public PersonaTelefono findOne(Integer id);
	public void update(PersonaTelefono personaTelefono);
	public void delete(Long n_telefono);
	public List<TipoTelefono> findAll();
	public List<PersonaTelefono> findAll(Long id);
}
