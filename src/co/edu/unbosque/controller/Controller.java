package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import co.edu.unbosque.util.exception.*;
import co.edu.unbosque.model.MenDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.WomenDTO;
import co.edu.unbosque.view.ViewFacade;

public class Controller implements ActionListener {

	private ModelFacade mf;
	private ViewFacade vf;

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
				// Obtener datos básicos comunes a todos los usuarios
				String nombres = vf.getRw().getTxtNombres().getText();
				String apellidos = vf.getRw().getTxtApellidos().getText();
				String apodo = vf.getRw().getTxtApodo().getText();
				String correo = vf.getRw().getTxtCorreo().getText();
				String password = vf.getRw().getTxtPassword().getText();
				String pais = (String) vf.getRw().getCmbPais().getSelectedItem();
				String genero = (String) vf.getRw().getCmbGenero().getSelectedItem();
				String fechaNacimiento = vf.getRw().getTxtFechaNacimiento().getText();

				// Validar campos básicos usando tus excepciones
				ExceptionLauncher.verifyName(nombres);
				ExceptionLauncher.verifyLastName(apellidos);
				ExceptionLauncher.verifyNickname(apodo);
				ExceptionLauncher.verifyEmail(correo);
				ExceptionLauncher.verifyBornDate(fechaNacimiento);
				ExceptionLauncher.verifyComboBox(pais);
				ExceptionLauncher.verifyComboBox(genero);
				ExceptionLauncher.verifyRegisterPassword(password);
				ExceptionLauncher.verifyImageSelected(vf.getRw().getRutaImagenSeleccionada());

				// Crear usuario según el género seleccionado
				if (genero.equals("Masculino")) {
					// Validar campos específicos para hombres
					String estatura = vf.getRw().getTxtEstatura().getText();
					String orientacion = (String) vf.getRw().getCmbOrientacion().getSelectedItem();
					String ingresosStr = vf.getRw().getTxtIngresos().getText();

					// Validar campos específicos
					ExceptionLauncher.verifyStature(estatura);
					ExceptionLauncher.verifyComboBox(orientacion);

					if (ingresosStr.isEmpty()) {
						throw new NumberFormatException("Los ingresos mensuales son obligatorios");
					}

					// Convertir y validar ingresos
					long ingresos = Long.parseLong(ingresosStr);
					if (ingresos < 0) {
						throw new NumberFormatException("Los ingresos no pueden ser negativos");
					}

					// Crear objeto Men
					MenDTO hombre = new MenDTO(nombres, apellidos, apodo, fechaNacimiento, estatura, correo, genero,
							orientacion, "ruta_foto_predeterminada", pais, ingresos);
					mf.getmDAO().create(hombre);

				} else if (genero.equals("Femenino")) {
					// Validar campos específicos para mujeres
					String estatura = vf.getRw().getTxtEstatura().getText();
					String orientacion = (String) vf.getRw().getCmbOrientacion().getSelectedItem();
					String divorciosStr = (String) vf.getRw().getCmbDivorcios().getSelectedItem();

					// Validar campos específicos
					ExceptionLauncher.verifyStature(estatura);
					ExceptionLauncher.verifyComboBox(orientacion);
					ExceptionLauncher.verifyComboBox(divorciosStr);

					// Convertir divorcios a boolean
					boolean tuvoDivorcios = divorciosStr.equals("Sí");

					// Crear objeto Women
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

				// Limpiar campos después del registro
				limpiarCamposRegistro();

			} catch (NameException ex) {
				JOptionPane.showMessageDialog(null,
						"Error en el nombre: Debe tener al menos 5 caracteres y solo letras", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (LastNameException ex) {
				JOptionPane.showMessageDialog(null,
						"Error en los apellidos: Deben tener al menos 5 caracteres y solo letras", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (NickNameException ex) {
				JOptionPane.showMessageDialog(null, "Error en el apodo: Debe tener al menos 5 caracteres y solo letras",
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (EmailException ex) {
				JOptionPane.showMessageDialog(null, "Error en el email: Formato inválido o dominio no permitido",
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (BornDateException ex) {
				JOptionPane.showMessageDialog(null,
						"Error en la fecha de nacimiento: Formato inválido (DD/MM/AAAA) o menor de 18 años", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (ComboBoxException ex) {
				JOptionPane.showMessageDialog(null,
						"Error: Debe seleccionar una opción válida en los campos de selección", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (RegisterPasswordException ex) {
				JOptionPane.showMessageDialog(null, "Error en la contraseña: Debe tener al menos 12 caracteres",
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (StatureException ex) {
				JOptionPane.showMessageDialog(null, "Error en la estatura: Debe ser un número entre 0.60 y 2.10 metros",
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Error en formato numérico: " + ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
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

	public void runGUI() {
		vf.getPw().setVisible(true);
	}
}
