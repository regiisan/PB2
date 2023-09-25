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
		Aula aulaEsperada = new Aula(id,cantidadDeLugares);
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
		CicloLectivo ciclo = new CicloLectivo(id, fechaInicioCicloLectivo,fechaFinalizacionCicloLectivo,fechaInicioInscripcion,fechaFinalizacionInscripcion);

		// Ejecucion
		Boolean registroExitoso = universidad.agregarCicloLectivo(ciclo); // cambie en universidad

		// Validacion
		assertTrue(registroExitoso);
	}
	
	

}
