package co.edu.unbosque.view;

import java.util.Properties;


/**
 * Clase que se usa para la gestion de las diferentes ventanas de la
 * interfaz grafica del sistema.
 * 
 * <p>
 * Centraliza el acceso y configuracion de las vistas, permitiendo
 * aplicar configuraciones globales como internacionalizacion y modo oscuro.
 * </p>
 * 
 * <p>
 * Esta clase facilita la interaccion entre el controlador y las vistas, 
 * encapsulando la logica de inicializacion y configuracion de cada ventana.
 * </p>
 * 
 * Autor: Maria Alejandra Carvajal Nepta.
 */
public class ViewFacade {

	// instancia de las ventanas de la aplicacion
	private StartWindow sw;
	private LoginWindow lw;
	private MapWindow mw;
	private MapUserWindow uw;
	private PrincipalWindow pw;
	private RegisterWindow rw;
	private MainWindow mmw;
	private AdminWindow aw;
	private MyProfileWindow mpw;
	private PreferencesWindow prefw;


	/**
	 * Constructor por defecto
	 * 
	 * @pre Ninguna ventana ha sido inicializada.
	 * @post Todas las ventanas se inicializan y estan listas para su uso.
	 */
	public ViewFacade() {
		lw = new LoginWindow();
		pw = new PrincipalWindow();
		mw = new MapWindow();
		uw = new MapUserWindow();
		sw = new StartWindow();
		rw = new RegisterWindow();
		mmw = new MainWindow();
		mpw = new MyProfileWindow();
		aw = new AdminWindow();
		prefw = new PreferencesWindow();
		
	}
	
	/**
	 * Aplica la configuracion de internaconalizacion a todaas las ventanas.
	 * 
	 * @param prop Propiedades que contienen los textos traducidos por idioma.
	 * @pre Las propiedades deben estar correctamente cargadas
	 * @post Todas las ventanan reflejan el idioma de los textos en el idioma
	 * especificado.
	 */

	public void aplicarInternacionalizacion(Properties prop) {
		sw.aplicarInternacionalizacion(prop);
		lw.aplicarInternacionalizacion(prop);
		pw.aplicarInternacionalizacion(prop);
		rw.aplicarInternacionalizacion(prop);
		mmw.aplicarInternacionalizacion(prop);
		mpw.aplicarInternacionalizacion(prop);
		prefw.aplicarInternacionalizacion(prop);
		aw.aplicarInternacionalizacion(prop);
		uw.aplicarInternacionalizacion(prop);
		mw.aplicarInternacionalizacion(prop);
	}
	
	/**
	 * Aplica el modo oscuro a todas las ventanas compatibles.
	 * 
	 * @pre Las ventanas deben estar inicializadas.
	 * @post Las ventanas cambian su apariencia al modo oscuro.
	 */
	
	public void aplicarModoOscuro() {
		sw.cambiarAModoOscuroSW();
		lw.cambiarAModoOscuroLW();
		rw.cambiarAModoOscuroRW();
		pw.cambiarAModoOscuroPW();
		mw.cambiarAModoOscuroMpW();
		mmw.cambiarAModoOscuroMW();
		mpw.cambiarAModoOscuroMPW();
		prefw.cambiarAModoOscuroSW();
		aw.cambiarAModoOscuroSW();
		
		
	}
	
	// Getters y setters para cada ventana.
	
	/**
	 * @return Instancia de StratWindow
	 */
	public StartWindow getSw() {
		return sw;
	}
	
	/**
	 * 
	 * @param sw Instancia de StratWindow para asignar.
	 */

	public void setSw(StartWindow sw) {
		this.sw = sw;
	}
	
	/**
	 * 
	 * @return Instancia de LoginWindow.
	 */
	public LoginWindow getLw() {
		return lw;
	}
	
	/**
	 * @param lw Instancia de LoginWindow para asignar.
	 */

	public void setLw(LoginWindow lw) {
		this.lw = lw;
	}
	
	/**
	 * @return Instancia de MapWindow.
	 */

	public MapWindow getMw() {
		return mw;
	}
	
	/**
	 * @param mw Instancia de MapWindow a asignar.
	 */

	public void setMw(MapWindow mw) {
		this.mw = mw;
	}
	
	/**
	 * @return Instancia de MapUserWindow
	 */

	public MapUserWindow getUw() {
		return uw;
	}
	
	/**
	 * 
	 * @param uw Instancia de MapUserWindow a asignar.
	 */

	public void setUw(MapUserWindow uw) {
		this.uw = uw;
	}
	
	/**
	 * @return Instancia de PrincipalWindow.
	 */

	public PrincipalWindow getPw() {
		return pw;
	}
	
	/**
	 * @param pw Instancia de PrincipalWindow  asignar.
	 */

	public void setPw(PrincipalWindow pw) {
		this.pw = pw;
	}
	
	/** 
	 * @return  Instancia de RegisterWindow.
	 */

	public RegisterWindow getRw() {
		return rw;
	}
	
	/**
	 * @param rw Instancia de RegisterWindow a asignar.
	 */

	public void setRw(RegisterWindow rw) {
		this.rw = rw;
	}
	
	/**
	 * @return Instancia de MainWindow
	 */

	public MainWindow getMmw() {
		return mmw;
	}
	
	/**
	 * @param mmw Instancia de MainWindow a asignar
	 */

	public void setMmw(MainWindow mmw) {
		this.mmw = mmw;
	}
	
	/**
	 * @return Instancia de AdminWindow.
	 */

	public AdminWindow getAw() {
		return aw;
	}
	
	/**
	 * @param aw Instancia de AdminWindow a asignar.
	 */

	public void setAw(AdminWindow aw) {
		this.aw = aw;
	}
	
	/**
	 * @return Instancia de MyProfileWindow.
	 */

	public MyProfileWindow getMpw() {
		return mpw;
	}
	
	/**
	 * @param mpw Instancia de MyProfileWindow a asignar.
	 */

	public void setMpw(MyProfileWindow mpw) {
		this.mpw = mpw;
	}
	
	/**
	 * @return Instancia de PreferenceWindow.
	 */

	public PreferencesWindow getPrefw() {
		return prefw;
	}
	
	/**
	 * 
	 * @param prefw Instancia de PreferenceWindow a asignar.
	 */

	public void setPrefw(PreferencesWindow prefw) {
		this.prefw = prefw;
	}
	
	

}