package co.edu.unbosque.util.exception;

public class NickNameException extends Exception{

	public NickNameException() {
		super("Invalid nickname: minimum 5 letters, no numbers, symbols, or spaces at the beginning or end.");
	}
}
