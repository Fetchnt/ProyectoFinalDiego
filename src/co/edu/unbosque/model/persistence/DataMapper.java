package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Men;
import co.edu.unbosque.model.MenDTO;
import co.edu.unbosque.model.WomenDTO;
import co.edu.unbosque.model.Women;

/**
 * Clase encargada de realizar la conversión entre objetos del modelo
 * (entidades) y sus respectivos objetos de transferencia de datos (DTO).
 * <b>pre:</b> Las listas o instancias pasadas como parámetros deben estar
 * inicializadas. <br>
 * <b>post:</b> Devuelve una nueva lista o instancia convertida al tipo
 * correspondiente.
 * 
 */
public class DataMapper {

	/**
	 * Convierte una lista de objetos {@link Men} a una lista de {@link MenDTO}.
	 * 
	 * @param entityList Lista de entidades {@code Men} a convertir.
	 * @return Lista de objetos {@code MenDTO} equivalentes.
	 */
	public static ArrayList<MenDTO> convertirListaMenAListaMenDTO(ArrayList<Men> entityList) {
		ArrayList<MenDTO> dtoList = new ArrayList<MenDTO>();
		for (Men entity : entityList) {
			MenDTO dto = new MenDTO();
			dto.setName(entity.getName());
			dto.setLastName(entity.getLastName());
			dto.setAlias(entity.getAlias());
			dto.setBornDate(entity.getBornDate());
			dto.setStature(entity.getStature());
			dto.setEmail(entity.getEmail());
			dto.setGender(entity.getGender());
			dto.setSexualOrientation(entity.getSexualOrientation());
			dto.setProfilePictureRoute(entity.getProfilePictureRoute());
			dto.setCountry(entity.getCountry());
			dto.setMensualIncome(entity.getMensualIncome());
			dtoList.add(dto);
		}
		return dtoList;
	}

	/**
	 * Convierte una lista de {@link MenDTO} a una lista de {@link Men}.
	 * 
	 * @param dtoList Lista de objetos DTO a convertir.
	 * @return Lista de entidades {@code Men} resultantes.
	 */
	public static ArrayList<Men> convertirListaMenDTOAListaMen(ArrayList<MenDTO> dtoList) {
		ArrayList<Men> entityList = new ArrayList<Men>();
		for (MenDTO dto : dtoList) {
			Men entity = new Men();
			entity.setName(dto.getName());
			entity.setLastName(dto.getLastName());
			entity.setAlias(dto.getAlias());
			entity.setBornDate(dto.getBornDate());
			entity.setStature(dto.getStature());
			entity.setEmail(dto.getEmail());
			entity.setGender(dto.getGender());
			entity.setSexualOrientation(dto.getSexualOrientation());
			entity.setProfilePictureRoute(dto.getProfilePictureRoute());
			entity.setCountry(dto.getCountry());
			entity.setMensualIncome(dto.getMensualIncome());
			dtoList.add(dto);
		}
		return entityList;
	}

	/**
	 * Convierte un objeto {@link MenDTO} a su entidad {@link Men}.
	 * 
	 * @param dto Objeto DTO a convertir.
	 * @return Objeto {@code Men} equivalente.
	 */
	public static Men convertirMenDTOAMen(MenDTO dto) {

		Men entity = new Men();

		entity.setName(dto.getName());
		entity.setLastName(dto.getLastName());
		entity.setAlias(dto.getAlias());
		entity.setBornDate(dto.getBornDate());
		entity.setStature(dto.getStature());
		entity.setEmail(dto.getEmail());
		entity.setGender(dto.getGender());
		entity.setSexualOrientation(dto.getSexualOrientation());
		entity.setProfilePictureRoute(dto.getProfilePictureRoute());
		entity.setCountry(dto.getCountry());
		entity.setMensualIncome(dto.getMensualIncome());

		return entity;

	}

	/**
	 * Convierte un objeto {@link Men} a su representación {@link MenDTO}.
	 * 
	 * @param entity Objeto {@code Men} a convertir.
	 * @return Objeto {@code MenDTO} equivalente.
	 */
	public static MenDTO convertirMenAMenDTO(Men entity) {
		MenDTO dto = new MenDTO();
		dto.setName(entity.getName());
		dto.setLastName(entity.getLastName());
		dto.setAlias(entity.getAlias());
		dto.setBornDate(entity.getBornDate());
		dto.setStature(entity.getStature());
		dto.setEmail(entity.getEmail());
		dto.setGender(entity.getGender());
		dto.setSexualOrientation(entity.getSexualOrientation());
		dto.setProfilePictureRoute(entity.getProfilePictureRoute());
		dto.setCountry(entity.getCountry());
		dto.setMensualIncome(entity.getMensualIncome());
		return dto;
	}

	/**
	 * Convierte una lista de {@link Women} a una lista de {@link WomenDTO}.
	 * 
	 * @param entityList Lista de entidades {@code Women}.
	 * @return Lista de objetos {@code WomenDTO} convertidos.
	 */
	public static ArrayList<WomenDTO> convertirListaWomenAListaWomenDTO(ArrayList<Women> entityList) {
		ArrayList<WomenDTO> dtoList = new ArrayList<WomenDTO>();
		for (Women entity : entityList) {
			WomenDTO dto = new WomenDTO();
			dto.setName(entity.getName());
			dto.setLastName(entity.getLastName());
			dto.setAlias(entity.getAlias());
			dto.setBornDate(entity.getBornDate());
			dto.setStature(entity.getStature());
			dto.setEmail(entity.getEmail());
			dto.setGender(entity.getGender());
			dto.setSexualOrientation(entity.getSexualOrientation());
			dto.setProfilePictureRoute(entity.getProfilePictureRoute());
			dto.setCountry(entity.getCountry());
			dto.setHadDivorces(entity.isHadDivorces());
			dtoList.add(dto);
		}
		return dtoList;
	}

	/**
	 * Convierte una lista de {@link WomenDTO} a una lista de {@link Women}.
	 * 
	 * @param dtoList Lista de DTOs de mujeres.
	 * @return Lista de entidades {@code Women}.
	 */
	public static ArrayList<Women> convertirListaWomenDTOAListaWomen(ArrayList<WomenDTO> dtoList) {
		ArrayList<Women> entityList = new ArrayList<Women>();
		for (WomenDTO dto : dtoList) {
			Women entity = new Women();
			entity.setName(dto.getName());
			entity.setLastName(dto.getLastName());
			entity.setAlias(dto.getAlias());
			entity.setBornDate(dto.getBornDate());
			entity.setStature(dto.getStature());
			entity.setEmail(dto.getEmail());
			entity.setGender(dto.getGender());
			entity.setSexualOrientation(dto.getSexualOrientation());
			entity.setProfilePictureRoute(dto.getProfilePictureRoute());
			entity.setCountry(dto.getCountry());
			entity.setHadDivorces(dto.isHadDivorces());
			entityList.add(entity);
		}
		return entityList;
	}

	/**
	 * Convierte un objeto {@link WomenDTO} en una entidad {@link Women}.
	 * 
	 * @param dto Objeto DTO de tipo {@code WomenDTO}.
	 * @return Entidad {@code Women} equivalente.
	 */
	public static Women convertirWomenDTOAWomen(WomenDTO dto) {
		Women entity = new Women();
		entity.setName(dto.getName());
		entity.setLastName(dto.getLastName());
		entity.setAlias(dto.getAlias());
		entity.setBornDate(dto.getBornDate());
		entity.setStature(dto.getStature());
		entity.setEmail(dto.getEmail());
		entity.setGender(dto.getGender());
		entity.setSexualOrientation(dto.getSexualOrientation());
		entity.setProfilePictureRoute(dto.getProfilePictureRoute());
		entity.setCountry(dto.getCountry());
		entity.setHadDivorces(dto.isHadDivorces());
		return entity;

	}

	/**
	 * Convierte un objeto {@link Women} en su correspondiente {@link WomenDTO}.
	 * 
	 * @param entity Entidad de tipo {@code Women}.
	 * @return Objeto {@code WomenDTO} resultante.
	 */
	public static WomenDTO convertirWomenAWomenDTO(Women entity) {
		WomenDTO dto = new WomenDTO();
		dto.setName(entity.getName());
		dto.setLastName(entity.getLastName());
		dto.setAlias(entity.getAlias());
		dto.setBornDate(entity.getBornDate());
		dto.setStature(entity.getStature());
		dto.setEmail(entity.getEmail());
		dto.setGender(entity.getGender());
		dto.setSexualOrientation(entity.getSexualOrientation());
		dto.setProfilePictureRoute(entity.getProfilePictureRoute());
		dto.setCountry(entity.getCountry());
		dto.setHadDivorces(entity.isHadDivorces());
		return dto;
	}
}
