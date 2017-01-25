package by.htp6.comicsworld.bean.entity;

/**
 * 	The class is used to greate objects with properties
 * 	<b>email</b>, <b>firstPassword</b> and <b>secondPassword</b>
 *  @author Viachaslav Bykov
 *	@version 1.0
 */
public class User {

	/** Propertie <b>idClient</b> content id */
	private int idClient;
	
	/** Propertie <b>email</b>. E-mail user */
	private String email;
	
	/** Propertie <b>firstPassword</b>. First enter password */
	private String firstPassword;
	
	/** Propertie <b>secondPassword</b>. First password confirm */
	private String secondPassword;
	
	private int AccesLevel;

	public int getAccesLevel() {
		return AccesLevel;
	}

	public void setAccesLevel(int accesLevel) {
		AccesLevel = accesLevel;
	}

	/** Get the {@link User#idClient} 
	 * 	@return current user id
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 *  
	 *  @param id {@link#idClient}
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstPassword() {
		return firstPassword;
	}

	public void setFirstPassword(String firstPassword) {
		this.firstPassword = firstPassword;
	}

	public String getSecondPassword() {
		return secondPassword;
	}

	public void setSecondPassword(String secondPassword) {
		this.secondPassword = secondPassword;
	}
	
	
}
