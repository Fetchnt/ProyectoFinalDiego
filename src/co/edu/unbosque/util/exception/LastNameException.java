package co.edu.unbosque.util.exception;

public class LastNameException extends Exception {

	public LastNameException() {
		super("Invalid last name: minimum 5 letters, no numbers, symbols, or spaces at the beginning or end.");
	}
}
