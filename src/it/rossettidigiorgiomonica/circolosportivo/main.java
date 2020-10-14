package it.rossettidigiorgiomonica.circolosportivo;

import java.util.ArrayList;
import java.util.*;

import it.rossettidigiorgiomonica.circolosportivo.classes.*;


public class main {

	public static void main(String[] args) {
		while(true) {
			//Print menu
			printMenu();		
			
			//Get options and execute
			optionExecutor();
		}
	}
	
	static void printMenu() {
		
	}
	
	static void optionExecutor() {
		System.out.print("Choose the option: ");
		try (var input = new Scanner(System.in)) {
			int Nchoice = input.nextInt();
			System.out.print(Nchoice);
			
			// Choice execution
			switch(Nchoice)
			{
				case 1:
					//continue...
			}
		}
	}
}