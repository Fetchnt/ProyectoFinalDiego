package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import co.edu.unbosque.model.Men;
import co.edu.unbosque.model.MenDTO;

/**
 * Clase de acceso a datos para la gestión de usuarios de tipo hombre.
 * <b>pre:</b> Debe existir un sistema de archivos accesible para persistencia.
 * <br>
 * <b>post:</b> Gestiona las operaciones CRUD y generación de informes para
 * usuarios masculinos.
 * 
 */
public class MenDAO implements DAO<MenDTO> {

	/** Lista de objetos DTO que representan a los usuarios masculinos. */
	public ArrayList<MenDTO> listaMenDTO;

	/** Propiedades utilizadas para la internacionalización o configuración. */
	private Properties props;

	/** Nombre del archivo de texto para almacenamiento en CSV. */
	private final String FILE_NAME = "Men.csv";

	/** Nombre del archivo binario para almacenamiento serializado. */
	private final String SERIAL_FILE_NAME = "Men.bin";

	/**
	 * Constructor por defecto que inicializa la lista y carga datos desde archivos.
	 */
	public MenDAO() {
		listaMenDTO = new ArrayList<>();
		loadFromSerializedFile();
		readFromTextFile(FILE_NAME);

	}

	/**
	 * Crea un nuevo usuario masculino en el sistema.
	 * 
	 * @param nuevoDato Objeto DTO con los datos del nuevo usuario.
	 */
	@Override
	public void create(MenDTO nuevoDato) {
		Men entity = DataMapper.convertirMenDTOAMen(nuevoDato);
		listaMenDTO.add(nuevoDato);
		writeSerializedFile();
		writeTextFile();
	}

	/**
	 * Muestra todos los usuarios masculinos registrados.
	 * 
	 * @return Cadena con la información de todos los usuarios.
	 */
	@Override
	public String showAll() {
		StringBuilder content = new StringBuilder();
		ArrayList<Men> entities = DataMapper.convertirListaMenDTOAListaMen(listaMenDTO);
		for (int i = 0; i < entities.size(); i++) {
			content.append(i).append(". ").append(entities.get(i).toString()).append("\n");
		}
		writeSerializedFile();
		writeTextFile();
		return content.toString();
	}

	/**
	 * Elimina un usuario masculino por su índice en la lista.
	 * 
	 * @param indice Posición del usuario en la lista.
	 * @return {@code true} si la eliminación fue exitosa, {@code false} en caso
	 *         contrario.
	 */
	@Override
	public boolean delete(int indice) {
		if (indice < 0 || indice >= listaMenDTO.size()) {
			return false;
		}
		listaMenDTO.remove(indice);
		writeSerializedFile();
		writeTextFile();
		return true;
	}

	/**
	 * Elimina un usuario masculino específico de la lista.
	 * 
	 * @param objetoAEliminar Objeto DTO del usuario a eliminar.
	 * @return {@code true} si la eliminación fue exitosa, {@code false} en caso
	 *         contrario.
	 */
	@Override
	public boolean delete(MenDTO objetoAEliminar) {
		return listaMenDTO.remove(objetoAEliminar);
	}

	/**
	 * Actualiza los datos de un usuario masculino en una posición específica.
	 * 
	 * @param indice          Posición del usuario en la lista.
	 * @param datoActualizado Objeto DTO con los datos actualizados.
	 * @return {@code true} si la actualización fue exitosa, {@code false} en caso
	 *         contrario.
	 */
	@Override
	public boolean update(int indice, MenDTO datoActualizado) {
		if (indice < 0 || indice >= listaMenDTO.size()) {
			return false;
		} else {
			Men entity = DataMapper.convertirMenDTOAMen(datoActualizado);
			listaMenDTO.set(indice, datoActualizado);
			writeSerializedFile();
			return true;
		}
	}

	/**
	 * Cuenta el número total de usuarios masculinos registrados.
	 * 
	 * @return Cantidad de usuarios en la lista.
	 */
	@Override
	public int count() {
		return listaMenDTO.size();
	}

	/**
	 * Lee los datos de usuarios desde un archivo de texto CSV.
	 * 
	 * @param url Ruta del archivo de texto a leer.
	 */
	@Override
	public void readFromTextFile(String url) {
		String content;
		content = FileHandler.leerDesdeArchivoTexto("Men.csv");
		if (content == null || content.isBlank()) {
			return;
		}

		String[] filas = content.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String separador = filas[i].contains(";") ? ";" : "\t";
			String[] columnas = filas[i].split(separador);

			if (columnas.length < 12) {
				System.err.println(" Línea inválida en CSV (fila " + (i + 1) + "): " + filas[i]);
				continue;
			}

			MenDTO temp = new MenDTO();
			temp.setName(columnas[0].trim());
			temp.setLastName(columnas[1].trim());
			temp.setAlias(columnas[2].trim());
			temp.setBornDate(columnas[3].trim());
			temp.setStature(columnas[4].trim());
			temp.setEmail(columnas[5].trim());
			temp.setGender(columnas[6].trim());
			temp.setSexualOrientation(columnas[7].trim());
			temp.setCountry(columnas[8].trim());
			temp.setPassword(columnas[9].trim());
			temp.setProfilePictureRoute(columnas[10].trim());

			try {
				temp.setMensualIncome(Long.parseLong(columnas[11].trim()));
			} catch (NumberFormatException e) {
				System.err.println(" Error convirtiendo ingreso mensual en fila " + (i + 1));
				temp.setMensualIncome(0);
			}

			if (columnas.length >= 13) {
				try {
					temp.setLikes(Integer.parseInt(columnas[12].trim()));
				} catch (NumberFormatException e) {
					temp.setLikes(0);
				}
			}

			listaMenDTO.add(temp);
		}
	}

	/**
	 * Escribe todos los datos de usuarios masculinos en un archivo de texto CSV.
	 */
	public void writeTextFile() {
		StringBuilder sb = new StringBuilder();
		for (MenDTO men : listaMenDTO) {
			sb.append(men.getName() + ";");
			sb.append(men.getLastName() + ";");
			sb.append(men.getAlias() + ";");
			sb.append(men.getBornDate() + ";");
			sb.append(men.getStature() + ";");
			sb.append(men.getEmail() + ";");
			sb.append(men.getGender() + ";");
			sb.append(men.getSexualOrientation() + ";");
			sb.append(men.getCountry() + ";");
			sb.append(men.getPassword() + ";");
			sb.append(men.getProfilePictureRoute() + ";");
			sb.append(men.getMensualIncome() + ";");
			sb.append(men.getLikes() + "\n");
		}

		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString());
	}

	/**
	 * Carga los datos de usuarios desde un archivo serializado binario.
	 */
	@Override
	public void loadFromSerializedFile() {
		Object content = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (content != null) {
			listaMenDTO = (ArrayList<MenDTO>) content;
		} else {
			listaMenDTO = new ArrayList<MenDTO>();
		}
	}

	/**
	 * Escribe todos los datos de usuarios en un archivo serializado binario.
	 */
	@Override
	public void writeSerializedFile() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaMenDTO);

	}

	/**
	 * Asigna las propiedades de internacionalización a todos los usuarios.
	 * 
	 * @param prop Propiedades de idioma o configuración.
	 */
	@Override
	public void internacionalizacion(Properties prop) {
		this.props = prop;
		for (MenDTO men : listaMenDTO) {
			men.internacionalizacion(prop);
		}
	}

	/**
	 * Valida las credenciales de un usuario masculino.
	 * 
	 * @param userAlias Alias del usuario.
	 * @param email     Correo electrónico del usuario.
	 * @param password  Contraseña del usuario.
	 * @return {@code true} si las credenciales son válidas, {@code false} en caso
	 *         contrario.
	 */
	public boolean validarUsuario(String userAlias, String email, String password) {
		String content = FileHandler.leerDesdeArchivoTexto(FILE_NAME);
		if (content == null || content.isBlank()) {
			return false;
		}

		String[] filas = content.split("\n");
		for (String fila : filas) {
			fila = fila.trim();
			if (fila.isEmpty())
				continue;

			String[] columnas = fila.split("[;\t]");
			if (columnas.length < 12)
				continue;

			// 0: nombre | 1: apellido | 2: alias | 3: fecha | 4: estatura |
			// 5: email | 6: género | 7: orientación | 8: país | 9: contraseña |
			// 10: foto | 11: ingresos
			String alias = columnas[2].trim();
			String mail = columnas[5].trim();
			String pass = columnas[9].trim();

			if (alias.equalsIgnoreCase(userAlias) && mail.equalsIgnoreCase(email) && pass.equals(password)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Actualiza el número de likes de un usuario específico.
	 * 
	 * @param alias       Alias del usuario.
	 * @param nuevosLikes Nueva cantidad de likes.
	 * @return {@code true} si la actualización fue exitosa, {@code false} en caso
	 *         contrario.
	 */
	@Override
	public boolean actualizarLikes(String alias, int nuevosLikes) {
		for (MenDTO usuario : listaMenDTO) {
			if (usuario.getAlias().equals(alias)) {
				usuario.setLikes(nuevosLikes);
				writeSerializedFile();
				writeTextFile();
				return true;
			}
		}
		return false;
	}

	/**
	 * Ordena la lista de usuarios de forma ascendente por nombre usando el
	 * algoritmo Selection Sort.
	 */
	@Override
	public void selectionSortAsc() {
		for (int i = 0; i < listaMenDTO.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < listaMenDTO.size(); j++) {
				if (listaMenDTO.get(j).getName().compareToIgnoreCase(listaMenDTO.get(minIndex).getName()) < 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				MenDTO temp = listaMenDTO.get(i);
				listaMenDTO.set(i, listaMenDTO.get(minIndex));
				listaMenDTO.set(minIndex, temp);
			}
		}
		writeSerializedFile();
		writeTextFile();
	}

	/**
	 * Ordena la lista de usuarios de forma descendente por nombre usando el
	 * algoritmo Insertion Sort.
	 */
	@Override
	public void insertionSortDes() {
		for (int i = 1; i < listaMenDTO.size(); i++) {
			MenDTO actual = listaMenDTO.get(i);
			int j = i - 1;
			while (j >= 0 && listaMenDTO.get(j).getName().compareToIgnoreCase(actual.getName()) < 0) {
				listaMenDTO.set(j + 1, listaMenDTO.get(j));
				j--;
			}
			listaMenDTO.set(j + 1, actual);
		}
		writeSerializedFile();
		writeTextFile();

	}

	/**
	 * Genera un informe PDF detallado con estadísticas y gráficas para un usuario
	 * específico.
	 * 
	 * @param alias Alias del usuario para el cual se generará el informe.
	 */
	@Override
	public void generarInformePDF(String alias) {
		MenDTO usuario = null;
		for (MenDTO m : listaMenDTO) {
			if (m.getAlias().equalsIgnoreCase(alias)) {
				usuario = m;
				break;
			}
		}

		if (usuario == null) {
			JOptionPane.showMessageDialog(null, "Usuario no encontrado: " + alias);
			return;
		}

		try {
			int totalUsuarios = listaMenDTO.size();
			int sumaLikes = 0;
			Map<Integer, Integer> freq = new HashMap<>();
			List<Integer> likesOrdenados = new ArrayList<Integer>();

			for (MenDTO u : listaMenDTO) {
				int likes = u.getLikes();
				sumaLikes += likes;
				freq.put(likes, freq.getOrDefault(likes, 0) + 1);
				likesOrdenados.add(likes);
			}

			// Media
			double media = (double) sumaLikes / totalUsuarios;

			// Mediana
			Collections.sort(likesOrdenados);
			double mediana;
			if (totalUsuarios % 2 == 0) {
				mediana = (likesOrdenados.get(totalUsuarios / 2 - 1) + likesOrdenados.get(totalUsuarios / 2)) / 2.0;
			} else {
				mediana = likesOrdenados.get(totalUsuarios / 2);
			}

			// Moda
			int moda = likesOrdenados.get(0);
			int maxFreq = 0;
			for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
				if (entry.getValue() > maxFreq) {
					maxFreq = entry.getValue();
					moda = entry.getKey();
				}
			}

			// Varianza
			double varianza = 0;
			for (int l : likesOrdenados) {
				varianza += Math.pow(l - media, 2);
			}
			varianza /= totalUsuarios;

			double desviacion = Math.sqrt(varianza);

			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("Informe_" + usuario.getAlias() + ".pdf"));
			document.open();

			Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
			Font textFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

			Paragraph titulo = new Paragraph("Informe de Usuario BosTinder", titleFont);
			titulo.setAlignment(Element.ALIGN_CENTER);
			document.add(titulo);

			document.add(new Paragraph("\nAlias: " + usuario.getAlias(), textFont));
			document.add(new Paragraph("Nombre: " + usuario.getName() + " " + usuario.getLastName(), textFont));
			document.add(new Paragraph("Email: " + usuario.getEmail(), textFont));
			document.add(new Paragraph("País: " + usuario.getCountry(), textFont));
			document.add(new Paragraph("Género: " + usuario.getGender(), textFont));
			document.add(new Paragraph("Orientación: " + usuario.getSexualOrientation(), textFont));
			document.add(new Paragraph("Fecha de nacimiento: " + usuario.getBornDate(), textFont));
			document.add(new Paragraph("Estatura: " + usuario.getStature(), textFont));
			document.add(new Paragraph("Ingreso mensual: $" + usuario.getMensualIncome(), textFont));
			document.add(new Paragraph("Likes: " + usuario.getLikes(), textFont));

			if (usuario.getProfilePictureRoute() != null && !usuario.getProfilePictureRoute().isBlank()) {
				try {
					Image foto = Image.getInstance(usuario.getProfilePictureRoute());
					foto.scaleToFit(150, 150);
					foto.setAlignment(Element.ALIGN_CENTER);
					document.add(new Paragraph("\n"));
					document.add(foto);
				} catch (Exception e) {
					document.add(new Paragraph("\n(Foto no encontrada o ruta inválida)", textFont));
				}
			}

			document.add(new Paragraph("\nEstadísticas de Likes", textFont));
			document.add(new Paragraph(String.format("Media: %.2f", media), textFont));
			document.add(new Paragraph(String.format("Mediana: %.2f", mediana), textFont));
			document.add(new Paragraph(String.format("Moda: %d", moda), textFont));
			document.add(new Paragraph(String.format("Varianza: %.2f", varianza), textFont));
			document.add(new Paragraph(String.format("Desviación estándar: %.2f", desviacion), textFont));

			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			for (MenDTO u : listaMenDTO) {
				dataset1.addValue(u.getLikes(), "Likes", u.getAlias());
			}
			JFreeChart chart1 = ChartFactory.createBarChart("Distribución de Likes", "Usuario", "Likes", dataset1);
			BarRenderer renderer1 = (BarRenderer) chart1.getCategoryPlot().getRenderer();
			renderer1.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer1.setDefaultItemLabelsVisible(true);
			NumberAxis yAxis1 = (NumberAxis) chart1.getCategoryPlot().getRangeAxis();
			yAxis1.setNumberFormatOverride(new java.text.DecimalFormat("#0"));
			File grafica1 = new File("GraficaLikes_" + usuario.getAlias() + ".png");
			ChartUtils.saveChartAsPNG(grafica1, chart1, 500, 300);
			Image imgChart1 = Image.getInstance(grafica1.getAbsolutePath());
			imgChart1.scaleToFit(450, 300);
			imgChart1.setAlignment(Element.ALIGN_CENTER);
			document.add(imgChart1);

			DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
			dataset2.addValue(media, "Media", "Likes");
			dataset2.addValue(mediana, "Mediana", "Likes");
			dataset2.addValue(moda, "Moda", "Likes");
			JFreeChart chart2 = ChartFactory.createBarChart("Media, Mediana y Moda", "Estadística", "Valor", dataset2);
			BarRenderer renderer2 = (BarRenderer) chart2.getCategoryPlot().getRenderer();
			renderer2.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer2.setDefaultItemLabelsVisible(true);
			NumberAxis yAxis2 = (NumberAxis) chart2.getCategoryPlot().getRangeAxis();
			yAxis2.setNumberFormatOverride(new java.text.DecimalFormat("#0.00"));
			File grafica2 = new File("GraficaMediaModa_" + usuario.getAlias() + ".png");
			ChartUtils.saveChartAsPNG(grafica2, chart2, 500, 300);
			Image imgChart2 = Image.getInstance(grafica2.getAbsolutePath());
			imgChart2.scaleToFit(450, 300);
			imgChart2.setAlignment(Element.ALIGN_CENTER);
			document.add(imgChart2);

			DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
			dataset3.addValue(varianza, "Varianza", "Likes");
			dataset3.addValue(desviacion, "Desviación", "Likes");
			JFreeChart chart3 = ChartFactory.createBarChart("Varianza y Desviación", "Estadística", "Valor", dataset3);
			BarRenderer renderer3 = (BarRenderer) chart3.getCategoryPlot().getRenderer();
			renderer3.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer3.setDefaultItemLabelsVisible(true);
			NumberAxis yAxis3 = (NumberAxis) chart3.getCategoryPlot().getRangeAxis();
			yAxis3.setNumberFormatOverride(new java.text.DecimalFormat("#0.00"));
			File grafica3 = new File("GraficaVarDesv_" + usuario.getAlias() + ".png");
			ChartUtils.saveChartAsPNG(grafica3, chart3, 500, 300);
			Image imgChart3 = Image.getInstance(grafica3.getAbsolutePath());
			imgChart3.scaleToFit(450, 300);
			imgChart3.setAlignment(Element.ALIGN_CENTER);
			document.add(imgChart3);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			document.add(new Paragraph("\nGenerado el: " + sdf.format(new java.util.Date()), textFont));

			document.close();

			JOptionPane.showMessageDialog(null, "PDF generado correctamente: Informe_" + usuario.getAlias() + ".pdf");

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
		}
	}

	/**
	 * Calcula la edad de un usuario masculino a partir de su fecha de nacimiento.
	 * 
	 * @param fechaNacimiento Fecha de nacimiento en formato dd/MM/yyyy.
	 * @return Edad calculada en años, o 0 si hay error en el formato.
	 */
	private int calcularEdadMen(String fechaNacimiento) {
		try {
			java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
			java.time.LocalDate fechaNac = java.time.LocalDate.parse(fechaNacimiento, formatter);
			java.time.LocalDate hoy = java.time.LocalDate.now();
			return java.time.Period.between(fechaNac, hoy).getYears();
		} catch (Exception e) {
			System.out.println("⚠️ Error al calcular edad para fecha: " + fechaNacimiento);
			return 0;
		}
	}
}