package co.edu.unbosque.view;

import java.awt.*;
import java.util.List;
import java.util.Properties;

import javax.swing.*;
import co.edu.unbosque.model.User;

public class MapUserWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel lTitulo;

	private JPanel panelUsuarios;

	private JButton btnVolver;

	public MapUserWindow() {
		// CONFIGURACION DE LA PANTALLA
		setTitle("Usuarios por país - BosTinder");
		setBounds(300, 100, 600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		getContentPane().setBackground(Color.decode("#F9CFCE"));

		lTitulo = new JLabel("Usuarios registrados:");
		lTitulo.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		lTitulo.setBounds(30, 20, 400, 30);
		add(lTitulo);

		panelUsuarios = new JPanel();
		panelUsuarios.setLayout(new BoxLayout(panelUsuarios, BoxLayout.Y_AXIS));
		panelUsuarios.setBackground(Color.decode("#F9CFCE"));

		JScrollPane scroll = new JScrollPane(panelUsuarios);
		scroll.setBounds(30, 70, 520, 200);
		scroll.getViewport().setBackground(Color.decode("#F9CFCE"));
		add(scroll);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(30, 300, 180, 35);
		btnVolver.setBackground(Color.decode("#F4716D"));
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setFont(new Font("Arial", Font.BOLD, 14));
		btnVolver.setFocusPainted(false);
		btnVolver.setBorderPainted(false);
		add(btnVolver);
	}

	/**
	 * Muestra los usuarios con sus imágenes y nombres.
	 */
	public void mostrarUsuariosConImagen(List<User> usuarios) {
		panelUsuarios.removeAll();

		if (usuarios == null || usuarios.isEmpty()) {
			JLabel noUsers = new JLabel("No hay usuarios registrados en este país.");
			noUsers.setFont(new Font("Arial", Font.PLAIN, 14));
			panelUsuarios.add(noUsers);
		} else {
			for (User user : usuarios) {
				JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT));
				item.setBackground(Color.decode("#F9CFCE"));

				ImageIcon icon = new ImageIcon(user.getProfilePictureRoute());
				Image scaled = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
				JLabel imgLabel = new JLabel(new ImageIcon(scaled));

				JLabel nameLabel = new JLabel(" " + user.getAlias());
				nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

				item.add(imgLabel);
				item.add(nameLabel);
				panelUsuarios.add(item);
			}
		}

		panelUsuarios.revalidate();
		panelUsuarios.repaint();
	}
	
	public void aplicarInternacionalizacion(Properties prop) {
	    setTitle(prop.getProperty("bostinder.view.mapuserwindow.title"));

	    lTitulo.setText(prop.getProperty("bostinder.view.mapuserwindow.label.titulo"));

	    btnVolver.setText(prop.getProperty("bostinder.view.mapuserwindow.button.volver"));
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}