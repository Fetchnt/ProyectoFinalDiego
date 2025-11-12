/**
 * Controlador principal de la aplicación BosTinder que maneja la lógica de negocio
 * y coordina las interacciones entre el modelo y la vista.
 * 
 * <p>Esta clase implementa ActionListener para gestionar todos los eventos de la interfaz
 * de usuario y contiene la lógica de aplicación para el sistema de citas BosTinder.</p>
 * 
 * @author Equipo de desarrollo BosTinder
 * @version 1.0
 * @see ActionListener
 * @see ModelFacade
 * @see ViewFacade
 */
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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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

	 /**
     * Constructor principal del controlador.
     * <b>pre</b> Las clases ModelFacade y ViewFacade están disponibles. <br>
     * <b>post</b> Se ha inicializado el controlador con modelo y vista configurados. <br>
     */
	
	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
		prop = new Properties();
		asignarOyentes();
	}

	/**
     * Asigna los oyentes de eventos a todos los componentes de la interfaz.
     * <b>pre</b> Todas las ventanas de la vista están inicializadas. <br>
     * <b>post</b> Todos los botones tienen sus ActionListener asignados. <br>
     */
	
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
	
	 /**
     * Maneja todos los eventos de acción generados por la interfaz de usuario.
     * <b>pre</b> El controlador está correctamente inicializado. <br>
     * <b>post</b> Se ha ejecutado la acción correspondiente al comando recibido. <br>
     * @param e El evento de acción generado. e != null
     */
	

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
			vf.getPw().cambiarAModoOscuroPW();
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
			vf.getPrefw().revalidate();
			vf.getPrefw().repaint();
			vf.getAw().revalidate();
			vf.getAw().repaint();
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
							prop.getProperty("controller.verifyemail.already_registered.message"),
							prop.getProperty("controller.verifyemail.already_registered.title"),
							JOptionPane.ERROR_MESSAGE);
					vf.getRw().setCorreoVerificado(false);
					break;
				}

				ExceptionLauncher.verifyEmail(correo);

				String codigo = generarCodigo();
				boolean enviado = enviarCorreo(correo, codigo);

				if (!enviado) {
					int opc = JOptionPane.showConfirmDialog(null,
							prop.getProperty("controller.verifyemail.smtp_fail.message"),
							prop.getProperty("controller.verifyemail.smtp_fail.title"), JOptionPane.YES_NO_OPTION);

					if (opc != JOptionPane.YES_OPTION) {
						vf.getRw().setCorreoVerificado(false);
						break;
					}

					JOptionPane.showMessageDialog(null,
							prop.getProperty("controller.verifyemail.simulated_code.message") + codigo
									+ prop.getProperty("controller.verifyemail.simulated_code.suffix"),
							prop.getProperty("controller.verifyemail.simulated_code.title"),
							JOptionPane.INFORMATION_MESSAGE);
				}

				boolean verificado = false;

				String codigoIngresado = JOptionPane.showInputDialog(null,
						prop.getProperty("controller.verifyemail.enter_code.message"),
						prop.getProperty("controller.verifyemail.enter_code.title"), JOptionPane.QUESTION_MESSAGE);

				if (codigoIngresado == null) {
					JOptionPane.showMessageDialog(null, prop.getProperty("controller.verifyemail.cancelled.message"),
							prop.getProperty("controller.verifyemail.cancelled.title"), JOptionPane.WARNING_MESSAGE);
					vf.getRw().setCorreoVerificado(false);
					break;
				}

				if (codigoIngresado.trim().equals(codigo)) {
					JOptionPane.showMessageDialog(null, prop.getProperty("controller.verifyemail.success.message"),
							prop.getProperty("controller.verifyemail.success.title"), JOptionPane.INFORMATION_MESSAGE);
					vf.getRw().setCorreoVerificado(true);
					vf.getRw().setCorreoVerificadoActual(correo);
					verificado = true;
					break;
				} else {
					JOptionPane.showMessageDialog(null, prop.getProperty("controller.verifyemail.incorrect.message"),
							prop.getProperty("controller.verifyemail.incorrect.title"), JOptionPane.ERROR_MESSAGE);
				}

			} catch (EmailException ex) {
				JOptionPane.showMessageDialog(null,
						prop.getProperty("controller.verifyemail.invalid_format.message") + ex.getMessage(),
						prop.getProperty("controller.verifyemail.invalid_format.title"), JOptionPane.ERROR_MESSAGE);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						prop.getProperty("controller.verifyemail.general_error.message") + ex.getMessage(),
						prop.getProperty("controller.verifyemail.general_error.title"), JOptionPane.ERROR_MESSAGE);
			}
			break;
		}

		// ---------- ACCIONES DEL REGISTRO ----------

		case "boton_subir_foto": {
			try {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagen PNG", "png");
				chooser.setFileFilter(filter);
				chooser.setCurrentDirectory(new File(System.getProperty("user.dir"))); // Directorio actual del proyecto
				int result = chooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					String fileName = selectedFile.getName();

					File destinationFolder = new File("sources");
					if (!destinationFolder.exists()) {
						destinationFolder.mkdirs();
					}
					File destinationFile = new File(destinationFolder, fileName);

					try {
						Files.copy(selectedFile.toPath(), destinationFile.toPath(),
								StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(),
								prop.getProperty("controller.uploadphoto.error.path.title"), JOptionPane.ERROR_MESSAGE);
						return;
					}

					vf.getRw().setRutaImagenSeleccionada("sources/" + fileName);

					ImageIcon image = new ImageIcon(destinationFile.getAbsolutePath());
					ImageIcon scaled = new ImageIcon(image.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
					vf.getRw().getlFotoPreview().setIcon(scaled);

					JOptionPane.showMessageDialog(null,
							prop.getProperty("controller.uploadphoto.success.message") + fileName,
							prop.getProperty("controller.uploadphoto.success.title"), JOptionPane.INFORMATION_MESSAGE);
				} else {
					throw new ImageNotSelectedException();
				}

			} catch (ImageNotSelectedException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(),
						prop.getProperty("controller.uploadphoto.error.general.title"), JOptionPane.ERROR_MESSAGE);
			}
			break;
		}

		case "seleccionar_genero":
			mostrarCamposPorGenero();
			break;

		case "boton_registrar": {
			try {
				String correo = vf.getRw().getTxtCorreo().getText();

				// Verificar si el correo ya fue validado antes
				if (!vf.getRw().isCorreoVerificado() || !correo.equals(vf.getRw().getCorreoVerificadoActual())) {
					JOptionPane.showMessageDialog(null, prop.getProperty("controller.register.warning.verify_email"),
							prop.getProperty("controller.register.warning.verify_title"), JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (correoYaRegistrado(correo)) {
					JOptionPane.showMessageDialog(null, prop.getProperty("controller.register.error.email_registered"),
							prop.getProperty("controller.register.error.email_registered.title"),
							JOptionPane.ERROR_MESSAGE);
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

				if (genero.equals(prop.getProperty("controller.register.gender.male"))) {
					String estatura = vf.getRw().getTxtEstatura().getText();
					String orientacion = (String) vf.getRw().getCmbOrientacion().getSelectedItem();
					String ingresosStr = vf.getRw().getTxtIngresos().getText();

					ExceptionLauncher.verifyStature(estatura);
					ExceptionLauncher.verifyComboBox(orientacion);
					ExceptionLauncher.verifyIncome(ingresosStr, pais);

					long ingresos = Long.parseLong(ingresosStr);
					if (ingresos < 0) {
						throw new NumberFormatException(prop.getProperty("controller.register.error.negative_income"));
					}

					double ingresosUSD = convertirMonedaADolares(ingresos, pais);
					if (ingresosUSD == -1) {
						throw new Exception(prop.getProperty("controller.register.error.currency_conversion") + pais);
					}

					String rutaFoto = vf.getRw().getRutaImagenSeleccionada();

					MenDTO hombre = new MenDTO(nombres, apellidos, apodo, fechaNacimiento, estatura, correo, genero,
							orientacion, rutaFoto, pais, password, (long) ingresosUSD, prop);
					mf.getmDAO().create(hombre);

				} else if (genero.equals(prop.getProperty("controller.register.gender.female"))) {
					String estatura = vf.getRw().getTxtEstatura().getText();
					String orientacion = (String) vf.getRw().getCmbOrientacion().getSelectedItem();
					String divorciosStr = (String) vf.getRw().getCmbDivorcios().getSelectedItem();

					if (!estatura.isEmpty()) {
						ExceptionLauncher.verifyStature(estatura);
					}
					ExceptionLauncher.verifyComboBox(orientacion);
					ExceptionLauncher.verifyComboBox(divorciosStr);

					boolean tuvoDivorcios = divorciosStr.equals(prop.getProperty("controller.register.divorces.yes"));
					String rutaFoto = vf.getRw().getRutaImagenSeleccionada();

					WomenDTO mujer = new WomenDTO(nombres, apellidos, apodo, fechaNacimiento, estatura, correo, genero,
							orientacion, rutaFoto, pais, password, tuvoDivorcios, prop);
					mf.getwDAO().create(mujer);

				} else {
					JOptionPane.showMessageDialog(null, prop.getProperty("controller.register.error.invalid_gender"),
							prop.getProperty("controller.register.error.title"), JOptionPane.ERROR_MESSAGE);
					return;
				}

				JOptionPane.showMessageDialog(null, prop.getProperty("controller.register.success.message"),
						prop.getProperty("controller.register.success.title"), JOptionPane.INFORMATION_MESSAGE);

				vf.getRw().setVisible(false);
				vf.getSw().setVisible(true);
				limpiarCamposRegistro();

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
						prop.getProperty("controller.register.error.general") + ex.getMessage(),
						prop.getProperty("controller.register.error.title"), JOptionPane.ERROR_MESSAGE);
			}
			break;
		}

		case "boton_volver_registro": {
			limpiarCamposRegistro();
			vf.getRw().setVisible(false);
			vf.getSw().setVisible(true);
			break;
		}

		case "boton_entrar_modo_admin": {
			String ADMIN_PASSWORD = "CarlosLlegueYa";
			String passwordIngresada = JOptionPane.showInputDialog(vf.getLw(),
					prop.getProperty("controller.admin.prompt.password"),
					prop.getProperty("controller.admin.title.restricted"), JOptionPane.WARNING_MESSAGE);

			if (passwordIngresada == null) {
				JOptionPane.showMessageDialog(vf.getLw(), prop.getProperty("controller.admin.cancelled"),
						prop.getProperty("controller.admin.title.cancelled"), JOptionPane.INFORMATION_MESSAGE);
				break;
			}

			if (ADMIN_PASSWORD.equals(passwordIngresada.trim())) {
				JOptionPane.showMessageDialog(vf.getLw(), prop.getProperty("controller.admin.access_granted"),
						prop.getProperty("controller.admin.title.access_granted"), JOptionPane.INFORMATION_MESSAGE);

				vf.getLw().setVisible(false);
				vf.getAw().setVisible(true);
				mostrarTodosLosUsuarios();

			} else {
				JOptionPane.showMessageDialog(vf.getLw(), prop.getProperty("controller.admin.access_denied"),
						prop.getProperty("controller.admin.title.auth_error"), JOptionPane.ERROR_MESSAGE);
			}
			break;
		}

		case "boton_iniciosesion": {
			String userAlias = vf.getLw().getUser().getText();
			String email = vf.getLw().getEmail().getText();
			String password = vf.getLw().getPassword().getText();

			boolean valido = mf.validarInicioSesion(userAlias, email, password);

			if (valido) {
				JOptionPane.showMessageDialog(null, prop.getProperty("controller.login.success.message"),
						prop.getProperty("controller.login.success.title"), JOptionPane.INFORMATION_MESSAGE);

				vf.getLw().setVisible(false);
				mostrarVentanaPreferencias();

			} else {
				JOptionPane.showMessageDialog(null, prop.getProperty("controller.login.error.message"),
						prop.getProperty("controller.login.error.title"), JOptionPane.ERROR_MESSAGE);
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
			List<User> top10Usuarios = mf.obtenerUsuariosMasPopulares(10);

			if (top10Usuarios.isEmpty()) {
				JOptionPane.showMessageDialog(vf.getAw(), prop.getProperty("controller.filter.top10.empty.message"),
						prop.getProperty("controller.filter.top10.empty.title"), JOptionPane.INFORMATION_MESSAGE);
				break;
			}

			DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
			modelo.setRowCount(0);

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

			JOptionPane.showMessageDialog(vf.getAw(), prop.getProperty("controller.filter.top10.success.message"),
					prop.getProperty("controller.filter.top10.success.title"), JOptionPane.INFORMATION_MESSAGE);
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
			int confirmacion = JOptionPane.showConfirmDialog(vf.getMpw(),
					prop.getProperty("controller.logout.confirm.message"),
					prop.getProperty("controller.logout.confirm.title"), JOptionPane.YES_NO_OPTION);

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

	 /**
     * Maneja el evento de click en un país del mapa.
     * <b>pre</b> El mapa está cargado y visible. <br>
     * <b>post</b> Se muestran los usuarios del país seleccionado. <br>
     * @param pais El nombre del país seleccionado. pais != null, pais != ""
     */
	
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
	 /**
     * Maneja el evento de hover sobre un país del mapa.
     * <b>pre</b> El mapa está cargado y visible. <br>
     * <b>post</b> Se actualiza la información del país en hover. <br>
     * @param pais El nombre del país sobre el que se hace hover. pais != null
     */

	// Maneja mouse sobre pais
	public void mostrarPaisHover(String pais) {
		if (pais != null) {
			// Actualiza un label temporal con el país
			vf.getMw().setPaisSeleccionado(pais);
		}
	}
	
	 /**
     * Muestra u oculta campos específicos según el género seleccionado en el registro.
     * <b>pre</b> El ComboBox de género está inicializado. <br>
     * <b>post</b> Los campos específicos de género son visibles u ocultos según la selección. <br>
     */

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

	/**
     * Limpia todos los campos del formulario de registro.
     * <b>pre</b> El formulario de registro está visible. <br>
     * <b>post</b> Todos los campos de texto y selecciones están en su estado inicial. <br>
     */
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

	  /**
     * Genera un código de verificación aleatorio de 6 dígitos.
     * <b>pre</b> El sistema de números aleatorios está disponible. <br>
     * <b>post</b> Se ha generado un código único de 6 dígitos. <br>
     * @return Código de verificación de 6 dígitos. != null, longitud = 6
     */
	public String generarCodigo() {
		Random rand = new Random();
		int codigo = 100000 + rand.nextInt(900000);
		return String.valueOf(codigo);
	}

	 /**
     * Envía un correo electrónico con el código de verificación.
     * <b>pre</b> El destinatario y código son válidos. <br>
     * <b>post</b> Se ha intentado enviar el correo con el código. <br>
     * @param destinatario Dirección de correo del destinatario. destinatario != null, destinatario != ""
     * @param codigo Código de verificación a enviar. codigo != null, codigo != ""
     * @return true si el correo fue enviado exitosamente, false en caso contrario
     * @throws MessagingException Si hay errores en el envío del correo
     */
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
			JOptionPane.showMessageDialog(null, prop.getProperty("controller.email.unsupported_domain.message"),
					prop.getProperty("controller.email.unsupported_domain.title"), JOptionPane.ERROR_MESSAGE);
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
			message.setSubject(prop.getProperty("controller.email.subject"));
			message.setText(prop.getProperty("controller.email.body") + " " + codigo);

			Transport.send(message);
			return true;
		} catch (AuthenticationFailedException e) {
			JOptionPane.showMessageDialog(null, prop.getProperty("controller.email.auth_error.message"),
					prop.getProperty("controller.email.auth_error.title"), JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (SendFailedException e) {
			JOptionPane.showMessageDialog(null,
					prop.getProperty("controller.email.send_error.message") + "\n" + e.getMessage(),
					prop.getProperty("controller.email.send_error.title"), JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null,
					prop.getProperty("controller.email.smtp_error.message") + "\n" + e.getMessage(),
					prop.getProperty("controller.email.smtp_error.title"), JOptionPane.ERROR_MESSAGE);
			return false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					prop.getProperty("controller.email.unexpected_error.message") + " " + e.getMessage(),
					prop.getProperty("controller.email.unexpected_error.title"), JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/**
     * Aplica la internacionalización a toda la aplicación según el idioma seleccionado.
     * <b>pre</b> Los archivos de propiedades de idioma están disponibles. <br>
     * <b>post</b> Todas las ventanas muestran textos en el idioma seleccionado. <br>
     * @param idioma Código del idioma a aplicar. idioma != null, idioma != ""
     * @throws IOException Si no se puede cargar el archivo de propiedades del idioma
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
			JOptionPane.showMessageDialog(null,
					prop.getProperty("controller.internationalization.error.message") + " " + ex.getMessage(),
					prop.getProperty("controller.internationalization.error.title"), JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	 /**
     * Muestra el perfil actual en la ventana principal.
     * <b>pre</b> Hay perfiles disponibles para mostrar. <br>
     * <b>post</b> La información del perfil actual se muestra en la interfaz. <br>
     */
	public void mostrarPerfilMain() {
		User actual = mf.getPerfilActual();
		if (actual == null) {
			JOptionPane.showMessageDialog(null, prop.getProperty("controller.mainprofile.noprofiles.message"),
					prop.getProperty("controller.mainprofile.noprofiles.title"), JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		int edad = calcularEdad(actual.getBornDate());

		vf.getMmw().getLblNameAge().setText(actual.getName() + " " + actual.getLastName());

		vf.getMmw().getTxtDescription()
				.setText(prop.getProperty("controller.mainprofile.alias") + ": " + actual.getAlias() + "\n"
						+ prop.getProperty("controller.mainprofile.gender") + ": " + actual.getGender() + "\n"
						+ prop.getProperty("controller.mainprofile.orientation") + ": " + actual.getSexualOrientation()
						+ "\n" + prop.getProperty("controller.mainprofile.country") + ": " + actual.getCountry() + "\n"
						+ prop.getProperty("controller.mainprofile.age") + ": " + edad + " "
						+ prop.getProperty("controller.mainprofile.age.years"));
	}

	 /**
     * Muestra la lista de usuarios que han dado like al perfil actual.
     * <b>pre</b> El usuario actual tiene una lista de likes. <br>
     * <b>post</b> Se muestra la lista de likes en un diálogo. <br>
     */
	public void mostrarLikes() {
		List<User> likes = mf.getLikes();
		if (likes.isEmpty()) {
			JOptionPane.showMessageDialog(null, prop.getProperty("controller.likes.empty.message"),
					prop.getProperty("controller.likes.empty.title"), JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		StringBuilder sb = new StringBuilder(prop.getProperty("controller.likes.header") + "\n\n");
		for (User u : likes) {
			sb.append("- ").append(u.getName()).append(" ").append(u.getLastName()).append("\n");
		}

		JOptionPane.showMessageDialog(null, sb.toString(), prop.getProperty("controller.likes.title"),
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
     * Calcula la edad a partir de una fecha de nacimiento.
     * <b>pre</b> La fecha tiene formato dd/MM/yyyy. <br>
     * <b>post</b> Se calcula la edad exacta en años. <br>
     * @param fechaNacimiento Fecha de nacimiento en formato dd/MM/yyyy. fechaNacimiento != null, fechaNacimiento != ""
     * @return Edad calculada en años. >= 0
     * @throws DateTimeException Si el formato de fecha es inválido
     */
	public int calcularEdad(String fechaNacimiento) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);
			LocalDate hoy = LocalDate.now();
			return Period.between(fechaNac, hoy).getYears();
		} catch (Exception e) {
			System.out.println(prop.getProperty("controller.agecalc.error") + fechaNacimiento);
			return 0;
		}
	}

	 /**
     * Inicializa la lista de perfiles disponibles en la aplicación.
     * <b>pre</b> Los archivos CSV de usuarios están disponibles. <br>
     * <b>post</b> Todos los perfiles están cargados y listos para mostrar. <br>
     * @throws IOException Si no se pueden leer los archivos CSV
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
     * Muestra todos los usuarios en la tabla de administración.
     * <b>pre</b> El modo administrador está activo. <br>
     * <b>post</b> La tabla muestra todos los usuarios registrados. <br>
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

	  /**
     * Muestra los detalles del usuario seleccionado en la tabla de administración.
     * <b>pre</b> Hay una fila seleccionada en la tabla. <br>
     * <b>post</b> Los campos de detalle muestran la información del usuario. <br>
     */
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
     * Da de baja (elimina) al usuario seleccionado de la base de datos.
     * <b>pre</b> Hay un usuario seleccionado en la tabla. <br>
     * <b>post</b> El usuario es eliminado del sistema si se confirma. <br>
     * @throws Exception Si no se puede eliminar el usuario
     */
	public void darDeBajaUsuario() {
		int filaSeleccionada = vf.getAw().getTablaUsuarios().getSelectedRow();

		// Verificar si hay una fila seleccionada
		if (filaSeleccionada == -1) {
			JOptionPane.showMessageDialog(vf.getAw(), prop.getProperty("controller.darbaja.noselection.message"),
					prop.getProperty("controller.darbaja.noselection.title"), JOptionPane.WARNING_MESSAGE);
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
			JOptionPane.showMessageDialog(vf.getAw(), prop.getProperty("controller.darbaja.usernotfound.message"),
					prop.getProperty("controller.darbaja.usernotfound.title"), JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Crear mensaje de confirmación con detalles del usuario
		String mensajeConfirmacion = String.format(prop.getProperty("controller.darbaja.confirm.message"), alias,
				nombre, apellido, usuario.getEmail(), usuario.getCountry());

		// Mostrar diálogo de confirmación
		int confirmacion = JOptionPane.showConfirmDialog(vf.getAw(), mensajeConfirmacion,
				prop.getProperty("controller.darbaja.confirm.title"), JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);

		if (confirmacion == JOptionPane.YES_OPTION) {
			boolean eliminado = mf.eliminarUsuarioPorAlias(alias);

			if (eliminado) {
				modelo.removeRow(filaSeleccionada);
				limpiarCamposDetalleAdmin();

				JOptionPane.showMessageDialog(vf.getAw(),
						String.format(prop.getProperty("controller.darbaja.success.message"), alias),
						prop.getProperty("controller.darbaja.success.title"), JOptionPane.INFORMATION_MESSAGE);

				actualizarEstadisticasAdmin();
			} else {
				JOptionPane.showMessageDialog(vf.getAw(), prop.getProperty("controller.darbaja.error.message"),
						prop.getProperty("controller.darbaja.error.title"), JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
     * Limpia los campos de detalle del usuario en la ventana de administración.
     * <b>pre</b> Los campos de detalle están inicializados. <br>
     * <b>post</b> Todos los campos de detalle están vacíos. <br>
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
     * Activa o desactiva el modo incógnito del usuario actual.
     * <b>pre</b> El usuario ha iniciado sesión. <br>
     * <b>post</b> El modo incógnito cambia de estado. <br>
     */
	public void toggleModoIncognito() {
		if (!vf.getMmw().isVisible())
			return;

		boolean modoActual = mf.isModoIncognito();
		mf.setModoIncognito(!modoActual);

		String mensaje = modoActual ? prop.getProperty("controller.incognito.deactivated.message")
				: prop.getProperty("controller.incognito.activated.message");

		JOptionPane.showMessageDialog(null, mensaje, prop.getProperty("controller.incognito.title"),
				JOptionPane.INFORMATION_MESSAGE);

		mostrarPerfilMain();
	}

	/**
     * Filtra usuarios por ingresos mínimos en la ventana de administración.
     * <b>pre</b> Hay usuarios cargados en el sistema. <br>
     * <b>post</b> La tabla muestra solo usuarios que cumplen el criterio de ingresos. <br>
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
					String.format(prop.getProperty("controller.filter.income.noresults.message"), umbralIngresos),
					prop.getProperty("controller.filter.income.noresults.title"), JOptionPane.INFORMATION_MESSAGE);
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

		limpiarCamposDetalleAdmin();

		// Mostrar mensaje de éxito
		JOptionPane.showMessageDialog(vf.getAw(),
				String.format(prop.getProperty("controller.filter.income.success.message"), usuariosFiltrados.size(),
						umbralIngresos),
				prop.getProperty("controller.filter.income.success.title"), JOptionPane.INFORMATION_MESSAGE);

		actualizarEstadisticasFiltro(usuariosFiltrados,
				String.format(prop.getProperty("controller.filter.income.criteria"), umbralIngresos));
	}

	/**
     * Filtra usuarios por género en la ventana de administración.
     * <b>pre</b> Hay usuarios cargados en el sistema. <br>
     * <b>post</b> La tabla muestra solo usuarios del género seleccionado. <br>
     */
	public void filtrarPorGenero() {
		// Recargar datos
		mf.getmDAO().listaMenDTO.clear();
		mf.getmDAO().readFromTextFile("Men.csv");

		mf.getwDAO().listaWomenDTO.clear();
		mf.getwDAO().readFromTextFile("Women.csv");

		// Obtener género seleccionado del ComboBox
		String generoSeleccionado = (String) vf.getAw().getCmbGeneroFiltro().getSelectedItem();

		if (generoSeleccionado == null
				|| generoSeleccionado.equals(prop.getProperty("controller.filter.gender.option.all"))) {
			// Si es "Todos", mostrar todos los usuarios
			mostrarTodosLosUsuarios();
			return;
		}

		// Obtener usuarios filtrados
		List<User> usuariosFiltrados = mf.obtenerUsuariosPorGenero(generoSeleccionado);

		if (usuariosFiltrados.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getAw(),
					String.format(prop.getProperty("controller.filter.gender.noresults.message"), generoSeleccionado),
					prop.getProperty("controller.filter.gender.noresults.title"), JOptionPane.INFORMATION_MESSAGE);
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
				String.format(prop.getProperty("controller.filter.gender.success.message"), usuariosFiltrados.size(),
						generoSeleccionado),
				prop.getProperty("controller.filter.gender.success.title"), JOptionPane.INFORMATION_MESSAGE);

		// Actualizar estadísticas
		actualizarEstadisticasFiltro(usuariosFiltrados,
				String.format(prop.getProperty("controller.filter.gender.criteria"), generoSeleccionado));
	}

	 /**
     * Busca usuarios por alias o correo en la ventana de administración.
     * <b>pre</b> El campo de búsqueda contiene texto. <br>
     * <b>post</b> La tabla muestra los usuarios que coinciden con la búsqueda. <br>
     */
	public void buscarUsuarioAdmin() {
		String textoBusqueda = vf.getAw().getTxtBuscar().getText().trim();

		if (textoBusqueda.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getAw(), prop.getProperty("controller.admin.search.empty.message"),
					prop.getProperty("controller.admin.search.empty.title"), JOptionPane.WARNING_MESSAGE);
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
					String.format(prop.getProperty("controller.admin.search.noresults.message"), textoBusqueda),
					prop.getProperty("controller.admin.search.noresults.title"), JOptionPane.INFORMATION_MESSAGE);
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
				String.format(prop.getProperty("controller.admin.search.success.message"), usuariosEncontrados.size()),
				prop.getProperty("controller.admin.search.success.title"), JOptionPane.INFORMATION_MESSAGE);

		// Actualizar estadísticas
		actualizarEstadisticasFiltro(usuariosEncontrados,
				String.format(prop.getProperty("controller.admin.search.criteria"), textoBusqueda));
	}

	/**
     * Actualiza las estadísticas mostradas según el filtro aplicado.
     * <b>pre</b> Hay una lista de usuarios filtrados. <br>
     * <b>post</b> Las estadísticas reflejan los datos del filtro actual. <br>
     * @param usuariosFiltrados Lista de usuarios después del filtrado. usuariosFiltrados != null
     * @param criterioFiltro Descripción del criterio de filtrado. criterioFiltro != null
     */
	public void actualizarEstadisticasFiltro(List<User> usuariosFiltrados, String criterioFiltro) {
		if (usuariosFiltrados.isEmpty()) {
			vf.getAw().getTxtEstadisticas().setText(prop.getProperty("controller.stats.filter.empty"));
			return;
		}

		int totalHombres = mf.contarPorGenero(usuariosFiltrados, "Masculino");
		int totalMujeres = mf.contarPorGenero(usuariosFiltrados, "Femenino");
		double edadPromedio = mf.calcularEdadPromedio(usuariosFiltrados);
		double ingresoPromedio = mf.calcularIngresoPromedio(usuariosFiltrados);

		StringBuilder estadisticas = new StringBuilder();
		estadisticas.append(prop.getProperty("controller.stats.filter.title")).append("\n");
		estadisticas.append(prop.getProperty("controller.stats.separator")).append("\n");
		estadisticas.append(String.format(prop.getProperty("controller.stats.filter.criteria"), criterioFiltro))
				.append("\n\n");
		estadisticas.append(String.format(prop.getProperty("controller.stats.total.users"), usuariosFiltrados.size()))
				.append("\n");
		estadisticas.append(String.format(prop.getProperty("controller.stats.total.men"), totalHombres)).append("\n");
		estadisticas.append(String.format(prop.getProperty("controller.stats.total.women"), totalMujeres)).append("\n");
		estadisticas.append(String.format(prop.getProperty("controller.stats.avg.age"), edadPromedio)).append("\n");

		if (totalHombres > 0) {
			estadisticas.append(String.format(prop.getProperty("controller.stats.avg.income"), ingresoPromedio))
					.append("\n");
		}

		vf.getAw().getTxtEstadisticas().setText(estadisticas.toString());
	}

	 /**
     * Actualiza las estadísticas globales en la ventana de administración.
     * <b>pre</b> Hay usuarios cargados en el sistema. <br>
     * <b>post</b> Las estadísticas muestran datos actualizados de todos los usuarios. <br>
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
		estadisticas.append(prop.getProperty("controller.stats.global.title")).append("\n");
		estadisticas.append(prop.getProperty("controller.stats.separator")).append("\n");
		estadisticas.append(String.format(prop.getProperty("controller.stats.total.users"), totalUsuarios))
				.append("\n");
		estadisticas.append(
				String.format(prop.getProperty("controller.stats.men.percent"), totalHombres, porcentajeHombres))
				.append("\n");
		estadisticas.append(
				String.format(prop.getProperty("controller.stats.women.percent"), totalMujeres, porcentajeMujeres))
				.append("\n");
		estadisticas.append(String.format(prop.getProperty("controller.stats.avg.age"), edadPromedio)).append("\n");
		estadisticas.append(String.format(prop.getProperty("controller.stats.avg.income.men"), ingresoPromedio))
				.append("\n");
		estadisticas.append(String.format(prop.getProperty("controller.stats.women.divorces.percent"),
				mujeresConDivorcios, porcentajeDivorcios)).append("\n");

		if (!paisMasUsuarios.isEmpty()) {
			estadisticas.append(String.format(prop.getProperty("controller.stats.top.country"), paisMasUsuarios))
					.append("\n");
		}

		vf.getAw().getTxtEstadisticas().setText(estadisticas.toString());
	}

	 /**
     * Muestra el perfil actual en la ventana principal con toda su información.
     * <b>pre</b> Hay un perfil actual cargado. <br>
     * <b>post</b> La interfaz muestra la información completa del perfil. <br>
     */
	public void mostrarPerfil() {
		User actual = mf.getPerfilActual();

		if (actual == null) {
			JOptionPane.showMessageDialog(vf.getMmw(), prop.getProperty("controller.profile.none.message"),
					prop.getProperty("controller.profile.none.title"), JOptionPane.INFORMATION_MESSAGE);

			// Limpiar la ventana
			vf.getMmw().getLblNameAge().setText(prop.getProperty("controller.profile.none.label"));
			vf.getMmw().getTxtDescription().setText(prop.getProperty("controller.profile.none.description"));
			vf.getMmw().getLblProfilePicture().setIcon(null);
			return;
		}

		// --- Calcular edad a partir de la fecha de nacimiento ---
		int edad = calcularEdad(actual.getBornDate());

		// --- Mostrar nombre y apellido ---
		vf.getMmw().getLblNameAge().setText(actual.getName() + " " + actual.getLastName() + ", " + edad);

		// --- Construir descripción según el tipo de usuario ---
		StringBuilder descripcion = new StringBuilder();
		descripcion.append(prop.getProperty("controller.profile.alias")).append(": ").append(actual.getAlias())
				.append("\n\n");
		descripcion.append(prop.getProperty("controller.profile.gender")).append(": ").append(actual.getGender())
				.append("\n");
		descripcion.append(prop.getProperty("controller.profile.orientation")).append(": ")
				.append(actual.getSexualOrientation()).append("\n");
		descripcion.append(prop.getProperty("controller.profile.stature")).append(": ").append(actual.getStature())
				.append(" m\n");
		descripcion.append(prop.getProperty("controller.profile.country")).append(": ").append(actual.getCountry())
				.append("\n");
		descripcion.append(prop.getProperty("controller.profile.age")).append(": ").append(edad).append(" ")
				.append(prop.getProperty("controller.profile.age.years")).append("\n");

		if (actual instanceof MenDTO) {
			MenDTO hombre = (MenDTO) actual;
			descripcion.append(prop.getProperty("controller.profile.income")).append(": $")
					.append(String.format("%.2f", (double) hombre.getMensualIncome())).append(" USD\n");
		} else if (actual instanceof WomenDTO) {
			WomenDTO mujer = (WomenDTO) actual;
			descripcion.append(prop.getProperty("controller.profile.divorces")).append(": ")
					.append(mujer.isHadDivorces() ? prop.getProperty("controller.profile.divorces.yes")
							: prop.getProperty("controller.profile.divorces.no"))
					.append("\n");
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
					vf.getMmw().getLblProfilePicture().setText("");
				} else {
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
     * Muestra una imagen por defecto cuando no hay foto de perfil disponible.
     * <b>pre</b> El label de imagen está inicializado. <br>
     * <b>post</b> El label muestra un mensaje de imagen no disponible. <br>
     */
	public void mostrarImagenPorDefecto() {
		vf.getMmw().getLblProfilePicture().setIcon(null);
		vf.getMmw().getLblProfilePicture().setText(prop.getProperty("controller.profile.no.photo"));
		vf.getMmw().getLblProfilePicture().setHorizontalAlignment(SwingConstants.CENTER);
	}

	public void manejarOrdenAscendente() {
		String genero = (String) vf.getAw().getCmbGeneroFiltro().getSelectedItem();
		if (genero == null || genero.equalsIgnoreCase(prop.getProperty("controller.sort.all.label"))) {
			JOptionPane.showMessageDialog(vf.getAw(), prop.getProperty("controller.sort.select_gender.message"),
					prop.getProperty("controller.sort.warning.title"), JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (genero.equalsIgnoreCase(prop.getProperty("controller.sort.male.label"))) {
			mf.getmDAO().selectionSortAsc();

			DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
			modelo.setRowCount(0);
			for (MenDTO m : mf.getmDAO().listaMenDTO) {
				int edad = calcularEdad(m.getBornDate());
				String ingresos = String.format("%.2f", (double) m.getMensualIncome());
				modelo.addRow(new Object[] { m.getAlias(), m.getName(), m.getLastName(), edad, m.getLikes(), ingresos,
						m.getGender() });
			}
		} else if (genero.equalsIgnoreCase(prop.getProperty("controller.sort.female.label"))) {
			mf.getwDAO().selectionSortAsc();

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
     * Ordena los usuarios de forma ascendente según criterios específicos.
     * <b>pre</b> Hay un género seleccionado para ordenar. <br>
     * <b>post</b> La tabla muestra usuarios ordenados ascendentemente. <br>
     */
	public void manejarOrdenDescendente() {
		String genero = (String) vf.getAw().getCmbGeneroFiltro().getSelectedItem();
		if (genero == null || genero.equalsIgnoreCase(prop.getProperty("controller.sort.all.label"))) {
			JOptionPane.showMessageDialog(vf.getAw(), prop.getProperty("controller.sort.select_gender.message"),
					prop.getProperty("controller.sort.warning.title"), JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (genero.equalsIgnoreCase(prop.getProperty("controller.sort.male.label"))) {
			mf.getmDAO().insertionSortDes();

			DefaultTableModel modelo = (DefaultTableModel) vf.getAw().getTablaUsuarios().getModel();
			modelo.setRowCount(0);
			for (MenDTO m : mf.getmDAO().listaMenDTO) {
				int edad = calcularEdad(m.getBornDate());
				String ingresos = String.format("%.2f", (double) m.getMensualIncome());
				modelo.addRow(new Object[] { m.getAlias(), m.getName(), m.getLastName(), edad, m.getLikes(), ingresos,
						m.getGender() });
			}
		} else if (genero.equalsIgnoreCase(prop.getProperty("controller.sort.female.label"))) {
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
     * Muestra el perfil del usuario actual en la ventana de mi perfil.
     * <b>pre</b> El usuario ha iniciado sesión. <br>
     * <b>post</b> La ventana de mi perfil muestra la información personal. <br>
     */

	public void mostrarMiPerfil() {
		User usuarioActual = mf.getUsuarioActual();

		if (usuarioActual == null) {
			JOptionPane.showMessageDialog(vf.getMmw(), prop.getProperty("controller.myprofile.load.error.message"),
					prop.getProperty("controller.myprofile.load.error.title"), JOptionPane.ERROR_MESSAGE);
			return;
		}

		int edad = calcularEdad(usuarioActual.getBornDate());

		vf.getMpw().getTxtNombre().setText(usuarioActual.getName());
		vf.getMpw().getTxtApellido().setText(usuarioActual.getLastName());
		vf.getMpw().getTxtAlias().setText(usuarioActual.getAlias());
		vf.getMpw().getTxtEdad().setText(String.valueOf(edad));
		vf.getMpw().getTxtCorreo().setText(usuarioActual.getEmail());
		vf.getMpw().getTxtLikes().setText(String.valueOf(usuarioActual.getLikes()));

		if (usuarioActual instanceof MenDTO) {
			MenDTO hombre = (MenDTO) usuarioActual;
			vf.getMpw().getTxtIngresos()
					.setText(prop.getProperty("controller.myprofile.income.prefix") + " "
							+ String.format("%.2f", (double) hombre.getMensualIncome()) + " "
							+ prop.getProperty("controller.myprofile.income.suffix"));
		} else if (usuarioActual instanceof WomenDTO) {
			WomenDTO mujer = (WomenDTO) usuarioActual;
			vf.getMpw().getTxtIngresos()
					.setText(mujer.isHadDivorces() ? prop.getProperty("controller.myprofile.divorced.yes")
							: prop.getProperty("controller.myprofile.divorced.no"));
		} else {
			vf.getMpw().getTxtIngresos().setText("N/A");
		}

		try {
			String rutaImagen = usuarioActual.getProfilePictureRoute();
			if (rutaImagen != null && !rutaImagen.isEmpty()) {
				ImageIcon imagenOriginal = new ImageIcon(rutaImagen);
				if (imagenOriginal.getIconWidth() > 0) {
					Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
					ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
					vf.getMpw().getLblFotoPreview().setIcon(iconoEscalado);
					vf.getMpw().getLblFotoPreview().setText("");
				} else {
					vf.getMpw().getLblFotoPreview().setIcon(null);
					vf.getMpw().getLblFotoPreview().setText(prop.getProperty("controller.myprofile.no.photo"));
				}
			} else {
				vf.getMpw().getLblFotoPreview().setIcon(null);
				vf.getMpw().getLblFotoPreview().setText(prop.getProperty("controller.myprofile.no.photo"));
			}
		} catch (Exception e) {
			System.err.println("Error al cargar imagen de perfil: " + e.getMessage());
			vf.getMpw().getLblFotoPreview().setIcon(null);
			vf.getMpw().getLblFotoPreview().setText(prop.getProperty("controller.myprofile.photo.error"));
		}

		vf.getMmw().setVisible(false);
		vf.getMpw().setVisible(true);
	}
	 /**
     * Genera un PDF con la información del usuario seleccionado.
     * <b>pre</b> Hay un usuario seleccionado o un alias especificado. <br>
     * <b>post</b> Se genera un archivo PDF con la información del usuario. <br>
     * @throws Exception Si no se puede generar el PDF
     */
	public void generarPDFUsuarioSeleccionado() {
		String aliasSeleccionado = vf.getAw().getTxtBuscar().getText().trim();

		if (aliasSeleccionado.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getAw(), prop.getProperty("controller.pdf.empty_alias.message"),
					prop.getProperty("controller.pdf.empty_alias.title"), JOptionPane.WARNING_MESSAGE);
			return;
		}

		MenDTO men = mf.getmDAO().listaMenDTO.stream().filter(m -> m.getAlias().equalsIgnoreCase(aliasSeleccionado))
				.findFirst().orElse(null);

		if (men != null) {
			mf.getmDAO().generarInformePDF(aliasSeleccionado);
			JOptionPane.showMessageDialog(vf.getAw(),
					prop.getProperty("controller.pdf.success.message").replace("{alias}", aliasSeleccionado),
					prop.getProperty("controller.pdf.success.title"), JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		WomenDTO woman = mf.getwDAO().listaWomenDTO.stream()
				.filter(w -> w.getAlias().equalsIgnoreCase(aliasSeleccionado)).findFirst().orElse(null);

		if (woman != null) {
			mf.getwDAO().generarInformePDF(aliasSeleccionado);
			JOptionPane.showMessageDialog(vf.getAw(),
					prop.getProperty("controller.pdf.success.message").replace("{alias}", aliasSeleccionado),
					prop.getProperty("controller.pdf.success.title"), JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		JOptionPane.showMessageDialog(vf.getAw(),
				prop.getProperty("controller.pdf.user_not_found.message").replace("{alias}", aliasSeleccionado),
				prop.getProperty("controller.pdf.user_not_found.title"), JOptionPane.ERROR_MESSAGE);
	}

	 /**
     * Verifica si un correo electrónico ya está registrado en el sistema.
     * <b>pre</b> Los archivos de usuarios están cargados. <br>
     * <b>post</b> Se determina si el correo existe en el sistema. <br>
     * @param correo Correo electrónico a verificar. correo != null, correo != ""
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
     * Solicita las preferencias del usuario según su género para filtrar perfiles.
     * <b>pre</b> El usuario ha iniciado sesión. <br>
     * <b>post</b> Se muestra la ventana de preferencias configurada según el género. <br>
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
     * Aplica y guarda las preferencias seleccionadas por el usuario.
     * <b>pre</b> El usuario ha completado el formulario de preferencias. <br>
     * <b>post</b> Los perfiles se filtran según las preferencias y se muestra la ventana principal. <br>
     * @throws NumberFormatException Si los valores numéricos no son válidos
     * @throws Exception Si hay errores al aplicar las preferencias
     */
	public void aplicarYGuardarPreferencias() {
		User usuarioActual = mf.getUsuarioActual();

		if (usuarioActual == null) {
			JOptionPane.showMessageDialog(vf.getPrefw(), prop.getProperty("controller.preferences.user_not_found.message"), prop.getProperty("controller.preferences.user_not_found.title"),
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			String orientacionUsuario = usuarioActual.getSexualOrientation().toLowerCase().trim();
			
			if (usuarioActual instanceof MenDTO) {
				// ✅ HOMBRE: Obtener y validar preferencias
				int edadMin = Integer.parseInt(vf.getPrefw().getTxtEdadMin().getText().trim());
				int edadMax = Integer.parseInt(vf.getPrefw().getTxtEdadMax().getText().trim());
				String preferenciaDiv = (String) vf.getPrefw().getCmbDivorcios().getSelectedItem();

				// Validar rango de edad
				if (edadMin < 18 || edadMax > 100 || edadMin > edadMax) {
					JOptionPane.showMessageDialog(vf.getPrefw(),
							prop.getProperty("controller.preferences.invalid_age_range.message")
									+ prop.getProperty("controller.preferences.invalid_age_range.message"),
							prop.getProperty("controller.preferences.invalid_age_range.title"), JOptionPane.ERROR_MESSAGE);
					return;
				}

				// ✅ GUARDAR Y COMPARAR: Filtrar perfiles según preferencias de HOMBRE
				if (orientacionUsuario.contains("heterosexual")) {
					// Hombre heterosexual busca MUJERES
					filtrarPerfilesPorPreferenciasHombresHeterosexuales(edadMin, edadMax, preferenciaDiv);
				} else if (orientacionUsuario.contains("homosexual") || orientacionUsuario.equals("gay")) {
					// Hombre homosexual/gay busca HOMBRES
					filtrarPerfilesPorPreferenciasHombresHomosexuales(edadMin, edadMax);
				} else if (orientacionUsuario.contains("bisexual")) {
					// Hombre bisexual busca HOMBRES Y MUJERES
					filtrarPerfilesPorPreferenciasHombresBisexuales(edadMin, edadMax, preferenciaDiv);
				} else if (orientacionUsuario.contains("asexual")) {
					// Hombre asexual busca cualquiera (sin filtro de género, pero sí de edad)
					filtrarPerfilesPorPreferenciasHombresAsexuales(edadMin, edadMax);
				}

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
							prop.getProperty("controller.preferences.invalid_age_range.message")
									+ prop.getProperty("controller.preferences.invalid_age_range.message"),
							prop.getProperty("controller.preferences.invalid_age_range.title"), JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar estatura
				if (estaturaMin < 0.60 || estaturaMin > 2.50) {
					JOptionPane.showMessageDialog(vf.getPrefw(),
							prop.getProperty("controller.preferences.invalid_height.message"), prop.getProperty("controller.preferences.invalid_age_range.title"),
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Validar ingresos
				if (ingresosMin < 0) {
					JOptionPane.showMessageDialog(vf.getPrefw(), prop.getProperty("controller.preferences.invalid_income.message"),
							prop.getProperty("controller.preferences.invalid_income.title"), JOptionPane.ERROR_MESSAGE);
					return;
				}

				// ✅ GUARDAR Y COMPARAR: Filtrar perfiles según preferencias de MUJER
				if (orientacionUsuario.contains("heterosexual")) {
					// Mujer heterosexual busca HOMBRES
					filtrarPerfilesPorPreferenciasMujeresHeterosexuales(edadMin, edadMax, estaturaMin, ingresosMin);
				} else if (orientacionUsuario.contains("homosexual") || orientacionUsuario.equals("lésbica")) {
					// Mujer homosexual/lésbica busca MUJERES
					filtrarPerfilesPorPreferenciasMujeresHomosexuales(edadMin, edadMax);
				} else if (orientacionUsuario.contains("bisexual")) {
					// Mujer bisexual busca HOMBRES Y MUJERES
					filtrarPerfilesPorPreferenciasMujeresBisexuales(edadMin, edadMax, estaturaMin, ingresosMin);
				} else if (orientacionUsuario.contains("asexual")) {
					// Mujer asexual busca cualquiera (sin filtro de género, pero sí de edad)
					filtrarPerfilesPorPreferenciasMujeresAsexuales(edadMin, edadMax);
				}

				// Cerrar ventana de preferencias y mostrar MainWindow
				vf.getPrefw().setAceptado(true);
				vf.getPrefw().setVisible(false);
				vf.getMmw().setVisible(true);
				mostrarPerfil();
			}

		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(vf.getPrefw(),
					prop.getProperty("controller.preferences.errorexception.numberformat.message"),
					prop.getProperty("controller.preferences.errorexception.numberformat.title"), JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(vf.getPrefw(), prop.getProperty("controller.preferences.errorpreferences.title") + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// ==================== MÉTODOS PARA HOMBRES ====================

	/**
	 * Filtra perfiles de HOMBRES para usuarios HOMOSEXUALES/GAY según rango de edad.
	 * <b>pre</b> El usuario actual es homosexual/gay y está autenticado. <br>
	 * <b>post</b> La lista de perfiles actuales contiene solo hombres dentro del rango de edad especificado. <br>
	 * @param edadMin Edad mínima para el filtrado. edadMin >= 18
	 * @param edadMax Edad máxima para el filtrado. edadMax >= edadMin, edadMax <= 100
	 */
	public void filtrarPerfilesPorPreferenciasHombresHeterosexuales(int edadMin, int edadMax, String preferenciaDiv) {
		User usuarioActual = mf.getUsuarioActual();
		mf.cargarPerfiles(usuarioActual);

		List<User> perfilesFiltrados = new ArrayList<>();

		for (User perfil : mf.perfilesActuales) {
			if (perfil instanceof WomenDTO) {
				WomenDTO mujer = (WomenDTO) perfil;
				int edad = calcularEdad(mujer.getBornDate());

				// Comparar edad
				if (edad < edadMin || edad > edadMax) {
					continue;
				}

				// Comparar divorcios
				if (preferenciaDiv.equals("Sí") && !mujer.isHadDivorces()) {
					continue;
				} else if (preferenciaDiv.equals("No") && mujer.isHadDivorces()) {
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
					prop.getProperty("controller.preferences.error_filtered_profiles.message"),
					prop.getProperty("controller.preferences.error_filtered_profiles.title"), JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found.message") + perfilesFiltrados.size() + prop.getProperty("controller.preferences.found_women.message")+ prop.getProperty("controller.preferences.found_women.age") + edadMin
							+ " - " + edadMax + prop.getProperty("controller.preferences.found_women.age.count") + prop.getProperty("controller.preferences.found_women_divorces.message") + preferenciaDiv,
					prop.getProperty("controller.preferences.found.title"), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Filtra HOMBRES para HOMBRES HOMOSEXUALES/GAY
	 */
	public void filtrarPerfilesPorPreferenciasHombresHomosexuales(int edadMin, int edadMax) {
		User usuarioActual = mf.getUsuarioActual();
		mf.cargarPerfiles(usuarioActual);

		List<User> perfilesFiltrados = new ArrayList<>();

		for (User perfil : mf.perfilesActuales) {
			if (perfil instanceof MenDTO) {
				MenDTO hombre = (MenDTO) perfil;
				int edad = calcularEdad(hombre.getBornDate());

				// Comparar edad
				if (edad < edadMin || edad > edadMax) {
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
					prop.getProperty("controller.preferences.found_men_notfound"),
					prop.getProperty("controller.preferences.found_men_notfound.title"), JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found.message") + perfilesFiltrados.size() + prop.getProperty("controller.preferences.found_men.message") + prop.getProperty("controller.preferences.found_men.age") + edadMin
							+ " - " + edadMax + prop.getProperty("controller.preferences.found_men.age.count"),
					prop.getProperty("controller.preferences.found.title"), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Filtra HOMBRES Y MUJERES para HOMBRES BISEXUALES
	 */
	public void filtrarPerfilesPorPreferenciasHombresBisexuales(int edadMin, int edadMax, String preferenciaDiv) {
		User usuarioActual = mf.getUsuarioActual();
		mf.cargarPerfiles(usuarioActual);

		List<User> perfilesFiltrados = new ArrayList<>();

		for (User perfil : mf.perfilesActuales) {
			int edad = calcularEdad(perfil.getBornDate());

			// Comparar edad para ambos
			if (edad < edadMin || edad > edadMax) {
				continue;
			}

			if (perfil instanceof WomenDTO) {
				WomenDTO mujer = (WomenDTO) perfil;

				// Para mujeres: comparar divorcios
				if (preferenciaDiv.equals("Sí") && !mujer.isHadDivorces()) {
					continue;
				} else if (preferenciaDiv.equals("No") && mujer.isHadDivorces()) {
					continue;
				}
				perfilesFiltrados.add(perfil);

			} else if (perfil instanceof MenDTO) {
				// Hombres sin criterios adicionales
				perfilesFiltrados.add(perfil);
			}
		}

		mf.perfilesActuales.clear();
		mf.perfilesActuales.addAll(perfilesFiltrados);
		mf.indiceActual = 0;

		if (perfilesFiltrados.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found_general_notfound"),
					prop.getProperty("controller.preferences.error_filtered_profiles.title"), JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found.message") + perfilesFiltrados.size() + prop.getProperty("controller.preferences.found_general.message") + prop.getProperty("controller.preferences.found_general.age") + edadMin + " - "
							+ edadMax + prop.getProperty("controller.preferences.found_men.age.count") + prop.getProperty("controller.preferences.found.men_women"),
					prop.getProperty("controller.preferences.found.title"), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Filtra TODOS para HOMBRES ASEXUALES (sin orientación restrictiva)
	 */
	public void filtrarPerfilesPorPreferenciasHombresAsexuales(int edadMin, int edadMax) {
		User usuarioActual = mf.getUsuarioActual();
		mf.cargarPerfiles(usuarioActual);

		List<User> perfilesFiltrados = new ArrayList<>();

		for (User perfil : mf.perfilesActuales) {
			int edad = calcularEdad(perfil.getBornDate());

			// Solo filtrar por edad
			if (edad >= edadMin && edad <= edadMax) {
				perfilesFiltrados.add(perfil);
			}
		}

		mf.perfilesActuales.clear();
		mf.perfilesActuales.addAll(perfilesFiltrados);
		mf.indiceActual = 0;

		if (perfilesFiltrados.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found_general_notfound"),
					prop.getProperty("controller.preferences.error_filtered_profiles.title"), JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found.message") + perfilesFiltrados.size() + prop.getProperty("controller.preferences.found_general.message") + prop.getProperty("controller.preferences.found_general.age") + edadMin + " - "
							+ edadMax + prop.getProperty("controller.preferences.found_men.age.count= años\\n"),
					prop.getProperty("controller.preferences.found.title"), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	// ==================== MÉTODOS PARA MUJERES ====================

	/**
	 * Filtra HOMBRES para MUJERES HETEROSEXUALES
	 */
	public void filtrarPerfilesPorPreferenciasMujeresHeterosexuales(int edadMin, int edadMax, double estaturaMin,
			long ingresosMin) {
		User usuarioActual = mf.getUsuarioActual();
		mf.cargarPerfiles(usuarioActual);

		List<User> perfilesFiltrados = new ArrayList<>();

		for (User perfil : mf.perfilesActuales) {
			if (perfil instanceof MenDTO) {
				MenDTO hombre = (MenDTO) perfil;
				int edad = calcularEdad(hombre.getBornDate());

				if (edad < edadMin || edad > edadMax) {
					continue;
				}

				try {
					double estatura = Double.parseDouble(hombre.getStature());
					if (estatura < estaturaMin) {
						continue;
					}
				} catch (NumberFormatException e) {
					continue;
				}

				if (hombre.getMensualIncome() < ingresosMin) {
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
					prop.getProperty("controller.preferences.found_men_notfound"),
					prop.getProperty("controller.preferences.found_men_notfound.title"), JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found.message") + perfilesFiltrados.size() + prop.getProperty("controller.preferences.found_men.message") + prop.getProperty("controller.preferences.found_general.age") + edadMin
							+ " - " + edadMax + prop.getProperty("controller.preferences.found_men.age.count") + prop.getProperty("controller.preferences.found.minimal_height") + estaturaMin + "m\n"
							+ prop.getProperty("controller.preferences.found.minimal_income") + ingresosMin,
					prop.getProperty("controller.preferences.found.title"), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Filtra MUJERES para MUJERES HOMOSEXUALES/LÉSBICA
	 */
	public void filtrarPerfilesPorPreferenciasMujeresHomosexuales(int edadMin, int edadMax) {
		User usuarioActual = mf.getUsuarioActual();
		mf.cargarPerfiles(usuarioActual);

		List<User> perfilesFiltrados = new ArrayList<>();

		for (User perfil : mf.perfilesActuales) {
			if (perfil instanceof WomenDTO) {
				WomenDTO mujer = (WomenDTO) perfil;
				int edad = calcularEdad(mujer.getBornDate());

				if (edad < edadMin || edad > edadMax) {
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
					prop.getProperty("controller.preferences.error_filtered_profiles.message"),
					prop.getProperty("controller.preferences.error_filtered_profiles.title"), JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found.message") + perfilesFiltrados.size() + prop.getProperty("controller.preferences.found_women.message") + prop.getProperty("controller.preferences.found_general.age") + edadMin
							+ " - " + edadMax +prop.getProperty("controller.preferences.found_men.age.count"),
					prop.getProperty("controller.preferences.found.title"), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Filtra HOMBRES Y MUJERES para MUJERES BISEXUALES
	 */
	public void filtrarPerfilesPorPreferenciasMujeresBisexuales(int edadMin, int edadMax, double estaturaMin,
			long ingresosMin) {
		User usuarioActual = mf.getUsuarioActual();
		mf.cargarPerfiles(usuarioActual);

		List<User> perfilesFiltrados = new ArrayList<>();

		for (User perfil : mf.perfilesActuales) {
			int edad = calcularEdad(perfil.getBornDate());

			if (edad < edadMin || edad > edadMax) {
				continue;
			}

			if (perfil instanceof MenDTO) {
				MenDTO hombre = (MenDTO) perfil;

				try {
					double estatura = Double.parseDouble(hombre.getStature());
					if (estatura < estaturaMin) {
						continue;
					}
				} catch (NumberFormatException e) {
					continue;
				}

				if (hombre.getMensualIncome() < ingresosMin) {
					continue;
				}

				perfilesFiltrados.add(perfil);

			} else if (perfil instanceof WomenDTO) {
				// Para mujeres solo filtrar por edad
				perfilesFiltrados.add(perfil);
			}
		}

		mf.perfilesActuales.clear();
		mf.perfilesActuales.addAll(perfilesFiltrados);
		mf.indiceActual = 0;

		if (perfilesFiltrados.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found_general_notfound"),
					prop.getProperty("controller.preferences.found_men_notfound.title"), JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found.message") + perfilesFiltrados.size() + prop.getProperty("controller.preferences.found_general.message") + prop.getProperty("controller.preferences.found_general.age")+ edadMin + " - "
							+ edadMax + prop.getProperty("controller.preferences.found_men.age.count") + prop.getProperty("controller.preferences.found.men_women"),
					prop.getProperty("controller.preferences.found.title"), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Filtra TODOS para MUJERES ASEXUALES (sin orientación restrictiva)
	 */
	public void filtrarPerfilesPorPreferenciasMujeresAsexuales(int edadMin, int edadMax) {
		User usuarioActual = mf.getUsuarioActual();
		mf.cargarPerfiles(usuarioActual);

		List<User> perfilesFiltrados = new ArrayList<>();

		for (User perfil : mf.perfilesActuales) {
			int edad = calcularEdad(perfil.getBornDate());

			if (edad >= edadMin && edad <= edadMax) {
				perfilesFiltrados.add(perfil);
			}
		}

		mf.perfilesActuales.clear();
		mf.perfilesActuales.addAll(perfilesFiltrados);
		mf.indiceActual = 0;

		if (perfilesFiltrados.isEmpty()) {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found_general_notfound"),
					prop.getProperty("controller.preferences.found_men_notfound.title"), JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.found.message") + perfilesFiltrados.size() + prop.getProperty("controller.preferences.found_general.message") + prop.getProperty("controller.preferences.found_general.age")+ edadMin + " - "
							+ edadMax + prop.getProperty("controller.preferences.found_men.age.count"),
					prop.getProperty("controller.preferences.found.title"),JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Muestra la ventana de preferencias según el género del usuario
	 */
	public void mostrarVentanaPreferencias() {
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
	
	public void filtrarPerfilesPorPreferenciasHombres(int edadMin, int edadMax, String preferenciaDiv) {
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
				if (preferenciaDiv.equals(prop.getProperty("controller.preferences.divorced.yes"))
						&& !mujer.isHadDivorces()) {
					continue;
				} else if (preferenciaDiv.equals(prop.getProperty("controller.preferences.divorced.no"))
						&& mujer.isHadDivorces()) {
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
			JOptionPane.showMessageDialog(vf.getMmw(), prop.getProperty("controller.preferences.no_results.message"),
					prop.getProperty("controller.preferences.no_results.title"), JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(), prop.getProperty("controller.preferences.men.results.message")
					.replace("{count}", String.valueOf(perfilesFiltrados.size()))
					.replace("{edadMin}", String.valueOf(edadMin)).replace("{edadMax}", String.valueOf(edadMax))
					.replace("{preferenciaDiv}", preferenciaDiv).replace("{orientacion}", orientacionHombreActual),
					prop.getProperty("controller.preferences.results.title"), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void filtrarPerfilesPorPreferenciasMujeres(int edadMin, int edadMax, double estaturaMin, long ingresosMin) {
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
			JOptionPane.showMessageDialog(vf.getMmw(), prop.getProperty("controller.preferences.no_results.message"),
					prop.getProperty("controller.preferences.no_results.title"), JOptionPane.INFORMATION_MESSAGE);
			mf.cargarPerfiles(usuarioActual);
		} else {
			JOptionPane.showMessageDialog(vf.getMmw(),
					prop.getProperty("controller.preferences.women.results.message")
							.replace("{count}", String.valueOf(perfilesFiltrados.size()))
							.replace("{edadMin}", String.valueOf(edadMin)).replace("{edadMax}", String.valueOf(edadMax))
							.replace("{estaturaMin}", String.valueOf(estaturaMin))
							.replace("{ingresosMin}", String.valueOf(ingresosMin))
							.replace("{orientacion}", orientacionMujerActual),
					prop.getProperty("controller.preferences.results.title"), JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * ✅ MÉTODO AUXILIAR: Verifica si dos orientaciones sexuales son compatibles
	 * Lógica de compatibilidad: - Heterosexual con Heterosexual: SÍ (opuesto
	 * género) - Homosexual con Homosexual: SÍ (mismo género) - Bisexual con
	 * cualquiera: SÍ (bisexual acepta todos) - Otros casos: NO
	 */
	public boolean esCompatibleOrientacionSexual(String orientacion1, String orientacion2) {
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
	public double obtenerTasaCambio(String pais) {
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
