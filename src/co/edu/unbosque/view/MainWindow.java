package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import co.edu.unbosque.controller.Controller;

public class MainWindow extends JFrame{

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
	
	public MainWindow(Controller controller) {
		initializeComponents();
		setVisible(true);
	}
	
	public void initializeComponents() {
		//configuracion de la ventana
		this.setTitle("BosTinder");
		this.setBounds(230, 5, 980, 720);
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
		
		//label para idiomas
		changeLanguage = new JLabel("-> Cambiar Idioma");
		changeLanguage.setBounds(415, 440, 250, 150);
		changeLanguage.setForeground(Color.decode("#03080D"));
		changeLanguage.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(changeLanguage);

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
		
		//botones con imagenes de los idiomas
		
	}

	public JLabel getIcon() {
		return icon;
	}

	public void setIcon(JLabel icon) {
		this.icon = icon;
	}

	public JLabel getPhrase() {
		return phrase;
	}

	public void setPhrase(JLabel phrase) {
		this.phrase = phrase;
	}

	public JButton getStart() {
		return start;
	}

	public void setStart(JButton start) {
		this.start = start;
	}

	public JLabel getChangeLanguage() {
		return changeLanguage;
	}

	public void setChangeLanguage(JLabel changeLanguage) {
		this.changeLanguage = changeLanguage;
	}

	public JButton getbSpanish() {
		return bSpanish;
	}

	public void setbSpanish(JButton bSpanish) {
		this.bSpanish = bSpanish;
	}

	public JButton getbPortuguese() {
		return bPortuguese;
	}

	public void setbPortuguese(JButton bPortuguese) {
		this.bPortuguese = bPortuguese;
	}

	public JButton getbRussian() {
		return bRussian;
	}

	public void setbRussian(JButton bRussian) {
		this.bRussian = bRussian;
	}

	public JButton getbChinese() {
		return bChinese;
	}

	public void setbChinese(JButton bChinese) {
		this.bChinese = bChinese;
	}

	public JButton getbHebrew() {
		return bHebrew;
	}

	public void setbHebrew(JButton bHebrew) {
		this.bHebrew = bHebrew;
	}

	public JLabel getlSpanish() {
		return lSpanish;
	}

	public void setlSpanish(JLabel lSpanish) {
		this.lSpanish = lSpanish;
	}

	public JLabel getlPortuguese() {
		return lPortuguese;
	}

	public void setlPortuguese(JLabel lPortuguese) {
		this.lPortuguese = lPortuguese;
	}

	public JLabel getlRussian() {
		return lRussian;
	}

	public void setlRussian(JLabel lRussian) {
		this.lRussian = lRussian;
	}

	public JLabel getlChinesse() {
		return lChinesse;
	}

	public void setlChinesse(JLabel lChinesse) {
		this.lChinesse = lChinesse;
	}

	public JLabel getlHebrew() {
		return lHebrew;
	}

	public void setlHebrew(JLabel lHebrew) {
		this.lHebrew = lHebrew;
	}

	public JLabel getlPartnerOne() {
		return lPartnerOne;
	}

	public void setlPartnerOne(JLabel lPartnerOne) {
		this.lPartnerOne = lPartnerOne;
	}

	public JLabel getlPartnerTwo() {
		return lPartnerTwo;
	}

	public void setlPartnerTwo(JLabel lPartnerTwo) {
		this.lPartnerTwo = lPartnerTwo;
	}

	public JLabel getlHeart() {
		return lHeart;
	}

	public void setlHeart(JLabel lHeart) {
		this.lHeart = lHeart;
	}
	
	

}
