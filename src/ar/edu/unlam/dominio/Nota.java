package ar.edu.unlam.dominio;

public class Nota {

	private Integer valor;
	private TipoDeNota tipoDeNota;

	public Nota(Integer valor, TipoDeNota tipoDeNota) {
		this.valor = valor;
		this.tipoDeNota = tipoDeNota;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public TipoDeNota getTipoDeNota() {
		return tipoDeNota;
	}

	public void setTipoDeNota(TipoDeNota tipoParcial) {
		this.tipoDeNota = tipoParcial;
	}
	
	
	
	

}
