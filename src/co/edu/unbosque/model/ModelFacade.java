package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import co.edu.unbosque.model.persistence.MenDAO;
import co.edu.unbosque.model.persistence.WomenDAO;

public class ModelFacade {

	private WomenDAO wDAO;
	private MenDAO mDAO;
	private List<User> perfilesActuales;
	private List<User> likes;
	private int indiceActual = 0;

	public ModelFacade() {
		mDAO = new MenDAO();
		wDAO = new WomenDAO();
		perfilesActuales = new ArrayList<User>();
		likes = new ArrayList<User>();
	}

	public WomenDAO getwDAO() {
		return wDAO;
	}

	public void setwDAO(WomenDAO wDAO) {
		this.wDAO = wDAO;
	}

	public MenDAO getmDAO() {
		return mDAO;
	}

	public void setmDAO(MenDAO mDAO) {
		this.mDAO = mDAO;
	}

	public List<User> getUsuariosPorPais(String pais) {
		List<User> resultado = new ArrayList<>();

		for (var m : mDAO.listaMenDTO) {
			if (m.getCountry() != null && m.getCountry().equalsIgnoreCase(pais)) {
				resultado.add(m);
			}
		}

		for (var w : wDAO.listaWomenDTO) {
			if (w.getCountry() != null && w.getCountry().equalsIgnoreCase(pais)) {
				resultado.add(w);
			}
		}

		return resultado;
	}

	public void cargarProperties(Properties prop) {
		mDAO.internacionalizacion(prop);
		wDAO.internacionalizacion(prop);

	}

	public boolean validarInicioSesion(String userAlias, String email, String password) {
		// 🔹 Leer siempre los CSV más recientes
		mDAO.listaMenDTO.clear();
		mDAO.readFromTextFile("Men.csv");

		wDAO.listaWomenDTO.clear();
		wDAO.readFromTextFile("Women.csv");

		// 🔹 Buscar coincidencia en hombres
		for (var m : mDAO.listaMenDTO) {
			if (m.getAlias().equalsIgnoreCase(userAlias) && m.getEmail().equalsIgnoreCase(email)
					&& m.getPassword().equals(password)) {
				return true;
			}
		}

		// 🔹 Buscar coincidencia en mujeres
		for (var w : wDAO.listaWomenDTO) {
			if (w.getAlias().equalsIgnoreCase(userAlias) && w.getEmail().equalsIgnoreCase(email)
					&& w.getPassword().equals(password)) {
				return true;
			}
		}

		return false;
	}

	public void cargarPerfiles() {
		perfilesActuales.clear();
		perfilesActuales.addAll(mDAO.listaMenDTO);
		perfilesActuales.addAll(wDAO.listaWomenDTO);
		indiceActual = 0;
	}

	public User getPerfilActual() {
		if (indiceActual < perfilesActuales.size()) {
			return perfilesActuales.get(indiceActual);
		}
		return null;
	}

	public void siguientePerfil() {
		if (indiceActual < perfilesActuales.size() - 1) {
			indiceActual++;
		} else {
			indiceActual = perfilesActuales.size(); // evita error de índice
		}
	}

	public void agregarLike() {
		User actual = getPerfilActual();
		if (actual != null && !likes.contains(actual)) {
			likes.add(actual);
		}
	}

	public List<User> getLikes() {
		return likes;
	}

}
