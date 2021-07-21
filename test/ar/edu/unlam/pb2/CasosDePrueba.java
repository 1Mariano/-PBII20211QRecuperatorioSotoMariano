package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasosDePrueba {

	@Test
	public void testQueSePuedaCrearUnaPersonaMayorA60() {
		Mayor60 persona = new PersonaMayor60("Alejandro", "pais", 65, 10390555, "Pami");
		
		assertEquals("Alejandro", ((PersonaMayor60)persona).getNombre());
		assertEquals("pais", ((PersonaMayor60)persona).getApellido());
		assertEquals(65, ((PersonaMayor60)persona).getEdad().intValue());
		assertEquals(10390555, ((PersonaMayor60)persona).getDni().intValue());
		assertEquals("Pami", persona.asociacionMedica());
	}

	@Test
	public void testQueSePuedaCrearUnaPersonaEntre30y60() {
		Entre30y60 persona = new PersonaEntre30y60("Juan", "Duarte", 30, 25005351, "20-25005351-1");
		
		assertEquals("Juan", ((PersonaEntre30y60)persona).getNombre());
		assertEquals("Duarte", ((PersonaEntre30y60)persona).getApellido());
		assertEquals(30, ((PersonaEntre30y60)persona).getEdad().intValue());
		assertEquals(25005351, ((PersonaEntre30y60)persona).getDni().intValue());
		assertEquals("20-25005351-1", persona.getNumeroDeCuit());
	}
	
	@Test
	public void testQueSePuedaCrearUnaPersonaMenora30() {
		Menor30 persona = new PersonaMenor30("Mariano", "Soto", 24, 40390555, false);
		
		assertEquals("Mariano", ((PersonaMenor30)persona).getNombre());
		assertEquals("Soto", ((PersonaMenor30)persona).getApellido());
		assertEquals(24, ((PersonaMenor30)persona).getEdad().intValue());
		assertEquals(40390555, ((PersonaMenor30)persona).getDni().intValue());
		assertFalse(persona.getTieneAlgunTipoDeEnfermedad());
	}
	
	@Test 
	public void testQueLanceUnaExceptionPorqueIntentoIngresarUnaPersonaRepetida() {
		CentroDeVacunacion centro = new CentroDeVacunacion("UNLaM");
		
		try {
			centro.agregarPersonas(new PersonaMenor30("Mariano", "Soto", 24, 40390555, false));
		} catch (LaPersonaYaEstaRegistradaException e1) {
			e1.printStackTrace();
		}
		
		try {
			centro.agregarPersonas(new PersonaMenor30("Mariano", "Soto", 24, 40390555, false));
		} catch (LaPersonaYaEstaRegistradaException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQuePermitaSepararAlasPersonasMayoresDe60() {
		CentroDeVacunacion centro = new CentroDeVacunacion("UNLaM");
		
		try {
			centro.agregarPersonas(new PersonaMayor60("Maria", "Soledad", 65, 11250555, "Pami"));
			centro.agregarPersonas(new PersonaMenor30("Mariano", "Soto", 24, 40390555, false));
			centro.agregarPersonas(new PersonaMenor30("Amanda", "Merida", 15, 45390255, true));
			centro.agregarPersonas(new PersonaEntre30y60("Juan", "Duarte", 30, 25005351, "20-25005351-1"));
			centro.agregarPersonas(new PersonaMayor60("Alejandro", "Pais", 65, 10390555, "Pami"));
			centro.agregarPersonas(new PersonaMayor60("Rocio", "Menta", 72, 10120525, "Pami"));
		} catch (LaPersonaYaEstaRegistradaException e1) {
			e1.printStackTrace();
		}
		
		assertEquals(3, centro.queObtengaUnicamenteLasPersonasMayoresA60().size());
	}
	
	@Test
	public void queSeVerifiqueQueLosMayoresDe60SeAplicaronLaVacuna() {
		CentroDeVacunacion centro = new CentroDeVacunacion("UNLaM");
		
		Mayor60 persona = new PersonaMayor60("Alejandro", "pais", 65, 10390555, "Pami");
		Mayor60 persona1 = new PersonaMayor60("Maria", "pais", 72, 10347555, "Pami");
		Entre30y60 persona2 = new PersonaEntre30y60("Juan", "Duarte", 30, 25005351, "20-25005351-1");
		Menor30 persona3 = new PersonaMenor30("Mariano", "Soto", 24, 40390555, false);
		
		try {
			centro.agregarPersonas((Persona)persona);
			centro.agregarPersonas((Persona)persona1);
			centro.agregarPersonas((Persona)persona2);
			centro.agregarPersonas((Persona)persona3);
			
		} catch (LaPersonaYaEstaRegistradaException e1) {
			e1.printStackTrace();
		}
		
		
		centro.registrNuevaVacunacionMayores60(((Persona) persona).getDni());
		
		assertEquals(Estado.VACUNADO, ((Persona) persona).getEstadoActual());
		assertEquals(1, centro.getPersonasVacunadas().size());

		
	}
	
	@Test
	public void queSeVerifiqueNoSePuedaVacunarUnaPersonaYaVacunada() {
		CentroDeVacunacion centro = new CentroDeVacunacion("UNLaM");
		
		Mayor60 persona = new PersonaMayor60("Alejandro", "pais", 65, 10390555, "Pami");
		Mayor60 persona1 = new PersonaMayor60("Maria", "pais", 72, 10347555, "Pami");
		Entre30y60 persona2 = new PersonaEntre30y60("Juan", "Duarte", 30, 25005351, "20-25005351-1");
		Menor30 persona3 = new PersonaMenor30("Mariano", "Soto", 24, 40390555, false);
		
		try {
			centro.agregarPersonas((Persona)persona);
			centro.agregarPersonas((Persona)persona1);
			centro.agregarPersonas((Persona)persona2);
			centro.agregarPersonas((Persona)persona3);
			
		} catch (LaPersonaYaEstaRegistradaException e1) {
			e1.printStackTrace();
		}
		
		
		centro.registrNuevaVacunacion(((Persona) persona).getDni());
		centro.registrNuevaVacunacion(((Persona) persona).getDni());
		
	
		assertEquals(1, centro.getPersonasVacunadas().size());

		
	}
}
