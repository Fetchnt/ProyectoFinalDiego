package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando el usuario no realiza una
 * selección válida en un componente {@code JComboBox}.
 * <p>
 * Esta excepción puede producirse si:
 * <ul>
 * <li>No se selecciona ninguna opción en el combo box (valor nulo o
 * vacío).</li>
 * <li>El valor seleccionado es un marcador por defecto, como <b>"..."</b>.</li>
 * </ul>
 * </p>
 * 
 * @author Juan Cabarcas
 * @version 1.0
 */
public class ComboBoxException extends Exception {

	/**
	 * Crea una nueva instancia de {@code ComboBoxException} con un mensaje
	 * descriptivo por defecto que indica que se debe elegir una opción válida.
	 */
	public ComboBoxException() {
		super("Invalid combobox selection: One of the selection boxes is null, please choose an option");
	}
}
