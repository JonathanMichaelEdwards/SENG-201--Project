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
	
	// Stored information that the user has chosen
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewName = new ArrayList<String>();
	private String shipType;
	private String shipName;
	private int days;
	private int parts;
	private int repair;
	
	// stores the selection type
	private JLabel type[] = new JLabel[6];
	private JLabel member[] = new JLabel[6];
	
	
	private JProgressBar health[] = new JProgressBar[4];
	private JProgressBar tiredness[] = new JProgressBar[4];
	private JProgressBar hunger[] = new JProgressBar [4];
	private JButton btnSleep;
	
	
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
		diasbleStatus(size);
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
	private void diasbleStatus(int size)
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
		if ((crewInfo.size()-1) == 4) addCrew(crewInfo, 2);
		else if ((crewInfo.size()-1) == 6) addCrew(crewInfo, 3);
		else if ((crewInfo.size()-1) == 8) addCrew(crewInfo, 4);
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
		
		// unwrap information
		decodeCrewInfo(crewInfo);
		
		shipType = shipInfo.get(0);
		shipName = shipInfo.get(1);
		
		days = Integer.parseInt(daysInfo.get(0));
		parts = Integer.parseInt(daysInfo.get(1));
		
		repair = Integer.parseInt(changeShields.get(2));
		
		// displaying stored info
		lblShipType.setText(shipType);
		lblShipName.setText(shipName);
		
		lblDaysLeft.setText("Day: " + days);
		lblParts.setText("Parts to find: " + parts);
		
		pBarShipHealth.setValue(repair);
		
		for (int index = 0; index < crewType.size(); index++) {
			type[index].setText(crewType.get(index));
			member[index].setText(crewName.get(index));
		}
	}
	
	
	// Go to the space outpost screen
	private void spaceOutpost()
	{
		btnSpaceOutpost = new JButton("Space Outpost");
		btnSpaceOutpost.setBounds(325, 478, 249, 101);
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
	
	
	// Go to the newPlanet screen
	private void newPlanet()
	{
		btnNewPlanet = new JButton("Travel to a new planet");
		btnNewPlanet.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnNewPlanet.setBounds(602, 729, 313, 113);
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
		btnExplorePlanet.setBounds(23, 720, 313, 108);
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
		btnRepairShields.setBounds(581, 260, 230, 96);
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
		btnSleep.setBounds(85, 258, 230, 101);
		frame.getContentPane().add(btnSleep);
		

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
		btnInventory.setBounds(49, 400, 230, 101);
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
				ArrayList<String> changeDays = new ArrayList<String>();
				IOFile ioFile = new IOFile();
				
				changeDays = ioFile.fileRead("StoreGame/DaysInfo.txt");
				days = Integer.parseInt(changeDays.get(0)) - 1;
				changeDays.set(0, "" + days);
				ioFile.fileWrite(changeDays, "StoreGame/DaysInfo.txt");  // Writing in new days
				
				lblDaysLeft.setText("Day: "  + days);
			}
		});
		btnNextDay.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		btnNextDay.setBounds(562, 62, 249, 101);
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
		panel.setBounds(884, 23, 1012, 593);
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
		lblParts.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblParts.setBounds(308, 75, 155, 33);
		frame.getContentPane().add(lblParts);
		
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setBounds(326, 36, 112, 23);
		panelShip.add(lblHealth);
		lblHealth.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		pBarShipHealth = new JProgressBar();
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
		panelCrew.setBounds(23, 249, 965, 317);
		panel.add(panelCrew);
		panelCrew.setLayout(null);
		
		pBarHealth1 = new JProgressBar();
		pBarHealth1.setBounds(204, 107, 146, 30);
		panelCrew.add(pBarHealth1);
		
		pBarTiredness1 = new JProgressBar();
		pBarTiredness1.setBounds(204, 171, 146, 30);
		panelCrew.add(pBarTiredness1);
		
		pBarTiredness3 = new JProgressBar();
		pBarTiredness3.setBounds(607, 165, 146, 52);
		panelCrew.add(pBarTiredness3);
		
		pBarTiredness4 = new JProgressBar();
		pBarTiredness4.setBounds(791, 171, 146, 52);
		panelCrew.add(pBarTiredness4);
		
		pBarHunger2 = new JProgressBar();
		pBarHunger2.setBounds(429, 241, 126, 30);
		panelCrew.add(pBarHunger2);
		
		pBarHunger1 = new JProgressBar();
		pBarHunger1.setBounds(204, 241, 146, 30);
		panelCrew.add(pBarHunger1);
		
		pBarTiredness2 = new JProgressBar();
		pBarTiredness2.setBounds(421, 171, 134, 30);
		panelCrew.add(pBarTiredness2);
		
		pBarHealth2 = new JProgressBar();
		pBarHealth2.setBounds(409, 107, 146, 36);
		panelCrew.add(pBarHealth2);
		
		pBarHunger3 = new JProgressBar();
		pBarHunger3.setBounds(607, 229, 146, 52);
		panelCrew.add(pBarHunger3);
		
		pBarHunger4 = new JProgressBar();
		pBarHunger4.setBounds(788, 229, 146, 52);
		panelCrew.add(pBarHunger4);
		
		lblMember4 = new JLabel("...");
		lblMember4.setBounds(791, 275, 127, 23);
		panelCrew.add(lblMember4);
		lblMember4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		lblMember3 = new JLabel("...");
		lblMember3.setBounds(607, 275, 126, 23);
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
		
		lblMember1 = new JLabel("...");
		lblMember1.setBounds(214, 273, 117, 28);
		panelCrew.add(lblMember1);
		lblMember1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		pBarHealth3 = new JProgressBar();
		pBarHealth3.setBounds(607, 101, 146, 52);
		panelCrew.add(pBarHealth3);
		
		pBarHealth4 = new JProgressBar();
		pBarHealth4.setBounds(791, 107, 146, 52);
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
		lblDaysLeft = new JLabel("Day: ...");
		lblDaysLeft.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDaysLeft.setBounds(133, 75, 76, 33);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblDaysLeft);
		
		
		// Initialize progress bars
		IOFile ioFile = new IOFile();
		

		
		
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}