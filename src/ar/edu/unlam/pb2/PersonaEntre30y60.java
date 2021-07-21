package ar.edu.unlam.pb2;

public class PersonaEntre30y60 extends Persona implements Entre30y60 {

	private String numeroDeCuit;
	
	public PersonaEntre30y60(String nombre, String apellido, Integer edad, Integer dni, String numeroDeCuit) {
		super(nombre, apellido, edad, dni);
		this.numeroDeCuit = numeroDeCuit;
		
	}

	@Override
	public String getNumeroDeCuit() {
		return this.numeroDeCuit;
	}

}
