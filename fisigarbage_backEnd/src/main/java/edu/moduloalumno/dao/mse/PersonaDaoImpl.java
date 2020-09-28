package edu.moduloalumno.dao.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.entity.mse.AlumnoMse;
import edu.moduloalumno.entity.mse.AperturaConcepto;
import edu.moduloalumno.entity.mse.ConProgramaPorAlumno;
import edu.moduloalumno.entity.mse.Formacion;
import edu.moduloalumno.entity.mse.Institucion;
import edu.moduloalumno.entity.mse.Nivel;
import edu.moduloalumno.entity.mse.Persona;
import edu.moduloalumno.entity.mse.TipoCorreo;
import edu.moduloalumno.entity.mse.TipoGrado;
import edu.moduloalumno.entity.mse.TipoInstitucion;
import edu.moduloalumno.entity.mse.TipoTelefono;
import edu.moduloalumno.rowmapper.mse.TipoGradoRowMapper;
import edu.moduloalumno.rowmapper.mse.AlumnoMseRowMapper;
import edu.moduloalumno.rowmapper.mse.AperturaConceptoRowMapper;
import edu.moduloalumno.rowmapper.mse.ConProgramaPorAlumnoRowMapper;
import edu.moduloalumno.rowmapper.mse.FormacionRowMapper;
import edu.moduloalumno.rowmapper.mse.NivelRowMapper;
import edu.moduloalumno.rowmapper.mse.PersonaRowMapper;
import edu.moduloalumno.rowmapper.mse.TipoCorreoRowMapper;
import edu.moduloalumno.rowmapper.mse.TipoInstitucionRowMapper;
import edu.moduloalumno.rowmapper.mse.TipoTelefonoRowMapper;


@Transactional
@Repository
public class PersonaDaoImpl implements IPersonaDao{

	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	@Override
	public Persona findOne(String codigo) {
		String sql="select persona_id,persona_dni,persona_apaterno,persona_amaterno,persona_nombres,persona_fnacimiento,persona_edad,persona_ubigeo_nac,persona_nhijos,ecivil_id,persona_ultimo,estado_id from PERSONA WHERE PERSONA_NOMBRES=(SELECT NOM_ALUMNO FROM ALUMNO_PROGRAMA WHERE cod_alumno='"+codigo+"');";
		System.out.println(sql);
		//RowMapper<Alumno2> rowMapper = new BeanPropertyRowMapper<Alumno2>(Alumno2.class);
		RowMapper<Persona> rowMapper = new PersonaRowMapper();
		Persona persona = this.jdbcTemplate.query(sql, rowMapper).get(0);
		System.out.println(persona);
		return persona;
		
		
		
		
	}

	@Override
	public void updatePersona(Persona persona) {
		//String sql = "UPDATE alumno_programa SET ape_paterno = ?, ape_materno = ?, nom_alumno = ?, nac_fecha = ? , ... = ?, ... = ? ,telefono = ?, telefono_movil = ?, correo_personal = ?, correo = ?  WHERE cod_alumno = ?";
				String sql = "UPDATE persona SET "
						+ "persona_apaterno = '"+persona.getApellidoPaterno()+"'"
						+ ",persona_amaterno = '"+persona.getApellidoMaterno()+"'"
						+ ",persona_nombres = '"+persona.getNombres()+"'"
						+ ",persona_dni = '"+persona.getDni()+"'"
						+ ",persona_fnacimiento = ?"
						+ " WHERE persona_id = "+persona.getId()+";";
						
				System.out.println("query="+sql);
				jdbcTemplate.update(sql,persona.getFechaNac());
				
		
	}

	@Override
	public AperturaConcepto findOneConcepto(Integer numero) {
		String sql="SELECT estado FROM configuracion WHERE id_configuracion="+numero+";";
		System.out.println(sql);
		RowMapper<AperturaConcepto> aperturaConceptoRowMapper=new AperturaConceptoRowMapper();
		AperturaConcepto a=this.jdbcTemplate.query(sql,aperturaConceptoRowMapper).get(0);
		return a;
	}

	@Override
	public void saveFormacion(Formacion formacion) {
		String sql="INSERT into FORMACION(persona_id,id_programa,nivel_id,formacion_calumno,formacion_fingreso,formacion_fegreso,modalidad_id,institucion_id) VALUES(?,?,?,?,?,?,?,?)";
		System.out.println("La consulta es: "+sql);
        try {
            jdbcTemplate.update(sql,formacion.getPersona_id(),formacion.getId_programa(),formacion.getNivel_id(),formacion.getFormacion_calumno(),formacion.getFormacion_fingreso(),formacion.getFormacion_fegreso(),formacion.getModalidad(),formacion.getInstitucion_id());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

		
	}

	@Override
	public List<Formacion> findFormacion(Integer id) {
		String sql="SELECT f.formacion_id, f.modalidad_id,f.persona_id,f.id_programa,f.nivel_id,f.formacion_calumno,f.formacion_fingreso,f.formacion_fegreso,pro.nom_programa,pro.sigla_programa,i.institucion_desc FROM FORMACION f INNER JOIN PERSONA p on p.persona_id=f.persona_id INNER JOIN PROGRAMA pro on pro.id_programa=f.id_programa inner join INSTITUCION i on i.institucion_id = f.institucion_id WHERE f.persona_id="+id+";";
		System.out.println(sql);
		RowMapper<Formacion> formacion=new FormacionRowMapper();
		List<Formacion> listaFormacion=this.jdbcTemplate.query(sql,formacion);
		System.out.println(listaFormacion);
				
		return listaFormacion;
	}

	@Override
	public List<Nivel> findNivel() {
		String sql="SELECT nivel_id,nivel_desc,nivel_ini FROM NIVEL ";
		System.out.println(sql);
		 RowMapper<Nivel> rowMapper=new NivelRowMapper();
		 List<Nivel> nivel = this.jdbcTemplate.query(sql, rowMapper);
		return nivel;
	}

	@Override
	public void deleteFormacion(Integer formacion) {
		String sql="DELETE FROM FORMACION WHERE formacion_id= ?";
		System.out.println(sql);
		jdbcTemplate.update(sql,formacion);
		
	}

	@Override
	public void saveInstitucion(Institucion institucion) {
		String sql="insert into institucion(institucion_id,aeconomica_id,tipo_inst_id,institucion_desc,institucion_desc_min,institucion_ini) values (?,?,?,?,?,?)";
		System.out.println("La consulta es: "+sql);
        try {
            jdbcTemplate.update(sql,institucion.getId(),institucion.getIdEconomico(),institucion.getIdTipoInst(),institucion.getInstDesc(),institucion.getInstDescMin(),institucion.getInstIni());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}

	@Override
	public List<TipoInstitucion> listarTipos() {
		String sql="SELECT tipo_inst_id ,tipo_inst_desc,tipo_inst_ini FROM tipo_institucion ;" ;
        System.out.println("la consulta es:"+sql);
        RowMapper<TipoInstitucion> rowMapper=new TipoInstitucionRowMapper();
        List<TipoInstitucion> tipoInstitucion= jdbcTemplate.query(sql,rowMapper);
        System.out.println(tipoInstitucion);
        return tipoInstitucion;
		
	}

	@Override
	public List<TipoGrado> tipoGrado() {
		String sql="Select id_tipo_grado,nom_tipo_grado from tipo_grado";
		System.out.println("La consulta es: "+sql);
		RowMapper<TipoGrado> rowMapper=new TipoGradoRowMapper();
        List<TipoGrado> tipoGrado= jdbcTemplate.query(sql,rowMapper);
        System.out.println(tipoGrado);
		return tipoGrado;
	}

}
