package repository;

import java.util.Date;
import java.util.List;

import model.Curso;

public interface CursosRepository {
	void altaCurso(Curso c);
	Curso buscarCurso(int idCurso);
	List<Curso> cursosAlumnos(String usuario);
	List<Curso> cursosDisponiblesAlumno(String usuario);
	List<Curso> cursos();
	List<Curso> cursosFechas(Date inicio, Date fin);
}
