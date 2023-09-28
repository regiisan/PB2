package ar.edu.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.dominio.*;
import org.junit.Test;

public class TestUniversidad {

	@Test
	public void queSePuedaRegistrarUnAlumnoAUnaUniversidad() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		String nombreAlumno = "Regina";
		String apellido = "Sanchez";
		Integer dni = 45870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);

		// Ejecucion
		Boolean registroExitoso = universidad.agregarAlumno(alumno);

		// Validacion
		assertTrue(registroExitoso);
	}

	@Test
	public void queNoSePuedaRegistrarUnAlumnoCuandoYaEsteRegistrado() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		String nombreAlumno = "Regina";
		String apellido = "Sanchez";
		Integer dni = 45870226;
		Alumno alumno1 = new Alumno(dni, nombreAlumno, apellido);
		Alumno alumno2 = new Alumno(dni, nombreAlumno, apellido);

		// Ejecucion
		universidad.agregarAlumno(alumno1);
		Boolean registroExitoso = universidad.agregarAlumno(alumno2);

		// Validacion
		assertFalse(registroExitoso);
	}

	@Test
	public void queSePuedaRegistrarUnaMateriaAUnaUniversidad() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		// Ejecucion
		Boolean registroExitoso = universidad.agregarMateria(pb2);

		// Validacion
		assertTrue(registroExitoso);
	}

	@Test
	public void queNoSePuedaRegistrarUnaMateriaCuandoYaEsteRegistrada() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		String nombreMateria = "PB1";
		Integer id = 1;
		Integer dni = 45870226;
		Materia materia1 = new Materia(nombreMateria, id);
		Materia materia2 = new Materia(nombreMateria, id);

		// Ejecucion
		universidad.agregarMateria(materia1);
		Boolean registroExitoso = universidad.agregarMateria(materia2);

		// Validacion
		assertFalse(registroExitoso);
	}

	@Test
	public void queSePuedaAgregarUnAulaALaUniversidad() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		Integer cantidadDeLugares = 50;
		Integer id = 1;
		Aula aula = new Aula(id, cantidadDeLugares);

		// Ejecucion
		universidad.agregarAula(aula);
		Integer cantAulasEsperada = 1;
		Integer cantAulasActual = universidad.obtenerCantidadAulas();

		// Validacion
		assertEquals(cantAulasEsperada, cantAulasActual);
		Aula aulaEsperada = new Aula(id, cantidadDeLugares);
		Aula aulaEncontrada = universidad.obtenerAulaPorId(id);
		assertEquals(aulaEsperada, aulaEncontrada);
	}

	@Test // ver
	public void queNoSePuedaInsctibirAlumnoPorSuperarLaCantidadEsperadaDeAulas() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		Integer cantidadDeLugares = 50;
		Integer id = 1;
		Aula aula = new Aula(id, cantidadDeLugares);

		// Ejecucion
		universidad.agregarAula(aula);
		Integer cantAulasEsperada = 1;
		Integer cantAulasActual = universidad.obtenerCantidadAulas();

		// Validacion
		assertEquals(cantAulasEsperada, cantAulasActual);
		Aula aulaEsperada = new Aula(id, cantidadDeLugares);
		Aula aulaEncontrada = universidad.obtenerAulaPorId(id);
		assertEquals(aulaEsperada, aulaEncontrada);
	}

	@Test
	public void queSePuedaRegistrarUnCicloLectivo() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		Integer id = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo = new CicloLectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		// Ejecucion
		Boolean registroExitoso = universidad.agregarCicloLectivo(ciclo);

		// Validacion
		assertTrue(registroExitoso);
	}

	@Test
	public void queSePuedaRegistrarDosCiclosLectivosConDiferentesFechas() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		Integer id = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 1, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 5, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 1, 1);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 1, 5);
		CicloLectivo ciclo = new CicloLectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer id2 = 2;
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo2 = new CicloLectivo(id2, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);

		// Ejecucion
		Boolean registroExitoso = universidad.agregarCicloLectivo(ciclo);
		Boolean registroExitoso2 = universidad.agregarCicloLectivo(ciclo2);

		// Validacion
		assertTrue(registroExitoso);
		assertTrue(registroExitoso2);
	}

	@Test
	public void queNoSePuedaRegistrarOtroCicloLectivoCuandoSeSuperponenFechas() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		Integer id = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo = new CicloLectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer id2 = 2;
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 9, 10);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 12, 6);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo2 = new CicloLectivo(id2, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);

		// Ejecucion
		Boolean registroExitoso = universidad.agregarCicloLectivo(ciclo);
		Boolean registroNoExitoso = universidad.agregarCicloLectivo(ciclo2);

		// Validacion
		assertTrue(registroExitoso);
		assertFalse(registroNoExitoso);
	}

	@Test
	public void queSePuedaRegistrarUnaComision() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);

		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb2);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);

		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
	}

	@Test
	public void queNoSePuedaRegistrarUnaComisionPorTenerElMismoCicloLectivoMateriaYturno() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer id = 1;
		Aula aula = new Aula(id, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);
		Comision comision2 = new Comision(idComision, pb2, ciclo, turno);

		// Ejecucion
		universidad.agregarMateria(pb2);
		universidad.agregarCicloLectivo(ciclo);
		universidad.agregarAula(aula);
		universidad.agregarComision(comision);
		Boolean registroExitoso = universidad.agregarComision(comision2);

		// Validacion
		assertFalse(registroExitoso);
	}

	@Test
	public void queSePuedaAsignarAulaAUnaComision() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);

		// Ejecucion
		universidad.agregarAula(aula);
		Boolean agregarMateria = universidad.agregarMateria(pb2);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);

		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarAula);
	}

	@Test
	public void queNoSePuedaAsignarAulaAUnaComisionSiLaComisionNoExiste() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = universidad.buscarComisionPorId(idComision);

		// Ejecucion
		universidad.agregarAula(aula);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);

		// Validacion
		assertFalse(asignarAula);
	}

	@Test
	public void queSePuedaAsignarUnProfesorAUnaComision() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer dni = 2243423;
		String nombreProfesor = "Juan";
		String apellidoProfesor = "Perez";
		Profesor profesor = new Profesor(dni, nombreProfesor, apellidoProfesor);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);

		// Ejecucion
		Boolean agregarProfesor = universidad.agregarProfesor(profesor);
		Boolean agregarMateria = universidad.agregarMateria(pb2);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		Boolean asignarProfesor = universidad.asignarProfesorAComision(idComision, dni);

		// Validacion
		assertTrue(agregarProfesor);
		assertTrue(agregarMateria);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarProfesor);
	}
	
	@Test
	public void queSeAsignen2ProfesoresAUnaComisionCuandoHayMasDe20Alumnos() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer dni = 2243423;
		String nombreProfesor = "Juan";
		String apellidoProfesor = "Perez";
		Profesor profesor = new Profesor(dni, nombreProfesor, apellidoProfesor);
		
		Integer dni2 = 2243424;
		String nombreProfesor2 = "Lionel";
		String apellidoProfesor2 = "Messi";
		Profesor profesor2 = new Profesor(dni2, nombreProfesor2, apellidoProfesor2);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);
		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		// Ejecucion
		Boolean agregarProfesor = universidad.agregarProfesor(profesor);
		Boolean agregarProfesor2 = universidad.agregarProfesor(profesor2);
		Boolean agregarMateria = universidad.agregarMateria(pb2);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		universidad.agregarAula(aula);
		universidad.asignarAulaAComision(idComision, idComision);
		for (int i = 0; i <= 20; i++) {
			Alumno alumno = new Alumno(i, "Nombre_" + i, "Apellido_" + i);
			universidad.agregarAlumno(alumno);
			universidad.inscribirAlumnoAComision(i, idComision, fechaFinalizacionInscripcion);
		}
		
		Boolean asignarProfesor = universidad.asignarProfesorAComision(idComision, dni);
		Integer cantProfesoresEsperados = 2;
		
		// Validacion
		assertTrue(agregarProfesor);
		assertTrue(agregarProfesor2);
		assertTrue(agregarMateria);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarProfesor);
		assertEquals(cantProfesoresEsperados, universidad.obtenerCantidadDeProfesoresEnComision(idComision));
	}


	@Test
	public void queNoSePuedaAsignarUnProfesorAUnaComisionSiLaComisionNoExiste() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer dni = 2243423;
		String nombreProfesor = "Juan";
		String apellidoProfesor = "Perez";
		Profesor profesor = new Profesor(dni, nombreProfesor, apellidoProfesor);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);

		// Ejecucion
		Boolean agregarProfesor = universidad.agregarProfesor(profesor);
		Boolean agregarMateria = universidad.agregarMateria(pb2);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean asignarProfesor = universidad.asignarProfesorAComision(idComision, dni);

		// Validacion
		assertTrue(agregarProfesor);
		assertTrue(agregarMateria);
		assertTrue(agregarCiclo);
		assertFalse(asignarProfesor);
	}

	@Test
	public void queNoSePuedaAsignarUnProfesorAUnaComisionSiElDocenteNoExiste() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer dni = 2243423;
		String nombreProfesor = "Juan";
		String apellidoProfesor = "Perez";
		Profesor profesor = new Profesor(dni, nombreProfesor, apellidoProfesor);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);

		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb2);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		Boolean asignarProfesor = universidad.asignarProfesorAComision(idComision, dni);

		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertFalse(asignarProfesor);
	}

	@Test
	public void queSePuedaRegistrarUnProfesor() {

		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		Integer dni = 30565567;
		String nombreProfesor = "Juan";
		String apellidoProfesor = "Perez";
		Profesor profesor = new Profesor(dni, nombreProfesor, apellidoProfesor);

		Boolean registroExitoso = universidad.agregarProfesor(profesor);

		assertTrue(registroExitoso);
	}

	@Test
	public void queNoSePuedaRegistrarUnProfesorCuandoYaEsteRegistrado() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		Integer dni = 30565567;
		String nombreProfesor = "Juan";
		String apellidoProfesor = "Perez";
		Profesor profesor = new Profesor(dni, nombreProfesor, apellidoProfesor);
		Profesor profesor2 = new Profesor(dni, nombreProfesor, apellidoProfesor);

		// Ejecucion
		universidad.agregarProfesor(profesor);
		Boolean registroNoExitoso = universidad.agregarProfesor(profesor2);

		// Validacion
		assertFalse(registroNoExitoso);
	}

	@Test
	public void queSePuedaAgregarUnaCorrelativaAUnaMateria() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreMateria = "PB1";
		Integer idMateria = 1;
		Materia materia = new Materia(nombreMateria, idMateria);

		String nombreCorrelativa = "PB1";
		Integer idCorrelativa = 2;
		Materia materiaCorrelativa = new Materia(nombreCorrelativa, idCorrelativa);

		// Ejecucion
		universidad.agregarMateria(materia);
		universidad.agregarMateria(materiaCorrelativa);
		Boolean registroExitoso = universidad.agregarCorrelatividad(idMateria, idCorrelativa);

		// Validacion
		assertTrue(registroExitoso);
	}

	@Test
	public void queNoSePuedaAgregarUnaCorrelativaAUnaMateriaSiNoExisteLaMateria() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreMateria = "PB1";
		Integer idMateria = 1;
		Materia materia = new Materia(nombreMateria, idMateria);

		String nombreCorrelativa = "PB1";
		Integer idCorrelativa = 2;
		Materia materiaCorrelativa = new Materia(nombreCorrelativa, idCorrelativa);

		// Ejecucion
		universidad.agregarMateria(materia);
		Boolean registroExitoso = universidad.agregarCorrelatividad(idMateria, idCorrelativa);

		// Validacion
		assertFalse(registroExitoso);
	}

	@Test
	public void queNoSePuedaAgregarUnaCorrelativaAUnaMateriaSiNoExisteLaCorrelativa() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreMateria = "PB1";
		Integer idMateria = 1;
		Materia materia = new Materia(nombreMateria, idMateria);

		String nombreCorrelativa = "PB2";
		Integer idCorrelativa = 2;
		Materia materiaCorrelativa = new Materia(nombreCorrelativa, idCorrelativa);

		// Ejecucion
		universidad.agregarMateria(materiaCorrelativa);
		Boolean registroExitoso = universidad.agregarCorrelatividad(idMateria, idCorrelativa);

		// Validacion
		assertFalse(registroExitoso);
	}

	@Test
	public void queSePuedaEliminarLaCorrelatividadDeUnaMateria() {

		// Preparacion
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreMateria = "PB1";
		Integer idMateria = 1;
		Materia materia = new Materia(nombreMateria, idMateria);

		String nombreCorrelativa = "PB1";
		Integer idCorrelativa = 2;
		Materia materiaCorrelativa = new Materia(nombreCorrelativa, idCorrelativa);

		// Ejecucion
		universidad.agregarMateria(materia);
		universidad.agregarMateria(materiaCorrelativa);
		universidad.agregarCorrelatividad(idMateria, idCorrelativa);
		Boolean registroExitoso = universidad.eliminarCorrelatividad(idMateria, idCorrelativa);

		// Validacion
		assertTrue(registroExitoso);
	}

	@Test
	public void queSePuedaInscribirAlumnoAComision() {
		
		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 25);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		
		String nombreAlumno = "Regina";
		String apellido = "Sanchez";
		Integer dni = 45870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);
		
		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);
		
		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);
		
		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 20);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo,fechaFinalizacionCicloLectivo,fechaInicioInscripcion,fechaFinalizacionInscripcion);
		
		Integer idComision = 1;
		String turno = "maÃ±ana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);
		
		// Ejecucion
		
		universidad.agregarAula(aula);
		Integer cantAulasEsperada = 1;
		Integer cantAulasActual = universidad.obtenerCantidadAulas();
		Aula aulaEsperada = new Aula(idAula, cantidadDeLugares);
		Aula aulaEncontrada = universidad.obtenerAulaPorId(idAula);
		
		boolean agregarAlumno = universidad.agregarAlumno(alumno);
		boolean agregarMateria = universidad.agregarMateria(pb2);
		boolean agregarCicloLectivo = universidad.agregarCicloLectivo(ciclo);
		boolean agregarComision = universidad.agregarComision(comision);
		boolean asignarAulaAComision = universidad.asignarAulaAComision(idComision, idAula);
		
		// Verificacion
		
		boolean inscripcionExitosa = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
	    
		assertEquals(cantAulasEsperada, cantAulasActual);
		assertEquals(aulaEsperada, aulaEncontrada);
		assertTrue(agregarAlumno);
		assertTrue(agregarMateria);
		assertTrue(agregarComision);
		assertTrue(asignarAulaAComision);
		assertTrue(agregarCicloLectivo);
		assertTrue(inscripcionExitosa);
	}
	
	@Test
	public void queNoSePuedaInscribirAlumnoAComisionPorqueNoExisteElAlumno() {
		
		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 25);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);
		
		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);
		
		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);
		
		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo,fechaFinalizacionCicloLectivo,fechaInicioInscripcion,fechaFinalizacionInscripcion);
		
		Integer idComision = 1;
		String turno = "maÃ±ana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);
	
		// Ejecucion
		
		universidad.agregarAula(aula);
		Integer cantAulasEsperada = 1;
		Integer cantAulasActual = universidad.obtenerCantidadAulas();
		Aula aulaEsperada = new Aula(idAula, cantidadDeLugares);
		Aula aulaEncontrada = universidad.obtenerAulaPorId(idAula);
		
		
		boolean agregarMateria = universidad.agregarMateria(pb2);
		boolean agregarCicloLectivo = universidad.agregarCicloLectivo(ciclo);
		boolean agregarComision = universidad.agregarComision(comision);
		boolean asignarAulaAComision = universidad.asignarAulaAComision(idComision, idAula);
		
		// Verificacion
		
		boolean inscripcionExitosa = universidad.inscribirAlumnoAComision(36546546, idComision, fechaActual);
	    
		assertEquals(cantAulasEsperada, cantAulasActual);
		assertEquals(aulaEsperada, aulaEncontrada);
		assertTrue(agregarMateria);
		assertTrue(agregarCicloLectivo);
		assertTrue(agregarComision);
		assertTrue(asignarAulaAComision);
		assertFalse(inscripcionExitosa);
	}
	
	@Test
	public void queSePuedaRegistrarUnaNota() {

		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 20);

		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);

		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 8, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);

		Integer valor = 7;
		TipoDeNota tipo = TipoDeNota.PRIMER_PARCIAL;
		Nota notaPrimerParcial = new Nota(valor, tipo);

		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb2);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		universidad.agregarAula(aula);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		Boolean registrarNota = universidad.registrarNota(idComision, dni, notaPrimerParcial);

		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarAlumno);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarAula);
		assertTrue(inscribirAlumno);
		assertTrue(registrarNota);
	}

	@Test
	public void queNoSePuedaRegistrarUnaNotaPorSerMayorA10() {

		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 20);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);

		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 8, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);

		Integer valor = 11;
		TipoDeNota tipo = TipoDeNota.PRIMER_PARCIAL;
		Nota notaPrimerParcial = new Nota(valor, tipo);

		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb2);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		universidad.agregarAula(aula);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		Boolean registrarNota = universidad.registrarNota(idComision, dni, notaPrimerParcial);

		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarAlumno);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarAula);
		assertTrue(inscribirAlumno);
		assertFalse(registrarNota);
	}

	@Test
	public void queNoSePuedaRegistrarUnaNotaPorSerMenorA1() {

		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 20);

		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);

		String nombre2 = "PB2";
		Integer codigo = 2;
		Materia pb2 = new Materia(nombre2, codigo);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 8, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb2, ciclo, turno);

		Integer valor = 0;
		TipoDeNota tipo = TipoDeNota.PRIMER_PARCIAL;
		Nota notaPrimerParcial = new Nota(valor, tipo);

		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb2);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		universidad.agregarAula(aula);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		Boolean registrarNota = universidad.registrarNota(idComision, dni, notaPrimerParcial);

		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarAlumno);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(inscribirAlumno);
		assertTrue(asignarAula);
		assertFalse(registrarNota);
	}

	@Test
	public void queNoSePuedaRegistrarOtraNotaDelMismoTipo() {
		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 26);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);
		
		String nombreMateria = "PB1";
		Integer codigoMateria = 2;
		Materia pb1 = new Materia(nombreMateria, codigoMateria);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 10, 11);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb1, ciclo, turno);

		Integer valor = 10;
		Integer valor2 = 7;
		TipoDeNota tipo = TipoDeNota.PRIMER_PARCIAL;
		Nota notaPrimerParcial = new Nota(valor, tipo);
		Nota notaPrimerParcial2 = new Nota(valor2, tipo);


		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb1);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		universidad.agregarAula(aula);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		Boolean registrarNota = universidad.registrarNota(idComision, dni, notaPrimerParcial);
		Boolean registrarNotaDelMismoTipo = universidad.registrarNota(idComision, dni, notaPrimerParcial2);
		
		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarAlumno);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarAula);
		assertTrue(inscribirAlumno);
		assertTrue(registrarNota);
		assertFalse(registrarNotaDelMismoTipo);
	}
	
	@Test
	public void queNoSePuedanRegistrarDosRecuperatorios() {
 
		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 26);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);
		
		String nombreMateria = "PB1";
		Integer codigoMateria = 2;
		Materia pb1 = new Materia(nombreMateria, codigoMateria);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 10, 11);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb1, ciclo, turno);

		Integer valor = 10;
		Integer valor2 = 7;
		TipoDeNota tipo = TipoDeNota.RECUPERATORIO_PRIMER_PARCIAL;
		TipoDeNota tipo2 = TipoDeNota.RECUPERATORIO_SEGUNDO_PARCIAL;
		Nota notaPrimerParcial = new Nota(valor, tipo);
		Nota notaPrimerParcial2 = new Nota(valor2, tipo2);


		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb1);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		universidad.agregarAula(aula);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		Boolean registrarNota = universidad.registrarNota(idComision, dni, notaPrimerParcial);
		Boolean registrarNotaDelMismoTipo = universidad.registrarNota(idComision, dni, notaPrimerParcial2);
		
		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarAlumno);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarAula);
		assertTrue(inscribirAlumno);
		assertTrue(registrarNota);
		assertFalse(registrarNotaDelMismoTipo);
	}
	
	@Test
	public void queSePuedaBuscarInscripcionAmateriaPorDniYComision() {
 
		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 26);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);
		
		String nombreMateria = "PB1";
		Integer codigoMateria = 2;
		Materia pb1 = new Materia(nombreMateria, codigoMateria);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 10, 11);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb1, ciclo, turno);

		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb1);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		universidad.agregarAula(aula);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		
		ComisionAlumno inscripcion = universidad.getInscripcionAcomision(dni, idComision);
		
		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarAlumno);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarAula);
		assertTrue(inscribirAlumno);
		
		assertNotNull(inscripcion);
	}
	
	@Test
	public void queSePuedaObtenerNotaFinalDeUnaMateriaDeUnAlumno() {
 
		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 26);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);
		
		String nombreMateria = "PB1";
		Integer codigoMateria = 2;
		Materia pb1 = new Materia(nombreMateria, codigoMateria);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 10, 11);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb1, ciclo, turno);

		Integer valor = 10;
		Integer valor2 = 7;
		TipoDeNota tipo = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota tipo2 = TipoDeNota.SEGUNDO_PARCIAL;
		Nota nota1P = new Nota(valor, tipo);
		Nota nota2P = new Nota(valor2, tipo2);


		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb1);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		universidad.agregarAula(aula);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		Boolean registrarNota1P = universidad.registrarNota(idComision, dni, nota1P);
		Boolean registrarNota2P = universidad.registrarNota(idComision, dni, nota2P);
		
		Integer ve = 8;
		Integer vo = universidad.obtenerNotaFinal(dni, idComision);
		
		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarAlumno);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarAula);
		assertTrue(inscribirAlumno);
		assertTrue(registrarNota1P);
		assertTrue(registrarNota2P);
		
		assertEquals(ve, vo);
	}
	
	@Test
	public void queNoSePuedaObtenerNotaFinalDeUnaMateriaDeUnAlumnoPorNoTenerPrimerOSegundoParcial() {
 
		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 26);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);
		
		String nombreMateria = "PB1";
		Integer codigoMateria = 2;
		Materia pb1 = new Materia(nombreMateria, codigoMateria);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 10, 11);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb1, ciclo, turno);

		Integer valor = 10;
		Integer valor2 = 7;
		TipoDeNota tipo = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota tipo2 = TipoDeNota.SEGUNDO_PARCIAL;
		Nota nota1P = new Nota(valor, tipo);
		Nota nota2P = new Nota(valor2, tipo2);


		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb1);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarComision = universidad.agregarComision(comision);
		universidad.agregarAula(aula);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		Boolean registrarNota1P = universidad.registrarNota(idComision, dni, nota1P);
		
		Integer ve = 8;
		Integer vo = universidad.obtenerNotaFinal(dni, idComision);
		
		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarAlumno);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarAula);
		assertTrue(inscribirAlumno);
		assertTrue(registrarNota1P);
		
		assertNull(vo);
	}
	
	@Test
	public void queSePuedaBuscarInscripcionesAmateriaPorDni() {
 
		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 26);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);
		 
		// COMISION 1
		String nombreMateria = "PB1";
		Integer codigoMateria = 2;
		Materia pb1 = new Materia(nombreMateria, codigoMateria);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 10, 11);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb1, ciclo, turno);

		// COMISION 2
		String nombreMateria2 = "BDD";
		Integer codigoMateria2 = 3;
		Materia bdd = new Materia(nombreMateria2, codigoMateria2);

		Integer idCiclo2 = 2;
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 1, 11);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 5, 4);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);

		Integer cantidadDeLugares2 = 50;
		Integer idAula2 = 2;
		Aula aula2 = new Aula(idAula2, cantidadDeLugares2);

		Integer idComision2 = 2;
		String turno2 = "noche";
		Comision comision2 = new Comision(idComision2, bdd, ciclo2, turno2);
		
		
		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb1);
		Boolean agregarMateria2 = universidad.agregarMateria(bdd);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarCiclo2 = universidad.agregarCicloLectivo(ciclo2);
		Boolean agregarComision = universidad.agregarComision(comision);
		Boolean agregarComision2 = universidad.agregarComision(comision2);
		universidad.agregarAula(aula);
		universidad.agregarAula(aula2);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean asignarAula2 = universidad.asignarAulaAComision(idComision2, idAula2);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		Boolean inscribirAlumno2 = universidad.inscribirAlumnoAComision(dni, idComision2, fechaActual);

		ArrayList<ComisionAlumno> inscripcionesObtenidas = universidad.getInscripcionesAcomision(dni);
		
		// Validacion
		assertTrue(agregarMateria);
		assertTrue(agregarMateria2);
		assertTrue(agregarCiclo2);
		assertTrue(agregarAlumno);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(asignarAula);
		assertTrue(asignarAula2);
		assertTrue(agregarComision2);
		assertTrue(inscribirAlumno);
		assertTrue(inscribirAlumno2);
		
		assertEquals(inscripcionesObtenidas.get(0).getIdComision(), idComision);
		assertEquals(inscripcionesObtenidas.get(1).getIdComision(), idComision2);
	}
	
	@Test
	public void queSePuedaObtenerMateriasAprobadasDeUnAlumno() {
 
		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 26);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);
		 
		// COMISION 1
		String nombreMateria = "PB1";
		Integer codigoMateria = 2;
		Materia pb1 = new Materia(nombreMateria, codigoMateria);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 10, 11);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb1, ciclo, turno);

		TipoDeNota tipo1 = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota tipo2 = TipoDeNota.SEGUNDO_PARCIAL;
		Integer valor1 = 10;
		Integer valor2 = 7;
		Nota notaPrimerParcial = new Nota(valor1, tipo1);
		Nota notaSegundoParcial = new Nota(valor2, tipo2);
		
		// COMISION 2
		String nombreMateria2 = "BDD";
		Integer codigoMateria2 = 3;
		Materia bdd = new Materia(nombreMateria2, codigoMateria2);

		Integer idCiclo2 = 2;
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 1, 11);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 5, 4);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);

		Integer cantidadDeLugares2 = 50;
		Integer idAula2 = 2;
		Aula aula2 = new Aula(idAula2, cantidadDeLugares2);

		Integer idComision2 = 2;
		String turno2 = "noche";
		Comision comision2 = new Comision(idComision2, bdd, ciclo2, turno2);
		
		Integer valor3 = 7;
		Integer valor4 = 8;
		Nota notaPrimerParcial2 = new Nota(valor3, tipo1);
		Nota notaSegundoParcial2 = new Nota(valor4, tipo2);
		
		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb1);
		Boolean agregarMateria2 = universidad.agregarMateria(bdd);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarCiclo2 = universidad.agregarCicloLectivo(ciclo2);
		Boolean agregarComision = universidad.agregarComision(comision);
		Boolean agregarComision2 = universidad.agregarComision(comision2);
		universidad.agregarAula(aula);
		universidad.agregarAula(aula2);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean asignarAula2 = universidad.asignarAulaAComision(idComision2, idAula2);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		Boolean inscribirAlumno2 = universidad.inscribirAlumnoAComision(dni, idComision2, fechaActual);
		Boolean registrarNota1 = universidad.registrarNota(idComision, dni, notaPrimerParcial);
		Boolean registrarNota2 = universidad.registrarNota(idComision, dni, notaSegundoParcial);
		Boolean registrarNota3 = universidad.registrarNota(idComision2, dni, notaPrimerParcial2);
		Boolean registrarNota4 = universidad.registrarNota(idComision2, dni, notaSegundoParcial2);
		ArrayList<ComisionAlumno> inscripciones = universidad.getInscripcionesAcomision(dni);
		
		List<Materia> materiasAprobadasEsperadas = List.of(pb1,bdd);
		ArrayList<Materia> materiasAprobadasObtenidas = universidad.obtenerMateriasAprobadasParaUnAlumno(dni);
		
		// Validacion
		assertTrue(agregarAlumno);
		assertTrue(agregarMateria);
		assertTrue(agregarMateria2);
		assertTrue(agregarCiclo2);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(agregarComision2);
		assertTrue(asignarAula);
		assertTrue(asignarAula2);
		assertTrue(inscribirAlumno);
		assertTrue(inscribirAlumno2);
		assertNotNull(inscripciones);
		assertTrue(registrarNota1);
		assertTrue(registrarNota2);
		assertTrue(registrarNota3);
		assertTrue(registrarNota4);
		
		assertTrue(materiasAprobadasEsperadas.containsAll(materiasAprobadasObtenidas));
	}
	
	
	@Test
	public void queSePuedaObtenerMateriasQueFaltanCursarParaUnAlumno() {
 
		// Preparacion
		LocalDate fechaActual = LocalDate.of(2023, 9, 26);
		
		String nombre = "Unlam";
		Universidad universidad = new Universidad(nombre);

		String nombreAlumno = "Franco";
		String apellido = "Coppola";
		Integer dni = 44870226;
		Alumno alumno = new Alumno(dni, nombreAlumno, apellido);
		 
		// COMISION 1
		String nombreMateria = "PB1";
		Integer codigoMateria = 2;
		Materia pb1 = new Materia(nombreMateria, codigoMateria);

		Integer idCiclo = 1;
		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 10, 11);
		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		Integer cantidadDeLugares = 50;
		Integer idAula = 1;
		Aula aula = new Aula(idAula, cantidadDeLugares);

		Integer idComision = 1;
		String turno = "mañana";
		Comision comision = new Comision(idComision, pb1, ciclo, turno);

		TipoDeNota tipo1 = TipoDeNota.PRIMER_PARCIAL;
		TipoDeNota tipo2 = TipoDeNota.SEGUNDO_PARCIAL;
		Integer valor1 = 10;
		Integer valor2 = 7;
		Nota notaPrimerParcial = new Nota(valor1, tipo1);
		Nota notaSegundoParcial = new Nota(valor2, tipo2);
		
		// COMISION 2
		String nombreMateria2 = "BDD";
		Integer codigoMateria2 = 3;
		Materia bdd = new Materia(nombreMateria2, codigoMateria2);

		Integer idCiclo2 = 2;
		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 1, 11);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 5, 4);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 9, 25);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 10, 10);
		CicloLectivo ciclo2 = new CicloLectivo(idCiclo2, fechaInicioCicloLectivo2, fechaFinalizacionCicloLectivo2,
				fechaInicioInscripcion2, fechaFinalizacionInscripcion2);

		Integer cantidadDeLugares2 = 50;
		Integer idAula2 = 2;
		Aula aula2 = new Aula(idAula2, cantidadDeLugares2);

		Integer idComision2 = 2;
		String turno2 = "noche";
		Comision comision2 = new Comision(idComision2, bdd, ciclo2, turno2);
		
		Integer valor3 = 7;
		Integer valor4 = 8;
		Nota notaPrimerParcial2 = new Nota(valor3, tipo1);
		
		// Ejecucion
		Boolean agregarMateria = universidad.agregarMateria(pb1);
		Boolean agregarMateria2 = universidad.agregarMateria(bdd);
		Boolean agregarAlumno = universidad.agregarAlumno(alumno);
		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
		Boolean agregarCiclo2 = universidad.agregarCicloLectivo(ciclo2);
		Boolean agregarComision = universidad.agregarComision(comision);
		Boolean agregarComision2 = universidad.agregarComision(comision2);
		universidad.agregarAula(aula);
		universidad.agregarAula(aula2);
		Boolean asignarAula = universidad.asignarAulaAComision(idComision, idAula);
		Boolean asignarAula2 = universidad.asignarAulaAComision(idComision2, idAula2);
		Boolean inscribirAlumno = universidad.inscribirAlumnoAComision(dni, idComision, fechaActual);
		Boolean inscribirAlumno2 = universidad.inscribirAlumnoAComision(dni, idComision2, fechaActual);
		Boolean registrarNota1 = universidad.registrarNota(idComision, dni, notaPrimerParcial);
		Boolean registrarNota2 = universidad.registrarNota(idComision, dni, notaSegundoParcial);
		Boolean registrarNota3 = universidad.registrarNota(idComision2, dni, notaPrimerParcial2);
		ArrayList<Materia> materiasQueFaltanCursar = universidad.obtenerMateriasQueFaltanCursarParaUnAlumno(dni);
				
		// Validacion
		assertTrue(agregarAlumno);
		assertTrue(agregarMateria);
		assertTrue(agregarMateria2);
		assertTrue(agregarCiclo2);
		assertTrue(agregarCiclo);
		assertTrue(agregarComision);
		assertTrue(agregarComision2);
		assertTrue(asignarAula);
		assertTrue(asignarAula2);
		assertTrue(inscribirAlumno);
		assertTrue(inscribirAlumno2);
		assertTrue(registrarNota1);
		assertTrue(registrarNota2);
		assertTrue(registrarNota3);
		assertEquals(1, materiasQueFaltanCursar.size());
		assertEquals(materiasQueFaltanCursar.get(0), bdd);
	}
}
