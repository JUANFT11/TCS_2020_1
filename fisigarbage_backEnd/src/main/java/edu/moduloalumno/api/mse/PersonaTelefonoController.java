package edu.moduloalumno.api.mse;

import java.util.List;

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
import edu.moduloalumno.entity.mse.ConProgramaPorAlumno;
import edu.moduloalumno.entity.mse.PersonaTelefono;
import edu.moduloalumno.entity.mse.TipoTelefono;
import edu.moduloalumno.service.mse.IPersonaTelefonoService;

@RestController
@RequestMapping("/mse/telefono")
public class PersonaTelefonoController {
	@Autowired
    private IPersonaTelefonoService service;
	
	@RequestMapping(value = "/telefonos/{idAlum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<PersonaTelefono>> getTelefonosPorPersonaById(@PathVariable("idAlum") Long id){
		List<PersonaTelefono> personaTelefonos = null;
        
        System.out.println("Entro hasta personasTelefonos3333");
        System.out.println("Entro hasta personasTelefonos2");
        System.out.println("Entro hasta personasTelefonos3");
        try {
        	System.out.println("Entro al try");
        	personaTelefonos = service.findAll(id);
			System.out.println("Paso hasta aqui");

			if (personaTelefonos == null) {
				personaTelefonos = null;
            }

        } catch (Exception e) {
            return new ResponseEntity<List<PersonaTelefono>>(personaTelefonos, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Salio de personasTelefonos");
        return new ResponseEntity<List<PersonaTelefono>>(personaTelefonos, HttpStatus.OK);
    }

    @RequestMapping(value="/guardar" , method=RequestMethod.POST)
        public void guardar(@RequestBody PersonaTelefono persona, BindingResult result){
    	System.out.println("entro a guardar");
    	System.out.println(persona);
    	System.out.println("************************");
    	if(result.hasErrors()){
          System.out.println("Tieene errores");            
         }
    	service.save(persona);
    
        }
    
    @RequestMapping(value = "/tipotelefono", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoTelefono>> tipoTelefono() {
    	System.out.println("Entro a tipo de telefono");
		List<TipoTelefono> tipoTelefono = null;
		try {
			tipoTelefono = service.findAll();

			if (tipoTelefono == null) {
				tipoTelefono = null;
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<List<TipoTelefono>>(tipoTelefono, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<TipoTelefono>>(tipoTelefono, HttpStatus.OK);
	}
    
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		System.out.println("Ingreso al delete");
		
		try {
			service.delete(id);				
		} catch (Exception e) {
				
		}
	}
}
