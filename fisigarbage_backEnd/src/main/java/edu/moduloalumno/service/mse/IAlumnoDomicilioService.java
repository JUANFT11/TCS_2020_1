package edu.moduloalumno.service.mse;


import java.util.List;

import edu.moduloalumno.entity.mse.AlumnoDomicilio;

public interface IAlumnoDomicilioService {
     void save(AlumnoDomicilio alumnoDomicilio);
	 AlumnoDomicilio findOne(Integer id);
	
	 void update(AlumnoDomicilio alumnoDomicilio);
}