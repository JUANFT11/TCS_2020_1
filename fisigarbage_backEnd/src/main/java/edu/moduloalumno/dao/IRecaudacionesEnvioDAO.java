package edu.moduloalumno.dao;

import java.util.List;
import edu.moduloalumno.entity.Alumno;
import java.io.ByteArrayInputStream;
import java.util.Date;
import edu.moduloalumno.entity.RecaudacionesEnvio;

public interface IRecaudacionesEnvioDAO {

	List<RecaudacionesEnvio> getAllRecaudacionesEnvio() ;
	
	

    List<RecaudacionesEnvio> getRecaudacionesEnvioByMesAnio(int n_mes, int n_anio);

	List<RecaudacionesEnvio> getRecaudacionesEnvioById_envio(int id_envio);

	List<RecaudacionesEnvio> getRecaudacionesEnvioByMes(int n_mes);

	List<RecaudacionesEnvio> getRecaudacionesEnvioByAnio(int n_anio);

	int updateRecaudacionesEnvio(RecaudacionesEnvio reacaudacionesEnvio);

	void updateRecaudacionesEnvio(char cod_alumno, char numero, int id_envio);

	List<RecaudacionesEnvio> getEnviobyId(int id_envio);

	List<RecaudacionesEnvio> getFechaEnvio(String numero);

	/*

	void addRecaudacionesEnvio(RecaudacionesEnvio RecaudacionesEnvio);

	void updateRecaudacionesEnvio(RecaudacionesEnvio RecaudacionesEnvio);

	void deleteRecaudacionesEnvio(int id_envio);*/
}

