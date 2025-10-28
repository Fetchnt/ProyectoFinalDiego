package co.edu.unbosque.model;

import java.io.Serializable;

public class Men extends User implements Serializable {

	private long mensualIncome;

	public Men() {
		super();
	}

	public Men(long mensualIncome) {
		super();
		this.mensualIncome = mensualIncome;
	}

	public Men(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password,
			long mensualIncome) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
		this.mensualIncome = mensualIncome;
	}

	public Men(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
		// TODO Auto-generated constructor stub
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
