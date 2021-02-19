package dto;

import java.util.ArrayList;
import java.util.stream.Collectors;

import model.Alumno;
import model.Curso;

public class Utilidades {
	
	public static DtoAlumno alumnoBuilder(Alumno ae) {
		return new DtoAlumno(ae.getNombre(), ae.getEdad(), ae.getEmail(), ae.getUsuario(), ae.getPassword());
	}
	
	public static Alumno alumnoEntityBuilder(DtoAlumno a) {
		Alumno ae = new Alumno();
		ae.setNombre(a.getNombre());
		ae.setEdad(a.getEdad());
		ae.setEmail(a.getEmail());
		ae.setUsuario(a.getUsuario());
		ae.setPassword(a.getPassword());
		return ae;
	}
	
	public static DtoCurso cursoBuilder(Curso ce) {
		return new DtoCurso(ce.getIdCurso(), ce.getNombre(), ce.getDuracion(), ce.getFechaInicio(),
				ce.getAlumnos()==null?new ArrayList<DtoAlumno>():ce.getAlumnos().stream().map(alumno->alumnoBuilder(alumno)).collect(Collectors.toList()));
	}
	
	public static Curso cursoEntityBuilder(DtoCurso c) {
		Curso ce = new Curso();
		ce.setIdCurso(c.getIdCurso());
		ce.setNombre(c.getNombre());
		ce.setDuracion(c.getDuracion());
		ce.setFechaInicio(c.getFechaInicio());
		if (c.getAlumnos() != null)
			ce.setAlumnos(c.getAlumnos().stream().map(alumnos->alumnoEntityBuilder(alumnos)).collect(Collectors.toList()));
		else
			ce.setAlumnos(null);
		return ce;
	}
}
