package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

/**
 * Clase que representa el objeto de transferencia de datos (DTO) para usuarias
 * de tipo mujer en el sistema. <br>
 * <b>pre:</b> Debe existir una instancia válida de {@link User}. <br>
 * <b>post:</b> Permite transportar información de una usuaria femenina entre
 * capas del sistema.
 * 
 */
public class WomenDTO extends User implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6033022692515366899L;

	/** Indica si la usuaria ha tenido divorcios. */
	private boolean hadDivorces;

	/** Propiedades utilizadas para la internacionalización o configuración. */
	private transient Properties prop;

	/**
	 * Constructor por defecto.
	 */
	public WomenDTO() {
		super();
	}

	/**
	 * Constructor que inicializa los atributos de divorcios e internacionalización.
	 * 
	 * @param hadDivorces Indica si la usuaria ha tenido divorcios.
	 * @param prop        Propiedades de idioma o configuración.
	 */
	public WomenDTO(boolean hadDivorces, Properties prop) {
		super();
		this.hadDivorces = hadDivorces;
		this.prop = prop;
	}

	/**
	 * Constructor completo con todos los atributos heredados y propios.
	 * 
	 * @param name                Nombre del usuario.
	 * @param lastName            Apellido del usuario.
	 * @param alias               Alias o apodo del usuario.
	 * @param bornDate            Fecha de nacimiento.
	 * @param stature             Estatura.
	 * @param email               Correo electrónico.
	 * @param gender              Género.
	 * @param sexualOrientation   Orientación sexual.
	 * @param profilePictureRoute Ruta de la foto de perfil.
	 * @param country             País de origen.
	 * @param password            Contraseña de acceso.
	 * @param hadDivorces         Indica si ha tenido divorcios.
	 * @param prop                Propiedades de idioma o configuración.
	 */
	public WomenDTO(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password,
			boolean hadDivorces, Properties prop) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
		this.hadDivorces = hadDivorces;
		this.prop = prop;
	}

	/**
	 * Constructor sin propiedades adicionales.
	 * 
	 * @param name                Nombre del usuario.
	 * @param lastName            Apellido del usuario.
	 * @param alias               Alias o apodo del usuario.
	 * @param bornDate            Fecha de nacimiento.
	 * @param stature             Estatura.
	 * @param email               Correo electrónico.
	 * @param gender              Género.
	 * @param sexualOrientation   Orientación sexual.
	 * @param profilePictureRoute Ruta de la foto de perfil.
	 * @param country             País de origen.
	 * @param password            Contraseña de acceso.
	 */
	public WomenDTO(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
	}

	/**
	 * Verifica si la usuaria ha tenido divorcios.
	 * 
	 * @return {@code true} si ha tenido divorcios, {@code false} en caso contrario.
	 */
	public boolean isHadDivorces() {
		return hadDivorces;
	}

	/**
	 * Asigna si la usuaria ha tenido divorcios.
	 * 
	 * @param hadDivorces Valor booleano que indica si ha tenido divorcios.
	 */
	public void setHadDivorces(boolean hadDivorces) {
		this.hadDivorces = hadDivorces;
	}

	/**
	 * Asigna las propiedades de internacionalización.
	 * 
	 * @param prop Propiedades de idioma o configuración.
	 */
	public void internacionalizacion(Properties prop) {
		this.prop = prop;
	}

	/**
	 * Retorna una representación en texto del objeto {@code WomenDTO}.
	 * 
	 * @return Cadena con los datos personales y estado de divorcios.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n Had divorces: " + hadDivorces + "\n==========================================";
	}
}
