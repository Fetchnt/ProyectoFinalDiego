package co.edu.unbosque.view;

import java.util.Properties;

import co.edu.unbosque.model.ModelFacade;

public class ViewFacade {

	private StartWindow sw;
	private LoginWindow lw;
	private MapWindow mw;
	private PrincipalWindow pw;
	private RegisterWindow rw;
	private MainWindow mmw;
	private ModelFacade model;

	public ViewFacade(ModelFacade model) {
		this.model = model;

		lw = new LoginWindow();
		pw = new PrincipalWindow();
		mw = new MapWindow(model);
		sw = new StartWindow();
		rw = new RegisterWindow();
		mmw = new MainWindow();
	}
	
	/*public void aplicarInternacionalizacion(Properties prop) {
        sw.aplicarInternacionalizacion(prop);
        lw.aplicarInternacionalizacion(prop);
        mw.aplicarInternacionalizacion(prop);
        pw.aplicarInternacionalizacion(prop);
        rw.aplicarInternacionalizacion(prop);
        mmw.aplicarInternacionalizacion(prop);
    }*/

	public ModelFacade getModel() {
		return model;
	}

	public void setModel(ModelFacade model) {
		this.model = model;
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
	

}
