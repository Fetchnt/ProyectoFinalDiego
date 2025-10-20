package co.edu.unbosque.view;

import co.edu.unbosque.view.*;

public class ViewFacade {

	private StartWindow sw;
	private LoginWindow lw;
	private MapWindow mw;
	private SignInWindow siw;

	public ViewFacade() {
		lw = new LoginWindow();
		mw = new MapWindow();
		sw = new StartWindow();
		siw = new SignInWindow();
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

	public SignInWindow getSiw() {
		return siw;
	}

	public void setSiw(SignInWindow siw) {
		this.siw = siw;
	}
}
