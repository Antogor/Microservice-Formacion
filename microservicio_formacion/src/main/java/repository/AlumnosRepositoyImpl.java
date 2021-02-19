package repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Alumno;

@Repository //para instantacion de repositorios
public class AlumnosRepositoyImpl implements AlumnosRepository {
	
	@Autowired
	AlumnoJpaRepository repository;
	
	@Override
	public void guardarAlumno(Alumno a) {
		repository.save(a);

	}

	@Override
	public Alumno buscarAlumno(String usuario) {
		return repository.findById(usuario).orElse(null);
	}

	@Override
	public void actualizarAlumno(Alumno a) {
		repository.save(a);

	}

	@Override
	public List<Alumno> alumnosCurso(int idCurso) {
		return repository.alumnosCurso(idCurso);
	}

	@Override
	public List<Alumno> alumnos() {
		return repository.findAll();
	}
}
