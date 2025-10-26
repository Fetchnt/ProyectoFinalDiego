package co.edu.unbosque.view;

import co.edu.unbosque.model.ModelFacade;

public class ViewFacade {

	private StartWindow sw;
	private LoginWindow lw;
	private MapWindow mw;
	private PrincipalWindow pw;
	private RegisterWindow rw;
	private ModelFacade model;

	public ViewFacade(ModelFacade model) {
		this.model = model;

		lw = new LoginWindow();
		pw = new PrincipalWindow();
		mw = new MapWindow(model);
		sw = new StartWindow();
		rw = new RegisterWindow();
	}

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

}
