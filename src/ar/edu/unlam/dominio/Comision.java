package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Objects;

public class Comision {

	private Integer id;
	private Materia materia;
	private CicloLectivo cicloLectivo;
//	private ArrayList<Examen> examenes;
	private String turno;
	
	public Comision(Integer id, Materia materia, CicloLectivo cicloLectivo) {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public CicloLectivo getCicloLectivo() {
		return cicloLectivo;
	}
	public void setCicloLectivo(CicloLectivo cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comision other = (Comision) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
