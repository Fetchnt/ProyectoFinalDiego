package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando el apodo o alias (nickname)
 * ingresado por el usuario no cumple con los criterios de validación
 * establecidos.
 * <p>
 * Esta excepción garantiza que el alias esté compuesto únicamente por letras
 * válidas (incluyendo acentos y la letra Ñ), sin números, símbolos o espacios
 * indebidos, y que tenga una longitud mínima de cinco caracteres.
 * </p>
 *
 * <p>
 * <b>Se lanza esta excepción cuando:</b>
 * </p>
 * <ul>
 * <li>El alias está vacío o es {@code null}.</li>
 * <li>El alias contiene números, símbolos o espacios al inicio o al final.</li>
 * <li>El alias tiene menos de cinco letras válidas.</li>
 * </ul>
 *
 * @author Juan Cabarcas
 * @version 1.0
 */
public class NickNameException extends Exception {

	/**
	 * Crea una nueva instancia de {@code NickNameException} con un mensaje de error
	 * predeterminado que indica que el alias ingresado es inválido.
	 */
	public NickNameException() {
		super("Invalid nickname: minimum 5 letters, no numbers, symbols, or spaces at the beginning or end.");
	}
}
