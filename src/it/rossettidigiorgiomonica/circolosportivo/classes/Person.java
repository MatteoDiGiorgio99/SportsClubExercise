package it.rossettidigiorgiomonica.circolosportivo.classes;



public  class Person {
	private String name;
	private String surname;
	private String email;
	private String psw;
	
	private Role role;
	
	public Person(String name, String surname, String email, String psw,Role rol) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.psw = psw;
		this.role=rol;
	}
	
	public String getname() { return this.name; }
	public void setname(String newname) { this.name = newname; }
	
	public String getsurnme() { return this.surname; }
	public void setsurname(String newsurname) { this.surname = newsurname; }
	
	public String getemail() { return this.email; }
	public void setemail(String newemail) { this.email = newemail; }
	
	public String getpsw() { return this.psw; }
	public void setpsw(String newpsw) { this.psw = newpsw; }
	
	public Role getrole() { return this.role; }
	public void setRole(Role rr) {this.role=rr;}
}