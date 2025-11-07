package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MyProfileWindow extends JFrame {

	private JLabel icon;
	private JPanel panelOpcion;
	private JPanel panelLike;
	private JButton back;
	private JButton close;
	private JLabel lblLike;
	private JLabel option;

	public MyProfileWindow() {
		// configuracion de la ventana -> aplica para todas en modo claro
		this.setTitle("BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F9CFCE")); // -> falta agregarle color

		// --- Encabezado ---
		JLabel icon = new JLabel("");
		icon.setForeground(Color.decode("#F9CFCE"));
		icon.setBackground(Color.decode("#F9CFCE"));
		icon.setIcon(new ImageIcon(MainWindow.class.getResource("/co/edu/unbosque/view/iconStart.JPG")));
		icon.setBounds(0, 0, 980, 150);
		getContentPane().add(icon);

		//----- Aqui para poner la informacion del usuario-----
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBounds(330, 190, 330, 460);
		panelInformacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY),
				"PERFIL", TitledBorder.CENTER, TitledBorder.TOP, new Font("Cooper Black", Font.ITALIC, 15)));
		panelInformacion.setBackground(Color.WHITE);
		getContentPane().add(panelInformacion);
		
		
		//----- panel para las opciones -----
		JPanel panelOpcion = new JPanel();
		panelOpcion.setLayout(null);
		panelOpcion.setBounds(695, 440, 250, 200);
		panelOpcion.setBackground(Color.WHITE);
		add(panelOpcion);
		
		option = new JLabel("OPCIONES");
		option.setBounds(80, 6, 100, 20);
		option.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		option.setBackground(Color.WHITE);
		panelOpcion.add(option);
		
		back = new JButton("VOLVER");
		back.setBounds(80, 60, 94, 40);
		back.setFont(new Font("Arial", Font.BOLD, 12));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelOpcion.add(back);
		
		back = new JButton("CERRAR SESIÓN");
		back.setBounds(64, 108, 130, 40);
		back.setFont(new Font("Arial", Font.BOLD, 12));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelOpcion.add(back);
		
		
		
		//------ panel para los likes ---
		JPanel panelLike = new JPanel();
		panelLike.setLayout(null);
		panelLike.setBounds(695, 200, 250, 200);
		panelLike.setBackground(Color.WHITE);
		add(panelLike);
		
		lblLike = new JLabel("LIKES A TU PERFIL");
		lblLike.setBounds(55, 6, 180, 20);
		lblLike.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		lblLike.setBackground(Color.WHITE);
		panelLike.add(lblLike);
		
		

	}

}
