package edu.moduloalumno.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import edu.moduloalumno.dao.IRecaudacionesEnvioDAO;
import edu.moduloalumno.entity.RecaudacionesEnvio;
import edu.moduloalumno.service.IRecaudacionesEnvioService;

@Service
public class RecaudacionesEnvioServiceImpl implements IRecaudacionesEnvioService{
    @Autowired
    private IRecaudacionesEnvioDAO recaudacionesEnvioDAO;
    
    @Override
	public List<RecaudacionesEnvio> getAllRecaudacionesEnvio() {
		return recaudacionesEnvioDAO.getAllRecaudacionesEnvio();
	}

	

	@Override
	public List<RecaudacionesEnvio> getRecaudacionesEnvioById_envio(int id_envio) {

		List<RecaudacionesEnvio>  recaudacionesEnvio = recaudacionesEnvioDAO.getRecaudacionesEnvioById_envio(id_envio);
		
		return recaudacionesEnvio;
    }

    @Override
	public List<RecaudacionesEnvio> getRecaudacionesEnvioByMes(int n_mes) {

		List<RecaudacionesEnvio>  recaudacionesEnvio = recaudacionesEnvioDAO.getRecaudacionesEnvioByMes(n_mes);
		
		return recaudacionesEnvio;
    }

    @Override
	public List<RecaudacionesEnvio> getRecaudacionesEnvioByAnio(int n_anio) {

		List<RecaudacionesEnvio>  recaudacionesEnvio = recaudacionesEnvioDAO.getRecaudacionesEnvioByAnio(n_anio);
		
		return recaudacionesEnvio;
    }


    @Override
	public List<RecaudacionesEnvio> getRecaudacionesEnvioByMesAnio(int n_mes, int n_anio) {

		List<RecaudacionesEnvio>  recaudacionesEnvio = recaudacionesEnvioDAO.getRecaudacionesEnvioByMesAnio(n_mes, n_anio);
		
		return recaudacionesEnvio;
	}
	
	@Override
	public int updateRecaudacionesEnvio(RecaudacionesEnvio recaudacionesEnvio) {
		return recaudacionesEnvioDAO.updateRecaudacionesEnvio(recaudacionesEnvio);
	}

	@Override
	public int updateRecaudacionesEnvio(List<RecaudacionesEnvio> reacaudacionesEnvioList) {
		int update = 0;
		for (RecaudacionesEnvio recaudacionesEnvio : reacaudacionesEnvioList) {
			update+=recaudacionesEnvioDAO.updateRecaudacionesEnvio(recaudacionesEnvio);
		}
		return update;
	}

	@Override
	public List<RecaudacionesEnvio> getEnviobyId(int id_envio) {
		List<RecaudacionesEnvio> recaudacionesEnvio = recaudacionesEnvioDAO.getEnviobyId(id_envio);
		return recaudacionesEnvio;
	}

	@Override
	public List<RecaudacionesEnvio> getFechaEnvio(String numero) {
		List<RecaudacionesEnvio> recaudacionesEnvio = recaudacionesEnvioDAO.getFechaEnvio(numero);
		return recaudacionesEnvio;
	}

	
    

    
    
    
}
