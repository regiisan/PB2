package ar.edu.unlam.dominio;

public class MateriaCorrelativa {
	private Integer idMateria;
	private Integer idCorrelativa;

	public MateriaCorrelativa(int idMateria, int idCorrelativa) {
		this.idMateria = idMateria;
		this.idCorrelativa = idCorrelativa;
	}
	
	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public Integer getIdCorrelativa() {
		return idCorrelativa;
	}

	public void setIdCorrelativa(Integer idCorrelativa) {
		this.idCorrelativa = idCorrelativa;
	}

}
