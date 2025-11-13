package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando el usuario no ha seleccionado
 * una imagen de perfil durante el proceso de registro o actualización de datos.
 * <p>
 * Esta excepción garantiza que todos los usuarios tengan una imagen de perfil
 * antes de continuar con la creación o modificación de su cuenta.
 * </p>
 * 
 * <p><b>Condiciones que generan esta excepción:</b></p>
 * <ul>
 *   <li>El campo de la ruta de la imagen es {@code null}.</li>
 *   <li>El campo de la ruta de la imagen está vacío.</li>
 * </ul>
 * 
 * @author  Juan Cabarcas
 * @version 1.0
 */
public class ImageNotSelectedException extends Exception {

    /**
     * Crea una nueva instancia de {@code ImageNotSelectedException} con un mensaje
     * descriptivo por defecto que indica que el usuario debe seleccionar una imagen
     * de perfil antes de continuar.
     */
    public ImageNotSelectedException() {
        super("Invalid image: You must select a profile picture before continuing");
    }
}
