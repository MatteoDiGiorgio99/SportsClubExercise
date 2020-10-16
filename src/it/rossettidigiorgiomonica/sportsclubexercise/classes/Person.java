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
	 */
	public void setName(String newName) { this.name = newName; }
	
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
	 */
	public void setSurname(String newSurname) { this.surname = newSurname; }
	
	
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
	 */
	public void setEmail(String newEmail) { this.email = newEmail; }
	
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
	 */
	public void setPassword(String newPassword) { this.password = newPassword; }
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
	 */
	public void setRole(Role newRole) { this.role = newRole; }
}