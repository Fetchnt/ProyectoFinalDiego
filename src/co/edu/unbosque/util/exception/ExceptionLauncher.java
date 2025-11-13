package co.edu.unbosque.util.exception;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Clase utilitaria encargada de verificar la validez de los datos ingresados
 * durante el registro o validaciones del sistema.
 * <p>
 * Cada método realiza una verificación específica y, en caso de no cumplir con
 * las condiciones establecidas, lanza una excepción personalizada
 * correspondiente.
 * </p>
 * 
 * @author Juan Cabarcas
 * @version 1.0
 */
public class ExceptionLauncher {

	/**
	 * Verifica que el nombre no sea nulo, vacío y que cumpla con el formato
	 * permitido. Solo se permiten letras (mayúsculas, minúsculas y acentuadas) y
	 * espacios.
	 * 
	 * @param s el nombre a verificar
	 * @throws NameException si el nombre es inválido o demasiado corto
	 */
	public static void verifyName(String s) throws NameException {
		if (s == null || s.isEmpty()) {
			throw new NameException();
		}
		if (!s.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || s.length() < 5) {
			throw new NameException();
		}
	}

	/**
	 * Verifica que el apellido no sea nulo, vacío y que cumpla con el formato
	 * permitido. Solo se permiten letras y espacios.
	 * 
	 * @param s el apellido a verificar
	 * @throws LastNameException si el apellido es inválido o demasiado corto
	 */
	public static void verifyLastName(String s) throws LastNameException {
		if (s == null || s.isEmpty()) {
			throw new LastNameException();
		}
		if (!s.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || s.length() < 5) {
			throw new LastNameException();
		}
	}

	/**
	 * Verifica que el alias o apodo no sea nulo, vacío y que cumpla con el formato
	 * permitido.
	 * 
	 * @param s el alias a verificar
	 * @throws NickNameException si el alias es inválido o demasiado corto
	 */
	public static void verifyNickname(String s) throws NickNameException {
		if (s == null || s.isEmpty()) {
			throw new NickNameException();
		}
		if (!s.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || s.length() < 5) {
			throw new NickNameException();
		}
	}

	/**
	 * Verifica que la estatura sea un valor numérico válido dentro del rango
	 * permitido (0.60 a 2.10 metros).
	 * 
	 * @param s la estatura ingresada como cadena
	 * @throws StatureException si la estatura no es válida o está fuera del rango
	 *                          permitido
	 */
	public static void verifyStature(String s) throws StatureException {
		if (s == null || s.isEmpty()) {
			throw new StatureException();
		}

		if (!s.matches("^[0-9]+(\\.[0-9]+)?$")) {
			throw new StatureException();
		}

		try {
			float estatura = Float.parseFloat(s);

			if (estatura < 0.60f || estatura > 2.10f) {
				throw new StatureException();
			}
		} catch (NumberFormatException e) {
			throw new StatureException();
		}
	}

	/**
	 * Verifica que el correo electrónico tenga un formato válido y pertenezca a uno
	 * de los dominios permitidos.
	 * 
	 * <p>
	 * Dominios válidos: gmail.com, hotmail.com, outlook.com, yahoo.com,
	 * unbosque.edu.co
	 * </p>
	 * 
	 * @param s el correo electrónico a verificar
	 * @throws EmailException si el formato o dominio del correo no es válido
	 */
	public static void verifyEmail(String s) throws EmailException {
		if (s == null || s.isEmpty()) {
			throw new EmailException();
		}

		if (s.contains(" ")) {
			throw new EmailException();
		}

		String[] partes = s.split("@");
		if (partes.length != 2) {
			throw new EmailException();
		}

		String usuario = partes[0];
		String dominio = partes[1];

		if (usuario.isEmpty() || !usuario.matches("^[A-Za-z0-9._-]+$")) {
			throw new EmailException();
		}

		if (!dominio.matches("^[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
			throw new EmailException();
		}

		if (!(dominio.endsWith("gmail.com") || dominio.endsWith("hotmail.com") || dominio.endsWith("outlook.com")
				|| dominio.endsWith("yahoo.com") || dominio.endsWith("unbosque.edu.co"))) {
			throw new EmailException();
		}
	}

	/**
	 * Verifica que la fecha de nacimiento sea válida, esté en formato
	 * {@code dd/MM/yyyy} y que el usuario tenga al menos 18 años.
	 * 
	 * @param s la fecha de nacimiento a verificar
	 * @throws BornDateException si el formato es incorrecto o la edad es menor a 18
	 *                           años
	 */
	public static void verifyBornDate(String s) throws BornDateException {
		if (s == null || s.isEmpty()) {
			throw new BornDateException();
		}

		if (!s.matches("^[0-9/]+$")) {
			throw new BornDateException();
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNacimiento;
		try {
			fechaNacimiento = LocalDate.parse(s, formatter);
		} catch (DateTimeParseException e) {
			throw new BornDateException();
		}

		LocalDate hoy = LocalDate.now();
		int edad = Period.between(fechaNacimiento, hoy).getYears();

		if (edad < 18) {
			throw new BornDateException();
		}
	}

	/**
	 * Verifica que el valor seleccionado de un ComboBox no sea nulo ni el valor por
	 * defecto ("...").
	 * 
	 * @param s el valor seleccionado
	 * @throws ComboBoxException si no se selecciona una opción válida
	 */
	public static void verifyComboBox(String s) throws ComboBoxException {
		if (s == null || s.equals("...")) {
			throw new ComboBoxException();
		}
	}

	/**
	 * Verifica que la contraseña cumpla con la longitud mínima requerida (12
	 * caracteres).
	 * 
	 * @param s la contraseña ingresada
	 * @throws RegisterPasswordException si la contraseña es nula, vacía o demasiado
	 *                                   corta
	 */
	public static void verifyRegisterPassword(String s) throws RegisterPasswordException {
		if (s == null || s.isEmpty() || s.length() < 12) {
			throw new RegisterPasswordException();
		}
	}

	/**
	 * Verifica que el usuario haya seleccionado una imagen válida durante el
	 * registro.
	 * 
	 * @param imgurl la ruta o URL de la imagen seleccionada
	 * @throws ImageNotSelectedException si no se ha seleccionado ninguna imagen
	 */
	public static void verifyImageSelected(String imgurl) throws ImageNotSelectedException {
		if (imgurl == null || imgurl.isEmpty()) {
			throw new ImageNotSelectedException();
		}
	}

	/**
	 * Verifica que los ingresos ingresados sean válidos, positivos y razonables
	 * según el país de residencia.
	 * 
	 * @param incomeStr el ingreso mensual en formato de cadena
	 * @param country   el país asociado al usuario
	 * @throws IncomeException si el valor no es numérico, negativo o menor al
	 *                         mínimo razonable
	 */
	public static void verifyIncome(String incomeStr, String country) throws IncomeException {
		if (incomeStr == null || incomeStr.trim().isEmpty()) {
			throw new IncomeException();
		}

		try {
			long ingresos = Long.parseLong(incomeStr.trim());

			if (ingresos < 0) {
				throw new IncomeException();
			}

			if (ingresos < 1000 && ("Angola".equals(country) || "Argentina".equals(country)
					|| "Colombia".equals(country) || "México".equals(country))) {
				throw new IncomeException();
			}

		} catch (NumberFormatException e) {
			throw new IncomeException();
		}
	}
}
