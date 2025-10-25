package co.edu.unbosque.util.exception;

public class RegisterPasswordException extends Exception {

	public RegisterPasswordException() {
		super("Invalid password: Password must contain at least 12 characters");
	}
}
