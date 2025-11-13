package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando un correo electrónico no cumple
 * con las reglas de validación establecidas en el sistema.
 * <p>
 * Esta excepción puede producirse si:
 * <ul>
 *   <li>El campo del correo electrónico está vacío o es nulo.</li>
 *   <li>El formato del correo no es válido (por ejemplo, sin '@' o con caracteres no permitidos).</li>
 *   <li>El dominio no pertenece a los permitidos (como gmail.com, hotmail.com, outlook.com, yahoo.com, unbosque.edu.co).</li>
 * </ul>
 * </p>
 * 
 * @author  Juan cabarcas
 * @version 1.0
 */
public class EmailException extends Exception {

    /**
     * Crea una nueva instancia de {@code EmailException} con un mensaje
     * descriptivo por defecto que indica que el correo electrónico es inválido.
     */
    public EmailException() {
        super("Invalid Email: Please enter a valid email with the correct format and allowed domain");
    }
}
