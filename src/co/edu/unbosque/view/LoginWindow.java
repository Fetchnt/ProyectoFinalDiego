package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	private JLabel lWoman;
	private JLabel lMen;
	private JLabel luserAlias;
	private JLabel lPassword;
	private JLabel lEmail;
	private JLabel lBosTinder;

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

		// --------- IMAGENES--------------
		ImageIcon imageWoman = new ImageIcon(getClass().getResource("womanLogin.JPG"));
		lWoman = new JLabel(imageWoman);
		lWoman.setBounds(23, 220, 340, 375);
		add(lWoman);

		ImageIcon imageMen = new ImageIcon(getClass().getResource("menLogin.JPG"));
		lMen = new JLabel(imageMen);
		lMen.setBounds(650, 220, 340, 375);
		add(lMen);

		// -------TITULO----------
		lTitle = new JLabel("¡Inicia sesión para continuar!");
		lTitle.setFont(new Font("Cooper Black", Font.PLAIN, 18));
		lTitle.setBounds(380, 225, 549, 58);
		add(lTitle);

		// -------PANEL----------
		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		panelLogin.setBounds(360, 210, 300, 400);
		panelLogin.setBackground(Color.WHITE);
		add(panelLogin);

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

		password = new JTextField();
		password.setBounds(73, 160, 164, 20);
		panelLogin.add(password);

		email = new JTextField();
		email.setBounds(73, 215, 164, 20);
		panelLogin.add(email);

		// --------BOTONES--------
		login = new JButton("Entrar");
		login.setBounds(160, 320, 90, 40);
		login.setFont(new Font("Arial", Font.BOLD, 16));
		login.setBackground(Color.decode("#F9CFCE"));
		login.setFocusPainted(false);
		login.setBorderPainted(false);
		panelLogin.add(login);

		back = new JButton("Volver");
		back.setBounds(60, 320, 90, 40);
		back.setFont(new Font("Arial", Font.BOLD, 16));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelLogin.add(back);

		adminMode = new JButton("Modo Admin");
		adminMode.setBounds(60, 270, 190, 40);
		adminMode.setFont(new Font("Arial", Font.BOLD, 16));
		adminMode.setBackground(Color.decode("#F9CFCE"));
		adminMode.setFocusPainted(false);
		adminMode.setBorderPainted(false);
		panelLogin.add(adminMode);
		
		darkMode = new JButton("MODO OSCURO");
		darkMode.setBounds(800, 10, 150, 30);
		darkMode.addActionListener(e -> cambiarAModoOscuro());
		add(darkMode);

	}

	// ----METODO PARA CAMBIAR EL TEMA DEL APLICATIVO------
	public void cambiarAModoOscuro() {
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
			this.getContentPane().setBackground(Color.decode("#161615"));
	        panelLogo.setBackground(Color.decode("#2D2D2D"));
	        panelLogin.setBackground(Color.decode("#2D2D2D"));
	        lBosTinder.setForeground(Color.decode("#F9CFCE"));
	        lTitle.setForeground(Color.decode("#E3225C"));

	        // Labels del panelLogin
	        luserAlias.setForeground(Color.decode("#F9CFCE"));
	        lPassword.setForeground(Color.decode("#F9CFCE"));
	        lEmail.setForeground(Color.decode("#F9CFCE"));

	        // Botones del panelLogin
	        login.setForeground(Color.decode("#F9CFCE"));
	        login.setBackground(Color.decode("#BA1750"));
	        back.setForeground(Color.decode("#F9CFCE"));
	        back.setBackground(Color.decode("#BA1750"));
	        adminMode.setForeground(Color.decode("#F9CFCE"));
	        adminMode.setBackground(Color.decode("#BA1750"));

	        // Campos de texto
	        userAlias.setBackground(Color.decode("#1E1E1E"));
	        userAlias.setForeground(Color.decode("#FFFFFF"));
	        password.setBackground(Color.decode("#1E1E1E"));
	        password.setForeground(Color.decode("#FFFFFF"));
	        email.setBackground(Color.decode("#1E1E1E"));
	        email.setForeground(Color.decode("#FFFFFF"));

	        // Botón darkMode
	        darkMode.setBackground(Color.decode("#BA1750"));
	        darkMode.setForeground(Color.decode("#FFFFFF"));
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

	public JTextField getPassword() {
		return password;
	}

	public void setPassword(JTextField password) {
		this.password = password;
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

	public JLabel getlWoman() {
		return lWoman;
	}

	public void setlWoman(JLabel lWoman) {
		this.lWoman = lWoman;
	}

	public JLabel getlMen() {
		return lMen;
	}

	public void setlMen(JLabel lMen) {
		this.lMen = lMen;
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

}
