package edu.moduloalumno.dao.mse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.moduloalumno.entity.mse.Facultad;
import edu.moduloalumno.entity.mse.Formacion;
import edu.moduloalumno.entity.mse.Programa;
import edu.moduloalumno.entity.mse.TipoGrado;
import edu.moduloalumno.rowmapper.mse.FormacionRowMapper;
import edu.moduloalumno.rowmapper.mse.ProgramaRowMapper;
import edu.moduloalumno.rowmapper.mse.TipoGradoRowMapper;

@Transactional
@Repository
public class ProgramaDaoImpl implements IProgramaDao {

	@Autowired
	private JdbcTemplate jdbcTemplate; 
	
	@Override
	public void agregarPrograma(Programa programa) {
		String sql="INSERT INTO PROGRAMA(nom_programa,sigla_programa,id_tip_grado,id_facultad, vigencia_programa,n_prioridad) VALUES(?,?,?,?,?,?)";
		System.out.println("La consulta es: "+sql);
        try {
            jdbcTemplate.update(sql,programa.getNombre(),programa.getSigla(),programa.getTipoGrado(),programa.getFacultadId(),programa.isVigencia(),programa.getPrioridad());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

		
		
	}

	@Override
	public List<Programa> listarProgramas() {
		String sql="SELECT id_programa,nom_programa,sigla_programa,id_tip_grado,id_facultad, vigencia_programa,n_prioridad FROM PROGRAMA";
		System.out.println(sql);
		RowMapper<Programa> programa=new ProgramaRowMapper();
		List<Programa> listaPrograma=this.jdbcTemplate.query(sql,programa);
		System.out.println(listaPrograma);
				
		return listaPrograma;
		
	}

	@Override
	public void agregarFacultad(Facultad facultad) {
		String sql="INSERT INTO FACULTAD(nombre) VALUES(?)";
		System.out.println("La consulta es: "+sql);
        try {
            jdbcTemplate.update(sql,facultad.getNombre());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

		
	}

	@Override
	public List<TipoGrado> listarTipoGrado() {
		String sql="SELECT id_tip_grado,nom_tip_grado FROM TIPO_GRADO";
		System.out.println(sql);
		RowMapper<TipoGrado> tipoGrado=new TipoGradoRowMapper();
		List<TipoGrado> list_tipoGrado=this.jdbcTemplate.query(sql,tipoGrado);
		System.out.println(list_tipoGrado);
				
		return list_tipoGrado;
	}

}
