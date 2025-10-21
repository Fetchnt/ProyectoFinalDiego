package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

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
	private JLabel lImage;
	private JLabel viewMode;
	private JButton darkMode;
	private JButton lightMode;

	public StartWindow() {
		initializeComponents();
		setVisible(false);
	}

	public void initializeComponents() {
		// configuracion de la ventana -> aplica para todas en modo claro
		this.setTitle("Inicio");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F9CFCE"));

		// logo y título -> lo voy a cambiar después :)
		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconStart.JPG"));
		JLabel lIcon = new JLabel(imageLogo);
		lIcon.setBounds(0, 0, 980, 150);
		add(lIcon);

		// -------CONTENEDOR------------
		JPanel panelOption = new JPanel();
		panelOption.setBounds(600, 220, 300, 400);
		panelOption.setBackground(Color.decode("#FFFFFF"));
		panelOption.setVisible(true);

		// botones
		signIn = new JButton("Registrarse");
		signIn.setBounds(60, 30, 180, 50);
		signIn.setFont(new Font("Arial", Font.BOLD, 20));
		signIn.setForeground(Color.decode("#EB5F5B"));// color letra
		signIn.setBackground(Color.decode("#F9CFCE"));
		signIn.setFocusPainted(false);
		signIn.setBorderPainted(false);
		panelOption.add(signIn);

		login = new JButton("Iniciar Sesion");
		login.setBounds(60, 90, 180, 50);
		login.setFont(new Font("Arial", Font.BOLD, 20));
		login.setForeground(Color.decode("#EB5F5B"));
		login.setBackground(Color.decode("#F9CFCE"));
		login.setFocusPainted(false);
		login.setBorderPainted(false);
		panelOption.add(login);

		exit = new JButton("Salir");
		exit.setBounds(120, 120, 80, 50);
		exit.setFont(new Font("Arial", Font.BOLD, 15));
		exit.setForeground(Color.decode("#EB5F5B"));
		exit.setBackground(Color.decode("#F9CFCE"));
		exit.setFocusPainted(false);
		exit.setBorderPainted(false);
		panelOption.add(exit);

		back = new JButton("Volver");
		back.setBounds(60, 120, 80, 50);
		back.setFont(new Font("Arial", Font.BOLD, 15));
		back.setForeground(Color.decode("#EB5F5B"));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelOption.add(back);

		add(panelOption);
		// ----------------------------

		ImageIcon imagePartnerThree = new ImageIcon(getClass().getResource("partnerThree.JPG"));
		JLabel lPartnerThree = new JLabel(imagePartnerThree);
		lPartnerThree.setBounds(100, 200, 450, 420);
		this.add(lPartnerThree);
	}

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

	public JLabel getViewMode() {
		return viewMode;
	}

	public void setViewMode(JLabel viewMode) {
		this.viewMode = viewMode;
	}

	public JButton getDarkMode() {
		return darkMode;
	}

	public void setDarkMode(JButton darkMode) {
		this.darkMode = darkMode;
	}

	public JButton getLightMode() {
		return lightMode;
	}

	public void setLightMode(JButton lightMode) {
		this.lightMode = lightMode;
	}

}
