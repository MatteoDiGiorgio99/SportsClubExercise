package it.rossettidigiorgiomonica.circolosportivo.classes;

import java.util.ArrayList;

public  class Person {
	private String name;
	private String surname;
	private String email;
	private String psw;
		
	public Person(String name, String surname, String email, String psw) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.psw = psw;
	}
	
	public String getname() { return this.name; }
	public void setname(String newname) { this.name = newname; }
	
	public String getsurnme() { return this.surname; }
	public void setsurname(String newsurname) { this.surname = newsurname; }
	
	public String getemail() { return this.email; }
	public void setemail(String newemail) { this.email = newemail; }
	
	public String getpsw() { return this.psw; }
	public void setpsw(String newpsw) { this.psw = newpsw; }
}