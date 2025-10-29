package co.edu.unbosque.model.persistence;

import java.util.ArrayList;

import co.edu.unbosque.model.Men;
import co.edu.unbosque.model.MenDTO;
import co.edu.unbosque.model.WomenDTO;
import co.edu.unbosque.model.Women;

public class DataMapper {

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
	
	public static ArrayList<Men> convertirListaMenDTOAListaMen(ArrayList<MenDTO> dtoList) {
		ArrayList<Men> entityList = new ArrayList<Men>();
		for (MenDTO dto: dtoList) {
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
	
	public static ArrayList<WomenDTO> convertirListaWomenAListaWomenDTO(ArrayList<Women> entityList){
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
	
	public static ArrayList<Women> convertirListaWomenDTOAListaWomen(ArrayList<WomenDTO> dtoList){
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
