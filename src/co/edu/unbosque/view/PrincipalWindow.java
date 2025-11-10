package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrincipalWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5369661132715804611L;
	private JLabel phrase;
	private JLabel icon;
	private JLabel changeLanguage;
	private JLabel lSpanish;
	private JLabel lPortuguese;
	private JLabel lRussian;
	private JLabel lChinnesse;
	private JLabel lHebrew;
	private JLabel lPartnerOne;
	private JLabel lPartnerTwo;
	private JLabel lBosTinder;

	private JButton start;
	private JButton bSpanish;
	private JButton bPortuguese;
	private JButton bRussian;
	private JButton bChinnesse;
	private JButton bHebrew;
	private JButton darkMode;
	private boolean isDarkMode = false;

	public PrincipalWindow() {
		initializeComponents();
		setVisible(true);
	}

	public void initializeComponents() {
		// CONFIGURACIN DE LA VENTANA
		this.setTitle("Ventana Inicial - BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#FFFFFF"));

		// ----- LOGO Y TITULO -------
		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconBosTinder.png"));
		JLabel icon = new JLabel(imageLogo);
		icon.setBounds(425, 60, 120, 120);
		this.add(icon);

		lBosTinder = new JLabel("BosTinder");
		lBosTinder.setBounds(300, 190, 400, 72);
		lBosTinder.setForeground(Color.decode("#303080D"));
		lBosTinder.setFont(new Font("Georgia", Font.BOLD, 70));
		this.add(lBosTinder);

		phrase = new JLabel("¡Tu amor ideal te está esperando!");
		phrase.setBounds(335, 258, 480, 30);
		phrase.setForeground(Color.decode("#03080D"));
		phrase.setFont(new Font("Georgia", Font.BOLD, 18));
		this.add(phrase);

		// ----- IDIOMAS -----
		changeLanguage = new JLabel("Cambiar Idioma");
		changeLanguage.setBounds(415, 440, 250, 150);
		changeLanguage.setForeground(Color.decode("#03080D"));
		changeLanguage.setFont(new Font("Georgia", Font.BOLD, 15));
		this.add(changeLanguage);

		ImageIcon imagen1 = new ImageIcon(getClass().getResource("spanish.JPG"));
		JLabel labelImagen1 = new JLabel(imagen1);
		bSpanish = new JButton(imagen1);
		bSpanish.setBackground(Color.RED);
		bSpanish.setBounds(380, 540, 35, 35);
		bSpanish.setFocusPainted(false);
		bSpanish.setBorderPainted(false);
		this.add(bSpanish);

		ImageIcon imagen2 = new ImageIcon(getClass().getResource("chinnesse.JPG"));
		JLabel labelImagen2 = new JLabel(imagen2);
		bChinnesse = new JButton(imagen2);
		bChinnesse.setBackground(Color.RED);
		bChinnesse.setBounds(420, 540, 35, 35);
		bChinnesse.setFocusPainted(false);
		bChinnesse.setBorderPainted(false);
		this.add(bChinnesse);

		ImageIcon imagen3 = new ImageIcon(getClass().getResource("hebrew.JPG"));
		JLabel labelImagen3 = new JLabel(imagen3);
		bHebrew = new JButton(imagen3);
		bHebrew.setBounds(460, 540, 35, 35);
		bHebrew.setFocusPainted(false);
		bHebrew.setBorderPainted(false);
		this.add(bHebrew);

		ImageIcon imagen4 = new ImageIcon(getClass().getResource("russian.JPG"));
		JLabel labelImagen4 = new JLabel(imagen4);
		bRussian = new JButton(imagen4);
		bRussian.setBounds(500, 540, 35, 35);
		bRussian.setFocusPainted(false);
		bRussian.setBorderPainted(false);
		this.add(bRussian);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("portuguesse.JPG"));
		JLabel labelImagen5 = new JLabel(imagen5);
		bPortuguese = new JButton(imagen5);
		bPortuguese.setBounds(540, 540, 35, 35);
		bPortuguese.setFocusPainted(false);
		bPortuguese.setBorderPainted(false);
		this.add(bPortuguese);

		// ----- BOTONES ------
		start = new JButton("INICIAR");
		start.setBounds(390, 340, 180, 50);
		start.setFont(new Font("Arial", Font.BOLD, 20));
		start.setForeground(Color.decode("#F9CFCE"));// color letra
		start.setBackground(Color.decode("#EB5F5B"));
		start.setFocusPainted(false);
		start.setBorderPainted(false);
		this.add(start);

		darkMode = new JButton("MODO OSCURO");
		darkMode.setBounds(390, 410, 180, 50);
		darkMode.setFont(new Font("Arial", Font.BOLD, 16));
		darkMode.setForeground(Color.decode("#F9CFCE"));// color letra
		darkMode.setBackground(Color.decode("#EB5F5B"));
		darkMode.setFocusPainted(false);
		darkMode.setBorderPainted(false);
		darkMode.addActionListener(e -> cambiarAModoOscuro());
		this.add(darkMode);

		// ------ IMAGENES ------
	

		ImageIcon imagePartnerOne = new ImageIcon(getClass().getResource("partnerOne.png"));
		JLabel lPartnerOne = new JLabel(imagePartnerOne);
		lPartnerOne.setBounds(50, 300, 300, 300);
		this.add(lPartnerOne);

		ImageIcon imagePartnerTwo = new ImageIcon(getClass().getResource("partnerTwo.png"));
		JLabel lPartnerTwo = new JLabel(imagePartnerTwo);
		lPartnerTwo.setBounds(600, 300, 300, 300);
		this.add(lPartnerTwo);

	}

	// ----METODO PARA CAMBIAR EL TEMA DEL APLICATIVO------
	public void cambiarAModoOscuro() {
		if (isDarkMode) {
			// Mantiene el modo claro
			this.getContentPane().setBackground(Color.decode("#FFFFFF"));
			lBosTinder.setForeground(Color.decode("#303080D"));
			phrase.setForeground(Color.decode("#03080D"));
			changeLanguage.setForeground(Color.decode("#03080D"));
			start.setBackground(Color.decode("#EB5F5B"));
			start.setForeground(Color.decode("#F9CFCE"));
			darkMode.setBackground(Color.decode("#EB5F5B"));
			darkMode.setForeground(Color.decode("#F9CFCE"));
			darkMode.setText("MODO OSCURO");
			isDarkMode = false;
		} else {
			// Cambia a modo oscuro
			this.getContentPane().setBackground(Color.decode("#161615"));
			lBosTinder.setForeground(Color.decode("#F9CFCE"));
			phrase.setForeground(Color.decode("#E8457E"));
			changeLanguage.setForeground(Color.decode("#FCE8EF"));
			start.setBackground(Color.decode("#BA1750"));
			start.setForeground(Color.decode("#FFFFFF"));
			darkMode.setBackground(Color.decode("#BA1750"));
			darkMode.setForeground(Color.decode("#FFFFFF"));
			darkMode.setText("MODO CLARO");
			isDarkMode = true;
		}
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
		if (lSpanish != null)
			lSpanish.setText(prop.getProperty("bostinder.view.principalwindow.label.spanish"));
		if (lPortuguese != null)
			lPortuguese.setText(prop.getProperty("bostinder.view.principalwindow.label.portuguese"));
		if (lRussian != null)
			lRussian.setText(prop.getProperty("bostinder.view.principalwindow.label.russian"));
		if (lChinnesse != null)
			lChinnesse.setText(prop.getProperty("bostinder.view.principalwindow.label.chinnesse"));
		if (lHebrew != null)
			lHebrew.setText(prop.getProperty("bostinder.view.principalwindow.label.hebrew"));
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

}
