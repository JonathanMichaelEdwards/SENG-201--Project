package Sleep;

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
//Self implemented
import WindowSettings.Display;
import MainScreen.MainScreen;


public class CrewSleep {

public JFrame frame;
	
	private JLabel csType1, csType2, csType3, csType4;
	private JLabel csName1, csName2, csName3, csName4;
	
	
	private JProgressBar csHealth1, csHealth2, csHealth3, csHealth4;
	private JProgressBar csTired1, csTired2, csTired3, csTired4;
	private JProgressBar csHunger1, csHunger2, csHunger3, csHunger4;
	
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
	private void csHealth() 
	{
		health[0] = csHealth1;
		health[1] = csHealth2;
		health[2] = csHealth3;
		health[3] = csHealth4;
	}
	
	private void csTired() 
	{
		tiredness[0] = csTired1;
		tiredness[1] = csTired2;
		tiredness[2] = csTired3;
		tiredness[3] = csTired4;
	}
	
	private void csHunger() 
	{
		hunger[0] = csHunger1;
		hunger[1] = csHunger2;
		hunger[2] = csHunger3;
		hunger[3] = csHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void csType() 
	{
		
		type[0] = csType1;
		type[1] = csType2;
		type[2] = csType3;
		type[3] = csType4;
	}
	
	private void csName() 
	{
		member[0] = csName1;
		member[1] = csName2;
		member[2] = csName3;
		member[3] = csName4;
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
		
		JButton btnSleepthis = new JButton("SLEEPTHIS");
		btnSleepthis.setBounds(154, 580, 309, 77);
		frame.getContentPane().add(btnSleepthis);
		
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
		
		
		

		csHealth1 = new JProgressBar();
		csHealth1.setBounds(204, 107, 146, 30);
		frame.getContentPane().add(csHealth1);

		csTired1 = new JProgressBar();
		csTired1.setBounds(204, 171, 146, 30);
		frame.getContentPane().add(csTired1);
	

		csHunger1 = new JProgressBar();
		csHunger1.setBounds(204, 241, 146, 30);
		frame.getContentPane().add(csHunger1);
		
	
		csHealth2 = new JProgressBar();
		csHealth2.setBounds(409, 107, 146, 36);
		frame.getContentPane().add(csHealth2);
		

		csTired2 = new JProgressBar();
		csTired2.setBounds(421, 171, 134, 30);
		frame.getContentPane().add(csTired2);
		
	
		csHunger2 = new JProgressBar();
		csHunger2.setBounds(429, 241, 126, 30);
		frame.getContentPane().add(csHunger2);
	

		csHealth3 = new JProgressBar();
		csHealth3.setBounds(607, 101, 146, 52);
		frame.getContentPane().add(csHealth3);
		
	
		csTired3 = new JProgressBar();
		csTired3.setBounds(607, 165, 146, 52);
		frame.getContentPane().add(csTired3);

		csHunger3 = new JProgressBar();
		csHunger3.setBounds(607, 229, 146, 52);
		frame.getContentPane().add(csHunger3);



		csHealth4 = new JProgressBar();
		csHealth4.setBounds(791, 107, 146, 52);
		frame.getContentPane().add(csHealth4);
		
	
		csTired4 = new JProgressBar();
		csTired4.setBounds(791, 171, 146, 52);
		frame.getContentPane().add(csTired4);
		
	
		csHunger4 = new JProgressBar();
		csHunger4.setBounds(788, 229, 146, 52);
		frame.getContentPane().add(csHunger4);

		csName4 = new JLabel("...");
		csName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		csName4.setBounds(791, 275, 127, 23);
		frame.getContentPane().add(csName4);

		csName3 = new JLabel("...");
		csName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		csName3.setBounds(607, 275, 126, 23);
		frame.getContentPane().add(csName3);

		csName2 = new JLabel("...");
		csName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		csName2.setBounds(419, 279, 119, 22);
		frame.getContentPane().add(csName2);
		
		csName1 = new JLabel("...");
		csName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		csName1.setBounds(214, 273, 117, 28);
		frame.getContentPane().add(csName1);
		
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

		csType1 = new JLabel("...");
		csType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		csType1.setBounds(221, 69, 129, 30);
		frame.getContentPane().add(csType1);

		csType2 = new JLabel("...");
		csType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		csType2.setBounds(432, 76, 119, 23);
		frame.getContentPane().add(csType2);

		csType3 = new JLabel("...");
		csType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		csType3.setBounds(624, 79, 129, 21);
		frame.getContentPane().add(csType3);
	

		csType4 = new JLabel("...");
		csType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		csType4.setBounds(803, 79, 134, 22);
		frame.getContentPane().add(csType4);
		
		frame.getContentPane().setLayout(null);
		
		

		//initialize storage arrays
		csType();
		csName();
		
		csHealth();
		csTired();
		csHunger();
		
		// Button actions
		
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/

	public CrewSleep() {
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
					CrewSleep window = new CrewSleep();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
