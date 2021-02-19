package repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Curso;

@Repository
public class CursosRepositoryImpl implements CursosRepository {
	
	@Autowired
	CursoJpaRepository repository;
	
	@Override
	public void altaCurso(Curso c) {
		repository.save(c);
	}

	@Override
	public Curso buscarCurso(int idCurso) {
		return repository.findById(idCurso).orElse(null);
	}

	@Override
	public List<Curso> cursosAlumnos(String usuario) {
		return repository.findAll();
	}

	@Override
	public List<Curso> cursosDisponiblesAlumno(String usuario) {
		return repository.cursosDisponiblesAlumno(usuario);
	}

	@Override
	public List<Curso> cursos() {
		return repository.findAll();
	}

	@Override
	public List<Curso> cursosFechas(Date inicio, Date fin) {
		return repository.findByFechaInicioBetween(inicio, fin);
	}

}
