package service;

import java.util.List;

import model.Curso;

public interface FormacionService {

	public List<Curso> todosCursos();
	public void altaCurso(Curso c);
}
