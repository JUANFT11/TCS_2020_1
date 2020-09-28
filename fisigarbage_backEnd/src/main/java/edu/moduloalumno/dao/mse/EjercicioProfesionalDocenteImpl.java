package edu.moduloalumno.dao.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.entity.mse.Correo;
import edu.moduloalumno.entity.mse.EjercicioProfesionalDocente;
import edu.moduloalumno.rowmapper.mse.EjercicioProfesionalDocenteRowMapper;


@Transactional
@Repository
public class EjercicioProfesionalDocenteImpl implements IEjercicioProfesionalDocenteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void agregar(EjercicioProfesionalDocente ejerprodoc) {
		String sql="INSERT INTO ejercicio_profesional_docente(entidad,tipo_entidad,cargo,princ_func,tipo_vinc_lab,fecha_inicio,fecha_fin,nom_jef_inm_sup,correo_jef_inm_sup) VALUES(?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		 try {
	            jdbcTemplate.update(sql,ejerprodoc.getEntidad(),ejerprodoc.getTipoEntidad(),ejerprodoc.getCargo(),ejerprodoc.getPrincFunc(),ejerprodoc.getTipoVincLab(),ejerprodoc.getFechInic(),ejerprodoc.getFechaFin(),ejerprodoc.getNomJefInmSup(),ejerprodoc.getCorrJefInmSup());
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	}

	@Override
	public void eliminar(Correo correo) {
		String sql="DELETE FROM ejercicio_profesional_docente where correo_jef_inm_sup=?";
		System.out.println(sql);
		
		jdbcTemplate.update(sql,correo.getCorreo());
		
	}

	@Override
	public List<EjercicioProfesionalDocente> listar(Integer id) {
		String sql="SELECT entidad,tipo_entidad,cargo,princ_func,tipo_vinc_lab,fecha_inicio,fecha_fin,nom_jef_inm_sup,correo_jef_inm_sup FROM ejercicio_profesional_docente where entidad="+id+";" ;
		System.out.println(sql);
		RowMapper<EjercicioProfesionalDocente> rowMapper=new EjercicioProfesionalDocenteRowMapper();
		List<EjercicioProfesionalDocente> ejerprodoc=jdbcTemplate.query(sql, rowMapper);
		System.out.println(ejerprodoc);
		
		return ejerprodoc;
	}

}
