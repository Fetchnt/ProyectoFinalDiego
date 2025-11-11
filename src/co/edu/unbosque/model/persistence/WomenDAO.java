package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

import co.edu.unbosque.model.Women;
import co.edu.unbosque.model.WomenDTO;

public class WomenDAO implements DAO<WomenDTO> {

	public ArrayList<WomenDTO> listaWomenDTO;
	private Properties props;
	private final String FILE_NAME = "Women.csv";
	private final String SERIAL_FILE_NAME = "Women.bin";

	public WomenDAO() {
		listaWomenDTO = new ArrayList<>();
		loadFromSerializedFile();
		readFromTextFile(FILE_NAME);
	}

	@Override
	public void create(WomenDTO nuevoDato) {
		Women entity = DataMapper.convertirWomenDTOAWomen(nuevoDato);
		listaWomenDTO.add(nuevoDato);
		writeSerializedFile();
		writeTextFile();
	}

	@Override
	public String showAll() {
		StringBuilder content = new StringBuilder();
		ArrayList<Women> entities = DataMapper.convertirListaWomenDTOAListaWomen(listaWomenDTO);
		for (int i = 0; i < entities.size(); i++) {
			content.append(i).append(". ").append(entities.get(i).toString()).append("\n");
		}
		writeSerializedFile();
		writeTextFile();
		return content.toString();
	}

	@Override
	public boolean delete(int indice) {
		if (indice < 0 || indice >= listaWomenDTO.size()) {
			return false;
		}
		listaWomenDTO.remove(indice);
		writeSerializedFile();
		writeTextFile();
		return true;
	}

	@Override
	public boolean delete(WomenDTO objetoAEliminar) {
		return listaWomenDTO.remove(objetoAEliminar);
	}

	@Override
	public boolean update(int indice, WomenDTO datoActualizado) {
		if (indice < 0 || indice >= listaWomenDTO.size()) {
			return false;
		} else {
			Women entity = DataMapper.convertirWomenDTOAWomen(datoActualizado);
			listaWomenDTO.set(indice, datoActualizado);
			writeSerializedFile();
			writeTextFile();
			return true;
		}
	}

	@Override
	public int count() {
		return listaWomenDTO.size();
	}

	@Override
	public void readFromTextFile(String url) {
		String content;
		content = FileHandler.leerDesdeArchivoTexto("Women.csv");
		if (content == null || content.isBlank()) {
			return;
		}

		String[] filas = content.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String separador = filas[i].contains(";") ? ";" : "\t";
			String[] columnas = filas[i].split(separador);

			if (columnas.length < 12) {
				System.err.println("⚠️ Línea inválida en CSV (fila " + (i + 1) + "): " + filas[i]);
				continue;
			}

			WomenDTO temp = new WomenDTO();
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

			String divorcioStr = columnas[11].trim().toLowerCase();
			boolean divorcios = divorcioStr.equals("true") || divorcioStr.equals("1") || divorcioStr.equals("sí");
			temp.setHadDivorces(divorcios);

			// Leer likes si existe la columna 12
			if (columnas.length >= 13) {
				try {
					temp.setLikes(Integer.parseInt(columnas[12].trim()));
				} catch (NumberFormatException e) {
					temp.setLikes(0);
				}
			}

			listaWomenDTO.add(temp);
		}
	}

	@Override
	public void writeTextFile() {
		StringBuilder sb = new StringBuilder();
		for (WomenDTO women : listaWomenDTO) {
			sb.append(women.getName() + ";");
			sb.append(women.getLastName() + ";");
			sb.append(women.getAlias() + ";");
			sb.append(women.getBornDate() + ";");
			sb.append(women.getStature() + ";");
			sb.append(women.getEmail() + ";");
			sb.append(women.getGender() + ";");
			sb.append(women.getSexualOrientation() + ";");
			sb.append(women.getCountry() + ";");
			sb.append(women.getPassword() + ";");
			sb.append(women.getProfilePictureRoute() + ";");
			sb.append(women.isHadDivorces() + ";");
			sb.append(women.getLikes() + "\n");
		}

		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString());
	}

	@Override
	public void loadFromSerializedFile() {
		Object content = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (content != null) {
			listaWomenDTO = (ArrayList<WomenDTO>) content;
		} else {
			listaWomenDTO = new ArrayList<WomenDTO>();
		}
	}

	@Override
	public void writeSerializedFile() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaWomenDTO);

	}

	@Override
	public void internacionalizacion(Properties prop) {
		this.props = prop;
		for (WomenDTO women : listaWomenDTO) {
			women.internacionalizacion(prop);
		}
	}

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
			// 10: foto | 11: divorcios
			String alias = columnas[2].trim();
			String mail = columnas[5].trim();
			String pass = columnas[9].trim();

			if (alias.equalsIgnoreCase(userAlias) && mail.equalsIgnoreCase(email) && pass.equals(password)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean actualizarLikes(String alias, int nuevosLikes) {
		for (WomenDTO usuario : listaWomenDTO) {
			if (usuario.getAlias().equals(alias)) {
				usuario.setLikes(nuevosLikes);
				writeSerializedFile();
				writeTextFile();
				return true;
			}
		}
		return false;
	}

	@Override
	public void selectionSortAsc() {
		for (int i = 0; i < listaWomenDTO.size() - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < listaWomenDTO.size(); j++) {
				if (listaWomenDTO.get(j).getName().compareToIgnoreCase(listaWomenDTO.get(minIndex).getName()) < 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				WomenDTO temp = listaWomenDTO.get(i);
				listaWomenDTO.set(i, listaWomenDTO.get(minIndex));
				listaWomenDTO.set(minIndex, temp);
			}
		}
		writeSerializedFile();
		writeTextFile();

	}

	@Override
	public void insertionSortDes() {
		for (int i = 1; i < listaWomenDTO.size(); i++) {
			WomenDTO actual = listaWomenDTO.get(i);
			int j = i - 1;
			while (j >= 0 && listaWomenDTO.get(j).getName().compareToIgnoreCase(actual.getName()) < 0) {
				listaWomenDTO.set(j + 1, listaWomenDTO.get(j));
				j--;
			}
			listaWomenDTO.set(j + 1, actual);
		}
		writeSerializedFile();
		writeTextFile();

	}

	public void generarInformeGeneralPDF() {
		try {
			int totalUsuarios = listaWomenDTO.size();

			if (totalUsuarios == 0) {
				JOptionPane.showMessageDialog(null, "No hay usuarios femeninos para generar el reporte.");
				return;
			}

			int sumaLikes = 0;
			Map<Integer, Integer> freq = new HashMap<>();
			List<Integer> likesOrdenados = new ArrayList<>();
			int conDivorcios = 0;

			for (WomenDTO u : listaWomenDTO) {
				int likes = u.getLikes();
				sumaLikes += likes;
				freq.put(likes, freq.getOrDefault(likes, 0) + 1);
				likesOrdenados.add(likes);
				if (u.isHadDivorces()) {
					conDivorcios++;
				}
			}

			// Media de likes
			double mediaLikes = (double) sumaLikes / totalUsuarios;

			// Porcentaje de divorcios
			double porcentajeDivorcios = (conDivorcios * 100.0) / totalUsuarios;

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

			// Varianza y desviación
			double varianza = 0;
			for (int l : likesOrdenados) {
				varianza += Math.pow(l - mediaLikes, 2);
			}
			varianza /= totalUsuarios;
			double desviacion = Math.sqrt(varianza);

			// Crear documento PDF
			Document document = new Document();
			String nombreArchivo = "Informe_General_Mujeres_" + System.currentTimeMillis() + ".pdf";
			PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
			document.open();

			Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
			Font subtitleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
			Font textFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

			Paragraph titulo = new Paragraph("Informe General - Usuarios Femeninos", titleFont);
			titulo.setAlignment(Element.ALIGN_CENTER);
			document.add(titulo);

			document.add(new Paragraph("\n"));

			Paragraph subtitulo = new Paragraph("Resumen Estadistico", subtitleFont);
			subtitulo.setAlignment(Element.ALIGN_CENTER);
			document.add(subtitulo);

			document.add(new Paragraph("\n"));

			document.add(new Paragraph("Total de usuarios femeninos: " + totalUsuarios, textFont));
			document.add(new Paragraph("Usuarios con divorcios: " + conDivorcios + " ("
					+ String.format("%.1f%%", porcentajeDivorcios) + ")", textFont));

			document.add(new Paragraph("\nEstadisticas de Likes:", subtitleFont));
			document.add(new Paragraph(String.format("Media: %.2f", mediaLikes), textFont));
			document.add(new Paragraph(String.format("Mediana: %.2f", mediana), textFont));
			document.add(new Paragraph(String.format("Moda: %d", moda), textFont));
			document.add(new Paragraph(String.format("Varianza: %.2f", varianza), textFont));
			document.add(new Paragraph(String.format("Desviacion estandar: %.2f", desviacion), textFont));

			// Gráfica 1: Distribución de Likes
			DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
			for (WomenDTO u : listaWomenDTO) {
				dataset1.addValue(u.getLikes(), "Likes", u.getAlias());
			}
			JFreeChart chart1 = ChartFactory.createBarChart("Distribucion de Likes por Usuario", "Usuario", "Likes",
					dataset1);
			BarRenderer renderer1 = (BarRenderer) chart1.getCategoryPlot().getRenderer();
			renderer1.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer1.setDefaultItemLabelsVisible(true);
			NumberAxis yAxis1 = (NumberAxis) chart1.getCategoryPlot().getRangeAxis();
			yAxis1.setNumberFormatOverride(new java.text.DecimalFormat("#0"));

			File grafica1 = new File("GraficaLikes_General_Mujeres.png");
			ChartUtils.saveChartAsPNG(grafica1, chart1, 600, 400);
			Image imgChart1 = Image.getInstance(grafica1.getAbsolutePath());
			imgChart1.scaleToFit(500, 350);
			imgChart1.setAlignment(Element.ALIGN_CENTER);
			document.add(new Paragraph("\n"));
			document.add(imgChart1);

			// Gráfica 2: Estadísticas centrales
			DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
			dataset2.addValue(mediaLikes, "Media", "Likes");
			dataset2.addValue(mediana, "Mediana", "Likes");
			dataset2.addValue(moda, "Moda", "Likes");

			JFreeChart chart2 = ChartFactory.createBarChart("Tendencias Centrales", "Estadistica", "Valor", dataset2);
			BarRenderer renderer2 = (BarRenderer) chart2.getCategoryPlot().getRenderer();
			renderer2.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer2.setDefaultItemLabelsVisible(true);
			NumberAxis yAxis2 = (NumberAxis) chart2.getCategoryPlot().getRangeAxis();
			yAxis2.setNumberFormatOverride(new java.text.DecimalFormat("#0.00"));

			File grafica2 = new File("GraficaTendencias_General_Mujeres.png");
			ChartUtils.saveChartAsPNG(grafica2, chart2, 600, 400);
			Image imgChart2 = Image.getInstance(grafica2.getAbsolutePath());
			imgChart2.scaleToFit(500, 350);
			imgChart2.setAlignment(Element.ALIGN_CENTER);
			document.add(new Paragraph("\n"));
			document.add(imgChart2);

			// Gráfica 3: Dispersión
			DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
			dataset3.addValue(varianza, "Varianza", "Likes");
			dataset3.addValue(desviacion, "Desviacion", "Likes");

			JFreeChart chart3 = ChartFactory.createBarChart("Medidas de Dispersion", "Estadistica", "Valor", dataset3);
			BarRenderer renderer3 = (BarRenderer) chart3.getCategoryPlot().getRenderer();
			renderer3.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			renderer3.setDefaultItemLabelsVisible(true);
			NumberAxis yAxis3 = (NumberAxis) chart3.getCategoryPlot().getRangeAxis();
			yAxis3.setNumberFormatOverride(new java.text.DecimalFormat("#0.00"));

			File grafica3 = new File("GraficaDispersion_General_Mujeres.png");
			ChartUtils.saveChartAsPNG(grafica3, chart3, 600, 400);
			Image imgChart3 = Image.getInstance(grafica3.getAbsolutePath());
			imgChart3.scaleToFit(500, 350);
			imgChart3.setAlignment(Element.ALIGN_CENTER);
			document.add(new Paragraph("\n"));
			document.add(imgChart3);

			// Fecha de generación
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			document.add(new Paragraph("\nGenerado el: " + sdf.format(new java.util.Date()), textFont));

			document.close();

			JOptionPane.showMessageDialog(null, "PDF general generado correctamente:\n" + nombreArchivo);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
		}
	}
}