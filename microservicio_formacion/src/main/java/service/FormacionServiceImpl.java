package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Curso;
import repository.CursosRepository;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Autowired
	CursosRepository cr;

	@Override
	public List<Curso> todosCursos() {
		return cr.cursos();
	}

	@Override
	public void altaCurso(Curso c) {
		cr.altaCurso(c);
	}

}
