package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.unbosque.controller.Controller;

public class PrincipalWindow extends JFrame {

	private JLabel phrase;
	private JButton start;
	private JLabel icon;

	// idiomas
	private JLabel changeLanguage;

	private JButton bSpanish;
	private JButton bPortuguese;
	private JButton bRussian;
	private JButton bChinnesse;
	private JButton bHebrew;

	private JLabel lSpanish;
	private JLabel lPortuguese;
	private JLabel lRussian;
	private JLabel lChinnesse;
	private JLabel lHebrew;

	// recursos adicionales
	private JLabel lPartnerOne;
	private JLabel lPartnerTwo;
	private JLabel lHeart;

	public PrincipalWindow() {
		initializeComponents();
		setVisible(true);
	}

	public void initializeComponents() {
		// configuracion de la ventana -> aplica para todas en modo claro
		this.setTitle("BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#FFFFFF")); // -> falta agregarle color

		// logo y título -> lo voy a cambiar después :)
		ImageIcon imageLogo = new ImageIcon(getClass().getResource("icon.JPG"));
		JLabel icon = new JLabel(imageLogo);
		icon.setBounds(0, 10, 960, 200);
		this.add(icon);

		// label frase
		phrase = new JLabel("¡Tu amor ideal te está esperando!");
		phrase.setBounds(360, 170, 480, 30);
		phrase.setForeground(Color.decode("#03080D"));
		phrase.setFont(new Font("Arial", Font.BOLD, 18));
		this.add(phrase);

		// para idiomas
		changeLanguage = new JLabel("-> Cambiar Idioma");
		changeLanguage.setBounds(415, 440, 250, 150);
		changeLanguage.setForeground(Color.decode("#03080D"));
		changeLanguage.setFont(new Font("Arial", Font.BOLD, 15));
		this.add(changeLanguage);

		ImageIcon imagen1 = new ImageIcon(getClass().getResource("spanish.JPG"));
		JLabel labelImagen1 = new JLabel(imagen1);
		bSpanish = new JButton(imagen1);
		bSpanish.setBackground(Color.RED);
		bSpanish.setBounds(380, 540, 35, 35);
		bSpanish.setFocusPainted(false);
		bSpanish.setBorderPainted(true);
		this.add(bSpanish);

		ImageIcon imagen2 = new ImageIcon(getClass().getResource("chinnesse.JPG"));
		JLabel labelImagen2 = new JLabel(imagen2);
		bChinnesse = new JButton(imagen2);
		bChinnesse.setBackground(Color.RED);
		bChinnesse.setBounds(420, 540, 35, 35);
		bChinnesse.setFocusPainted(false);
		bChinnesse.setBorderPainted(true);
		this.add(bChinnesse);

		ImageIcon imagen3 = new ImageIcon(getClass().getResource("hebrew.JPG"));
		JLabel labelImagen3 = new JLabel(imagen3);
		bHebrew = new JButton(imagen3);
		bHebrew.setBounds(460, 540, 35, 35);
		bHebrew.setFocusPainted(false);
		bHebrew.setBorderPainted(true);
		this.add(bHebrew);

		ImageIcon imagen4 = new ImageIcon(getClass().getResource("russian.JPG"));
		JLabel labelImagen4 = new JLabel(imagen4);
		bRussian = new JButton(imagen4);
		bRussian.setBounds(500, 540, 35, 35);
		bRussian.setFocusPainted(false);
		bRussian.setBorderPainted(true);
		this.add(bRussian);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("portuguesse.JPG"));
		JLabel labelImagen5 = new JLabel(imagen5);
		bPortuguese = new JButton(imagen5);
		bPortuguese.setBounds(540, 540, 35, 35);
		bPortuguese.setFocusPainted(false);
		bPortuguese.setBorderPainted(true);
		this.add(bPortuguese);

		// boton iniciar
		start = new JButton("INICIAR");
		start.setBounds(390, 410, 180, 50);
		start.setFont(new Font("Arial", Font.BOLD, 20));
		start.setForeground(Color.decode("#F9CFCE"));// color letra
		start.setBackground(Color.decode("#EB5F5B"));
		start.setFocusPainted(false);
		start.setBorderPainted(false);
		this.add(start);

		// imagenes recursos adicionales
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
	
	public void aplicarInternacionalizacion(Properties prop) {
	    // Ventana
	    setTitle(prop.getProperty("bostinder.view.principalwindow.title"));

	    // Frase principal
	    phrase.setText(prop.getProperty("bostinder.view.principalwindow.label.phrase"));

	    // Botón principal
	    start.setText(prop.getProperty("bostinder.view.principalwindow.button.start"));

	    // Cambio de idioma
	    changeLanguage.setText(prop.getProperty("bostinder.view.principalwindow.label.changeLanguage"));

	    // Etiquetas de idiomas (debajo de los botones con banderas)
	    if (lSpanish != null) lSpanish.setText(prop.getProperty("bostinder.view.principalwindow.label.spanish"));
	    if (lPortuguese != null) lPortuguese.setText(prop.getProperty("bostinder.view.principalwindow.label.portuguese"));
	    if (lRussian != null) lRussian.setText(prop.getProperty("bostinder.view.principalwindow.label.russian"));
	    if (lChinnesse != null) lChinnesse.setText(prop.getProperty("bostinder.view.principalwindow.label.chinnesse"));
	    if (lHebrew != null) lHebrew.setText(prop.getProperty("bostinder.view.principalwindow.label.hebrew"));
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

	public JButton getbChinnesse() {
		return bChinnesse;
	}

	public void setbChinnesse(JButton bChinnesse) {
		this.bChinnesse = bChinnesse;
	}

	public JLabel getlChinnesse() {
		return lChinnesse;
	}

	public void setlChinnesse(JLabel lChinnesse) {
		this.lChinnesse = lChinnesse;
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
