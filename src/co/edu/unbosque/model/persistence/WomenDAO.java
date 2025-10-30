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
		if (content == "" || content.isBlank()) {
			return;
		}
		String[] filas = content.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			WomenDTO temp = new WomenDTO();
			temp.setName(columnas[0]);
			temp.setLastName(columnas[1]);
			temp.setAlias(columnas[2]);
			temp.setBornDate(columnas[3]);
			temp.setStature(columnas[4]);
			temp.setEmail(columnas[5]);
			temp.setGender(columnas[6]);
			temp.setSexualOrientation(columnas[7]);
			temp.setCountry(columnas[8]);
			temp.setPassword(columnas[9]);
			temp.setProfilePictureRoute(columnas[10]);
			temp.setHadDivorces(Boolean.parseBoolean(columnas[11]));

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
			sb.append(women.isHadDivorces() + "\n");
		}

		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString()); // hay que actualizar o sobreescribir el archivo
																		// cada vez que usted agregue, elimine y
																		// actualice//
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

}
