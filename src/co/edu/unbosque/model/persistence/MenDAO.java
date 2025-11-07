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
				System.err.println("⚠️ Error convirtiendo ingreso mensual en fila " + (i + 1));
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

}
