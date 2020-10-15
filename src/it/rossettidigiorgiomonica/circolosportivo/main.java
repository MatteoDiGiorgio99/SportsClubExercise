package it.rossettidigiorgiomonica.circolosportivo;

import java.util.*;
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.*; 

import it.rossettidigiorgiomonica.circolosportivo.classes.*;


public class main {
	public static void main(String[] args) {
		boolean login = false;
		
		if(!login)
			return;
	}
	
	public static List<String> readFile(String fileName) 
	{   
		List<String> lines = Collections.emptyList(); 
		try
		{ 
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
	    } 
		catch (IOException e) 
		{ 
			e.printStackTrace(); 
    	} 
		
		return lines;
	}
	
	public static ArrayList<Activity> parseActivities(List<String> list) {
		return null;
	}
}