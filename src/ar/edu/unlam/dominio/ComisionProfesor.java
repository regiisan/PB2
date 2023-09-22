package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class ComisionProfesor {

	private Integer idComision;
	private Integer dniProfesor;
	
	public ComisionProfesor(Integer idComision, Integer dniProfesor) {
		this.idComision = idComision;
		this.dniProfesor = dniProfesor;
	}

	public Integer getIdComision() {
		return idComision;
	}

	public void setIdComision(Integer idComision) {
		this.idComision = idComision;
	}

	public Integer getDniProfesor() {
		return dniProfesor;
	}

	public void setDniProfesor(Integer dniProfesor) {
		this.dniProfesor = dniProfesor;
	}
	
	
}
