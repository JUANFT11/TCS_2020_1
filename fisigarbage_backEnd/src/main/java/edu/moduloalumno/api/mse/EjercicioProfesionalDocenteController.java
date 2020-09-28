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
import edu.moduloalumno.entity.mse.EjercicioProfesionalDocente;
import edu.moduloalumno.entity.mse.PersonaTelefono;
import edu.moduloalumno.service.mse.IEjercicioProfesionalDocenteService;

@RestController
@RequestMapping("/mse/ejerprodoc")
public class EjercicioProfesionalDocenteController {
	
	@Autowired
    private IEjercicioProfesionalDocenteService service;
	
	@RequestMapping(value = "/datosEjerprodoc/{codigoEntidad}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<EjercicioProfesionalDocente>> getListEjericioProfesionalDocente(@PathVariable("codigoEntidad") Integer codigo){
		List<EjercicioProfesionalDocente> ejerprodoc = null;
        
        System.out.println("Entro hasta datosEjerprodoc");
        
        try {
        	System.out.println("Entro al try");
        	ejerprodoc = service.listar(codigo);
			System.out.println("Paso hasta aqui");

			if (ejerprodoc == null) {
				ejerprodoc = null;
            }

        } catch (Exception e) {
            return new ResponseEntity<List<EjercicioProfesionalDocente>>(ejerprodoc, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Salio de personasTelefonos");
        return new ResponseEntity<List<EjercicioProfesionalDocente>>(ejerprodoc, HttpStatus.OK);
    }
	
	@RequestMapping(value="/guardar" , method=RequestMethod.POST)
    public void guardar(@RequestBody EjercicioProfesionalDocente ejerprodoc, BindingResult result){
	System.out.println("entro a guardar ejerprodoc");
	System.out.println(ejerprodoc);
	System.out.println("************************");
	if(result.hasErrors()){
      System.out.println("Tieene errores");            
     }
	service.agregar(ejerprodoc);

    }
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.DELETE)
	public void delete(@RequestBody Correo correo) {
		System.out.println("Ingreso al delete");
		System.out.println(correo);
		
		try {
			service.eliminar(correo);				
		} catch (Exception e) {
				
		}
	}
}
