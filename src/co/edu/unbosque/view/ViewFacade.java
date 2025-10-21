package co.edu.unbosque.view;

import co.edu.unbosque.view.*;

public class ViewFacade {

	private StartWindow sw;
	private LoginWindow lw;
	private MapWindow mw;
	private PrincipalWindow pw;
	private SignInPrincipalWindow siw;

	public ViewFacade() {
		lw = new LoginWindow();
		pw = new PrincipalWindow(null);
		mw = new MapWindow();
		sw = new StartWindow();
		siw = new SignInPrincipalWindow();
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

	public SignInPrincipalWindow getSiw() {
		return siw;
	}

	public void setSiw(SignInPrincipalWindow siw) {
		this.siw = siw;
	}

	public PrincipalWindow getMaw() {
		return pw;
	}

	public void setMaw(PrincipalWindow maw) {
		this.pw = maw;
	}
}
