package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Clase que representa la ventana principal de la aplicación BosTinder.
 * 
 * <p>
 * Esta ventana es la pantalla inicial de la aplicación, donde el usuario puede
 * seleccionar el idioma, iniciar la aplicación o cambiar al modo oscuro.
 * Incluye elementos gráficos como logos, títulos, frases motivadoras, botones
 * para idiomas y opciones de navegación.
 * </p>
 * 
 * <p>
 * Incluye elementos gráficos como botones, etiquetas e imágenes, y permite
 * aplicar configuraciones de internacionalización y tema visual.
 * </p>
 * 
 * Autor: Maria Alejandra Carvajal Nepta
 */
public class PrincipalWindow extends JFrame {

	/**
	 * Identificador de versión para la serialización.
	 */
	private static final long serialVersionUID = -5369661132715804611L;
	// Componentes gráficos.
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
	private JButton bEnglish;
	private JButton darkMode;
	private boolean isDarkMode = false;

	/**
	 * Constructor por defecto.
	 * 
	 * @pre No se ha inicializado la ventana.
	 * @post Se inicializan los componentes y se muestra la ventana.
	 */
	public PrincipalWindow() {
		initializeComponents();
		setVisible(true);
	}

	/**
	 * Inicializa y configura todos los componentes gráficos de la ventana.
	 * 
	 * @pre No hay componentes gráficos en la ventana.
	 * @post La ventana contiene todos los elementos visuales necesarios, incluyendo
	 *       logos, botones, etiquetas e imágenes.
	 */
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
		phrase.setFont(new Font("Noto Sans", Font.BOLD, 18));
		this.add(phrase);

		// ----- IDIOMAS -----
		changeLanguage = new JLabel("Cambiar Idioma");
		changeLanguage.setBounds(415, 440, 250, 150);
		changeLanguage.setForeground(Color.decode("#03080D"));
		changeLanguage.setFont(new Font("Noto Sans", Font.BOLD, 15));
		this.add(changeLanguage);

		ImageIcon imagen1 = new ImageIcon(getClass().getResource("spanish.JPG"));
		JLabel labelImagen1 = new JLabel(imagen1);
		bSpanish = new JButton(imagen1);
		bSpanish.setBackground(Color.RED);
		bSpanish.setBounds(360, 540, 35, 35);
		bSpanish.setFocusPainted(false);
		bSpanish.setBorderPainted(false);
		this.add(bSpanish);

		ImageIcon imagen2 = new ImageIcon(getClass().getResource("chinnesse.JPG"));
		JLabel labelImagen2 = new JLabel(imagen2);
		bChinnesse = new JButton(imagen2);
		bChinnesse.setBackground(Color.RED);
		bChinnesse.setBounds(400, 540, 35, 35);
		bChinnesse.setFocusPainted(false);
		bChinnesse.setBorderPainted(false);
		this.add(bChinnesse);

		ImageIcon imagen3 = new ImageIcon(getClass().getResource("hebrew.JPG"));
		JLabel labelImagen3 = new JLabel(imagen3);
		bHebrew = new JButton(imagen3);
		bHebrew.setBounds(440, 540, 35, 35);
		bHebrew.setFocusPainted(false);
		bHebrew.setBorderPainted(false);
		this.add(bHebrew);

		ImageIcon imagen4 = new ImageIcon(getClass().getResource("russian.JPG"));
		JLabel labelImagen4 = new JLabel(imagen4);
		bRussian = new JButton(imagen4);
		bRussian.setBounds(480, 540, 35, 35);
		bRussian.setFocusPainted(false);
		bRussian.setBorderPainted(false);
		this.add(bRussian);

		ImageIcon imagen5 = new ImageIcon(getClass().getResource("portuguesse.JPG"));
		JLabel labelImagen5 = new JLabel(imagen5);
		bPortuguese = new JButton(imagen5);
		bPortuguese.setBounds(520, 540, 35, 35);
		bPortuguese.setFocusPainted(false);
		bPortuguese.setBorderPainted(false);
		this.add(bPortuguese);

		ImageIcon imagenEnglish = new ImageIcon(getClass().getResource("english.JPG"));
		JLabel labelImagen6 = new JLabel(imagenEnglish);
		bEnglish = new JButton(imagenEnglish);
		bEnglish.setBounds(560, 540, 35, 35);
		bEnglish.setFocusPainted(false);
		bEnglish.setBorderPainted(false);
		bEnglish.setBackground(Color.RED);
		this.add(bEnglish);

		// ----- BOTONES ------
		start = new JButton("INICIAR");
		start.setBounds(390, 340, 180, 50);
		start.setFont(new Font("Noto Sans", Font.BOLD, 20));
		start.setForeground(Color.decode("#F9CFCE"));// color letra
		start.setBackground(Color.decode("#EB5F5B"));
		start.setFocusPainted(false);
		start.setBorderPainted(false);
		this.add(start);

		darkMode = new JButton("MODO OSCURO");
		darkMode.setBounds(390, 410, 180, 50);
		darkMode.setFont(new Font("Noto Sans", Font.BOLD, 16));
		darkMode.setForeground(Color.decode("#F9CFCE"));// color letra
		darkMode.setBackground(Color.decode("#EB5F5B"));
		darkMode.setFocusPainted(false);
		darkMode.setBorderPainted(false);
		darkMode.addActionListener(e -> cambiarAModoOscuroPW());
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

	/**
	 * Cambia el tema visual de la ventana entre modo claro y modo oscuro.
	 * 
	 * @pre La ventana debe estar inicializada.
	 * @post Se actualiza el color de fondo y estilo de los componentes según el
	 *       modo.
	 */
	public void cambiarAModoOscuroPW() {

		if (isDarkMode == true) {
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
			// Cambia a MODO OSCURO
			this.getContentPane().setBackground(Color.decode("#11021E"));
			lBosTinder.setForeground(Color.decode("#FF2B91"));
			phrase.setForeground(Color.decode("#FF7171"));
			changeLanguage.setForeground(Color.decode("#FF7171"));
			start.setBackground(Color.decode("#52247C"));
			start.setForeground(Color.decode("#DCC8EF"));
			darkMode.setBackground(Color.decode("#52247C"));
			darkMode.setForeground(Color.decode("#DCC8EF"));
			darkMode.setText("MODO CLARO");
			isDarkMode = true;
		}
	}

	/**
	 * Aplica los textos traducidos a los componentes de la ventana según las
	 * propiedades dadas.
	 * 
	 * @param prop Propiedades que contienen los textos traducidos por el idioma.
	 * @pre Las propiedades deben estar correctamente cargadas.
	 * @post Los textos de los botones y etiquetas se actualizan con los valores
	 *       traducidos.
	 */
	public void aplicarInternacionalizacion(Properties prop) {
		setTitle(prop.getProperty("bostinder.view.principalwindow.title"));
		phrase.setText(prop.getProperty("bostinder.view.principalwindow.label.phrase"));
		start.setText(prop.getProperty("bostinder.view.principalwindow.button.start"));
		darkMode.setText(prop.getProperty("bostinder.view.principalwindow.button.darkMode"));
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

	/**
	 * @return Etiqueta del icono principal.
	 */
	public JLabel getIcon() {
		return icon;
	}

	/**
	 * @param icon Etiqueta del icono principal.
	 */
	public void setIcon(JLabel icon) {
		this.icon = icon;
	}

	/**
	 * @return Etiqueta de la frase motivadora.
	 */
	public JLabel getPhrase() {
		return phrase;
	}

	/**
	 * @param phrase Etiqueta de la frase motivadora.
	 */
	public void setPhrase(JLabel phrase) {
		this.phrase = phrase;
	}

	/**
	 * @return Botón para iniciar la aplicación.
	 */
	public JButton getStart() {
		return start;
	}

	/**
	 * @param start Botón para iniciar la aplicación.
	 */

	public void setStart(JButton start) {
		this.start = start;
	}

	/**
	 * @return Etiqueta para cambiar idioma.
	 */
	public JLabel getChangeLanguage() {
		return changeLanguage;
	}

	/**
	 * @param changeLanguage Etiqueta para cambiar idioma.
	 */
	public void setChangeLanguage(JLabel changeLanguage) {
		this.changeLanguage = changeLanguage;
	}

	/**
	 * @return Botón para seleccionar español.
	 */
	public JButton getbSpanish() {
		return bSpanish;
	}

	/**
	 * @param bSpanish Botón para seleccionar español.
	 */
	public void setbSpanish(JButton bSpanish) {
		this.bSpanish = bSpanish;
	}

	/**
	 * @return Botón para seleccionar portugués.
	 */
	public JButton getbPortuguese() {
		return bPortuguese;
	}

	/**
	 * @param bPortuguese Botón para seleccionar portugués.
	 */
	public void setbPortuguese(JButton bPortuguese) {
		this.bPortuguese = bPortuguese;
	}

	/**
	 * @return Botón para seleccionar ruso.
	 */
	public JButton getbRussian() {
		return bRussian;
	}

	/**
	 * @param bRussian Botón para seleccionar ruso.
	 */
	public void setbRussian(JButton bRussian) {
		this.bRussian = bRussian;
	}

	/**
	 * @return Botón para seleccionar chino.
	 */
	public JButton getbChinnesse() {
		return bChinnesse;
	}

	/**
	 * @param bChinnesse Botón para seleccionar chino.
	 */
	public void setbChinnesse(JButton bChinnesse) {
		this.bChinnesse = bChinnesse;
	}

	/**
	 * @return Etiqueta para chino.
	 */
	public JLabel getlChinnesse() {
		return lChinnesse;
	}
	/**
	 * @param lChinnesse Etiqueta para chino.
	 */
	public void setlChinnesse(JLabel lChinnesse) {
		this.lChinnesse = lChinnesse;
	}
	/**
	 * @return Botón para seleccionar hebreo.
	 */
	public JButton getbHebrew() {
		return bHebrew;
	}
	/**
	 * @param bHebrew Botón para seleccionar hebreo.
	 */
	public void setbHebrew(JButton bHebrew) {
		this.bHebrew = bHebrew;
	}
	/**
	 * @return Etiqueta para español.
	 */
	public JLabel getlSpanish() {
		return lSpanish;
	}
	/**
	 * @param lSpanish Etiqueta para español.
	 */
	public void setlSpanish(JLabel lSpanish) {
		this.lSpanish = lSpanish;
	}
	/**
	 * @return Etiqueta para portugués.
	 */
	public JLabel getlPortuguese() {
		return lPortuguese;
	}
	/**
	 * @param lPortuguese Etiqueta para portugués.
	 */
	public void setlPortuguese(JLabel lPortuguese) {
		this.lPortuguese = lPortuguese;
	}
	/**
	 * @return Etiqueta para ruso.
	 */
	public JLabel getlRussian() {
		return lRussian;
	}
	/**
	 * @param lRussian Etiqueta para ruso.
	 */
	public void setlRussian(JLabel lRussian) {
		this.lRussian = lRussian;
	}
	/**
	 * @return Etiqueta para hebreo.
	 */
	public JLabel getlHebrew() {
		return lHebrew;
	}
	/**
	 * @param lHebrew Etiqueta para hebreo.
	 */
	public void setlHebrew(JLabel lHebrew) {
		this.lHebrew = lHebrew;
	}
	/**
	 * @return Etiqueta de la primera imagen de pareja.
	 */
	public JLabel getlPartnerOne() {
		return lPartnerOne;
	}
	/**
	 * @param lPartnerOne Etiqueta de la primera imagen de pareja.
	 */
	public void setlPartnerOne(JLabel lPartnerOne) {
		this.lPartnerOne = lPartnerOne;
	}
	/**
	 * @return Etiqueta de la segunda imagen de pareja.
	 */
	public JLabel getlPartnerTwo() {
		return lPartnerTwo;
	}
	/**
	 * @param lPartnerTwo Etiqueta de la segunda imagen de pareja.
	 */
	public void setlPartnerTwo(JLabel lPartnerTwo) {
		this.lPartnerTwo = lPartnerTwo;
	}
	/**
	 * @return Botón para cambiar el aspecto.
	 */
	public JButton getDarkMode() {
		return darkMode;
	}
	/**
	 * @param darkMode Botón para cambiar el aspecto.
	 */
	public void setDarkMode(JButton darkMode) {
		this.darkMode = darkMode;
	}
	/**
	 * @return Estado actual del modo oscuro.
	 */
	public boolean isDarkMode() {
		return isDarkMode;
	}
	/**
	 * @param isDarkMode Estado del modo oscuro a establecer.
	 */
	public void setDarkMode(boolean isDarkMode) {
		this.isDarkMode = isDarkMode;
	}
	/**
	 * @return Botón para seleccionar inglés.
	 */
	public JButton getbEnglish() {
		return bEnglish;
	}
	/**
	 * @param bEnglish Botón para seleccionar inglés.
	 */
	public void setbEnglish(JButton bEnglish) {
		this.bEnglish = bEnglish;
	}

}