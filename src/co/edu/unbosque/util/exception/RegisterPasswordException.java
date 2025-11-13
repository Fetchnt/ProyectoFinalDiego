package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando la contraseña ingresada por el
 * usuario no cumple con los requisitos mínimos de seguridad establecidos
 * durante el registro.
 * <p>
 * Esta excepción asegura que las contraseñas tengan una longitud mínima de 12
 * caracteres, con el fin de mantener un nivel básico de fortaleza y protección
 * en el sistema.
 * </p>
 *
 * <p>
 * <b>Se lanza esta excepción cuando:</b>
 * </p>
 * <ul>
 * <li>La contraseña es {@code null} o está vacía.</li>
 * <li>La contraseña contiene menos de 12 caracteres.</li>
 * </ul>
 *
 *
 * @author Juan Cabarcas
 * @version 1.0
 */
public class RegisterPasswordException extends Exception {

	/**
	 * Crea una nueva instancia de {@code RegisterPasswordException} con un mensaje
	 * de error predeterminado que indica que la contraseña es inválida.
	 */
	public RegisterPasswordException() {
		super("Invalid password: Password must contain at least 12 characters");
	}
}
