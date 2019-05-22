package NewPlanet;

//Library imports
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


import IOFile.IOFile;
import MainScreen.MainScreen;
import RandomEvents.asteroids;
import SearchPlanet.ExplorePlanet;
//Self implemented
import WindowSettings.Display;
import javax.swing.JCheckBox;


public class CrewTravel {

	public JFrame frame;
	
	private JLabel cpType1, cpType2, cpType3, cpType4;
	private JLabel cpName1, cpName2, cpName3, cpName4;
	private JButton btnSearchPlanet;
	

	private JProgressBar cpHealth1, cpHealth2, cpHealth3, cpHealth4;
	private JProgressBar cpTired1, cpTired2, cpTired3, cpTired4;
	private JProgressBar cpHunger1, cpHunger2, cpHunger3, cpHunger4;

	
	// stores the selection type
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewName = new ArrayList<String>();

	private JLabel type[] = new JLabel[4];
	private JLabel member[] = new JLabel[4];
	
	private String readFile = "StoreGame/CrewSelected/";	
	
	private JProgressBar health[] = new JProgressBar[4];
	private JProgressBar tiredness[] = new JProgressBar[4];
	private JProgressBar hunger[] = new JProgressBar [4];
	private JCheckBox character1, character2, character3, character4;
	private int countCrew = 0;
	

	// Store all progress bar so it can be used easily
	// Stores crew details in data arrays so it can be used easily
	private void cpHealth() 
	{
		health[0] = cpHealth1;
		health[1] = cpHealth2;
		health[2] = cpHealth3;
		health[3] = cpHealth4;
	}
	
	private void cpTired() 
	{
		tiredness[0] = cpTired1;
		tiredness[1] = cpTired2;
		tiredness[2] = cpTired3;
		tiredness[3] = cpTired4;
	}
	
	private void cpHunger() 
	{
		hunger[0] = cpHunger1;
		hunger[1] = cpHunger2;
		hunger[2] = cpHunger3;
		hunger[3] = cpHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void cpType() 
	{
		
		type[0] = cpType1;
		type[1] = cpType2;
		type[2] = cpType3;
		type[3] = cpType4;
	}
	
	private void cpName() 
	{
		member[0] = cpName1;
		member[1] = cpName2;
		member[2] = cpName3;
		member[3] = cpName4;
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
			if ((lsSize-size) == 2 && (index >= 2)) {
				disableInfo(index);
			} else if ((lsSize-size) == 3 && (index == 3)) {
				disableInfo(index);
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
	
	
	// organizing information from files
	private void organizeGameInfo()
	{
		// gather information stored in file
		IOFile ioFile = new IOFile();
		
		// Reading files
		ArrayList<String> crewInfo = ioFile.fileRead("StoreGame/CrewInfo.txt");
		
		// unwrap information
		decodeCrewInfo(crewInfo);
		
		readCrewRatings();
		
		for (int index = 0; index < crewType.size(); index++) {
			type[index].setText(crewType.get(index));
			member[index].setText(crewName.get(index));
		}
	}
		
	private void btnBack()
	{
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		btnBack.setBounds(1054, 594, 207, 69);
		frame.getContentPane().add(btnBack);
	}
	
	
	// Enable button if 2 characters have been chosen
	private void characterChoice()
	{
		character1 = new JCheckBox("Character 1");
//		this part detects if we have enough turns left, if not the radio button is disabled
		ArrayList<String> member = new ArrayList<String>();
		String actionLeft;
		String readFile = "StoreGame/CrewSelected/";
		IOFile ioFile = new IOFile();
		member = ioFile.fileRead(readFile + "MemberOne.txt");
		actionLeft = member.get(3);
		if (actionLeft.equals("0"))
				{
			character1.setEnabled(false);
				}
		
		character1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (character1.isSelected()) {
					countCrew++;
				} else {
					countCrew--;
				}
				
				if (countCrew == 2) {
					btnSearchPlanet.setEnabled(true);
				} else {
					btnSearchPlanet.setEnabled(false);
				}
			}
		});
		character1.setBounds(221, 372, 126, 23);
		frame.getContentPane().add(character1);
		
		
		character2 = new JCheckBox("Character 2");
		
//		this part detects if we have enough turns left, if not the radio button is disabled
		ArrayList<String> member2 = new ArrayList<String>();
		String actionLeft2;
		String readFile2 = "StoreGame/CrewSelected/";
		IOFile ioFile2 = new IOFile();
		member2 = ioFile2.fileRead(readFile2 + "MemberTwo.txt");
		actionLeft2 = member2.get(3);
		if (actionLeft2.equals("0"))
				{
			character2.setEnabled(false);
				}
		character2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (character2.isSelected()) {
					countCrew++;
				} else {
					countCrew--;
				}

				if (countCrew == 2) {
					btnSearchPlanet.setEnabled(true);
				} else {
					btnSearchPlanet.setEnabled(false);
				}
			}
		});
	
		character2.setBounds(429, 372, 126, 23);
		frame.getContentPane().add(character2);
		
		
		character3 = new JCheckBox("Character 3");
//		this part detects if we have enough turns left, if not the radio button is disabled
		ArrayList<String> member3 = new ArrayList<String>();
		String actionLeft3;
		String readFile3 = "StoreGame/CrewSelected/";
		IOFile ioFile3 = new IOFile();
		member3 = ioFile3.fileRead(readFile3 + "MemberThree.txt");
		actionLeft3 = member3.get(3);
		if (actionLeft3.equals("0"))
				{
			character3.setEnabled(false);
				}
		
		character3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (character3.isSelected()) {
					countCrew++;
				} else {
					countCrew--;
				}
				
				if (countCrew == 2) {
					btnSearchPlanet.setEnabled(true);
				} else {
					btnSearchPlanet.setEnabled(false);
				}
			}
		});
		character3.setBounds(624, 372, 126, 23);
		frame.getContentPane().add(character3);
		
		
		character4 = new JCheckBox("Character 4");
//		this part detects if we have enough turns left, if not the radio button is disabled
		ArrayList<String> member4 = new ArrayList<String>();
		String actionLeft4;
		String readFile4 = "StoreGame/CrewSelected/";
		IOFile ioFile4 = new IOFile();
		member4 = ioFile4.fileRead(readFile4 + "MemberFour.txt");
		actionLeft4 = member4.get(3);
		if (actionLeft4.equals("0"))
				{
			character4.setEnabled(false);
				}
		character4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (character4.isSelected()) {
					countCrew++;
				} else {
					countCrew--;
				}

				if (countCrew == 2) {
					btnSearchPlanet.setEnabled(true);
				} else {
					btnSearchPlanet.setEnabled(false);
				}
			}
		});
		character4.setBounds(803, 372, 126, 23);
		frame.getContentPane().add(character4);
	}
		
		
	private void disableMember()
	{
		IOFile ioFile = new IOFile();
		
		// Reading files
		ArrayList<String> crewMembers = ioFile.fileRead("StoreGame/CrewInfo.txt");
		
		if ((crewMembers.size()/2) == 2) {
			character3.setEnabled(false);
			character4.setEnabled(false);
		} else if ((crewMembers.size()/2) == 3) {
			character4.setEnabled(false);
		}
	}
	
	private void tiredRate(ArrayList<String> member, IOFile ioFile, String name)
	{
		member.set(3, ""+(Integer.parseInt(member.get(3)) - 1));
		int tired = Integer.parseInt(member.get(1));
		if (tired <= 0) //are we zero on tired! if so, take hp and make sure tired is set to zero
		{
			int health = Integer.parseInt(member.get(0)) - 30;
			member.set(0, "" + health);
			member.set(1, "" + 0);
			if (health <= 0)
			{
				member.set(7, "dead");
				member.set(0, "" + 0);
				member.set(1, "" + 0);
				member.set(2, "" + 0);
				member.set(3, "" + 0); //if dead no more turns
			}
			ioFile.fileWrite(member, readFile + name + ".txt");
		}
		else 
		{
			int tired1 = Integer.parseInt(member.get(1)) - 10; //above zero tired, so take some tired off
			member.set(1, "" + tired1);
			ioFile.fileWrite(member, readFile + name + ".txt");
		}
	}	
	private void btnSearch()
	{
		btnSearchPlanet = new JButton("Search for a new Planet");
		btnSearchPlanet.setEnabled(false);
		btnSearchPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				IOFile ioFile = new IOFile();
				ArrayList<String> member = new ArrayList<String>();
				ArrayList<String> updateFalse = new ArrayList<String>();
				
				// changes the member selected file
				if (character1.isSelected()) {
					member = ioFile.fileRead(readFile + "MemberOne.txt");
					tiredRate(member, ioFile, "MemberOne");
				} 
				if (character2.isSelected()) {
					member = ioFile.fileRead(readFile + "MemberTwo.txt");
					tiredRate(member, ioFile, "MemberTwo");
				} 
				if (character3.isSelected()) {
					member = ioFile.fileRead(readFile + "MemberThree.txt");
					tiredRate(member, ioFile, "MemberThree");
				} 
				if (character4.isSelected()) {
					member = ioFile.fileRead(readFile + "MemberFour.txt");
					tiredRate(member, ioFile, "MemberFour");
				} 
				updateFalse = ioFile.fileRead("StoreGame/ShipInfo.txt");
				updateFalse.set(3, "false");
				ioFile.fileWrite(updateFalse, "StoreGame/ShipInfo.txt");
				int x = (int)(Math.random()*((2-0)+0))+0;
				if (x == 1)
				{
					TravelPlanet screen = new TravelPlanet();
					screen.frame.setVisible(true);    // turn on screen
					frame.setVisible(false);          // turn off screen
				}
				if (x == 0)
				{
					System.out.println("asteroids");
					asteroids outpost = new asteroids();
					outpost.frame.setVisible(true);
					frame.setVisible(false);
				}
			}
		});
		frame.getContentPane().setLayout(null);
		btnSearchPlanet.setBounds(392, 514, 307, 122);
		frame.getContentPane().add(btnSearchPlanet);
	}
	
	
	// Storing and displaying the characters health
	private void memberOne(ArrayList<String> crewMember1, IOFile ioFile)
	{
		crewMember1 = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
		
		cpHealth1.setValue(Integer.valueOf(crewMember1.get(0)));
		cpTired1.setValue(Integer.valueOf(crewMember1.get(1)));
		cpHunger1.setValue(Integer.valueOf(crewMember1.get(2)));
	}
	
	private void memberTwo(ArrayList<String> crewMember2, IOFile ioFile)
	{
		crewMember2 = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
		
		cpHealth2.setValue(Integer.valueOf(crewMember2.get(0)));
		cpTired2.setValue(Integer.valueOf(crewMember2.get(1)));
		cpHunger2.setValue(Integer.valueOf(crewMember2.get(2)));
	}
	
	private void memberThree(ArrayList<String> crewMember3, IOFile ioFile)
	{
		crewMember3 = ioFile.fileRead("StoreGame/CrewSelected/MemberThree.txt");
		
		cpHealth3.setValue(Integer.valueOf(crewMember3.get(0)));
		cpTired3.setValue(Integer.valueOf(crewMember3.get(1)));
		cpHunger3.setValue(Integer.valueOf(crewMember3.get(2)));
	}
	
	private void memberFour(ArrayList<String> crewMember4, IOFile ioFile)
	{
		crewMember4 = ioFile.fileRead("StoreGame/CrewSelected/MemberFour.txt");
		
		cpHealth4.setValue(Integer.valueOf(crewMember4.get(0)));
		cpTired4.setValue(Integer.valueOf(crewMember4.get(1)));
		cpHunger4.setValue(Integer.valueOf(crewMember4.get(2)));
	}
	
	
	private void readCrewRatings()
	{ 
		ArrayList<String> crewMember1 = new ArrayList<String>();
		ArrayList<String> crewMember2 = new ArrayList<String>();
		ArrayList<String> crewMember3 = new ArrayList<String>();
		ArrayList<String> crewMember4 = new ArrayList<String>();
		IOFile ioFile = new IOFile();
		
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
	
	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() {
		// Setting Layout dimensions
		frame = new JFrame();
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
		frame.setBounds(display.x, display.y, display.width, display.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
//		frame.setUndecorated(true);  // Frame cannot be adjusted during game
		
		
		cpHealth1 = new JProgressBar();
		cpHealth1.setStringPainted(true);
		cpHealth1.setBounds(204, 107, 146, 30);
		frame.getContentPane().add(cpHealth1);

		cpTired1 = new JProgressBar();
		cpTired1.setStringPainted(true);
		cpTired1.setBounds(204, 171, 146, 30);
		frame.getContentPane().add(cpTired1);
	
		cpHunger1 = new JProgressBar();
		cpHunger1.setStringPainted(true);
		cpHunger1.setBounds(204, 241, 146, 30);
		frame.getContentPane().add(cpHunger1);
	
		cpHealth2 = new JProgressBar();
		cpHealth2.setStringPainted(true);
		cpHealth2.setBounds(409, 107, 146, 30);
		frame.getContentPane().add(cpHealth2);
		
		cpTired2 = new JProgressBar();
		cpTired2.setStringPainted(true);
		cpTired2.setBounds(409, 171, 146, 30);
		frame.getContentPane().add(cpTired2);
		
		cpHunger2 = new JProgressBar();
		cpHunger2.setStringPainted(true);
		cpHunger2.setBounds(409, 241, 146, 30);
		frame.getContentPane().add(cpHunger2);

		cpHealth3 = new JProgressBar();
		cpHealth3.setStringPainted(true);
		cpHealth3.setBounds(607, 107, 146, 30);
		frame.getContentPane().add(cpHealth3);
		
		cpTired3 = new JProgressBar();
		cpTired3.setStringPainted(true);
		cpTired3.setBounds(607, 171, 146, 30);
		frame.getContentPane().add(cpTired3);

		cpHunger3 = new JProgressBar();
		cpHunger3.setStringPainted(true);
		cpHunger3.setBounds(607, 241, 146, 30);
		frame.getContentPane().add(cpHunger3);

		cpHealth4 = new JProgressBar();
		cpHealth4.setStringPainted(true);
		cpHealth4.setBounds(791, 107, 146, 30);
		frame.getContentPane().add(cpHealth4);
		
		cpTired4 = new JProgressBar();
		cpTired4.setStringPainted(true);
		cpTired4.setBounds(791, 171, 146, 30);
		frame.getContentPane().add(cpTired4);
		
		cpHunger4 = new JProgressBar();
		cpHunger4.setStringPainted(true);
		cpHunger4.setBounds(791, 241, 146, 30);
		frame.getContentPane().add(cpHunger4);

		cpName4 = new JLabel("...");
		cpName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName4.setBounds(791, 275, 127, 23);
		frame.getContentPane().add(cpName4);

		cpName3 = new JLabel("...");
		cpName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName3.setBounds(607, 275, 126, 23);
		frame.getContentPane().add(cpName3);

		cpName2 = new JLabel("...");
		cpName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName2.setBounds(419, 279, 119, 22);
		frame.getContentPane().add(cpName2);
		
		cpName1 = new JLabel("...");
		cpName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName1.setBounds(214, 273, 117, 28);
		frame.getContentPane().add(cpName1);
		
		JLabel label = new JLabel("Crew Info");
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(435, 22, 112, 23);
		frame.getContentPane().add(label);
	
		JLabel label0 = new JLabel("Hunger:");
		label0.setFont(new Font("Dialog", Font.PLAIN, 16));
		label0.setBounds(60, 245, 81, 15);
		frame.getContentPane().add(label0);

		JLabel label1 = new JLabel("Tiredness:");
		label1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label1.setBounds(60, 188, 81, 15);
		frame.getContentPane().add(label1);
	
		JLabel label2 = new JLabel("Health:");
		label2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(60, 125, 81, 15);
		frame.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Name:");
		label3.setFont(new Font("Dialog", Font.PLAIN, 16));
		label3.setBounds(62, 278, 81, 15);
		frame.getContentPane().add(label3);

		JLabel label4 = new JLabel("Type:");
		label4.setFont(new Font("Dialog", Font.PLAIN, 16));
		label4.setBounds(60, 85, 81, 15);
		frame.getContentPane().add(label4);

		cpType1 = new JLabel("...");
		cpType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpType1.setBounds(221, 69, 129, 30);
		frame.getContentPane().add(cpType1);

		cpType2 = new JLabel("...");
		cpType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpType2.setBounds(432, 76, 119, 23);
		frame.getContentPane().add(cpType2);

		cpType3 = new JLabel("...");
		cpType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpType3.setBounds(624, 79, 129, 21);
		frame.getContentPane().add(cpType3);

		cpType4 = new JLabel("...");
		cpType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpType4.setBounds(803, 79, 134, 22);
		frame.getContentPane().add(cpType4);
		frame.getContentPane().setLayout(null);
			

		//initialize storage arrays
		cpType();
		cpName();
		
		cpHealth();
		cpTired();
		cpHunger();
		
		// Button actions
		
		btnSearch();
		characterChoice();
		disableMember();
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public CrewTravel() {
		initialize();
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
					CrewTravel window = new CrewTravel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
