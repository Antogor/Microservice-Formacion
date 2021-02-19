package service;

import java.util.List;

import model.Alumno;
import model.Curso;

public interface FormacionService {
	public List<Curso> cursosExistentes();
	public List<Alumno> alumnosEnElCurso(String c);

}
