package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando el nombre ingresado por el
 * usuario no cumple con los criterios de validación establecidos.
 * <p>
 * Esta excepción asegura que el nombre solo contenga letras (incluyendo acentos
 * y la letra Ñ), sin números, símbolos o espacios indebidos, y que tenga al
 * menos cinco caracteres válidos.
 * </p>
 *
 * <p>
 * <b>Se lanza esta excepción cuando:</b>
 * </p>
 * <ul>
 * <li>El nombre está vacío o es {@code null}.</li>
 * <li>El nombre contiene números, símbolos o espacios al inicio o al
 * final.</li>
 * <li>El nombre tiene menos de cinco letras válidas.</li>
 * </ul>
 *
 * @author Juan Cabarcas
 * @version 1.0
 */
public class NameException extends Exception {

	/**
	 * Crea una nueva instancia de {@code NameException} con un mensaje de error
	 * predeterminado que describe el formato incorrecto del nombre ingresado.
	 */
	public NameException() {
		super("Invalid name: minimum 5 letters, no numbers, symbols, or spaces at the beginning or end.");
	}
}
