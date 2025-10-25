package co.edu.unbosque.util.exception;

public class BornDateException extends Exception {

	public BornDateException() {
		super("Invalid born date: You must be 18+ years older, and no letters or symbols are accepted");
	}
}
