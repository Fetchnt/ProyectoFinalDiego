package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Properties;

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

}
