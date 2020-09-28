package edu.moduloalumno.service;
import edu.moduloalumno.service.IRecaudacionesEnvioService;

import java.io.ByteArrayInputStream;

import java.util.List;


import edu.moduloalumno.entity.RecaudacionesEnvio;



public interface IRecaudacionesEnvioService {

    List<RecaudacionesEnvio> getAllRecaudacionesEnvio() ;

 

    List<RecaudacionesEnvio> getRecaudacionesEnvioByMesAnio(int n_mes, int n_anio);

    List<RecaudacionesEnvio> getRecaudacionesEnvioById_envio(int id_envio);

    List<RecaudacionesEnvio> getRecaudacionesEnvioByMes(int n_mes);

    List<RecaudacionesEnvio> getRecaudacionesEnvioByAnio(int n_anio);

    int updateRecaudacionesEnvio(RecaudacionesEnvio recaudacionesEnvio);	

    List<RecaudacionesEnvio> getEnviobyId(int id_envio);

    List<RecaudacionesEnvio> getFechaEnvio(String numero);

	
	
	int updateRecaudacionesEnvio(List<RecaudacionesEnvio> reacaudacionesEnvioList);
    
    /*

	void addRecaudacionesEnvio(RecaudacionesEnvio RecaudacionesEnvio);

	void updateRecaudacionesEnvio(RecaudacionesEnvio RecaudacionesEnvio);

    void deleteRecaudacionesEnvio(int id_envio);*/
    


   /* ByteArrayInputStream exportAllData(int n_mes,int n_anio) throws Exception;
	ByteArrayInputStream exportAllDataMasInfo(int n_mes, int n_anio) throws Exception;*/









}