package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MapWindow extends JFrame {

	private JLabel lMap;
	
	public MapWindow() {
		initializeComponents();
		setVisible(false);
	}

	public void initializeComponents() {
		
		// configuracion de la ventana -> aplica para todas en modo claro
		this.setTitle("Map");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#FFFFFF")); // -> falta agregarle color
		
		
	}

}
