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
	
	/** 
	 * Defines the logic of execution 
	 * 
	 * @param args the console arguments
	 * @throws IllegalAccessException in case the string is empty or it doesn't exist
	 */
	public static void main(final String[] args) throws IllegalAccessException {	
		
		/// Login
		SportsClub club = initClub();
		Logger logger = initLogger();
		
		Person loggedIn = club.login(args[0], args[1]);
		
		if(loggedIn == null) {
			logger.warning("Unknown user tried to login");
			return;	
		}
		
		logger.info("User " + loggedIn.getEmail() + " logged in");
		
		Person pTest1 = new Person("testAdd1", "testAdd1", "testadd1@sportclub.it", "1234", Role.User);
		Person pTest2 = new Person("testAdd2", "testAdd2", "testadd2@sportclub.it", "1234", Role.Admin);
		
		/// Test Add Member
		try {
			club.addMember(loggedIn, pTest1);
			club.addMember(loggedIn, pTest2);
			
			logger.info("User " + pTest1.getEmail() + " added succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: ADD USER");
		}
		
		/// Test Edit Member
		try {			
			pTest1.setPassword("modded");
			club.editMember(loggedIn, pTest1.getEmail(), pTest1);
			
			logger.info("User " + pTest1.getEmail() + " edited succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: EDIT USER");
		}
		
		/// Test Remove Member
		try {
			club.removeMember(loggedIn, pTest2);
			
			logger.info("User " + pTest2.getEmail() + " removed succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: DELETE USER");
		}
		
		Activity testActivity1 = new Course("testActivity1");
		Activity testActivity2 = new Competition("testActivity2");
		
		/// Test Add Activity
		try {
			club.addActivity(loggedIn, testActivity1);
			club.addActivity(loggedIn, testActivity2);
			
			logger.info("Activity " + testActivity1.getActivityName() + " added succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: ADD ACTIVITY");
		}
		
		/// Test Update Activity
		try {
			testActivity1.setActivityName(loggedIn, "testModded1");
			
			club.editActivity(loggedIn, testActivity1.getActivityName(), testActivity1);
			
			logger.info("Activity " + testActivity1.getActivityName() + " edited succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: UPDATE ACTIVITY");
		}
		
		/// Test Delete Activity
		try {			
			club.removeActivity(loggedIn, testActivity2);
			
			logger.info("Activity " + testActivity2.getActivityName() + " removed succesfully");
		} catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: DELETE ACTIVITY");
		}
				
		/// Test Add User into Activity
		try {
		club.eventsRegistration("activity1", pTest1);
		club.eventsRegistration("activity1", loggedIn);
		
		club.eventsRegistration(testActivity1.getActivityName(), pTest1);
		club.eventsRegistration(testActivity1.getActivityName(), pTest1);
		logger.info("User: " + loggedIn.getEmail() +" has been added to the event: " + "Activity1" );
		}catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: EVENT REGISTRATION");
		}

		
		/// Test Remove User into Activity
		try {
		club.eventsDeregistration(testActivity1.getActivityName(), pTest1);
		club.eventsDeregistration(testActivity1.getActivityName(), loggedIn);
		logger.info("User: " + loggedIn.getEmail() +" has been deleted from event: " + "Activity1");
		}catch (IllegalAccessException e) {
			logger.severe("Access Denied: " + loggedIn.getEmail() + " tried to perform an unauthorized operation: EVENT DEREGISTRATION");
		}

		
		/// Get all activities
		logger.info("Activities: \n\n" + club.getActivityString());
		
		/// Get all members
		logger.info("Members: \n\n" + club.getMembersString());
	}
	
	/** 
	 * Allows you to create a file where the executed operations will be logged
	 * 
	 * @return a logger variable
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
	 * Initialize the sports club operating on what is read from file
	 * 
	 * @return a sports club 
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
	 * 
	 * A list of lines 
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
	 * A method to parse a CSV styled lines into an Activity list
	 * 
	 * @param list the list on which you operate
	 * 
	 * @return
	 * 
	 * An array list of activities
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
	
	/** 
	 * A method to parse a CSV styled lines into a Member list
	 * 
	 * @param list the list on which you operate
	 * 
	 * @return An array list of members
	 * 
	 * @throws IllegalFormatException If the input file is not formatted correctly
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