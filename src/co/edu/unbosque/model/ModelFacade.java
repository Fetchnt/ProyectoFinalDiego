package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
	private boolean modoIncognito;
	private User usuarioActual;

	public ModelFacade() {
		mDAO = new MenDAO();
		wDAO = new WomenDAO();
		perfilesActuales = new ArrayList<User>();
		likes = new ArrayList<User>();
		favoritos = new ArrayList<User>();
		modoIncognito = false;
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

			// Incrementar el contador de likes del perfil (ahora está en User)
			actual.incrementarLikes();

			// Guardar inmediatamente el cambio
			if (actual instanceof MenDTO) {
				mDAO.actualizarLikes(actual.getAlias(), actual.getLikes());
			} else if (actual instanceof WomenDTO) {
				wDAO.actualizarLikes(actual.getAlias(), actual.getLikes());
			}
		}
	}

	public int obtenerLikesUsuario(String alias) {
		User usuario = buscarUsuarioPorAlias(alias);
		return usuario != null ? usuario.getLikes() : 0;
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
	 * Obtiene los usuarios ordenados por ingresos (solo hombres con ingresos >=
	 * umbral)
	 * 
	 * @param umbralIngresos El umbral mínimo de ingresos
	 * @return Lista de hombres que cumplen con el criterio
	 */
	public List<User> obtenerUsuariosPorIngresos(double umbralIngresos) {
		List<User> usuariosFiltrados = new ArrayList<>();

		for (MenDTO hombre : mDAO.listaMenDTO) {
			if (hombre.getMensualIncome() >= umbralIngresos) {
				usuariosFiltrados.add(hombre);
			}
		}

		// Ordenar por ingresos de mayor a menor (bubble sort simple)
		for (int i = 0; i < usuariosFiltrados.size() - 1; i++) {
			for (int j = 0; j < usuariosFiltrados.size() - i - 1; j++) {
				long ing1 = ((MenDTO) usuariosFiltrados.get(j)).getMensualIncome();
				long ing2 = ((MenDTO) usuariosFiltrados.get(j + 1)).getMensualIncome();

				if (ing1 < ing2) {
					User temp = usuariosFiltrados.get(j);
					usuariosFiltrados.set(j, usuariosFiltrados.get(j + 1));
					usuariosFiltrados.set(j + 1, temp);
				}
			}
		}

		return usuariosFiltrados;
	}

	/**
	 * Obtiene usuarios filtrados por género
	 * 
	 * @param genero El género a filtrar ("Masculino", "Femenino", o "Todos")
	 * @return Lista de usuarios del género especificado
	 */
	public List<User> obtenerUsuariosPorGenero(String genero) {
		List<User> usuariosFiltrados = new ArrayList<>();

		if (genero == null || genero.equals("Todos")) {
			return obtenerTodosLosUsuarios();
		}

		if (genero.equals("Masculino")) {
			usuariosFiltrados.addAll(mDAO.listaMenDTO);
		} else if (genero.equals("Femenino")) {
			usuariosFiltrados.addAll(wDAO.listaWomenDTO);
		}

		return usuariosFiltrados;
	}

	/**
	 * Calcula la edad promedio de una lista de usuarios
	 */
	public double calcularEdadPromedio(List<User> usuarios) {
		if (usuarios.isEmpty()) {
			return 0;
		}

		double sumaEdades = 0;
		int contadorValidos = 0;

		for (User usuario : usuarios) {
			try {
				int edad = calcularEdadDesdeString(usuario.getBornDate());
				if (edad > 0) {
					sumaEdades += edad;
					contadorValidos++;
				}
			} catch (Exception e) {
				// Ignorar errores
			}
		}

		return contadorValidos > 0 ? sumaEdades / contadorValidos : 0;
	}

	/**
	 * Calcula el ingreso promedio de hombres en una lista
	 */
	public double calcularIngresoPromedio(List<User> usuarios) {
		double sumaIngresos = 0;
		int contador = 0;

		for (User usuario : usuarios) {
			if (usuario instanceof MenDTO) {
				MenDTO hombre = (MenDTO) usuario;
				sumaIngresos += hombre.getMensualIncome();
				contador++;
			}
		}

		return contador > 0 ? sumaIngresos / contador : 0;
	}

	/**
	 * Cuenta cuántas mujeres tienen divorcios en una lista
	 */
	public int contarMujeresConDivorcios(List<User> usuarios) {
		int contador = 0;

		for (User usuario : usuarios) {
			if (usuario instanceof WomenDTO) {
				WomenDTO mujer = (WomenDTO) usuario;
				if (mujer.isHadDivorces()) {
					contador++;
				}
			}
		}

		return contador;
	}

	/**
	 * Cuenta cuántos usuarios hay por género
	 */
	public int contarPorGenero(List<User> usuarios, String genero) {
		int contador = 0;

		for (User usuario : usuarios) {
			if (genero.equals("Masculino") && usuario instanceof MenDTO) {
				contador++;
			} else if (genero.equals("Femenino") && usuario instanceof WomenDTO) {
				contador++;
			}
		}

		return contador;
	}

	/**
	 * Encuentra el país con más usuarios
	 */
	public String encontrarPaisMasUsuarios(List<User> usuarios) {
		if (usuarios.isEmpty()) {
			return "";
		}

		// Crear listas paralelas para países y contadores
		List<String> paises = new ArrayList<>();
		List<Integer> contadores = new ArrayList<>();

		for (User usuario : usuarios) {
			String pais = usuario.getCountry();

			// Buscar si el país ya está en la lista
			int indice = -1;
			for (int i = 0; i < paises.size(); i++) {
				if (paises.get(i).equals(pais)) {
					indice = i;
					break;
				}
			}

			if (indice == -1) {
				// País nuevo, agregarlo
				paises.add(pais);
				contadores.add(1);
			} else {
				// País existente, incrementar contador
				contadores.set(indice, contadores.get(indice) + 1);
			}
		}

		// Encontrar el país con mayor contador
		int maxUsuarios = 0;
		String paisMasUsuarios = "";

		for (int i = 0; i < paises.size(); i++) {
			if (contadores.get(i) > maxUsuarios) {
				maxUsuarios = contadores.get(i);
				paisMasUsuarios = paises.get(i);
			}
		}

		return paisMasUsuarios + " (" + maxUsuarios + ")";
	}

	/**
	 * Calcula edad desde un string de fecha
	 */
	private int calcularEdadDesdeString(String fechaNacimiento) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);
			LocalDate hoy = LocalDate.now();
			return Period.between(fechaNac, hoy).getYears();
		} catch (Exception e) {
			return 0;
		}
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

			/*
			 * @Override public String getProfilePictureRoute() { // Ruta a una imagen
			 * genérica/placeholder return "images/incognito_avatar.png"; }
			 */

			@Override
			public String getStature() {
				return "No especificado";
			}
		};
	}

	// En ModelFacade.java
	public List<User> obtenerUsuariosMasPopulares(int cantidad) {
		List<User> todosLosUsuarios = obtenerTodosLosUsuarios();

		// Ordenar por likes (de mayor a menor)
		for (int i = 0; i < todosLosUsuarios.size() - 1; i++) {
			for (int j = 0; j < todosLosUsuarios.size() - i - 1; j++) {
				int likes1 = todosLosUsuarios.get(j).getLikes();
				int likes2 = todosLosUsuarios.get(j + 1).getLikes();

				if (likes1 < likes2) {
					User temp = todosLosUsuarios.get(j);
					todosLosUsuarios.set(j, todosLosUsuarios.get(j + 1));
					todosLosUsuarios.set(j + 1, temp);
				}
			}
		}

		// Devolver solo la cantidad solicitada
		return todosLosUsuarios.subList(0, Math.min(cantidad, todosLosUsuarios.size()));
	}
}