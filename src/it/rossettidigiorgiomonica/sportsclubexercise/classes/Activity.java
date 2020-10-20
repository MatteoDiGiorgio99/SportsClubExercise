package it.rossettidigiorgiomonica.sportsclubexercise.classes;

 import java.util.ArrayList;
 
/** 
 * The {@code Activity} class defines a behavior that:
 * 
 * Manages the creation of sports activity of the club.
 * 
 * It also allows to manage subscriptions to these activities.
 * 
 * Activities can be of two types: courses or competitions described in separated classes
 *  
 *  @author 297398
 **/
 
public abstract class Activity {
	private String activityName;
	private ArrayList<Person> activityPartecipants;
	
	/**
	 * Class constructor.
	 * 
	 * @param activityName
	 */
	public Activity(final String activityName) { this.activityName = activityName; this.activityPartecipants = new ArrayList<Person>(); }
	
	/**
	 * Allows the user to fetch the activity name.
	 * 
	 * @return 
	 * 
	 * The activity name.
	 */
	public String getActivityName() { return this.activityName; }
	
	/**
	 * Permit to modify the activity name. 
	 * @param admin user with the necessary permission to modify the activity.
	 * @param newName the new activity name 
	 * @throws IllegalAccessException in case the current user doesn't have permissions or the string is empty or it doesn't exist
	 */	
	public void setActivityName(Person admin, String newName) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin && newName != null && newName.isEmpty()== false)
			throw new IllegalAccessException();
		
		this.activityName = newName; 
	}
	
	/**
	 * To access to the activity participants
	 * 
	 * @return
	 * Activity's participants list
	 */
	public ArrayList<Person> getActivityPartecipants() { return this.activityPartecipants; }
	
	/**
	 * Adds to the activity a participant
	 * @param toAdd participant to be added
	 * @throws IllegalAccessException in case the string is empty or it doesn't exist
	 */
	public void addActivityPartecipant(Person toAdd) throws IllegalAccessException{if(toAdd != null) this.activityPartecipants.add(toAdd); else throw new IllegalAccessException();}
	
	/**
	 * Removes a participant from the activity
	 * @param toRemove  participant to be removed
	 * @throws IllegalAccessException in case the string is empty or it doesn't exist
	 */
	public void removeActivityPartecipant(Person toRemove)throws IllegalAccessException {if(toRemove != null) this.activityPartecipants.remove(toRemove);else throw new IllegalAccessException(); } 
}
