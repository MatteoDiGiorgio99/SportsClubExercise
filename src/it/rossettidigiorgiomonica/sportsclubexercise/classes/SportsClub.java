package it.rossettidigiorgiomonica.sportsclubexercise.classes;

import java.util.ArrayList;

/**
 * Defines the business logic of the sports club
 * 
 * @author 296666
 *
 */
public class SportsClub {
	private ArrayList<Person> members;
	private ArrayList<Activity> activities;
	
	/**
	 * Class constructor
	 * 
	 * @param members a starter list of members
	 * @param activities a starter list of activities
	 */
	public SportsClub(ArrayList<Person> members, ArrayList<Activity> activities) {
		this.members = members;
		this.activities = activities;
	}
	
	/**
	 * Allows a user to access the system's resources
	 * 
	 * @param username the user name for login
	 * @param password the password for login
	 * @return
	 * 
	 * The logged user, null if wrong credentials 
	 */
	public Person login(final String username, final String password) {
		for(Person p : this.members) {
			if(p.getEmail().contains(username) && p.getPassword().contains(password)) {
				return p;
			}
		}
		
		return null;
	}
	
	/**
	 * Allows a member to join an activity
	 * 
	 * @param activityName the activity to join 
	 * @param member the user to join 
	 */
	public void eventsRegistration(final String activityName, final Person member) {
		Activity activity = getActivityFromList(activityName);
		
		if(activity == null)
			return;
		
		int index = this.activities.indexOf(activity);
		
		activity.addActivityPartecipant(member);
		
		this.activities.set(index, activity);
	}
	
	/**
	 * Allows a member to unsubscribe an activity
	 * 
	 * @param activityName the activity name
	 * @param member the member to unsubscribe
	 */
	public void eventsDeregistration(final String activityName, final Person member) {
		Activity activity = getActivityFromList(activityName);
		
		if(activity == null)
			return;
		
		int index = this.activities.indexOf(activity);
		
		activity.removeActivityPartecipant(member);
		
		this.activities.set(index, activity);
	}
	
	/**
	 * Allows an administrator to add a member
	 * 
	 * @param admin the administrator account
	 * @param member the new member account
	 * @throws IllegalAccessException in case the user isn't an administrator
	 */
	public void addMember(final Person admin, final Person member) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		this.members.add(member);
	}
	
	/**
	 * Allows an administrator to edit a member
	 * 
	 * @param admin the administrator account
	 * @param memberEmail the edited member's email
	 * @param editedMember the member's updated informations
	 * @throws IllegalAccessException in case the user isn't an administrator
	 */
	public void editMember(final Person admin, final String memberEmail, final Person editedMember) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		int personIndex = this.members.indexOf(getMemberFromList(memberEmail));
		
		this.members.set(personIndex, editedMember);
	}
	
	/**
	 * Allows an administrator to delete a member
	 * 
	 * @param admin the administrator account
	 * @param member the member to delete
	 * @throws IllegalAccessException in case the user isn't an administrator
	 */
	public void removeMember(final Person admin, final Person member) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		this.members.remove(member);
	}
	
	/**
	 * Allows to create a new activity
	 * 
	 * @param admin the administrator account
	 * @param activity the activity to insert
	 * @throws IllegalAccessException in case the user isn't an administrator
	 */
	public void addActivity(final Person admin, final Activity activity) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		this.activities.add(activity);
	}
	/**
	 * Allows to edit an activity
	 * 
	 * @param admin the administrator account
	 * @param activityName the name of the activity to edit
	 * @param editedActivity the activities updated informations
	 * @throws IllegalAccessException in case the user isn't an administrator
	 */
	public void editActivity(final Person admin, final String activityName, final Activity editedActivity) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		Activity activityFromList = getActivityFromList(activityName);
		int activityIndex = this.activities.indexOf(activityFromList);
		
		this.activities.set(activityIndex, editedActivity);
	}
	
	/**
	 * Allows to remove an Activity
	 * 
	 * @param admin the administrator account
	 * @param activity the activity to delete
	 * @throws IllegalAccessException in case the user isn't an administrator
	 */
	public void removeActivity(final Person admin, final Activity activity) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		this.activities.remove(activity);
	}
	
	/**
	 * An internal method that allows to fetch a member given his email
	 * 
	 * @param memberEmail the member email
	 * @return
	 * 
	 * The member, null if not found
	 */
	private Person getMemberFromList(String memberEmail) {
		for(Person person : this.members) {
			if(person.getEmail() == memberEmail) {
				return person;
			}
		}
		
		return null;
	}
	
	/**
	 * An internal method that allows to fetch an activity given its name
	 * 
	 * @param activityName the activity name
	 * @return
	 * 
	 * The activity, null if not found
	 */
	private Activity getActivityFromList(final String activityName) {
		for(Activity activity : this.activities) {
			if(activity.getActivityName().contains(activityName)) {
				return activity;
			}
		}
		
		return null;
	}
}
