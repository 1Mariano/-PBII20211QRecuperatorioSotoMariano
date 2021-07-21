package ar.edu.unlam.pb2;

public class LaPersonaYaEstaRegistradaException extends Exception {
	public LaPersonaYaEstaRegistradaException() {
		super("La persona no puede volver a ser registrada porque ya lo está");
	}
}
