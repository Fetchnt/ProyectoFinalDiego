package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import co.edu.unbosque.model.WomenDTO;

public class WomenDAO implements DAO<WomenDTO> {

	public ArrayList<WomenDTO> listaWomenDTO;
	private final String FILE_NAME = "Women.txt";
	private final String SERIAL_FILE_NAME = "Women.bin";
	
	public WomenDAO() {
		listaWomenDTO = new ArrayList<>();
		loadFromSerializedFile();
	}

	@Override
	public void create(WomenDTO nuevoDato) {
		listaWomenDTO.add(nuevoDato);
		WriteSerializedFile();
	}

	private String content = "";
	@Override
	public String showAll() {
		content = "";
		for (int i = 0; i < listaWomenDTO.size(); i++) {
			content += i + "." + listaWomenDTO.get(i).toString() + "\n";
		}
		writeFromTextFile();
		return content;
	}

	@Override
	public boolean delete(int indice) {
		if(indice<0 || indice >= listaWomenDTO.size()) {
		return false;
		}
		else {
			return true;
		}
	}
	

	@Override
	public boolean delete(WomenDTO objetoAEliminar) {
		return listaWomenDTO.remove(objetoAEliminar);
	}

	@Override
	public boolean update(int indice, WomenDTO datoActualizado) {
		if (indice <0 || indice >= listaWomenDTO.size()) {
			return false;			
		}
		else {
			WriteSerializedFile();
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
		content = FileHandler.leerDesdeArchivoDeTexto("ave.csv");
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
			temp.setAge(Byte.parseByte(columnas[3]));
			temp.setStature(Float.parseFloat(columnas[4]));
			temp.setEmail(columnas[5]);
			temp.setGender(columnas[6]);
			temp.setSexualOrientation(columnas[7]);
			temp.setCountry(columnas[8]);
			temp.setHadDivorces(Boolean.parseBoolean(columnas[9]));
			
			
			listaWomenDTO.add(temp);
		}
		
	}

	@Override
	public void writeFromTextFile() {
		StringBuilder sb = new StringBuilder();
		for (WomenDTO women : listaWomenDTO) {
			sb.append(women.getName() + ";");
			sb.append(women.getLastName() + ";");
			sb.append(women.getAlias() + ";");
			sb.append(women.getAge() + ";");
			sb.append(women.getStature() + ";");
			sb.append(women.getEmail() + ";");
			sb.append(women.getGender() + ";");
			sb.append(women.getSexualOrientation() + ";");
			sb.append(women.getCountry() + ";");
//			sb.append(women.getHadDivorces() + ";");
		}

		
		FileHandler.escribirEnArchivoTexto(FILE_NAME, sb.toString()); //hay que actualizar o sobreescribir el archivo cada vez que usted agregue, elimine y actualice//
	}

	@Override
	public void loadFromSerializedFile() {
		Object content = FileHandler.leerDesdeArchivoSerializado(SERIAL_FILE_NAME);
		if (content != null) {
			listaWomenDTO = (ArrayList<WomenDTO>) content;		
		}
		else {
			listaWomenDTO = new ArrayList<WomenDTO>();
		}	
	}

	@Override
	public void WriteSerializedFile() {
		FileHandler.escribirEnArchivoSerializado(SERIAL_FILE_NAME, listaWomenDTO);
		
	}
	
	
	
}
