package ar.edu.unlam.dominio;

import java.util.Objects;

public class Aula {

	private Integer id;
	private Integer cantidadDeLugares;

	public Aula(Integer id, Integer cantidadDeLugares) {
		this.id = id;
		this.cantidadDeLugares = cantidadDeLugares;
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
		Aula other = (Aula) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getCantidadDeLugares() {
		return cantidadDeLugares;
	}

	public void setCantidadDeLugares(Integer cantidadDeLugares) {
		this.cantidadDeLugares = cantidadDeLugares;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
