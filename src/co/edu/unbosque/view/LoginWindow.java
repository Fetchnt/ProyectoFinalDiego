package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * Ventana de inicio de sesión para la aplicación BosTinder.
 * 
 * <p>Permite al usuario ingresar sus credenciales (usuario, contraseña y correo electrónico)
 * para acceder al sistema. También ofrece opciones para volver, acceder como administrador
 * y cambiar el tema visual entre modo claro y oscuro.</p>
 * 
 * <p>Incluye soporte para internacionalización mediante propiedades externas.</p>
 * 
 * Autor: Maria Alejandra Carvajal Nepta
 */

public class LoginWindow extends JFrame {


	private static final long serialVersionUID = -6607094145774420518L;
	private JPanel panelLogo;
	private JPanel panelLogin;
	private JLabel lIcon;
	private JLabel lDeco;
	private JLabel lTitle;
	private JLabel luserAlias;
	private JLabel lPassword;
	private JLabel lEmail;
	private JLabel lBosTinder;
	private JLabel background;

	private JTextField userAlias;
	private JTextField password;
	private JTextField email;

	private JButton login;
	private JButton back;
	private JButton adminMode;
	private JButton darkMode;
	private boolean isDarkMode = false;

	/**
	 * Constructor por defecto.
	 * 
	 * @pre No se ha inicializado la ventana.
	 * @post Se inicializan todos los componentes gráficos y se oculta la ventana.
	 */
	public LoginWindow() {
		initializeComponents();
		setVisible(false);
	}
	
	

	/**
	 * Inicializa y configura todos los componentes gráficos de la ventana.
	 * 
	 * @pre No hay componentes gráficos en la ventana.
	 * @post La ventana contiene todos los elementos visuales necesarios para el inicio de sesión.
	 */
	public void initializeComponents() {

		// CONFIGURACION DE LA VENTANA
		this.setTitle("Iniciar Sesión- BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));

		  // --------- IMAGEN DE FONDO ---------
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("partnerFour.JPG"));
        background = new JLabel(backgroundImage);
        background.setBounds(0, 0, 980, 730);
        background.setLayout(null);
        this.getContentPane().add(background);
        
		// ---------IMAGEN SUPERIOR----------

		panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 980, 150);
		panelLogo.setBackground(Color.decode("#FFFFFF"));
		panelLogo.setLayout(null);
		background.add(panelLogo);

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

		// -------TITULO----------
		lTitle = new JLabel("¡Inicia sesión para continuar!");
		lTitle.setFont(new Font("Noto Sans", Font.PLAIN, 18));
		lTitle.setBounds(380, 225, 549, 58);
		background.add(lTitle);

		// -------PANEL----------
		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setBounds(360, 210, 300, 400);
		panelLogin.setBackground(Color.WHITE);
		background.add(panelLogin);

		// --------CAMPOS DE TEXTO--------
		luserAlias = new JLabel("Usuario");
		luserAlias.setBounds(128, 80, 150, 20);
		panelLogin.add(luserAlias);

		lPassword = new JLabel("Contraseña");
		lPassword.setBounds(123, 135, 150, 20);
		panelLogin.add(lPassword);

		lEmail = new JLabel("Correo electrónico");
		lEmail.setBounds(103, 190, 150, 20);
		panelLogin.add(lEmail);

		userAlias = new JTextField();
		userAlias.setBounds(73, 105, 164, 20);
		panelLogin.add(userAlias);

		password = new JPasswordField();
		password.setBounds(73, 160, 164, 20);
		panelLogin.add(password);

		email = new JTextField();
		email.setBounds(73, 215, 164, 20);
		panelLogin.add(email);

		// --------BOTONES--------
		login = new JButton("Entrar");
		login.setBounds(160, 320, 90, 40);
		login.setFont(new Font("Noto Sans", Font.BOLD, 16));
		login.setBackground(Color.decode("#F9CFCE"));
		login.setFocusPainted(false);
		login.setBorderPainted(false);
		panelLogin.add(login);

		back = new JButton("Volver");
		back.setBounds(60, 320, 90, 40);
		back.setFont(new Font("Noto Sans", Font.BOLD, 16));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelLogin.add(back);

		adminMode = new JButton("Modo Admin");
		adminMode.setBounds(60, 270, 190, 40);
		adminMode.setFont(new Font("Noto Sans", Font.BOLD, 16));
		adminMode.setBackground(Color.decode("#F9CFCE"));
		adminMode.setFocusPainted(false);
		adminMode.setBorderPainted(false);
		panelLogin.add(adminMode);

		ImageIcon changeMode = new ImageIcon(getClass().getResource("changeMode.png"));
		JLabel lChangeMode = new JLabel(changeMode);
		darkMode = new JButton(changeMode);
		darkMode.setBounds(8, 160, 66, 60);
		darkMode.setOpaque(false);
		darkMode.setOpaque(false);
		darkMode.setContentAreaFilled(false);
		darkMode.setFocusPainted(false);
		darkMode.setBorderPainted(false);
		darkMode.addActionListener(e -> cambiarAModoOscuroLW());
		background.add(darkMode);

	}


     /**
     * Cambia el tema visual de la ventana entre modo claro y modo oscuro.
     * 
     * @pre La ventana debe estar inicializada.
     * @post Se actualiza el color de fondo y estilo de los componentes según el modo.
     */
	public void cambiarAModoOscuroLW() {
		if (isDarkMode) {
			// Mantiene el modo claro
			this.getContentPane().setBackground(Color.decode("#F9CFCE"));
			panelLogo.setBackground(Color.decode("#FFFFFF"));
			panelLogin.setBackground(Color.decode("#FFFFFF"));
			lBosTinder.setForeground(Color.decode("#303080D"));
			lTitle.setForeground(Color.decode("#000000"));

			// Labels del panelLogin
			luserAlias.setForeground(Color.decode("#000000"));
			lPassword.setForeground(Color.decode("#000000"));
			lEmail.setForeground(Color.decode("#000000"));

			// Botones del panelLogin
			login.setForeground(Color.decode("#EB5F5B"));
			login.setBackground(Color.decode("#F9CFCE"));
			back.setForeground(Color.decode("#EB5F5B"));
			back.setBackground(Color.decode("#F9CFCE"));
			adminMode.setForeground(Color.decode("#EB5F5B"));
			adminMode.setBackground(Color.decode("#F9CFCE"));

			// Campos de texto
			userAlias.setBackground(Color.decode("#FFFFFF"));
			userAlias.setForeground(Color.decode("#000000"));
			password.setBackground(Color.decode("#FFFFFF"));
			password.setForeground(Color.decode("#000000"));
			email.setBackground(Color.decode("#FFFFFF"));
			email.setForeground(Color.decode("#000000"));

			// Botón darkMode
			darkMode.setBackground(Color.decode("#EB5F5B"));
			darkMode.setForeground(Color.decode("#F9CFCE"));
			darkMode.setText("MODO OSCURO");
			isDarkMode = false;

		} else {
			// Cambia a modo oscuro
			this.getContentPane().setBackground(Color.decode("#11021E"));
			panelLogo.setBackground(Color.decode("#1E1724"));
			panelLogin.setBackground(Color.decode("#1E1724"));
			lBosTinder.setForeground(Color.decode("#FF2B91"));
			lTitle.setForeground(Color.decode("#FF7171"));

			// Labels del panelLogin
			luserAlias.setForeground(Color.decode("#DCC8EF"));
			lPassword.setForeground(Color.decode("#DCC8EF"));
			lEmail.setForeground(Color.decode("#DCC8EF"));

			// Botones del panelLogin
			login.setForeground(Color.decode("#DCC8EF"));
			login.setBackground(Color.decode("#52247C"));
			back.setForeground(Color.decode("#DCC8EF"));
			back.setBackground(Color.decode("#52247C"));
			adminMode.setForeground(Color.decode("#DCC8EF"));
			adminMode.setBackground(Color.decode("#52247C"));

			// Campos de texto
			userAlias.setBackground(Color.decode("#2A1F3A"));
			userAlias.setForeground(Color.decode("#DCC8EF"));
			password.setBackground(Color.decode("#2A1F3A"));
			password.setForeground(Color.decode("#DCC8EF"));
			email.setBackground(Color.decode("#2A1F3A"));
			email.setForeground(Color.decode("#DCC8EF"));

			// Botón darkMode
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
     * @post Los textos de los botones, etiquetas y título se actualizan con los valores traducidos.
     */
	public void aplicarInternacionalizacion(Properties prop) {
		// Título de la ventana
		setTitle(prop.getProperty("bostinder.view.loginwindow.title"));

		// Título principal
		lTitle.setText(prop.getProperty("bostinder.view.loginwindow.label.title"));

		// Etiquetas de campos
		luserAlias.setText(prop.getProperty("bostinder.view.loginwindow.label.user"));
		lPassword.setText(prop.getProperty("bostinder.view.loginwindow.label.password"));
		lEmail.setText(prop.getProperty("bostinder.view.loginwindow.label.email"));

		// Botones
		login.setText(prop.getProperty("bostinder.view.loginwindow.button.login"));
		back.setText(prop.getProperty("bostinder.view.loginwindow.button.back"));
		adminMode.setText(prop.getProperty("bostinder.view.loginwindow.button.adminMode"));
	}

	// ---------GETTERS Y SETTERS---------


   /**
   * 
   * @return lIcon Etiqueta con el ícono de la aplicación.
   */
	public JLabel getlIcon() {
		return lIcon;
	}
	

    /**
    * Establece la etiqueta del ícono principal de BosTinder.
    * 
    * @param lIcon Etiqueta con el ícono de la aplicación.
    */
	public void setlIcon(JLabel lIcon) {
		this.lIcon = lIcon;
	}
	

    /**
    * @return lDeco Etiqueta decorativa.
    */
	public JLabel getlDeco() {
		return lDeco;
	}
	

    /**
    * @param lDeco Etiqueta decorativa.
    */
	public void setlDeco(JLabel lDeco) {
		this.lDeco = lDeco;
	}
	
	/**
	 * 
	 * @return luserAlias Etiqueta del campo de alias.
	 */

	public JLabel getlUser() {
		return luserAlias;
	}
	
	/**
	 * 
	 * @param lUser Etiqueta del campo de alias.
	 */

	public void setlUser(JLabel lUser) {
		this.luserAlias = lUser;
	}
	
	/**
	 * 
	 * 
	 * @return lPassword Etiqueta del campo de contraseña.
	 */

	public JLabel getlPassword() {
		return lPassword;
	}
	
	/**
	 * 
	 * @param lPassword Etiqueta del campo de contraseña.
	 */

	public void setlPassword(JLabel lPassword) {
		this.lPassword = lPassword;
	}
	
	/**
	 * 
	 * @return lEmail Etiqueta del campo de correo.
	 */

	public JLabel getlEmail() {
		return lEmail;
	}
	
	/**
	 * 
	 * @param lEmail Etiqueta del campo de correo.
	 */

	public void setlEmail(JLabel lEmail) {
		this.lEmail = lEmail;
	}
	
	/**
	 * 
	 * @return userAlias Campo de texto del alias.
	 */

	public JTextField getUser() {
		return userAlias;
	}
	
	/**
	 * 
	 * @param user Campo de texto del alias.
	 */

	public void setUser(JTextField user) {
		this.userAlias = user;
	}
	
	/**
	 * 
	 * @return email Campo de texto del correo.
	 */
	public JTextField getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param email Campo de texto del correo.
	 */

	public void setEmail(JTextField email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return login Botón de inicio de sesión.
	 */

	public JButton getLogin() {
		return login;
	}
	
	/**
	 * 
	 * @param login Botón de inicio de sesión.
	 */

	public void setLogin(JButton login) {
		this.login = login;
	}
	
	/**
	 * 
	 * @return back Botón de volver.
	 */

	public JButton getBack() {
		return back;
	}
	
	/**
	 * 
	 * @param back Botón de volver.
	 */
	public void setBack(JButton back) {
		this.back = back;
	}
	
	/**
	 * 
	 * @return lTitle Etiqueta del título.
	 */

	public JLabel getlTitle() {
		return lTitle;
	}
	
	/**
	 * 
	 * @param lTitle Etiqueta del título.
	 */

	public void setlTitle(JLabel lTitle) {
		this.lTitle = lTitle;
	}
	
	/**
	 * 
	 * @return luserAlias Etiqueta del alias.
	 */

	public JLabel getLuserAlias() {
		return luserAlias;
	}
	
	/**
	 * 
	 * @param luserAlias Etiqueta del alias.
	 */

	public void setLuserAlias(JLabel luserAlias) {
		this.luserAlias = luserAlias;
	}
	
	/**
	 * 
	 * @return userAlias Campo de texto del alias.
	 */

	public JTextField getUserAlias() {
		return userAlias;
	}
	
	/**
	 * 
	 * @param userAlias Campo de texto del alias.
	 */

	public void setUserAlias(JTextField userAlias) {
		this.userAlias = userAlias;
	}
	
	/**
	 * 
	 * @return adminMode Botón de modo administrador.
	 */

	public JButton getAdminMode() {
		return adminMode;
	}
	
	/**
	 * 
	 * @param adminMode Botón de modo administrador.
	 */

	public void setAdminMode(JButton adminMode) {
		this.adminMode = adminMode;
	}
	
	/**
	 * 
	 * @return panelLogo Panel con el logo.
	 */

	public JPanel getPanelLogo() {
		return panelLogo;
	}
	
	/**
	 * 
	 * @param panelLogo Panel con el logo.
	 */

	public void setPanelLogo(JPanel panelLogo) {
		this.panelLogo = panelLogo;
	}
	
	/**
	 * 
	 * @return panelLogin Panel de login.
	 */

	public JPanel getPanelLogin() {
		return panelLogin;
	}
	
	/**
	 * 
	 * @param panelLogin Panel de login.
	 */

	public void setPanelLogin(JPanel panelLogin) {
		this.panelLogin = panelLogin;
	}
	
	/**
	 * 
	 * @return lBosTinder Etiqueta del logo.
	 */
	
	public JLabel getlBosTinder() {
		return lBosTinder;
	}
	
	/**
	 * 
	 * @param lBosTinder Etiqueta del logo.
	 */

	public void setlBosTinder(JLabel lBosTinder) {
		this.lBosTinder = lBosTinder;
	}
	
	/**
	 * 
	 * @param background Etiqueta con la imagen de fondo.
	 */


	public void setBackground(JLabel background) {
		this.background = background;
	}
	
	/**
	 * 
	 * @return darkMode Botón de modo oscuro.
	 */

	public JButton getDarkMode() {
		return darkMode;
	}
	
	/**
	 * 
	 * @param darkMode Botón de modo oscuro.
	 */

	public void setDarkMode(JButton darkMode) {
		this.darkMode = darkMode;
	}
	
	/**
	 * 
	 * @return True si está activado, false si está en modo claro.
	 */

	public boolean isDarkMode() {
		return isDarkMode;
	}
	
	/**
	 * 
	 * @param isDarkMode true para activar, false para desactivar.
	 */

	public void setDarkMode(boolean isDarkMode) {
		this.isDarkMode = isDarkMode;
	}
	
	/**
	 * 
	 * @return password Campo de contraseña.
	 */

	public JTextField getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param password Campo de contraseña.
	 */

	public void setPassword(JTextField password) {
		this.password = password;
	}
	
	

}