package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.util.exception.*;
import co.edu.unbosque.model.MenDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.WomenDTO;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;

	// --- Variables para verificación de correo ---
	private boolean correoVerificado = false;
	private String correoVerificadoActual = "";

	// --- Credenciales para envío del correo (usa contraseña de aplicación) ---
	private static final String REMITENTE = "BostinderPF@gmail.com";
	private static final String CONTRASENA = "ixsx oohf ewsy lamq";

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade(mf);
		asignarOyentes();
	}

	public void asignarOyentes() {
		// BOTONES Start en PrincipalWindow
		vf.getPw().getStart().addActionListener(this);
		vf.getPw().getStart().setActionCommand("boton_start");

		// BOTONES en SignInWindow
		vf.getSw().getSignIn().addActionListener(this);
		vf.getSw().getSignIn().setActionCommand("boton_signIn");

		vf.getSw().getLogin().addActionListener(this);
		vf.getSw().getLogin().setActionCommand("boton_login");

		vf.getSw().getExit().addActionListener(this);
		vf.getSw().getExit().setActionCommand("boton_exit");

		vf.getSw().getBack().addActionListener(this);
		vf.getSw().getBack().setActionCommand("boton_back");

		// ---------- BOTONES en RegisterWindow ----------
		vf.getRw().getBtnRegistrar().addActionListener(this);
		vf.getRw().getBtnRegistrar().setActionCommand("boton_registrar");

		vf.getRw().getBtnSubirFoto().addActionListener(this);
		vf.getRw().getBtnSubirFoto().setActionCommand("boton_subir_foto");

		vf.getRw().getCmbGenero().addActionListener(this);
		vf.getRw().getCmbGenero().setActionCommand("seleccionar_genero");

		vf.getRw().getBtnVerificarCorreo().addActionListener(this);
		vf.getRw().getBtnVerificarCorreo().setActionCommand("verificar_correo");

		vf.getRw().getBtnVolver().addActionListener(this);
		vf.getRw().getBtnVolver().setActionCommand("boton_volver_registro");

		// Mapa
		vf.getSw().getMapButton().addActionListener(this);
		vf.getSw().getMapButton().setActionCommand("abrir_mapa");

		vf.getMw().getBtnBackMap().addActionListener(this);
		vf.getMw().getBtnBackMap().setActionCommand("back_mapa");

		// ---------- BOTONES en LoginWindow ----------
		vf.getLw().getBack().addActionListener(this);
		vf.getLw().getBack().setActionCommand("boton_volver_iniciosesion");

		vf.getLw().getLogin().addActionListener(this);
		vf.getLw().getLogin().setActionCommand("boton_iniciosesion");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();
		switch (alias) {
		case "boton_start":
			vf.getPw().dispose();
			vf.getSw().setVisible(true);
			break;

		case "abrir_mapa":
			vf.getSw().dispose();
			vf.getMw().setVisible(true);
			break;

		case "boton_signIn":
			vf.getSw().setVisible(false);
			vf.getRw().setVisible(true);
			break;

		case "boton_login":
			vf.getSw().dispose();
			vf.getLw().setVisible(true);
			break;

		case "boton_exit":
			int confirm = JOptionPane.showConfirmDialog(vf.getSw(), "Confirmar salida", "¿Desea salir de BosTinder?",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			break;

		case "boton_back":
			vf.getSw().dispose();
			vf.getPw().setVisible(true);
			break;

		case "verificar_correo":
			try {
				String correo = vf.getRw().getTxtCorreo().getText().trim();
				ExceptionLauncher.verifyEmail(correo); // tu validación personalizada

				String codigo = generarCodigo();

				// Intentar enviar correo real
				boolean enviado = enviarCorreo(correo, codigo);

				if (!enviado) {
					// Si falla el envío SMTP, ofrecer verificación simulada
					int opc = JOptionPane.showConfirmDialog(null,
							"No fue posible enviar el correo.\n¿Deseas usar verificación simulada?", "SMTP falló",
							JOptionPane.YES_NO_OPTION);
					if (opc != JOptionPane.YES_OPTION) {
						correoVerificado = false;
						break;
					}

					// Mostrar código en pantalla (modo prueba)
					JOptionPane.showMessageDialog(null,
							"Modo SIMULADO: tu código es: " + codigo + "\n(En modo real este mensaje no aparece).",
							"Código simulado", JOptionPane.INFORMATION_MESSAGE);
				}

				// --- Verificación con tiempo límite ---
				long inicio = System.currentTimeMillis();
				boolean verificado = false;

				while (System.currentTimeMillis() - inicio < 5 * 60 * 1000) { // 5 minutos
					String codigoIngresado = JOptionPane.showInputDialog(null,
							"Introduce el código recibido por correo:", "Verificación de correo",
							JOptionPane.QUESTION_MESSAGE);

					if (codigoIngresado == null) { // Usuario canceló
						JOptionPane.showMessageDialog(null, "Verificación cancelada.");
						correoVerificado = false;
						break;
					}

					if (codigoIngresado.trim().equals(codigo)) {
						JOptionPane.showMessageDialog(null, "✅ Correo verificado correctamente.");
						correoVerificado = true;
						correoVerificadoActual = correo;
						verificado = true;
						break;
					} else {
						JOptionPane.showMessageDialog(null, "❌ Código incorrecto. Intenta nuevamente.");
					}
				}

				if (!verificado && (System.currentTimeMillis() - inicio >= 5 * 60 * 1000)) {
					JOptionPane.showMessageDialog(null, "⏰ Tiempo de verificación expirado. Intenta de nuevo.");
					correoVerificado = false;
				}

			} catch (EmailException ex) {
				JOptionPane.showMessageDialog(null,
						"Formato de correo inválido o dominio no permitido:\n" + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error al verificar correo: " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			break;

		// ---------- ACCIONES DEL REGISTRO ----------
		case "boton_subir_foto":
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagen PNG", "png");
			chooser.setFileFilter(filter);
			int result = chooser.showOpenDialog(null);

			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = chooser.getSelectedFile();
				ImageIcon image = new ImageIcon(selectedFile.getAbsolutePath());
				ImageIcon scaled = new ImageIcon(
						image.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

				// Mostrar imagen seleccionada
				vf.getRw().getlFotoPreview().setIcon(scaled);
				vf.getRw().setRutaImagenSeleccionada(selectedFile.getAbsolutePath());

			}
			break;

		case "seleccionar_genero":
			mostrarCamposPorGenero();
			break;

		case "boton_registrar":
			try {
				String correo = vf.getRw().getTxtCorreo().getText();

				// Verificar si el correo ya fue validado antes
				if (!correoVerificado || !correo.equals(correoVerificadoActual)) {
					JOptionPane.showMessageDialog(null,
							"⚠️ Debes verificar tu correo electrónico antes de registrarte.", "Verificación requerida",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				// Obtener datos básicos comunes
				String nombres = vf.getRw().getTxtNombres().getText();
				String apellidos = vf.getRw().getTxtApellidos().getText();
				String apodo = vf.getRw().getTxtApodo().getText();
				String password = vf.getRw().getTxtPassword().getText();
				String pais = (String) vf.getRw().getCmbPais().getSelectedItem();
				String genero = (String) vf.getRw().getCmbGenero().getSelectedItem();
				String fechaNacimiento = vf.getRw().getTxtFechaNacimiento().getText();

				// Validaciones
				ExceptionLauncher.verifyName(nombres);
				ExceptionLauncher.verifyLastName(apellidos);
				ExceptionLauncher.verifyNickname(apodo);
				ExceptionLauncher.verifyBornDate(fechaNacimiento);
				ExceptionLauncher.verifyComboBox(pais);
				ExceptionLauncher.verifyComboBox(genero);
				ExceptionLauncher.verifyRegisterPassword(password);
				ExceptionLauncher.verifyImageSelected(vf.getRw().getRutaImagenSeleccionada());

				// Crear usuario según género
				if (genero.equals("Masculino")) {
					String estatura = vf.getRw().getTxtEstatura().getText();
					String orientacion = (String) vf.getRw().getCmbOrientacion().getSelectedItem();
					String ingresosStr = vf.getRw().getTxtIngresos().getText();

					ExceptionLauncher.verifyStature(estatura);
					ExceptionLauncher.verifyComboBox(orientacion);

					if (ingresosStr.isEmpty()) {
						throw new NumberFormatException("Los ingresos mensuales son obligatorios");
					}

					long ingresos = Long.parseLong(ingresosStr);
					if (ingresos < 0) {
						throw new NumberFormatException("Los ingresos no pueden ser negativos");
					}

					MenDTO hombre = new MenDTO(nombres, apellidos, apodo, fechaNacimiento, estatura, correo, genero,
							orientacion, "ruta_foto_predeterminada", pais, ingresos);
					mf.getmDAO().create(hombre);

				} else if (genero.equals("Femenino")) {
					String estatura = vf.getRw().getTxtEstatura().getText();
					String orientacion = (String) vf.getRw().getCmbOrientacion().getSelectedItem();
					String divorciosStr = (String) vf.getRw().getCmbDivorcios().getSelectedItem();

					ExceptionLauncher.verifyStature(estatura);
					ExceptionLauncher.verifyComboBox(orientacion);
					ExceptionLauncher.verifyComboBox(divorciosStr);

					boolean tuvoDivorcios = divorciosStr.equals("Sí");

					WomenDTO mujer = new WomenDTO(nombres, apellidos, apodo, fechaNacimiento, estatura, correo, genero,
							orientacion, "ruta_foto_predeterminada", pais, tuvoDivorcios);
					mf.getwDAO().create(mujer);

				} else {
					JOptionPane.showMessageDialog(null, "Género no válido", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(null, "Registro exitoso.\n¡Bienvenido al sistema!");
				vf.getRw().setVisible(false);
				vf.getSw().setVisible(true);
				limpiarCamposRegistro();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error en el registro: " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			break;

		case "boton_volver_registro": {
			limpiarCamposRegistro();
			vf.getRw().setVisible(false);
			vf.getSw().setVisible(true);
			break;
		}

		case "boton_volver_iniciosesion": {
			vf.getLw().setVisible(false);
			vf.getSw().setVisible(true);
			break;
		}

		case "boton_iniciosesion": {

			break;
		}

		case "back_mapa":
			vf.getMw().dispose();
			vf.getSw().setVisible(true);
			break;

		default:
			System.out.println("Acción no definida: " + alias);
			break;
		}
	}

	// -------------METODOS AUXILIARES-----------------
	public void mostrarCamposPorGenero() {
		String genero = (String) vf.getRw().getCmbGenero().getSelectedItem();

		boolean mostrarCampos = genero.equals("Masculino") || genero.equals("Femenino");

		vf.getRw().getlEstatura().setVisible(mostrarCampos);
		vf.getRw().getTxtEstatura().setVisible(mostrarCampos);
		vf.getRw().getlOrientacion().setVisible(mostrarCampos);
		vf.getRw().getCmbOrientacion().setVisible(mostrarCampos);

		vf.getRw().getlIngresos().setVisible(genero.equals("Masculino"));
		vf.getRw().getTxtIngresos().setVisible(genero.equals("Masculino"));

		vf.getRw().getlDivorcios().setVisible(genero.equals("Femenino"));
		vf.getRw().getCmbDivorcios().setVisible(genero.equals("Femenino"));
	}

	public void limpiarCamposRegistro() {
		// Limpiar campos de texto
		vf.getRw().getTxtNombres().setText("");
		vf.getRw().getTxtApellidos().setText("");
		vf.getRw().getTxtApodo().setText("");
		vf.getRw().getTxtCorreo().setText("");
		vf.getRw().getTxtPassword().setText("");
		vf.getRw().getTxtFechaNacimiento().setText("");
		vf.getRw().getTxtEstatura().setText("");
		vf.getRw().getTxtIngresos().setText("");

		// Restablecer combobox
		vf.getRw().getCmbPais().setSelectedIndex(0);
		vf.getRw().getCmbGenero().setSelectedIndex(0);
		vf.getRw().getCmbOrientacion().setSelectedIndex(0);
		vf.getRw().getCmbDivorcios().setSelectedIndex(0);

		// Ocultar campos específicos
		mostrarCamposPorGenero();
	}

	private String generarCodigo() {
		Random rand = new Random();
		int codigo = 100000 + rand.nextInt(900000);
		return String.valueOf(codigo);
	}

	/**
	 * Intenta enviar el correo con STARTTLS (puerto 587). Devuelve true si el envío
	 * fue correcto, false si hubo fallo.
	 */
	private boolean enviarCorreo(String destinatario, String codigo) {
		// 1) Propiedades comunes para STARTTLS
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true"); // fuerza STARTTLS
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // forzar TLSv1.2
		// determinar host según remitente
		String host;
		if (REMITENTE.endsWith("@gmail.com")) {
			host = "smtp.gmail.com";
		} else if (REMITENTE.endsWith("@hotmail.com") || REMITENTE.endsWith("@outlook.com")
				|| REMITENTE.endsWith("@live.com") || REMITENTE.endsWith("@outlook.es")
				|| REMITENTE.endsWith("@unbosque.edu.co")) {
			host = "smtp.office365.com";
		} else if (REMITENTE.endsWith("@yahoo.com") || REMITENTE.endsWith("@yahoo.es")) {
			host = "smtp.mail.yahoo.com";
		} else {
			JOptionPane.showMessageDialog(null, "❌ Dominio del remitente no soportado.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.ssl.trust", host); // confiar en el host para SSL/TLS

		// 2) Crear sesión con autenticación
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(REMITENTE, CONTRASENA);
			}
		});
		session.setDebug(false); // poner true si necesitas traza en consola

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(REMITENTE));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject("Código de verificación - BosTinder 💌");
			message.setText("Tu código de verificación es: " + codigo + "\n\nTienes 5 minutos para ingresarlo.");

			Transport.send(message);
			return true;
		} catch (AuthenticationFailedException e) {
			JOptionPane.showMessageDialog(null,
					"❌ Error de autenticación: verifica usuario/contraseña (usa contraseña de aplicación si Gmail).",
					"Error de autenticación", JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (SendFailedException e) {
			JOptionPane.showMessageDialog(null, "❌ Error al enviar: dirección inválida o rechazada.\n" + e.getMessage(),
					"Error de envío", JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (MessagingException e) {
			// Mensaje con detalle para diagnóstico (no demasiado técnico al usuario)
			JOptionPane.showMessageDialog(null, "❌ Error SMTP al enviar el correo.\nDetalle: " + e.getMessage(),
					"Error SMTP", JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "⚠️ Error inesperado al enviar correo: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public void runGUI() {
		vf.getPw().setVisible(true);
	}
}
