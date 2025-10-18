package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VentanaPrincipal extends JFrame{
	
	private JLabel icon;
	private JLabel phrase;
	private JButton start;
	private JLabel changeLanguage;
	private JButton bSpanish;
	private JButton bPortuguese;
	private JButton bRussian;
	private JButton bChinese;
	private JButton bHebrew;
	
	//para las imagenes de los idiomas
	private JLabel lSpanish;
	private JLabel lPortuguese;
	private JLabel lRussian;
	private JLabel lChinesse;
	private JLabel lHebrew;
	
	//me faltan los label para las imagenes de los muñequitos
	
	public VentanaPrincipal() {
		initializeComponents();
		setVisible(true);
	}
	
	public void initializeComponents() {
		//configuracion de la ventana
		this.setTitle("BosTinder");
		this.setBounds(275, 20, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		
		//aqui falta el label para el logo y el titulo
		
		//boton
		
		
		
	}
	

}
