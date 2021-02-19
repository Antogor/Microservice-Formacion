package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface AlumnoJpaRepository extends JpaRepository<Alumno, String> {
	
	@Query("Select a From Alumno a join a.cursos c Where c.idCurso=?1")
	public List<Alumno> alumnosCurso(int idCurso);
}
