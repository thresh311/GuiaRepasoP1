package excepciones;

public class TallerCompletoException extends Exception {

	public String getMessage() {
		return "El cupo del taller ya se encuentra completo";
	}
	
}
