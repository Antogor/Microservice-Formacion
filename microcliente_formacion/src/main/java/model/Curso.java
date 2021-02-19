package model;

public class Curso {
	private int codigoCurso;

	private String nombreCurso;
	
	public Curso() {
		
	}

	public Curso(int codigoCurso, String nombreCurso) {
		super();
		this.codigoCurso = codigoCurso;
		this.nombreCurso = nombreCurso;
	}

	public int getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(int codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}


	
	
}
