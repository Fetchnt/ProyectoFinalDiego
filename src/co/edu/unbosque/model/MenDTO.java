package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

/**
 * Clase que representa un usuario de tipo hombre dentro del sistema.
 * <b>pre:</b> Debe existir un usuario con información válida. <br>
 * <b>post:</b> Crea o manipula la información correspondiente al usuario
 * masculino.
 * 
 */
public class MenDTO extends User implements Serializable {

	private static final long serialVersionUID = 8703244232885622082L;
	private long mensualIncome;
	private Properties prop;

	/**
	 * Constructor por defecto. <b>pre:</b> No se requiere información previa. <br>
	 * <b>post:</b> Crea un objeto vacío de tipo MenDTO.
	 */
	public MenDTO() {
		super();
	}

	/**
	 * Constructor que inicializa los ingresos y propiedades.
	 * 
	 * @param mensualIncome Ingreso mensual del usuario.
	 * @param prop          Propiedades de internacionalización.
	 */
	public MenDTO(long mensualIncome, Properties prop) {
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
	public MenDTO(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password,
			long mensualIncome, Properties prop) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
		this.mensualIncome = mensualIncome;
		this.prop = prop;
	}

	/**
	 * Constructor que inicializa sin ingresos ni propiedades.
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
	 */
	public MenDTO(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password) {
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
