package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

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
import co.edu.unbosque.view.ViewFacade;
import co.edu.unbosque.model.User;

public class Controller implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;
	private Properties prop;

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		prop = new Properties();
		asignarOyentes();
	}

	public void asignarOyentes() {
		// ---------- BOTONES en PrincipalWindow ----------
		vf.getPw().getStart().addActionListener(this);
		vf.getPw().getStart().setActionCommand("boton_start");

		vf.getPw().getDarkMode().addActionListener(this);
		vf.getPw().getDarkMode().setActionCommand("boton_modo_oscuro");

		vf.getPw().getbSpanish().addActionListener(this);
		vf.getPw().getbSpanish().setActionCommand("internacionalizacion_esp");

		vf.getPw().getbChinnesse().addActionListener(this);
		vf.getPw().getbChinnesse().setActionCommand("internacionalizacion_chi");

		vf.getPw().getbHebrew().addActionListener(this);
		vf.getPw().getbHebrew().setActionCommand("internacionalizacion_heb");

		vf.getPw().getbPortuguese().addActionListener(this);
		vf.getPw().getbPortuguese().setActionCommand("internacionalizacion_por");

		vf.getPw().getbRussian().addActionListener(this);
		vf.getPw().getbRussian().setActionCommand("internacionalizacion_rus");

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

		vf.getLw().getAdminMode().addActionListener(this);
		vf.getLw().getAdminMode().setActionCommand("boton_entrar_modo_admin");

		// ---------- BOTONES en MyProfileWindow ----------

		vf.getMpw().getBtnback().addActionListener(this);
		vf.getMpw().getBtnback().setActionCommand("boton_volver_myprofile");

		vf.getMpw().getBtnclose().addActionListener(this);
		vf.getMpw().getBtnclose().setActionCommand("boton_cerrarsesion_myprofile");

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

		vf.getAw().getBtnGenerarPDF().addActionListener(this);
		vf.getAw().getBtnGenerarPDF().setActionCommand("boton_generar_pdf");

		// ---------- BOTONES en PreferencesWindow ----------
		vf.getPrefw().getBtnAceptar().addActionListener(this);
		vf.getPrefw().getBtnAceptar().setActionCommand("boton_aceptar_preferencias");

		vf.getPrefw().getBtnCancelar().addActionListener(this);
		vf.getPrefw().getBtnCancelar().setActionCommand("boton_cancelar_preferencias");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String alias = e.getActionCommand();
		switch (alias) {
		case "boton_start":
			vf.getPw().setVisible(false);
			vf.getSw().setVisible(true);
			break;

		case "boton_modo_oscuro":
			vf.aplicarModoOscuro();

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
			vf.getMpw().revalidate();
			vf.getMpw().repaint();
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

		case "internacionalizacion_por":
			aplicarInternacionalizacion("pt");
			break;

		case "internacionalizacion_chi":
			aplicarInternacionalizacion("chi");
			break;

		case "internacionalizacion_heb":
			aplicarInternacionalizacion("heb");
			break;

		case "internacionalizacion_rus":
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
			vf.getSw().setVisible(false);
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
			vf.getSw().setVisible(false);
			vf.getPw().setVisible(true);
			break;

		case "verificar_correo": {
			try {
				String correo = vf.getRw().getTxtCorreo().getText().trim();

				if (correoYaRegistrado(correo)) {
					JOptionPane.showMessageDialog(null,
							"Este correo electrónico ya está registrado en el sistema.\n\n"
									+ "Por favor, utiliza otro correo o inicia sesión con tu cuenta existente.",
							"Correo Ya Registrado", JOptionPane.ERROR_MESSAGE);
					vf.getRw().setCorreoVerificado(false);
					break;
				}

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

				// --- Verificación

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

				if (correoYaRegistrado(correo)) {
					JOptionPane.showMessageDialog(null,
							"Este correo electrónico ya fue registrado recientemente.\n\n"
									+ "Por favor, verifica con otro correo",
							"Correo Ya Registrado", JOptionPane.ERROR_MESSAGE);
					vf.getRw().setCorreoVerificado(false);
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
					ExceptionLauncher.verifyIncome(ingresosStr, pais);


					long ingresos = Long.parseLong(ingresosStr);
					if (ingresos < 0) {
						throw new NumberFormatException("Los ingresos no pueden ser negativos");
					}

					double ingresosUSD = convertirMonedaADolares(ingresos, pais);
					if (ingresosUSD == -1) {
						throw new Exception("Error al convertir moneda para el país: " + pais);
					}

					String rutaFoto = vf.getRw().getRutaImagenSeleccionada();

					MenDTO hombre = new MenDTO(nombres, apellidos, apodo, fechaNacimiento, estatura, correo, genero,
							orientacion, rutaFoto, pais, password, (long) ingresosUSD, prop);
					mf.getmDAO().create(hombre);
				} else if (genero.equals("Femenino")) {
					String estatura = vf.getRw().getTxtEstatura().getText();
					String orientacion = (String) vf.getRw().getCmbOrientacion().getSelectedItem();
					String divorciosStr = (String) vf.getRw().getCmbDivorcios().getSelectedItem();

					if (!estatura.isEmpty()) {
						ExceptionLauncher.verifyStature(estatura);
					}
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

		case "boton_entrar_modo_admin": {

			String ADMIN_PASSWORD = "CarlosLlegueYa";
			String passwordIngresada = JOptionPane.showInputDialog(vf.getLw(),
					"Ingrese la contraseña de administrador:", "Acceso Restringido", JOptionPane.WARNING_MESSAGE);

			if (passwordIngresada == null) {
				JOptionPane.showMessageDialog(vf.getLw(), "Acceso al modo administrador cancelado.", "Cancelado",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			}

			if (ADMIN_PASSWORD.equals(passwordIngresada.trim())) {

				JOptionPane.showMessageDialog(vf.getLw(), "Contraseña correcta. Accediendo al modo administrador...",
						"Acceso Permitido", JOptionPane.INFORMATION_MESSAGE);

				vf.getLw().setVisible(false);
				vf.getAw().setVisible(true);

				mostrarTodosLosUsuarios();

			} else {

				JOptionPane.showMessageDialog(vf.getLw(), "Contraseña incorrecta. Acceso denegado.",
						"Error de Autenticación", JOptionPane.ERROR_MESSAGE);
			}
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

				// ✅ NUEVO: Mostrar PreferencesWindow para capturar preferencias
				mostrarVentanaPreferencias();

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
			mostrarMiPerfil();
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

		case "boton_mostrar_todos_admin": {
			mostrarTodosLosUsuarios();
			break;
		}

		case "boton_modo_incognito": {
			toggleModoIncognito();
			break;
		}

		case "boton_filtro_top10_admin": {
			// Ahora que los likes están implementados, podemos usar este filtro
			List<User> top10Usuarios = mf.obtenerUsuariosMasPopulares(10);

			if (top10Usuarios.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getAw(), "No hay usuarios con likes para mostrar.", "Sin resultados",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			}

			// Limpiar la tabla
			DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
			modelo.setRowCount(0);

			// Llenar la tabla con el top 10
			for (User usuario : top10Usuarios) {
				int edad = calcularEdad(usuario.getBornDate());

				String ingresos = "N/A";
				if (usuario instanceof MenDTO) {
					MenDTO hombre = (MenDTO) usuario;
					ingresos = String.format("%.2f", (double) hombre.getMensualIncome());
				}

				Object[] fila = { usuario.getAlias(), usuario.getName(), usuario.getLastName(), edad,
						usuario.getLikes(), ingresos, usuario.getGender() };
				modelo.addRow(fila);
			}

			JOptionPane.showMessageDialog(vf.getAw(), "✅ Top 10 usuarios más populares cargados.", "Filtro aplicado",
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

		case "boton_salir_admin": {
			vf.getAw().dispose();
			vf.getSw().setVisible(true);
			break;
		}

		case "boton_ver_perfil": {
			mostrarMiPerfil();
			break;
		}

		case "boton_orden_ascendente_admin": {
			manejarOrdenAscendente();
			break;
		}

		case "boton_orden_descendente_admin": {
			manejarOrdenDescendente();
			break;
		}

		case "boton_generar_pdf": {
			generarPDFUsuarioSeleccionado();
			break;
		}

		case "boton_volver_perfil": {
			vf.getMpw().setVisible(false);
			vf.getMmw().setVisible(true);
			break;
		}

		case "boton_cerrar_sesion_perfil": {
			int confirmacion = JOptionPane.showConfirmDialog(vf.getMpw(), "¿Estás seguro de que deseas cerrar sesión?",
					"Confirmar cierre de sesión", JOptionPane.YES_NO_OPTION);

			if (confirmacion == JOptionPane.YES_OPTION) {
				vf.getMpw().dispose();
				vf.getSw().setVisible(true);

				// Limpiar usuario actual
				mf.setUsuarioActual(null);
			}
			break;
		}
		case "boton_volver_myprofile": {
			vf.getMpw().dispose();
			vf.getMmw().setVisible(true);
			break;
		}

		case "boton_cerrarsesion_myprofile": {
			vf.getMmw().dispose();
			vf.getPw().setVisible(true);
			break;
		}

		case "boton_aceptar_preferencias": {
			aplicarYGuardarPreferencias();
			break;
		}

		case "boton_cancelar_preferencias": {
			vf.getPrefw().setAceptado(false);
			vf.getPrefw().setVisible(false);
			mf.cargarPerfiles(mf.getUsuarioActual());
			vf.getMmw().setVisible(true);
			mostrarPerfil();
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

			vf.aplicarInternacionalizacion(prop);
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
			vf.getMpw().revalidate();
			vf.getMpw().repaint();

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error al aplicar internacionalización: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	public void mostrarPerfilMain() {
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
			JOptionPane.showMessageDialog(null, "Aún no has dado like a nadie");
			return;
		}

		StringBuilder sb = new StringBuilder("Usuarios que te gustaron:\n\n");
		for (User u : likes) {
			sb.append("- ").append(u.getName()).append(" ").append(u.getLastName()).append("\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString());
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
		mf.getmDAO().listaMenDTO.clear();
		mf.getmDAO().readFromTextFile("Men.csv");

		mf.getwDAO().listaWomenDTO.clear();
		mf.getwDAO().readFromTextFile("Women.csv");

		// Cargar lista combinada de perfiles
		mf.cargarPerfiles();

		// El perfil se mostrará solo cuando el usuario entre a MainWindow
		mostrarPerfilMain();
	}

	/**
	 * Muestra todos los usuarios en la tabla del AdminWindow
	 */
	public void mostrarTodosLosUsuarios() {

		// --- Recargar datos desde los archivos CSV ---
		mf.getmDAO().listaMenDTO.clear();
		mf.getmDAO().readFromTextFile("Men.csv");

		mf.getwDAO().listaWomenDTO.clear();
		mf.getwDAO().readFromTextFile("Women.csv");

		List<User> todosLosUsuarios = mf.obtenerTodosLosUsuarios();

		// --- Resto del código igual ---
		DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
		modelo.setRowCount(0);

		for (User usuario : todosLosUsuarios) {
			int edad = calcularEdad(usuario.getBornDate());
			String ingresos = "N/A";
			if (usuario instanceof MenDTO) {
				MenDTO hombre = (MenDTO) usuario;
				ingresos = String.format("%.2f", (double) hombre.getMensualIncome());
			}
			int likesReales = usuario.getLikes();
			Object[] fila = { usuario.getAlias(), usuario.getName(), usuario.getLastName(), edad, likesReales, ingresos,
					usuario.getGender() };
			modelo.addRow(fila);
		}

		limpiarCamposDetalleAdmin();
		actualizarEstadisticasAdmin();

		JOptionPane.showMessageDialog(vf.getAw(),
				"Se encontraron " + todosLosUsuarios.size() + " usuarios registrados.", "Usuarios cargados",
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
		User usuarioSeleccionado = mf.buscarUsuarioPorAlias(alias);

		// Mostrar detalles si se encontró
		if (usuarioSeleccionado != null) {
			vf.getAw().getTxtNombre().setText(usuarioSeleccionado.getName());
			vf.getAw().getTxtApellido().setText(usuarioSeleccionado.getLastName());
			vf.getAw().getTxtAlias().setText(usuarioSeleccionado.getAlias());
			vf.getAw().getTxtEdad().setText(String.valueOf(calcularEdad(usuarioSeleccionado.getBornDate())));
			vf.getAw().getTxtCorreo().setText(usuarioSeleccionado.getEmail());

			// Mostrar los likes REALES del usuario (desde la clase User)
			vf.getAw().getTxtLikes().setText(String.valueOf(usuarioSeleccionado.getLikes()));

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
			JOptionPane.showMessageDialog(vf.getAw(), "Por favor, selecciona un usuario de la tabla para dar de baja.",
					"Sin selección", JOptionPane.WARNING_MESSAGE);
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
			JOptionPane.showMessageDialog(vf.getAw(), "Error: No se encontró el usuario en el sistema.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Crear mensaje de confirmación con detalles del usuario
		String mensajeConfirmacion = String.format(
				"¿Estás seguro de que deseas dar de baja al siguiente usuario?\n\n" + "Alias: %s\n" + "Nombre: %s %s\n"
						+ "Correo: %s\n" + "País: %s\n\n" + "⚠️ Esta acción NO se puede deshacer.",
				alias, nombre, apellido, usuario.getEmail(), usuario.getCountry());

		// Mostrar diálogo de confirmación
		int confirmacion = JOptionPane.showConfirmDialog(vf.getAw(), mensajeConfirmacion, "Confirmar dar de baja",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

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
						"✅ Usuario dado de baja exitosamente.\n\n" + "El usuario '" + alias
								+ "' ha sido eliminado del sistema.",
						"Usuario eliminado", JOptionPane.INFORMATION_MESSAGE);

				// Actualizar estadísticas si las hay
				actualizarEstadisticasAdmin();

			} else {
				JOptionPane.showMessageDialog(vf.getAw(), "❌ Error al eliminar el usuario del sistema.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Limpia los campos de detalle del usuario en AdminWindow
	 */
	public void limpiarCamposDetalleAdmin() {
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
		if (!vf.getMmw().isVisible())
			return;

		boolean modoActual = mf.isModoIncognito();
		mf.setModoIncognito(!modoActual);

		String mensaje = modoActual ? "Modo incógnito DESACTIVADO\n\n• Tu perfil es visible completamente"
				: "Modo incógnito ACTIVADO\n\n• Tu perfil aparecerá oculto para otros";

		JOptionPane.showMessageDialog(null, mensaje, "Modo Incógnito", JOptionPane.INFORMATION_MESSAGE);
		mostrarPerfilMain();
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
					"Sin resultados", JOptionPane.INFORMATION_MESSAGE);
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

			Object[] fila = { usuario.getAlias(), usuario.getName(), usuario.getLastName(), edad, 0, // likes
					ingresos, usuario.getGender() };
			modelo.addRow(fila);
		}

		// Limpiar campos de detalle
		limpiarCamposDetalleAdmin();

		// Mostrar mensaje de éxito
		JOptionPane.showMessageDialog(vf.getAw(),
				"Filtro aplicado exitosamente.\n\n" + "Se encontraron " + usuariosFiltrados.size()
						+ " usuario(s) con ingresos >= $" + umbralIngresos + " USD.",
				"Filtro aplicado", JOptionPane.INFORMATION_MESSAGE);

		// Actualizar estadísticas
		actualizarEstadisticasFiltro(usuariosFiltrados, "Ingresos >= $" + umbralIngresos + " USD");
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
			JOptionPane.showMessageDialog(vf.getAw(), "No se encontraron usuarios del género: " + generoSeleccionado,
					"Sin resultados", JOptionPane.INFORMATION_MESSAGE);
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

			Object[] fila = { usuario.getAlias(), usuario.getName(), usuario.getLastName(), edad, 0, // likes
					ingresos, usuario.getGender() };
			modelo.addRow(fila);
		}

		// Limpiar campos de detalle
		limpiarCamposDetalleAdmin();

		// Mostrar mensaje de éxito
		JOptionPane.showMessageDialog(vf.getAw(),
				"Filtro aplicado exitosamente.\n\n" + "Se encontraron " + usuariosFiltrados.size()
						+ " usuario(s) del género: " + generoSeleccionado,
				"Filtro aplicado", JOptionPane.INFORMATION_MESSAGE);

		// Actualizar estadísticas
		actualizarEstadisticasFiltro(usuariosFiltrados, "Género: " + generoSeleccionado);
	}

	/**
	 * Busca usuarios por alias o correo
	 */
	public void buscarUsuarioAdmin() {
		String textoBusqueda = vf.getAw().getTxtBuscar().getText().trim();

		if (textoBusqueda.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getAw(), "Por favor, ingresa un alias o correo para buscar.",
					"Campo vacío", JOptionPane.WARNING_MESSAGE);
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
			if (usuario.getAlias().toLowerCase().contains(textoBusqueda.toLowerCase())
					|| usuario.getEmail().toLowerCase().contains(textoBusqueda.toLowerCase())) {
				usuariosEncontrados.add(usuario);
			}
		}

		if (usuariosEncontrados.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getAw(),
					"No se encontraron usuarios que coincidan con: \"" + textoBusqueda + "\"", "Sin resultados",
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

			Object[] fila = { usuario.getAlias(), usuario.getName(), usuario.getLastName(), edad, 0, // likes
					ingresos, usuario.getGender() };
			modelo.addRow(fila);
		}

		// Limpiar campos de detalle
		limpiarCamposDetalleAdmin();

		// Mostrar mensaje de éxito
		JOptionPane.showMessageDialog(vf.getAw(),
				"Búsqueda completada.\n\n" + "Se encontraron " + usuariosEncontrados.size() + " usuario(s).",
				"Resultados de búsqueda", JOptionPane.INFORMATION_MESSAGE);

		// Actualizar estadísticas
		actualizarEstadisticasFiltro(usuariosEncontrados, "Búsqueda: \"" + textoBusqueda + "\"");
	}

	/**
	 * Actualiza las estadísticas para mostrar información del filtro aplicado
	 */
	public void actualizarEstadisticasFiltro(List<User> usuariosFiltrados, String criterioFiltro) {
		if (usuariosFiltrados.isEmpty()) {
			vf.getAw().getTxtEstadisticas().setText("No hay usuarios que cumplan con el filtro aplicado.");
			return;
		}

		int totalHombres = mf.contarPorGenero(usuariosFiltrados, "Masculino");
		int totalMujeres = mf.contarPorGenero(usuariosFiltrados, "Femenino");
		double edadPromedio = mf.calcularEdadPromedio(usuariosFiltrados);
		double ingresoPromedio = mf.calcularIngresoPromedio(usuariosFiltrados);

		StringBuilder estadisticas = new StringBuilder();
		estadisticas.append("Estadísticas del filtro aplicado\n");
		estadisticas.append("=========================================\n");
		estadisticas.append("Filtro: ").append(criterioFiltro).append("\n\n");
		estadisticas.append("Total de usuarios: ").append(usuariosFiltrados.size()).append("\n");
		estadisticas.append("Hombres: ").append(totalHombres).append("\n");
		estadisticas.append("Mujeres: ").append(totalMujeres).append("\n");
		estadisticas.append("Edad promedio: ").append(String.format("%.1f", edadPromedio)).append(" años\n");

		if (totalHombres > 0) {
			estadisticas.append("Ingreso promedio: $").append(String.format("%.2f", ingresoPromedio)).append(" USD");
		}

		vf.getAw().getTxtEstadisticas().setText(estadisticas.toString());
	}

	/**
	 * Actualiza las estadísticas mostradas en AdminWindow
	 */
	public void actualizarEstadisticasAdmin() {
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
		estadisticas.append("Estadísticas generales del sistema\n");
		estadisticas.append("=========================================\n");
		estadisticas.append("Total de usuarios: ").append(totalUsuarios).append("\n");
		estadisticas.append("Hombres: ").append(totalHombres);
		estadisticas.append(" (").append(String.format("%.1f%%", porcentajeHombres)).append(")\n");
		estadisticas.append("Mujeres: ").append(totalMujeres);
		estadisticas.append(" (").append(String.format("%.1f%%", porcentajeMujeres)).append(")\n");
		estadisticas.append("Edad promedio: ").append(String.format("%.1f", edadPromedio)).append(" años\n");
		estadisticas.append("Ingreso promedio (Hombres): $").append(String.format("%.2f", ingresoPromedio))
				.append(" USD\n");
		estadisticas.append("Mujeres con divorcios: ").append(mujeresConDivorcios);
		estadisticas.append(" (").append(String.format("%.1f%%", porcentajeDivorcios)).append(")\n");

		if (!paisMasUsuarios.isEmpty()) {
			estadisticas.append("País con más usuarios: ").append(paisMasUsuarios);
		}

		vf.getAw().getTxtEstadisticas().setText(estadisticas.toString());
	}

	/**
	 * Muestra el perfil actual en la ventana principal
	 */
	public void mostrarPerfil() {
		User actual = mf.getPerfilActual();

		if (actual == null) {
			JOptionPane.showMessageDialog(vf.getMmw(),
					"No hay más perfiles por mostrar.\nHas visto todos los perfiles disponibles!", "Fin de perfiles",
					JOptionPane.INFORMATION_MESSAGE);

			// Limpiar la ventana
			vf.getMmw().getLblNameAge().setText("No hay más perfiles");
			vf.getMmw().getTxtDescription().setText("Has visto todos los perfiles disponibles.");
			vf.getMmw().getLblProfilePicture().setIcon(null);
			return;
		}

		// --- Calcular edad a partir de la fecha de nacimiento ---
		int edad = calcularEdad(actual.getBornDate());

		// --- Mostrar nombre y apellido ---
		vf.getMmw().getLblNameAge().setText(actual.getName() + " " + actual.getLastName() + ", " + edad);

		// --- Construir descripción según el tipo de usuario ---
		StringBuilder descripcion = new StringBuilder();
		descripcion.append("Alias: ").append(actual.getAlias()).append("\n\n");

		if (actual instanceof MenDTO) {
			MenDTO hombre = (MenDTO) actual;
			descripcion.append("Género: ").append(actual.getGender()).append("\n");
			descripcion.append("Orientación: ").append(actual.getSexualOrientation()).append("\n");
			descripcion.append("Estatura: ").append(actual.getStature()).append(" m\n");
			descripcion.append("País: ").append(actual.getCountry()).append("\n");
			descripcion.append("Edad: ").append(edad).append(" años\n");
			descripcion.append("Ingresos: $").append(String.format("%.2f", (double) hombre.getMensualIncome()))
					.append(" USD\n");
		} else if (actual instanceof WomenDTO) {
			WomenDTO mujer = (WomenDTO) actual;
			descripcion.append("Género: ").append(actual.getGender()).append("\n");
			descripcion.append("Orientación: ").append(actual.getSexualOrientation()).append("\n");
			descripcion.append("Estatura: ").append(actual.getStature()).append(" m\n");
			descripcion.append("País: ").append(actual.getCountry()).append("\n");
			descripcion.append("Edad: ").append(edad).append(" años\n");
			descripcion.append("Divorcios: ").append(mujer.isHadDivorces() ? "Sí" : "No").append("\n");
		}

		vf.getMmw().getTxtDescription().setText(descripcion.toString());

		// --- Mostrar imagen de perfil ---
		try {
			String rutaImagen = actual.getProfilePictureRoute();

			if (rutaImagen != null && !rutaImagen.isEmpty()) {
				ImageIcon imagenOriginal = new ImageIcon(rutaImagen);

				// Verificar si la imagen se cargó correctamente
				if (imagenOriginal.getIconWidth() > 0) {
					// Escalar la imagen al tamaño del JLabel (350x350)
					Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
					ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
					vf.getMmw().getLblProfilePicture().setIcon(iconoEscalado);
				} else {
					// Si no se pudo cargar, mostrar icono por defecto
					mostrarImagenPorDefecto();
				}
			} else {
				mostrarImagenPorDefecto();
			}
		} catch (Exception e) {
			System.err.println("Error al cargar imagen de perfil: " + e.getMessage());
			mostrarImagenPorDefecto();
		}
	}

	/**
	 * Muestra una imagen por defecto cuando no hay foto de perfil
	 */
	public void mostrarImagenPorDefecto() {
		vf.getMmw().getLblProfilePicture().setIcon(null);
		vf.getMmw().getLblProfilePicture().setText("Sin foto disponible");
		vf.getMmw().getLblProfilePicture().setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void manejarOrdenAscendente() {
		String genero = (String) vf.getAw().getCmbGeneroFiltro().getSelectedItem();
		if (genero == null || genero.equalsIgnoreCase("Todos")) {
			JOptionPane.showMessageDialog(vf.getAw(),
					"Selecciona 'Masculino' o 'Femenino' en el filtro antes de ordenar.", "Aviso",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (genero.equalsIgnoreCase("Masculino")) {
			mf.getmDAO().selectionSortAsc();

			DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
			modelo.setRowCount(0);
			for (MenDTO m : mf.getmDAO().listaMenDTO) {
				int edad = calcularEdad(m.getBornDate());
				String ingresos = String.format("%.2f", (double) m.getMensualIncome());
				modelo.addRow(new Object[] { m.getAlias(), m.getName(), m.getLastName(), edad, m.getLikes(), ingresos,
						m.getGender() });
			}
		} else if (genero.equalsIgnoreCase("Femenino")) {
			// Ordenar la lista de mujeres
			mf.getwDAO().selectionSortAsc();

			// Repintar la tabla con la lista ordenada
			DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
			modelo.setRowCount(0);
			for (WomenDTO w : mf.getwDAO().listaWomenDTO) {
				int edad = calcularEdad(w.getBornDate());
				String ingresos = "N/A";
				modelo.addRow(new Object[] { w.getAlias(), w.getName(), w.getLastName(), edad, w.getLikes(), ingresos,
						w.getGender() });
			}
		}
	}

	public void manejarOrdenDescendente() {
		String genero = (String) vf.getAw().getCmbGeneroFiltro().getSelectedItem();
		if (genero == null || genero.equalsIgnoreCase("Todos")) {
			JOptionPane.showMessageDialog(vf.getAw(),
					"Selecciona 'Masculino' o 'Femenino' en el filtro antes de ordenar.", "Aviso",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (genero.equalsIgnoreCase("Masculino")) {
			mf.getmDAO().insertionSortDes();

			DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
			modelo.setRowCount(0);
			for (MenDTO m : mf.getmDAO().listaMenDTO) {
				int edad = calcularEdad(m.getBornDate());
				String ingresos = String.format("%.2f", (double) m.getMensualIncome());
				modelo.addRow(new Object[] { m.getAlias(), m.getName(), m.getLastName(), edad, m.getLikes(), ingresos,
						m.getGender() });
			}
		} else if (genero.equalsIgnoreCase("Femenino")) {
			mf.getwDAO().insertionSortDes();

			DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
			modelo.setRowCount(0);
			for (WomenDTO w : mf.getwDAO().listaWomenDTO) {
				int edad = calcularEdad(w.getBornDate());
				String ingresos = "N/A";
				modelo.addRow(new Object[] { w.getAlias(), w.getName(), w.getLastName(), edad, w.getLikes(), ingresos,
						w.getGender() });
			}
		}
	}

	/**
	 * Muestra el perfil del usuario actual en MyProfileWindow
	 */
	public void mostrarMiPerfil() {
		User usuarioActual = mf.getUsuarioActual();

		if (usuarioActual == null) {
			JOptionPane.showMessageDialog(vf.getMmw(),
					"No se pudo cargar la información del perfil.\nPor favor, inicia sesión nuevamente.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Calcular edad
		int edad = calcularEdad(usuarioActual.getBornDate());

		// Llenar los campos de texto con la información del usuario
		vf.getMpw().getTxtNombre().setText(usuarioActual.getName());
		vf.getMpw().getTxtApellido().setText(usuarioActual.getLastName());
		vf.getMpw().getTxtAlias().setText(usuarioActual.getAlias());
		vf.getMpw().getTxtEdad().setText(String.valueOf(edad));
		vf.getMpw().getTxtCorreo().setText(usuarioActual.getEmail());
		vf.getMpw().getTxtLikes().setText(String.valueOf(usuarioActual.getLikes()));

		// Mostrar información específica según el género
		if (usuarioActual instanceof MenDTO) {
			MenDTO hombre = (MenDTO) usuarioActual;
			vf.getMpw().getTxtIngresos()
					.setText("$" + String.format("%.2f", (double) hombre.getMensualIncome()) + " USD");
		} else if (usuarioActual instanceof WomenDTO) {
			WomenDTO mujer = (WomenDTO) usuarioActual;
			vf.getMpw().getTxtIngresos().setText(mujer.isHadDivorces() ? "Ha tenido divorcios" : "Sin divorcios");
		} else {
			vf.getMpw().getTxtIngresos().setText("N/A");
		}

		// Cargar y mostrar foto de perfil
		try {
			String rutaImagen = usuarioActual.getProfilePictureRoute();

			if (rutaImagen != null && !rutaImagen.isEmpty()) {
				ImageIcon imagenOriginal = new ImageIcon(rutaImagen);

				if (imagenOriginal.getIconWidth() > 0) {
					// Escalar la imagen para el preview (100x100)
					Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
					ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
					vf.getMpw().getLblFotoPreview().setIcon(iconoEscalado);
					vf.getMpw().getLblFotoPreview().setText("");
				} else {
					vf.getMpw().getLblFotoPreview().setIcon(null);
					vf.getMpw().getLblFotoPreview().setText("Sin foto");
				}
			} else {
				vf.getMpw().getLblFotoPreview().setIcon(null);
				vf.getMpw().getLblFotoPreview().setText("Sin foto");
			}
		} catch (Exception e) {
			System.err.println("Error al cargar imagen de perfil: " + e.getMessage());
			vf.getMpw().getLblFotoPreview().setIcon(null);
			vf.getMpw().getLblFotoPreview().setText("Error al cargar");
		}

		// Actualizar el número grande de likes en el panel lateral
		try {
			Component[] components = vf.getMpw().getContentPane().getComponents();
			for (Component comp : components) {
				if (comp instanceof JPanel) {
					JPanel panel = (JPanel) comp;
					Component[] panelComps = panel.getComponents();
					for (Component panelComp : panelComps) {
						if (panelComp instanceof JLabel) {
							JLabel label = (JLabel) panelComp;
							// Buscar el label que muestra el número de likes (fuente grande)
							if (label.getFont() != null && label.getFont().getSize() == 48) {
								label.setText(String.valueOf(usuarioActual.getLikes()));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.err.println("Error al actualizar likes visuales: " + e.getMessage());
		}

		// Mostrar la ventana de perfil
		vf.getMmw().setVisible(false);
		vf.getMpw().setVisible(true);
	}

	public void generarPDFUsuarioSeleccionado() {
		String aliasSeleccionado = vf.getAw().getTxtBuscar().getText().trim(); // o el campo donde se muestra el alias

		if (aliasSeleccionado.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getAw(), "Por favor ingresa o selecciona un alias válido.", "Alias vacío",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		MenDTO men = mf.getmDAO().listaMenDTO.stream().filter(m -> m.getAlias().equalsIgnoreCase(aliasSeleccionado))
				.findFirst().orElse(null);

		if (men != null) {
			mf.getmDAO().generarInformePDF(aliasSeleccionado);
			return;
		}

		WomenDTO woman = mf.getwDAO().listaWomenDTO.stream()
				.filter(w -> w.getAlias().equalsIgnoreCase(aliasSeleccionado)).findFirst().orElse(null);

		if (woman != null) {
			mf.getwDAO().generarInformePDF(aliasSeleccionado);
			return;
		}

		JOptionPane.showMessageDialog(vf.getAw(), "No se encontró ningún usuario con ese alias.",
				"Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
	}

	
	/**
	 * Verifica si un correo electrónico ya está registrado en el sistema
	 * 
	 * @param correo El correo a verificar
	 * @return true si el correo ya está registrado, false si está disponible
	 */
	public boolean correoYaRegistrado(String correo) {

		mf.getmDAO().listaMenDTO.clear();
		mf.getmDAO().readFromTextFile("Men.csv");

		mf.getwDAO().listaWomenDTO.clear();
		mf.getwDAO().readFromTextFile("Women.csv");

		String correoLower = correo.toLowerCase().trim();

		// Buscar en hombres
		for (MenDTO hombre : mf.getmDAO().listaMenDTO) {
			if (hombre.getEmail() != null && hombre.getEmail().toLowerCase().trim().equals(correoLower)) {
				return true;
			}
		}

		// Buscar en mujeres
		for (WomenDTO mujer : mf.getwDAO().listaWomenDTO) {
			if (mujer.getEmail() != null && mujer.getEmail().toLowerCase().trim().equals(correoLower)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Solicita las preferencias del usuario según su género y filtra los perfiles
	 * disponibles
	 */
	public void solicitarPreferenciasUsuario() {
		User usuarioActual = mf.getUsuarioActual();

		if (usuarioActual == null) {
			return;
		}

		// Limpiar campos anteriores
		vf.getPrefw().limpiarCampos();

		// Configurar ventana según género
		if (usuarioActual instanceof MenDTO) {
			vf.getPrefw().configurarParaHombres();
		} else if (usuarioActual instanceof WomenDTO) {
			vf.getPrefw().configurarParaMujeres();
		}

		// Mostrar ventana de preferencias
		vf.getPrefw().setVisible(true);
	}

	/**
	 * Aplica las preferencias seleccionadas por el usuario
	 */
	private void aplicarPreferencias() {
		User usuarioActual = mf.getUsuarioActual();

		if (usuarioActual == null) {
			return;
		}

		try {
			if (usuarioActual instanceof MenDTO) {
				// Obtener valores para hombres
				int edadMin = Integer.parseInt(vf.getPrefw().getTxtEdadMin().getText().trim());
				int edadMax = Integer.parseInt(vf.getPrefw().getTxtEdadMax().getText().trim());
				String preferenciaDiv = (String) vf.getPrefw().getCmbDivorcios().getSelectedItem();

				// Validar rango de edad
				if (edadMin < 18 || edadMax > 100 || edadMin > edadMax) {
					JOptionPane.showMessageDialog(vf.getPrefw(),
							"Rango de edad inválido. La edad mínima debe ser 18 o más, y la edad máxima debe ser mayor que la mínima.",
							"Error de validación", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Filtrar perfiles
				vf.getPrefw().setAceptado(true);
				vf.getPrefw().setVisible(false);
				filtrarPerfilesPorPreferenciasHombres(edadMin, edadMax, preferenciaDiv);
				vf.getMmw().setVisible(true);
				mostrarPerfil();

			} else if (usuarioActual instanceof WomenDTO) {
				// Obtener valores para mujeres
				int edadMin = Integer.parseInt(vf.getPrefw().getTxtEdadMin().getText().trim());
				int edadMax = Integer.parseInt(vf.getPrefw().getTxtEdadMax().getText().trim());
				double estaturaMin = Double.parseDouble(vf.getPrefw().getTxtEstatura().getText().trim());
				long ingresosMin = Long.parseLong(vf.getPrefw().getTxtIngresos().getText().trim());

				// Validar valores
				if (edadMin < 18 || edadMax > 100 || edadMin > edadMax) {
					JOptionPane.showMessageDialog(vf.getPrefw(),
							"Rango de edad inválido. La edad mínima debe ser 18 o más, y la edad máxima debe ser mayor que la mínima.",
							"Error de validación", JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (estaturaMin < 0.60 || estaturaMin > 2.50) {
					JOptionPane.showMessageDialog(vf.getPrefw(),
							"Estatura inválida. Debe estar entre 0.60 y 2.50 metros.", "Error de validación",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				if (ingresosMin < 0) {
					JOptionPane.showMessageDialog(vf.getPrefw(), "Los ingresos mínimos no pueden ser negativos.",
							"Error de validación", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Filtrar perfiles
				vf.getPrefw().setAceptado(true);
				vf.getPrefw().setVisible(false);
				filtrarPerfilesPorPreferenciasMujeres(edadMin, edadMax, estaturaMin, ingresosMin);
				vf.getMmw().setVisible(true);
				mostrarPerfil();
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(vf.getPrefw(),
					"Por favor, ingresa valores numéricos válidos en todos los campos.", "Error de validación",
					JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(vf.getPrefw(), "Error al aplicar preferencias: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Muestra la ventana de preferencias según el género del usuario
	 */
	private void mostrarVentanaPreferencias() {
		User usuarioActual = mf.getUsuarioActual();

		if (usuarioActual == null) {
			JOptionPane.showMessageDialog(null, "Error: No se pudo obtener la información del usuario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Limpiar campos previos
		vf.getPrefw().limpiarCampos();

		// Configurar la ventana según el género del usuario
		if (usuarioActual instanceof MenDTO) {
			vf.getPrefw().configurarParaHombres();
		} else if (usuarioActual instanceof WomenDTO) {
			vf.getPrefw().configurarParaMujeres();
		}

		// Mostrar la ventana de preferencias
		vf.getPrefw().setVisible(true);
	}

	/**
	 * Aplica y guarda las preferencias seleccionadas en la PreferencesWindow Luego
	 * filtra y compara los perfiles según los criterios
	 */
	private void aplicarYGuardarPreferencias() {
		User usuarioActual = mf.getUsuarioActual();

		if (usuarioActual == null) {
			JOptionPane.showMessageDialog(vf.getPrefw(), "Error: Usuario no identificado.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			if (usuarioActual instanceof MenDTO) {
				// ✅ HOMBRE: Obtener y validar preferencias
				int edadMin = Integer.parseInt(vf.getPrefw().getTxtEdadMin().getText().trim());
				int edadMax = Integer.parseInt(vf.getPrefw().getTxtEdadMax().getText().trim());
				String preferenciaDiv = (String) vf.getPrefw().getCmbDivorcios().getSelectedItem();

				// Validar rango de edad
				if (edadMin < 18 || edadMax > 100 || edadMin > edadMax) {
					JOptionPane.showMessageDialog(vf.getPrefw(),
							"❌ Rango de edad inválido.\n" + "• Edad mínima: 18 o más\n"
									+ "• Edad máxima: debe ser mayor que la mínima\n" + "• Máximo: 100 años",
							"Error de validación", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// ✅ GUARDAR Y COMPARAR: Filtrar perfiles según preferencias de HOMBRE
				filtrarPerfilesPorPreferenciasHombres(edadMin, edadMax, preferenciaDiv);

				// Cerrar ventana de preferencias y mostrar MainWindow
				vf.getPrefw().setAceptado(true);
				vf.getPrefw().setVisible(false);
				vf.getMmw().setVisible(true);
				mostrarPerfil();

			} else if (usuarioActual instanceof WomenDTO) {
				// ✅ MUJER: Obtener y validar preferencias
				int edadMin = Integer.parseInt(vf.getPrefw().getTxtEdadMin().getText().trim());
				int edadMax = Integer.parseInt(vf.getPrefw().getTxtEdadMax().getText().trim());
				double estaturaMin = Double.parseDouble(vf.getPrefw().getTxtEstatura().getText().trim());
				long ingresosMin = Long.parseLong(vf.getPrefw().getTxtIngresos().getText().trim());

				// Validar rango de edad
				if (edadMin < 18 || edadMax > 100 || edadMin > edadMax) {
					JOptionPane.showMessageDialog(vf.getPrefw(),
							"❌ Rango de edad inválido.\n" + "• Edad mínima: 18 o más\n"
									+ "• Edad máxima: debe ser mayor que la mínima\n" + "• Máximo: 100 años",
							"Error de validación", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar estatura
				if (estaturaMin < 0.60 || estaturaMin > 2.50) {
					JOptionPane.showMessageDialog(vf.getPrefw(),
							"❌ Estatura inválida.\n" + "• Debe estar entre 0.60m y 2.50m", "Error de validación",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar ingresos
				if (ingresosMin < 0) {
					JOptionPane.showMessageDialog(vf.getPrefw(), "❌ Los ingresos mínimos no pueden ser negativos.",
							"Error de validación", JOptionPane.ERROR_MESSAGE);
					return;
				}

				// ✅ GUARDAR Y COMPARAR: Filtrar perfiles según preferencias de MUJER
				filtrarPerfilesPorPreferenciasMujeres(edadMin, edadMax, estaturaMin, ingresosMin);

				// Cerrar ventana de preferencias y mostrar MainWindow
				vf.getPrefw().setAceptado(true);
				vf.getPrefw().setVisible(false);
				vf.getMmw().setVisible(true);
				mostrarPerfil();
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(vf.getPrefw(),
					"❌ Error en los valores ingresados.\n"
							+ "Por favor verifica que todos los campos contengan números válidos.",
					"Error de validación", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(vf.getPrefw(), "❌ Error al aplicar preferencias: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void filtrarPerfilesPorPreferenciasHombres(int edadMin, int edadMax, String preferenciaDiv) {
		User usuarioActual = mf.getUsuarioActual();
		mf.cargarPerfiles(usuarioActual);

		String orientacionHombreActual = usuarioActual.getSexualOrientation();

		List<User> perfilesFiltrados = new ArrayList<>();

		for (int i = 0; i < mf.perfilesActuales.size(); i++) {
			User perfil = mf.perfilesActuales.get(i);

			// Solo filtrar mujeres
			if (perfil instanceof WomenDTO) {
				WomenDTO mujer = (WomenDTO) perfil;

				int edad = calcularEdad(mujer.getBornDate());
				String orientacionMujer = mujer.getSexualOrientation();

				// ✅ COMPARAR 1: Rango de edad
				if (edad < edadMin || edad > edadMax) {
					continue;
				}

				// ✅ COMPARAR 2: Preferencia de divorcios
				if (preferenciaDiv.equals("Sí") && !mujer.isHadDivorces()) {
					continue;
				} else if (preferenciaDiv.equals("No") && mujer.isHadDivorces()) {
					continue;
				}

				// ✅ COMPARAR 3: ORIENTACIÓN SEXUAL (COMPATIBILIDAD)
				if (!esCompatibleOrientacionSexual(orientacionHombreActual, orientacionMujer)) {
					continue;
				}

				perfilesFiltrados.add(perfil);
			}
		}

		mf.perfilesActuales.clear();
		mf.perfilesActuales.addAll(perfilesFiltrados);
		mf.indiceActual = 0;

		if (perfilesFiltrados.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getMmw(),
					"⚠️ No se encontraron perfiles que coincidan con tus preferencias.\nMostrando todos los perfiles disponibles.",
					"Sin resultados", JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					"✅ Se encontraron " + perfilesFiltrados.size() + " perfil(es) que coinciden con tus preferencias.\n"
							+ "• Edad: " + edadMin + " - " + edadMax + " años\n" + "• Divorcios: " + preferenciaDiv
							+ "\n" + "• Orientación sexual compatible: " + orientacionHombreActual,
					"Preferencias aplicadas", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void filtrarPerfilesPorPreferenciasMujeres(int edadMin, int edadMax, double estaturaMin, long ingresosMin) {
		User usuarioActual = mf.getUsuarioActual();
		mf.cargarPerfiles(usuarioActual);

		String orientacionMujerActual = usuarioActual.getSexualOrientation();

		List<User> perfilesFiltrados = new ArrayList<>();

		for (int i = 0; i < mf.perfilesActuales.size(); i++) {
			User perfil = mf.perfilesActuales.get(i);

			// Solo filtrar hombres
			if (perfil instanceof MenDTO) {
				MenDTO hombre = (MenDTO) perfil;

				int edad = calcularEdad(hombre.getBornDate());
				String orientacionHombre = hombre.getSexualOrientation();

				// ✅ COMPARAR 1: Rango de edad
				if (edad < edadMin || edad > edadMax) {
					continue;
				}

				// ✅ COMPARAR 2: Estatura mínima
				try {
					double estatura = Double.parseDouble(hombre.getStature());
					if (estatura < estaturaMin) {
						continue;
					}
				} catch (NumberFormatException e) {
					continue;
				}

				// ✅ COMPARAR 3: Ingresos mínimos mensuales
				if (hombre.getMensualIncome() < ingresosMin) {
					continue;
				}

				// ✅ COMPARAR 4: ORIENTACIÓN SEXUAL (COMPATIBILIDAD)
				if (!esCompatibleOrientacionSexual(orientacionMujerActual, orientacionHombre)) {
					continue;
				}

				perfilesFiltrados.add(perfil);
			}
		}

		mf.perfilesActuales.clear();
		mf.perfilesActuales.addAll(perfilesFiltrados);
		mf.indiceActual = 0;

		if (perfilesFiltrados.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getMmw(),
					"⚠️ No se encontraron perfiles que coincidan con tus preferencias.\nMostrando todos los perfiles disponibles.",
					"Sin resultados", JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					"✅ Se encontraron " + perfilesFiltrados.size() + " perfil(es) que coinciden con tus preferencias.\n"
							+ "• Edad: " + edadMin + " - " + edadMax + " años\n" + "• Estatura mínima: " + estaturaMin
							+ "m\n" + "• Ingresos mínimos: $" + ingresosMin + "\n" + "• Orientación sexual compatible: "
							+ orientacionMujerActual,
					"Preferencias aplicadas", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * ✅ MÉTODO AUXILIAR: Verifica si dos orientaciones sexuales son compatibles
	 * Lógica de compatibilidad: - Heterosexual con Heterosexual: SÍ (opuesto
	 * género) - Homosexual con Homosexual: SÍ (mismo género) - Bisexual con
	 * cualquiera: SÍ (bisexual acepta todos) - Otros casos: NO
	 */
	private boolean esCompatibleOrientacionSexual(String orientacion1, String orientacion2) {
		// Normalizar valores (por si hay espacios o diferencias de mayúsculas)
		orientacion1 = orientacion1.trim().toLowerCase();
		orientacion2 = orientacion2.trim().toLowerCase();

		// Si alguno es bisexual, siempre es compatible
		if (orientacion1.contains("bisexual") || orientacion2.contains("bisexual")) {
			return true;
		}

		// Si ambos son heterosexuales (genéricos)
		if (orientacion1.equals("heterosexual") && orientacion2.equals("heterosexual")) {
			return true;
		}

		// Si ambos son homosexuales (genéricos)
		if (orientacion1.equals("homosexual") && orientacion2.equals("homosexual")) {
			return true;
		}

		// Si ambos son gay
		if (orientacion1.equals("gay") && orientacion2.equals("gay")) {
			return true;
		}

		// Si ambos son lésbica
		if (orientacion1.equals("lésbica") && orientacion2.equals("lésbica")) {
			return true;
		}

		// Heterosexual con Gay/Lésbica: NO compatible
		if (orientacion1.equals("heterosexual") && (orientacion2.equals("gay") || orientacion2.equals("lésbica"))) {
			return false;
		}

		if (orientacion2.equals("heterosexual") && (orientacion1.equals("gay") || orientacion1.equals("lésbica"))) {
			return false;
		}

		// Si no coincide ningún caso, considera compatible por defecto
		return true;
	}

	/**
	 * Convierte una cantidad de moneda local a dólares estadounidenses (USD) según
	 * el país seleccionado
	 * 
	 * @param cantidad La cantidad en moneda local
	 * @param pais     El país seleccionado (debe coincidir con los del ComboBox)
	 * @return La cantidad convertida a USD, o -1 si hay error
	 */
	public double convertirMonedaADolares(double cantidad, String pais) {
		if (pais == null || pais.isEmpty()) {
			return -1;
		}

		// Tasas de cambio aproximadas (debes actualizarlas según el mercado actual)
		double tasaCambio = obtenerTasaCambio(pais);

		if (tasaCambio <= 0) {
			return -1;
		}

		return cantidad / tasaCambio;
	}

	/**
	 * Obtiene la tasa de cambio de la moneda local a USD
	 * 
	 * @param pais El país seleccionado
	 * @return La tasa de cambio, o -1 si el país no es válido
	 */
	private double obtenerTasaCambio(String pais) {
		switch (pais) {
		case "Angola":
			return 832.50; // Kwanza angoleño (AOA) a USD
		case "Argentina":
			return 917.50; // Peso argentino (ARS) a USD
		case "Brasil":
			return 5.45; // Real brasileño (BRL) a USD
		case "Colombia":
			return 3915.00; // Peso colombiano (COP) a USD
		case "España":
			return 0.92; // Euro (EUR) a USD
		case "Israel":
			return 3.67; // Nuevo shéquel (ILS) a USD
		case "Kazajistán":
			return 447.50; // Tenge kazajo (KZT) a USD
		case "Macao":
			return 8.06; // Pataca de Macao (MOP) a USD
		case "México":
			return 16.75; // Peso mexicano (MXN) a USD
		case "Portugal":
			return 0.92; // Euro (EUR) a USD
		case "Rusia":
			return 92.50; // Rublo ruso (RUB) a USD
		case "Singapur":
			return 1.35; // Dólar de Singapur (SGD) a USD
		case "Taiwán":
			return 31.40; // Nuevo dólar taiwanés (TWD) a USD
		default:
			return -1;
		}
	}

	public void run() {
		vf.getPw().setVisible(true);
		inicializarPerfiles();
	}
}
