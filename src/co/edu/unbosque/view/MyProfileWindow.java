package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MyProfileWindow extends JFrame {

	private JLabel icon;
	private JPanel panelOpcion;
	private JPanel panelLike;
	private JButton back;
	private JButton close;
	private JLabel lblLike;
	private JLabel option;
	private JLabel lblHeart;
	private JLabel partner;
	private JLabel lblFotoPreview;
	private JTextField txtNombre, txtApellido, txtEdad, txtCorreo, txtAlias, txtLikes, txtIngresos;

	public MyProfileWindow() {
		// configuracion de la ventana -> aplica para todas en modo claro
		this.setTitle("BosTinder");
		this.setBounds(230, 5, 980, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.decode("#F9CFCE")); // -> falta agregarle color

		// --- Encabezado ---
		JLabel icon = new JLabel("");
		icon.setForeground(Color.decode("#F9CFCE"));
		icon.setBackground(Color.decode("#F9CFCE"));
		icon.setIcon(new ImageIcon(MainWindow.class.getResource("/co/edu/unbosque/view/iconStart.JPG")));
		icon.setBounds(0, 0, 980, 150);
		getContentPane().add(icon);
		
		ImageIcon image = new ImageIcon(getClass().getResource("partnerFive.JPG"));
		partner = new JLabel(image);
		partner.setBounds(20, 195, 300, 450);
		add(partner);

		// ----- Aqui para poner la informacion del usuario-----
		JPanel panelInformacion = new JPanel();
		panelInformacion.setLayout(null);
		panelInformacion.setBounds(330, 190, 330, 460);
		panelInformacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY),
				"PERFIL", TitledBorder.CENTER, TitledBorder.TOP, new Font("Cooper Black", Font.ITALIC, 15)));
		panelInformacion.setBackground(Color.WHITE);
		getContentPane().add(panelInformacion);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 30, 100, 20);
		panelInformacion.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(120, 30, 180, 20);
		txtNombre.setEditable(false);
		panelInformacion.add(txtNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(20, 60, 100, 20);
		panelInformacion.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setBounds(120, 60, 180, 20);
		txtApellido.setEditable(false);
		panelInformacion.add(txtApellido);

		JLabel lblAlias = new JLabel("Username:");
		lblAlias.setBounds(20, 90, 100, 20);
		panelInformacion.add(lblAlias);

		txtAlias = new JTextField();
		txtAlias.setBounds(120, 90, 180, 20);
		txtAlias.setEditable(false);
		panelInformacion.add(txtAlias);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(20, 120, 100, 20);
		panelInformacion.add(lblEdad);

		txtEdad = new JTextField();
		txtEdad.setBounds(120, 120, 180, 20);
		txtEdad.setEditable(false);
		panelInformacion.add(txtEdad);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(20, 150, 100, 20);
		panelInformacion.add(lblCorreo);

		txtCorreo = new JTextField();
		txtCorreo.setBounds(120, 150, 180, 20);
		txtCorreo.setEditable(false);
		panelInformacion.add(txtCorreo);

		JLabel lblLikes = new JLabel("Likes:");
		lblLikes.setBounds(20, 180, 100, 20);
		panelInformacion.add(lblLikes);

		txtLikes = new JTextField();
		txtLikes.setBounds(120, 180, 180, 20);
		txtLikes.setEditable(false);
		panelInformacion.add(txtLikes);

		JLabel lblIngresos = new JLabel("Ingresos (USD):");
		lblIngresos.setBounds(20, 210, 100, 20);
		panelInformacion.add(lblIngresos);

		txtIngresos = new JTextField();
		txtIngresos.setBounds(120, 210, 180, 20);
		txtIngresos.setEditable(false);
		panelInformacion.add(txtIngresos);

		JLabel lblFoto = new JLabel("Foto de perfil:");
		lblFoto.setBounds(20, 240, 100, 20);
		panelInformacion.add(lblFoto);

		lblFotoPreview = new JLabel();
		lblFotoPreview.setBounds(120, 240, 100, 100);
		lblFotoPreview.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panelInformacion.add(lblFotoPreview);


		// ----- panel para las opciones -----
		JPanel panelOpcion = new JPanel();
		panelOpcion.setLayout(null);
		panelOpcion.setBounds(695, 440, 250, 200);
		panelOpcion.setBackground(Color.WHITE);
		add(panelOpcion);

		option = new JLabel("OPCIONES");
		option.setBounds(80, 6, 100, 20);
		option.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		option.setBackground(Color.WHITE);
		panelOpcion.add(option);

		back = new JButton("VOLVER");
		back.setBounds(80, 60, 94, 40);
		back.setFont(new Font("Arial", Font.BOLD, 12));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelOpcion.add(back);

		back = new JButton("CERRAR SESIÓN");
		back.setBounds(64, 108, 130, 40);
		back.setFont(new Font("Arial", Font.BOLD, 12));
		back.setBackground(Color.decode("#F9CFCE"));
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		panelOpcion.add(back);

		// ------ panel para los likes ---
		JPanel panelLike = new JPanel();
		panelLike.setLayout(null);
		panelLike.setBounds(695, 200, 250, 200);
		panelLike.setBackground(Color.WHITE);
		add(panelLike);

		lblLike = new JLabel("LIKES A TU PERFIL");
		lblLike.setBounds(55, 6, 180, 20);
		lblLike.setFont(new Font("Cooper Black", Font.PLAIN, 15));
		lblLike.setBackground(Color.WHITE);
		panelLike.add(lblLike);

		ImageIcon imageHeart = new ImageIcon(getClass().getResource("heartThree.JPG"));
		lblHeart = new JLabel(imageHeart);
		lblHeart.setBounds(30, 55, 95, 95);
		panelLike.add(lblHeart);

	}

}
