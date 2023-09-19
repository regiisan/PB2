package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {

	private Integer id;
	private String fechaInicioCicloLectivo;
	private String fechaFinalizacionCicloLectivo;
	private LocalDate fechaInicioInscripcion;
	private String fechaFinalizacionInscripcion;
	
	public CicloLectivo(Integer id, String fechaInicioCicloLectivo) {
		LocalDate messi = LocalDate.of(2023, 9, 18);
		
		messi.isAfter(fechaInicioInscripcion);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		CicloLectivo other = (CicloLectivo) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
