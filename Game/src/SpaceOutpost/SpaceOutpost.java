package SpaceOutpost;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import IOFile.IOFile;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

//Self implemented
import WindowSettings.Display;
import SpaceOutpost.SpaceOutpost;
import MainScreen.MainScreen;



public class SpaceOutpost 
{

	public JFrame frame;
	
	private JLabel lblCashTotal;
	private JLabel cBType1, cBType2, cBType3, cBType4;
	private JLabel cBName1, cBName2, cBName3, cBName4;
	
	
	private JProgressBar cBHealth1, cBHealth2, cBHealth3, cBHealth4;
	private JProgressBar cBTired1, cBTired2, cBTired3, cBTired4;
	private JProgressBar cBHunger1, cBHunger2, cBHunger3, cBHunger4;
	
	// stores the selection type
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewName = new ArrayList<String>();

	private JLabel type[] = new JLabel[4];
	private JLabel member[] = new JLabel[4];
	
	
	private JProgressBar health[] = new JProgressBar[4];
	private JProgressBar tiredness[] = new JProgressBar[4];
	private JProgressBar hunger[] = new JProgressBar [4];
	

	// Store all progress bar cB it can be used easily
	// Stores crew details in data arrays cB it can be used easily
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
	
	
	// Stores crew details in data arrays cB it can be used easily
	private void cBType() 
	{
		
		type[0] = cBType1;
		type[1] = cBType2;
		type[2] = cBType3;
		type[3] = cBType4;
	}
	
	private void cBName() 
	{
		member[0] = cBName1;
		member[1] = cBName2;
		member[2] = cBName3;
		member[3] = cBName4;
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
			} else if ((lsSize-size) == 1 && (index == 3)) {
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
	
	
	private void readCrewRatings()
	{ 
		IOFile ioFile = new IOFile();
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
	
	
	// organizing information from files
	private void organizeGameInfo()
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
		
	
	private void bankStore()
	{
		ArrayList<String> totalCash = new ArrayList<String>();
		IOFile ioFile = new IOFile();

		// read how much cash the player has
		totalCash = ioFile.fileRead("src/StoreGame/CashInfo.txt");
		lblCashTotal.setText("Current Cash = $ " + totalCash.get(0).toString());
	}
	
	
	// Go to the medical shop
	private void medicalShop()
	{
		JButton btnClickHereTo = new JButton("Medical Shop");
		btnClickHereTo.setBounds(512, 445, 300, 200);
		btnClickHereTo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MedicalStore medicalStore = new MedicalStore();
				medicalStore.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);              // turn off screen
			}
		});
		frame.getContentPane().add(btnClickHereTo);
	}
	
	
	
	
	
	// Go to the food shop
	private void foodShop()
	{
		JButton btnFoodShop = new JButton("Food Shop");
		btnFoodShop.setBounds(1249, 445, 300, 200);
		btnFoodShop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FoodStore foodStore = new FoodStore();
				foodStore.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);           // turn off screen
			}
		});
		frame.getContentPane().add(btnFoodShop);
	}
	
	
	// Returning back to main screen
	private void goBack()
	{
		JButton btnBackToYour = new JButton("Back to your ship");
		btnBackToYour.setBounds(910, 693, 250, 100);
		btnBackToYour.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				MainScreen mainScreen = new MainScreen();
				mainScreen.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);            // turn off screen
			}
		});
		frame.getContentPane().add(btnBackToYour);
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
		frame.setUndecorated(false);  // Frame cannot be adjusted during game
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
		// Initializing displays
		JLabel lblWelcomeToYour = new JLabel("Welcome to your local Space Station");
		lblWelcomeToYour.setFont(new Font("Dialog", Font.BOLD, 24));
		lblWelcomeToYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToYour.setBounds(650, 50, 600, 100);
		frame.getContentPane().add(lblWelcomeToYour);
		
		JLabel lblMedicalShop = new JLabel("Purchase items to heal/boost your crew");
		lblMedicalShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicalShop.setBounds(512, 667, 300, 50);
		frame.getContentPane().add(lblMedicalShop);
		
		JLabel lblFoodShop = new JLabel("Purchase items to replenish Hunger");
		lblFoodShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoodShop.setBounds(1249, 655, 300, 50);
		frame.getContentPane().add(lblFoodShop);
		
		lblCashTotal = new JLabel("Current Cash = $ <dynamic>");
		lblCashTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashTotal.setBounds(942, 571, 220, 21);
		frame.getContentPane().add(lblCashTotal);
	
		cBHealth1 = new JProgressBar();
		cBHealth1.setBounds(662, 260, 150, 30);
		cBHealth1.setStringPainted(true);
		frame.getContentPane().add(cBHealth1);

		cBTired1 = new JProgressBar();
		cBTired1.setBounds(662, 297, 150, 30);
		cBTired1.setStringPainted(true);
		frame.getContentPane().add(cBTired1);
	
		cBHunger1 = new JProgressBar();
		cBHunger1.setBounds(662, 339, 150, 30);
		cBHunger1.setStringPainted(true);
		frame.getContentPane().add(cBHunger1);
	
		cBHealth2 = new JProgressBar();
		cBHealth2.setBounds(849, 260, 150, 30);
		cBHealth2.setStringPainted(true);
		frame.getContentPane().add(cBHealth2);
		
		cBTired2 = new JProgressBar();
		cBTired2.setBounds(849, 297, 150, 30);
		cBTired2.setStringPainted(true);
		frame.getContentPane().add(cBTired2);
		
		cBHunger2 = new JProgressBar();
		cBHunger2.setBounds(849, 337, 150, 30);
		cBHunger2.setStringPainted(true);
		frame.getContentPane().add(cBHunger2);

		cBHealth3 = new JProgressBar();
		cBHealth3.setBounds(1040, 260, 150, 30);
		cBHealth3.setStringPainted(true);
		frame.getContentPane().add(cBHealth3);
		
		cBTired3 = new JProgressBar();
		cBTired3.setBounds(1040, 297, 150, 30);
		cBTired3.setStringPainted(true);
		frame.getContentPane().add(cBTired3);

		cBHunger3 = new JProgressBar();
		cBHunger3.setBounds(1040, 337, 150, 30);
		cBHunger3.setStringPainted(true);
		frame.getContentPane().add(cBHunger3);

		cBHealth4 = new JProgressBar();
		cBHealth4.setBounds(1238, 260, 150, 30);
		cBHealth4.setStringPainted(true);
		frame.getContentPane().add(cBHealth4);
		
		cBTired4 = new JProgressBar();
		cBTired4.setBounds(1238, 297, 150, 30);
		cBTired4.setStringPainted(true);
		frame.getContentPane().add(cBTired4);
		
		cBHunger4 = new JProgressBar();
		cBHunger4.setBounds(1238, 337, 150, 30);
		cBHunger4.setStringPainted(true);
		frame.getContentPane().add(cBHunger4);

		cBName4 = new JLabel("...");
		cBName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBName4.setBounds(1238, 379, 150, 30);
		frame.getContentPane().add(cBName4);

		cBName3 = new JLabel("...");
		cBName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBName3.setBounds(1040, 379, 150, 30);
		frame.getContentPane().add(cBName3);

		cBName2 = new JLabel("...");
		cBName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBName2.setBounds(849, 379, 150, 30);
		frame.getContentPane().add(cBName2);
		
		cBName1 = new JLabel("...");
		cBName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBName1.setBounds(662, 381, 150, 30);
		frame.getContentPane().add(cBName1);
		
		JLabel label = new JLabel("Crew Info");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(910, 172, 150, 30);
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label);
	
		JLabel label0 = new JLabel("Hunger:");
		label0.setBounds(518, 337, 150, 30);
		label0.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label0);

		JLabel label1 = new JLabel("Tiredness:");
		label1.setBounds(518, 295, 150, 30);
		label1.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label1);
	
		JLabel label2 = new JLabel("Health:");
		label2.setBounds(518, 258, 150, 30);
		label2.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Name:");
		label3.setBounds(518, 379, 150, 30);
		label3.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label3);

		JLabel label4 = new JLabel("Type:");
		label4.setBounds(518, 218, 150, 30);
		label4.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label4);

		cBType1 = new JLabel("...");
		cBType1.setBounds(672, 218, 150, 30);
		cBType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBType1);

		cBType2 = new JLabel("...");
		cBType2.setBounds(887, 222, 119, 23);
		cBType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBType2);

		cBType3 = new JLabel("...");
		cBType3.setBounds(1065, 218, 150, 30);
		cBType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBType3);

		cBType4 = new JLabel("...");
		cBType4.setBounds(1249, 218, 150, 30);
		cBType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBType4);
		frame.getContentPane().setLayout(null);
		

		//initialize storage arrays
		cBType();
		cBName();
		
		cBHealth();
		cBTired();
		cBHunger();

		
		// Button Actions
		foodShop();
		medicalShop();
		goBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public SpaceOutpost() 
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
					SpaceOutpost window = new SpaceOutpost();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}