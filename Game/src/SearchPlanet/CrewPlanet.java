package SearchPlanet;

//Library imports
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import IOFile.IOFile;
import MainScreen.MainScreen;
import RepairShields.CrewRepair;
//Self implemented
import WindowSettings.Display;
import javax.swing.JCheckBox;


public class CrewPlanet {

	public JFrame frmEliteDangerousBeta;
	
	private JLabel cBType1, cBType2, cBType3, cBType4;
	private JLabel cpName1, cpName2, cpName3, cpName4;
	private JRadioButton rBChar1, rBChar2, rBChar3, rBChar4;
	private JButton btnSearchPlanet;
	

	private JProgressBar cBHealth1, cBHealth2, cBHealth3, cBHealth4;
	private JProgressBar cBTired1, cBTired2, cBTired3, cBTired4;
	private JProgressBar cBHunger1, cBHunger2, cBHunger3, cBHunger4;
	
	// File locations
	private String readCrew = "src/StoreGame/CrewRatings/";
	private String readFile = "src/StoreGame/CrewSelected/";	
	
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
	protected void addCrew(ArrayList<String> crewInfo, int size)
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
			} else if ((lsSize-size) == 1 && (index == 3)) {
				disableInfo(index);
			}
		}
	}

	
	// decode crew information to get correct data
	protected void decodeCrewInfo(ArrayList<String> crewInfo)
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
		crewMember1 = ioFile.fileRead("src/StoreGame/CrewSelected/MemberOne.txt");
		
		cBHealth1.setValue(Integer.valueOf(crewMember1.get(0)));
		cBTired1.setValue(Integer.valueOf(crewMember1.get(1)));
		cBHunger1.setValue(Integer.valueOf(crewMember1.get(2)));
	}
	
	private void memberTwo(ArrayList<String> crewMember2, IOFile ioFile)
	{
		crewMember2 = ioFile.fileRead("src/StoreGame/CrewSelected/MemberTwo.txt");
		
		cBHealth2.setValue(Integer.valueOf(crewMember2.get(0)));
		cBTired2.setValue(Integer.valueOf(crewMember2.get(1)));
		cBHunger2.setValue(Integer.valueOf(crewMember2.get(2)));
	}
	
	private void memberThree(ArrayList<String> crewMember3, IOFile ioFile)
	{
		crewMember3 = ioFile.fileRead("src/StoreGame/CrewSelected/MemberThree.txt");
		
		cBHealth3.setValue(Integer.valueOf(crewMember3.get(0)));
		cBTired3.setValue(Integer.valueOf(crewMember3.get(1)));
		cBHunger3.setValue(Integer.valueOf(crewMember3.get(2)));
	}
	
	private void memberFour(ArrayList<String> crewMember4, IOFile ioFile)
	{
		crewMember4 = ioFile.fileRead("src/StoreGame/CrewSelected/MemberFour.txt");
		
		cBHealth4.setValue(Integer.valueOf(crewMember4.get(0)));
		cBTired4.setValue(Integer.valueOf(crewMember4.get(1)));
		cBHunger4.setValue(Integer.valueOf(crewMember4.get(2)));
	}
	
	
	protected void readCrewRatings()
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
	protected void organizeGameInfo()
	{
		// gather information stored in file
		IOFile ioFile = new IOFile();
		
		// Reading files
		ArrayList<String> crewInfo = ioFile.fileRead("src/StoreGame/CrewInfo.txt");
		
		// unwrap information
		decodeCrewInfo(crewInfo);
		readCrewRatings();
		
		for (int index = 0; index < crewType.size(); index++) {
			type[index].setText(crewType.get(index));
			member[index].setText(crewName.get(index));
		}
	}
		
	protected void btnBack()
	{
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				MainScreen screen = new MainScreen();
				screen.frmEliteDangerousBeta.setVisible(true);    // turn on screen
				frmEliteDangerousBeta.setVisible(false);          // turn off screen
			}
		});
		btnBack.setBounds(940, 700, 250, 100);
		frmEliteDangerousBeta.getContentPane().add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(CrewRepair.class.getResource("/gameImages/crew.PNG")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(0, 0, 1920, 1080);
		frmEliteDangerousBeta.getContentPane().add(label);
	}
	
	
	
	protected void clearSearch()
	{
		rBChar1.setSelected(false);
		rBChar2.setSelected(false);
		rBChar3.setSelected(false);
		rBChar4.setSelected(false);
	}
	
	
	protected void disableMember()
	{
		IOFile ioFile = new IOFile();
		
		// Reading files
		ArrayList<String> crewMembers = ioFile.fileRead("src/StoreGame/CrewInfo.txt");
		
		if ((crewMembers.size()/2) == 2) {
			rBChar3.setEnabled(false);
			rBChar4.setEnabled(false);
		} else if ((crewMembers.size()/2) == 3) {
			rBChar4.setEnabled(false);
		}
	}
	protected void tiredRate(ArrayList<String> member, IOFile ioFile, String name)
	{
		member.set(3, ""+(Integer.parseInt(member.get(3)) - 1));
		int tired = Integer.parseInt(member.get(1));
		if (tired <= 0)
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
			int tired1 = Integer.parseInt(member.get(1)) - 10; //this is the value in which a repair heals
			member.set(1, "" + tired1);
			ioFile.fileWrite(member, readFile + name + ".txt");
		}
	}	
	

	protected void btnSearch()
	{
		btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.setEnabled(false);
		btnSearchPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				IOFile ioFile = new IOFile();
				ArrayList<String> member = new ArrayList<String>();
				
				String readFile = "src/StoreGame/CrewSelected/";
				
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
				screen.frmEliteDangerousBeta.setVisible(true);    // turn on screen
				frmEliteDangerousBeta.setVisible(false);          // turn off screen
			}
		});
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		btnSearchPlanet.setBounds(1200, 700, 250, 100);
		frmEliteDangerousBeta.getContentPane().add(btnSearchPlanet);
	}
	
	
	// characters that can be chosen
	protected void characterChoice()
	{
		rBChar1 = new JRadioButton("character 1");
		ArrayList<String> member = new ArrayList<String>();
		String actionLeft;
		String readFile = "src/StoreGame/CrewSelected/";
		IOFile ioFile = new IOFile();
		member = ioFile.fileRead(readFile + "MemberOne.txt");
		actionLeft = member.get(3);
		if (actionLeft.equals("0"))
				{
			rBChar1.setEnabled(false);
				}
		
		rBChar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSearch();
				rBChar1.setSelected(true);
				btnSearchPlanet.setEnabled(true);
			}
		});
		rBChar1.setBounds(661, 530, 126, 23);
		frmEliteDangerousBeta.getContentPane().add(rBChar1);
		
		
		rBChar2 = new JRadioButton("character 2");
		
		ArrayList<String> member2 = new ArrayList<String>();
		String actionLeft2;
		String readFile2 = "src/StoreGame/CrewSelected/";
		IOFile ioFile2 = new IOFile();
		member2 = ioFile2.fileRead(readFile2 + "MemberTwo.txt");
		actionLeft2 = member2.get(3);
		if (actionLeft2.equals("0"))
				{
			rBChar2.setEnabled(false);
				}
		
		rBChar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSearch();
				rBChar2.setSelected(true);
				btnSearchPlanet.setEnabled(true);
			}
		});
		rBChar2.setBounds(848, 530, 126, 23);
		frmEliteDangerousBeta.getContentPane().add(rBChar2);
		
		
		rBChar3 = new JRadioButton("character 3");
		
		ArrayList<String> member3 = new ArrayList<String>();
		String actionLeft3;
		String readFile3 = "src/StoreGame/CrewSelected/";
		IOFile ioFile3 = new IOFile();
		member3 = ioFile3.fileRead(readFile3 + "MemberThree.txt");
		actionLeft3 = member3.get(3);
		if (actionLeft3.equals("0"))
				{
			rBChar3.setEnabled(false);
				}
		
		rBChar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSearch();
				rBChar3.setSelected(true);
				btnSearchPlanet.setEnabled(true);
			}
		});
		rBChar3.setBounds(1039, 530, 126, 23);
		frmEliteDangerousBeta.getContentPane().add(rBChar3);
		
		
		rBChar4 = new JRadioButton("character 4");
		ArrayList<String> member4 = new ArrayList<String>();
		String actionLeft4;
		String readFile4 = "src/StoreGame/CrewSelected/";
		IOFile ioFile4 = new IOFile();
		member4 = ioFile4.fileRead(readFile4 + "MemberFour.txt");
		actionLeft4 = member4.get(3);
		if (actionLeft4.equals("0"))
				{
			rBChar4.setEnabled(false);
				}
		
		rBChar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSearch();
				rBChar4.setSelected(true);
				btnSearchPlanet.setEnabled(true);
			}
		});
		rBChar4.setBounds(1248, 530, 126, 23);
		frmEliteDangerousBeta.getContentPane().add(rBChar4);
	}
		
		
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() {
		// Setting Layout dimensions
		frmEliteDangerousBeta = new JFrame();
		frmEliteDangerousBeta.setTitle("Elite Dangerous beta");
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
<<<<<<< Updated upstream
		frmEliteDangerousBeta.setBounds(display.x, display.y, display.width, display.height);
		frmEliteDangerousBeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliteDangerousBeta.setResizable(false);
//		frame.setUndecorated(true);  // Frame cannot be adjusted during game
=======
		frame.setBounds(display.x, display.y, display.width, display.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
>>>>>>> Stashed changes
		
		cBHealth1 = new JProgressBar();
		cBHealth1.setBounds(661, 326, 150, 30);
		cBHealth1.setStringPainted(true);
		frmEliteDangerousBeta.getContentPane().add(cBHealth1);

		cBTired1 = new JProgressBar();
		cBTired1.setBounds(661, 363, 150, 30);
		cBTired1.setStringPainted(true);
<<<<<<< Updated upstream
		frmEliteDangerousBeta.getContentPane().add(cBTired1);
=======
		frame.getContentPane().add(cBTired1);
<<<<<<< Updated upstream
>>>>>>> Stashed changes
	
=======

>>>>>>> Stashed changes
		cBHunger1 = new JProgressBar();
		cBHunger1.setBounds(661, 405, 150, 30);
		cBHunger1.setStringPainted(true);
<<<<<<< Updated upstream
		frmEliteDangerousBeta.getContentPane().add(cBHunger1);
=======
		frame.getContentPane().add(cBHunger1);
<<<<<<< Updated upstream
>>>>>>> Stashed changes
	
=======
		
>>>>>>> Stashed changes
		cBHealth2 = new JProgressBar();
		cBHealth2.setBounds(848, 326, 150, 30);
		cBHealth2.setStringPainted(true);
<<<<<<< Updated upstream
		frmEliteDangerousBeta.getContentPane().add(cBHealth2);
=======
		frame.getContentPane().add(cBHealth2);
<<<<<<< Updated upstream
>>>>>>> Stashed changes
		
=======
	
>>>>>>> Stashed changes
		cBTired2 = new JProgressBar();
		cBTired2.setBounds(848, 363, 150, 30);
		cBTired2.setStringPainted(true);
		frmEliteDangerousBeta.getContentPane().add(cBTired2);
		
		cBHunger2 = new JProgressBar();
		cBHunger2.setBounds(848, 403, 150, 30);
		cBHunger2.setStringPainted(true);
		frmEliteDangerousBeta.getContentPane().add(cBHunger2);

		cBHealth3 = new JProgressBar();
		cBHealth3.setBounds(1039, 326, 150, 30);
		cBHealth3.setStringPainted(true);
<<<<<<< Updated upstream
		frmEliteDangerousBeta.getContentPane().add(cBHealth3);
=======
		frame.getContentPane().add(cBHealth3);
<<<<<<< Updated upstream
>>>>>>> Stashed changes
		
=======
	
>>>>>>> Stashed changes
		cBTired3 = new JProgressBar();
		cBTired3.setBounds(1039, 363, 150, 30);
		cBTired3.setStringPainted(true);
		frmEliteDangerousBeta.getContentPane().add(cBTired3);

		cBHunger3 = new JProgressBar();
		cBHunger3.setBounds(1039, 403, 150, 30);
		cBHunger3.setStringPainted(true);
		frmEliteDangerousBeta.getContentPane().add(cBHunger3);

		cBHealth4 = new JProgressBar();
		cBHealth4.setBounds(1237, 326, 150, 30);
		cBHealth4.setStringPainted(true);
		frmEliteDangerousBeta.getContentPane().add(cBHealth4);
		
		cBTired4 = new JProgressBar();
		cBTired4.setBounds(1237, 363, 150, 30);
		cBTired4.setStringPainted(true);
		frmEliteDangerousBeta.getContentPane().add(cBTired4);
		
		cBHunger4 = new JProgressBar();
		cBHunger4.setBounds(1237, 403, 150, 30);
		cBHunger4.setStringPainted(true);
		frmEliteDangerousBeta.getContentPane().add(cBHunger4);

		cpName4 = new JLabel("...");
		cpName4.setOpaque(true);
		cpName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName4.setBounds(1237, 445, 150, 30);
		frmEliteDangerousBeta.getContentPane().add(cpName4);

		cpName3 = new JLabel("...");
		cpName3.setOpaque(true);
		cpName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName3.setBounds(1039, 445, 150, 30);
		frmEliteDangerousBeta.getContentPane().add(cpName3);

		cpName2 = new JLabel("...");
		cpName2.setOpaque(true);
		cpName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName2.setBounds(848, 445, 150, 30);
		frmEliteDangerousBeta.getContentPane().add(cpName2);
		
		cpName1 = new JLabel("...");
		cpName1.setOpaque(true);
		cpName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName1.setBounds(661, 447, 150, 30);
		frmEliteDangerousBeta.getContentPane().add(cpName1);
		
		JLabel label = new JLabel("Crew Info");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(909, 238, 150, 30);
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
<<<<<<< Updated upstream
		frmEliteDangerousBeta.getContentPane().add(label);
=======
		frame.getContentPane().add(label);
<<<<<<< Updated upstream
>>>>>>> Stashed changes
	
=======

>>>>>>> Stashed changes
		JLabel label0 = new JLabel("Hunger:");
		label0.setOpaque(true);
		label0.setBounds(517, 403, 111, 30);
		label0.setFont(new Font("Dialog", Font.PLAIN, 16));
		frmEliteDangerousBeta.getContentPane().add(label0);

		JLabel label1 = new JLabel("Tiredness:");
		label1.setOpaque(true);
		label1.setBounds(517, 361, 111, 30);
		label1.setFont(new Font("Dialog", Font.PLAIN, 16));
<<<<<<< Updated upstream
		frmEliteDangerousBeta.getContentPane().add(label1);
=======
		frame.getContentPane().add(label1);
<<<<<<< Updated upstream
>>>>>>> Stashed changes
	
=======

>>>>>>> Stashed changes
		JLabel label2 = new JLabel("Health:");
		label2.setOpaque(true);
		label2.setBounds(517, 324, 111, 30);
		label2.setFont(new Font("Dialog", Font.PLAIN, 16));
		frmEliteDangerousBeta.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Name:");
		label3.setOpaque(true);
		label3.setBounds(517, 445, 111, 30);
		label3.setFont(new Font("Dialog", Font.PLAIN, 16));
		frmEliteDangerousBeta.getContentPane().add(label3);

		JLabel label4 = new JLabel("Type:");
		label4.setOpaque(true);
		label4.setBounds(517, 284, 111, 30);
		label4.setFont(new Font("Dialog", Font.PLAIN, 16));
		frmEliteDangerousBeta.getContentPane().add(label4);

		cBType1 = new JLabel("...");
		cBType1.setOpaque(true);
		cBType1.setBounds(661, 284, 150, 30);
		cBType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frmEliteDangerousBeta.getContentPane().add(cBType1);

		cBType2 = new JLabel("...");
		cBType2.setOpaque(true);
		cBType2.setBounds(848, 280, 150, 34);
		cBType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frmEliteDangerousBeta.getContentPane().add(cBType2);

		cBType3 = new JLabel("...");
		cBType3.setOpaque(true);
		cBType3.setBounds(1039, 284, 150, 30);
		cBType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frmEliteDangerousBeta.getContentPane().add(cBType3);

		cBType4 = new JLabel("...");
		cBType4.setOpaque(true);
		cBType4.setBounds(1237, 284, 150, 30);
		cBType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		frmEliteDangerousBeta.getContentPane().add(cBType4);
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		

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
	public CrewPlanet() 
	{
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
					CrewPlanet window = new CrewPlanet();
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
