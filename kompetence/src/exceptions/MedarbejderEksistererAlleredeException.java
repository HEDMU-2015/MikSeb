package exceptions;

public class MedarbejderEksistererAlleredeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MedarbejderEksistererAlleredeException(String message){
		super(message);
	}
}