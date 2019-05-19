package RepairShields;

//Library imports
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import IOFile.IOFile;
import MainScreen.MainScreen;
//Self implemented
import WindowSettings.Display;
import java.awt.Font;


public class CrewRepair {

	public JFrame frame;
	
	private JLabel crType1, crType2, crType3, crType4;
	private JLabel crName1, crName2, crName3, crName4;
	
	
	private JProgressBar crHealth1, crHealth2, crHealth3, crHealth4;
	private JProgressBar crTired1, crTired2, crTired3, crTired4;
	private JProgressBar crHunger1, crHunger2, crHunger3, crHunger4;
	
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
	private void crHealth() 
	{
		health[0] = crHealth1;
		health[1] = crHealth2;
		health[2] = crHealth3;
		health[3] = crHealth4;
	}
	
	private void crTired() 
	{
		tiredness[0] = crTired1;
		tiredness[1] = crTired2;
		tiredness[2] = crTired3;
		tiredness[3] = crTired4;
	}
	
	private void crHunger() 
	{
		hunger[0] = crHunger1;
		hunger[1] = crHunger2;
		hunger[2] = crHunger3;
		hunger[3] = crHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void crType() 
	{
		
		type[0] = crType1;
		type[1] = crType2;
		type[2] = crType3;
		type[3] = crType4;
	}
	
	private void crName() 
	{
		member[0] = crName1;
		member[1] = crName2;
		member[2] = crName3;
		member[3] = crName4;
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
		
		for (int index = 0; index < crewType.size(); index++) {
			type[index].setText(crewType.get(index));
			member[index].setText(crewName.get(index));
		}
	}
		
			
	private void btnRepair()
	{
		JButton btnSearchPlanet = new JButton("Repair");
		btnSearchPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				IOFile ioFile = new IOFile();
				
				ArrayList<String> changeShields = ioFile.fileRead("StoreGame/ShipInfo.txt");
				int repair = Integer.parseInt(changeShields.get(2)) + 10; //this is the value in which a repair heals
				
				changeShields.set(2, "" + repair);
				ioFile.fileWrite(changeShields, "StoreGame/ShipInfo.txt");  // Writing in new days
				
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().setLayout(null);
		
		
		
	
		btnSearchPlanet.setBounds(725, 580, 197, 97);
		frame.getContentPane().add(btnSearchPlanet);
	}
	
	
	// back button
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
		
		
		

		crHealth1 = new JProgressBar();
		crHealth1.setBounds(204, 107, 146, 30);
		frame.getContentPane().add(crHealth1);

		crTired1 = new JProgressBar();
		crTired1.setBounds(204, 171, 146, 30);
		frame.getContentPane().add(crTired1);
	

		crHunger1 = new JProgressBar();
		crHunger1.setBounds(204, 241, 146, 30);
		frame.getContentPane().add(crHunger1);
		
	
		crHealth2 = new JProgressBar();
		crHealth2.setBounds(409, 107, 146, 36);
		frame.getContentPane().add(crHealth2);
		

		crTired2 = new JProgressBar();
		crTired2.setBounds(421, 171, 134, 30);
		frame.getContentPane().add(crTired2);
		
	
		crHunger2 = new JProgressBar();
		crHunger2.setBounds(429, 241, 126, 30);
		frame.getContentPane().add(crHunger2);
	

		crHealth3 = new JProgressBar();
		crHealth3.setBounds(607, 101, 146, 52);
		frame.getContentPane().add(crHealth3);
		
	
		crTired3 = new JProgressBar();
		crTired3.setBounds(607, 165, 146, 52);
		frame.getContentPane().add(crTired3);

		crHunger3 = new JProgressBar();
		crHunger3.setBounds(607, 229, 146, 52);
		frame.getContentPane().add(crHunger3);



		crHealth4 = new JProgressBar();
		crHealth4.setBounds(791, 107, 146, 52);
		frame.getContentPane().add(crHealth4);
		
	
		crTired4 = new JProgressBar();
		crTired4.setBounds(791, 171, 146, 52);
		frame.getContentPane().add(crTired4);
		
	
		crHunger4 = new JProgressBar();
		crHunger4.setBounds(788, 229, 146, 52);
		frame.getContentPane().add(crHunger4);

		crName4 = new JLabel("...");
		crName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		crName4.setBounds(791, 275, 127, 23);
		frame.getContentPane().add(crName4);

		crName3 = new JLabel("...");
		crName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		crName3.setBounds(607, 275, 126, 23);
		frame.getContentPane().add(crName3);

		crName2 = new JLabel("...");
		crName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		crName2.setBounds(419, 279, 119, 22);
		frame.getContentPane().add(crName2);
		
		crName1 = new JLabel("...");
		crName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		crName1.setBounds(214, 273, 117, 28);
		frame.getContentPane().add(crName1);
		
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

		crType1 = new JLabel("...");
		crType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		crType1.setBounds(221, 69, 129, 30);
		frame.getContentPane().add(crType1);

		crType2 = new JLabel("...");
		crType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		crType2.setBounds(432, 76, 119, 23);
		frame.getContentPane().add(crType2);

		crType3 = new JLabel("...");
		crType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		crType3.setBounds(624, 79, 129, 21);
		frame.getContentPane().add(crType3);
	

		crType4 = new JLabel("...");
		crType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		crType4.setBounds(803, 79, 134, 22);
		frame.getContentPane().add(crType4);
		
		

		//initialize storage arrays
		crType();
		crName();
		
		crHealth();
		crTired();
		crHunger();
		
		// Button actions
		btnRepair();
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public CrewRepair() {
		initialize();
		organizeGameInfo();  // displaying info
	}
	
	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewRepair window = new CrewRepair();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
