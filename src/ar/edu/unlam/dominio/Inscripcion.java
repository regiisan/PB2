package ar.edu.unlam.dominio;

public class Inscripcion {

	private Alumno alumno;
	private Materia materia;
	private Nota nota;

	public Inscripcion(Alumno alumno, Materia materia) {
		this.alumno = alumno;
		this.materia = materia;
//		this.nota = new Nota(0);
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public boolean tieneNota() {
		return this.nota != null;
	}

	public boolean esAprobada() {
		if (!tieneNota()) {
			return false;
		}

		if (this.nota.getNota() < 4) {
			return false;
		}

		return true;
	}
}
