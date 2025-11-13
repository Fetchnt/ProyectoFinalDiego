package co.edu.unbosque.view;

import java.awt.Color;

import java.awt.Font;
import javax.swing.*;

import java.util.Properties;



 /**
 * Ventana principal de la aplicación BosTinder.
 * 
 * <p>Esta interfaz gráfica permite al usuario visualizar perfiles, dar "me gusta" o "no me gusta",
 * acceder a su perfil, cerrar sesión, activar modo incógnito, ver los perfiles que le han gustado
 * y cambiar el tema visual entre modo claro y oscuro.</p>
 * 
 * <p>La clase extiende {@code JFrame} y contiene múltiples componentes gráficos organizados
 * en paneles, etiquetas, botones y áreas de texto.</p>
 * 
 * Autor: Maria Alejandra Carvajal Nepta
 */

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5700920981964266645L;
	private JLabel lblProfilePicture;
	private JLabel lblNameAge;
	private JLabel lblTitulo;
	private JLabel lBosTinder;

	private JTextArea txtDescription;

	private JButton btnLike;
	private JButton btnNope;
	private JButton btnProfile;
	private JButton btnLogOff;
	private JButton btnVerMeGusta;
	private JButton btnModoIncognito;
	private JButton darkMode;
	private boolean isDarkMode = false;

	private JPanel panelMenu;
	private JPanel panelLogo;
	

     /**
     * Constructor por defecto.
     * 
     * @pre No se ha inicializado la ventana.
     * @post Se inicializan todos los componentes gráficos y se oculta la ventana.
     */
	public MainWindow() {
		// CONFIGURACION DE LA VENTANA
		this.setTitle("Inicio - BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));
		getContentPane().setLayout(null);

		// ---------IMAGEN SUPERIOR----------

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

		lblTitulo = new JLabel("隆Bienvenido a BosTinder!");
		lblTitulo.setFont(new Font("Noto Sans", Font.PLAIN, 20));
		lblTitulo.setBounds(110, 166, 361, 58);
		getContentPane().add(lblTitulo);

		// --- FOTO GRANDE DEL PERFIL ---
		lblProfilePicture = new JLabel();
		lblProfilePicture.setBounds(57, 222, 350, 350);
		lblProfilePicture.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
		getContentPane().add(lblProfilePicture);

		// --- NOMBRE Y EDAD DEBAJO DE LA FOTO ---
		lblNameAge = new JLabel("", SwingConstants.CENTER);
		lblNameAge.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		lblNameAge.setBounds(57, 571, 350, 25);
		getContentPane().add(lblNameAge);

		// --- DESCRIPCI脫N A LA DERECHA ---
		txtDescription = new JTextArea();
		txtDescription.setBounds(422, 290, 390, 280);
		txtDescription.setLineWrap(true);
		txtDescription.setWrapStyleWord(true);
		txtDescription.setEditable(false);
		txtDescription.setFont(new Font("Noto Sans", Font.PLAIN, 14));
		txtDescription.setBackground(Color.WHITE);
		txtDescription.setBorder(BorderFactory.createTitledBorder("Descripci贸n"));
		getContentPane().add(txtDescription);

		ImageIcon imagen1 = new ImageIcon(getClass().getResource("nope.png"));
		JLabel labelImagen1 = new JLabel(imagen1);
		btnNope = new JButton(imagen1);
		btnNope.setBounds(284, 592, 69, 67);
		btnNope.setOpaque(false);
		btnNope.setContentAreaFilled(false);
		btnNope.setFocusPainted(false);
		btnNope.setBorderPainted(false);
		getContentPane().add(btnNope);
		
		ImageIcon imagen2 = new ImageIcon(getClass().getResource("like.png"));
		JLabel labelImagen2 = new JLabel(imagen2);
		btnLike = new JButton(imagen2);
		btnLike.setBounds(100, 595, 67, 67);
		btnLike.setOpaque(false);
		btnLike.setContentAreaFilled(false);
		btnLike.setFocusPainted(false);
		btnLike.setBorderPainted(false);
		getContentPane().add(btnLike);	

		// --- BOTONES LATERALES ---
		panelMenu = new JPanel();
		panelMenu.setBounds(422, 222, 485, 60);
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setLayout(null);
		add(panelMenu);

		btnVerMeGusta = new JButton("Ver me gusta");
		btnVerMeGusta.setBounds(10, 18, 110, 25);
		btnVerMeGusta.setBackground(Color.decode("#F9CFCE"));
		btnVerMeGusta.setForeground(Color.decode("#EB5F5B"));
		btnVerMeGusta.setFocusPainted(false);
		btnVerMeGusta.setBorderPainted(false);
		// getContentPane().add(btnVerMeGusta);
		panelMenu.add(btnVerMeGusta);

		btnModoIncognito = new JButton("Modo Incognito");
		btnModoIncognito.setBounds(126, 18, 122, 25);
		btnModoIncognito.setBackground(Color.decode("#F9CFCE"));
		btnModoIncognito.setForeground(Color.decode("#EB5F5B"));
		btnModoIncognito.setFocusPainted(false);
		btnModoIncognito.setBorderPainted(false);
		// getContentPane().add(btnModoIncognito);
		panelMenu.add(btnModoIncognito);

		btnProfile = new JButton("Mi Perfil");
		btnProfile.setBounds(253, 18, 105, 25);
		btnProfile.setBackground(Color.decode("#F9CFCE"));
		btnProfile.setForeground(Color.decode("#EB5F5B"));
		btnProfile.setFocusPainted(false);
		btnProfile.setBorderPainted(false);
		// getContentPane().add(btnProfile);
		panelMenu.add(btnProfile);

		btnLogOff = new JButton("Cerrar sesi贸n");
		btnLogOff.setBounds(363, 18, 113, 25);
		btnLogOff.setBackground(Color.decode("#F9CFCE"));
		btnLogOff.setForeground(Color.decode("#EB5F5B"));
		btnLogOff.setFocusPainted(false);
		btnLogOff.setBorderPainted(false);
		// getContentPane().add(btnLogOff);
		panelMenu.add(btnLogOff);

		darkMode = new JButton("MODO OSCURO");
		darkMode.setBounds(800, 10, 150, 30);
		darkMode.addActionListener(e -> cambiarAModoOscuroMW());
		add(darkMode);

		// ------IMAGEN-------
		ImageIcon imageHeartTwo = new ImageIcon(getClass().getResource("heartTwo.png"));
		JLabel imageHeart = new JLabel(imageHeartTwo);
		imageHeart.setBounds(810, 300, 160, 300);
		this.add(imageHeart);

	}
	

     /**
     * Cambia el tema visual de la ventana entre modo claro y modo oscuro.
     * 
     * @pre La ventana debe estar inicializada.
     * @post Se actualiza el color de fondo y estilo de los componentes según el modo.
     */
	public void cambiarAModoOscuroMW() {
		if (isDarkMode) {
			// Mantiene el modo claro
			this.getContentPane().setBackground(Color.decode("#F9CFCE"));
			panelMenu.setBackground(Color.decode("#FFFFFF"));
			panelLogo.setBackground(Color.decode("#FFFFFF"));
			lBosTinder.setForeground(Color.decode("#303080D"));
			lblTitulo.setForeground(Color.decode("#000000"));
			lblNameAge.setForeground(Color.decode("#000000"));

			// 脕rea de texto
			txtDescription.setBackground(Color.decode("#FFFFFF"));
			txtDescription.setForeground(Color.decode("#000000"));

			// Botones principales
			btnLike.setForeground(Color.decode("#F9CFCE"));
			btnLike.setBackground(Color.decode("#EB5F5B"));
			btnNope.setForeground(Color.decode("#F9CFCE"));
			btnNope.setBackground(Color.decode("#EB5F5B"));

			// Botones del panelMenu
			btnVerMeGusta.setForeground(Color.decode("#EB5F5B"));
			btnVerMeGusta.setBackground(Color.decode("#F9CFCE"));
			btnModoIncognito.setForeground(Color.decode("#EB5F5B"));
			btnModoIncognito.setBackground(Color.decode("#F9CFCE"));
			btnProfile.setForeground(Color.decode("#EB5F5B"));
			btnProfile.setBackground(Color.decode("#F9CFCE"));
			btnLogOff.setForeground(Color.decode("#EB5F5B"));
			btnLogOff.setBackground(Color.decode("#F9CFCE"));

			// Borde de la foto de perfil
			lblProfilePicture.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

			// Bot贸n darkMode
			ImageIcon changeMode = new ImageIcon(getClass().getResource("changeMode.png"));
			JLabel lChangeMode = new JLabel(changeMode);
			darkMode = new JButton(changeMode);
			darkMode.setBounds(8, 160, 66, 60);
			darkMode.setOpaque(false);
			darkMode.setOpaque(false);
			darkMode.setContentAreaFilled(false);
			darkMode.setFocusPainted(false);
			darkMode.setBorderPainted(false);
			darkMode.addActionListener(e -> cambiarAModoOscuroMW());
			add(darkMode);

		} else {
			// Cambia a modo oscuro
			this.getContentPane().setBackground(Color.decode("#11021E"));
			panelMenu.setBackground(Color.decode("#1E1724"));
			panelLogo.setBackground(Color.decode("#1E1724"));
			lBosTinder.setForeground(Color.decode("#FF2B91"));
			lblTitulo.setForeground(Color.decode("#FF7171"));
			lblNameAge.setForeground(Color.decode("#DCC8EF"));

			// 脕rea de texto
			txtDescription.setBackground(Color.decode("#2A1F3A"));
			txtDescription.setForeground(Color.decode("#DCC8EF"));

			// Botones principales
			btnLike.setForeground(Color.decode("#DCC8EF"));
			btnLike.setBackground(Color.decode("#52247C"));
			btnNope.setForeground(Color.decode("#DCC8EF"));
			btnNope.setBackground(Color.decode("#52247C"));

			// Botones del panelMenu
			btnVerMeGusta.setForeground(Color.decode("#DCC8EF"));
			btnVerMeGusta.setBackground(Color.decode("#52247C"));
			btnModoIncognito.setForeground(Color.decode("#DCC8EF"));
			btnModoIncognito.setBackground(Color.decode("#52247C"));
			btnProfile.setForeground(Color.decode("#DCC8EF"));
			btnProfile.setBackground(Color.decode("#52247C"));
			btnLogOff.setForeground(Color.decode("#DCC8EF"));
			btnLogOff.setBackground(Color.decode("#52247C"));

			// Borde de la foto de perfil
			lblProfilePicture.setBorder(BorderFactory.createLineBorder(Color.decode("#DCC8EF"), 2));

			// Bot贸n darkMode
			darkMode.setBackground(Color.decode("#52247C"));
			darkMode.setForeground(Color.decode("#DCC8EF"));
			darkMode.setText("MODO CLARO");
			isDarkMode = true;
		}

	}
	

	     /**
	     * Aplica los textos traducidos a los componentes de la ventana según las propiedades dadas.
	     * 
	     * @param prop Propiedades que contienen los textos traducidos por idioma.
	     * @pre Las propiedades deben estar correctamente cargadas.
	     * @post Los textos de los botones, etiquetas y títulos se actualizan con los valores traducidos.
	     */
	public void aplicarInternacionalizacion(Properties prop) {
		// T铆tulo de la ventana
		setTitle(prop.getProperty("bostinder.view.mainwindow.title"));

		lblTitulo.setText(prop.getProperty("bostinder.view.mainwindow.header"));

		// Bordes y t铆tulo de descripci贸n
		txtDescription.setBorder(
				BorderFactory.createTitledBorder(prop.getProperty("bostinder.view.mainwindow.label.description")));

		// Botones principales
		btnLike.setText(prop.getProperty("bostinder.view.mainwindow.button.like"));
		btnNope.setText(prop.getProperty("bostinder.view.mainwindow.button.nope"));
		btnProfile.setText(prop.getProperty("bostinder.view.mainwindow.button.profile"));
		btnLogOff.setText(prop.getProperty("bostinder.view.mainwindow.button.logout"));
		btnModoIncognito.setText(prop.getProperty("bostinder.view.mainwindow.button.incognito"));
		btnVerMeGusta.setText(prop.getProperty("bostinder.view.mainwindow.button.seelikes"));

	}
	

     /**
     * @return Etiqueta de la imagen del perfil.
     */
	public JLabel getLblProfilePicture() {
		return lblProfilePicture;
	}
	

     /**
     * @param lblProfilePicture Etiqueta de la imagen del perfil.
     */
	public void setLblProfilePicture(JLabel lblProfilePicture) {
		this.lblProfilePicture = lblProfilePicture;
	}
	

     /**
     * @return Etiqueta con el nombre y edad del perfil.
     */
	public JLabel getLblNameAge() {
		return lblNameAge;
	}
	

     /**
     * @param lblNameAge Etiqueta con el nombre y edad del perfil.
     */
	public void setLblNameAge(JLabel lblNameAge) {
		this.lblNameAge = lblNameAge;
	}
	

     /**
     * @return Área de texto con la descripción del perfil.
     */
	public JTextArea getTxtDescription() {
		return txtDescription;
	}
	

     /**
     * @param txtDescription Área de texto con la descripción del perfil.
     */
	public void setTxtDescription(JTextArea txtDescription) {
		this.txtDescription = txtDescription;
	}
	

     /**
     * @return Botón para dar "me gusta".
     */
	public JButton getBtnLike() {
		return btnLike;
	}
	

	 /**
	 * @param btnLike Botón para dar "me gusta".
     */


	public void setBtnLike(JButton btnLike) {
		this.btnLike = btnLike;
	}
	

     /**
     * @return Botón para dar "no me gusta".
     */
	public JButton getBtnNope() {
		return btnNope;
	}
	

     /**
     * @param btnNope Botón para dar "no me gusta".
     */
	public void setBtnNope(JButton btnNope) {
		this.btnNope = btnNope;
	}
	

     /**
     * @return Botón para acceder al perfil del usuario.
     */
	public JButton getBtnProfile() {
		return btnProfile;
	}
	

	 /**
     * @param btnProfile Botón para acceder al perfil del usuario.
     */
	public void setBtnProfile(JButton btnProfile) {
		this.btnProfile = btnProfile;
	}
	

     /**
     * @return Botón para cerrar sesión.
     */
	public JButton getBtnLogOff() {
		return btnLogOff;
	}
	

     /**
     * @param btnLogOff Botón para cerrar sesión.
     */
	public void setBtnLogOff(JButton btnLogOff) {
		this.btnLogOff = btnLogOff;
	}
	

     /**
     * @return Botón para ver los perfiles que le han gustado al usuario.
     */
	public JButton getBtnVerMeGusta() {
		return btnVerMeGusta;
	}
	

     /**
     * @param btnVerMeGusta Botón para ver los perfiles que le han gustado al usuario.
     */
	public void setBtnVerMeGusta(JButton btnVerMeGusta) {
		this.btnVerMeGusta = btnVerMeGusta;
	}
	

     /**
     * @return Botón para activar el modo incógnito.
     */
	public JButton getBtnModoIncognito() {
		return btnModoIncognito;
	}
	

     /**
     * @param btnModoIncognito Botón para activar el modo incógnito.
     */
	public void setBtnModoIncognito(JButton btnModoIncognito) {
		this.btnModoIncognito = btnModoIncognito;
	}
	

     /**
     * @return Etiqueta del título principal de la ventana.
     */
	public JLabel getLblTitulo() {
		return lblTitulo;
	}
	

     /**
     * @param lblTitulo Etiqueta del título principal de la ventana.
     */
	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}
	

     /**
     * @return Panel que contiene los botones de navegación.
     */
	public JPanel getPanelMenu() {
		return panelMenu;
	}
	

     /**
     * @param panelMenu Panel que contiene los botones de navegación.
     */
	public void setPanelMenu(JPanel panelMenu) {
		this.panelMenu = panelMenu;
	}
	

     /**
     * @return Etiqueta del logo BosTinder.
     */
	public JLabel getlBosTinder() {
		return lBosTinder;
	}
	

     /**
     * @param lBosTinder Etiqueta del logo BosTinder.
     */
	public void setlBosTinder(JLabel lBosTinder) {
		this.lBosTinder = lBosTinder;
	}
	

     /**
     * @return Botón para cambiar el modo visual.
     */
	public JButton getDarkMode() {
		return darkMode;
	}
	

     /**
     * @param darkMode Botón para cambiar el modo visual.
     */
	public void setDarkMode(JButton darkMode) {
		this.darkMode = darkMode;
	}
	

     /**
     * @return true si el modo oscuro está activado, false si está en modo claro.
     */
	public boolean isDarkMode() {
		return isDarkMode;
	}
	

     /**
     * @param isDarkMode true para activar modo oscuro, false para modo claro.
     */
	public void setDarkMode(boolean isDarkMode) {
		this.isDarkMode = isDarkMode;
	}
	

     /**
     * @return Panel superior que contiene el logo.
     */
	public JPanel getPanelLogo() {
		return panelLogo;
	}
	

     /**
     * @param panelLogo Panel superior que contiene el logo.
     */
	public void setPanelLogo(JPanel panelLogo) {
		this.panelLogo = panelLogo;
	}

}