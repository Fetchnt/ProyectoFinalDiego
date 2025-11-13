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

public class LoginWindow extends JFrame {

	/**
	 * 
	 */
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

	public LoginWindow() {
		initializeComponents();
		setVisible(false);
	}

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

		darkMode = new JButton("MODO OSCURO");
		darkMode.setBounds(800, 10, 150, 30);
		darkMode.addActionListener(e -> cambiarAModoOscuroLW());
		background.add(darkMode);

	}

	// ----METODO PARA CAMBIAR EL TEMA DEL APLICATIVO------
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

	public JLabel getlIcon() {
		return lIcon;
	}

	public void setlIcon(JLabel lIcon) {
		this.lIcon = lIcon;
	}

	public JLabel getlDeco() {
		return lDeco;
	}

	public void setlDeco(JLabel lDeco) {
		this.lDeco = lDeco;
	}

	public JLabel getlUser() {
		return luserAlias;
	}

	public void setlUser(JLabel lUser) {
		this.luserAlias = lUser;
	}

	public JLabel getlPassword() {
		return lPassword;
	}

	public void setlPassword(JLabel lPassword) {
		this.lPassword = lPassword;
	}

	public JLabel getlEmail() {
		return lEmail;
	}

	public void setlEmail(JLabel lEmail) {
		this.lEmail = lEmail;
	}

	public JTextField getUser() {
		return userAlias;
	}

	public void setUser(JTextField user) {
		this.userAlias = user;
	}


	public JTextField getEmail() {
		return email;
	}

	public void setEmail(JTextField email) {
		this.email = email;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JLabel getlTitle() {
		return lTitle;
	}

	public void setlTitle(JLabel lTitle) {
		this.lTitle = lTitle;
	}

	public JLabel getLuserAlias() {
		return luserAlias;
	}

	public void setLuserAlias(JLabel luserAlias) {
		this.luserAlias = luserAlias;
	}

	public JTextField getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(JTextField userAlias) {
		this.userAlias = userAlias;
	}

	public JButton getAdminMode() {
		return adminMode;
	}

	public void setAdminMode(JButton adminMode) {
		this.adminMode = adminMode;
	}

	public JPanel getPanelLogo() {
		return panelLogo;
	}

	public void setPanelLogo(JPanel panelLogo) {
		this.panelLogo = panelLogo;
	}

	public JPanel getPanelLogin() {
		return panelLogin;
	}

	public void setPanelLogin(JPanel panelLogin) {
		this.panelLogin = panelLogin;
	}

	public JLabel getlBosTinder() {
		return lBosTinder;
	}

	public void setlBosTinder(JLabel lBosTinder) {
		this.lBosTinder = lBosTinder;
	}


	public void setBackground(JLabel background) {
		this.background = background;
	}

	public JButton getDarkMode() {
		return darkMode;
	}

	public void setDarkMode(JButton darkMode) {
		this.darkMode = darkMode;
	}

	public boolean isDarkMode() {
		return isDarkMode;
	}

	public void setDarkMode(boolean isDarkMode) {
		this.isDarkMode = isDarkMode;
	}

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JTextField password) {
		this.password = password;
	}
	
	

}