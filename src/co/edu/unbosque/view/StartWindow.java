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

	private JLabel lIcon;
	private JLabel lPartnerThree;
	private JButton signIn;
	private JButton login;
	private JButton exit;
	private JButton back;
	private JLabel lMail;
	private JLabel lImage;
	private JButton mapButton;

	public StartWindow() {
		initializeComponents();
		setVisible(false);
	}

	public void initializeComponents() {
		// CONFIGURACIÓN GENERAL DE LA VENTANA 
		this.setTitle("Menú principal");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));

		// ---------IMAGEN SUPERIOR--------------
		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconStart.JPG"));
		JLabel lIcon = new JLabel(imageLogo);
		lIcon.setBounds(0, 0, 980, 150);
		add(lIcon);

		// -------PANEL------------
		JPanel panelOption = new JPanel();
		panelOption.setBounds(600, 270, 300, 300);
		panelOption.setBackground(Color.decode("#FFFFFF"));
		panelOption.setLayout(null);
		add(panelOption);

		// ---------BOTONES-------------
		signIn = new JButton("Registrarse");
		signIn.setBounds(60, 40, 180, 50);
		signIn.setFont(new Font("Arial", Font.BOLD, 20));
		signIn.setForeground(Color.decode("#EB5F5B"));// color letra
		signIn.setBackground(Color.decode("#F9CFCE"));
		signIn.setFocusPainted(false);
		signIn.setBorderPainted(false);
		panelOption.add(signIn);

		login = new JButton("Iniciar Sesion");
		login.setBounds(60, 100, 180, 50);
		login.setFont(new Font("Arial", Font.BOLD, 20));
		login.setForeground(Color.decode("#EB5F5B"));
		login.setBackground(Color.decode("#F9CFCE"));
		login.setFocusPainted(false);
		login.setBorderPainted(false);
		panelOption.add(login);

		exit = new JButton("Salir");
		exit.setBounds(155, 220, 85, 50);
		exit.setFont(new Font("Arial", Font.BOLD, 15));
		exit.setForeground(Color.decode("#EB5F5B"));
		exit.setBackground(Color.decode("#F9CFCE"));
		exit.setFocusPainted(false);
		exit.setBorderPainted(false);
		panelOption.add(exit);

		back = new JButton("Volver");
		back.setBounds(60, 220, 85, 50);
		back.setFont(new Font("Arial", Font.BOLD, 15));
		back.setForeground(Color.decode("#EB5F5B"));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelOption.add(back);

		mapButton = new JButton("Ver mapa");
		mapButton.setBounds(60, 160, 180, 50);
		mapButton.setFont(new Font("Arial", Font.BOLD, 20));
		mapButton.setForeground(Color.decode("#EB5F5B"));
		mapButton.setBackground(Color.decode("#F9CFCE"));
		mapButton.setFocusPainted(false);
		mapButton.setBorderPainted(false);
		panelOption.add(mapButton);

		// -----------IMAGES-----------------

		ImageIcon imagePartnerThree = new ImageIcon(getClass().getResource("partnerThree.JPG"));
		JLabel lPartnerThree = new JLabel(imagePartnerThree);
		lPartnerThree.setBounds(100, 200, 450, 420);
		this.add(lPartnerThree);
		
		ImageIcon imageMail = new ImageIcon(getClass().getResource("mail.JPG"));
		JLabel lMail = new JLabel(imageMail);
		lMail.setBounds(700, 170, 100, 100);
		this.add(lMail);
		
	}
	
	public void aplicarInternacionalizacion(Properties prop) {
	    // 🔹 Ventana
	    setTitle(prop.getProperty("bostinder.view.startwindow.title"));

	    // 🔹 Botones principales
	    signIn.setText(prop.getProperty("bostinder.view.startwindow.button.signin"));
	    login.setText(prop.getProperty("bostinder.view.startwindow.button.login"));
	    exit.setText(prop.getProperty("bostinder.view.startwindow.button.exit"));
	    back.setText(prop.getProperty("bostinder.view.startwindow.button.back"));
	    mapButton.setText(prop.getProperty("bostinder.view.startwindow.button.map"));
	}

	//--------GETTERS Y SETTERS------
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

}
