package edu.moduloalumno.entity.mse;

import java.io.Serializable;


public class AlumnoDomicilio implements Serializable{


    private static final long serialVersionUID = 3332162947038691155L;

    private Integer id;
    private String domicilio;
    private String ubigeo;
    
    public AlumnoDomicilio (Integer id,String domicilio,String ubigeo){
        this.id=id;
        this.domicilio=domicilio;
        this.ubigeo=ubigeo;
    }
    public AlumnoDomicilio(){

    }

    public void setId(Integer id){
        this.id=id;
    }
    public Integer getId(){
        return this.id;
    }

    public void setDomicilio(String domicilio){
        this.domicilio=domicilio;
    }
    public String getDomicilio(){
        return this.domicilio;
    }
    public void setUbigeo(String ubigeo){
        this.ubigeo=ubigeo;
    }
    public String getUbigeo(){
        return this.ubigeo;
    }
   

}