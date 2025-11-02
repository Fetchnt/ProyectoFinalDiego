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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MapWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private BufferedImage mapaImg;
	private JPanel panelMapa;
	private JButton btnBackMap;
	private JLabel icon, lImage, lText, lPaisSeleccionado;
	private JPanel panelOption;

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

	public void initializeComponents() {
		setTitle("BosTinder - Mapa de usuarios");
		setBounds(230, 5, 980, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		getContentPane().setBackground(Color.decode("#F9CFCE"));

		ImageIcon imageLogo = new ImageIcon(getClass().getResource("iconStart.JPG"));
		icon = new JLabel(imageLogo);
		icon.setBounds(0, 0, 980, 150);
		add(icon);

		ImageIcon imagePartnerFour = new ImageIcon(getClass().getResource("partnerFour.JPG"));
		lImage = new JLabel(imagePartnerFour);
		lImage.setBounds(750, 247, 200, 300);
		add(lImage);

		lText = new JLabel("-MAPA USUARIOS-");
		lText.setBounds(755, 190, 200, 100);
		lText.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		add(lText);

		lPaisSeleccionado = new JLabel("");
		lPaisSeleccionado.setBounds(820, 150, 200, 30);
		lPaisSeleccionado.setFont(new Font("Arial", Font.BOLD, 16));
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

		try {
			mapaImg = ImageIO.read(new java.io.File("src/co/edu/unbosque/view/mapWorld.jpg"));
			panelMapa.setPreferredSize(new Dimension(730, 520));
		} catch (Exception e) {
			System.out.println("Error al cargar el mapa: " + e.getMessage());
		}
	}

	private void definirPuntosPaises() {
		puntosPaises = new HashMap<>();
		puntosPaises.put("España", new Point(338, 220));
		puntosPaises.put("Portugal", new Point(327, 220));
		puntosPaises.put("Israel", new Point(425, 260));
		puntosPaises.put("Rusia", new Point(529, 149));
		puntosPaises.put("Taiwan", new Point(576, 263));
		puntosPaises.put("Singapur", new Point(539, 311));
		puntosPaises.put("Brasil", new Point(240, 348));
		puntosPaises.put("Macao", new Point(568, 249));
		puntosPaises.put("Angola", new Point(374, 353));
		puntosPaises.put("Kazajistan", new Point(470, 195));
		puntosPaises.put("Mexico", new Point(142, 264));
		puntosPaises.put("Argentina", new Point(215, 406));
		puntosPaises.put("Colombia", new Point(200, 318));
	}

	/**
	 * Devuelve el nombre del país si el punto está cerca (<10 px) de alguno de los
	 * puntos definidos; si no, devuelve null.
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

	// 🔹 Nuevo método para actualizar el label
	public void setPaisSeleccionado(String pais) {
		lPaisSeleccionado.setText(pais != null ? pais : "");
	}

	public JPanel getPanelMapa() {
		return panelMapa;
	}

	public JButton getBtnBackMap() {
		return btnBackMap;
	}
}
