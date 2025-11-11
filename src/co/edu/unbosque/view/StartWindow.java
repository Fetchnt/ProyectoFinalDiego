package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4030797315944790873L;
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

	public StartWindow() {
		initializeComponents();
		setVisible(false);
	}

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
		lText.setFont(new Font("Georgia", Font.BOLD, 25));
		lText.setForeground(Color.decode("#E3225C"));
		panelOption.add(lText);

		// ---------BOTONES-------------
		signIn = new JButton("Registrarse");
		signIn.setBounds(60, 60, 180, 50);
		signIn.setFont(new Font("Arial", Font.BOLD, 20));
		signIn.setForeground(Color.decode("#EB5F5B"));// color letra
		signIn.setBackground(Color.decode("#F9CFCE"));
		signIn.setFocusPainted(false);
		signIn.setBorderPainted(false);
		panelOption.add(signIn);

		login = new JButton("Iniciar Sesion");
		login.setBounds(60, 120, 180, 50);
		login.setFont(new Font("Arial", Font.BOLD, 20));
		login.setForeground(Color.decode("#EB5F5B"));
		login.setBackground(Color.decode("#F9CFCE"));
		login.setFocusPainted(false);
		login.setBorderPainted(false);
		panelOption.add(login);

		exit = new JButton("Salir");
		exit.setBounds(155, 240, 85, 50);
		exit.setFont(new Font("Arial", Font.BOLD, 15));
		exit.setForeground(Color.decode("#EB5F5B"));
		exit.setBackground(Color.decode("#F9CFCE"));
		exit.setFocusPainted(false);
		exit.setBorderPainted(false);
		panelOption.add(exit);

		back = new JButton("Volver");
		back.setBounds(60, 240, 85, 50);
		back.setFont(new Font("Arial", Font.BOLD, 15));
		back.setForeground(Color.decode("#EB5F5B"));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelOption.add(back);

		mapButton = new JButton("Ver mapa");
		mapButton.setBounds(60, 180, 180, 50);
		mapButton.setFont(new Font("Arial", Font.BOLD, 20));
		mapButton.setForeground(Color.decode("#EB5F5B"));
		mapButton.setBackground(Color.decode("#F9CFCE"));
		mapButton.setFocusPainted(false);
		mapButton.setBorderPainted(false);
		panelOption.add(mapButton);

		darkMode = new JButton("MODO OSCURO");
		darkMode.setBounds(800, 10, 150, 30);
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

	public void aplicarInternacionalizacion(Properties prop) {
		// Ventana
		setTitle(prop.getProperty("bostinder.view.startwindow.title"));

		// Botones principales
		signIn.setText(prop.getProperty("bostinder.view.startwindow.button.signin"));
		login.setText(prop.getProperty("bostinder.view.startwindow.button.login"));
		exit.setText(prop.getProperty("bostinder.view.startwindow.button.exit"));
		back.setText(prop.getProperty("bostinder.view.startwindow.button.back"));
		mapButton.setText(prop.getProperty("bostinder.view.startwindow.button.map"));
	}

	// --------GETTERS Y SETTERS------
	public JLabel getlIcon() {
		return lIcon;
	}

	public void setlIcon(JLabel lIcon) {
		this.lIcon = lIcon;
	}

	public JLabel getlPartnerThree() {
		return lPartnerThree;
	}

	public void setlPartnerThree(JLabel lPartnerThree) {
		this.lPartnerThree = lPartnerThree;
	}

	public JButton getSignIn() {
		return signIn;
	}

	public void setSignIn(JButton signIn) {
		this.signIn = signIn;
	}

	public JButton getLogin() {
		return login;
	}

	public void setLogin(JButton login) {
		this.login = login;
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

	public JButton getBack() {
		return back;
	}

	public void setBack(JButton back) {
		this.back = back;
	}

	public JLabel getlImage() {
		return lImage;
	}

	public void setlImage(JLabel lImage) {
		this.lImage = lImage;
	}

	public JLabel getlMail() {
		return lMail;
	}

	public void setlMail(JLabel lMail) {
		this.lMail = lMail;
	}

	public JButton getMapButton() {
		return mapButton;
	}

	public void setMapButton(JButton mapButton) {
		this.mapButton = mapButton;
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

	public JPanel getPanelLogo() {
		return panelLogo;
	}

	public void setPanelLogo(JPanel panelLogo) {
		this.panelLogo = panelLogo;
	}

	public JLabel getlBosTinder() {
		return lBosTinder;
	}

	public void setlBosTinder(JLabel lBosTinder) {
		this.lBosTinder = lBosTinder;
	}

}
