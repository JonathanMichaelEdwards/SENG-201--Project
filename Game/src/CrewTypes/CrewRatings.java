package CrewTypes;

import java.util.ArrayList;


public class CrewRatings 
{
	// Store crew ratings
	public ArrayList<String> soldier = new ArrayList<String>();
	public ArrayList<String> medic = new ArrayList<String>();
	public ArrayList<String> leader = new ArrayList<String>();
	public ArrayList<String> mechanic = new ArrayList<String>();
	public ArrayList<String> pilot = new ArrayList<String>();
	public ArrayList<String> thief = new ArrayList<String>();
	
	
	// Adds the crew ratings to there allocated lists
	public void crewRatings()
	{
		// Ratings (Health, Tiredness, Hunger)
		// Soldier ratings
		soldier.add("80");
		soldier.add("50");
		soldier.add("70");

		// Medic ratings
		medic.add("100");
		medic.add("50");
		medic.add("50");
		
		// Leader ratings
		leader.add("40");
		leader.add("60");
		leader.add("100");
		
		// Mechanic ratings
		mechanic.add("80");
		mechanic.add("50");
		mechanic.add("70");
		
		// Pilot ratings
		pilot.add("50");
		pilot.add("100");
		pilot.add("50");
		
		// Pilot ratings
		thief.add("70");
		thief.add("60");
		thief.add("70");
	}
}
