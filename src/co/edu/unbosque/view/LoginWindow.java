package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

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

	// PARA EL PANEL
	private JLabel lUser;
	private JLabel lPassword;
	private JLabel lEmail;
	private JTextField user;
	private JTextField password;
	private JTextField email;
	private JButton verificate;
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
		
		//-------TITULO----------
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
		lUser = new JLabel("Usuario");
		lUser.setBounds(128, 80, 150, 20);
		panelLogin.add(lUser);

		lPassword = new JLabel("Contraseña");
		lPassword.setBounds(123, 135, 150, 20);
		panelLogin.add(lPassword);

		lEmail = new JLabel("Correo electrónico");
		lEmail.setBounds(103, 190, 150, 20);
		panelLogin.add(lEmail);

		user = new JTextField();
		user.setBounds(73, 105, 164, 20);
		panelLogin.add(user);

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

		verificate = new JButton("Verificar Correo");
		verificate.setBounds(60, 260, 190, 40);
		verificate.setFont(new Font("Arial", Font.BOLD, 14));
		verificate.setBackground(Color.decode("#F9CFCE"));
		verificate.setFocusPainted(false);
		verificate.setBorderPainted(false);
		panelLogin.add(verificate);
		
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
		return lUser;
	}

	public void setlUser(JLabel lUser) {
		this.lUser = lUser;
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
		return user;
	}

	public void setUser(JTextField user) {
		this.user = user;
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

}
