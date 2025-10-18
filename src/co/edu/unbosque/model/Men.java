package co.edu.unbosque.model;

public class Men extends User {

	private long mensualIncome;

	public Men() {
		super();
	}

	public Men(long mensualIncome) {
		super();
		this.mensualIncome = mensualIncome;
	}

	public Men(String name, String lastName, String alias, byte age, float stature, String email, String gender,
			String sexualOrientation, String profilePictureRoute, String country, long mensualIncome) {
		super(name, lastName, alias, age, stature, email, gender, sexualOrientation, profilePictureRoute, country);
		this.mensualIncome = mensualIncome;
	}

	public Men(String name, String lastName, String alias, byte age, float stature, String email, String gender,
			String sexualOrientation, String profilePictureRoute, String country) {
		super(name, lastName, alias, age, stature, email, gender, sexualOrientation, profilePictureRoute, country);
	}

	public long getMensualIncome() {
		return mensualIncome;
	}

	public void setMensualIncome(long mensualIncome) {
		this.mensualIncome = mensualIncome;
	}

	@Override
	public String toString() {
		return super.toString() + "\n - Mensual Income" + mensualIncome + "\n==========================================";
	}
	
	
	
}
