package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase que representa la ventana de registro de la aplicación BosTinder.
 * 
 * <p>
 * Esta ventana permite al usuario registrarse proporcionando información
 * personal como nombres, apellidos, apodo, fecha de nacimiento, correo
 * electrónico, género, orientación sexual, estatura, ingresos, divorcios, país
 * de residencia y una foto de perfil. Incluye validación de correo, subida de
 * imagen y opciones para cambiar el tema visual (modo claro/oscuro).
 * </p>
 * 
 * <p>
 * Incluye elementos gráficos como botones, etiquetas, campos de texto, combos y
 * paneles, y permite aplicar configuraciones de internacionalización y tema
 * visual.
 * </p>
 * Autor: Maria Alejandra Carvajal Nepta
 */
public class RegisterWindow extends JFrame {

	/**
	 * Identificador de versión para la serialización.
	 */
	private static final long serialVersionUID = -663545927077308663L;
	
	//Componentes gráficos de la ventana
	private JPanel panelLogo;
	private JPanel panelForm;
	private JLabel lIcon;
	private JLabel lImage;
	private JLabel lFotoPreview;
	private JLabel lAreaDeRegistro;
	private JLabel lNombres;
	private JLabel lApellidos;
	private JLabel lApodo;
	private JLabel lCorreo;
	private JLabel lGenero;
	private JLabel lOrientacion;
	private JLabel lEstatura;
	private JLabel lIngresos;
	private JLabel lDivorcios;
	private JLabel lFechaNacimiento;
	private JLabel lPais;
	private JLabel lPassword;
	private JLabel lFoto;
	private JLabel lBosTinder;

	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtApodo;
	private JTextField txtCorreo;
	private JTextField txtEstatura;
	private JTextField txtIngresos;
	private JTextField txtFechaNacimiento;
	private JTextField txtPassword;

	private JComboBox<String> cmbGenero;
	private JComboBox<String> cmbOrientacion;
	private JComboBox<String> cmbDivorcios;
	private JComboBox<String> cmbPais;

	private JButton btnSubirFoto;
	private JButton btnVerificarCorreo;
	private JButton btnRegistrar;
	private JButton btnVolver;
	private JButton darkMode;
	private boolean isDarkMode = false;

	private String rutaImagenSeleccionada;
	private boolean correoVerificado = false;
	private String correoVerificadoActual = "";

	/**
	 * Constructor por defecto.
	 * 
	 * @pre No se ha inicializado la ventana.
	 * @post Se inicializan los componentes y se oculta la ventana.
	 */
	public RegisterWindow() {
		initializeComponents();
		setVisible(false);
	}

	/**
	 * Inicializa y configura todos los componentes gráficos de la ventana.
	 * 
	 * @pre No hay componentes gráficos en la ventana.
	 * @post La ventana contiene todos los elementos visuales necesarios, incluyendo paneles, etiquetas, campos de texto, combos y botones.
	 */
	public void initializeComponents() {

		// CONFIGURACIÓN GENERAL DE LA VENTANA
		this.setTitle("Registro de usuario - BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));

		// ---------- IMAGEN SUPERIOR ----------
		panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 980, 150);
		panelLogo.setBackground(Color.decode("#FFFFFF"));
		panelLogo.setLayout(null);
		this.add(panelLogo);

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconBosTinder.png"));
		JLabel lIcon = new JLabel(imageLogo);
		lIcon.setBounds(250, 10, 120, 120);
		panelLogo.add(lIcon);
		// add(lIcon);

		lBosTinder = new JLabel("BosTinder");
		lBosTinder.setBounds(380, 35, 400, 72);
		lBosTinder.setForeground(Color.decode("#303080D"));
		lBosTinder.setFont(new Font("Georgia", Font.BOLD, 70));
		panelLogo.add(lBosTinder);
		// add(lBosTinder);

		// ----------IMAGEN ADICIONAL -----------
		ImageIcon imagePenguin = new ImageIcon(getClass().getResource("bunny.png"));
		lImage = new JLabel(imagePenguin);
		lImage.setBounds(650, 247, 300, 300);
		add(lImage);

		// ---------- TÍTULO ----------
		lAreaDeRegistro = new JLabel("¡Regístrate y encuentra el amor!");
		lAreaDeRegistro.setFont(new Font("Noto Sans", Font.PLAIN, 20));
		lAreaDeRegistro.setBounds(350, 174, 549, 58);
		add(lAreaDeRegistro);

		// ---------- PANEL DE FORMULARIO ----------
		panelForm = new JPanel();
		panelForm.setLayout(null);
		panelForm.setBounds(20, 250, 920, 400);
		panelForm.setBackground(Color.decode("#FFFFFF"));
		add(panelForm);

		// ---------- CAMPOS DE TEXTO ----------
		lNombres = new JLabel("Nombre/s");
		lNombres.setBounds(30, 20, 150, 20);
		panelForm.add(lNombres);

		txtNombres = new JTextField();
		txtNombres.setBounds(30, 45, 164, 20);
		panelForm.add(txtNombres);

		lApellidos = new JLabel("Apellidos");
		lApellidos.setBounds(30, 75, 150, 20);
		panelForm.add(lApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setBounds(30, 100, 164, 20);
		panelForm.add(txtApellidos);

		lApodo = new JLabel("Apodo");
		lApodo.setBounds(30, 130, 150, 20);
		panelForm.add(lApodo);

		txtApodo = new JTextField();
		txtApodo.setBounds(30, 155, 164, 20);
		panelForm.add(txtApodo);

		lFechaNacimiento = new JLabel("Fecha de nacimiento (DD/MM/AAAA)");
		lFechaNacimiento.setBounds(30, 185, 250, 20);
		panelForm.add(lFechaNacimiento);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(30, 210, 164, 20);
		panelForm.add(txtFechaNacimiento);

		lCorreo = new JLabel("Correo electrónico:");
		lCorreo.setBounds(30, 240, 150, 20);
		panelForm.add(lCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(30, 265, 164, 20);
		panelForm.add(txtCorreo);

		btnVerificarCorreo = new JButton("Verificar correo");
		btnVerificarCorreo.setBounds(30, 295, 150, 30);
		btnVerificarCorreo.setBackground(Color.decode("#F9CFCE"));
		btnVerificarCorreo.setFocusPainted(false);
		btnVerificarCorreo.setBorderPainted(false);
		panelForm.add(btnVerificarCorreo);

		lPassword = new JLabel("Contraseña");
		lPassword.setBounds(250, 20, 164, 20);
		panelForm.add(lPassword);

		txtPassword = new JTextField();
		txtPassword.setBounds(250, 45, 164, 20);
		panelForm.add(txtPassword);

		// ---------- CAMPOS DE SELECCIÓN ----------
		lPais = new JLabel("Pais de residencia:");
		lPais.setBounds(250, 75, 150, 20);
		panelForm.add(lPais);

		cmbPais = new JComboBox<>(new String[] { "...", "Angola", "Argentina", "Brasil", "Colombia", "España", "Israel",
				"Kazajistan", "Macao", "Mexico", "Portugal", "Rusia", "Singapur", "Taiwan" });
		cmbPais.setBounds(250, 100, 150, 20);
		panelForm.add(cmbPais);

		lGenero = new JLabel("Selecciona tu género:");
		lGenero.setBounds(250, 130, 150, 20);
		panelForm.add(lGenero);

		cmbGenero = new JComboBox<>(new String[] { "...", "Masculino", "Femenino" });
		cmbGenero.setBounds(250, 155, 150, 22);
		panelForm.add(cmbGenero);

		lEstatura = new JLabel("Estatura (cm):" + " (Mujer Opcional)");
		lEstatura.setBounds(250, 185, 200, 20);
		lEstatura.setVisible(false);
		panelForm.add(lEstatura);

		txtEstatura = new JTextField();
		txtEstatura.setBounds(250, 210, 150, 20);
		txtEstatura.setVisible(false);
		panelForm.add(txtEstatura);

		lOrientacion = new JLabel("Orientación sexual:");
		lOrientacion.setBounds(250, 240, 150, 20);
		lOrientacion.setVisible(false);
		panelForm.add(lOrientacion);

		cmbOrientacion = new JComboBox<>(new String[] { "...", "Heterosexual", "Homosexual", "Bisexual", "Asexual" });
		cmbOrientacion.setBounds(250, 265, 150, 20);
		cmbOrientacion.setVisible(false);
		panelForm.add(cmbOrientacion);

		lIngresos = new JLabel("Ingresos mensuales:");
		lIngresos.setBounds(250, 295, 340, 20);
		lIngresos.setVisible(false);
		panelForm.add(lIngresos);

		txtIngresos = new JTextField();
		txtIngresos.setBounds(250, 330, 150, 20);
		txtIngresos.setVisible(false);
		panelForm.add(txtIngresos);

		lDivorcios = new JLabel("¿Ha tenido divorcios?");
		lDivorcios.setBounds(250, 295, 340, 20);
		lDivorcios.setVisible(false);
		panelForm.add(lDivorcios);

		cmbDivorcios = new JComboBox<>(new String[] { "...", "Si", "No" });
		cmbDivorcios.setBounds(250, 330, 150, 20);
		cmbDivorcios.setVisible(false);
		panelForm.add(cmbDivorcios);

		// ---------- SUBIR FOTO ----------
		lFoto = new JLabel("Foto de perfil (.png):");
		lFoto.setBounds(470, 20, 176, 20);
		panelForm.add(lFoto);

		btnSubirFoto = new JButton("Subir foto");
		btnSubirFoto.setBounds(470, 45, 124, 30);
		btnSubirFoto.setBackground(Color.decode("#F9CFCE"));
		btnSubirFoto.setFocusPainted(false);
		btnSubirFoto.setBorderPainted(false);
		panelForm.add(btnSubirFoto);

		lFotoPreview = new JLabel();
		lFotoPreview.setBounds(470, 90, 150, 150);
		lFotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelForm.add(lFotoPreview);

		// ---------- BOTONES ----------
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(755, 320, 120, 40);
		btnRegistrar.setFont(new Font("Noto Sans", Font.BOLD, 16));
		btnRegistrar.setBackground(Color.decode("#F9CFCE"));
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setBorderPainted(false);
		panelForm.add(btnRegistrar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(660, 320, 90, 40);
		btnVolver.setFont(new Font("Noto Sans", Font.BOLD, 16));
		btnVolver.setBackground(Color.decode("#F9CFCE"));
		btnVolver.setFocusPainted(false);
		btnVolver.setBorderPainted(false);
		panelForm.add(btnVolver);

		ImageIcon changeMode = new ImageIcon(getClass().getResource("changeMode.png"));
		JLabel lChangeMode = new JLabel(changeMode);
		darkMode = new JButton(changeMode);
		darkMode.setBounds(8, 160, 66, 60);
		darkMode.setOpaque(false);
		darkMode.setOpaque(false);
		darkMode.setContentAreaFilled(false);
		darkMode.setFocusPainted(false);
		darkMode.setBorderPainted(false);
		darkMode.addActionListener(e -> cambiarAModoOscuroRW());
		this.add(darkMode);
	}

	/**
	 * Cambia el tema visual de la ventana entre modo claro y modo oscuro.
	 * 
	 * @pre La ventana debe estar inicializada.
	 * @post Se actualiza el color de fondo y estilo de los componentes según el modo.
	 */
	public void cambiarAModoOscuroRW() {
		if (isDarkMode) {
			// Mantiene el modo claro
			this.getContentPane().setBackground(Color.decode("#F9CFCE"));
			panelLogo.setBackground(Color.decode("#FFFFFF"));
			panelForm.setBackground(Color.decode("#FFFFFF"));
			lBosTinder.setForeground(Color.decode("#303080D"));
			lAreaDeRegistro.setForeground(Color.decode("#000000"));

			// Labels del formulario
			lNombres.setForeground(Color.decode("#000000"));
			lApellidos.setForeground(Color.decode("#000000"));
			lApodo.setForeground(Color.decode("#000000"));
			lFechaNacimiento.setForeground(Color.decode("#000000"));
			lCorreo.setForeground(Color.decode("#000000"));
			lPassword.setForeground(Color.decode("#000000"));
			lPais.setForeground(Color.decode("#000000"));
			lGenero.setForeground(Color.decode("#000000"));
			lEstatura.setForeground(Color.decode("#000000"));
			lOrientacion.setForeground(Color.decode("#000000"));
			lIngresos.setForeground(Color.decode("#000000"));
			lDivorcios.setForeground(Color.decode("#000000"));
			lFoto.setForeground(Color.decode("#000000"));

			// Botones del formulario
			btnSubirFoto.setForeground(Color.decode("#EB5F5B"));
			btnSubirFoto.setBackground(Color.decode("#F9CFCE"));
			btnVerificarCorreo.setForeground(Color.decode("#EB5F5B"));
			btnVerificarCorreo.setBackground(Color.decode("#F9CFCE"));
			btnRegistrar.setForeground(Color.decode("#EB5F5B"));
			btnRegistrar.setBackground(Color.decode("#F9CFCE"));
			btnVolver.setForeground(Color.decode("#EB5F5B"));
			btnVolver.setBackground(Color.decode("#F9CFCE"));

			// Campos de texto
			txtNombres.setBackground(Color.decode("#FFFFFF"));
			txtNombres.setForeground(Color.decode("#000000"));
			txtApellidos.setBackground(Color.decode("#FFFFFF"));
			txtApellidos.setForeground(Color.decode("#000000"));
			txtApodo.setBackground(Color.decode("#FFFFFF"));
			txtApodo.setForeground(Color.decode("#000000"));
			txtFechaNacimiento.setBackground(Color.decode("#FFFFFF"));
			txtFechaNacimiento.setForeground(Color.decode("#000000"));
			txtCorreo.setBackground(Color.decode("#FFFFFF"));
			txtCorreo.setForeground(Color.decode("#000000"));
			txtPassword.setBackground(Color.decode("#FFFFFF"));
			txtPassword.setForeground(Color.decode("#000000"));
			txtEstatura.setBackground(Color.decode("#FFFFFF"));
			txtEstatura.setForeground(Color.decode("#000000"));
			txtIngresos.setBackground(Color.decode("#FFFFFF"));
			txtIngresos.setForeground(Color.decode("#000000"));

			// ComboBox
			cmbPais.setBackground(Color.decode("#FFFFFF"));
			cmbPais.setForeground(Color.decode("#000000"));
			cmbGenero.setBackground(Color.decode("#FFFFFF"));
			cmbGenero.setForeground(Color.decode("#000000"));
			cmbOrientacion.setBackground(Color.decode("#FFFFFF"));
			cmbOrientacion.setForeground(Color.decode("#000000"));
			cmbDivorcios.setBackground(Color.decode("#FFFFFF"));
			cmbDivorcios.setForeground(Color.decode("#000000"));

			// Foto preview
			lFotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));

			// Botón darkMode
			darkMode.setBackground(Color.decode("#EB5F5B"));
			darkMode.setForeground(Color.decode("#F9CFCE"));
			darkMode.setText("MODO OSCURO");
			isDarkMode = false;

		} else {
			// Cambia a modo oscuro
			this.getContentPane().setBackground(Color.decode("#11021E"));
			panelLogo.setBackground(Color.decode("#1E1724"));
			panelForm.setBackground(Color.decode("#1E1724"));
			lBosTinder.setForeground(Color.decode("#FF2B91"));
			lAreaDeRegistro.setForeground(Color.decode("#FF7171"));

			// Labels del formulario
			lNombres.setForeground(Color.decode("#DCC8EF"));
			lApellidos.setForeground(Color.decode("#DCC8EF"));
			lApodo.setForeground(Color.decode("#DCC8EF"));
			lFechaNacimiento.setForeground(Color.decode("#DCC8EF"));
			lCorreo.setForeground(Color.decode("#DCC8EF"));
			lPassword.setForeground(Color.decode("#DCC8EF"));
			lPais.setForeground(Color.decode("#DCC8EF"));
			lGenero.setForeground(Color.decode("#DCC8EF"));
			lEstatura.setForeground(Color.decode("#DCC8EF"));
			lOrientacion.setForeground(Color.decode("#DCC8EF"));
			lIngresos.setForeground(Color.decode("#DCC8EF"));
			lDivorcios.setForeground(Color.decode("#DCC8EF"));
			lFoto.setForeground(Color.decode("#DCC8EF"));

			// Botones del formulario
			btnSubirFoto.setForeground(Color.decode("#DCC8EF"));
			btnSubirFoto.setBackground(Color.decode("#52247C"));
			btnVerificarCorreo.setForeground(Color.decode("#DCC8EF"));
			btnVerificarCorreo.setBackground(Color.decode("#52247C"));
			btnRegistrar.setForeground(Color.decode("#DCC8EF"));
			btnRegistrar.setBackground(Color.decode("#52247C"));
			btnVolver.setForeground(Color.decode("#DCC8EF"));
			btnVolver.setBackground(Color.decode("#52247C"));

			// Campos de texto
			txtNombres.setBackground(Color.decode("#2A1F3A"));
			txtNombres.setForeground(Color.decode("#DCC8EF"));
			txtApellidos.setBackground(Color.decode("#2A1F3A"));
			txtApellidos.setForeground(Color.decode("#DCC8EF"));
			txtApodo.setBackground(Color.decode("#2A1F3A"));
			txtApodo.setForeground(Color.decode("#DCC8EF"));
			txtFechaNacimiento.setBackground(Color.decode("#2A1F3A"));
			txtFechaNacimiento.setForeground(Color.decode("#DCC8EF"));
			txtCorreo.setBackground(Color.decode("#2A1F3A"));
			txtCorreo.setForeground(Color.decode("#DCC8EF"));
			txtPassword.setBackground(Color.decode("#2A1F3A"));
			txtPassword.setForeground(Color.decode("#DCC8EF"));
			txtEstatura.setBackground(Color.decode("#2A1F3A"));
			txtEstatura.setForeground(Color.decode("#DCC8EF"));
			txtIngresos.setBackground(Color.decode("#2A1F3A"));
			txtIngresos.setForeground(Color.decode("#DCC8EF"));

			// ComboBox
			cmbPais.setBackground(Color.decode("#2A1F3A"));
			cmbPais.setForeground(Color.decode("#DCC8EF"));
			cmbGenero.setBackground(Color.decode("#2A1F3A"));
			cmbGenero.setForeground(Color.decode("#DCC8EF"));
			cmbOrientacion.setBackground(Color.decode("#2A1F3A"));
			cmbOrientacion.setForeground(Color.decode("#DCC8EF"));
			cmbDivorcios.setBackground(Color.decode("#2A1F3A"));
			cmbDivorcios.setForeground(Color.decode("#DCC8EF"));

			// Foto preview
			lFotoPreview.setBorder(BorderFactory.createLineBorder(Color.decode("#DCC8EF")));

			// Botón darkMode
			darkMode.setBackground(Color.decode("#52247C"));
			darkMode.setForeground(Color.decode("#DCC8EF"));
			darkMode.setText("MODO CLARO");
			isDarkMode = true;
		}
	}

	/**
	 * Aplica los textos traducidos a los componentes  de la ventana segun las propiedades dadas.
	 * 
	 * @param prop Propiedades que contienen los textos traducidos por el idioma.
	 * @pre Las propiedades deben estar correctaamente cargadas.
	 * @post Los textos de los botones y etiquetas se actualizan con los valores traducidos.
	 */
	public void aplicarInternacionalizacion(Properties prop) {
		// Ventana
		setTitle(prop.getProperty("bostinder.view.registerwindow.title"));

		// Título principal
		lAreaDeRegistro.setText(prop.getProperty("bostinder.view.registerwindow.label.areaRegistro"));

		// Labels de texto
		lNombres.setText(prop.getProperty("bostinder.view.registerwindow.label.nombres"));
		lApellidos.setText(prop.getProperty("bostinder.view.registerwindow.label.apellidos"));
		lApodo.setText(prop.getProperty("bostinder.view.registerwindow.label.apodo"));
		lFechaNacimiento.setText(prop.getProperty("bostinder.view.registerwindow.label.fechaNacimiento"));
		lCorreo.setText(prop.getProperty("bostinder.view.registerwindow.label.correo"));
		lPassword.setText(prop.getProperty("bostinder.view.registerwindow.label.password"));
		lPais.setText(prop.getProperty("bostinder.view.registerwindow.label.pais"));
		lGenero.setText(prop.getProperty("bostinder.view.registerwindow.label.genero"));
		lEstatura.setText(prop.getProperty("bostinder.view.registerwindow.label.estatura"));
		lOrientacion.setText(prop.getProperty("bostinder.view.registerwindow.label.orientacion"));
		lIngresos.setText(prop.getProperty("bostinder.view.registerwindow.label.ingresos"));
		lDivorcios.setText(prop.getProperty("bostinder.view.registerwindow.label.divorcios"));
		lFoto.setText(prop.getProperty("bostinder.view.registerwindow.label.foto"));

		// Botones
		btnSubirFoto.setText(prop.getProperty("bostinder.view.registerwindow.button.subirFoto"));
		btnVerificarCorreo.setText(prop.getProperty("bostinder.view.registerwindow.button.verificarCorreo"));
		btnRegistrar.setText(prop.getProperty("bostinder.view.registerwindow.button.registrar"));
		btnVolver.setText(prop.getProperty("bostinder.view.registerwindow.button.volver"));

		// ComboBox País
		String paises = prop.getProperty("bostinder.view.registerwindow.combo.paises");
		if (paises != null) {
			cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(paises.split(",")));
		}

		// ComboBox Género
		String generos = prop.getProperty("bostinder.view.registerwindow.combo.generos");
		if (generos != null) {
			cmbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(generos.split(",")));
		}

		// ComboBox Orientación
		String orientaciones = prop.getProperty("bostinder.view.registerwindow.combo.orientaciones");
		if (orientaciones != null) {
			cmbOrientacion.setModel(new javax.swing.DefaultComboBoxModel<>(orientaciones.split(",")));
		}

		// ComboBox Divorcios
		String divorcios = prop.getProperty("bostinder.view.registerwindow.combo.divorcios");
		if (divorcios != null) {
			cmbDivorcios.setModel(new javax.swing.DefaultComboBoxModel<>(divorcios.split(",")));
		}
	}

	// ---------- GETTERS Y SETTERSS ----------

	/**
	 * 
	 * @return Etiqueta del icono principal.
	 */
	public JLabel getlIcon() {
		return lIcon;
	}
	/**
	 * 
	 * @param lIcon Etiqueta del icono principal.
	 */
	public void setlIcon(JLabel lIcon) {
		this.lIcon = lIcon;
	}

	/**
	 * 
	 * @return Etiqueta de la foto de perfil del usuario.
	 */
	public JLabel getlFotoPreview() {
		return lFotoPreview;
	}

	/**
	 * 
	 * @param lFotoPreview Etiqueta de foto de perfil del usuario.
	 */
	public void setlFotoPreview(JLabel lFotoPreview) {
		this.lFotoPreview = lFotoPreview;
	}

	/**
	 * 
	 * @return Etiqueta del area de registro.
	 */
	public JLabel getlAreaDeRegistro() {
		return lAreaDeRegistro;
	}

	/**
	 * 
	 * @param lAreaDeRegistro Etiqueta del Area de registro.
	 */
	public void setlAreaDeRegistro(JLabel lAreaDeRegistro) {
		this.lAreaDeRegistro = lAreaDeRegistro;
	}

	/**
	 * @return Etiqueta de nombres.
	 */
	public JLabel getlNombres() {
		return lNombres;
	}

	/**
	 * @param lNombres Etiqueta de nombres.
	 */
	public void setlNombres(JLabel lNombres) {
		this.lNombres = lNombres;
	}

	/**
	 * @return Etiqueta de apellidos.
	 */
	public JLabel getlApellidos() {
		return lApellidos;
	}

	/**
	 * @param lApellidos Etiqueta de apellidos.
	 */
	public void setlApellidos(JLabel lApellidos) {
		this.lApellidos = lApellidos;
	}

	/**
	 * @return Etiqueta de apodo.
	 */
	public JLabel getlApodo() {
		return lApodo;
	}
	/**
	 * @param lApodo Etiqueta de apodo.
	 */
	public void setlApodo(JLabel lApodo) {
		this.lApodo = lApodo;
	}

	/**
	 * @return Etiqueta de correo electrónico.
	 */
	public JLabel getlCorreo() {
		return lCorreo;
	}

	/**
	 * @param lCorreo Etiqueta de correo electrónico.
	 */
	public void setlCorreo(JLabel lCorreo) {
		this.lCorreo = lCorreo;
	}
	
	/**
	 * @return Etiqueta de género.
	 */
	public JLabel getlGenero() {
		return lGenero;
	}

	/**
	 * @param lGenero Etiqueta de género.
	 */
	public void setlGenero(JLabel lGenero) {
		this.lGenero = lGenero;
	}
	/**
	 * @return Etiqueta de orientación sexual.
	 */
	public JLabel getlOrientacion() {
		return lOrientacion;
	}

	/**
	 * @param lOrientacion Etiqueta de orientación sexual.
	 */
	public void setlOrientacion(JLabel lOrientacion) {
		this.lOrientacion = lOrientacion;
	}

	/**
	 * @return Etiqueta de estatura.
	 */
	public JLabel getlEstatura() {
		return lEstatura;
	}
	/**
	 * @param lEstatura Etiqueta de estatura.
	 */
	public void setlEstatura(JLabel lEstatura) {
		this.lEstatura = lEstatura;
	}
	/**
	 * @return Etiqueta de ingresos.
	 */
	public JLabel getlIngresos() {
		return lIngresos;
	}
	/**
	 * @param lIngresos Etiqueta de ingresos.
	 */
	public void setlIngresos(JLabel lIngresos) {
		this.lIngresos = lIngresos;
	}
	/**
	 * @return Etiqueta de divorcios.
	 */
	public JLabel getlDivorcios() {
		return lDivorcios;
	}
	/**
	 * @param lDivorcios Etiqueta de divorcios.
	 */
	public void setlDivorcios(JLabel lDivorcios) {
		this.lDivorcios = lDivorcios;
	}
	/**
	 * @return Etiqueta de fecha de nacimiento.
	 */
	public JLabel getlFechaNacimiento() {
		return lFechaNacimiento;
	}
	/**
	 * @param lFechaNacimiento Etiqueta de fecha de nacimiento.
	 */
	public void setlFechaNacimiento(JLabel lFechaNacimiento) {
		this.lFechaNacimiento = lFechaNacimiento;
	}
	/**
	 * @return Campo de texto para nombres.
	 */
	public JTextField getTxtNombres() {
		return txtNombres;
	}
	/**
	 * @param txtNombres Campo de texto para nombres.
	 */
	public void setTxtNombres(JTextField txtNombres) {
		this.txtNombres = txtNombres;
	}
	/**
	 * @return Campo de texto para apellidos.
	 */
	public JTextField getTxtApellidos() {
		return txtApellidos;
	}
	/**
	 * @param txtApellidos Campo de texto para apellidos.
	 */
	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtApellidos = txtApellidos;
	}

	/**
	 * @return Campo de texto para apodo.
	 */
	public JTextField getTxtApodo() {
		return txtApodo;
	}
	/**
	 * @param txtApodo Campo de texto para apodo.
	 */
	public void setTxtApodo(JTextField txtApodo) {
		this.txtApodo = txtApodo;
	}
	/**
	 * @return Campo de texto para correo electrónico.
	 */
	public JTextField getTxtCorreo() {
		return txtCorreo;
	}
	/**
	 * @param txtCorreo Campo de texto para correo electrónico.
	 */
	public void setTxtCorreo(JTextField txtCorreo) {
		this.txtCorreo = txtCorreo;
	}
	/**
	 * @return Campo de texto para estatura.
	 */
	public JTextField getTxtEstatura() {
		return txtEstatura;
	}
	/**
	 * @param txtEstatura Campo de texto para estatura.
	 */
	public void setTxtEstatura(JTextField txtEstatura) {
		this.txtEstatura = txtEstatura;
	}
	/**
	 * @return Campo de texto para ingresos.
	 */
	public JTextField getTxtIngresos() {
		return txtIngresos;
	}
	/**
	 * @param txtIngresos Campo de texto para ingresos.
	 */
	public void setTxtIngresos(JTextField txtIngresos) {
		this.txtIngresos = txtIngresos;
	}
	/**
	 * @return Campo de texto para fecha de nacimiento.
	 */
	public JTextField getTxtFechaNacimiento() {
		return txtFechaNacimiento;
	}
	/**
	 * @param txtFechaNacimiento Campo de texto para fecha de nacimiento.
	 */
	public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
		this.txtFechaNacimiento = txtFechaNacimiento;
	}
	/**
	 * @return ComboBox para selección de género.
	 */
	public JComboBox<String> getCmbGenero() {
		return cmbGenero;
	}
	/**
	 * @param cmbGenero ComboBox para selección de género.
	 */
	public void setCmbGenero(JComboBox<String> cmbGenero) {
		this.cmbGenero = cmbGenero;
	}
	/**
	 * @return ComboBox para selección de orientación sexual.
	 */
	public JComboBox<String> getCmbOrientacion() {
		return cmbOrientacion;
	}
	/**
	 * @param cmbOrientacion ComboBox para selección de orientación sexual.
	 */
	public void setCmbOrientacion(JComboBox<String> cmbOrientacion) {
		this.cmbOrientacion = cmbOrientacion;
	}
	/**
	 * @return ComboBox para selección de divorcios.
	 */
	public JComboBox<String> getCmbDivorcios() {
		return cmbDivorcios;
	}
	/**
	 * @param cmbDivorcios ComboBox para selección de divorcios.
	 */
	public void setCmbDivorcios(JComboBox<String> cmbDivorcios) {
		this.cmbDivorcios = cmbDivorcios;
	}
	/**
	 * @return Botón para subir foto.
	 */
	public JButton getBtnSubirFoto() {
		return btnSubirFoto;
	}
	/**
	 * @param btnSubirFoto Botón para subir foto.
	 */
	public void setBtnSubirFoto(JButton btnSubirFoto) {
		this.btnSubirFoto = btnSubirFoto;
	}
	/**
	 * @return Botón para verificar correo.
	 */
	public JButton getBtnVerificarCorreo() {
		return btnVerificarCorreo;
	}
	/**
	 * @param btnVerificarCorreo Botón para verificar correo.
	 */
	public void setBtnVerificarCorreo(JButton btnVerificarCorreo) {
		this.btnVerificarCorreo = btnVerificarCorreo;
	}
	/**
	 * @return Botón para registrar.
	 */
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}
	/**
	 * @param btnRegistrar Botón para registrar.
	 */
	public void setBtnRegistrar(JButton btnRegistrar) {
		this.btnRegistrar = btnRegistrar;
	}
	/**
	 * @return Etiqueta de imagen adicional.
	 */
	public JLabel getlImage() {
		return lImage;
	}
	/**
	 * @param lImage Etiqueta de imagen adicional.
	 */
	public void setlImage(JLabel lImage) {
		this.lImage = lImage;
	}
	/**
	 * @return Etiqueta de país.
	 */
	public JLabel getlPais() {
		return lPais;
	}
	/**
	 * @param lPais Etiqueta de país.
	 */
	public void setlPais(JLabel lPais) {
		this.lPais = lPais;
	}
	/**
	 * @return Etiqueta de contraseña.
	 */
	public JLabel getlPassword() {
		return lPassword;
	}
	/**
	 * @param lPassword Etiqueta de contraseña.
	 */
	public void setlPassword(JLabel lPassword) {
		this.lPassword = lPassword;
	}
	/**
	 * @return Campo de texto para contraseña.
	 */
	public JTextField getTxtPassword() {
		return txtPassword;
	}
	/**
	 * @param txtPassword Campo de texto para contraseña.
	 */
	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}
	/**
	 * @return ComboBox para selección de país.
	 */
	public JComboBox<String> getCmbPais() {
		return cmbPais;
	}
	/**
	 * @param cmbPais ComboBox para selección de país.
	 */
	public void setCmbPais(JComboBox<String> cmbPais) {
		this.cmbPais = cmbPais;
	}
	/**
	 * @return Botón para volver.
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}
	/**
	 * @param btnVolver Botón para volver.
	 */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	/**
	 * @return Ruta de la imagen seleccionada.
	 */
	public String getRutaImagenSeleccionada() {
		return rutaImagenSeleccionada;
	}
	/**
	 * @param rutaImagenSeleccionada Ruta de la imagen seleccionada.
	 */
	public void setRutaImagenSeleccionada(String rutaImagenSeleccionada) {
		this.rutaImagenSeleccionada = rutaImagenSeleccionada;
	}
	/**
	 * @return Estado de verificación del correo.
	 */
	public boolean isCorreoVerificado() {
		return correoVerificado;
	}
	/**
	 * @param correoVerificado Estado de verificación del correo.
	 */
	public void setCorreoVerificado(boolean correoVerificado) {
		this.correoVerificado = correoVerificado;
	}
	/**
	 * @return Correo verificado actual.
	 */
	public String getCorreoVerificadoActual() {
		return correoVerificadoActual;
	}
	/**
	 * @param correoVerificadoActual Correo verificado actual.
	 */
	public void setCorreoVerificadoActual(String correoVerificadoActual) {
		this.correoVerificadoActual = correoVerificadoActual;
	}

}