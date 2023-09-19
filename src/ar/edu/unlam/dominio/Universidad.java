package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<Aula> aulas;
	private ArrayList<Profesor> profesores;
	private ArrayList<Comision> comisiones;
	private ArrayList<CicloLectivo> ciclos;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<Materia>();
		this.aulas = new ArrayList<Aula>();
	}

	public Boolean agregarAlumno(Alumno alumno) {
		if (buscarAlumnoPorDni(alumno.getDni()) == null) {
			return this.alumnos.add(alumno);
		}
		return false;
	}

	private Alumno buscarAlumnoPorDni(Integer dni) {
		for (int i = 0; i < alumnos.size(); i++) {
			if (this.alumnos.get(i).getDni().equals(dni)) {
				return this.alumnos.get(i);
			}
		}
		return null;
	}

	public boolean existeAlumno(Alumno buscado) { // ver 
		return this.alumnos.contains(buscado);
	}

	public boolean agregarMateria(Materia materia) {
		if (buscarMateriaPorCodigo(materia.getCodigo()) == null) {
			return this.materias.add(materia);
		}
		return false;
	}

	public Materia buscarMateriaPorCodigo(Integer codigo) {
		for (int i = 0; i < this.materias.size(); i++) {
			if (this.materias.get(i).getCodigo().equals(codigo)) {
				return this.materias.get(i);
			} // hashcode
		}
		return null;
	}


	public Boolean agregarCicloLectivo(CicloLectivo ciclo) {

		return false;
	}

	private CicloLectivo buscarCicloPorId(Integer id) {
		for (int i = 0; i < ciclos.size(); i++) {
			if (this.ciclos.get(i).getId().equals(id)) {
				return this.ciclos.get(i);
			}
		}
		return null;
	}
	
	public Boolean agregarComision(Comision comision) {
			if(sePuedeAgregarComision(null, null, nombre)) {
			return this.comisiones.add(comision);
		}
			return false;
		}
	
	private boolean sePuedeAgregarComision(Materia materia, CicloLectivo cicloLectivo, String turno) {
		for(int i = 0; i<comisiones.size();i++) {
			if(this.comisiones.get(i).getMateria().equals(materia) && this.comisiones.get(i).getCicloLectivo().equals(cicloLectivo) && this.comisiones.get(i).getTurno().equals(turno)) {
				return false;
			}
	}
		return true;
	}
	
	public Boolean agregarDocente(Profesor profesor) {
		if (buscarDocentePorDni(profesor.getDni()) == null) {
			return this.profesores.add(profesor);
		} 
		return false;
	}

	private Profesor buscarDocentePorDni(Integer dni) {
		for (int i = 0; i < profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				return this.profesores.get(i); 
			} // hashcode
		}
		return null;
	}
	
	public Boolean asignarDocentesAComision(Integer idComision, Integer dniDocente) {
		
		if(existeDocente(dniDocente) && existeComision(idComision)) {
		}
		
		return false;
		
	}
	
	public boolean existeDocente(Integer dniDocente) { 
		return this.profesores.contains(dniDocente);
	}
	
	public boolean existeComision(Integer idComision) { 
		return this.comisiones.contains(idComision);
	}

	public Boolean inscribirAlumnoAMateria(Integer dni, Integer codigo) {
		Alumno alumno = buscarAlumnoPorDni(dni);
		Materia materia = buscarMateriaPorCodigo(codigo);

		if (alumno == null || materia == null) {
			return false;
		}
		// Hacer
		return false;
	}

	public void agregarAula(Aula aula) {
		this.aulas.add(aula);
	}

	public Integer obtenerCantidadAulas() {
		return this.aulas.size();
	}

	public Aula obtenerAulaPorId(Integer id) {
		for (int i = 0; i < this.aulas.size(); i++) {
			if (this.aulas.get(i).getId().equals(id)) {
				return this.aulas.get(i);
			}
		}
		return null;
	}

	public Boolean asignarAulaAMateria(Integer codigoMateria, Integer idAula) {

		Materia materia = buscarMateriaPorCodigo(codigoMateria);
		Aula aula = obtenerAulaPorId(idAula);
		Boolean asignado = false;

		if (materia != null && aula != null) {
			materia.asignarAula(aula);
			asignado = true;
		}
		return asignado;
	}

	public Integer obtenerCantidadDeInscriptosDeUnaMateria(Integer codigo) {
		return null;

	}
}
