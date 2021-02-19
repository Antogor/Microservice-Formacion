package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Alumno;
import model.Curso;
import service.FormacionService;

@CrossOrigin("*")
@RestController
public class FormacionController {

	@Autowired
	FormacionService fs;
	
	@GetMapping(value = "cursosExistentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curso>> cursos(){
		HttpHeaders header = new HttpHeaders();
		List<Curso> cursos = fs.cursosExistentes();
		int nCursos = cursos.size();
		header.add("Cursos disponibles", nCursos+"");
		return new ResponseEntity<List<Curso>>(cursos, header, HttpStatus.OK);
	}
	
	@GetMapping(value = "alumnos/{curso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Alumno>> alumnos(@PathVariable("curso")String curso){
		HttpHeaders header = new HttpHeaders();
		List<Alumno> alumnos = fs.alumnosEnElCurso(curso);
		int nAlumnos = alumnos.size();
		header.add("Alumnos en el curso", nAlumnos+"");
		return new ResponseEntity<List<Alumno>>(alumnos, header, HttpStatus.OK);
	}
}
