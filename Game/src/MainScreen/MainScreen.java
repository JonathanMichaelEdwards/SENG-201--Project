package MainScreen;

// Library imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JPanel;

//Self implemented
import WindowSettings.Display;
import SpaceOutpost.SpaceOutpost;
import IOFile.IOFile;
import Inventory.ShipInventory;
import NewPlanet.CrewTravel;
import RepairShields.CrewRepair;
import SearchPlanet.CrewPlanet;
import Sleep.CrewSleep;
import MainScreen.loseGame;
import MainScreen.winGame;
import RandomEvents.asteroids;
import RandomEvents.alienPirates;
import RandomEvents.spacePlague;



public class MainScreen

{
	public JFrame frame;
	
	// setting output labels
	private JLabel lblDaysLeft, lblParts;
	private JLabel lblShipType, lblShipName;
	private JLabel lblCrewType1, lblCrewType2, lblCrewType3, lblCrewType4;
	private JLabel lblMember1, lblMember2, lblMember3, lblMember4;

	// Setting action buttons to be scoped globally
	private JButton btnSpaceOutpost;
	private JButton btnNewPlanet;
	private JButton btnRepairShields;

	// Setting progress bars
	private JProgressBar pBarHealth1, pBarHealth2, pBarHealth3, pBarHealth4;
	private JProgressBar pBarTiredness1, pBarTiredness2, pBarTiredness3, pBarTiredness4;
	private JProgressBar pBarHunger1, pBarHunger2, pBarHunger3, pBarHunger4;
	private JProgressBar pBarShipHealth;
	private JLabel player1, player2, player3, player4;
	private JLabel lblCashTotal;
	
	// Stored information that the user has chosen
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewName = new ArrayList<String>();
	private String shipType;
	private String shipName;
	private int days;
	private int parts;
	private int repair;
	private JLabel lblptr;
	
	// File locations
	private String writeHealth = "StoreGame/CrewSelected/";
	
	// stores the selection type
	private JLabel type[] = new JLabel[4];
	private JLabel member[] = new JLabel[4];
	
	
	private JProgressBar health[] = new JProgressBar[4];
	private JProgressBar tiredness[] = new JProgressBar[4];
	private JProgressBar hunger[] = new JProgressBar [4];
	private JButton btnSleep;
	private JLabel lblPlague;
	
	private String readFile = "StoreGame/CrewSelected/";	
	
	// Store all progress bar so it can be used easily
	// Stores crew details in data arrays so it can be used easily
	private void pBarHealth() 
	{
		health[0] = pBarHealth1;
		health[1] = pBarHealth2;
		health[2] = pBarHealth3;
		health[3] = pBarHealth4;
	}
	
	private void pBarTiredness() 
	{
		tiredness[0] = pBarTiredness1;
		tiredness[1] = pBarTiredness2;
		tiredness[2] = pBarTiredness3;
		tiredness[3] = pBarTiredness4;
	}
	
	private void pBarHunger() 
	{
		hunger[0] = pBarHunger1;
		hunger[1] = pBarHunger2;
		hunger[2] = pBarHunger3;
		hunger[3] = pBarHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void dispCrewType() 
	{
		type[0] = lblCrewType1;
		type[1] = lblCrewType2;
		type[2] = lblCrewType3;
		type[3] = lblCrewType4;
	}
	
	private void dispCrewMember() 
	{
		member[0] = lblMember1;
		member[1] = lblMember2;
		member[2] = lblMember3;
		member[3] = lblMember4;
	}
	

	// helper function to find the correct member and name
	private void addCrew(ArrayList<String> crewInfo, int size)
	{	
		for (int index = 0; index < size; index ++) {
			crewType.add(crewInfo.get(index));
			crewName.add(crewInfo.get(index+size));
		}
		disableStatus(size);
	}
	
	private void tiredRate(ArrayList<String> member, IOFile ioFile, String name)
	{
		member.set(3, ""+(Integer.parseInt(member.get(3)) - 1));
		int tired = Integer.parseInt(member.get(1));
		if (tired <= 0)
		{
			int health = Integer.parseInt(member.get(0)) - 30;
			member.set(0, "" + health);
			member.set(1, "" + 0);
			ioFile.fileWrite(member, readFile + name + ".txt");
		}
		else 
		{
			int tired1 = Integer.parseInt(member.get(1)) - 10; //this is the value in which a repair heals
			member.set(1, "" + tired1);
			ioFile.fileWrite(member, readFile + name + ".txt");
		}
	}	
	
	// items to be disabled
	private void disableInfo(int index) 
	{
		type[index].setEnabled(false);
		member[index].setEnabled(false);
		hunger[index].setEnabled(false);
		health[index].setEnabled(false);
		tiredness[index].setEnabled(false);
	}
	
	// helper function to disable/(grey out) unused status information areas
	private void disableStatus(int size)
	{
		int lsSize = 4;
		
		// disable/(grey out) unused status information areas
		for (int index = 0; index < lsSize; index++) {
			if ((lsSize-size) == 2 && (index == 2)) {
				disableInfo(index);
				player3.setEnabled(false);
				player4.setEnabled(false);
			} else if ((lsSize-size) == 1 && (index == 3)) {
				disableInfo(index);
				player4.setEnabled(false);
			}
		}	
	}

	
	// decode crew information to get correct data
	private void decodeCrewInfo(ArrayList<String> crewInfo)
	{
		// store crew member and there names at the correct index in separate lists
		// size is -1 because an empty value is added on to the end
		if ((crewInfo.size()) == 4) addCrew(crewInfo, 2);
		else if (crewInfo.size() == 6) addCrew(crewInfo, 3);
		else if (crewInfo.size() == 8) addCrew(crewInfo, 4);
	}
	
	
	// Storing and displaying the characters health
	private void memberOne(ArrayList<String> crewMember1, IOFile ioFile)
	

	{

		crewMember1 = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
//		String deadAlive;
//		deadAlive = crewMember1.get(7);
//		if (deadAlive.equals("dead"))
//		{
//			pBarHealth1.setVisible(false); // IS THIS DUDE HELLA DEAD?? XDDDDDD
//			pBarTiredness1.setVisible(false);
//			pBarHunger1.setVisible(false);
//			System.out.println("this nibba dead");
//		}
		pBarHealth1.setValue(Integer.valueOf(crewMember1.get(0)));
		pBarTiredness1.setValue(Integer.valueOf(crewMember1.get(1)));
		pBarHunger1.setValue(Integer.valueOf(crewMember1.get(2)));
	}
	
	private void memberTwo(ArrayList<String> crewMember2, IOFile ioFile)
	{
		crewMember2 = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
//		String deadAlive;
//		deadAlive = crewMember2.get(7);
//		if (deadAlive.equals("dead"))
//		{
//			pBarHealth2.setVisible(false); // IS THIS DUDE HELLA DEAD?? XDDDDDD
//			pBarTiredness2.setVisible(false);
//			pBarHunger2.setVisible(false);
//			System.out.println("this nibba dead");
//		}
		pBarHealth2.setValue(Integer.valueOf(crewMember2.get(0)));
		pBarTiredness2.setValue(Integer.valueOf(crewMember2.get(1)));
		pBarHunger2.setValue(Integer.valueOf(crewMember2.get(2)));
	}
	
	private void memberThree(ArrayList<String> crewMember3, IOFile ioFile)
	{
		crewMember3 = ioFile.fileRead("StoreGame/CrewSelected/MemberThree.txt");
//		String deadAlive;
//		deadAlive = crewMember3.get(7);
//		if (deadAlive.equals("dead"))
//		{
//			pBarHealth3.setVisible(false); // IS THIS DUDE HELLA DEAD?? XDDDDDD
//			pBarTiredness3.setVisible(false);
//			pBarHunger3.setVisible(false);
//			System.out.println("this nibba dead");
//		}
		pBarHealth3.setValue(Integer.valueOf(crewMember3.get(0)));
		pBarTiredness3.setValue(Integer.valueOf(crewMember3.get(1)));
		pBarHunger3.setValue(Integer.valueOf(crewMember3.get(2)));
	}
	
	private void memberFour(ArrayList<String> crewMember4, IOFile ioFile)
	{
		crewMember4 = ioFile.fileRead("StoreGame/CrewSelected/MemberFour.txt");
		
//		String deadAlive;
//		deadAlive = crewMember4.get(7);
//		if (deadAlive.equals("dead"))
//		{
//			pBarHealth4.setVisible(false); // IS THIS DUDE HELLA DEAD?? XDDDDDD
//			pBarTiredness4.setVisible(false);
//			pBarHunger4.setVisible(false);
//			System.out.println("this nibba dead");
//		}
		
		pBarHealth4.setValue(Integer.valueOf(crewMember4.get(0)));
		pBarTiredness4.setValue(Integer.valueOf(crewMember4.get(1)));
		pBarHunger4.setValue(Integer.valueOf(crewMember4.get(2)));
	}
	
	
	private void readCrewRatings(IOFile ioFile)
	{ 
		ArrayList<String> crewMember1 = new ArrayList<String>();
		ArrayList<String> crewMember2 = new ArrayList<String>();
		ArrayList<String> crewMember3 = new ArrayList<String>();
		ArrayList<String> crewMember4 = new ArrayList<String>();
		
		// Reading and storing the crew members health rating
		for (int index = 0; index < crewType.size(); index++) {
			// Storing the character types health rating
			if (index == 0) {
				memberOne(crewMember1, ioFile);
			} else if (index == 1) {
				memberTwo(crewMember2, ioFile);
			} else if (index == 2) {
				memberThree(crewMember3, ioFile);
			} else if (index == 3) {
				memberFour(crewMember4, ioFile);;
			}
		}
	}
	
	
	private void bankStore()
	{
		ArrayList<String> totalCash = new ArrayList<String>();
		IOFile ioFile = new IOFile();

		// read how much cash the player has
		totalCash = ioFile.fileRead("StoreGame/CashInfo.txt");
		lblCashTotal.setText("Current Cash = $ " + totalCash.get(0).toString());
	}
	
	
	// organizing information from files
	private void organizeGameInfo()
	{
		// gather information stored in file
		IOFile ioFile = new IOFile();
		
		// Reading files
		ArrayList<String> crewInfo = ioFile.fileRead("StoreGame/CrewInfo.txt");
		ArrayList<String> shipInfo = ioFile.fileRead("StoreGame/ShipInfo.txt");
		ArrayList<String> daysInfo = ioFile.fileRead("StoreGame/DaysInfo.txt");
		ArrayList<String> changeShields = ioFile.fileRead("StoreGame/ShipInfo.txt");
		ArrayList<String> memberOne = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
		ArrayList<String> memberTwo = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");

		// unwrap the crew information
		decodeCrewInfo(crewInfo);
		
		shipType = shipInfo.get(0);
		shipName = shipInfo.get(1);
		
		days = Integer.parseInt(daysInfo.get(0));
		parts = Integer.parseInt(daysInfo.get(1));
		
		repair = Integer.parseInt(changeShields.get(2));
		
		// Displaying crew info
		lblShipType.setText(shipType);
		lblShipName.setText(shipName);
		lblDaysLeft.setText("Days Remaining: " + days);
		lblParts.setText("Parts to find: " + parts);
		pBarShipHealth.setValue(repair);
		
		// if true, part is found on this planet
		if (changeShields.get(3).equals("true"))
			lblptr.setText("Parts on this planet: " + 0 );
		else 
			lblptr.setText("Parts on this planet: " + 1 );
		
		
		if (memberOne.get(4).equals("true") && memberTwo.get(4).equals("true")) 
			lblPlague.setText(memberOne.get(5) + " and " + memberTwo.get(5) + " both have the plague");
		else if (memberOne.get(4).equals("true"))
			lblPlague.setText(memberOne.get(5) + " has the plague");
		else if (memberTwo.get(4).equals("true")) 
			lblPlague.setText(memberTwo.get(5) + " has the plague");
		else 
			lblPlague.setText("No body has the plague");
		
		// Output crew
		for (int index = 0; index < crewType.size(); index++) {
			type[index].setText(crewType.get(index));
			member[index].setText(crewName.get(index));
		}
		
		// Read and display the crew ratings
		readCrewRatings(ioFile);
		
		ArrayList<String> membersActions = new ArrayList<String>();
		
		// Display the crew Members action count
		for (int index = 0; index < crewType.size(); index++) {
			if (index == 0) {
				membersActions = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
				player1.setText(membersActions.get(3));
			} else if (index == 1) {
				membersActions = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
				player2.setText(membersActions.get(3));
			} else if (index == 2) {
				membersActions = ioFile.fileRead("StoreGame/CrewSelected/MemberThree.txt");
				player3.setText(membersActions.get(3));
			} else if (index == 3) {
				membersActions = ioFile.fileRead("StoreGame/CrewSelected/MemberFour.txt");
				player4.setText(membersActions.get(3));
			}
		}
	}
	
	
	// Go to the space outpost screen
	private void spaceOutpost()
	{
		btnSpaceOutpost = new JButton("Space Outpost");
		btnSpaceOutpost.setBounds(521, 478, 249, 101);
		btnSpaceOutpost.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnSpaceOutpost.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SpaceOutpost outpost = new SpaceOutpost();
				outpost.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);         // turn off screen
			}
		});
		frame.getContentPane().add(btnSpaceOutpost);
	}
	
//	private void asteroids()
//			{
//				asteroids outpost = new asteroids();
//				outpost.frame.setVisible(true);  // turn on screen
//				frame.setVisible(false);         // turn off screen
//			}
	
	// Go to the newPlanet screen
	private void newPlanet()
	{
		btnNewPlanet = new JButton("Travel to a new planet");
		btnNewPlanet.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnNewPlanet.setBounds(457, 726, 313, 113);
		btnNewPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				CrewTravel screen = new CrewTravel();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().add(btnNewPlanet);
	}
	
	
	// Go to the explore planet screen
	private void explorePlanet()
	{
		JButton btnExplorePlanet = new JButton("Explore current planet");
		btnExplorePlanet.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnExplorePlanet.setBounds(60, 731, 313, 108);
		btnExplorePlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				CrewPlanet screen = new CrewPlanet();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().add(btnExplorePlanet);
	}
	
	
	// repair shields
	private void repairShields()
	{
		btnRepairShields = new JButton("Repair Shields!");
		btnRepairShields.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnRepairShields.setBounds(540, 241, 230, 96);
		btnRepairShields.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{	
				CrewRepair screen = new CrewRepair();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().add(btnRepairShields);
	}
	
	
	// Go to sleep screen
	private void btnSleep()
	{
		btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				CrewSleep sleep = new CrewSleep();
				sleep.frame.setVisible(true);     // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		btnSleep.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnSleep.setBounds(127, 239, 230, 101);
		frame.getContentPane().add(btnSleep);
		
		lblptr = new JLabel("Parts on this planet: ...");
		lblptr.setFont(new Font("Dialog", Font.BOLD, 16));
		lblptr.setBounds(112, 667, 256, 40);
		frame.getContentPane().add(lblptr);
		
		lblPlague = new JLabel("... has the plague");
		lblPlague.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPlague.setBounds(81, 404, 488, 62);
		frame.getContentPane().add(lblPlague);
		

	}
	
	private void btnInventory()
	{
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ShipInventory sleep = new ShipInventory();
				sleep.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);         // turn off screen
			}
		});
		btnInventory.setFont(new Font("Dialog", Font.PLAIN, 23));
		btnInventory.setBounds(127, 478, 230, 101);
		frame.getContentPane().add(btnInventory);
	}
	
	
	// go to the next day
	private void nextDay()
	{	
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{

				IOFile ioFile = new IOFile();
				ArrayList<String> changeDays = new ArrayList<String>();
				
				// Resetting crew action count
				ArrayList<String> memberActions1 = new ArrayList<String>();
				ArrayList<String> memberActions2 = new ArrayList<String>();
				ArrayList<String> memberActions3 = new ArrayList<String>();
				ArrayList<String> memberActions4 = new ArrayList<String>();
				String boolPlague;
				String check;

				
				changeDays = ioFile.fileRead("StoreGame/DaysInfo.txt");
				days = Integer.parseInt(changeDays.get(0)) - 1;
				changeDays.set(0, "" + days);
				ioFile.fileWrite(changeDays, "StoreGame/DaysInfo.txt");  // Writing in new days
				if (days == -1)
				{
					System.out.println("GAME OVER XDDD OUTA DAYS");
					loseGame outpost = new loseGame();
					outpost.frame.setVisible(true);
					frame.setVisible(false);
				}
				if (days != -1)
				{
				//ioFile.fileWrite(changeDays, "StoreGame/DaysInfo.txt");  // Writing in new days
				lblDaysLeft.setText("Days Remaining: "  + days);
				
				// reading from file &Changing file & Writing back to file
				for (int index = 0; index < crewType.size(); index++) {
					if (index == 0) {
						memberActions1 = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
						memberActions1.set(3, "2");
						check = memberActions1.get(7);
						if (check.equals("dead"))
						{
							memberActions1.set(3, "Character is Dead");
						}
						if (check.equals("alive"))
						{
						int tired = Integer.parseInt(memberActions1.get(1)) - 20;
						memberActions1.set(1, "" + tired);
						ioFile.fileWrite(memberActions1, writeHealth + "MemberOne.txt");
						memberActions1 = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
						int tiredHp = Integer.parseInt(memberActions1.get(1));
						System.out.println(tiredHp);
						if (tiredHp <= 0)
						
						{
							memberActions1.set(1, "" + 0);

							ioFile.fileWrite(memberActions1, "StoreGame/CrewSelected/MemberOne.txt");
							memberActions1 = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
							int health = Integer.parseInt(memberActions1.get(0)) - 30;
							memberActions1.set(0, "" + health);
							System.out.println(health);
							if (health <= 0)
							{
								memberActions1.set(7, "dead");
								memberActions1.set(0, "" + 0);
								memberActions1.set(1, "" + 0);
								memberActions1.set(2, "" + 0);
								memberActions1.set(3, "" + 0);
								
							}
							ioFile.fileWrite(memberActions1, writeHealth + "MemberOne.txt");
						}
						
						boolPlague = memberActions1.get(4);		
						if (boolPlague.equals("true")) {	
							int health = Integer.parseInt(memberActions1.get(0)) - 30;
							memberActions1.set(0, "" + health);
							ioFile.fileWrite(memberActions1, writeHealth + "MemberOne.txt");
						}
						}
						
					} else if (index == 1) {
						memberActions2 = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
						memberActions2.set(3, "2");
						check = memberActions2.get(7);
						if (check.equals("dead"))
						{
							memberActions2.set(3, "0");
						}
						if (check.equals("alive"))
						{
						int tired = Integer.parseInt(memberActions2.get(1)) - 20;
						memberActions2.set(1, "" + tired);
						ioFile.fileWrite(memberActions2, writeHealth + "MemberTwo.txt");
						int tiredHp = Integer.parseInt(memberActions2.get(1));
						if (tiredHp <= 0)
						{
							memberActions2.set(1, "0");
							ioFile.fileWrite(memberActions2, "StoreGame/CrewSelected/MemberTwo.txt");
							memberActions2 = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
							int health = Integer.parseInt(memberActions2.get(0)) - 30;
							memberActions2.set(0, "" + health);
							if (health <= 0)
							{
								memberActions2.set(7, "dead");
								memberActions2.set(0, "" + 0);
								memberActions2.set(1, "" + 0);
								memberActions2.set(2, "" + 0);
								memberActions2.set(3, "" + 0); //if dead no more turns
							}
							ioFile.fileWrite(memberActions2, writeHealth + "MemberTwo.txt");
						}
						boolPlague = memberActions2.get(4);
						if (boolPlague.equals("true")) {
							memberActions2 = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
							int health = Integer.parseInt(memberActions2.get(0)) - 30;
							memberActions2.set(0, "" + health);
							ioFile.fileWrite(memberActions2, writeHealth + "MemberTwo.txt");
						}
						}
					} else if (index == 2) {
						memberActions3 = ioFile.fileRead("StoreGame/CrewSelected/MemberThree.txt");
						memberActions3.set(3, "2");
						check = memberActions3.get(7);
						if (check.equals("dead"))
						{
							memberActions3.set(3, "0");
						}
						if (check.equals("alive"))
						{
						int tired = Integer.parseInt(memberActions3.get(1)) - 20;
						memberActions3.set(1, "" + tired);
						ioFile.fileWrite(memberActions3, writeHealth + "MemberThree.txt");
						
						int tiredHp = Integer.parseInt(memberActions3.get(1));
						if (tiredHp <=0)
						{
							memberActions3.set(1, "0");
							ioFile.fileWrite(memberActions3, "StoreGame/CrewSelected/MemberThree.txt");
							memberActions3 = ioFile.fileRead("StoreGame/CrewSelected/MemberThree.txt");
							int health = Integer.parseInt(memberActions3.get(0)) - 30;
							memberActions3.set(0, "" + health);
							if (health <= 0)
							{
								memberActions3.set(7, "dead");
								memberActions3.set(0, "" + 0);
								memberActions3.set(1, "" + 0);
								memberActions3.set(2, "" + 0);
								memberActions3.set(3, "" + 0);
							}
							ioFile.fileWrite(memberActions3, writeHealth + "MemberThree.txt");
						}
						boolPlague = memberActions3.get(4);
						if (boolPlague.equals("true")) {
							memberActions3 = ioFile.fileRead("StoreGame/CrewSelected/MemberThree.txt");
							int health = Integer.parseInt(memberActions3.get(0)) - 30;
							memberActions3.set(0, "" + health);
							ioFile.fileWrite(memberActions3, writeHealth + "MemberThree.txt");
						}
						}
						
					} else if (index == 3) {
						memberActions4 = ioFile.fileRead("StoreGame/CrewSelected/MemberFour.txt");
						memberActions4.set(3, "2");
						check = memberActions4.get(7);
						if (check.equals("dead"))
						{
							memberActions4.set(3, "0");
						}
						if (check.equals("alive"))
						{
						int tired = Integer.parseInt(memberActions4.get(1)) - 20;
						memberActions4.set(1, "" + tired);
						ioFile.fileWrite(memberActions4, writeHealth + "MemberFour.txt");
						int tiredHp = Integer.parseInt(memberActions4.get(1));
						if (tiredHp <=0)
						{
							memberActions4.set(1, "0");
							ioFile.fileWrite(memberActions4, "StoreGame/CrewSelected/MemberFour.txt");
							memberActions4 = ioFile.fileRead("StoreGame/CrewSelected/MemberFour.txt");
							int health = Integer.parseInt(memberActions4.get(0)) - 30;
							memberActions4.set(0, "" + health);
							if (health <= 0)
							{
								memberActions4.set(7, "dead");
								memberActions4.set(0, "" + 0);
								memberActions4.set(1, "" + 0);
								memberActions4.set(2, "" + 0);
								memberActions4.set(3, "" + 0); //if dead no more turns
							}
							ioFile.fileWrite(memberActions4, writeHealth + "MemberFour.txt");
						}
						boolPlague = memberActions4.get(4);
						if (boolPlague.equals("true")) {
							memberActions4 = ioFile.fileRead("StoreGame/CrewSelected/MemberFour.txt");
							int health = Integer.parseInt(memberActions4.get(0)) - 30;
							memberActions4.set(0, "" + health);
							ioFile.fileWrite(memberActions4, writeHealth + "MemberFour.txt");
						}
						}
					}
				}
				
			int x = (int)(Math.random()*((3-0)+0))+0;
			System.out.println(x);
			if (x == 1)
			{
				System.out.println("nothing");
				// reset Screen
					MainScreen screen = new MainScreen();
					screen.frame.setVisible(true);    // turn on screen
					frame.setVisible(false);         // turn off screen
			}
			if (x == 0)
			{ //to make the game a little easier, if anyone is dead, the plague will not happen, asteroids will though

				int makeNormal = 0;
				int curChar = 0;
				memberActions4 = ioFile.fileRead("StoreGame/CrewSelected/MemberFour.txt");
				check = memberActions4.get(7);
				if (check.equals("dead"))
				{

					curChar ++;
				}
				if (check.equals("alive"))
				{
					makeNormal++;
					curChar ++;
				}
				
				memberActions3 = ioFile.fileRead("StoreGame/CrewSelected/MemberThree.txt");
				check = memberActions3.get(7);
				if (check.equals("dead"))
				{

					curChar ++;
				}
				if (check.equals("alive"))
				{
					makeNormal++;
					curChar ++;

				}
				memberActions2 = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
				check = memberActions2.get(7);
				if (check.equals("dead"))
				{

					curChar ++;
				}
				if (check.equals("alive"))
				{
					makeNormal++;
					curChar ++;

				}
				
				memberActions1 = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
				check = memberActions1.get(7);
				if (check.equals("dead"))
				{

					curChar ++;
				}
				if (check.equals("alive"))
				{
					makeNormal++;
					curChar ++;

				}
				
				if (curChar == makeNormal ) //if the number of characters = number of alive characters, plague is possible
				System.out.println("plague");
//					SpaceOutpost outpost = new SpaceOutpost();
//					outpost.frame.setVisible(true);  // turn on screen
//					frame.setVisible(false);         // turn off screen
					
					spacePlague outpost = new spacePlague();
					outpost.frame.setVisible(true);  // turn on screen
					frame.setVisible(false);         // turn off screen
				if (curChar != makeNormal)  //if the number is different, eg. 1 or more is dead. only asteroids hit
				{
					System.out.println("asteroids");
					asteroids outpost2 = new asteroids();
					outpost2.frame.setVisible(true);
					frame.setVisible(false);
				}
			}
			if (x == 2)
			{
				System.out.println("aliens");
				alienPirates outpost = new alienPirates();
				outpost.frame.setVisible(true);
				frame.setVisible(false);
			}
			
			}
		}
		}
		);
	
		btnNextDay.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnNextDay.setBounds(561, 51, 249, 101);
		frame.getContentPane().add(btnNextDay);
	}
	
	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{
		// Setting Layout dimensions
		frame = new JFrame();
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
		frame.setBounds(display.x, display.y, display.width, display.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
//		frame.setUndecorated(true);  // Frame cannot be adjusted during game

		
		JPanel panel = new JPanel();
		panel.setBounds(884, 23, 1012, 646);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panelShip = new JPanel();
		panelShip.setBounds(23, 42, 530, 170);
		panel.add(panelShip);
		panelShip.setLayout(null);
		
		JLabel label = new JLabel("Name:");
		label.setBounds(60, 112, 55, 15);
		panelShip.add(label);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("Type:");
		label_4.setBounds(60, 74, 55, 15);
		panelShip.add(label_4);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblShipName = new JLabel("...");
		lblShipName.setBounds(127, 101, 132, 26);
		panelShip.add(lblShipName);
		lblShipName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblShipType = new JLabel("...");
		lblShipType.setBounds(127, 66, 132, 23);
		panelShip.add(lblShipType);
		lblShipType.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblParts = new JLabel("Parts: ...");
		lblParts.setFont(new Font("Dialog", Font.BOLD, 18));
		lblParts.setBounds(308, 75, 168, 33);
		frame.getContentPane().add(lblParts);
		
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setBounds(326, 36, 112, 23);
		panelShip.add(lblHealth);
		lblHealth.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		pBarShipHealth = new JProgressBar();
		pBarShipHealth.setStringPainted(true);
		pBarShipHealth.setBounds(259, 93, 223, 34);
		panelShip.add(pBarShipHealth);
		
		JLabel lblSp = new JLabel("Ship Info");
		lblSp.setBounds(175, 6, 84, 20);
		panelShip.add(lblSp);
		lblSp.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(497, 6, 81, 33);
		panel.add(lblStatus);
		lblStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		JPanel panelCrew = new JPanel();
		panelCrew.setBounds(23, 230, 965, 376);
		panel.add(panelCrew);
		panelCrew.setLayout(null);
	
		pBarHealth1 = new JProgressBar();
		pBarHealth1.setStringPainted(true);
		pBarHealth1.setBounds(204, 107, 146, 30);
		panelCrew.add(pBarHealth1);
		
		pBarTiredness1 = new JProgressBar();
		pBarTiredness1.setStringPainted(true);
		pBarTiredness1.setBounds(204, 171, 146, 30);
		panelCrew.add(pBarTiredness1);
		
		pBarTiredness3 = new JProgressBar();
		pBarTiredness3.setStringPainted(true);
		pBarTiredness3.setBounds(607, 165, 134, 36);
		panelCrew.add(pBarTiredness3);
		
		pBarTiredness4 = new JProgressBar();
		pBarTiredness4.setStringPainted(true);
		pBarTiredness4.setBounds(791, 171, 134, 30);
		panelCrew.add(pBarTiredness4);
		
		pBarHunger2 = new JProgressBar();
		pBarHunger2.setStringPainted(true);
		pBarHunger2.setBounds(429, 241, 126, 30);
		panelCrew.add(pBarHunger2);
		
		pBarHunger1 = new JProgressBar();
		pBarHunger1.setStringPainted(true);
		pBarHunger1.setBounds(204, 241, 146, 30);
		panelCrew.add(pBarHunger1);
		
		pBarTiredness2 = new JProgressBar();
		pBarTiredness2.setStringPainted(true);
		pBarTiredness2.setBounds(421, 171, 134, 30);
		panelCrew.add(pBarTiredness2);
		
		pBarHealth2 = new JProgressBar();
		pBarHealth2.setStringPainted(true);
		pBarHealth2.setBounds(409, 107, 146, 36);
		panelCrew.add(pBarHealth2);
		
		pBarHunger3 = new JProgressBar();
		pBarHunger3.setStringPainted(true);
		pBarHunger3.setBounds(607, 229, 146, 36);
		panelCrew.add(pBarHunger3);
		
		pBarHunger4 = new JProgressBar();
		pBarHunger4.setStringPainted(true);
		pBarHunger4.setBounds(791, 235, 146, 36);
		panelCrew.add(pBarHunger4);
		
		lblCashTotal = new JLabel("Current Cash = $ <dynamic>");
		lblCashTotal.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCashTotal.setBounds(66, 146, 326, 33);
		frame.getContentPane().add(lblCashTotal);
		
		lblMember4 = new JLabel("...");
		lblMember4.setBounds(791, 273, 134, 25);
		panelCrew.add(lblMember4);
		lblMember4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		lblMember3 = new JLabel("...");
		lblMember3.setBounds(615, 273, 138, 25);
		panelCrew.add(lblMember3);
		lblMember3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		lblMember2 = new JLabel("...");
		lblMember2.setBounds(419, 279, 119, 22);
		panelCrew.add(lblMember2);
		lblMember2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		JLabel lblCrew_1 = new JLabel("Crew Info");
		lblCrew_1.setBounds(435, 22, 112, 23);
		panelCrew.add(lblCrew_1);
		lblCrew_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblHunger_2 = new JLabel("Hunger:");
		lblHunger_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblHunger_2.setBounds(60, 245, 81, 15);
		panelCrew.add(lblHunger_2);
		
		JLabel lblHunger_1 = new JLabel("Tiredness:");
		lblHunger_1.setBounds(60, 188, 81, 15);
		panelCrew.add(lblHunger_1);
		lblHunger_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblHunger = new JLabel("Health:");
		lblHunger.setBounds(60, 125, 81, 15);
		panelCrew.add(lblHunger);
		lblHunger.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblNames = new JLabel("Name:");
		lblNames.setBounds(62, 278, 81, 15);
		panelCrew.add(lblNames);
		lblNames.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblMember4 = new JLabel("...");
		lblMember4.setBounds(791, 273, 134, 25);
		panelCrew.add(lblMember4);
		lblMember4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
//		ArrayList<String> crewMember4 = new ArrayList<String>(); // if this fella is dead, hide name :D
//		IOFile ioFile4 = new IOFile();
//		crewMember4 = ioFile4.fileRead("StoreGame/CrewSelected/MemberFour.txt");
//		String deadAlive4;
//		deadAlive4 = crewMember4.get(7);
//		if (deadAlive4.equals("dead"))
//		{
//			lblMember4.setVisible(false);
//		}
		
		lblMember3 = new JLabel("...");
		lblMember3.setBounds(615, 273, 138, 25);
		panelCrew.add(lblMember3);
		lblMember3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
//		ArrayList<String> crewMember3 = new ArrayList<String>(); // if this fella is dead, hide name :D
//		IOFile ioFile3 = new IOFile();
//		crewMember3 = ioFile3.fileRead("StoreGame/CrewSelected/MemberThree.txt");
//		String deadAlive3;
//		deadAlive3 = crewMember3.get(7);
//		if (deadAlive3.equals("dead"))
//		{
//			lblMember3.setVisible(false);
//		}
		
		lblMember2 = new JLabel("...");
		lblMember2.setBounds(419, 279, 119, 22);
		panelCrew.add(lblMember2);
		lblMember2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
//		ArrayList<String> crewMember2 = new ArrayList<String>(); // if this fella is dead, hide name :D
//		IOFile ioFile2 = new IOFile();
//		crewMember2 = ioFile2.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
//		String deadAlive2;
//		deadAlive2 = crewMember2.get(7);
//		if (deadAlive2.equals("dead"))
//		{
//			lblMember2.setVisible(false);
//		}
		
		lblMember1 = new JLabel("...");
		lblMember1.setBounds(214, 273, 117, 28);
		panelCrew.add(lblMember1);
		lblMember1.setFont(new Font("Lucida Grande", Font.PLAIN, 18)); 
//		ArrayList<String> crewMember1 = new ArrayList<String>(); // if this fella is dead, hide name :D
//		IOFile ioFile = new IOFile();
//		crewMember1 = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
//		String deadAlive;
//		deadAlive = crewMember1.get(7);
//		if (deadAlive.equals("dead"))
//		{
//			lblMember1.setVisible(false);
//		}
		
		pBarHealth3 = new JProgressBar();
		pBarHealth3.setStringPainted(true);
		pBarHealth3.setBounds(607, 101, 139, 36);
		panelCrew.add(pBarHealth3);
		
		pBarHealth4 = new JProgressBar();
		pBarHealth4.setStringPainted(true);
		pBarHealth4.setBounds(791, 107, 139, 36);
		panelCrew.add(pBarHealth4);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblType.setBounds(60, 85, 81, 15);
		panelCrew.add(lblType);
		
		lblCrewType1 = new JLabel("...");
		lblCrewType1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCrewType1.setBounds(221, 69, 129, 30);
		panelCrew.add(lblCrewType1);
		
		lblCrewType2 = new JLabel("...");
		lblCrewType2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCrewType2.setBounds(432, 76, 119, 23);
		panelCrew.add(lblCrewType2);
		
		lblCrewType3 = new JLabel("...");
		lblCrewType3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCrewType3.setBounds(624, 79, 129, 21);
		panelCrew.add(lblCrewType3);
		
		lblCrewType4 = new JLabel("...");
		lblCrewType4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblCrewType4.setBounds(803, 79, 134, 22);
		panelCrew.add(lblCrewType4);
		
		player1 = new JLabel("...");
		player1.setFont(new Font("Dialog", Font.PLAIN, 18));
		player1.setBounds(214, 313, 117, 28);
		panelCrew.add(player1);
		
		player2 = new JLabel("...");
		player2.setFont(new Font("Dialog", Font.PLAIN, 18));
		player2.setBounds(429, 313, 117, 28);
		panelCrew.add(player2);
		
		player3 = new JLabel("...");
		player3.setFont(new Font("Dialog", Font.PLAIN, 18));
		player3.setBounds(617, 310, 117, 28);
		panelCrew.add(player3);
		
		player4 = new JLabel("...");
		player4.setFont(new Font("Dialog", Font.PLAIN, 18));
		player4.setBounds(801, 310, 117, 28);
		panelCrew.add(player4);
		
		JLabel lblactions = new JLabel("Actions Left:");
		lblactions.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblactions.setBounds(44, 312, 126, 31);
		panelCrew.add(lblactions);
		
		
		lblDaysLeft = new JLabel("Day: ...");
		lblDaysLeft.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDaysLeft.setBounds(66, 75, 230, 33);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblDaysLeft);
		
		
		// Initialize storage arrays
		dispCrewType();
		dispCrewMember();
		
		pBarHealth();
		pBarTiredness();
		pBarHunger();
		
		
		// Button Actions
		spaceOutpost();
		newPlanet();
		explorePlanet();
		repairShields();
		btnInventory();
		nextDay();
		btnSleep();

	}
	
	
	/*
	 * Create the application.
	*/
	public MainScreen() 
	{
		initialize();
		bankStore();
		organizeGameInfo();
	}

	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
//					asteroids window = new asteroids();
//					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}