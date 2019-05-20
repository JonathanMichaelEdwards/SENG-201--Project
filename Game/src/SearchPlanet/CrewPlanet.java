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

import IOFile.IOFile;
import MainScreen.MainScreen;
//Self implemented
import WindowSettings.Display;
import javax.swing.JCheckBox;


public class CrewPlanet {

	public JFrame frame;
	private JLabel cpType1, cpType2, cpType3, cpType4;
	private JLabel cpName1, cpName2, cpName3, cpName4;
	
	
	private JProgressBar cpHealth1, cpHealth2, cpHealth3, cpHealth4;
	private JProgressBar cpTired1, cpTired2, cpTired3, cpTired4;
	private JProgressBar cpHunger1, cpHunger2, cpHunger3, cpHunger4;
	
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
		
		JCheckBox chckbxChoose = new JCheckBox("Choose ");
		chckbxChoose.setBounds(204, 344, 126, 23);
		frame.getContentPane().add(chckbxChoose);
		
		JCheckBox checkBox = new JCheckBox("Choose ");
		checkBox.setBounds(409, 344, 126, 23);
		frame.getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Choose ");
		checkBox_1.setBounds(607, 344, 126, 23);
		frame.getContentPane().add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("Choose ");
		checkBox_2.setBounds(791, 344, 126, 23);
		frame.getContentPane().add(checkBox_2);
		
	}
	
	
	private void btnSearch()
	{
		JButton btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ExplorePlanet screen = new ExplorePlanet();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().setLayout(null);
		btnSearchPlanet.setBounds(392, 514, 307, 122);
		frame.getContentPane().add(btnSearchPlanet);
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
		cpHealth1.setBounds(204, 107, 146, 30);
		frame.getContentPane().add(cpHealth1);

		cpTired1 = new JProgressBar();
		cpTired1.setBounds(204, 171, 146, 30);
		frame.getContentPane().add(cpTired1);
	

		cpHunger1 = new JProgressBar();
		cpHunger1.setBounds(204, 241, 146, 30);
		frame.getContentPane().add(cpHunger1);
		
	
		cpHealth2 = new JProgressBar();
		cpHealth2.setBounds(409, 107, 146, 30);
		frame.getContentPane().add(cpHealth2);
		

		cpTired2 = new JProgressBar();
		cpTired2.setBounds(409, 171, 146, 30);
		frame.getContentPane().add(cpTired2);
		
	
		cpHunger2 = new JProgressBar();
		cpHunger2.setBounds(409, 241, 146, 30);
		frame.getContentPane().add(cpHunger2);
	

		cpHealth3 = new JProgressBar();
		cpHealth3.setBounds(607, 107, 146, 30);
		frame.getContentPane().add(cpHealth3);
		
	
		cpTired3 = new JProgressBar();
		cpTired3.setBounds(607, 171, 146, 30);
		frame.getContentPane().add(cpTired3);

		cpHunger3 = new JProgressBar();
		cpHunger3.setBounds(607, 241, 146, 30);
		frame.getContentPane().add(cpHunger3);



		cpHealth4 = new JProgressBar();
		cpHealth4.setBounds(791, 107, 146, 30);
		frame.getContentPane().add(cpHealth4);
		
	
		cpTired4 = new JProgressBar();
		cpTired4.setBounds(791, 171, 146, 30);
		frame.getContentPane().add(cpTired4);
		
	
		cpHunger4 = new JProgressBar();
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
		

		
		// forward Button
		btnSearch();
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
