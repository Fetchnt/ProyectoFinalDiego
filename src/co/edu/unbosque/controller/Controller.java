package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
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
import javax.swing.table.DefaultTableModel;

import org.junit.rules.Verifier;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import java.awt.*;

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

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade(mf);
		prop = new Properties();
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
		
		vf.getAw().getTablaUsuarios().getSelectionModel().addListSelectionListener(e -> {
		    if (!e.getValueIsAdjusting()) {
		        mostrarDetalleUsuarioSeleccionado();
		    }
		});

		// ---------- BOTONES en MainWindow ----------
		vf.getMmw().getBtnLogOff().addActionListener(this);
		vf.getMmw().getBtnLogOff().setActionCommand("boton_cerrarsesion");

		vf.getMmw().getBtnLike().addActionListener(this);
		vf.getMmw().getBtnLike().setActionCommand("boton_like");

		vf.getMmw().getBtnNope().addActionListener(this);
		vf.getMmw().getBtnNope().setActionCommand("boton_nope");

		vf.getMmw().getBtnProfile().addActionListener(this);
		vf.getMmw().getBtnProfile().setActionCommand("boton_profile");

		vf.getMmw().getBtnVerMeGusta().addActionListener(this);
		vf.getMmw().getBtnVerMeGusta().setActionCommand("boton_ver_megusta");

		vf.getMmw().getBtnModoIncognito().addActionListener(this);
		vf.getMmw().getBtnModoIncognito().setActionCommand("boton_modo_incognito");

		vf.getMmw().getBtnFavorite().addActionListener(this);
		vf.getMmw().getBtnFavorite().setActionCommand("boton_favorito");
		
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

		case "verificar_correo": {
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
						vf.getRw().setCorreoVerificado(false);
						break;
					}

					JOptionPane.showMessageDialog(null,
							"Modo SIMULADO: tu código es: " + codigo + "\n(En modo real este mensaje no aparece).",
							"Código simulado", JOptionPane.INFORMATION_MESSAGE);
				}

				// --- Verificación con tiempo límite ---

				boolean verificado = false;

				String codigoIngresado = JOptionPane.showInputDialog(null, "Introduce el código recibido por correo:",
						"Verificación de correo", JOptionPane.QUESTION_MESSAGE);

				if (codigoIngresado == null) {
					JOptionPane.showMessageDialog(null, "Verificación cancelada.");
					vf.getRw().setCorreoVerificado(false);
					break;
				}

				if (codigoIngresado.trim().equals(codigo)) {
					JOptionPane.showMessageDialog(null, "✅ Correo verificado correctamente.");
					vf.getRw().setCorreoVerificado(true);
					vf.getRw().setCorreoVerificadoActual(correo);
					verificado = true;
					break;
				} else {
					JOptionPane.showMessageDialog(null, "❌ Código incorrecto. Intenta nuevamente.");
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
		}

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
					ImageIcon scaled = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));

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
				if (!vf.getRw().isCorreoVerificado() || !correo.equals(vf.getRw().getCorreoVerificadoActual())) {
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
			break;
		}

		case "back_mapa":
			vf.getMw().dispose();
			vf.getSw().setVisible(true);
			break;

		case "boton_like": {
			mf.agregarLike();
			mf.siguientePerfil();
			mostrarPerfil();
			break;
		}

		case "boton_nope": {
			mf.siguientePerfil();
			mostrarPerfil();
			break;
		}

		case "boton_profile": {

			break;
		}

		case "boton_ver_megusta": {
			mostrarLikes();
			break;
		}
		
		
		case "boton_dar_baja_admin": {
		    darDeBajaUsuario();
		    break;
		}
		
		case "boton_mostrar_todos_admin" : {
		    mostrarTodosLosUsuarios();
		}

		case "boton_modo_incognito": {
			toggleModoIncognito();
			break;
		}

		case "boton_favorito": {

		}
		
		case "boton_filtro_top10_admin": {
		    // Este filtro lo omitiremos por ahora ya que los likes no están implementados
		    JOptionPane.showMessageDialog(vf.getAw(),
		        "⚠️ El sistema de likes aún no está implementado.\n" +
		        "Este filtro estará disponible próximamente.",
		        "Función no disponible",
		        JOptionPane.INFORMATION_MESSAGE);
		    break;
		}

		case "boton_filtro_ingresos_admin": {
		    filtrarPorIngresos();
		    break;
		}

		case "boton_filtro_genero_admin": {
		    filtrarPorGenero();
		    break;
		}

		case "boton_buscar_admin": {
		    buscarUsuarioAdmin();
		    break;
		}

		default:
			System.out.println("Acción no definida: " + alias);
			break;
		}

	}

	// -------------METODOS AUXILIARES-----------------

	// Maneja click en un país
	public void manejarClickPais(String pais) {
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
	public void mostrarPaisHover(String pais) {
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

		// --- Credenciales para envío del correo
		final String remintente = "BostinderPF@gmail.com";
		final String contrasena = "ixsx oohf ewsy lamq";

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.starttls.required", "true");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

		String host;
		if (remintente.endsWith("@gmail.com")) {
			host = "smtp.gmail.com";
		} else if (remintente.endsWith("@hotmail.com") || remintente.endsWith("@outlook.com")
				|| remintente.endsWith("@live.com") || remintente.endsWith("@outlook.es")
				|| remintente.endsWith("@unbosque.edu.co")) {
			host = "smtp.office365.com";
		} else if (remintente.endsWith("@yahoo.com") || remintente.endsWith("@yahoo.es")) {
			host = "smtp.mail.yahoo.com";
		} else {
			JOptionPane.showMessageDialog(null, "❌ Dominio del remitente no soportado.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.ssl.trust", host);
		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(remintente, contrasena);
			}
		});
		session.setDebug(false);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(remintente));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject("Código de verificación - BosTinder 💌");
			message.setText("Tu código de verificación es: " + codigo);

			Transport.send(message);
			return true;
		} catch (AuthenticationFailedException e) {
			JOptionPane.showMessageDialog(null, "❌ Error de autenticación: verifica usuario/contraseña",
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

	public void mostrarPerfil() {
		User actual = mf.getPerfilActual();
		if (actual == null) {
			JOptionPane.showMessageDialog(null, "No hay más perfiles por mostrar ");
			return;
		}

		// --- Calcular edad a partir de la fecha de nacimiento ---
		int edad = calcularEdad(actual.getBornDate());

		// --- Mostrar texto básico ---
		vf.getMmw().getLblNameAge().setText(actual.getName() + " " + actual.getLastName());

		vf.getMmw().getTxtDescription()
				.setText("Alias: " + actual.getAlias() + "\n" + "Género: " + actual.getGender() + "\n" + "Orientación: "
						+ actual.getSexualOrientation() + "\n" + "País: " + actual.getCountry() + "\n" + "Edad: " + edad
						+ " años");

		// --- Mostrar imagen de perfil ---
	}

	public void mostrarLikes() {
		List<User> likes = mf.getLikes();
		if (likes.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Aún no has dado like a nadie\n\n"
					+ "Da like a perfiles que te gusten\n" + "   para verlos aquí después", "Mis Likes",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		StringBuilder sb = new StringBuilder("❤️ Tus Likes:\n\n");
		for (int i = 0; i < likes.size(); i++) {
			User u = likes.get(i);
			sb.append(i + 1).append(". ").append(u.getName()).append(" ").append(u.getLastName()).append(" (")
					.append(u.getAlias()).append(")\n");
		}

		JOptionPane.showMessageDialog(null, sb.toString(), "Mis Likes (" + likes.size() + ")",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public int calcularEdad(String fechaNacimiento) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);
			LocalDate hoy = LocalDate.now();
			return Period.between(fechaNac, hoy).getYears();
		} catch (Exception e) {
			System.out.println("⚠️ Error al calcular edad para fecha: " + fechaNacimiento);
			return 0;
		}
	}
	/**
	 * Inicializa la lista de perfiles y muestra el primero. Se llama después de que
	 * las ventanas estén listas.
	 */
	public void inicializarPerfiles() {
		mf.cargarPerfiles();
		mostrarPerfil();
	}

	/**
	 * Muestra todos los usuarios en la tabla del AdminWindow
	 */
	public void mostrarTodosLosUsuarios() {
	    // Recargar datos desde los archivos CSV
	    mf.getmDAO().listaMenDTO.clear();
	    mf.getmDAO().readFromTextFile("Men.csv");
	    
	    mf.getwDAO().listaWomenDTO.clear();
	    mf.getwDAO().readFromTextFile("Women.csv");
	    
	    // Obtener todos los usuarios
	    List<User> todosLosUsuarios = mf.obtenerTodosLosUsuarios();
	    
	    // Limpiar la tabla
	    DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
	    modelo.setRowCount(0);
	    
	    // Llenar la tabla con todos los usuarios
	    for (User usuario : todosLosUsuarios) {
	        // Calcular edad
	        int edad = calcularEdad(usuario.getBornDate());
	        
	        // Obtener ingresos (solo para hombres)
	        String ingresos = "N/A";
	        if (usuario instanceof MenDTO) {
	            MenDTO hombre = (MenDTO) usuario;
	            ingresos = String.format("%.2f", (double) hombre.getMensualIncome());
	        }
	        
	        // Obtener likes (por ahora será 0, puedes implementar un sistema de likes después)
	        int likes = 0;
	        
	        // Agregar fila a la tabla
	        Object[] fila = {
	            usuario.getAlias(),
	            usuario.getName(),
	            usuario.getLastName(),
	            edad,
	            likes,
	            ingresos,
	            usuario.getGender()
	        };
	        modelo.addRow(fila);
	    }
	    
	    // Limpiar los campos de detalle
	    limpiarCamposDetalleAdmin();
	    
	    // Actualizar estadísticas
	    actualizarEstadisticasAdmin();
	    
	    JOptionPane.showMessageDialog(vf.getAw(), 
	        "Se encontraron " + todosLosUsuarios.size() + " usuarios registrados.",
	        "Usuarios cargados", 
	        JOptionPane.INFORMATION_MESSAGE);
	}

	public void mostrarDetalleUsuarioSeleccionado() {
		int filaSeleccionada = vf.getAw().getTablaUsuarios().getSelectedRow();

		if (filaSeleccionada == -1) {
			return; // No hay fila seleccionada
		}

		// Obtener datos de la tabla
		DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
		String alias = (String) modelo.getValueAt(filaSeleccionada, 0);

		// Buscar el usuario completo
		User usuarioSeleccionado = null;

		// Buscar en hombres
		for (MenDTO hombre : mf.getmDAO().listaMenDTO) {
			if (hombre.getAlias().equals(alias)) {
				usuarioSeleccionado = hombre;
				break;
			}
		}

		// Buscar en mujeres si no se encontró
		if (usuarioSeleccionado == null) {
			for (WomenDTO mujer : mf.getwDAO().listaWomenDTO) {
				if (mujer.getAlias().equals(alias)) {
					usuarioSeleccionado = mujer;
					break;
				}
			}
		}

		// Mostrar detalles si se encontró
		if (usuarioSeleccionado != null) {
			vf.getAw().getTxtNombre().setText(usuarioSeleccionado.getName());
			vf.getAw().getTxtApellido().setText(usuarioSeleccionado.getLastName());
			vf.getAw().getTxtAlias().setText(usuarioSeleccionado.getAlias());
			vf.getAw().getTxtEdad().setText(String.valueOf(calcularEdad(usuarioSeleccionado.getBornDate())));
			vf.getAw().getTxtCorreo().setText(usuarioSeleccionado.getEmail());
			vf.getAw().getTxtLikes().setText("0"); // Implementar sistema de likes después

			// Mostrar ingresos si es hombre
			if (usuarioSeleccionado instanceof MenDTO) {
				MenDTO hombre = (MenDTO) usuarioSeleccionado;
				vf.getAw().getTxtIngresos().setText(String.format("%.2f", (double) hombre.getMensualIncome()));
			} else {
				vf.getAw().getTxtIngresos().setText("N/A");
			}

			// Cargar y mostrar foto
			try {
				ImageIcon imagen = new ImageIcon(usuarioSeleccionado.getProfilePictureRoute());
				ImageIcon imagenEscalada = new ImageIcon(
						imagen.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
				vf.getAw().getLblFotoPreview().setIcon(imagenEscalada);
			} catch (Exception ex) {
				vf.getAw().getLblFotoPreview().setIcon(null);
				System.err.println("Error al cargar la imagen: " + ex.getMessage());
			}
		}
	}
	/**
	 * Da de baja (elimina) al usuario seleccionado en la tabla
	 */
	public void darDeBajaUsuario() {
	    int filaSeleccionada = vf.getAw().getTablaUsuarios().getSelectedRow();
	    
	    // Verificar si hay una fila seleccionada
	    if (filaSeleccionada == -1) {
	        JOptionPane.showMessageDialog(vf.getAw(),
	            "Por favor, selecciona un usuario de la tabla para dar de baja.",
	            "Sin selección",
	            JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    // Obtener el alias del usuario seleccionado
	    DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
	    String alias = (String) modelo.getValueAt(filaSeleccionada, 0);
	    String nombre = (String) modelo.getValueAt(filaSeleccionada, 1);
	    String apellido = (String) modelo.getValueAt(filaSeleccionada, 2);
	    
	    // Buscar información completa del usuario
	    User usuario = mf.buscarUsuarioPorAlias(alias);
	    
	    if (usuario == null) {
	        JOptionPane.showMessageDialog(vf.getAw(),
	            "Error: No se encontró el usuario en el sistema.",
	            "Error",
	            JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    // Crear mensaje de confirmación con detalles del usuario
	    String mensajeConfirmacion = String.format(
	        "¿Estás seguro de que deseas dar de baja al siguiente usuario?\n\n" +
	        "Alias: %s\n" +
	        "Nombre: %s %s\n" +
	        "Correo: %s\n" +
	        "País: %s\n\n" +
	        "⚠️ Esta acción NO se puede deshacer.",
	        alias, nombre, apellido, usuario.getEmail(), usuario.getCountry()
	    );
	    
	    // Mostrar diálogo de confirmación
	    int confirmacion = JOptionPane.showConfirmDialog(
	        vf.getAw(),
	        mensajeConfirmacion,
	        "Confirmar dar de baja",
	        JOptionPane.YES_NO_OPTION,
	        JOptionPane.WARNING_MESSAGE
	    );
	    
	    // Si el usuario confirma la eliminación
	    if (confirmacion == JOptionPane.YES_OPTION) {
	        // Eliminar del sistema
	        boolean eliminado = mf.eliminarUsuarioPorAlias(alias);
	        
	        if (eliminado) {
	            // Eliminar de la tabla
	            modelo.removeRow(filaSeleccionada);
	            
	            // Limpiar los campos de detalle
	            limpiarCamposDetalleAdmin();
	            
	            // Mostrar mensaje de éxito
	            JOptionPane.showMessageDialog(vf.getAw(),
	                "✅ Usuario dado de baja exitosamente.\n\n" +
	                "El usuario '" + alias + "' ha sido eliminado del sistema.",
	                "Usuario eliminado",
	                JOptionPane.INFORMATION_MESSAGE);
	            
	            // Actualizar estadísticas si las hay
	            actualizarEstadisticasAdmin();
	            
	        } else {
	            JOptionPane.showMessageDialog(vf.getAw(),
	                "❌ Error al eliminar el usuario del sistema.",
	                "Error",
	                JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

	/**
	 * Limpia los campos de detalle del usuario en AdminWindow
	 */
	private void limpiarCamposDetalleAdmin() {
	    vf.getAw().getTxtNombre().setText("");
	    vf.getAw().getTxtApellido().setText("");
	    vf.getAw().getTxtAlias().setText("");
	    vf.getAw().getTxtEdad().setText("");
	    vf.getAw().getTxtCorreo().setText("");
	    vf.getAw().getTxtLikes().setText("");
	    vf.getAw().getTxtIngresos().setText("");
	    vf.getAw().getLblFotoPreview().setIcon(null);
	}


	/**
	 * Activa/desactiva el modo incógnito
	 */
	public void toggleModoIncognito() {
		boolean modoActual = mf.isModoIncognito();
		mf.setModoIncognito(!modoActual);

		String mensaje = modoActual ? "👀 Modo incógnito DESACTIVADO\n\n• Tu perfil es visible completamente"
				: "🕵️ Modo incógnito ACTIVADO\n\n• Tu perfil aparecerá oculto para otros";

		JOptionPane.showMessageDialog(null, mensaje, "Modo Incógnito", JOptionPane.INFORMATION_MESSAGE);
		mostrarPerfil();
	}
	
	/**
	 * Filtra usuarios por ingresos mínimos (244.85 USD)
	 */
	public void filtrarPorIngresos() {
	    // Recargar datos
	    mf.getmDAO().listaMenDTO.clear();
	    mf.getmDAO().readFromTextFile("Men.csv");
	    
	    double umbralIngresos = 244.85;
	    
	    // Obtener usuarios filtrados
	    List<User> usuariosFiltrados = mf.obtenerUsuariosPorIngresos(umbralIngresos);
	    
	    if (usuariosFiltrados.isEmpty()) {
	        JOptionPane.showMessageDialog(vf.getAw(),
	            "No se encontraron usuarios con ingresos iguales o superiores a $" + umbralIngresos + " USD.",
	            "Sin resultados",
	            JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }
	    
	    // Limpiar la tabla
	    DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
	    modelo.setRowCount(0);
	    
	    // Llenar la tabla con usuarios filtrados
	    for (User usuario : usuariosFiltrados) {
	        int edad = calcularEdad(usuario.getBornDate());
	        
	        MenDTO hombre = (MenDTO) usuario;
	        String ingresos = String.format("%.2f", (double) hombre.getMensualIncome());
	        
	        Object[] fila = {
	            usuario.getAlias(),
	            usuario.getName(),
	            usuario.getLastName(),
	            edad,
	            0, // likes
	            ingresos,
	            usuario.getGender()
	        };
	        modelo.addRow(fila);
	    }
	    
	    // Limpiar campos de detalle
	    limpiarCamposDetalleAdmin();
	    
	    // Mostrar mensaje de éxito
	    JOptionPane.showMessageDialog(vf.getAw(),
	        "✅ Filtro aplicado exitosamente.\n\n" +
	        "Se encontraron " + usuariosFiltrados.size() + " usuario(s) con ingresos ≥ $" + umbralIngresos + " USD.",
	        "Filtro aplicado",
	        JOptionPane.INFORMATION_MESSAGE);
	    
	    // Actualizar estadísticas
	    actualizarEstadisticasFiltro(usuariosFiltrados, "Ingresos ≥ $" + umbralIngresos + " USD");
	}

	/**
	 * Filtra usuarios por género seleccionado
	 */
	public void filtrarPorGenero() {
	    // Recargar datos
	    mf.getmDAO().listaMenDTO.clear();
	    mf.getmDAO().readFromTextFile("Men.csv");
	    
	    mf.getwDAO().listaWomenDTO.clear();
	    mf.getwDAO().readFromTextFile("Women.csv");
	    
	    // Obtener género seleccionado del ComboBox
	    String generoSeleccionado = (String) vf.getAw().getCmbGeneroFiltro().getSelectedItem();
	    
	    if (generoSeleccionado == null || generoSeleccionado.equals("Todos")) {
	        // Si es "Todos", mostrar todos los usuarios
	        mostrarTodosLosUsuarios();
	        return;
	    }
	    
	    // Obtener usuarios filtrados
	    List<User> usuariosFiltrados = mf.obtenerUsuariosPorGenero(generoSeleccionado);
	    
	    if (usuariosFiltrados.isEmpty()) {
	        JOptionPane.showMessageDialog(vf.getAw(),
	            "No se encontraron usuarios del género: " + generoSeleccionado,
	            "Sin resultados",
	            JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }
	    
	    // Limpiar la tabla
	    DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
	    modelo.setRowCount(0);
	    
	    // Llenar la tabla con usuarios filtrados
	    for (User usuario : usuariosFiltrados) {
	        int edad = calcularEdad(usuario.getBornDate());
	        
	        String ingresos = "N/A";
	        if (usuario instanceof MenDTO) {
	            MenDTO hombre = (MenDTO) usuario;
	            ingresos = String.format("%.2f", (double) hombre.getMensualIncome());
	        }
	        
	        Object[] fila = {
	            usuario.getAlias(),
	            usuario.getName(),
	            usuario.getLastName(),
	            edad,
	            0, // likes
	            ingresos,
	            usuario.getGender()
	        };
	        modelo.addRow(fila);
	    }
	    
	    // Limpiar campos de detalle
	    limpiarCamposDetalleAdmin();
	    
	    // Mostrar mensaje de éxito
	    JOptionPane.showMessageDialog(vf.getAw(),
	        "✅ Filtro aplicado exitosamente.\n\n" +
	        "Se encontraron " + usuariosFiltrados.size() + " usuario(s) del género: " + generoSeleccionado,
	        "Filtro aplicado",
	        JOptionPane.INFORMATION_MESSAGE);
	    
	    // Actualizar estadísticas
	    actualizarEstadisticasFiltro(usuariosFiltrados, "Género: " + generoSeleccionado);
	}

	/**
	 * Busca usuarios por alias o correo
	 */
	public void buscarUsuarioAdmin() {
	    String textoBusqueda = vf.getAw().getTxtBuscar().getText().trim();
	    
	    if (textoBusqueda.isEmpty()) {
	        JOptionPane.showMessageDialog(vf.getAw(),
	            "Por favor, ingresa un alias o correo para buscar.",
	            "Campo vacío",
	            JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    // Recargar datos
	    mf.getmDAO().listaMenDTO.clear();
	    mf.getmDAO().readFromTextFile("Men.csv");
	    
	    mf.getwDAO().listaWomenDTO.clear();
	    mf.getwDAO().readFromTextFile("Women.csv");
	    
	    // Buscar en todos los usuarios
	    List<User> todosLosUsuarios = mf.obtenerTodosLosUsuarios();
	    List<User> usuariosEncontrados = new ArrayList<>();
	    
	    for (User usuario : todosLosUsuarios) {
	        if (usuario.getAlias().toLowerCase().contains(textoBusqueda.toLowerCase()) ||
	            usuario.getEmail().toLowerCase().contains(textoBusqueda.toLowerCase())) {
	            usuariosEncontrados.add(usuario);
	        }
	    }
	    
	    if (usuariosEncontrados.isEmpty()) {
	        JOptionPane.showMessageDialog(vf.getAw(),
	            "❌ No se encontraron usuarios que coincidan con: \"" + textoBusqueda + "\"",
	            "Sin resultados",
	            JOptionPane.INFORMATION_MESSAGE);
	        return;
	    }
	    
	    // Limpiar la tabla
	    DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
	    modelo.setRowCount(0);
	    
	    // Llenar la tabla con usuarios encontrados
	    for (User usuario : usuariosEncontrados) {
	        int edad = calcularEdad(usuario.getBornDate());
	        
	        String ingresos = "N/A";
	        if (usuario instanceof MenDTO) {
	            MenDTO hombre = (MenDTO) usuario;
	            ingresos = String.format("%.2f", (double) hombre.getMensualIncome());
	        }
	        
	        Object[] fila = {
	            usuario.getAlias(),
	            usuario.getName(),
	            usuario.getLastName(),
	            edad,
	            0, // likes
	            ingresos,
	            usuario.getGender()
	        };
	        modelo.addRow(fila);
	    }
	    
	    // Limpiar campos de detalle
	    limpiarCamposDetalleAdmin();
	    
	    // Mostrar mensaje de éxito
	    JOptionPane.showMessageDialog(vf.getAw(),
	        "✅ Búsqueda completada.\n\n" +
	        "Se encontraron " + usuariosEncontrados.size() + " usuario(s).",
	        "Resultados de búsqueda",
	        JOptionPane.INFORMATION_MESSAGE);
	    
	    // Actualizar estadísticas
	    actualizarEstadisticasFiltro(usuariosEncontrados, "Búsqueda: \"" + textoBusqueda + "\"");
	}

	/**
	 * Actualiza las estadísticas para mostrar información del filtro aplicado
	 */
	private void actualizarEstadisticasFiltro(List<User> usuariosFiltrados, String criterioFiltro) {
	    if (usuariosFiltrados.isEmpty()) {
	        vf.getAw().getTxtEstadisticas().setText("No hay usuarios que cumplan con el filtro aplicado.");
	        return;
	    }
	    
	    int totalHombres = mf.contarPorGenero(usuariosFiltrados, "Masculino");
	    int totalMujeres = mf.contarPorGenero(usuariosFiltrados, "Femenino");
	    double edadPromedio = mf.calcularEdadPromedio(usuariosFiltrados);
	    double ingresoPromedio = mf.calcularIngresoPromedio(usuariosFiltrados);
	    
	    StringBuilder estadisticas = new StringBuilder();
	    estadisticas.append("📊 Estadísticas del filtro aplicado\n");
	    estadisticas.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
	    estadisticas.append("Filtro: ").append(criterioFiltro).append("\n\n");
	    estadisticas.append("👥 Total de usuarios: ").append(usuariosFiltrados.size()).append("\n");
	    estadisticas.append("♂️  Hombres: ").append(totalHombres).append("\n");
	    estadisticas.append("♀️  Mujeres: ").append(totalMujeres).append("\n");
	    estadisticas.append("📅 Edad promedio: ").append(String.format("%.1f", edadPromedio)).append(" años\n");
	    
	    if (totalHombres > 0) {
	        estadisticas.append("💰 Ingreso promedio: $").append(String.format("%.2f", ingresoPromedio)).append(" USD");
	    }
	    
	    vf.getAw().getTxtEstadisticas().setText(estadisticas.toString());
	}

	/**
	 * Actualiza las estadísticas mostradas en AdminWindow (versión simplificada)
	 */
	private void actualizarEstadisticasAdmin() {
	    List<User> todosLosUsuarios = mf.obtenerTodosLosUsuarios();
	    
	    int totalUsuarios = todosLosUsuarios.size();
	    int totalHombres = mf.contarPorGenero(todosLosUsuarios, "Masculino");
	    int totalMujeres = mf.contarPorGenero(todosLosUsuarios, "Femenino");
	    double edadPromedio = mf.calcularEdadPromedio(todosLosUsuarios);
	    double ingresoPromedio = mf.calcularIngresoPromedio(todosLosUsuarios);
	    int mujeresConDivorcios = mf.contarMujeresConDivorcios(todosLosUsuarios);
	    String paisMasUsuarios = mf.encontrarPaisMasUsuarios(todosLosUsuarios);
	    
	    double porcentajeHombres = totalUsuarios > 0 ? (totalHombres * 100.0 / totalUsuarios) : 0;
	    double porcentajeMujeres = totalUsuarios > 0 ? (totalMujeres * 100.0 / totalUsuarios) : 0;
	    double porcentajeDivorcios = totalMujeres > 0 ? (mujeresConDivorcios * 100.0 / totalMujeres) : 0;
	    
	    StringBuilder estadisticas = new StringBuilder();
	    estadisticas.append("📊 Estadísticas generales del sistema\n");
	    estadisticas.append("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
	    estadisticas.append("👥 Total de usuarios: ").append(totalUsuarios).append("\n");
	    estadisticas.append("♂️  Hombres: ").append(totalHombres);
	    estadisticas.append(" (").append(String.format("%.1f%%", porcentajeHombres)).append(")\n");
	    estadisticas.append("♀️  Mujeres: ").append(totalMujeres);
	    estadisticas.append(" (").append(String.format("%.1f%%", porcentajeMujeres)).append(")\n");
	    estadisticas.append("📅 Edad promedio: ").append(String.format("%.1f", edadPromedio)).append(" años\n");
	    estadisticas.append("💰 Ingreso promedio (♂️): $").append(String.format("%.2f", ingresoPromedio)).append(" USD\n");
	    estadisticas.append("💔 Mujeres con divorcios: ").append(mujeresConDivorcios);
	    estadisticas.append(" (").append(String.format("%.1f%%", porcentajeDivorcios)).append(")\n");
	    
	    if (!paisMasUsuarios.isEmpty()) {
	        estadisticas.append("🌍 País con más usuarios: ").append(paisMasUsuarios);
	    }
	    
	    vf.getAw().getTxtEstadisticas().setText(estadisticas.toString());
	}

	public void run() {
		vf.getPw().setVisible(true);
		inicializarPerfiles();
	}
}
