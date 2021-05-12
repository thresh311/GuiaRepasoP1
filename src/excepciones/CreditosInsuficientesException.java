package excepciones;

public class CreditosInsuficientesException extends Exception {

	public String getMessage() {
		return "El alumno no cuenta con los creditos suficientes.";
	}
}
