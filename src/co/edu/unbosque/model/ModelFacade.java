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
	private List<User> favoritos;
	private int indiceActual = 0;
	private boolean modoIncognito = false;
	private User usuarioActual;

	public ModelFacade() {
		mDAO = new MenDAO();
		wDAO = new WomenDAO();
		perfilesActuales = new ArrayList<User>();
		likes = new ArrayList<User>();
		favoritos = new ArrayList<User>();
	}

	// === GETTERS Y SETTERS ===
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

	public boolean isModoIncognito() {
		return modoIncognito;
	}

	public void setModoIncognito(boolean modoIncognito) {
		this.modoIncognito = modoIncognito;
	}

	public User getUsuarioActual() {
		return usuarioActual;
	}

	public void setUsuarioActual(User usuarioActual) {
		this.usuarioActual = usuarioActual;
	}

	// === MÉTODOS DE USUARIOS Y PAÍSES ===
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
				setUsuarioActual(m);
				return true;
			}
		}

		// 🔹 Buscar coincidencia en mujeres
		for (var w : wDAO.listaWomenDTO) {
			if (w.getAlias().equalsIgnoreCase(userAlias) && w.getEmail().equalsIgnoreCase(email)
					&& w.getPassword().equals(password)) {
				setUsuarioActual(w);
				return true;
			}
		}

		return false;
	}

	public User obtenerUsuarioPorAlias(String alias) {
		// Buscar en hombres
		for (MenDTO hombre : mDAO.listaMenDTO) {
			if (hombre.getAlias().equals(alias)) {
				return hombre;
			}
		}

		// Buscar en mujeres
		for (WomenDTO mujer : wDAO.listaWomenDTO) {
			if (mujer.getAlias().equals(alias)) {
				return mujer;
			}
		}

		return null;
	}

	// === MÉTODOS DE PERFILES Y LIKES ===
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

	public boolean agregarAFavoritos(User usuario) {
		if (usuario != null && !favoritos.contains(usuario)) {
			favoritos.add(usuario);
			return true;
		}
		return false;
	}

	public List<User> getFavoritos() {
		return favoritos;
	}

	// === MÉTODOS DE ADMINISTRACIÓN ===
	public List<User> obtenerTodosLosUsuarios() {
		List<User> todosLosUsuarios = new ArrayList<>();
		todosLosUsuarios.addAll(mDAO.listaMenDTO);
		todosLosUsuarios.addAll(wDAO.listaWomenDTO);
		return todosLosUsuarios;
	}

	public boolean eliminarUsuarioPorAlias(String alias) {
		// Buscar y eliminar en hombres
		for (int i = 0; i < mDAO.listaMenDTO.size(); i++) {
			if (mDAO.listaMenDTO.get(i).getAlias().equals(alias)) {
				mDAO.delete(i);
				return true;
			}
		}

		// Buscar y eliminar en mujeres
		for (int i = 0; i < wDAO.listaWomenDTO.size(); i++) {
			if (wDAO.listaWomenDTO.get(i).getAlias().equals(alias)) {
				wDAO.delete(i);
				return true;
			}
		}

		return false; // No se encontró el usuario
	}

	public User buscarUsuarioPorAlias(String alias) {
		// Buscar en hombres
		for (MenDTO hombre : mDAO.listaMenDTO) {
			if (hombre.getAlias().equals(alias)) {
				return hombre;
			}
		}

		// Buscar en mujeres
		for (WomenDTO mujer : wDAO.listaWomenDTO) {
			if (mujer.getAlias().equals(alias)) {
				return mujer;
			}
		}

		return null;
	}

	// === MÉTODOS DE MODO INCÓGNITO ===
	/**
	 * Retorna un usuario con datos ocultos si está en modo incógnito
	 */
	public User getPerfilParaMostrar(User usuarioOriginal) {
		if (usuarioOriginal == null)
			return null;

		// Si el usuario NO es el mismo que está viendo, y está en modo incógnito,
		// ocultar datos
		if (modoIncognito && !usuarioOriginal.equals(usuarioActual)) {
			return crearUsuarioOculto(usuarioOriginal);
		}

		return usuarioOriginal; // Mostrar datos completos
	}

	/**
	 * Obtiene el perfil actual para mostrar (con lógica de incógnito aplicada)
	 */
	public User getPerfilActualParaMostrar() {
		User perfilActual = getPerfilActual();
		return getPerfilParaMostrar(perfilActual);
	}

	/**
	 * Crea una versión con datos ocultos del usuario
	 */
	private User crearUsuarioOculto(User usuarioOriginal) {
		// Usar una clase anónima para crear un usuario con datos ocultos
		return new User() {
			@Override
			public String getName() {
				return "Usuario";
			}

			@Override
			public String getLastName() {
				return "Incógnito";
			}

			@Override
			public String getAlias() {
				return "anon_imous456";
			}

			@Override
			public String getEmail() {
				return "oculto@bostinder.com";
			}

			@Override
			public String getBornDate() {
				return "??/??/????";
			} 

			@Override
			public String getCountry() {
				return "Desconocido";
			}

			@Override
			public String getGender() {
				return usuarioOriginal.getGender();
			} 

			@Override
			public String getSexualOrientation() {
				return "No especificado";
			}

			/*@Override
			public String getProfilePictureRoute() {
				// Ruta a una imagen genérica/placeholder
				return "images/incognito_avatar.png";
			}*/

			@Override
			public String getStature() {
				return "No especificado";
			}
		};
	}
}