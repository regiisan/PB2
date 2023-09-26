package ar.edu.unlam.materia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import ar.edu.unlam.dominio.*;
import org.junit.Test;

public class TestUniversidad {

	// universidad inscriba al alumno
	// universidad registre materia
	// universidad inscriba alumno

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
	public void queNoSePuedaRegistrarUnCicloLectivoCuandoSeSuperponenFechas() {

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

		LocalDate fechaInicioCicloLectivo2 = LocalDate.of(2023, 9, 10);
		LocalDate fechaFinalizacionCicloLectivo2 = LocalDate.of(2023, 12, 3);
		LocalDate fechaInicioInscripcion2 = LocalDate.of(2023, 7, 25);
		LocalDate fechaFinalizacionInscripcion2 = LocalDate.of(2023, 7, 30);
		CicloLectivo ciclo2 = new CicloLectivo(id, fechaInicioCicloLectivo, fechaFinalizacionCicloLectivo,
				fechaInicioInscripcion, fechaFinalizacionInscripcion);

		// Ejecucion
		universidad.agregarCicloLectivo(ciclo);
		Boolean registroNoExitoso = universidad.agregarCicloLectivo(ciclo2);

		// Validacion
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
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo,fechaFinalizacionCicloLectivo,fechaInicioInscripcion,fechaFinalizacionInscripcion);
		
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
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo,fechaFinalizacionCicloLectivo,fechaInicioInscripcion,fechaFinalizacionInscripcion);
		
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
		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo,fechaFinalizacionCicloLectivo,fechaInicioInscripcion,fechaFinalizacionInscripcion);
		
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
	
//	@Test
//	public void queSePuedaAsignarUnProfesorAUnaComision() {
//
//		// Preparacion
//		String nombre = "Unlam";
//		Universidad universidad = new Universidad(nombre);
//		
//		String nombre2 = "PB2";
//		Integer codigo = 2;
//		Materia pb2 = new Materia(nombre2, codigo);
//		
//		Integer idCiclo = 1;
//		LocalDate fechaInicioCicloLectivo = LocalDate.of(2023, 8, 16);
//		LocalDate fechaFinalizacionCicloLectivo = LocalDate.of(2023, 12, 4);
//		LocalDate fechaInicioInscripcion = LocalDate.of(2023, 7, 25);
//		LocalDate fechaFinalizacionInscripcion = LocalDate.of(2023, 7, 30);
//		CicloLectivo ciclo = new CicloLectivo(idCiclo, fechaInicioCicloLectivo,fechaFinalizacionCicloLectivo,fechaInicioInscripcion,fechaFinalizacionInscripcion);
//		
//		Integer dni = 2243423;
//		String nombreProfesor = "Juan";
//		String apellidoProfesor = "Perez";
//		Profesor profesor = new Profesor(dni, nombreProfesor, apellidoProfesor);
//		
//		Integer idComision = 1;
//		String turno = "mañana";
//		Comision comision = new Comision(idComision, pb2, ciclo, turno);
//
//		// Ejecucion
//		Boolean agregarProfesor = universidad.agregarProfesor(profesor);
//		Boolean agregarMateria = universidad.agregarMateria(pb2);
//		Boolean agregarCiclo = universidad.agregarCicloLectivo(ciclo);
//		Boolean agregarComision = universidad.agregarComision(comision);
//		Boolean asignarProfesor = universidad.asignarProfesorAComision(idComision, dni);
//
//		// Validacion
//		assertTrue(agregarProfesor);
//		assertTrue(agregarMateria);
//		assertTrue(agregarCiclo);
//		assertTrue(agregarComision);
//		assertTrue(asignarProfesor);
//	}
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
		Materia materiaCorrelativa = new Materia(nombreMateria, idCorrelativa);

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
		Materia materiaCorrelativa = new Materia(nombreMateria, idCorrelativa);

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
		Materia materiaCorrelativa = new Materia(nombreMateria, idCorrelativa);

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
		Materia materiaCorrelativa = new Materia(nombreMateria, idCorrelativa);

		// Ejecucion
		universidad.agregarMateria(materia);
		universidad.agregarMateria(materiaCorrelativa);
		universidad.agregarCorrelatividad(idMateria, idCorrelativa);
		Boolean registroExitoso = universidad.eliminarCorrelatividad(idMateria, idCorrelativa);
		
		// Validacion
		assertTrue(registroExitoso);
	}
	
	
	
	
	
	
	
}
