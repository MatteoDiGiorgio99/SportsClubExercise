package it.rossettidigiorgiomonica.circolosportivo.classes;

public  class Person {
	private String name;
	private String surname;
	private String email;
	private String password;
	
	private Role role;
	
	public Person(String name, String surname, String email, String password, Role role) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public String getName() { return this.name; }
	public void setName(String newName) { this.name = newName; }
	
	public String getSurname() { return this.surname; }
	public void setSurname(String newSurname) { this.surname = newSurname; }
	
	public String getEmail() { return this.email; }
	public void setEmail(String newEmail) { this.email = newEmail; }
	
	public String getPassword() { return this.password; }
	public void setPassword(String newPassword) { this.password = newPassword; }
	
	public Role getRole() { return this.role; }
	public void setRole(Role newRole) { this.role = newRole; }
}