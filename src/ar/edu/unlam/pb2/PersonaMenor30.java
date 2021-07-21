package ar.edu.unlam.pb2;

public class PersonaMenor30 extends Persona implements Menor30 {

	private Boolean tieneAlgunTipoDeEnfermedad;
	
	public PersonaMenor30(String nombre, String apellido, Integer edad, Integer dni, Boolean tieneAlgunTipoDeEnfermedad) {
		super(nombre, apellido, edad, dni);
		this.tieneAlgunTipoDeEnfermedad = tieneAlgunTipoDeEnfermedad;
	}

	@Override
	public Boolean getTieneAlgunTipoDeEnfermedad() {
		return this.tieneAlgunTipoDeEnfermedad;
	}

}
