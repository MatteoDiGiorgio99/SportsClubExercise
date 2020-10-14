package it.rossettidigiorgiomonica.circolosportivo;

import java.util.ArrayList;
import java.util.*;

import it.rossettidigiorgiomonica.circolosportivo.classes.*;


public class main {

	public static void main(String[] args) {

		
		//Esempio persona con enum
		Person bambino = new Person("camillo","benso","conte@di","cavour",Role.Admin);
		
		//Array persone
		ArrayList<Person> activityPartecipants = new ArrayList<Person>();
		activityPartecipants.add(bambino);
		
		//Creo menù
		
		
		//Scelta menù
		System.out.print("Scegli l'opzione: ");
		Scanner Input= new Scanner(System.in);
		int Nchoice= Input.nextInt();
	    System.out.print(Nchoice);
	    
	    //esecuzione della scelta
		switch(Nchoice)
		{
		case 1:
			//continue...
		}
		
		
	}

}