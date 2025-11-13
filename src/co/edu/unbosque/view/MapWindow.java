package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Ventana que muestra un mapa interactivo con puntos que representan países donde hay usuarios registrados.
 * 
 * <p>Permite al usuario visualizar el mapa, hacer clic en los países para obtener información,
 * activar el modo oscuro, aplicar internacionalización y regresar a la ventana anterior.</p>
 * 
 * <p>La clase extiende {@code JFrame} y contiene componentes gráficos como paneles, etiquetas,
 * botones e imágenes, además de un sistema de eventos para interacción con el mapa.</p>
 * 
 * Autor: Maria Alejandra Carvajal Nepta
 */
public class MapWindow extends JFrame {
	

/**
     * Constructor por defecto.
     * 
     * @pre No se ha inicializado la ventana.
     * @post Se configuran los componentes gráficos y se definen los puntos de países en el mapa.
     */


	private static final long serialVersionUID = 1L;

	private BufferedImage mapaImg;

	private JPanel panelMapa;
	private JPanel panelOption;
	private JPanel panelLogo;

	private JButton btnBackMap;

	private JLabel icon;
	private JLabel lImage;
	private JLabel lTituloMapa;
	private JLabel lPaisSeleccionado;
	private JLabel lBosTinder;

	private JButton darkMode;
	private boolean isDarkMode = false;

	// puntos visuales del mapa (vista responsable de posicionarlos y dibujarlos)
	private Map<String, Point> puntosPaises;

	// Listener (callback) que el controlador implementará
	public interface MapaListener {
		void onPaisClick(String pais);

		void onPaisHover(String pais);
	}

	private MapaListener mapaListener;

	public MapWindow() {
		initializeComponents();
		definirPuntosPaises();
	}

	public void setMapaListener(MapaListener listener) {
		this.mapaListener = listener;
	}
	

     /**
     * Inicializa todos los componentes gráficos de la ventana.
     * 
     * @pre No hay componentes en la ventana.
     * @post Se agregan paneles, botones, etiquetas e imágenes al contenedor principal.
     */
	public void initializeComponents() {
		// CONFIGURACION DE LA VENTANA
		setTitle("Mapa de usuarios - BosTinder");
		setBounds(230, 5, 980, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.decode("#F9CFCE"));

		// ------IMAGEN SUPERIOR----
		panelLogo = new JPanel();
		panelLogo.setBounds(0, 0, 980, 150);
		panelLogo.setBackground(Color.decode("#FFFFFF"));
		panelLogo.setLayout(null);
		this.add(panelLogo);

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconBosTinder.png"));
		JLabel lIcon = new JLabel(imageLogo);
		lIcon.setBounds(250, 10, 120, 120);
		panelLogo.add(lIcon);
		// add(lIcon);

		lBosTinder = new JLabel("BosTinder");
		lBosTinder.setBounds(380, 35, 400, 72);
		lBosTinder.setForeground(Color.decode("#303080D"));
		lBosTinder.setFont(new Font("Georgia", Font.BOLD, 70));
		panelLogo.add(lBosTinder);
		// add(lBosTinder);

		// -----IMAGEN ADICIONAL-------

		ImageIcon imagePartnerFour = new ImageIcon(getClass().getResource("flower.png"));
		lImage = new JLabel(imagePartnerFour);
		lImage.setBounds(750, 247, 200, 300);
		add(lImage);

		lTituloMapa = new JLabel("-MAPA USUARIOS-");
		lTituloMapa.setBounds(755, 140, 200, 100);
		lTituloMapa.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		add(lTituloMapa);

		lPaisSeleccionado = new JLabel("");
		lPaisSeleccionado.setBounds(820, 210, 200, 30);
		lPaisSeleccionado.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		add(lPaisSeleccionado);

		panelOption = new JPanel();
		panelOption.setBounds(750, 592, 190, 70);
		panelOption.setLayout(null);
		panelOption.setBackground(Color.WHITE);
		add(panelOption);

		panelMapa = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (mapaImg != null) {
					g.drawImage(mapaImg, 0, 0, getWidth(), getHeight(), null);
					// dibujar puntos
					g.setColor(Color.RED);
					for (Point p : puntosPaises.values()) {
						g.fillOval(p.x - 5, p.y - 5, 10, 10);
					}
				}
			}
		};
		panelMapa.setBounds(5, 155, 730, 520);
		panelMapa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add(panelMapa);

		// listeners de la vista: solo notifican al mapaListener
		panelMapa.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
				String pais = getPaisEnPunto(e.getPoint());
				if (mapaListener != null) {
					mapaListener.onPaisHover(pais);
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// no usado
			}
		});

		panelMapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String pais = getPaisEnPunto(e.getPoint());
				if (mapaListener != null) {
					mapaListener.onPaisClick(pais);
				}
			}
		});

		btnBackMap = new JButton("Volver");
		btnBackMap.setBounds(40, 20, 120, 30);
		btnBackMap.setBackground(Color.decode("#F4716D"));
		btnBackMap.setForeground(Color.WHITE);
		btnBackMap.setFont(new Font("Arial", Font.BOLD, 14));
		btnBackMap.setFocusPainted(false);
		btnBackMap.setBorderPainted(false);
		panelOption.add(btnBackMap);

		ImageIcon changeMode = new ImageIcon(getClass().getResource("changeMode.png"));
		JLabel lChangeMode = new JLabel(changeMode);
		darkMode = new JButton(changeMode);
		darkMode.setBounds(815, 530, 66, 60);
		darkMode.setOpaque(false);
		darkMode.setOpaque(false);
		darkMode.setContentAreaFilled(false);
		darkMode.setFocusPainted(false);
		darkMode.setBorderPainted(false);
		darkMode.addActionListener(e -> cambiarAModoOscuroMpW());
		this.add(darkMode);

		try {
			mapaImg = ImageIO.read(new java.io.File("src/co/edu/unbosque/view/map.jpeg"));
			panelMapa.setPreferredSize(new Dimension(730, 520));
		} catch (Exception e) {
			System.out.println("Error al cargar el mapa: " + e.getMessage());
		}
	}
	

     /**
     * Define los puntos en el mapa que representan países.
     * 
     * @pre El mapa debe estar cargado correctamente.
     * @post Se asignan coordenadas a cada país en el mapa.
     */
	private void definirPuntosPaises() {
		puntosPaises = new HashMap<>();
		puntosPaises.put("Espana", new Point(338, 220));
		puntosPaises.put("Portugal", new Point(327, 220));
		puntosPaises.put("Israel", new Point(410, 235));
		puntosPaises.put("Rusia", new Point(529, 149));
		puntosPaises.put("Taiwan", new Point(590, 263));
		puntosPaises.put("Singapur", new Point(539, 311));
		puntosPaises.put("Brasil", new Point(240, 348));
		puntosPaises.put("Macao", new Point(576, 263));
		puntosPaises.put("Angola", new Point(374, 353));
		puntosPaises.put("Kazajistan", new Point(470, 195));
		puntosPaises.put("Mexico", new Point(142, 264));
		puntosPaises.put("Argentina", new Point(210, 406));
		puntosPaises.put("Colombia", new Point(200, 318));

	}


     /**
     * Devuelve el nombre del país si el punto está cerca (<10 px) de alguno de los puntos definidos.
     * 
     * @param p Punto donde se realizó el clic o movimiento del mouse.
     * @return Nombre del país si se encuentra cerca de un punto; {@code null} en caso contrario.
     */
	public String getPaisEnPunto(Point p) {
		for (Map.Entry<String, Point> entry : puntosPaises.entrySet()) {
			Point paisPoint = entry.getValue();
			double distancia = p.distance(paisPoint);
			if (distancia < 10) {
				return entry.getKey();
			}
		}
		return null;
	}


     /**
     * Cambia el tema visual de la ventana entre modo claro y modo oscuro.
     * 
     * @pre La ventana debe estar inicializada.
     * @post Se actualiza el color de fondo y estilo de los componentes según el modo.
     */
	public void cambiarAModoOscuroMpW() {
		if (isDarkMode) {
			// Mantiene el modo claro
			this.getContentPane().setBackground(Color.decode("#F9CFCE"));
			panelLogo.setBackground(Color.decode("#FFFFFF"));
			panelOption.setBackground(Color.decode("#FFFFFF"));
			panelMapa.setBackground(Color.decode("#FFFFFF"));
			lBosTinder.setForeground(Color.decode("#303080D"));
			lTituloMapa.setForeground(Color.decode("#000000"));
			lPaisSeleccionado.setForeground(Color.decode("#000000"));

			// Botón del panelOption
			btnBackMap.setForeground(Color.decode("#FFFFFF"));
			btnBackMap.setBackground(Color.decode("#F4716D"));

			// Botón darkMode
			darkMode.setBackground(Color.decode("#EB5F5B"));
			darkMode.setForeground(Color.decode("#F9CFCE"));
			darkMode.setText("MODO OSCURO");
			isDarkMode = false;

		} else {
			// Cambia a modo oscuro
			this.getContentPane().setBackground(Color.decode("#11021E"));
			panelLogo.setBackground(Color.decode("#1E1724"));
			panelOption.setBackground(Color.decode("#1E1724"));
			panelMapa.setBackground(Color.decode("#1E1724"));
			lBosTinder.setForeground(Color.decode("#FF2B91"));
			lTituloMapa.setForeground(Color.decode("#FF7171"));
			lPaisSeleccionado.setForeground(Color.decode("#DCC8EF"));

			// Botón del panelOption
			btnBackMap.setForeground(Color.decode("#DCC8EF"));
			btnBackMap.setBackground(Color.decode("#52247C"));

			// Botón darkMode
			darkMode.setBackground(Color.decode("#52247C"));
			darkMode.setForeground(Color.decode("#DCC8EF"));
			darkMode.setText("MODO CLARO");
			isDarkMode = true;
		}

	}
	

     /**
     * Aplica los textos traducidos a los componentes de la ventana según las propiedades dadas.
     * 
     * @param prop Propiedades que contienen los textos traducidos por idioma.
     * @pre Las propiedades deben estar correctamente cargadas.
     * @post Se actualizan los textos de la ventana, etiquetas y botones.
     */
	public void aplicarInternacionalizacion(Properties prop) {
		// Ventana
		setTitle(prop.getProperty("bostinder.view.mapwindow.title"));

		// Labels
		lBosTinder.setText(prop.getProperty("bostinder.view.mapwindow.label.bostinder"));
		lTituloMapa.setText(prop.getProperty("bostinder.view.mapwindow.label.titulomapa"));

		// Botones
		btnBackMap.setText(prop.getProperty("bostinder.view.mapwindow.button.volver"));
		darkMode.setText(prop.getProperty("bostinder.view.mapwindow.button.modooscuro"));
	}
	

	 /**
	     * Establece el nombre del país seleccionado en la etiqueta correspondiente.
	     * 
	     * @param pais Nombre del país seleccionado.
	     * @pre El país debe estar definido en el mapa.
	     * @post Se muestra el nombre del país en la interfaz.
	     */


	public void setPaisSeleccionado(String pais) {
		lPaisSeleccionado.setText(pais != null ? pais : "");
	}
	

     /**
     * Obtiene el panel que contiene el mapa.
     * 
     * @return panelMapa Panel del mapa.
     */
	public JPanel getPanelMapa() {
		return panelMapa;
	}
	

     /**
     * Obtiene el botón para regresar a la ventana anterior.
     * 
     * @return btnBackMap Botón de volver.
     */
	public JButton getBtnBackMap() {
		return btnBackMap;
	}
}
