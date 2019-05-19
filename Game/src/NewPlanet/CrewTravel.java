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
//Self implemented
import WindowSettings.Display;


public class CrewTravel 
{
	public JFrame frame;
	private JLabel ctType1, ctType2, ctType3, ctType4;
	private JLabel ctName1, ctName2, ctName3, ctName4;
	
	
	private JProgressBar ctHealth1, ctHealth2, ctHealth3, ctHealth4;
	private JProgressBar ctTired1, ctTired2, ctTired3, ctTired4;
	private JProgressBar ctHunger1, ctHunger2, ctHunger3, ctHunger4;
	
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
	private void ctHealth() 
	{
		health[0] = ctHealth1;
		health[1] = ctHealth2;
		health[2] = ctHealth3;
		health[3] = ctHealth4;
	}
	
	private void ctTired() 
	{
		tiredness[0] = ctTired1;
		tiredness[1] = ctTired2;
		tiredness[2] = ctTired3;
		tiredness[3] = ctTired4;
	}
	
	private void ctHunger() 
	{
		hunger[0] = ctHunger1;
		hunger[1] = ctHunger2;
		hunger[2] = ctHunger3;
		hunger[3] = ctHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void ctType() 
	{
		
		type[0] = ctType1;
		type[1] = ctType2;
		type[2] = ctType3;
		type[3] = ctType4;
	}
	
	private void ctName() 
	{
		member[0] = ctName1;
		member[1] = ctName2;
		member[2] = ctName3;
		member[3] = ctName4;
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
	
	private void btnTravel()
	{
		JButton btnSearchPlanet = new JButton("Travel");
		btnSearchPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				TravelPlanet planet = new TravelPlanet();
				planet.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().setLayout(null);
		btnSearchPlanet.setBounds(392, 514, 307, 122);
		frame.getContentPane().add(btnSearchPlanet);
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
		
		ctHealth1 = new JProgressBar();
		ctHealth1.setBounds(204, 107, 146, 30);
		frame.getContentPane().add(ctHealth1);

		ctTired1 = new JProgressBar();
		ctTired1.setBounds(204, 171, 146, 30);
		frame.getContentPane().add(ctTired1);
	

		ctHunger1 = new JProgressBar();
		ctHunger1.setBounds(204, 241, 146, 30);
		frame.getContentPane().add(ctHunger1);
		
	
		ctHealth2 = new JProgressBar();
		ctHealth2.setBounds(409, 107, 146, 36);
		frame.getContentPane().add(ctHealth2);
		

		ctTired2 = new JProgressBar();
		ctTired2.setBounds(421, 171, 134, 30);
		frame.getContentPane().add(ctTired2);
		
	
		ctHunger2 = new JProgressBar();
		ctHunger2.setBounds(429, 241, 126, 30);
		frame.getContentPane().add(ctHunger2);
	

		ctHealth3 = new JProgressBar();
		ctHealth3.setBounds(607, 101, 146, 52);
		frame.getContentPane().add(ctHealth3);
		
	
		ctTired3 = new JProgressBar();
		ctTired3.setBounds(607, 165, 146, 52);
		frame.getContentPane().add(ctTired3);

		ctHunger3 = new JProgressBar();
		ctHunger3.setBounds(607, 229, 146, 52);
		frame.getContentPane().add(ctHunger3);



		ctHealth4 = new JProgressBar();
		ctHealth4.setBounds(791, 107, 146, 52);
		frame.getContentPane().add(ctHealth4);
		
	
		ctTired4 = new JProgressBar();
		ctTired4.setBounds(791, 171, 146, 52);
		frame.getContentPane().add(ctTired4);
		
	
		ctHunger4 = new JProgressBar();
		ctHunger4.setBounds(788, 229, 146, 52);
		frame.getContentPane().add(ctHunger4);

		ctName4 = new JLabel("...");
		ctName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctName4.setBounds(791, 275, 127, 23);
		frame.getContentPane().add(ctName4);

		ctName3 = new JLabel("...");
		ctName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctName3.setBounds(607, 275, 126, 23);
		frame.getContentPane().add(ctName3);

		ctName2 = new JLabel("...");
		ctName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctName2.setBounds(419, 279, 119, 22);
		frame.getContentPane().add(ctName2);
		
		ctName1 = new JLabel("...");
		ctName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctName1.setBounds(214, 273, 117, 28);
		frame.getContentPane().add(ctName1);
		
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

		ctType1 = new JLabel("...");
		ctType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctType1.setBounds(221, 69, 129, 30);
		frame.getContentPane().add(ctType1);

		ctType2 = new JLabel("...");
		ctType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctType2.setBounds(432, 76, 119, 23);
		frame.getContentPane().add(ctType2);

		ctType3 = new JLabel("...");
		ctType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctType3.setBounds(624, 79, 129, 21);
		frame.getContentPane().add(ctType3);
	

		ctType4 = new JLabel("...");
		ctType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		ctType4.setBounds(803, 79, 134, 22);
		frame.getContentPane().add(ctType4);
		
		frame.getContentPane().setLayout(null);
		
		

		//initialize storage arrays
		ctType();
		ctName();
		
		ctHealth();
		ctTired();
		ctHunger();
		// forward Button
		btnTravel();
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
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
