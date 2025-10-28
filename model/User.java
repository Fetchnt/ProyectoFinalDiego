package co.edu.unbosque.model;

public abstract class User {

	private String name;
	private String lastName;
	private String alias;
	private String bornDate;
	private String stature;
	private String email;
	private String gender;
	private String sexualOrientation;
	private String profilePictureRoute;
	private String country;
	private String password;
	
	public User() {
		super();
	}
	public User(String name, String lastName, String alias, String bornDate, String stature, String email,
			String gender, String sexualOrientation, String profilePictureRoute, String country, String password) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.alias = alias;
		this.bornDate = bornDate;
		this.stature = stature;
		this.email = email;
		this.gender = gender;
		this.sexualOrientation = sexualOrientation;
		this.profilePictureRoute = profilePictureRoute;
		this.country = country;
		this.password = password;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAlias() {
		return alias;
	}


	public void setAlias(String alias) {
		this.alias = alias;
	}


	public String getBornDate() {
		return bornDate;
	}


	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}


	public String getStature() {
		return stature;
	}


	public void setStature(String stature) {
		this.stature = stature;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getSexualOrientation() {
		return sexualOrientation;
	}


	public void setSexualOrientation(String sexualOrientation) {
		this.sexualOrientation = sexualOrientation;
	}


	public String getProfilePictureRoute() {
		return profilePictureRoute;
	}


	public void setProfilePictureRoute(String profilePictureRoute) {
		this.profilePictureRoute = profilePictureRoute;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "==========================================\n - Name: " + name + "\n - last Name: " + lastName + "\n - Nickname" + alias + "\n -  Born Date: " + bornDate + "\n - Stature: "
				+ stature + "\n - Email: " + email + "\n - Gender: " + gender + "\n - Sexual Orientation: " + sexualOrientation
				+ " \n - Country: " + country + "\n - Password" + password ;
	}	
}
