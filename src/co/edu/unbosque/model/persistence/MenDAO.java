package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.MenDTO;

public class MenDAO implements DAO<MenDTO> {

	public ArrayList<MenDTO> listaMenDTO;
	private final String FILE_NAME = "Men.csv";
	private final String SERIAL_FILE_NAME = "Men.bin";
	
	public MenDAO() {
		listaMenDTO = new ArrayList<>();
		loadFromSerializedFile();
		
	}

	@Override
	public void create(MenDTO nuevoDato) {
		listaMenDTO.add(nuevoDato);
		WriteSerializedFile();
	}

	private String content = "";
	@Override
	public String showAll() {
		content = "";
		for (int i = 0; i < listaMenDTO.size(); i++) {
			content += i + "." + listaMenDTO.get(i).toString() + "\n";
		}
		writeFromTextFile();
		return content;
	}

	@Override
	public boolean delete(int indice) {
		if(indice<0 || indice >= listaMenDTO.size()) {
		return false;
		}
		else {
			return true;
		}
	}
	

	@Override
	public boolean delete(MenDTO objetoAEliminar) {
		return listaMenDTO.remove(objetoAEliminar);
	}

	@Override
	public boolean update(int indice, MenDTO datoActualizado) {
		if (indice <0 || indice >= listaMenDTO.size()) {
			return false;			
		}
		else {
			WriteSerializedFile();
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
		content = FileHandler.leerDesdeArchivoDeTexto("Men.csv");
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
			temp.setMensualIncome(Long.parseLong(columnas[9]));
			
			
			listaMenDTO.add(temp);
		}
		
	}

	@Override
	public void writeFromTextFile() {
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
			sb.append(men.getMensualIncome() + ";");
		}

		
		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString()); //hay que actualizar o sobreescribir el archivo cada vez que usted agregue, elimine y actualice//
	}

	@Override
	public void loadFromSerializedFile() {
		Object content = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (content != null) {
			listaMenDTO = (ArrayList<MenDTO>) content;		
		}
		else {
			listaMenDTO = new ArrayList<MenDTO>();
		}	
	}

	@Override
	public void WriteSerializedFile() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaMenDTO);
		
	}
	
	
	
}
