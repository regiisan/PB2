package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class CicloLectivo {

	private Integer id;
	private LocalDate fechaInicioCicloLectivo;
	private LocalDate fechaFinalizacionCicloLectivo;
	private LocalDate fechaInicioInscripcion;
	private LocalDate fechaFinalizacionInscripcion;
	
	
	public CicloLectivo(Integer id, LocalDate fechaInicioCicloLectivo, LocalDate fechaFinalizacionCicloLectivo, LocalDate fechaInicioInscripcion, LocalDate fechaFinalizacionInscripcion) {
		this.id = id;
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
		this.fechaInicioInscripcion = fechaInicioInscripcion;
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
	}

	
//	public boolean seSuperpone(CicloLectivo nuevoCiclo) {
//	    return (nuevoCiclo.getFechaInicioCicloLectivo().isBefore(fechaFinalizacionCicloLectivo) || nuevoCiclo.getFechaInicioCicloLectivo().isEqual(fechaFinalizacionCicloLectivo))
//	        && (nuevoCiclo.getFechaFinalizacionCicloLectivo().isAfter(fechaInicioCicloLectivo) || nuevoCiclo.getFechaFinalizacionCicloLectivo().isEqual(fechaInicioCicloLectivo));
//	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDate getFechaInicioCicloLectivo() {
		return fechaInicioCicloLectivo;
	}

	public void setFechaInicioCicloLectivo(LocalDate fechaInicioCicloLectivo) {
		this.fechaInicioCicloLectivo = fechaInicioCicloLectivo;
	}

	public LocalDate getFechaFinalizacionCicloLectivo() {
		return fechaFinalizacionCicloLectivo;
	}

	public void setFechaFinalizacionCicloLectivo(LocalDate fechaFinalizacionCicloLectivo) {
		this.fechaFinalizacionCicloLectivo = fechaFinalizacionCicloLectivo;
	}

	public LocalDate getFechaInicioInscripcion() {
		return fechaInicioInscripcion;
	}

	public void setFechaInicioInscripcion(LocalDate fechaInicioInscripcion) {
		this.fechaInicioInscripcion = fechaInicioInscripcion;
	}

	public LocalDate getFechaFinalizacionInscripcion() {
		return fechaFinalizacionInscripcion;
	}

	public void setFechaFinalizacionInscripcion(LocalDate fechaFinalizacionInscripcion) {
		this.fechaFinalizacionInscripcion = fechaFinalizacionInscripcion;
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
