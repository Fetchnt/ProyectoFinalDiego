package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Properties;

public class MenDTO extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8703244232885622082L;
	private long mensualIncome;
	private Properties prop;

	public MenDTO() {
		super();
	}

	public MenDTO(long mensualIncome, Properties prop) {
		super();
		this.mensualIncome = mensualIncome;
		this.prop = prop;
	}

	public MenDTO(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password,
			long mensualIncome, Properties prop) {
		super(name, lastName, alias, bornDate, stature, email, gender, sexualOrientation, profilePictureRoute, country,
				password);
		this.mensualIncome = mensualIncome;
		this.prop = prop;
	}

	public MenDTO(String name, String lastName, String alias, String bornDate, String stature, String email,
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

	public void internacionalizacion(Properties prop) {
		this.prop = prop;
	}

	@Override
	public String toString() {
		return super.toString() + "\n - Mensual Income" + mensualIncome
				+ "\n==========================================";
	}

}
