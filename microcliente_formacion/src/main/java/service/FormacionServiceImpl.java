package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dto.DtoCurso;
import model.Alumno;
import model.Curso;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	private String url = "http://localhost:8000/formacion/";
	
	@Autowired
	RestTemplate template;

	@Override
	public List<Curso> cursosExistentes() {
		DtoCurso[] cursos = template.getForObject(url+"cursos", DtoCurso[].class);
		
		return Arrays.asList(cursos).stream()
				.map(c->new Curso(c.getIdCurso(), c.getNombre()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Alumno> alumnosEnElCurso(String c) {
		DtoCurso[] cursos = template.getForObject(url+"cursos", DtoCurso[].class);
		DtoCurso cr = Arrays.asList(cursos).stream()
				.filter(curso->curso.getNombre().equals(c))
				.findFirst()
				.orElse(null);
		return cr != null? cr.getAlumnos().stream()
					.map(a->new Alumno(a.getEdad(), a.getEmail(), a.getNombre()))
					.collect(Collectors.toList()): new ArrayList<Alumno>();
	}

}
