package co.edu.unbosque.util.exception;

public class ImageNotSelectedException extends Exception {

	public ImageNotSelectedException() {
		super("Invalid image: You must select a profile picture before continuing");
	}

}
