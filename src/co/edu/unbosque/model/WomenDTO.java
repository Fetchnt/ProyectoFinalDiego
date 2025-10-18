package co.edu.unbosque.model;

public class WomenDTO extends User {

	private boolean hadDivorces;

	public WomenDTO() {
		super();
	}

	public WomenDTO(boolean hadDivorces) {
		super();
		this.hadDivorces = hadDivorces;
	}

	public WomenDTO(String name, String lastName, String alias, byte age, float stature, String email, String gender,
			String sexualOrientation, String profilePictureRoute, String country, boolean hadDivorces) {
		super(name, lastName, alias, age, stature, email, gender, sexualOrientation, profilePictureRoute, country);
		this.hadDivorces = hadDivorces;
	}

	public WomenDTO(String name, String lastName, String alias, byte age, float stature, String email, String gender,
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
