package co.edu.unbosque.model;

import java.util.Properties;

/**
 * Clase abstracta que representa a un usuario genérico dentro del sistema.
 * <b>pre:</b> Debe existir un conjunto de datos válidos para crear un usuario.
 * <br>
 * <b>post:</b> Se crea o gestiona la información básica de un usuario, tanto
 * hombre como mujer.
 * 
 */
public abstract class User {

	/** Nombre del usuario. */
	private String name;

	/** Apellido del usuario. */
	private String lastName;

	/** Alias o apodo del usuario. */
	private String alias;

	/** Fecha de nacimiento del usuario. */
	private String bornDate;

	/** Estatura del usuario. */
	private String stature;

	/** Correo electrónico del usuario. */
	private String email;

	/** Género del usuario. */
	private String gender;

	/** Orientación sexual del usuario. */
	private String sexualOrientation;

	/** Ruta de la imagen de perfil del usuario. */
	private String profilePictureRoute;

	/** País de origen del usuario. */
	private String country;

	/** Contraseña del usuario. */
	private String password;

	/** Número de "likes" recibidos por el usuario. */
	private int likes;

	/** Propiedades de internacionalización o configuración. */
	private Properties prop;

	/**
	 * Constructor por defecto. Inicializa el contador de "likes" en 0.
	 */
	public User() {
		super();
		this.likes = 0;
	}

	/**
	 * Constructor que inicializa todos los atributos del usuario.
	 * 
	 * @param name                Nombre del usuario.
	 * @param lastName            Apellido del usuario.
	 * @param alias               Alias o apodo del usuario.
	 * @param bornDate            Fecha de nacimiento del usuario.
	 * @param stature             Estatura del usuario.
	 * @param email               Correo electrónico del usuario.
	 * @param gender              Género del usuario.
	 * @param sexualOrientation   Orientación sexual del usuario.
	 * @param profilePictureRoute Ruta de la imagen de perfil.
	 * @param country             País del usuario.
	 * @param password            Contraseña del usuario.
	 */
	public User(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.alias = alias;
		this.bornDate = bornDate;
		this.stature = stature;
		this.email = email;
		this.gender = gender;
		this.sexualOrientation = sexualOrientation;
		this.profilePictureRoute = profilePictureRoute;
		this.country = country;
		this.password = password;
		this.likes = 0;
	}

	/**
	 * Obtiene el nombre del usuario.
	 * 
	 * @return Nombre del usuario.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Asigna el nombre del usuario.
	 * 
	 * @param name Nombre a asignar.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Obtiene el apellido del usuario.
	 * 
	 * @return Apellido del usuario.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Asigna el apellido del usuario.
	 * 
	 * @param lastName Apellido a asignar.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Obtiene el alias del usuario.
	 * 
	 * @return Alias del usuario.
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Asigna el alias del usuario.
	 * 
	 * @param alias Alias a asignar.
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Obtiene la fecha de nacimiento del usuario.
	 * 
	 * @return Fecha de nacimiento en formato texto.
	 */
	public String getBornDate() {
		return bornDate;
	}

	/**
	 * Asigna la fecha de nacimiento del usuario.
	 * 
	 * @param bornDate Fecha de nacimiento a asignar.
	 */
	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}

	/**
	 * Obtiene la estatura del usuario.
	 * 
	 * @return Estatura en formato texto.
	 */
	public String getStature() {
		return stature;
	}

	/**
	 * Asigna la estatura del usuario.
	 * 
	 * @param stature Estatura a asignar.
	 */
	public void setStature(String stature) {
		this.stature = stature;
	}

	/**
	 * Obtiene el correo electrónico del usuario.
	 * 
	 * @return Correo electrónico del usuario.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Asigna el correo electrónico del usuario.
	 * 
	 * @param email Correo electrónico a asignar.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene el género del usuario.
	 * 
	 * @return Género del usuario.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Asigna el género del usuario.
	 * 
	 * @param gender Género a asignar.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Obtiene la orientación sexual del usuario.
	 * 
	 * @return Orientación sexual del usuario.
	 */
	public String getSexualOrientation() {
		return sexualOrientation;
	}

	/**
	 * Asigna la orientación sexual del usuario.
	 * 
	 * @param sexualOrientation Orientación sexual a asignar.
	 */
	public void setSexualOrientation(String sexualOrientation) {
		this.sexualOrientation = sexualOrientation;
	}

	/**
	 * Obtiene la ruta de la foto de perfil.
	 * 
	 * @return Ruta de la imagen de perfil.
	 */
	public String getProfilePictureRoute() {
		return profilePictureRoute;
	}

	/**
	 * Asigna la ruta de la foto de perfil del usuario.
	 * 
	 * @param profilePictureRoute Ruta de la imagen a asignar.
	 */
	public void setProfilePictureRoute(String profilePictureRoute) {
		this.profilePictureRoute = profilePictureRoute;
	}

	/**
	 * Obtiene el país de origen del usuario.
	 * 
	 * @return País del usuario.
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Asigna el país de origen del usuario.
	 * 
	 * @param country País a asignar.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Obtiene la contraseña del usuario.
	 * 
	 * @return Contraseña del usuario.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Asigna la contraseña del usuario.
	 * 
	 * @param password Contraseña a asignar.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Obtiene la cantidad de "likes" del usuario.
	 * 
	 * @return Número de "likes".
	 */
	public int getLikes() {
		return likes;
	}

	/**
	 * Asigna la cantidad de "likes" del usuario.
	 * 
	 * @param likes Cantidad de "likes" a establecer.
	 */
	public void setLikes(int likes) {
		this.likes = likes;
	}

	/**
	 * Incrementa en 1 el contador de "likes" del usuario. <b>post:</b> El número de
	 * "likes" aumenta en una unidad.
	 */
	public void incrementarLikes() {
		this.likes++;
	}

	/**
	 * Obtiene las propiedades de internacionalización del usuario.
	 * 
	 * @return Objeto {@link Properties} asociado al usuario.
	 */
	public Properties getProp() {
		return prop;
	}

	/**
	 * Asigna las propiedades de internacionalización del usuario.
	 * 
	 * @param prop Propiedades a asignar.
	 */
	public void setProp(Properties prop) {
		this.prop = prop;
	}

	/**
	 * Retorna una representación textual del usuario con todos sus datos básicos.
	 * 
	 * @return Cadena de texto con la información del usuario.
	 */
	@Override
	public String toString() {
		return "==========================================\n - Name: " + name + "\n - last Name: " + lastName
				+ "\n - Nickname" + alias + "\n -  Born Date: " + bornDate + "\n - Stature: " + stature + "\n - Email: "
				+ email + "\n - Gender: " + gender + "\n - Sexual Orientation: " + sexualOrientation + " \n - Country: "
				+ country + "\n - Password: " + password + "\n - Likes: " + likes;
	}
}
