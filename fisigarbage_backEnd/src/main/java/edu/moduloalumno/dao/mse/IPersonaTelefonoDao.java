package edu.moduloalumno.dao.mse;

import java.util.List;

import edu.moduloalumno.entity.mse.PersonaTelefono;

public interface IPersonaTelefonoDao {
	public void save(PersonaTelefono personaTelefono);
	public PersonaTelefono findOne(Integer id);
	
	public void update(PersonaTelefono personaTelefono);
	public void delete(Long n_telefono);
	public List<PersonaTelefono> findAll(Long id);
	
}
