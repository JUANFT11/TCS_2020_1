package edu.moduloalumno.api;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.moduloalumno.entity.CuentasPorCobrar;
import edu.moduloalumno.entity.CuentasPorCobrar2;
import edu.moduloalumno.entity.DeudoresPosgradoMasInfo;
import edu.moduloalumno.entity.RecaudacionesEnvio;
import edu.moduloalumno.model.Filtro;
import edu.moduloalumno.service.IRecaudacionesEnvioService;
import edu.moduloalumno.util.Operaciones;

@RestController
@RequestMapping("/recaudaciones_envios")

public class RecaudacionesEnvioController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IRecaudacionesEnvioService recaudacionesEnvioService;
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecaudacionesEnvio>> getAllRecaudacionesEnvio() {
		logger.info("> getAllRecaudacionesEnvio [RecaudacionesEnvio]");

		List<RecaudacionesEnvio> list = null;
		try {
			list = recaudacionesEnvioService.getAllRecaudacionesEnvio();

			if (list == null) {
				list = new ArrayList<RecaudacionesEnvio>();
			}
		} catch (final Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAllRecaudacionesEnvio [RecaudacionesEnvio]");
		return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.OK);
	}
	
	
    

    @RequestMapping(value = "/buscarid/{id_envio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecaudacionesEnvio>> getRecaudacionesEnvioById_envio(@PathVariable("id_envio") Integer id_envio) {
		logger.info(">  getRecaudacionesEnvioById_envio [RecaudacionesEnvio]");

		List<RecaudacionesEnvio> list = null;
		try {
			
						list = recaudacionesEnvioService.getRecaudacionesEnvioById_envio(id_envio);
						if (list == null) {
							list = new ArrayList<RecaudacionesEnvio>();
						}
					} catch (Exception e) {
						logger.error("Unexpected Exception caught.", e);
						return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
					}
			
					logger.info("< getRecaudacionesByNomApe [Recaudaciones]");
			//		System.out.println("retornando: "+list);
					return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscarm/{n_mes}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecaudacionesEnvio>> getRecaudacionesEnvioByMes(@PathVariable("n_mes") Integer n_mes) {
		logger.info(">  getRecaudacionesEnvioByMes [RecaudacionesEnvio]");

		List<RecaudacionesEnvio> list = null;
		try {
			
						list = recaudacionesEnvioService.getRecaudacionesEnvioByMes(n_mes);
						if (list == null) {
							list = new ArrayList<RecaudacionesEnvio>();
						}
					} catch (Exception e) {
						logger.error("Unexpected Exception caught.", e);
						return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
					}
			
					logger.info("< getRecaudacionesByNomApe [Recaudaciones]");
			//		System.out.println("retornando: "+list);
					return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.OK);
	}


	@RequestMapping(value = "/buscara/{n_anio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecaudacionesEnvio>> getRecaudacionesEnvioByAnio(@PathVariable("n_anio") Integer n_anio) {
		logger.info(">  getRecaudacionesEnvioByAnio [RecaudacionesEnvio]");

		List<RecaudacionesEnvio> list = null;
		try {
			
						list = recaudacionesEnvioService.getRecaudacionesEnvioByAnio(n_anio);
						if (list == null) {
							list = new ArrayList<RecaudacionesEnvio>();
						}
					} catch (Exception e) {
						logger.error("Unexpected Exception caught.", e);
						return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
					}
			
					logger.info("< getRecaudacionesByNomApe [Recaudaciones]");
			//		System.out.println("retornando: "+list);
					return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.OK);
	}


	@RequestMapping(value = "/filtro/{n_mes}/{n_anio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecaudacionesEnvio>> getRecaudacionesEnvioByMesAnio(@PathVariable("n_mes") Integer n_mes,@PathVariable("n_anio") Integer n_anio) {
		logger.info("> getRecaudacionesEnvioByMesAnio [RecaudacionesEnvio]");

		List<RecaudacionesEnvio> list = null;
		try {
			list = recaudacionesEnvioService.getRecaudacionesEnvioByMesAnio(n_mes,n_anio);

			if (list == null) {
				list = new ArrayList<RecaudacionesEnvio>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAlumnoProgramasIdByCodAlumIdProg [AlumnoPrograma]");
		return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id_envio}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecaudacionesEnvio>> getEnviobyId(@PathVariable("id_envio") Integer id_envio) {
		logger.info("> getEnviobyId [RecaudacionesEnvio]");

		List<RecaudacionesEnvio> list = null;
		try {
			list = recaudacionesEnvioService.getEnviobyId(id_envio);

			if (list == null) {	
				list = new ArrayList<RecaudacionesEnvio>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAlumnoProgramasIdByNombresApellidosRestringido [AlumnoPrograma]");
		return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/fechaenvio/{numero}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RecaudacionesEnvio>> getFechaEnvio(@PathVariable("numero") String numero) {
		logger.info("> getFechaEnvio [RecaudacionesEnvio]");

		List<RecaudacionesEnvio> list = null;
		try {
			list = recaudacionesEnvioService.getFechaEnvio(numero);

			if (list == null) {	
				list = new ArrayList<RecaudacionesEnvio>();
			}
			
		} catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		logger.info("< getAlumnoProgramasIdByNombresApellidosRestringido [AlumnoPrograma]");
		return new ResponseEntity<List<RecaudacionesEnvio>>(list, HttpStatus.OK);
	}

		

	





















}