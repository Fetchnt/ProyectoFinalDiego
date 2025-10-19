package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import co.edu.unbosque.controller.Controller;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VentanaPrincipal extends JFrame{
	
	private JLabel icon;
	private JLabel phrase;
	private JButton start;
	
	//idiomas
	private JLabel changeLanguage;
	
	private JButton bSpanish;
	private JButton bPortuguese;
	private JButton bRussian;
	private JButton bChinese;
	private JButton bHebrew;
	
	private JLabel lSpanish;
	private JLabel lPortuguese;
	private JLabel lRussian;
	private JLabel lChinesse;
	private JLabel lHebrew;
	
	//recursos adicionales
	private JLabel lPartnerOne;
	private JLabel lPartnerTwo;
	private JLabel lHeart;
	
	public VentanaPrincipal(Controller controller) {
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
		this.getContentPane().setBackground(Color.decode("#FFFFFF")); //-> falta agregarle color
		
		//logo y título -> lo voy a cambiar después :)
		ImageIcon imageLogo = new ImageIcon(getClass().getResource("icon.JPG"));
		JLabel icon = new JLabel(imageLogo);
		icon.setBounds(0, 10, 960, 200);
		this.add(icon);
		
		//label frase
		phrase = new JLabel("¡Tu amor ideal te está esperando!");
		phrase.setBounds(360, 170, 480, 30);
		phrase.setForeground(Color.decode("#03080D"));
		phrase.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(phrase);

		//boton iniciar
		start = new JButton("INICIAR");
		start.setBounds(400, 410, 180, 50);
		start.setFont(new Font("Arial", Font.BOLD, 20));
		start.setForeground(Color.decode("#000000"));//color letra
		start.setBackground(Color.decode("#EB5F5B"));
		start.setFocusPainted(false);
		start.setBorderPainted(false);
		this.add(start);
		
		//imagenes recursos adicionales
		ImageIcon imageHeart = new ImageIcon(getClass().getResource("heart.JPG"));
		JLabel lheart = new JLabel(imageHeart);
		lheart.setBounds(250, 260, 500, 90);
		this.add(lheart);
		
		ImageIcon imagePartnerOne = new ImageIcon(getClass().getResource("partnerOne.JPG"));
		JLabel lPartnerOne = new JLabel(imagePartnerOne);
		lPartnerOne.setBounds(50, 330, 300, 300);
		this.add(lPartnerOne);
		
		ImageIcon imagePartnerTwo = new ImageIcon(getClass().getResource("partnerTwo.JPG"));
		JLabel lPartnerTwo = new JLabel(imagePartnerTwo);
		lPartnerTwo.setBounds(600, 330, 300, 300);
		this.add(lPartnerTwo);
	}
	

}
