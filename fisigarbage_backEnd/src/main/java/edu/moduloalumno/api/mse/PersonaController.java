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

import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.entity.mse.AperturaConcepto;
import edu.moduloalumno.entity.mse.Correo;
import edu.moduloalumno.entity.mse.Formacion;
import edu.moduloalumno.entity.mse.Institucion;
import edu.moduloalumno.entity.mse.Nivel;
import edu.moduloalumno.entity.mse.Persona;
import edu.moduloalumno.entity.mse.PersonaTelefono;
import edu.moduloalumno.entity.mse.TipoInstitucion;
import edu.moduloalumno.entity.mse.TipoTelefono;
import edu.moduloalumno.service.mse.IAlumnoService;
import edu.moduloalumno.service.mse.IPersonaService;

@RestController
@RequestMapping("/mse/persona")
public class PersonaController {
	
	@Autowired
	private IPersonaService service;
	
	@RequestMapping(value = "/buscar/{idPersona}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> getAlumnoById(@PathVariable("idPersona") String codAlumn) {
		System.out.println("ENTRO A Persona + codigo= " + codAlumn);
		Persona persona = null;
		try {
			persona = service.findOne(codAlumn);
			System.out.println(persona);
			System.out.println("paso persona");
			if (persona == null) {
				persona = null;
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona) {
		System.out.println("ingreso a update persona");
		System.out.println(persona);
		try {
			service.updatePersona(persona);
		}
		catch(Exception e) {
			return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/aperturaConcepto/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AperturaConcepto> getAperturaConcepto(@PathVariable("id") Integer identificador) {
		System.out.println("ENTRO A Persona + el identificador es =  " + identificador);
		AperturaConcepto aperturaConcepto = null;
		try {
			aperturaConcepto = service.findOneConcepto(identificador);
			System.out.println(aperturaConcepto);
			
			if (aperturaConcepto == null) {
				aperturaConcepto = null;
			}
			
		} catch (Exception e) {
			
			return new ResponseEntity<AperturaConcepto>(aperturaConcepto, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<AperturaConcepto>(aperturaConcepto, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/guardarFormacion" , method=RequestMethod.POST)
    public void guardar(@RequestBody Formacion formacion, BindingResult result){
	System.out.println("entro a guardar");
	System.out.println(formacion);
	System.out.println("************************");
	if(result.hasErrors()){
      System.out.println("Tieene errores");            
     }
	service.saveFormacion(formacion);

    }
	
	 @RequestMapping(value = "/listaFormacion/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Formacion>> tipoTelefono(@PathVariable("id") Integer identificador) {
	    	System.out.println("Entro a Formacion");
			List<Formacion> listaFormacion = null;
			try {
				listaFormacion = service.findFormacion(identificador);

				if (listaFormacion == null) {
					listaFormacion = null;
				}
				
			} catch (Exception e) {
				
				return new ResponseEntity<List<Formacion>>(listaFormacion, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<List<Formacion>>(listaFormacion, HttpStatus.OK);
		}
	 
	 
	 @RequestMapping(value = "/listaNivel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Nivel>> listaNivel() {
	    	System.out.println("Entro a tipo de telefono");
			List<Nivel> nivel = null;
			try {
				nivel = service.findNivel();

				if (nivel == null) {
					nivel = null;
				}
				
			} catch (Exception e) {
				
				return new ResponseEntity<List<Nivel>>(nivel, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<List<Nivel>>(nivel, HttpStatus.OK);
		}
	 
	 @RequestMapping(value = "/eliminarFormacion/{id}", method = RequestMethod.DELETE)
		public void delete(@PathVariable("id") Integer formacion) {
		 
			System.out.println("Ingreso al deleteeeeeFormacion");
			System.out.println(formacion);
			try {
				service.deleteFormacion(formacion);		
			System.out.println("paso por el deleteee");
			} catch (Exception e) {
			System.out.println(e);		
			}
		}
	 	
	 
	 // Guardar informacion
	 
	 @RequestMapping(value = "/guardarInstitucion", method = RequestMethod.POST)
		public void guardarInstitucion(@RequestBody Institucion institucion, BindingResult result){
			System.out.println("entro a guardar");
			System.out.println(institucion);
			System.out.println("************************");
			if(result.hasErrors()){
		      System.out.println("Tieene errores");            
		     }
			service.saveInstitucion(institucion);

		}
	 
	 //Listar tipos
	 
	 @RequestMapping(value = "/listarInstitucion",  method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<TipoInstitucion>> listarInstitucion() {		 
		 System.out.println("Entro a tipos de institucion");
			List<TipoInstitucion> tipo = null;
			try {
				tipo = service.listarTipos();

				if (tipo == null) {
					tipo = null;
				}
				
			} catch (Exception e) {
				
				return new ResponseEntity<List<TipoInstitucion>>(tipo, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			return new ResponseEntity<List<TipoInstitucion>>(tipo, HttpStatus.OK);
		}
	 
	 
	
}
