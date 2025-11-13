package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando el apellido ingresado por el
 * usuario no cumple con las condiciones de validación establecidas.
 * <p>
 * Esta excepción se utiliza para garantizar que el apellido contenga únicamente
 * letras (incluyendo acentos y la letra Ñ), sin números ni símbolos, y que
 * tenga una longitud mínima de cinco caracteres.
 * </p>
 * 
 * <p>
 * <b>Condiciones que generan esta excepción:</b>
 * </p>
 * <ul>
 * <li>El campo del apellido está vacío o es {@code null}.</li>
 * <li>El apellido contiene números, símbolos o espacios indebidos.</li>
 * <li>El apellido tiene menos de cinco caracteres válidos.</li>
 * </ul>
 * 
 * @author
 * @version 1.0
 */
public class LastNameException extends Exception {

	/**
	 * Crea una nueva instancia de {@code LastNameException} con un mensaje
	 * descriptivo por defecto.
	 * <p>
	 * Este mensaje indica que el apellido ingresado no cumple con el formato
	 * requerido.
	 * </p>
	 */
	public LastNameException() {
		super("Invalid last name: minimum 5 letters, no numbers, symbols, or spaces at the beginning or end.");
	}
}
