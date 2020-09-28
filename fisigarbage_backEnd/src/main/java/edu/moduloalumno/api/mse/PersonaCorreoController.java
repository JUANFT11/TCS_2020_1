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

import edu.moduloalumno.entity.mse.Correo;
import edu.moduloalumno.entity.mse.PersonaCorreo;
import edu.moduloalumno.entity.mse.PersonaTelefono;
import edu.moduloalumno.entity.mse.TipoCorreo;
import edu.moduloalumno.entity.mse.TipoTelefono;
import edu.moduloalumno.service.mse.IPersonaCorreoService;
import edu.moduloalumno.service.mse.IPersonaTelefonoService;

@RestController
@RequestMapping("/mse/correo")
public class PersonaCorreoController {
	@Autowired
    private IPersonaCorreoService service;
	
	@RequestMapping(value = "/correos/{idAlum}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<PersonaCorreo>> getTelefonosPorPersonaById(@PathVariable("idAlum") Long id){
		List<PersonaCorreo> personaCorreo = null;
        
        System.out.println("Entro hasta correoss3333");
        
        try {
        	System.out.println("Entro al try");
        	personaCorreo = service.findAll(id);
			System.out.println("Paso hasta aqui");

			if (personaCorreo == null) {
				personaCorreo = null;
            }

        } catch (Exception e) {
            return new ResponseEntity<List<PersonaCorreo>>(personaCorreo, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Salio de personasTelefonos");
        return new ResponseEntity<List<PersonaCorreo>>(personaCorreo, HttpStatus.OK);
    }
	
	 @RequestMapping(value="/guardar" , method=RequestMethod.POST)
     public void guardar(@RequestBody PersonaCorreo persona, BindingResult result){
 	System.out.println("entro a guardar");
 	System.out.println(persona);
 	System.out.println("************************");
 	if(result.hasErrors()){
       System.out.println("Tieene errores");            
      }
 	service.save(persona);
 
     }
 
 @RequestMapping(value = "/tipoCorreo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoCorreo>> tipoCorreo() {
 	System.out.println("Entro a tipo de telefono");
		List<TipoCorreo> tipoCorreo = null;
		try {
			tipoCorreo = service.findAll();

			if (tipoCorreo == null) {
				tipoCorreo = null;
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<List<TipoCorreo>>(tipoCorreo, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<TipoCorreo>>(tipoCorreo, HttpStatus.OK);
	}
 
 @RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
	public void delete(@RequestBody Correo correo) {
	 
		System.out.println("Ingreso al deleteeeee");
		System.out.println(correo);
		try {
			service.delete(correo);		
		System.out.println("paso por el deleteee");
		} catch (Exception e) {
		System.out.println(e);		
		}
	}
}
