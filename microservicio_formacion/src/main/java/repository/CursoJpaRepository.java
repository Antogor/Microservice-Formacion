package repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Curso;

public interface CursoJpaRepository extends JpaRepository<Curso, Integer>{
	
	@Query("Select c From Curso c join c.alumnos a where a.usuario=?1")
	public List<Curso> cursosAlumnos(String usuario);
	
	@Query("Select c From Curso c where c not in (Select c From Curso c join c.alumnos a Where a.usuario=?1)")
	public List<Curso> cursosDisponiblesAlumno(String usuario);
	
	
	public List<Curso> findByFechaInicioBetween(Date inicio, Date fin);
}
