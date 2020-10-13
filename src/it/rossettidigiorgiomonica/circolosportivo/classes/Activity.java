package it.rossettidigiorgiomonica.circolosportivo.classes;

import java.util.ArrayList;

public abstract class Activity {
	private String activityName;
	private ArrayList<Person> activityPartecipants;
	
	public Activity(final String activityName) { this.activityName = activityName; this.activityPartecipants = new ArrayList<Person>(); }
	
	public String getActivityName() { return this.activityName; }
	public void setActivityName(String newName) { this.activityName = newName; }
	
	public ArrayList<Person> getActivityPartecipants() { return this.activityPartecipants; }
	public void addActivityPartecipant(Person toAdd) { this.activityPartecipants.add(toAdd); }
	public void removeActivityPartecipant(Person toRemove) { this.activityPartecipants.remove(toRemove); } 
}
