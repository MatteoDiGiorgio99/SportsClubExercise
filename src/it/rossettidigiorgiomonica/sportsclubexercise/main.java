package it.rossettidigiorgiomonica.sportsclubexercise;

import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.*; 

import it.rossettidigiorgiomonica.sportsclubexercise.classes.*;


/**
 * The {@code main} class defines a behavior that:
 * 
 * Allow you to run the program 
 * 
 * This method implements communication with other classes
 * 
 * @author 296666
 *
 */

public class main {
	
	/** Defines the logic of execution 
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {	
		
		/// Login
		SportsClub club = initClub();
		Logger logger = initLogger();
		
		Person loggedIn = club.login(args[0], args[1]);
		
		if(loggedIn == null) {
			logger.warning("Unknown user tried to login");
			return;	
		}
		
		logger.info("User " + loggedIn.getEmail() + " logged in");
		
		Person toAdd = new Person("testAdd", "testAdd", "testadd@sportclub.it", "1234", Role.User);
		
		/// Test Add Member
		try {
			club.addMember(loggedIn, toAdd);
			
			logger.info("User " + toAdd.getEmail() + " added succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: ADD USER");
		}
		
		/// Test Edit Member
		try {			
			toAdd.setPassword("modded");
			club.editMember(loggedIn, toAdd.getEmail(), toAdd);
			
			logger.info("User " + toAdd.getEmail() + " edited succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: EDIT USER");
		}
		
		/// Test Remove Member
		try {
			club.removeMember(loggedIn, toAdd);
			
			logger.info("User " + toAdd.getEmail() + " removed succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: DELETE USER");
		}
		
		Activity testActivity = new Course("testActivity1");
		
		/// Test Add Activity
		try {
			club.addActivity(loggedIn, testActivity);
			
			logger.info("Activity " + testActivity.getActivityName() + " added succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: ADD ACTIVITY");
		}
		
		/// Test Update Activity
		try {
			testActivity.addActivityPartecipant(toAdd);
			
			club.editActivity(loggedIn, testActivity.getActivityName(), testActivity);
			
			logger.info("Activity " + testActivity.getActivityName() + " edited succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: UPDATE ACTIVITY");
		}
		
		/// Test Delete Activity
		try {
			testActivity.addActivityPartecipant(toAdd);
			
			club.removeActivity(loggedIn, testActivity);
			
			logger.info("Activity " + testActivity.getActivityName() + " removed succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: DELETE ACTIVITY");
		}
		
		//Test Add User into Activity 
		club.eventsRegistration("Activity1",loggedIn);
		logger.info("User: " + loggedIn.getEmail() +" has been added to the event: " + "Activity1" );
		
		//Test Remove User into Activity
		club.eventsDeregistration("Activity1",loggedIn);
		logger.info("User: " + loggedIn.getEmail() +" has been deleted from event: " + "Activity1");
		
		
		
	}
	
	/** Allows you to create the log file where the operations will follow
	 * 
	 * @return
	 */
	public static Logger initLogger() {	
		try {
		    Logger logger = Logger.getLogger("SportClubLogs");  
		    FileHandler fh;
		    
			fh = new FileHandler("./src/it/rossettidigiorgiomonica/sportsclubexercise/SportClubLogs.txt");
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);
	        
			return logger;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * initialize the sports club operating on what is read from file
	 * 
	 * @return
	 */
	public static SportsClub initClub() {	
		List<String> activitiesRaw = readFile("./src/it/rossettidigiorgiomonica/sportsclubexercise/sources/activities.csv");
		List<String> membersRaw = readFile("./src/it/rossettidigiorgiomonica/sportsclubexercise/sources/users.csv");
			
		ArrayList<Activity> activities = parseActivities(activitiesRaw);
		ArrayList<Person> members = parseMembers(membersRaw);
		
		SportsClub club = new SportsClub(members, activities);
		
		return club;
	}
	
	/** 
	 * Allows you to read and interpret the text file
	 * 
	 * @param fileName The file's name
	 * 
	 * @return
	 */
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
	
	/**
	 * Set the inscription on the list of Activities
	 * 
	 * @param list The list on which you operate
	 * 
	 * @return
	 */
	public static ArrayList<Activity> parseActivities(List<String> list) {
		ArrayList<Activity> result = new ArrayList<Activity>();
		
		for(String r : list) {
			String[] separated = r.split(";");
			
			Activity toInsert;
			int type = Integer.parseInt(separated[1]);
			
			if(type == 0)
				toInsert = new Course(separated[0]);
			else if(type == 1)
				toInsert = new Competition(separated[0]);
			else
				continue;
			
			result.add(toInsert);
		}
		
		return result;
	}
	
	/** Set the inscription on the list of Members
	 * 
	 * @param list The list on which you operate
	 * 
	 * @return
	 * 
	 * @throws IllegalFormatException If the members isn't a User or Administrator
	 */
	public static ArrayList<Person> parseMembers(List<String> list) throws IllegalFormatException {
		ArrayList<Person> result = new ArrayList<Person>();
		
		for(String r : list) {
			String[] separated = r.split(";");
			
			if(separated.length < 5)
				throw new IllegalArgumentException("");
			
			Role role = Role.values()[Integer.parseInt(separated[4])];
				
			Person toInsert = new Person(separated[0], separated[1], separated[2], separated[3], role);
			
			result.add(toInsert);
		}
		
		return result;
	}
}