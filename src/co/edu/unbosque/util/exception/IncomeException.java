package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando los ingresos proporcionados por
 * el usuario son inválidos o no cumplen con las condiciones establecidas.
 * <p>
 * Esta excepción se utiliza para validar que el valor ingresado como ingreso
 * mensual sea numérico, positivo y cumpla con los límites razonables definidos
 * por país.
 * </p>
 * 
 * <p>
 * <b>Condiciones que generan esta excepción:</b>
 * </p>
 * <ul>
 * <li>El campo de ingreso está vacío o es {@code null}.</li>
 * <li>El valor ingresado no es un número válido.</li>
 * <li>El ingreso es negativo o menor al mínimo permitido según el país.</li>
 * </ul>
 * 
 * @author Juan Cabarcas
 * @version 1.0
 */
public class IncomeException extends Exception {

	/**
	 * Crea una nueva instancia de {@code IncomeException} con un mensaje
	 * descriptivo por defecto.
	 * <p>
	 * Este constructor invoca el de la superclase {@link Exception} con el mensaje
	 * por defecto.
	 * </p>
	 */
	public IncomeException() {
		super("Invalid income: The value must be numeric, positive, and above the minimum allowed for the selected country.");
	}
}
