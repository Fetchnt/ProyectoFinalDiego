package co.edu.unbosque.util.exception;

public class NameException extends Exception{

	public NameException() {
		super("Invalid name: minimum 5 letters, no numbers, symbols, or spaces at the beginning or end.");
	}
}
