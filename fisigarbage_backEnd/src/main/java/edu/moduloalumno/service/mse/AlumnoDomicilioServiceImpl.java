package edu.moduloalumno.service.mse;

import java.util.List;
import edu.moduloalumno.dao.mse.IAlumnoDomicilioDao;
import edu.moduloalumno.entity.mse.AlumnoDomicilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoDomicilioServiceImpl implements IAlumnoDomicilioService {
    @Autowired
    private IAlumnoDomicilioDao alumnoDAO;

    @Override
    public void save(AlumnoDomicilio alumnoDomicilio) {
        alumnoDAO.save(alumnoDomicilio);

    }

    @Override
    public AlumnoDomicilio findOne(Integer id) {
        return alumnoDAO.findOne(id);
        
    }

    @Override
    public void update(AlumnoDomicilio alumnoDomicilio) {
        alumnoDAO.update(alumnoDomicilio);

    }
}