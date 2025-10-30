package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

public class Women extends User implements Serializable {

	private boolean hadDivorces;
	private Properties prop;

	public Women() {
	}

	public Women(boolean hadDivorces, Properties prop) {
		super();
		this.hadDivorces = hadDivorces;
		this.prop = prop;
	}

	public Women(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password,
			boolean hadDivorces, Properties prop) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
		this.hadDivorces = hadDivorces;
		this.prop = prop;
	}

	public Women(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
	}

	public boolean isHadDivorces() {
		return hadDivorces;
	}

	public void setHadDivorces(boolean hadDivorces) {
		this.hadDivorces = hadDivorces;
	}

	public void internacionalizacion(Properties prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return super.toString() + "\n Had divorces: " + hadDivorces + "\n==========================================";
	}

}
