package controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.DtoCurso;
import dto.Utilidades;
import service.FormacionService;

@RestController
public class CursoController {
	
	@Autowired
	FormacionService fs;

	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DtoCurso> cursosCompletos(){
		return fs.todosCursos().stream()
				.map(c->Utilidades.cursoBuilder(c))
				.collect(Collectors.toList());
	}
	
	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void anadirCurso(@RequestBody DtoCurso c) {
		fs.altaCurso(Utilidades.cursoEntityBuilder(c));
	}
}
