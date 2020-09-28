package edu.moduloalumno.dao.mse;

import org.springframework.jdbc.core.RowMapper;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.entity.mse.AlumnoDomicilio;
import edu.moduloalumno.rowmapper.mse.AlumnoDomicilioRowMapper;

@Transactional
@Repository
public class AlumnoDomicilioDaoImpl implements IAlumnoDomicilioDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
   

    @Override
    public void save(AlumnoDomicilio personaDomicilio) {
        String sql = "INSERT into persona_domicilio(persona_id,persona_direccion,persona_ubigeo) VALUES(?,?,?)";
        System.out.println("La consulta es: "+sql);
        try {
            jdbcTemplate.update(sql,personaDomicilio.getId(),personaDomicilio.getDomicilio(),personaDomicilio.getUbigeo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    

    @Override
    public AlumnoDomicilio findOne(Integer id) {
        String sql="SELECT persona_id , persona_direccion , persona_ubigeo FROM  persona_domicilio WHERE persona_id = "+id+";" ;
        System.out.println("la consulta es:"+sql);
        RowMapper<AlumnoDomicilio> rowMapper=new AlumnoDomicilioRowMapper();
        AlumnoDomicilio personaDomicilio= jdbcTemplate.query(sql,rowMapper).get(0);
        System.out.println(personaDomicilio);
        return personaDomicilio;
        
       
    }
    
    @Override
    public void update(AlumnoDomicilio personaDomicilio) {
        String sql= "UPDATE persona_domicilio SET"
                + " persona_direccion = ?" 
                + ", persona_ubigeo = ?" 
                +" WHERE persona_id = "+personaDomicilio.getId()+";";
               
        jdbcTemplate.update(sql,personaDomicilio.getDomicilio(),personaDomicilio.getUbigeo());
        
                    
    }
    
}