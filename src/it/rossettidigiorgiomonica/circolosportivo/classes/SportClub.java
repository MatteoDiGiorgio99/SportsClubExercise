package it.rossettidigiorgiomonica.circolosportivo.classes;

import java.util.ArrayList;

public class SportClub {
	private ArrayList<Person> members;
	private ArrayList<Activity> activities;
	
	public SportClub(ArrayList<Person> members, ArrayList<Activity> activities) {
		this.members = members;
		this.activities = activities;
	}
	
	public Person login(final String username, final String password) {
		for(Person p : this.members) {
			if(p.getEmail().contains(username) && p.getPassword().contains(password)) {
				return p;
			}
		}
		
		return null;
	}
	
	public void eventsRegistration(final String activityName, final Person member) {
		Activity activity = getActivityFromList(activityName);
		
		if(activity == null)
			return;
		
		int index = this.activities.indexOf(activity);
		
		activity.addActivityPartecipant(member);
		
		this.activities.set(index, activity);
	}
	
	public void eventsDeregistration(final String activityName, final Person member) {
		Activity activity = getActivityFromList(activityName);
		
		if(activity == null)
			return;
		
		int index = this.activities.indexOf(activity);
		
		activity.removeActivityPartecipant(member);
		
		this.activities.set(index, activity);
	}
	
	
	public void addMember(final Person admin, final Person member) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		this.members.add(member);
	}
	
	public void editMember(final Person admin, final String memberEmail, final Person editedMember) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		int personIndex = this.members.indexOf(getMemberFromList(memberEmail));
		
		this.members.set(personIndex, editedMember);
	}
	
	public void removeMember(final Person admin, final Person member) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		this.members.remove(member);
	}
	
	
	public void addActivity(final Person admin, final Activity activity) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		this.activities.add(activity);
	}
	
	public void editActivity(final Person admin, final String activityName, final Activity editedActivity) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		Activity activityFromList = getActivityFromList(activityName);
		int activityIndex = this.activities.indexOf(activityFromList);
		
		this.activities.set(activityIndex, editedActivity);
	}
	
	public void removeActivity(final Person admin, final Activity activity) throws IllegalAccessException {
		if(admin.getRole() != Role.Admin)
			throw new IllegalAccessException();
		
		this.activities.remove(activity);
	}
	
	
	private Person getMemberFromList(String memberEmail) {
		for(Person person : this.members) {
			if(person.getEmail() == memberEmail) {
				return person;
			}
		}
		
		return null;
	}
	
	private Activity getActivityFromList(final String activityName) {
		for(Activity activity : this.activities) {
			if(activity.getActivityName().contains(activityName)) {
				return activity;
			}
		}
		
		return null;
	}
}
