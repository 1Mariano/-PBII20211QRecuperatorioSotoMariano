package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CentroDeVacunacion {

	private String nombre;
	private Set<Persona> filaDePersona;
	private Map<Integer, Persona> PersonasVacunadas;
	private Integer contadorDeVacunados;
	
	public CentroDeVacunacion(String nombre) {
		this.nombre = nombre;
		this.filaDePersona = new HashSet<>();
		this.PersonasVacunadas = new HashMap<Integer, Persona>();
		this.contadorDeVacunados = 0;
	}
	
	public void agregarPersonas(Persona nuevo) throws LaPersonaYaEstaRegistradaException {
		if(this.filaDePersona.contains(nuevo))
		{
			throw new LaPersonaYaEstaRegistradaException();
		}
		this.filaDePersona.add(nuevo);
	}
	
	public List<Persona> queObtengaUnicamenteLasPersonasMayoresA60() {
		ArrayList<Persona> personaObtenidas = new ArrayList<>(); 
		for (Persona persona : filaDePersona) {
			if(persona instanceof Mayor60) {
				personaObtenidas.add(persona); 
			}
		}
		return personaObtenidas;
	}
	
	public Persona buscarPersona(Integer dni) {
		for (Persona persona : filaDePersona) {
			if(persona.getDni().equals(dni))
			{
				return persona;
			}
		}
		return null;
	}
	
	public Integer registrNuevaVacunacion(Integer dni) {
		Persona persona = buscarPersona(dni);
		if(persona != null && persona.getEstadoActual() == Estado.NOVACUNADO)
		{
		this.PersonasVacunadas.put(++contadorDeVacunados, persona);
		persona.setEstadoActual(Estado.VACUNADO);
		}
		return contadorDeVacunados;
	}
	
	public Integer registrNuevaVacunacionMayores60(Integer dni) {
		Persona persona = buscarPersona(dni);
		if(persona != null && persona.getEstadoActual() == Estado.NOVACUNADO && persona instanceof Mayor60)
		{
		this.PersonasVacunadas.put(++contadorDeVacunados, persona);
		persona.setEstadoActual(Estado.VACUNADO);
		}
		return contadorDeVacunados;
	}

	public Map<Integer, Persona> getPersonasVacunadas() {
		return PersonasVacunadas;
	}

	public void setPersonasVacunadas(Map<Integer, Persona> personasVacunadas) {
		PersonasVacunadas = personasVacunadas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Persona> getFilaDePersona() {
		return filaDePersona;
	}

	public void setFilaDePersona(Set<Persona> filaDePersona) {
		this.filaDePersona = filaDePersona;
	}
	
	
}
