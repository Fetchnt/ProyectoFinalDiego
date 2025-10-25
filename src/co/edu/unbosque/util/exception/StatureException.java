package co.edu.unbosque.util.exception;

public class StatureException extends Exception {

	public StatureException() {
		super("Invalid stature: Accepted heights between 0.6m - 2.10m and no letters or whitespaces.");
	}
}
