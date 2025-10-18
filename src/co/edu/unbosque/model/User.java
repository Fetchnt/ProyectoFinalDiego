package co.edu.unbosque.model;

public abstract class User {

	private String name;
	private String lastName;
	private String alias;
	private byte age;
	private float stature;
	private String email;
	private String gender;
	private String sexualOrientation;
	private String profilePictureRoute;
	private String country;
	
	public User() {
		super();
	}

	public User(String name, String lastName, String alias, byte age, float stature, String email, String gender,
			String sexualOrientation, String profilePictureRoute, String country) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.alias = alias;
		this.age = age;
		this.stature = stature;
		this.email = email;
		this.gender = gender;
		this.sexualOrientation = sexualOrientation;
		this.profilePictureRoute = profilePictureRoute;
		this.country = country;
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

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public float getStature() {
		return stature;
	}

	public void setStature(float stature) {
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

	@Override
	public String toString() {
		return "==========================================\n - Name: " + name + "\n - last Name: " + lastName + "\n - Alias" + alias + "\n -  Age: " + age + "\n - Stature: "
				+ stature + "\n - Email: " + email + "\n - Gender: " + gender + "\n - Sexual Orientation: " + sexualOrientation
				+ " \n - Country: " + country ;
	}	
}
