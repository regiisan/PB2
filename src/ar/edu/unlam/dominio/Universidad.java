package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Universidad {

	private String nombre;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Materia> materias;
	private ArrayList<Aula> aulas;
	private ArrayList<Profesor> profesores;
	private ArrayList<Comision> comisiones;
	private ArrayList<CicloLectivo> ciclos;
	private ArrayList<ComisionAlumno> comisionesAlumno;
	private ArrayList<ComisionProfesor> comisionesProfesor;
	private ArrayList<MateriaCorrelativa> materiasCorrelativas;

	public Universidad(String nombre) {
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
		this.materias = new ArrayList<Materia>();
		this.profesores = new ArrayList<Profesor>();
		this.aulas = new ArrayList<Aula>();
		this.ciclos = new ArrayList<CicloLectivo>();
		this.comisiones = new ArrayList<Comision>();
		this.comisionesAlumno = new ArrayList<ComisionAlumno>();
		this.comisionesProfesor = new ArrayList<ComisionProfesor>();
		this.materiasCorrelativas = new ArrayList<MateriaCorrelativa>();

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

	public boolean existeAlumno(Alumno buscado) {
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
			}
		}
		return null;
	}

	public Boolean agregarCicloLectivo(CicloLectivo ciclo) {
		if (buscarCicloPorId(ciclo.getId()) != null) {
			return false;
		}
		if (seSuperponen(ciclo)) {
			return false;
		}
		return this.ciclos.add(ciclo);
	}

	private CicloLectivo buscarCicloPorId(Integer id) {
		for (int i = 0; i < ciclos.size(); i++) {
			if (this.ciclos.get(i).getId().equals(id)) {
				return this.ciclos.get(i);
			}
		}
		return null;
	}
	
	public Boolean seSuperponen(CicloLectivo ciclo) {
		for(int i = 0;i<this.ciclos.size();i++) {
			if(ciclos.get(i).getFechaInicioCicloLectivo().isBefore(ciclo.getFechaFinalizacionCicloLectivo())||ciclos.get(i).getFechaFinalizacionCicloLectivo().isAfter(ciclo.getFechaInicioCicloLectivo())) {
				return true;
			}
		}
		return false;
	}

	public Boolean agregarComision(Comision comision) {
		if (sePuedeAgregarComision(comision)) {
			return this.comisiones.add(comision);
		}
		return false;
	}

	private boolean sePuedeAgregarComision(Comision comision) {
		if (buscarComisionPorId(comision.getId()) != null) {
			return false;
		}
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getMateria().equals(comision.getMateria())
					&& this.comisiones.get(i).getCicloLectivo().equals(comision.getCicloLectivo())
					&& this.comisiones.get(i).getTurno().equals(comision.getTurno())) {
				return false;
			}
		}
		return true;
	}
	
	public boolean existeComision(Integer idComision) {
		return this.comisiones.contains(idComision);
	}

	private Comision buscarComisionPorId(Integer id) {
		for (int i = 0; i < comisiones.size(); i++) {
			if (this.comisiones.get(i).getId().equals(id)) {
				return this.comisiones.get(i);
			}
		}
		return null;
	}

	public Boolean agregarProfesor(Profesor profesor) {
		if (buscarProfesorPorDni(profesor.getDni()) == null) {
			return this.profesores.add(profesor);
		}
		return false;
	}

	private Profesor buscarProfesorPorDni(Integer dni) {
		for (int i = 0; i < profesores.size(); i++) {
			if (this.profesores.get(i).getDni().equals(dni)) {
				return this.profesores.get(i);
			}
		}
		return null;
	}
	
	public boolean existeProfesor(Integer dniProfesor) {
		return this.profesores.contains(dniProfesor);
	}

	public Boolean asignarProfesorAComision(Integer idComision, Integer dniProfesor) {
		if (!existeProfesor(dniProfesor) || !existeComision(idComision)) {
			return false;
		}

		for (int i = 0; i < this.comisionesProfesor.size(); i++) {
			if (comisionesProfesor.get(i).getDniProfesor().equals(dniProfesor)) {
				if (buscarComisionPorId(idComision).equals(comisionesProfesor.get(i).getIdComision()))
					return false; // falta
			}
		}
		return this.comisionesProfesor.add(new ComisionProfesor(idComision, dniProfesor));
	}

	public static Integer obtenerCantidadAlumnos(ArrayList<Alumno> alumnos) {
		return alumnos.size();
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

	public Boolean asignarAulaAComision(Integer idComision, Integer idAula) {
		Boolean asignado = false;
		Comision comision = buscarComisionPorId(idComision);
		Aula aula = obtenerAulaPorId(idAula);

		if (comision != null && aula != null) {
			comision.setAula(aula);
			asignado = true; // 
		}
		return asignado;
	}

	public Boolean agregarCorrelatividad(int idMateria, int idCorrelativa) {
		Materia materia = buscarMateriaPorCodigo(idMateria);
		Materia correlativa = buscarMateriaPorCodigo(idCorrelativa);

		if (materia == null || correlativa == null) {
			return false;
		}
		return this.materiasCorrelativas.add(new MateriaCorrelativa(idMateria, idCorrelativa));
	}

	public Boolean eliminarCorrelatividad(int idMateria, int idCorrelativaAEliminar) {
		Materia materia = buscarMateriaPorCodigo(idMateria);
		Materia correlativa = buscarMateriaPorCodigo(idCorrelativaAEliminar);

		if (materia == null || correlativa == null) {
			return false;
		}
		
		for (int i = 0; i < materiasCorrelativas.size(); i++) {
	        if (materiasCorrelativas.get(i).getIdCorrelativa().equals(idCorrelativaAEliminar)) {
	             materiasCorrelativas.remove(i);
	             return true;
	        }
	}
		return false;
	}

	private ArrayList<Materia> buscarMateriasCorrelativas(Integer idMateria) {
		ArrayList<Materia> idCorrelativas = new ArrayList<>();

		for (int i = 0; i < materiasCorrelativas.size(); i++) {
			if (this.materiasCorrelativas.get(i).getIdMateria().equals(idMateria)) {
				idCorrelativas.add(buscarMateriaPorCodigo(materiasCorrelativas.get(i).getIdCorrelativa()));
			}
		}
		return idCorrelativas;
	}

	public Boolean inscribirAlumnoAComision(Integer dniAlumno, Integer idComision) {
		Alumno alumno = buscarAlumnoPorDni(dniAlumno);
		Comision comision = buscarComisionPorId(idComision);

		if (alumno == null || comision == null) {
			return false;
		}
		


		Integer cantidadDeLugaresMaximos = comision.getAula().getCantidadDeLugares();
		Integer cantidadDeInscripos = obtenerCantidadDeInscriptosDeUnaComision(idComision);

		if (cantidadDeLugaresMaximos.equals(cantidadDeInscripos)) {
			return false;
		}

		LocalDate fechaInicioInscripcion = comision.getCicloLectivo().getFechaInicioInscripcion();
		LocalDate fechaFinInscripcion = comision.getCicloLectivo().getFechaFinalizacionCicloLectivo();
		LocalDate fechaActual = LocalDate.now();

		if (fechaActual.isBefore(fechaInicioInscripcion) || fechaActual.isAfter(fechaFinInscripcion)) {
			return false;
		}

		for (int i = 0; i < comisionesAlumno.size(); i++) {
			ComisionAlumno comisionAlumno = comisionesAlumno.get(i);

			if (comisionAlumno.getDniAlumno().equals(dniAlumno)) {
				if (buscarComisionPorId(comisionAlumno.getIdComision()).getTurno().equals(comision.getTurno())) {
					return false;
				}
			}
		}
		return this.comisionesAlumno.add(new ComisionAlumno(dniAlumno, idComision));
	}

	private ComisionAlumno getInscripcionAcomision(Integer dniAlumno, Integer idComision) {
		for (int i = 0; i < comisionesAlumno.size(); i++) {
			if (this.comisionesAlumno.get(i).getDniAlumno().equals(dniAlumno)
					&& this.comisionesAlumno.get(i).getIdComision().equals(idComision)) {
				return this.comisionesAlumno.get(i);
			}
		}
		return null;
	}

	private ArrayList<ComisionAlumno> getInscripcionesAcomision(Integer dniAlumno) {
		ArrayList<ComisionAlumno> resultado = new ArrayList<>();

		for (int i = 0; i < comisionesAlumno.size(); i++) {
			if (this.comisionesAlumno.get(i).getDniAlumno().equals(dniAlumno)) {
				resultado.add(comisionesAlumno.get(i));
			}
		}
		return resultado;
	}

	public Integer obtenerCantidadDeInscriptosDeUnaComision(Integer idComision) {
		Integer cantidad = 0;

		for (int i = 0; i < comisionesAlumno.size(); i++) {
			if (comisionesAlumno.get(i).getIdComision().equals(idComision)) {
				cantidad++; // ver si no se hace infinito
			}
		}
		return cantidad;
	}

	public Boolean registrarNota(Integer idComision, Integer dniAlumno, Nota nota) {
		ComisionAlumno comisionAlumno = getInscripcionAcomision(idComision, dniAlumno);

		if (comisionAlumno == null) {
			return false;
		}

		if (nota.getValor() < 1 || nota.getValor() > 10) {
			return false;
		}

		if (nota.getValor() >= 7 && !tieneCorrelativasAprobadas(idComision, dniAlumno)) {
			return false;
		}

		if (TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL.equals(nota.getTipoDeNota())
				|| TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL.equals(nota.getTipoDeNota())) {
			if (comisionAlumno.buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) != null
					|| comisionAlumno.buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) != null) {
				return false;
			}
		}

		if (comisionAlumno.buscarNotaPorTipo(nota.getTipoDeNota()) != null) {
			return false;
		}

		comisionAlumno.agregarNota(nota);
		return true;
	}

	private boolean tieneCorrelativasAprobadas(Integer idComision, Integer dniAlumno) {
		Comision comisionAprobada = buscarComisionPorId(idComision);
		ArrayList<Materia> materiasAprobadas = obtenerMateriasAprobadasParaUnAlumno(dniAlumno);
		ArrayList<Materia> materiasCorrelativas = buscarMateriasCorrelativas(comisionAprobada.getMateria().getCodigo());

		return materiasAprobadas.containsAll(materiasCorrelativas);

//		for(int i = 0; i < materiasCorrelativas.size(); i++) {
//			Materia materiaCorrelativa = materiasCorrelativas.get(i);
//			if(!materiasAprobadas.contains(materiaCorrelativa)) {
//				return false;
//			}
//		}
//		return true;
	}

	public Nota obtenerNota(Integer dniAlumno, Integer idMateria) { // falta
		ArrayList<ComisionAlumno> comisionesDelAlumno = getInscripcionesAcomision(dniAlumno);
		
		for(int i = 0;i<comisionesDelAlumno.size();i++) {
			
		}
		return null;
	}

	public ArrayList<Materia> obtenerMateriasAprobadasParaUnAlumno(Integer dniAlumno) {
		ArrayList<ComisionAlumno> comisionesDelAlumno = getInscripcionesAcomision(dniAlumno);
		ArrayList<Materia> materiasAprobadasDelAlumno = new ArrayList<>();

		for (int i = 0; i < comisionesDelAlumno.size(); i++) {
			if (comisionesDelAlumno.get(i).isAprobada()) {
				Comision comisionAprobada = buscarComisionPorId(comisionesDelAlumno.get(i).getIdComision());
				materiasAprobadasDelAlumno.add(comisionAprobada.getMateria());
			}
		}
		return materiasAprobadasDelAlumno;
	}
}
