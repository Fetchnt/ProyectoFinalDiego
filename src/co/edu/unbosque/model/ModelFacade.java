package co.edu.unbosque.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import co.edu.unbosque.model.persistence.MenDAO;
import co.edu.unbosque.model.persistence.WomenDAO;

/**
 * Fachada que centraliza la lógica de negocio del modelo. <b>pre:</b> Deben
 * existir objetos DAO válidos para gestionar usuarios. <br>
 * <b>post:</b> Proporciona una interfaz unificada para operaciones de usuarios,
 * perfiles, likes y estadísticas.
 * 
 */
public class ModelFacade {

	/** Objeto de acceso a datos para usuarios femeninos. */
	private WomenDAO wDAO;

	/** Objeto de acceso a datos para usuarios masculinos. */
	private MenDAO mDAO;

	/** Lista de perfiles disponibles para visualización. */
	private List<User> perfilesActuales;

	/** Índice del perfil actual que se está mostrando. */
	private int indiceActual = 0;

	/** Lista de usuarios que han recibido like. */
	private List<User> likes;

	/** Indica si el modo incógnito está activo. */
	private boolean modoIncognito;

	/** Usuario que ha iniciado sesión actualmente. */
	private User usuarioActual;

	/**
	 * Constructor por defecto que inicializa los DAOs y las listas de gestión.
	 */
	public ModelFacade() {
		mDAO = new MenDAO();
		wDAO = new WomenDAO();
		perfilesActuales = new ArrayList<User>();
		likes = new ArrayList<User>();
		modoIncognito = false;
	}

	// === GETTERS Y SETTERS ===

	/**
	 * Obtiene el DAO de usuarios femeninos.
	 * 
	 * @return Objeto WomenDAO.
	 */
	public WomenDAO getwDAO() {
		return wDAO;
	}

	/**
	 * Asigna el DAO de usuarios femeninos.
	 * 
	 * @param wDAO Objeto WomenDAO a asignar.
	 */
	public void setwDAO(WomenDAO wDAO) {
		this.wDAO = wDAO;
	}

	/**
	 * Obtiene el DAO de usuarios masculinos.
	 * 
	 * @return Objeto MenDAO.
	 */
	public MenDAO getmDAO() {
		return mDAO;
	}

	/**
	 * Asigna el DAO de usuarios masculinos.
	 * 
	 * @param mDAO Objeto MenDAO a asignar.
	 */
	public void setmDAO(MenDAO mDAO) {
		this.mDAO = mDAO;
	}

	/**
	 * Verifica si el modo incógnito está activo.
	 * 
	 * @return {@code true} si está en modo incógnito, {@code false} en caso
	 *         contrario.
	 */
	public boolean isModoIncognito() {
		return modoIncognito;
	}

	/**
	 * Asigna el estado del modo incógnito.
	 * 
	 * @param modoIncognito Valor booleano para activar o desactivar el modo
	 *                      incógnito.
	 */
	public void setModoIncognito(boolean modoIncognito) {
		this.modoIncognito = modoIncognito;
	}

	/**
	 * Obtiene el usuario que ha iniciado sesión actualmente.
	 * 
	 * @return Objeto User del usuario actual.
	 */
	public User getUsuarioActual() {
		return usuarioActual;
	}

	/**
	 * Asigna el usuario que ha iniciado sesión actualmente.
	 * 
	 * @param usuarioActual Objeto User del usuario actual.
	 */
	public void setUsuarioActual(User usuarioActual) {
		this.usuarioActual = usuarioActual;
	}
	

	public List<User> getPerfilesActuales() {
		return perfilesActuales;
	}

	public void setPerfilesActuales(List<User> perfilesActuales) {
		this.perfilesActuales = perfilesActuales;
	}

	public int getIndiceActual() {
		return indiceActual;
	}

	public void setIndiceActual(int indiceActual) {
		this.indiceActual = indiceActual;
	}
	// === MÉTODOS DE USUARIOS Y PAÍSES ===

	/**
	 * Obtiene todos los usuarios que pertenecen a un país específico.
	 * 
	 * @param pais Nombre del país a filtrar.
	 * @return Lista de usuarios del país especificado.
	 */
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

	/**
	 * Carga las propiedades de internacionalización en los DAOs.
	 * 
	 * @param prop Propiedades de idioma o configuración.
	 */
	public void cargarProperties(Properties prop) {
		mDAO.internacionalizacion(prop);
		wDAO.internacionalizacion(prop);
	}

	/**
	 * Valida las credenciales de inicio de sesión de un usuario.
	 * 
	 * @param userAlias Alias del usuario.
	 * @param email     Correo electrónico del usuario.
	 * @param password  Contraseña del usuario.
	 * @return {@code true} si las credenciales son válidas, {@code false} en caso
	 *         contrario.
	 */
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

	/**
	 * Obtiene un usuario específico por su alias.
	 * 
	 * @param alias Alias del usuario a buscar.
	 * @return Objeto User encontrado, o {@code null} si no existe.
	 */
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

	/**
	 * Carga todos los perfiles disponibles sin excluir ningún usuario.
	 */
	public void cargarPerfiles() {
		cargarPerfiles(null);
	}

	/**
	 * Carga todos los perfiles disponibles, excluyendo opcionalmente un usuario
	 * específico.
	 * 
	 * @param usuarioExcluir Usuario a excluir de la lista de perfiles, o
	 *                       {@code null} para no excluir ninguno.
	 */
	public void cargarPerfiles(User usuarioExcluir) {
		perfilesActuales.clear();

		// Agregar hombres (excluyendo al usuario actual si se especifica)
		for (MenDTO hombre : mDAO.listaMenDTO) {
			if (usuarioExcluir == null || !hombre.getAlias().equals(usuarioExcluir.getAlias())) {
				perfilesActuales.add(hombre);
			}
		}

		// Agregar mujeres (excluyendo al usuario actual si se especifica)
		for (WomenDTO mujer : wDAO.listaWomenDTO) {
			if (usuarioExcluir == null || !mujer.getAlias().equals(usuarioExcluir.getAlias())) {
				perfilesActuales.add(mujer);
			}
		}

		indiceActual = 0;
	}

	/**
	 * Obtiene el perfil que se está visualizando actualmente.
	 * 
	 * @return Objeto User del perfil actual, o {@code null} si no hay más perfiles.
	 */
	public User getPerfilActual() {
		if (indiceActual < perfilesActuales.size()) {
			return perfilesActuales.get(indiceActual);
		}
		return null;
	}

	/**
	 * Avanza al siguiente perfil disponible en la lista.
	 */
	public void siguientePerfil() {
		if (perfilesActuales.isEmpty()) {
			indiceActual = 0;
			return;
		}

		if (indiceActual < perfilesActuales.size() - 1) {
			indiceActual++;

			User siguiente = perfilesActuales.get(indiceActual);
			if (usuarioActual != null && siguiente.getAlias().equals(usuarioActual.getAlias())) {
				siguientePerfil();
			}
		} else {
			indiceActual = perfilesActuales.size();
		}
	}

	/**
	 * Agrega un like al perfil actual y actualiza el contador de likes.
	 */
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

	/**
	 * Obtiene la cantidad de likes que tiene un usuario específico.
	 * 
	 * @param alias Alias del usuario.
	 * @return Cantidad de likes del usuario, o 0 si no se encuentra.
	 */
	public int obtenerLikesUsuario(String alias) {
		User usuario = buscarUsuarioPorAlias(alias);
		return usuario != null ? usuario.getLikes() : 0;
	}

	/**
	 * Obtiene la lista de usuarios que han recibido like.
	 * 
	 * @return Lista de usuarios con like.
	 */
	public List<User> getLikes() {
		return likes;
	}

	// === MÉTODOS DE ADMINISTRACIÓN ===

	/**
	 * Obtiene todos los usuarios registrados en el sistema.
	 * 
	 * @return Lista con todos los usuarios masculinos y femeninos.
	 */
	public List<User> obtenerTodosLosUsuarios() {
		List<User> todosLosUsuarios = new ArrayList<>();
		todosLosUsuarios.addAll(mDAO.listaMenDTO);
		todosLosUsuarios.addAll(wDAO.listaWomenDTO);
		return todosLosUsuarios;
	}

	/**
	 * Elimina un usuario del sistema por su alias.
	 * 
	 * @param alias Alias del usuario a eliminar.
	 * @return {@code true} si el usuario fue eliminado, {@code false} si no se
	 *         encontró.
	 */
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

	/**
	 * Busca un usuario específico por su alias.
	 * 
	 * @param alias Alias del usuario a buscar.
	 * @return Objeto User encontrado, o {@code null} si no existe.
	 */
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
	 * Retorna un usuario con datos ocultos si está en modo incógnito.
	 * 
	 * @param usuarioOriginal Usuario original a procesar.
	 * @return Usuario con datos ocultos si aplica modo incógnito, o el usuario
	 *         original.
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
	 * Obtiene el perfil actual para mostrar con lógica de incógnito aplicada.
	 * 
	 * @return Usuario para mostrar con datos ocultos si aplica.
	 */
	public User getPerfilActualParaMostrar() {
		User perfilActual = getPerfilActual();
		return getPerfilParaMostrar(perfilActual);
	}

	/**
	 * Obtiene los usuarios ordenados por ingresos solo hombres con ingresos mayores
	 * o iguales al umbral.
	 * 
	 * @param umbralIngresos El umbral mínimo de ingresos.
	 * @return Lista de hombres que cumplen con el criterio ordenados de mayor a
	 *         menor ingreso.
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
	 * Obtiene usuarios filtrados por género.
	 * 
	 * @param genero El género a filtrar ("Masculino", "Femenino", o "Todos").
	 * @return Lista de usuarios del género especificado.
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
	 * Calcula la edad promedio de una lista de usuarios.
	 * 
	 * @param usuarios Lista de usuarios para calcular el promedio.
	 * @return Edad promedio calculada, o 0 si no hay usuarios válidos.
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
	 * Calcula el ingreso promedio de hombres en una lista.
	 * 
	 * @param usuarios Lista de usuarios para calcular el promedio.
	 * @return Ingreso promedio calculado, o 0 si no hay hombres en la lista.
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
	 * Cuenta cuántas mujeres tienen divorcios en una lista.
	 * 
	 * @param usuarios Lista de usuarios a analizar.
	 * @return Cantidad de mujeres con divorcios.
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
	 * Cuenta cuántos usuarios hay por género.
	 * 
	 * @param usuarios Lista de usuarios a analizar.
	 * @param genero   Género a contar ("Masculino" o "Femenino").
	 * @return Cantidad de usuarios del género especificado.
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
	 * Encuentra el país con más usuarios.
	 * 
	 * @param usuarios Lista de usuarios a analizar.
	 * @return Cadena con el nombre del país y cantidad de usuarios, o cadena vacía
	 *         si no hay usuarios.
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
	 * Calcula edad desde un string de fecha.
	 * 
	 * @param fechaNacimiento Fecha de nacimiento en formato dd/MM/yyyy.
	 * @return Edad calculada en años, o 0 si hay error en el formato.
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
	 * Crea una versión con datos ocultos del usuario.
	 * 
	 * @param usuarioOriginal Usuario original cuyos datos se ocultarán.
	 * @return Usuario anónimo con datos genéricos.
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

	/**
	 * Obtiene los usuarios más populares según su cantidad de likes.
	 * 
	 * @param cantidad Número máximo de usuarios a retornar.
	 * @return Lista de usuarios más populares ordenados de mayor a menor cantidad
	 *         de likes.
	 */
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