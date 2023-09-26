package ar.edu.unlam.dominio;

import java.util.ArrayList;

public class ComisionAlumno {

	private Integer idComision;
	private Integer dniAlumno;
	private ArrayList<Nota> notas;

	public ComisionAlumno(Integer idComision, Integer dniAlumno) {
		this.idComision = idComision;
		this.dniAlumno = dniAlumno;
		this.notas = new ArrayList<>();
	}

	public Integer getIdComision() {
		return idComision;
	}

	public void setIdComision(Integer idComision) {
		this.idComision = idComision;
	}

	public Integer getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(Integer dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void agregarNota(Nota nota) {
		this.notas.add(nota);
	}

	public boolean isAprobada() {
		Nota primerParcial = buscarNotaPorTipo(TipoDeNota.PRIMER_PARCIAL);
		Nota segundoParcial = buscarNotaPorTipo(TipoDeNota.SEGUNDO_PARCIAL);
		
		if (primerParcial == null || segundoParcial == null) {
			return false;
		}
		
		if (primerParcial.getValor() < 4) {
			primerParcial = buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL);
		}
		
		if (segundoParcial.getValor() < 4) {
			segundoParcial = buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL);
		}
		
		if (primerParcial == null || segundoParcial == null) {
			return false;
		}
		
		if (primerParcial.getValor() < 4 || segundoParcial.getValor() < 4 ) {
			return false;
		}
		
		return true;
	}
	
	public int obtenerNota() {
		int notaFinal;
		
		Nota primerParcial = buscarNotaPorTipo(TipoDeNota.PRIMER_PARCIAL);
		
		Nota segundoParcial = buscarNotaPorTipo(TipoDeNota.SEGUNDO_PARCIAL);
		
		notaFinal = (primerParcial.getValor() + segundoParcial.getValor()) /2;
		
		return notaFinal;
	}
	
	

	public Nota buscarNotaPorTipo(TipoDeNota tipoDeNota) {
		for (int i = 0; i < this.notas.size(); i++) {
			if (tipoDeNota.equals(notas.get(i).getTipoDeNota())) {
				return notas.get(i);
			}
		}
		return null;
	}

}
