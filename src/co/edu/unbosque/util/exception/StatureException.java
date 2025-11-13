package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando la estatura ingresada por el usuario
 * no cumple con el formato o los límites permitidos durante el registro.
 * <p>
 * Esta excepción asegura que los valores de estatura sean válidos numéricamente
 * y se encuentren dentro del rango lógico aceptado por el sistema.
 * </p>
 *
 * <p><b>Se lanza esta excepción cuando:</b></p>
 * <ul>
 *   <li>El valor ingresado está vacío o es {@code null}.</li>
 *   <li>El valor contiene letras, símbolos o espacios.</li>
 *   <li>La estatura es menor que 0.60 metros o mayor que 2.10 metros.</li>
 * </ul>
 *
 * @author  Juan Cabarcas
 * @version 1.0
 */
public class StatureException extends Exception {

    /**
     * Crea una nueva instancia de {@code StatureException} con un mensaje
     * de error predeterminado que indica los rangos válidos y el formato correcto.
     */
    public StatureException() {
        super("Invalid stature: Accepted heights between 0.6m - 2.10m and no letters or whitespaces.");
    }
}
