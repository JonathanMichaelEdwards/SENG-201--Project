package SearchPlanet;

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
import javax.swing.JRadioButton;

import IOFile.IOFile;
import MainScreen.MainScreen;
//Self implemented
import WindowSettings.Display;
import javax.swing.JCheckBox;


public class CrewPlanet {

	public JFrame frame;
	
	private JLabel cBType1, cBType2, cBType3, cBType4;
	private JLabel cpName1, cpName2, cpName3, cpName4;
	private JRadioButton rBChar1, rBChar2, rBChar3, rBChar4;
	private JButton btnSearchPlanet;
	

	private JProgressBar cBHealth1, cBHealth2, cBHealth3, cBHealth4;
	private JProgressBar cBTired1, cBTired2, cBTired3, cBTired4;
	private JProgressBar cBHunger1, cBHunger2, cBHunger3, cBHunger4;
	
	// File locations
	private String readCrew = "StoreGame/CrewRatings/";
	private String readFile = "StoreGame/CrewSelected/";	
	
	// stores the selection type
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewName = new ArrayList<String>();

	private JLabel type[] = new JLabel[4];
	private JLabel member[] = new JLabel[4];
	
	
	private JProgressBar health[] = new JProgressBar[4];
	private JProgressBar tiredness[] = new JProgressBar[4];
	private JProgressBar hunger[] = new JProgressBar [4];
	

	// Store all progress bar so it can be used easily
	// Stores crew details in data arrays so it can be used easily
	private void cBHealth() 
	{
		health[0] = cBHealth1;
		health[1] = cBHealth2;
		health[2] = cBHealth3;
		health[3] = cBHealth4;
	}
	
	private void cBTired() 
	{
		tiredness[0] = cBTired1;
		tiredness[1] = cBTired2;
		tiredness[2] = cBTired3;
		tiredness[3] = cBTired4;
	}
	
	private void cBHunger() 
	{
		hunger[0] = cBHunger1;
		hunger[1] = cBHunger2;
		hunger[2] = cBHunger3;
		hunger[3] = cBHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void cBType() 
	{
		
		type[0] = cBType1;
		type[1] = cBType2;
		type[2] = cBType3;
		type[3] = cBType4;
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
	
	

	// Storing and displaying the characters health
	private void memberOne(ArrayList<String> crewMember1, IOFile ioFile)
	{
		crewMember1 = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
		
		cBHealth1.setValue(Integer.valueOf(crewMember1.get(0)));
		cBTired1.setValue(Integer.valueOf(crewMember1.get(1)));
		cBHunger1.setValue(Integer.valueOf(crewMember1.get(2)));
	}
	
	private void memberTwo(ArrayList<String> crewMember2, IOFile ioFile)
	{
		crewMember2 = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
		
		cBHealth2.setValue(Integer.valueOf(crewMember2.get(0)));
		cBTired2.setValue(Integer.valueOf(crewMember2.get(1)));
		cBHunger2.setValue(Integer.valueOf(crewMember2.get(2)));
	}
	
	private void memberThree(ArrayList<String> crewMember3, IOFile ioFile)
	{
		crewMember3 = ioFile.fileRead("StoreGame/CrewSelected/MemberThree.txt");
		
		cBHealth3.setValue(Integer.valueOf(crewMember3.get(0)));
		cBTired3.setValue(Integer.valueOf(crewMember3.get(1)));
		cBHunger3.setValue(Integer.valueOf(crewMember3.get(2)));
	}
	
	private void memberFour(ArrayList<String> crewMember4, IOFile ioFile)
	{
		crewMember4 = ioFile.fileRead("StoreGame/CrewSelected/MemberFour.txt");
		
		cBHealth4.setValue(Integer.valueOf(crewMember4.get(0)));
		cBTired4.setValue(Integer.valueOf(crewMember4.get(1)));
		cBHunger4.setValue(Integer.valueOf(crewMember4.get(2)));
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
	
	
	
	private void clearSearch()
	{
		rBChar1.setSelected(false);
		rBChar2.setSelected(false);
		rBChar3.setSelected(false);
		rBChar4.setSelected(false);
	}
	
	
	private void disableMember()
	{
		IOFile ioFile = new IOFile();
		
		// Reading files
		ArrayList<String> crewMembers = ioFile.fileRead("StoreGame/CrewInfo.txt");
		
		if ((crewMembers.size()/2) == 2) {
			rBChar3.setEnabled(false);
			rBChar4.setEnabled(false);
		} else if ((crewMembers.size()/2) == 3) {
			rBChar4.setEnabled(false);
		}
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
	
	private void btnSearch()
	{
		btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.setEnabled(false);
		btnSearchPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				IOFile ioFile = new IOFile();
				ArrayList<String> member = new ArrayList<String>();
				
				String readFile = "StoreGame/CrewSelected/";
				
				// changes the member selected file
				if (rBChar1.isSelected()) {
					member = ioFile.fileRead(readFile + "MemberOne.txt");
					tiredRate(member, ioFile, "MemberOne");
				} 
				if (rBChar2.isSelected()) {
					member = ioFile.fileRead(readFile + "MemberTwo.txt");
					tiredRate(member, ioFile, "MemberTwo");
				} 
				if (rBChar3.isSelected()) {
					member = ioFile.fileRead(readFile + "MemberThree.txt");
					tiredRate(member, ioFile, "MemberThree");
				} 
				if (rBChar4.isSelected()) {
					member = ioFile.fileRead(readFile + "MemberFour.txt");
					tiredRate(member, ioFile, "MemberFour");
				}
				
				ExplorePlanet screen = new ExplorePlanet();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().setLayout(null);
		btnSearchPlanet.setBounds(392, 514, 307, 122);
		frame.getContentPane().add(btnSearchPlanet);
	}
	
	
	// characters that can be chosen
	private void characterChoice()
	{
		rBChar1 = new JRadioButton("character 1");
		rBChar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSearch();
				rBChar1.setSelected(true);
				btnSearchPlanet.setEnabled(true);
			}
		});
		rBChar1.setBounds(214, 327, 144, 23);
		frame.getContentPane().add(rBChar1);
		
		
		rBChar2 = new JRadioButton("character 2");
		rBChar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSearch();
				rBChar2.setSelected(true);
				btnSearchPlanet.setEnabled(true);
			}
		});
		rBChar2.setBounds(428, 327, 144, 23);
		frame.getContentPane().add(rBChar2);
		
		
		rBChar3 = new JRadioButton("character 3");
		rBChar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSearch();
				rBChar3.setSelected(true);
				btnSearchPlanet.setEnabled(true);
			}
		});
		rBChar3.setBounds(607, 327, 144, 23);
		frame.getContentPane().add(rBChar3);
		
		
		rBChar4 = new JRadioButton("character 4");
		rBChar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSearch();
				rBChar4.setSelected(true);
				btnSearchPlanet.setEnabled(true);
			}
		});
		rBChar4.setBounds(791, 327, 144, 23);
		frame.getContentPane().add(rBChar4);
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
		
		cBHealth1 = new JProgressBar();
		cBHealth1.setBounds(204, 107, 146, 30);
		frame.getContentPane().add(cBHealth1);

		cBTired1 = new JProgressBar();
		cBTired1.setBounds(204, 171, 146, 30);
		frame.getContentPane().add(cBTired1);
	

		cBHunger1 = new JProgressBar();
		cBHunger1.setBounds(204, 241, 146, 30);
		frame.getContentPane().add(cBHunger1);
		
	
		cBHealth2 = new JProgressBar();
		cBHealth2.setBounds(409, 107, 146, 30);
		frame.getContentPane().add(cBHealth2);
		

		cBTired2 = new JProgressBar();
		cBTired2.setBounds(409, 171, 146, 30);
		frame.getContentPane().add(cBTired2);
		
	
		cBHunger2 = new JProgressBar();
		cBHunger2.setBounds(409, 241, 146, 30);
		frame.getContentPane().add(cBHunger2);
	

		cBHealth3 = new JProgressBar();
		cBHealth3.setBounds(607, 107, 146, 30);
		frame.getContentPane().add(cBHealth3);
		
	
		cBTired3 = new JProgressBar();
		cBTired3.setBounds(607, 171, 146, 30);
		frame.getContentPane().add(cBTired3);

		cBHunger3 = new JProgressBar();
		cBHunger3.setBounds(607, 241, 146, 30);
		frame.getContentPane().add(cBHunger3);

		cBHealth4 = new JProgressBar();
		cBHealth4.setBounds(791, 107, 146, 30);
		frame.getContentPane().add(cBHealth4);
		
		cBTired4 = new JProgressBar();
		cBTired4.setBounds(791, 171, 146, 30);
		frame.getContentPane().add(cBTired4);
		
		cBHunger4 = new JProgressBar();
		cBHunger4.setBounds(791, 241, 146, 30);
		frame.getContentPane().add(cBHunger4);

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

		cBType1 = new JLabel("...");
		cBType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType1.setBounds(221, 69, 129, 30);
		frame.getContentPane().add(cBType1);

		cBType2 = new JLabel("...");
		cBType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType2.setBounds(432, 76, 119, 23);
		frame.getContentPane().add(cBType2);

		cBType3 = new JLabel("...");
		cBType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType3.setBounds(624, 79, 129, 21);
		frame.getContentPane().add(cBType3);
	

		cBType4 = new JLabel("...");
		cBType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType4.setBounds(803, 79, 134, 22);
		frame.getContentPane().add(cBType4);
		
		frame.getContentPane().setLayout(null);
		
		

		//initialize storage arrays
		cBType();
		cpName();
		
		cBHealth();
		cBTired();
		cBHunger();
		
		// Button actions
		btnSearch();
		characterChoice();
		disableMember();
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public CrewPlanet() {
		initialize();
		organizeGameInfo();
	}
	
	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewPlanet window = new CrewPlanet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
