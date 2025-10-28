package co.edu.unbosque.model;

import java.io.Serializable;

public class WomenDTO extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2239763327417958409L;
	private boolean hadDivorces;

	public WomenDTO() {
		super();
	}

	public WomenDTO(boolean hadDivorces) {
		super();
		this.hadDivorces = hadDivorces;
	}

	public WomenDTO(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password,
			boolean hadDivorces) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
		this.hadDivorces = hadDivorces;
	}

	public WomenDTO(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
		// TODO Auto-generated constructor stub
	}

	public boolean isHadDivorces() {
		return hadDivorces;
	}

	public void setHadDivorces(boolean hadDivorces) {
		this.hadDivorces = hadDivorces;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Had divorces: " + hadDivorces + "\n==========================================";
	}

}
