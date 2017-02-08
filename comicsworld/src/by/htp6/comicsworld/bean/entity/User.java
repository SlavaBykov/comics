package by.htp6.comicsworld.bean.entity;

/**
 * The class is used to greate objects with properties <b>email</b>,
 * <b>firstPassword</b> and <b>secondPassword</b>
 * 
 * @author Viachaslav Bykov
 * @version 1.0
 */
public class User {

	private int idClient;
		
	private String login;

	private String email;

	private String password;

	private String confirmPassword;

	private String AccesLevel;

	public String getAccesLevel() {
		return AccesLevel;
	}

	public void setAccesLevel(String accesLevel) {
		AccesLevel = accesLevel;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String firstPassword) {
		this.password = firstPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String secondPassword) {
		this.confirmPassword = secondPassword;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String lastName) {
		this.login = lastName;
	}

	
}
