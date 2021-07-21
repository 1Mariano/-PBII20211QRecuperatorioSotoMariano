package ar.edu.unlam.pb2;

public class PersonaMayor60 extends Persona implements Mayor60 {
	
	private String asociacionMedica;

	public PersonaMayor60(String nombre, String apellido, Integer edad, Integer dni, String asociacionMedica) {
		super(nombre, apellido, edad, dni);
		this.asociacionMedica = asociacionMedica;
	}

	@Override
	public String asociacionMedica() {
		return this.asociacionMedica;
	}

}
