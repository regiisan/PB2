package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

	public Boolean seSuperponen(CicloLectivo cicloIngresado) {

		for (int i = 0; i < this.ciclos.size(); i++) {
			if ((cicloIngresado.getFechaInicioCicloLectivo().isAfter(ciclos.get(i).getFechaInicioCicloLectivo())
					|| cicloIngresado.getFechaFinalizacionCicloLectivo().isAfter(ciclos.get(i).getFechaInicioCicloLectivo()))
				&& (cicloIngresado.getFechaInicioCicloLectivo().isBefore(ciclos.get(i).getFechaFinalizacionCicloLectivo())
						|| cicloIngresado.getFechaFinalizacionCicloLectivo().isBefore(ciclos.get(i).getFechaFinalizacionCicloLectivo()))) {
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

	public Comision buscarComisionPorId(Integer id) {
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

	public Boolean asignarProfesorAComision(Integer idComision, Integer dniProfesor) {
		if (buscarProfesorPorDni(dniProfesor) == null || buscarComisionPorId(idComision) == null) {
			return false;
		}
		for (int i = 0; i < this.comisionesProfesor.size(); i++) {
			if (comisionesProfesor.get(i).getDniProfesor().equals(dniProfesor)) {
				if (buscarComisionPorId(idComision).equals(comisionesProfesor.get(i).getIdComision()))
					return false;
			}
		}
		
		this.comisionesProfesor.add(new ComisionProfesor(idComision, dniProfesor));
		
		return agregarOtroProfesorSiHaceFalta(dniProfesor, idComision);
	}

	public Boolean agregarOtroProfesorSiHaceFalta(Integer dniProfesor, Integer idComision) {
		if (obtenerCantidadDeInscriptosDeUnaComision(idComision) > 20 && obtenerCantidadDeProfesoresEnComision(idComision) < 2) {
			if (profesores.size() < 2) {
				return false;
			}
			
			ArrayList<Profesor> profesoresDisponibles = new ArrayList<>();
			for (int i = 0; i < profesores.size(); i++) {
				if(!profesores.get(i).getDni().equals(dniProfesor)) {
					profesoresDisponibles.add(profesores.get(i));
				}
			}
			
			Random random = new Random();
			int indiceAleatorio = random.nextInt(profesoresDisponibles.size());
			Profesor profesorAleatorio = profesores.get(indiceAleatorio);
			Integer dniAleatorio = profesorAleatorio.getDni();

			this.comisionesProfesor.add(new ComisionProfesor(idComision, dniProfesor));
			
			return true;
		}
		return true;
	}
 
	public Integer obtenerCantidadDeProfesoresEnComision(Integer idComision) {
		int cantidad = 0;
		
		for (int i = 0; i < comisionesProfesor.size(); i++) {
			if(comisionesProfesor.get(i).getIdComision().equals(idComision)) {
				cantidad++;
			}
		}
		
		return cantidad;
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
			asignado = true;
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

	public Boolean inscribirAlumnoAComision(Integer dniAlumno, Integer idComision, LocalDate fechaActual) {
		Alumno alumno = buscarAlumnoPorDni(dniAlumno);
		Comision comision = buscarComisionPorId(idComision);
		ArrayList<Materia> materiasCorrelativas = buscarMateriasCorrelativas(comision.getMateria().getCodigo());

		if (alumno == null || comision == null) {
			return false;
		}

		if(materiasCorrelativas!=null) {
			if (!tieneCorrelativasAprobadas(idComision, dniAlumno))
			return false;
		}
		
		Integer cantidadDeLugaresMaximos = comision.getAula().getCantidadDeLugares();
		Integer cantidadDeInscripos = obtenerCantidadDeInscriptosDeUnaComision(idComision);

		if (cantidadDeLugaresMaximos.equals(cantidadDeInscripos)) {
			return false;
		}

		LocalDate fechaInicioInscripcion = comision.getCicloLectivo().getFechaInicioInscripcion();
		LocalDate fechaFinInscripcion = comision.getCicloLectivo().getFechaFinalizacionInscripcion();

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

		for (int i = 0; i < obtenerMateriasAprobadasParaUnAlumno(dniAlumno).size(); i++) {
			if (obtenerMateriasAprobadasParaUnAlumno(dniAlumno).get(i).equals(comision.getMateria())) {
				return false;
			}
		}

		return this.comisionesAlumno.add(new ComisionAlumno(dniAlumno, idComision));
	}

	public ComisionAlumno getInscripcionAcomision(Integer dniAlumno, Integer idComision) {
		for (int i = 0; i < this.comisionesAlumno.size(); i++) {
			if (this.comisionesAlumno.get(i).getDniAlumno().equals(dniAlumno)
					&& this.comisionesAlumno.get(i).getIdComision().equals(idComision)) {
				return this.comisionesAlumno.get(i);
			}
		}
		return null;
	}

	public ArrayList<ComisionAlumno> getInscripcionesAcomision(Integer dniAlumno) {
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
				cantidad++;
			}
		}
		return cantidad;
	}

	public Boolean registrarNota(Integer idComision, Integer dniAlumno, Nota nota) {
		ComisionAlumno comisionAlumno = getInscripcionAcomision(dniAlumno, idComision);
		Comision comision = buscarComisionPorId(idComision);

		if (comisionAlumno == null) {
			return false;
		}

		if (nota.getValor() < 1 || nota.getValor() > 10) {
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
		
		for(int i = 0; i < materiasCorrelativas.size(); i++) {
			Materia materiaCorrelativa = materiasCorrelativas.get(i);
			if(!materiasAprobadas.contains(materiaCorrelativa)) {
				return false;
			}
		}
		return true;
	}

	public Integer obtenerNotaFinal(Integer dniAlumno, Integer idComision) {

		ComisionAlumno comisionDelAlumno = getInscripcionAcomision(dniAlumno, idComision);
		Nota primerParcial = comisionDelAlumno.buscarNotaPorTipo(TipoDeNota.PRIMER_PARCIAL);
		Nota segundoParcial = comisionDelAlumno.buscarNotaPorTipo(TipoDeNota.SEGUNDO_PARCIAL);

		if (comisionDelAlumno.buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL) != null) {
			primerParcial = comisionDelAlumno.buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL);
		}

		if (comisionDelAlumno.buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL) != null) {
			segundoParcial = comisionDelAlumno.buscarNotaPorTipo(TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL);
		}

		if (primerParcial != null && segundoParcial != null) {
			Integer notaFinal = (primerParcial.getValor() + segundoParcial.getValor()) / 2;
			return notaFinal;
		}

		return null;
	}

	public ArrayList<Materia> obtenerMateriasQueFaltanCursarParaUnAlumno(Integer dniAlumno) {
		ArrayList<Materia> materiasAprobadasDelAlumno = obtenerMateriasAprobadasParaUnAlumno(dniAlumno);
		ArrayList<Materia> materiasFaltantes = new ArrayList<>();

		Alumno alumno = buscarAlumnoPorDni(dniAlumno);

		if (alumno != null) {
			for (Materia materia : materias) {
				if (!materiasAprobadasDelAlumno.contains(materia)) {
					materiasFaltantes.add(materia);
				}
			}
		}
		return materiasFaltantes;
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
