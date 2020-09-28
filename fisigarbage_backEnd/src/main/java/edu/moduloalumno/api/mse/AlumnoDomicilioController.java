package edu.moduloalumno.api.mse;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.mse.AlumnoDomicilio;
import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.service.mse.IAlumnoDomicilioService;

@RestController
@RequestMapping("/mse/domicilio")
public class AlumnoDomicilioController {
	
    @Autowired
    private IAlumnoDomicilioService service;
    

    @RequestMapping(value = "/buscar/{idAlum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<AlumnoDomicilio> getAlumnoById(@PathVariable("idAlum") Integer codAlumn){
        AlumnoDomicilio personaDom = null;
        System.out.println("Entro a buscar a el alumno con el codigo aea: "+codAlumn );
        System.out.println("Paso hasta aqui");
        try {
			personaDom = service.findOne(codAlumn);
			System.out.println("Paso hasta aqui");

			if (personaDom == null) {
                personaDom = new AlumnoDomicilio();
            }

        } catch (Exception e) {
            return new ResponseEntity<AlumnoDomicilio>(personaDom, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<AlumnoDomicilio>(personaDom, HttpStatus.OK);
    }

    @RequestMapping(value="/guardar" , method=RequestMethod.POST)
        public String guardar(@RequestBody AlumnoDomicilio aluDom, BindingResult result){
    	System.out.println("entro a guardar");
    	System.out.println(aluDom);
    	if(result.hasErrors()){
          System.out.println("Tieene errores");            
         }
    	service.save(aluDom);
    	return null;
        }
    
    @RequestMapping(value = "/editar", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AlumnoDomicilio> update(@RequestBody AlumnoDomicilio alumnoDomicilio) {
		System.out.println("Ingreso update");
		System.out.println(alumnoDomicilio);
		try {
			service.update(alumnoDomicilio);				
		} catch (Exception e) {
			
			return new ResponseEntity<AlumnoDomicilio>(alumnoDomicilio, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<AlumnoDomicilio>(alumnoDomicilio, HttpStatus.OK);
	}
    


}

