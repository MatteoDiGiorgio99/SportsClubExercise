package it.rossettidigiorgiomonica.circolosportivo;

import java.util.ArrayList;

import it.rossettidigiorgiomonica.circolosportivo.classes.*;

public class main {

	public static void main(String[] args) {
		
	    ArrayList<Person> activityPartecipants = new ArrayList<Person>();
	    
	    Person bambino = new Person("camillo","benso","conte@di","cavour");
	    
	    activityPartecipants.add(bambino);
	    
		Activity course = new Course("hellow world");
		
		for(Person p : activityPartecipants) {
			course.addActivityPartecipant(p);
		}
		
		for(Person p : course.getActivityPartecipants()) {
			System.out.print(p.getname());
		}
	}

}