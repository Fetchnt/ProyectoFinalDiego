package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Clase que representa la ventana de inicio de laaplicacion BosTinder.
 * 
 * <p>
 * Esta ventana permite al usuario acceder a las opciones principales como registrarse,
 * iniciar sesion, ver el mapa, cambiar al modo oscuro, salir o volver.
 * </p>
 * 
 * <p>
 * Incluye elementos graficos como botones, etiquetas, paneles e imagenes, y permite
 * aplicar configuraciones de internacionalizacion y tema visual.
 * </p>
 * 
 * Autor: Maria Alejandra Carvajal Nepta.
 */
public class StartWindow extends JFrame {

	/**
	 * Identificador de version para la serializacion.
	 */
	private static final long serialVersionUID = 4030797315944790873L;
	
	// Componentes graficos.
	private JPanel panelLogo;
	private JPanel panelOption;

	private JLabel lIcon;
	private JLabel lPartnerThree;
	private JLabel lMail;
	private JLabel lImage;
	private JLabel lBosTinder;
	private JLabel lText;
	
	private JButton signIn;
	private JButton login;
	private JButton exit;
	private JButton back;
	private JButton mapButton;
	private JButton darkMode;
	private boolean isDarkMode = false;
	
	/**
	 * Constructor por defecto.
	 * 
	 * @pre No se ha inicializado la ventana.
	 * @post Se inicializan los componentes y se oculta la ventana. 
	 */
	public StartWindow() {
		initializeComponents();
		setVisible(false);
	}
	
	/**
	 * Inicializa y configura todos los componentes graficos de la ventana.
	 * 
	 * @pre No hay componentes graficos en la ventana.
	 * @post La ventana contiene todos los elementos visuales necesarios.
	 */
	public void initializeComponents() {
		// CONFIGURACIÓN GENERAL DE LA VENTANA
		this.setTitle("Menú principal - BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));

		// ---------LOGO Y TITULO--------------
		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconBosTinder.png"));
		JLabel lIcon = new JLabel(imageLogo);
		lIcon.setBounds(250, 10, 120, 120);
		// panelLogo.add(lIcon);
		add(lIcon);

		lBosTinder = new JLabel("BosTinder");
		lBosTinder.setBounds(380, 35, 400, 72);
		lBosTinder.setForeground(Color.decode("#303080D"));
		lBosTinder.setFont(new Font("Georgia", Font.BOLD, 70));
		// panelLogo.add(lBosTinder);
		add(lBosTinder);
		// -------PANEL------------
		panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 980, 150);
		panelLogo.setBackground(Color.decode("#FFFFFF"));
		panelLogo.setLayout(null);
		this.add(panelLogo);

		panelOption = new JPanel();
		panelOption.setBounds(560, 310, 300, 330);
		panelOption.setBackground(Color.decode("#FFFFFF"));
		panelOption.setLayout(null);
		this.add(panelOption);
		
		lText = new JLabel("¡Bienvenido!");
		lText.setBounds(70, 15, 250, 25);
		lText.setFont(new Font("Noto Sans", Font.BOLD, 25));
		lText.setForeground(Color.decode("#E3225C"));
		panelOption.add(lText);

		// ---------BOTONES-------------
		signIn = new JButton("Registrarse");
		signIn.setBounds(60, 60, 180, 50);
		signIn.setFont(new Font("Noto Sans", Font.BOLD, 20));
		signIn.setForeground(Color.decode("#EB5F5B"));// color letra
		signIn.setBackground(Color.decode("#F9CFCE"));
		signIn.setFocusPainted(false);
		signIn.setBorderPainted(false);
		panelOption.add(signIn);

		login = new JButton("Iniciar Sesion");
		login.setBounds(60, 120, 180, 50);
		login.setFont(new Font("Noto Sans", Font.BOLD, 20));
		login.setForeground(Color.decode("#EB5F5B"));
		login.setBackground(Color.decode("#F9CFCE"));
		login.setFocusPainted(false);
		login.setBorderPainted(false);
		panelOption.add(login);

		exit = new JButton("Salir");
		exit.setBounds(155, 240, 85, 50);
		exit.setFont(new Font("Noto Sans", Font.BOLD, 15));
		exit.setForeground(Color.decode("#EB5F5B"));
		exit.setBackground(Color.decode("#F9CFCE"));
		exit.setFocusPainted(false);
		exit.setBorderPainted(false);
		panelOption.add(exit);

		back = new JButton("Volver");
		back.setBounds(60, 240, 85, 50);
		back.setFont(new Font("Noto Sans", Font.BOLD, 15));
		back.setForeground(Color.decode("#EB5F5B"));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelOption.add(back);

		mapButton = new JButton("Ver mapa");
		mapButton.setBounds(60, 180, 180, 50);
		mapButton.setFont(new Font("Noto Sans", Font.BOLD, 20));
		mapButton.setForeground(Color.decode("#EB5F5B"));
		mapButton.setBackground(Color.decode("#F9CFCE"));
		mapButton.setFocusPainted(false);
		mapButton.setBorderPainted(false);
		panelOption.add(mapButton);

		ImageIcon changeMode = new ImageIcon(getClass().getResource("changeMode.png"));
		JLabel lChangeMode = new JLabel(changeMode);
		darkMode = new JButton(changeMode);
		darkMode.setBounds(8, 160, 66, 60);
		darkMode.setOpaque(false);
		darkMode.setOpaque(false);
		darkMode.setContentAreaFilled(false);
		darkMode.setFocusPainted(false);
		darkMode.setBorderPainted(false);
		darkMode.addActionListener(e -> cambiarAModoOscuroSW());
		this.add(darkMode);

		// -----------IMAGES-----------------

		ImageIcon imagePartnerThree = new ImageIcon(getClass().getResource("partnerThree.png"));
		JLabel lPartnerThree = new JLabel(imagePartnerThree);
		lPartnerThree.setBounds(0, 205, 500, 480);
		this.add(lPartnerThree);

		ImageIcon imageMail = new ImageIcon(getClass().getResource("mail.png"));
		JLabel lMail = new JLabel(imageMail);
		lMail.setBounds(605, 155, 240, 170);
		this.add(lMail);

	}
	
	/**
	 * Cambia el tema visual de la ventana entre modo claro y modo oscuro.
	 * 
	 * @pre La ventana debe estar inicializada.
	 * @post Se actualiza el color de fondo y estilo de los componentes segun el modo.
	 */

	// ----METODO PARA CAMBIAR EL TEMA DEL APLICATIVO------
	public void cambiarAModoOscuroSW() {
		if (isDarkMode) {
			// Mantiene el modo claro
			this.getContentPane().setBackground(Color.decode("#F9CFCE"));
			panelOption.setBackground(Color.decode("#FFFFFF"));
			panelLogo.setBackground(Color.decode("#FFFFFF"));
			lBosTinder.setForeground(Color.decode("#303080D"));

			// Botones del panelOption
			signIn.setForeground(Color.decode("#EB5F5B"));
			signIn.setBackground(Color.decode("#F9CFCE"));
			login.setForeground(Color.decode("#EB5F5B"));
			login.setBackground(Color.decode("#F9CFCE"));
			exit.setForeground(Color.decode("#EB5F5B"));
			exit.setBackground(Color.decode("#F9CFCE"));
			back.setForeground(Color.decode("#EB5F5B"));
			back.setBackground(Color.decode("#F9CFCE"));
			mapButton.setForeground(Color.decode("#EB5F5B"));
			mapButton.setBackground(Color.decode("#F9CFCE"));

			// Botón darkMode
			darkMode.setBackground(Color.decode("#EB5F5B"));
			darkMode.setForeground(Color.decode("#F9CFCE"));
			darkMode.setText("MODO OSCURO");
			isDarkMode = false;

		} else {
			// Cambia a modo oscuro
			this.getContentPane().setBackground(Color.decode("#11021E"));
			panelLogo.setBackground(Color.decode("#1E1724"));
			lBosTinder.setForeground(Color.decode("#FF2B91"));
			panelOption.setBackground(Color.decode("#1E1724"));
			lText.setForeground(Color.decode("#FF7171"));
			signIn.setForeground(Color.decode("#DCC8EF"));
			signIn.setBackground(Color.decode("#52247C"));
			login.setForeground(Color.decode("#DCC8EF"));
			login.setBackground(Color.decode("#52247C"));
			exit.setForeground(Color.decode("#DCC8EF"));
			exit.setBackground(Color.decode("#52247C"));
			back.setForeground(Color.decode("#DCC8EF"));
			back.setBackground(Color.decode("#52247C"));
			mapButton.setForeground(Color.decode("#DCC8EF"));
			mapButton.setBackground(Color.decode("#52247C"));

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
		setTitle(prop.getProperty("bostinder.view.startwindow.title"));

		// Botones principales
		signIn.setText(prop.getProperty("bostinder.view.startwindow.button.signin"));
		login.setText(prop.getProperty("bostinder.view.startwindow.button.login"));
		lText.setText(prop.getProperty("bostinder.view.startwindow.button.login"));
		exit.setText(prop.getProperty("bostinder.view.startwindow.button.exit"));
		back.setText(prop.getProperty("bostinder.view.startwindow.button.back"));
		mapButton.setText(prop.getProperty("bostinder.view.startwindow.button.map"));
	}

	// --------GETTERS Y SETTERS------
	
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
	 * @return Etiqueta de la imagen de los socios.
	 */

	public JLabel getlPartnerThree() {
		return lPartnerThree;
	}
	
	/**
	 * 
	 * @param lPartnerThree Etiqueta de la imagen de los socios.
	 */

	public void setlPartnerThree(JLabel lPartnerThree) {
		this.lPartnerThree = lPartnerThree;
	}
	
	/**
	 * 
	 * @return Boton para registrarse.
	 */

	public JButton getSignIn() {
		return signIn;
	}
	
	/**
	 * 
	 * @param signIn Boton para registrarse.
	 */

	public void setSignIn(JButton signIn) {
		this.signIn = signIn;
	}
	
	/**
	 * 
	 * @return Boton para iniciar sesion.
	 */

	public JButton getLogin() {
		return login;
	}
	
	/**
	 * 
	 * @param login Boton para iniciar sesion.
	 */

	public void setLogin(JButton login) {
		this.login = login;
	}
	
	/**
	 * 
	 * @return Boton para salir.
	 */

	public JButton getExit() {
		return exit;
	}
	
	/**
	 * 
	 * @param exit Boton para salir.
	 */

	public void setExit(JButton exit) {
		this.exit = exit;
	}
	
	/**
	 * 
	 * @return Boton para volver.
	 */

	public JButton getBack() {
		return back;
	}
	
	/**
	 * 
	 * @param back Boton para volver.
	 */

	public void setBack(JButton back) {
		this.back = back;
	}
	
	/**
	 * 
	 * @return Etiqueta de imagen decorativo.
	 */

	public JLabel getlImage() {
		return lImage;
	}
	
	/**
	 * 
	 * @param lImage Etiqueta de imagen decorativa.
	 */

	public void setlImage(JLabel lImage) {
		this.lImage = lImage;
	}
	
	/**
	 * 
	 * @return Etiqueta del icono de correo.
	 */

	public JLabel getlMail() {
		return lMail;
	}
	
	/**
	 * 
	 * @param lMail Etiqueta del icono de correo.
	 */

	public void setlMail(JLabel lMail) {
		this.lMail = lMail;
	}
	
	/**
	 * 
	 * @return Boton para ver el mapa.
	 */

	public JButton getMapButton() {
		return mapButton;
	}
	
	/**
	 * 
	 * @param mapButton Boton para ver el mapa.
	 */

	public void setMapButton(JButton mapButton) {
		this.mapButton = mapButton;
	}
	
	/**
	 * 
	 * @return Boton para cambiar el aspecto.
	 */

	public JButton getDarkMode() {
		return darkMode;
	}
	
	/**
	 * 
	 * @param darkMode Boton para cambiar el aspecto.
	 */

	public void setDarkMode(JButton darkMode) {
		this.darkMode = darkMode;
	}
	
	/**
	 * 
	 * @return Estado actual del modo oscuro.
	 */

	public boolean isDarkMode() {
		return isDarkMode;
	}
	
	/**
	 * 
	 * @param isDarkMode Estado del modo oscuro a establecer.
	 */

	public void setDarkMode(boolean isDarkMode) {
		this.isDarkMode = isDarkMode;
	}
	
	/**
	 * 
	 * @return Panel del logo.
	 */

	public JPanel getPanelLogo() {
		return panelLogo;
	}
	
	/**
	 * 
	 * @param panelLogo Panel del logo a establecer.
	 */

	public void setPanelLogo(JPanel panelLogo) {
		this.panelLogo = panelLogo;
	}
	
	/**
	 * 
	 * @return Etiqueta del titulo BosTinder.
	 */

	public JLabel getlBosTinder() {
		return lBosTinder;
	}
	
	/**
	 * 
	 * @param lBosTinder Etiqueta del titulo BosTinder.
	 */

	public void setlBosTinder(JLabel lBosTinder) {
		this.lBosTinder = lBosTinder;
	}

}