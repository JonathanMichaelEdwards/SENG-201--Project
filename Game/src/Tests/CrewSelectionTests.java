package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import SetUpScreens.CrewSelection;


public class CrewSelectionTests 
{
	CrewSelection crew = new CrewSelection();
	
	  /** 
	   *  Testing to see whether user has selected 
	   *  valid characters in order to play the game 
	   */
	  @Test
	 public void characterCount() {
		  CrewSelection crew = new CrewSelection();
		  
		  crew.comBoxCharChosen.addItem("Attack");
		  crew.comBoxCharChosen.addItem("Leader");

		  assertEquals(crew.comBoxCharChosen.getItemAt(0), "Attack");
		  assertEquals(crew.comBoxCharChosen.getItemAt(1), "Leader");
	  }
	  
	  
	  /** 
	   *  Checking to see whether a member can be added to a list
	   */
	  @Test
	 public void addPlayer() {
		  crew.selectSoldier.setEnabled(true);
		  crew.crewType.add("Soldier");
		  crew.crewType.add("Soldier");
		  assertEquals(crew.crewType.get(0), "Soldier");
	  }
}
