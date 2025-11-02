package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
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

import org.junit.rules.Verifier;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.io.FileInputStream;

import co.edu.unbosque.util.exception.*;
import co.edu.unbosque.model.MenDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.WomenDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.view.ViewFacade;
import co.edu.unbosque.model.User;

public class Controller implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;
	private Properties prop;

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
		// ---------- BOTONES en PrincipalWindow ----------
		vf.getPw().getStart().addActionListener(this);
		vf.getPw().getStart().setActionCommand("boton_start");

		vf.getPw().getbSpanish().addActionListener(this);
		vf.getPw().getbSpanish().setActionCommand("internacionalizacion_esp");

		vf.getPw().getbChinnesse().addActionListener(this);
		vf.getPw().getbChinnesse().setActionCommand("internacinalizacion_chi");

		vf.getPw().getbHebrew().addActionListener(this);
		vf.getPw().getbHebrew().setActionCommand("internacionalizacion_heb");

		vf.getPw().getbPortuguese().addActionListener(this);
		vf.getPw().getbPortuguese().setActionCommand("internacinalizacion_por");

		vf.getPw().getbRussian().addActionListener(this);
		vf.getPw().getbRussian().setActionCommand("internacinalizacion_rus");

		// ---------- BOTONES en SignInWindow ----------
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

		// ---------- BOTONES en Mapa ----------
		vf.getSw().getMapButton().addActionListener(this);
		vf.getSw().getMapButton().setActionCommand("abrir_mapa");

		vf.getMw().getBtnBackMap().addActionListener(this);
		vf.getMw().getBtnBackMap().setActionCommand("back_mapa");

		vf.getUw().getBtnVolver().addActionListener(this);
		vf.getUw().getBtnVolver().setActionCommand("volver_usuarios");

		// ---------- BOTONES en LoginWindow ----------
		vf.getLw().getBack().addActionListener(this);
		vf.getLw().getBack().setActionCommand("boton_volver_iniciosesion");

		vf.getLw().getLogin().addActionListener(this);
		vf.getLw().getLogin().setActionCommand("boton_iniciosesion");

		// ---------- BOTONES en AdminWindow ----------
		vf.getAw().getBtnBuscar().addActionListener(this);
		vf.getAw().getBtnBuscar().setActionCommand("boton_buscar_admin");

		vf.getAw().getBtnDarBaja().addActionListener(this);
		vf.getAw().getBtnDarBaja().setActionCommand("boton_dar_baja_admin");

		vf.getAw().getBtnFiltroGenero().addActionListener(this);
		vf.getAw().getBtnFiltroGenero().setActionCommand("boton_filtro_genero_admin");

		vf.getAw().getBtnFiltroIngresos().addActionListener(this);
		vf.getAw().getBtnFiltroIngresos().setActionCommand("boton_filtro_ingresos_admin");

		vf.getAw().getBtnFiltroTop10().addActionListener(this);
		vf.getAw().getBtnFiltroTop10().setActionCommand("boton_filtro_top10_admin");

		vf.getAw().getBtnGenerarPDF().addActionListener(this);
		vf.getAw().getBtnGenerarPDF().setActionCommand("boton_generarPDF_admin");

		vf.getAw().getBtnMostrarTodos().addActionListener(this);
		vf.getAw().getBtnMostrarTodos().setActionCommand("boton_mostrar_todos_admin");

		vf.getAw().getBtnOrdenAsc().addActionListener(this);
		vf.getAw().getBtnOrdenAsc().setActionCommand("boton_orden_ascendente_admin");

		vf.getAw().getBtnOrdenDesc().addActionListener(this);
		vf.getAw().getBtnOrdenDesc().setActionCommand("boton_orden_descendente_admin");

		vf.getAw().getBtnSalirModoAdmin().addActionListener(this);
		vf.getAw().getBtnSalirModoAdmin().setActionCommand("boton_salir_admin");

		// ---------- BOTONES en MainWindow ----------
		vf.getMmw().getBtnLogOff().addActionListener(this);
		vf.getMmw().getBtnLogOff().setActionCommand("boton_cerrarsesion");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();
		switch (alias) {
		case "boton_start":
			vf.getPw().setVisible(false);
			vf.getSw().setVisible(true);
			break;

		case "internacionalizacion_esp":
			/*
			 * prop = FileHandler.cargarArchivoPropiedades("esp.properties");
			 * 
			 * vf.aplicarInternacionalizacion(prop); mf.cargarProperties(prop);
			 * vf.getsw().mostrarProductos(mf.mostrarPaginaPrincipal());
			 * vf.getStartWin().repaint(); vf.getStartWin().revalidate();
			 */
			aplicarInternacionalizacion("es");
			break;

		case "internacinalizacion_por":
			aplicarInternacionalizacion("pt");
			break;

		case "internacinalizacion_chi":
			aplicarInternacionalizacion("chi");
			break;

		case "internacionalizacion_heb":
			aplicarInternacionalizacion("heb");
			break;

		case "internacinalizacion_rus":
			aplicarInternacionalizacion("rus");
			break;

		case "abrir_mapa":
			vf.getSw().dispose();
			vf.getMw().setVisible(true);

			// Asignamos listener usando métodos auxiliares
			co.edu.unbosque.view.MapWindow.MapaListener listener = new co.edu.unbosque.view.MapWindow.MapaListener() {
				@Override
				public void onPaisClick(String pais) {
					manejarClickPais(pais);
				}

				@Override
				public void onPaisHover(String pais) {
					mostrarPaisHover(pais);
				}
			};

			vf.getMw().setMapaListener(listener);
			break;

		case "volver_usuarios":
			vf.getUw().setVisible(false);
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
			int confirm = JOptionPane.showConfirmDialog(vf.getSw(),
					prop.getProperty("bostinder.controller.dialog.confirm_exit.message", "¿Desea salir de BosTinder?"),
					prop.getProperty("bostinder.controller.dialog.confirm_exit.title", "Confirmar salida"),
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
				ExceptionLauncher.verifyEmail(correo);

				String codigo = generarCodigo();

				boolean enviado = enviarCorreo(correo, codigo);

				if (!enviado) {

					int opc = JOptionPane.showConfirmDialog(null,
							"No fue posible enviar el correo.\n¿Deseas usar verificación simulada?", "SMTP falló",
							JOptionPane.YES_NO_OPTION);
					if (opc != JOptionPane.YES_OPTION) {
						correoVerificado = false;
						break;
					}

					JOptionPane.showMessageDialog(null,
							"Modo SIMULADO: tu código es: " + codigo + "\n(En modo real este mensaje no aparece).",
							"Código simulado", JOptionPane.INFORMATION_MESSAGE);
				}

				// --- Verificación con tiempo límite ---
				long inicio = System.currentTimeMillis();
				boolean verificado = false;

				while (System.currentTimeMillis() - inicio < 5 * 60 * 1000) {
					String codigoIngresado = JOptionPane.showInputDialog(null,
							"Introduce el código recibido por correo:", "Verificación de correo",
							JOptionPane.QUESTION_MESSAGE);

					if (codigoIngresado == null) {
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
			try {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagen PNG", "png");
				chooser.setFileFilter(filter);
				int result = chooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();

					ImageIcon image = new ImageIcon(selectedFile.getAbsolutePath());
					ImageIcon scaled = new ImageIcon(
							image.getImage().getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

					vf.getRw().getlFotoPreview().setIcon(scaled);
					vf.getRw().setRutaImagenSeleccionada(selectedFile.getAbsolutePath());

					JOptionPane.showMessageDialog(null, "Imagen cargada correctamente.");
				} else {
					throw new ImageNotSelectedException();
				}

			} catch (ImageNotSelectedException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

				String nombres = vf.getRw().getTxtNombres().getText();
				String apellidos = vf.getRw().getTxtApellidos().getText();
				String apodo = vf.getRw().getTxtApodo().getText();
				String password = vf.getRw().getTxtPassword().getText();
				String pais = (String) vf.getRw().getCmbPais().getSelectedItem();
				String genero = (String) vf.getRw().getCmbGenero().getSelectedItem();
				String fechaNacimiento = vf.getRw().getTxtFechaNacimiento().getText();

				ExceptionLauncher.verifyName(nombres);
				ExceptionLauncher.verifyLastName(apellidos);
				ExceptionLauncher.verifyNickname(apodo);
				ExceptionLauncher.verifyBornDate(fechaNacimiento);
				ExceptionLauncher.verifyComboBox(pais);
				ExceptionLauncher.verifyComboBox(genero);
				ExceptionLauncher.verifyRegisterPassword(password);
				ExceptionLauncher.verifyImageSelected(vf.getRw().getRutaImagenSeleccionada());

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

					String rutaFoto = vf.getRw().getRutaImagenSeleccionada();

					MenDTO hombre = new MenDTO(nombres, apellidos, apodo, fechaNacimiento, estatura, correo, genero,
							orientacion, rutaFoto, pais, password, ingresos, prop);
					mf.getmDAO().create(hombre);

				} else if (genero.equals("Femenino")) {
					String estatura = vf.getRw().getTxtEstatura().getText();
					String orientacion = (String) vf.getRw().getCmbOrientacion().getSelectedItem();
					String divorciosStr = (String) vf.getRw().getCmbDivorcios().getSelectedItem();

					ExceptionLauncher.verifyStature(estatura);
					ExceptionLauncher.verifyComboBox(orientacion);
					ExceptionLauncher.verifyComboBox(divorciosStr);

					boolean tuvoDivorcios = divorciosStr.equals("Sí");
					String rutaFoto = vf.getRw().getRutaImagenSeleccionada();

					WomenDTO mujer = new WomenDTO(nombres, apellidos, apodo, fechaNacimiento, estatura, correo, genero,
							orientacion, rutaFoto, pais, password, tuvoDivorcios, prop);
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

		case "boton_iniciosesion": {
			// Obtener los datos ingresados
			String userAlias = vf.getLw().getUser().getText();
			String email = vf.getLw().getEmail().getText();
			String password = vf.getLw().getPassword().getText();

			// Validar credenciales con el modelo
			boolean valido = mf.validarInicioSesion(userAlias, email, password);

			if (valido) {
				JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. ¡Bienvenido!");
				vf.getLw().setVisible(false);
				vf.getMmw().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos. Verifica tu alias, correo y contraseña.",
						"Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		case "boton_volver_iniciosesion": {
			vf.getLw().dispose();
			vf.getSw().setVisible(true);
			break;
		}

		case "boton_cerrarsesion": {
			vf.getMmw().dispose();
			vf.getSw().setVisible(true);
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

	// Maneja click en un país
	private void manejarClickPais(String pais) {
		if (pais != null) {
			// Actualiza el label con el país seleccionado en la ventana principal
			vf.getMw().setPaisSeleccionado(pais);

			// Obtener la lista de usuarios de ese país
			List<User> usuarios = mf.getUsuariosPorPais(pais);

			// Mostrar directamente las personas registradas en ese país con imagen
			vf.getUw().mostrarUsuariosConImagen(usuarios);
			vf.getUw().setVisible(true);

			// Ocultar la ventana principal mientras se muestra la lista
			vf.getMw().setVisible(false);
		}
	}

	// Maneja mouse sobre pais
	private void mostrarPaisHover(String pais) {
		if (pais != null) {
			// Actualiza un label temporal con el país
			vf.getMw().setPaisSeleccionado(pais);
		}
	}

	public void mostrarCamposPorGenero() {
		int indice = vf.getRw().getCmbGenero().getSelectedIndex();

		if (indice == 1) { // Masculino
			vf.getRw().getlEstatura().setVisible(true);
			vf.getRw().getTxtEstatura().setVisible(true);
			vf.getRw().getlOrientacion().setVisible(true);
			vf.getRw().getCmbOrientacion().setVisible(true);
			vf.getRw().getlIngresos().setVisible(true);
			vf.getRw().getTxtIngresos().setVisible(true);
			vf.getRw().getlDivorcios().setVisible(false);
			vf.getRw().getCmbDivorcios().setVisible(false);
		} else if (indice == 2) { // Femenino
			vf.getRw().getlEstatura().setVisible(true);
			vf.getRw().getTxtEstatura().setVisible(true);
			vf.getRw().getlOrientacion().setVisible(true);
			vf.getRw().getCmbOrientacion().setVisible(true);
			vf.getRw().getlIngresos().setVisible(false);
			vf.getRw().getTxtIngresos().setVisible(false);
			vf.getRw().getlDivorcios().setVisible(true);
			vf.getRw().getCmbDivorcios().setVisible(true);
		} else {
			vf.getRw().getlEstatura().setVisible(false);
			vf.getRw().getTxtEstatura().setVisible(false);
			vf.getRw().getlOrientacion().setVisible(false);
			vf.getRw().getCmbOrientacion().setVisible(false);
			vf.getRw().getlIngresos().setVisible(false);
			vf.getRw().getTxtIngresos().setVisible(false);
			vf.getRw().getlDivorcios().setVisible(false);
			vf.getRw().getCmbDivorcios().setVisible(false);
		}
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

	public String generarCodigo() {
		Random rand = new Random();
		int codigo = 100000 + rand.nextInt(900000);
		return String.valueOf(codigo);
	}

	public boolean enviarCorreo(String destinatario, String codigo) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.starttls.required", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

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
		props.put("mail.smtp.ssl.trust", host);
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(REMITENTE, CONTRASENA);
			}
		});
		session.setDebug(false);

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
			JOptionPane.showMessageDialog(null, "❌ Error SMTP al enviar el correo.\nDetalle: " + e.getMessage(),
					"Error SMTP", JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "⚠️ Error inesperado al enviar correo: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/**
	 * Aplica internacionalización a TODO el programa (todas las ventanas y modelo).
	 * 
	 * @param idioma Código del idioma, ej: "es", "en", "pt", "chi", "heb", "rus"
	 */
	public void aplicarInternacionalizacion(String idioma) {
		try {
			String archivo = switch (idioma.toLowerCase()) {
			case "es" -> "spa.properties";
			case "pt" -> "por.properties";
			case "chi" -> "chin.properties";
			case "heb" -> "heb.properties";
			case "rus" -> "rus.properties";
			default -> "spa.properties";
			};

			prop = new Properties();
			prop.load(new FileInputStream("Language_properties/" + archivo));

			vf.getPw().aplicarInternacionalizacion(prop);
			vf.getSw().aplicarInternacionalizacion(prop);
			vf.getRw().aplicarInternacionalizacion(prop);
			vf.getLw().aplicarInternacionalizacion(prop);
			vf.getMmw().aplicarInternacionalizacion(prop);

			mf.cargarProperties(prop);

			vf.getPw().revalidate();
			vf.getPw().repaint();
			vf.getSw().revalidate();
			vf.getSw().repaint();
			vf.getRw().revalidate();
			vf.getRw().repaint();
			vf.getLw().revalidate();
			vf.getLw().repaint();
			vf.getMmw().revalidate();
			vf.getMmw().repaint();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al aplicar internacionalización: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	public void runGUI() {
		vf.getPw().setVisible(true);
	}
}
