package it.rossettidigiorgiomonica.circolosportivo;

import java.util.ArrayList;

import it.rossettidigiorgiomonica.circolosportivo.classes.*;

public class main {

	public static void main(String[] args) {
		
	    ArrayList<Partecipant> activityPartecipants = null;
	    Person bambino = new Person("camillo","benso","conte@di","cavour");
	    activityPartecipants.add(0, bambino);
		Activity course = new Course("hellow world",activityPartecipants);
		
	}

}
