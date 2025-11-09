package co.edu.unbosque.view;

import java.util.Properties;

public class ViewFacade {

	private StartWindow sw;
	private LoginWindow lw;
	private MapWindow mw;
	private MapUserWindow uw;
	private PrincipalWindow pw;
	private RegisterWindow rw;
	private MainWindow mmw;
	private AdminWindow aw;
	private MyProfileWindow mpw;


	
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
	}

	public void aplicarInternacionalizacion(Properties prop) {
		sw.aplicarInternacionalizacion(prop);
		lw.aplicarInternacionalizacion(prop);
		pw.aplicarInternacionalizacion(prop);
		rw.aplicarInternacionalizacion(prop);
		mmw.aplicarInternacionalizacion(prop);
		aw.aplicarInternacionalizacion(prop);
		mpw.aplicarInternacionalizacion(prop);
	}

	

	public StartWindow getSw() {
		return sw;
	}

	public void setSw(StartWindow sw) {
		this.sw = sw;
	}

	public LoginWindow getLw() {
		return lw;
	}

	public void setLw(LoginWindow lw) {
		this.lw = lw;
	}

	public MapWindow getMw() {
		return mw;
	}

	public void setMw(MapWindow mw) {
		this.mw = mw;
	}

	public MapUserWindow getUw() {
		return uw;
	}

	public void setUw(MapUserWindow uw) {
		this.uw = uw;
	}

	public PrincipalWindow getPw() {
		return pw;
	}

	public void setPw(PrincipalWindow pw) {
		this.pw = pw;
	}

	public RegisterWindow getRw() {
		return rw;
	}

	public void setRw(RegisterWindow rw) {
		this.rw = rw;
	}

	public MainWindow getMmw() {
		return mmw;
	}

	public void setMmw(MainWindow mmw) {
		this.mmw = mmw;
	}

	public AdminWindow getAw() {
		return aw;
	}

	public void setAw(AdminWindow aw) {
		this.aw = aw;
	}

	public MyProfileWindow getMpw() {
		return mpw;
	}

	public void setMpw(MyProfileWindow mpw) {
		this.mpw = mpw;
	}
	
	

}
