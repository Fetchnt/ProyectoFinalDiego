package co.edu.unbosque.util.exception;

public class ExceptionLauncher {

	public static void verifyName(String s) throws NameException {
		if (s == null) {
			throw new NameException();
		}
		if (!s.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || s.length() < 5) {
			throw new NameException();
		}
	}

	public static void verifyLastName(String s) throws LastNameException {
		if (s == null) {
			throw new LastNameException();
		}
		if (!s.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || s.length() < 5) {
			throw new LastNameException();
		}
	}

	public static void verifyStature(String s) throws StatureException {
		if (s == null) {
			throw new StatureException();
		}

		// No debe contener espacios ni letras, solo dígitos y un punto opcional
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

		if (usuario.isEmpty()) {
			throw new EmailException();
		}

		if (!usuario.matches("^[A-Za-z0-9.]+$")) {
			throw new EmailException();
		}

		if (!(dominio.contains("gmail") || dominio.contains("hotmail") || dominio.contains("outlook")
				|| dominio.contains("yahoo") || dominio.contains("unbosque.edu.co"))) {
			throw new EmailException();
		}

		if (!dominio.contains(".")) {
			throw new EmailException();
		}
	}
}
