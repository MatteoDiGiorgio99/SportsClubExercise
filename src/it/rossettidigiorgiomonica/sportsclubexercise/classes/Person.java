package it.rossettidigiorgiomonica.sportsclubexercise.classes;

/**
 * The {@code Person} class defines a behavior that:
 * 
 * Defines the member of the sport club
 * 
 * @author 297402
 *
 */
public  class Person {
	private String name;
	private String surname;
	private String email;
	private String password;
	private Role role;
	
	/**
	 * Class constructor 
	 * 
	 * @param name the member name
	 * @param surname the member surname
	 * @param email the member email
	 * @param password the member password
	 * @param role the member {@code Role}
	 */
	public Person(String name, String surname, String email, String password, Role role) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	/**
	 * Allows the user to fetch the member name.
	 * 
	 * @return
	 * 
	 * The member name
	 */
	public String getName() { return this.name; }
	
	/**
	 * Permit to modify the member name
	 * 
	 * @param newName
	 * @throws IllegalAccessException in case the string is empty or it doesn't exist
	 */
	public void setName(String newName) throws IllegalAccessException{if(newName != null && newName.isEmpty() == false ) this.name = newName;else throw new IllegalAccessException();}
	
	/**
	 * Allows the user to fetch the member surname.
	 * 
	 * @return
	 * 
	 * The member surname
	 */
	public String getSurname() { return this.surname; }
	
	/**
	 * Permit to modify the member surname
	 * 
	 * @param newSurname
	 * @throws IllegalAccessException in case the string is empty or it doesn't exist
	 */
	public void setSurname(String newSurname) throws IllegalAccessException{if(newSurname != null && newSurname.isEmpty() == false ) this.surname = newSurname;else throw new IllegalAccessException();}
	
	
	/**
	 * Allows the user to fetch the member email.
	 * 
	 * @return
	 * 
	 * The member email
	 */
	public String getEmail() { return this.email; }
	
	/**
	 * Permit to modify the member email
	 * 
	 * @param newEmail
	 * @throws IllegalAccessException in case the string is empty or it doesn't exist
	 */
	public void setEmail(String newEmail) throws IllegalAccessException{if(newEmail != null && newEmail.isEmpty() == false ) this.email = newEmail;else throw new IllegalAccessException();}
	
	/**
	 * Allows the user to fetch the member password.
	 * 
	 * @return
	 * 
	 * The member password
	 */
	public String getPassword() { return this.password; }
	
	/**
	 * Permit to modify the member password
	 * 
	 * @param newPassword
	 * @throws IllegalAccessException in case the string is empty or it doesn't exist
	 */
	public void setPassword(String newPassword) throws IllegalAccessException{if(newPassword != null && newPassword.isEmpty() == false ) this.password = newPassword;else throw new IllegalAccessException();}
	/**
	 * Allows the user to fetch the member role.
	 * 
	 * @return
	 * 
	 * The member role
	 */
	public Role getRole() { return this.role; }
	
	/**
	 * Permit to modify the member role
	 * 
	 * @param newRole
	 * @throws IllegalAccessException in case it doesn't exist
	 */
	public void setRole(Role newRole) throws IllegalAccessException { if(newRole != null) this.role = newRole; else throw new IllegalAccessException();}
}