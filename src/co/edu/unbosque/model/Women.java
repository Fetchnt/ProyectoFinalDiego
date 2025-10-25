package co.edu.unbosque.model;

import java.io.Serializable;

public class Women extends User implements Serializable{

	private boolean hadDivorces;

	public Women() {
		super();
	}

	public Women(boolean hadDivorces) {
		super();
		this.hadDivorces = hadDivorces;
	}

	public Women(String name, String lastName, String alias, byte age, String stature, String email, String gender,
			String sexualOrientation, String profilePictureRoute, String country, boolean hadDivorces) {
		super(name, lastName, alias, age, stature, email, gender, sexualOrientation, profilePictureRoute, country);
		this.hadDivorces = hadDivorces;
	}

	public Women(String name, String lastName, String alias, byte age, String stature, String email, String gender,
			String sexualOrientation, String profilePictureRoute, String country) {
		super(name, lastName, alias, age, stature, email, gender, sexualOrientation, profilePictureRoute, country);
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
