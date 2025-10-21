package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartWindow extends JFrame {

	private JLabel lIcon;
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
		this.getContentPane().setBackground(Color.decode("#FFFFFF")); // -> falta agregarle color

		// botones
		signIn = new JButton("Registrarse");
		signIn.setBounds(400, 410, 180, 50);
		signIn.setFont(new Font("Arial", Font.BOLD, 20));
		signIn.setForeground(Color.decode("#000000"));// color letra
		signIn.setBackground(Color.decode("#EB5F5B"));
		signIn.setFocusPainted(false);
		signIn.setBorderPainted(false);
		add(signIn);

		login = new JButton("Iniciar Sesion");
		login.setBounds(400, 410, 180, 50);
		login.setFont(new Font("Arial", Font.BOLD, 20));
		login.setForeground(Color.decode("#000000"));
		login.setBackground(Color.decode("#EB5F5B"));
		login.setFocusPainted(false);
		login.setBorderPainted(false);
		add(login);

		exit = new JButton("Salir");
		exit.setBounds(400, 410, 180, 50);
		exit.setFont(new Font("Arial", Font.BOLD, 20));
		exit.setForeground(Color.decode("#000000"));
		exit.setBackground(Color.decode("#EB5F5B"));
		exit.setFocusPainted(false);
		exit.setBorderPainted(false);
		add(exit);

		back = new JButton("Volver");
		back.setBounds(400, 410, 180, 50);
		back.setFont(new Font("Arial", Font.BOLD, 20));
		back.setForeground(Color.decode("#000000"));
		back.setBackground(Color.decode("#EB5F5B"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		add(back);

	}

}
