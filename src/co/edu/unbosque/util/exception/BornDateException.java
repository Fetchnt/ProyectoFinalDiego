package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando la fecha de nacimiento ingresada
 * no cumple con los criterios de validación establecidos.
 * <p>
 * Esta excepción puede producirse si:
 * <ul>
 * <li>El formato de la fecha no corresponde a <b>DD/MM/YYYY</b>.</li>
 * <li>La fecha contiene letras o símbolos no válidos.</li>
 * <li>El usuario es menor de 18 años.</li>
 * </ul>
 * </p>
 * 
 * @author Juan Cabarcas
 * @version 1.0
 */
public class BornDateException extends Exception {

	/**
	 * Crea una nueva instancia de {@code BornDateException} con un mensaje
	 * descriptivo por defecto que indica las causas posibles del error.
	 */
	public BornDateException() {
		super("Invalid born date: You must be 18+ years older, please introduce the correct format DD/MM/YYYY and no letters or symbols are accepted");
	}
}
