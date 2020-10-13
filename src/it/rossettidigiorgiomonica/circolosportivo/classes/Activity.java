package it.rossettidigiorgiomonica.circolosportivo.classes;

import java.util.ArrayList;

public abstract class Activity {
	private String activityName;
	private ArrayList<Partecipant> activityPartecipants;
	
	public Activity(final String activityName) { this.activityName = activityName; this.activityPartecipants = new ArrayList<Partecipant>(); }
	
	protected String getActivityName() { return this.activityName; }
	protected void setActivityName(String newName) { this.activityName = newName; }
	
	protected ArrayList<Partecipant> getActivityPartecipants() { return this.activityPartecipants; }
	protected void addActivityPartecipant(Partecipant toAdd) { this.activityPartecipants.add(toAdd); }
	protected void removeActivityPartecipant(Partecipant toRemove) { this.activityPartecipants.remove(toRemove); } 
}
