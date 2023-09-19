package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class Materia {

	private String nombre;
	private Integer codigo;
	private Aula aula;
	private ArrayList<Materia> correlativas;

	public Materia(String nombre, Integer codigo) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.correlativas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public void asignarAula(Aula aula) {
		this.aula = aula;
	}

	public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}

}
