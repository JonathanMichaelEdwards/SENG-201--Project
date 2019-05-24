package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import IOFile.IOFile;
import SetUpScreens.ChooseDays;

public class ChooseDaysTest 
{
	  /** 
	   *  Testing to see for the inputed value and that
	   *  value chosen is correct
	   */
	  @Test
	 public  void testDays() {
		  ChooseDays choose = new ChooseDays();
		  
		  choose.piecesToCollect = 3;
		  assertEquals(choose.getDays(), 3);
	  }
}
