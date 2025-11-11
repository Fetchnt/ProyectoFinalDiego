package co.edu.unbosque.util.exception;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ExceptionLauncher {

	public static void verifyName(String s) throws NameException {
		if (s == null || s.isEmpty()) {
			throw new NameException();
		}
		if (!s.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || s.length() < 5) {
			throw new NameException();
		}
	}

	public static void verifyLastName(String s) throws LastNameException {
		if (s == null || s.isEmpty()) {
			throw new LastNameException();
		}
		if (!s.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || s.length() < 5) {
			throw new LastNameException();
		}
	}

	public static void verifyNickname(String s) throws NickNameException {
		if (s == null || s.isEmpty()) {
			throw new NickNameException();
		}
		if (!s.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+( [A-Za-zÁÉÍÓÚáéíóúÑñ]+)*$") || s.length() < 5) {
			throw new NickNameException();
		}
	}

	public static void verifyStature(String s) throws StatureException {
		if (s == null || s.isEmpty()) {
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

	    if (!usuario.matches("^[A-Za-z0-9._-]+$")) {
	        throw new EmailException();
	    }

	    // Verificar formato general del dominio (por ejemplo: unbosque.edu.co)
	    if (!dominio.matches("^[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
	        throw new EmailException();
	    }

	    // Verificar dominios permitidos
	    if (!(dominio.endsWith("gmail.com")
	            || dominio.endsWith("hotmail.com")
	            || dominio.endsWith("outlook.com")
	            || dominio.endsWith("yahoo.com")
	            || dominio.endsWith("unbosque.edu.co"))) {
	        throw new EmailException();
	    }
	}

	public static void verifyBornDate(String s) throws BornDateException {
		if (s == null || s.isEmpty()) {
			throw new BornDateException();
		}

		// Solo debe contener números y barras (no letras ni símbolos)
		if (!s.matches("^[0-9/]+$")) {
			throw new BornDateException();
		}

		// Validar formato DD/MM/AAAA
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNacimiento;
		try {
			fechaNacimiento = LocalDate.parse(s, formatter);
		} catch (DateTimeParseException e) {
			throw new BornDateException(); // formato o fecha inválida
		}

		// Calcular edad
		LocalDate hoy = LocalDate.now();
		int edad = Period.between(fechaNacimiento, hoy).getYears();

		if (edad < 18) {
			throw new BornDateException();
		}
	}

	public static void verifyComboBox(String s) throws ComboBoxException {
		if (s == null || s.equals("...")) {
			throw new ComboBoxException();
		}
	}

	public static void verifyRegisterPassword(String s) throws RegisterPasswordException {
		if (s == null || s.isEmpty() || s.length() < 12) {
			throw new RegisterPasswordException();
		}
	}

	public static void verifyImageSelected(String imgurl) throws ImageNotSelectedException {
		if (imgurl == null || imgurl.isEmpty()) {
			throw new ImageNotSelectedException();
		}
	}
	
	public static void verifyIncome(String incomeStr, String country) throws IncomeException {
	    if (incomeStr == null || incomeStr.trim().isEmpty()) {
	        throw new IncomeException();
	    }
	    
	    try {
	        long ingresos = Long.parseLong(incomeStr.trim());
	        
	        if (ingresos < 0) {
	            throw new IncomeException();
	        }
	        // Validación adicional: ingresos mínimos razonables por país
	        if (ingresos < 1000 && ("Angola".equals(country) || "Argentina".equals(country) || 
	                               "Colombia".equals(country) || "México".equals(country))) {
	            throw new IncomeException();
	        }
	        
	    } catch (NumberFormatException e) {
	        throw new IncomeException();
	    }
	}

}
