package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

/**
 * Clase que representa a un usuario de tipo hombre en el sistema. <b>pre:</b>
 * Debe existir un usuario con datos válidos. <br>
 * <b>post:</b> Crea o gestiona la información del usuario masculino.
 * 
 */
public class Men extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	private long mensualIncome;
	private Properties prop;

	/**
	 * Constructor por defecto.
	 */
	public Men() {
	}

	/**
	 * Constructor que inicializa ingresos y propiedades.
	 * 
	 * @param mensualIncome Ingreso mensual del usuario.
	 * @param prop          Propiedades de internacionalización.
	 */
	public Men(long mensualIncome, Properties prop) {
		super();
		this.mensualIncome = mensualIncome;
		this.prop = prop;
	}

	/**
	 * Constructor completo con todos los atributos.
	 * 
	 * @param name                Nombre del usuario.
	 * @param lastName            Apellido del usuario.
	 * @param alias               Alias del usuario.
	 * @param bornDate            Fecha de nacimiento.
	 * @param stature             Estatura.
	 * @param email               Correo electrónico.
	 * @param gender              Género.
	 * @param sexualOrientation   Orientación sexual.
	 * @param profilePictureRoute Ruta de la foto de perfil.
	 * @param country             País de origen.
	 * @param password            Contraseña.
	 * @param mensualIncome       Ingreso mensual.
	 * @param prop                Propiedades de internacionalización.
	 */
	public Men(String name, String lastName, String alias, String bornDate, String stature, String email, String gender,
			String sexualOrientation, String profilePictureRoute, String country, String password, long mensualIncome,
			Properties prop) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
		this.mensualIncome = mensualIncome;
		this.prop = prop;
	}

	/**
	 * Constructor sin ingresos ni propiedades.
	 */
	public Men(String name, String lastName, String alias, String bornDate, String stature, String email, String gender,
			String sexualOrientation, String profilePictureRoute, String country, String password) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
	}

	/**
	 * Obtiene el ingreso mensual.
	 * 
	 * @return Ingreso mensual del usuario.
	 */
	public long getMensualIncome() {
		return mensualIncome;
	}

	/**
	 * Establece el ingreso mensual.
	 * 
	 * @param mensualIncome Ingreso mensual a asignar.
	 */
	public void setMensualIncome(long mensualIncome) {
		this.mensualIncome = mensualIncome;
	}

	/**
	 * Asigna las propiedades de internacionalización.
	 * 
	 * @param prop Propiedades de idioma o configuración.
	 */
	public void internacionalizacion(Properties prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return super.toString() + "\n - Mensual Income: " + mensualIncome
				+ "\n==========================================";
	}
}
