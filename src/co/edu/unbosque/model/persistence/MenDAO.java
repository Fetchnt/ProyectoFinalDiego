package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.Properties;

import co.edu.unbosque.model.Men;
import co.edu.unbosque.model.MenDTO;

public class MenDAO implements DAO<MenDTO> {

	public ArrayList<MenDTO> listaMenDTO;
	private Properties props;
	private final String FILE_NAME = "Men.csv";
	private final String SERIAL_FILE_NAME = "Men.bin";

	public MenDAO() {
		listaMenDTO = new ArrayList<>();
		loadFromSerializedFile();
		readFromTextFile(FILE_NAME);

	}

	@Override
	public void create(MenDTO nuevoDato) {
		Men entity = DataMapper.convertirMenDTOAMen(nuevoDato);
		listaMenDTO.add(nuevoDato);
		writeSerializedFile();
		writeTextFile();
	}

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

	@Override
	public boolean delete(MenDTO objetoAEliminar) {
		return listaMenDTO.remove(objetoAEliminar);
	}

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

	@Override
	public int count() {
		return listaMenDTO.size();
	}

	@Override
	public void readFromTextFile(String url) {
		String content;
		content = FileHandler.leerDesdeArchivoTexto("Men.csv");
		if (content == "" || content.isBlank()) {
			return;
		}
		String[] filas = content.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");
			MenDTO temp = new MenDTO();
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
			temp.setMensualIncome(Long.parseLong(columnas[11]));

			listaMenDTO.add(temp);
		}

	}

	@Override
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
			sb.append(men.getMensualIncome() + "\n");
		}

		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString()); // hay que actualizar o sobreescribir el archivo
																		// cada vez que usted agregue, elimine y
																		// actualice//
	}

	@Override
	public void loadFromSerializedFile() {
		Object content = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (content != null) {
			listaMenDTO = (ArrayList<MenDTO>) content;
		} else {
			listaMenDTO = new ArrayList<MenDTO>();
		}
	}

	@Override
	public void writeSerializedFile() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaMenDTO);

	}

	@Override
	public void internacionalizacion(Properties prop) {
		this.props = prop;
		for (MenDTO men : listaMenDTO) {
			men.internacionalizacion(prop);
		}
	}
}
