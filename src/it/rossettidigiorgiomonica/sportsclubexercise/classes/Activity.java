package it.rossettidigiorgiomonica.sportsclubexercise.classes;

import java.util.ArrayList;

public abstract class Activity {
	private String activityName;
	private ArrayList<Person> activityPartecipants;
	
	public Activity(final String activityName) { this.activityName = activityName; this.activityPartecipants = new ArrayList<Person>(); }
	
	public String getActivityName() { return this.activityName; }
	public void setActivityName(Person admin, String newName) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		this.activityName = newName; 
	}
	
	public ArrayList<Person> getActivityPartecipants() { return this.activityPartecipants; }
	public void addActivityPartecipant(Person toAdd) { this.activityPartecipants.add(toAdd); }
	public void removeActivityPartecipant(Person toRemove) { this.activityPartecipants.remove(toRemove); } 
}
