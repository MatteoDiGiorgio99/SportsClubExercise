package it.rossettidigiorgiomonica.circolosportivo.classes;

import java.util.ArrayList;

public  class Person {
	private String name;
	private String surname;
	private String email;
	private String psw;
	
	private ArrayList<Person> Users;
	
	public Person(String string, String string2, String string3, String string4) {
		
	}
	protected String getname() { return this.name; }
	protected void setname(String newname) { this.name = newname; }
	
	protected String getsurnme() { return this.surname; }
	protected void setsurname(String newsurname) { this.surname = newsurname; }
	
	protected String getemail() { return this.email; }
	protected void setemail(String newemail) { this.email = newemail; }
	
	protected String getpsw() { return this.psw; }
	protected void setpsw(String newpsw) { this.psw = newpsw; }
	
	protected void addUsers(Person toAdd) { this.Users.add(toAdd); }
	protected void removeUsers(Person toRemove) { this.Users.remove(toRemove); } 


}
