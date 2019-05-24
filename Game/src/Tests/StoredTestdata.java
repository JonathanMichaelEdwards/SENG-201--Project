package Tests;

import java.util.ArrayList;

import IOFile.IOFile;
import SetUpScreens.NameShip;


public class StoredTestdata 
{
	NameShip crew = new NameShip();
	
	public String shipType = "";
	public String shipName = "";
	public ArrayList<String> storeCrew, storeShip, storeCash, inventory, storeDays;
	
	
	public void defaultData()
	{
		// Store information in files
		IOFile ioFile = new IOFile();
		
		ArrayList<String> memberActions1 = new ArrayList<String>();
		ArrayList<String> memberActions2 = new ArrayList<String>();
		ArrayList<String> memberActions3 = new ArrayList<String>();
		ArrayList<String> memberActions4 = new ArrayList<String>();
		
		storeCrew.addAll(crew.crewType);
		storeCrew.addAll(crew.crewNames);
		
		storeDays.add("2");
		storeDays.add("4");
		
		storeShip.add(shipType);
		storeShip.add(shipName);
		storeShip.add("75");
		storeShip.add("false");  //true false for whether we've found this planets piece
		storeShip.add("0");      //counter for how many planets we've been to
		
		storeCash.add("500");
		
		inventory.add("cookie");
		inventory.add("cookie");
		inventory.add("cookie");
		inventory.add("cookie");
		inventory.add("surgical");
		inventory.add("surgical");
		inventory.add("bandage");
		inventory.add("bandage");
		inventory.add("bandage");
		inventory.add("medkit");
		
		ioFile.fileWrite(storeCrew, "src/StoreGame/CrewInfo.txt");
		ioFile.fileWrite(storeShip, "src/StoreGame/ShipInfo.txt");
		ioFile.fileWrite(storeCash, "src/StoreGame/CashInfo.txt");
		ioFile.fileWrite(inventory, "src/StoreGame/Inventory/Storage.txt");
		ioFile.fileWrite(storeDays, "src/StoreGame/DaysInfo.txt");
		
		// Creating crew member each crew member there own information file
		for (int index = 0; index < crew.crewType.size(); index++) {
			if (index == 0) {
				memberActions1 = ioFile.fileRead("src/StoreGame/CrewRatings/"+  crew.crewType.get(0) + ".txt");
				memberActions1.add("2");
				memberActions1.add("false");
				memberActions1.add(crew.crewNames.get(0));
				memberActions1.add(crew.crewType.get(0));
				memberActions1.add("alive");
				ioFile.fileWrite(memberActions1, "src/StoreGame/CrewSelected/MemberOne.txt");
			} else if (index == 1) {
				memberActions2 = ioFile.fileRead("src/StoreGame/CrewRatings/"+  crew.crewType.get(1) + ".txt");
				memberActions2.add("2");
				memberActions2.add("false");
				memberActions2.add(crew.crewNames.get(1));
				memberActions2.add(crew.crewType.get(1));
				memberActions2.add("alive");
				ioFile.fileWrite(memberActions2, "src/StoreGame/CrewSelected/MemberTwo.txt");
			} else if (index == 2) {
				memberActions3 = ioFile.fileRead("src/StoreGame/CrewRatings/"+  crew.crewType.get(2) + ".txt");
				memberActions3.add("2");
				memberActions3.add("false");
				memberActions3.add(crew.crewNames.get(2));
				memberActions3.add(crew.crewType.get(2));
				memberActions3.add("alive");
				ioFile.fileWrite(memberActions3, "src/StoreGame/CrewSelected/MemberThree.txt");
			} else if (index == 3) {
				memberActions4 = ioFile.fileRead("src/StoreGame/CrewRatings/"+  crew.crewType.get(3) + ".txt");
				memberActions4.add("2");
				memberActions4.add("false");
				memberActions4.add(crew.crewNames.get(3));
				memberActions4.add(crew.crewType.get(3));
				memberActions4.add("alive");
				ioFile.fileWrite(memberActions4, "src/StoreGame/CrewSelected/MemberFour.txt");
			}
		}
	}
}
