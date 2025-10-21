package co.edu.unbosque.view;

import co.edu.unbosque.view.*;

public class ViewFacade {

	private StartWindow sw;
	private LoginWindow lw;
	private MapWindow mw;
	private PrincipalWindow pw;
	private SignInPrincipalWindow siw;
	private SignInMenWindow simw;
	private SignInWomanWindow siww;

	public ViewFacade() {
		lw = new LoginWindow();
		pw = new PrincipalWindow();
		mw = new MapWindow();
		sw = new StartWindow();
		siw = new SignInPrincipalWindow();
		simw = new SignInMenWindow();
		siww = new SignInWomanWindow();
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

	public SignInPrincipalWindow getSiw() {
		return siw;
	}

	public void setSiw(SignInPrincipalWindow siw) {
		this.siw = siw;
	}

	public SignInMenWindow getSimw() {
		return simw;
	}

	public void setSimw(SignInMenWindow simw) {
		this.simw = simw;
	}

	public SignInWomanWindow getSiww() {
		return siww;
	}

	public void setSiww(SignInWomanWindow siww) {
		this.siww = siww;
	}

}
