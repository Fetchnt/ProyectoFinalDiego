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

	// PARA DECORACION
	private JLabel lIcon;
	private JLabel lDeco;
	private JLabel lTitle;
	private JLabel lWoman;
	private JLabel lMen;

	// PARA EL PANEL
	private JLabel luserAlias;
	private JLabel lPassword;
	private JLabel lEmail;
	private JTextField userAlias;
	private JTextField password;
	private JTextField email;
	private JButton login;
	private JButton back;

	public LoginWindow() {
		initializeComponents();
		setVisible(false);
	}

	public void initializeComponents() {

		// -----------CONFIGURACION DE LA VENTANA--------
		this.setTitle("Registrarse");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));

		// ---------IMAGEN SUPERIOR----------

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconStart.JPG"));
		lIcon = new JLabel(imageLogo);
		lIcon.setBounds(0, 0, 980, 150);
		add(lIcon);

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
		JPanel panelLogin = new JPanel();
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

	  public JLabel getlIcon() { return lIcon; }
	  
	  public void setlIcon(JLabel lIcon) { this.lIcon = lIcon; }
	 
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

}
