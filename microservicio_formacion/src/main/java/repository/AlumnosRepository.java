package repository;

import java.util.List;

import model.Alumno;

public interface AlumnosRepository {
	void guardarAlumno(Alumno a);
	Alumno buscarAlumno(String usuario);
	void actualizarAlumno(Alumno a);
	List<Alumno> alumnosCurso(int idCurso);
	List<Alumno> alumnos();
}
