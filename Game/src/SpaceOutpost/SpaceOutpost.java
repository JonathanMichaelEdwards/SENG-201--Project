package SpaceOutpost;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

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
		ArrayList<String> crewInfo = ioFile.fileRead("StoreGame/CrewInfo.txt");
		
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
		totalCash = ioFile.fileRead("StoreGame/CashInfo.txt");
		lblCashTotal.setText("Current Cash = $ " + totalCash.get(0).toString());
	}
	
	
	// Go to the medical shop
	private void medicalShop()
	{
		JButton btnClickHereTo = new JButton("Medical Shop");
		btnClickHereTo.setBounds(137, 131, 183, 188);
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
	
	
	// Go to the Convenience Store
	private void convenienceStore()
	{
		JButton btnConvenienceStore = new JButton("Convenience Store");
		btnConvenienceStore.setBounds(867, 131, 183, 188);
		btnConvenienceStore.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ConvenienceStore convenienceStore = new ConvenienceStore();
				convenienceStore.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);                  // turn off screen
			}
		});
		frame.getContentPane().add(btnConvenienceStore);
	}
	
	
	// Go to the food shop
	private void foodShop()
	{
		JButton btnFoodShop = new JButton("Food Shop");
		btnFoodShop.setBounds(495, 131, 183, 188);
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
		btnBackToYour.setBounds(1057, 850, 160, 55);
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
		lblWelcomeToYour.setBounds(348, 47, 444, 45);
		frame.getContentPane().add(lblWelcomeToYour);
		
		JLabel lblMedicalShop = new JLabel("Purchase items to heal/boost your crew");
		lblMedicalShop.setBounds(96, 331, 301, 55);
		frame.getContentPane().add(lblMedicalShop);
		
		JLabel lblFoodShop = new JLabel("Purchase items to replenish Hunger");
		lblFoodShop.setBounds(470, 341, 316, 34);
		frame.getContentPane().add(lblFoodShop);
		
		JLabel lblConvenienceStore = new JLabel("Purchase items to aid your quest");
		lblConvenienceStore.setBounds(847, 365, 271, 34);
		frame.getContentPane().add(lblConvenienceStore);
		
		lblCashTotal = new JLabel("Current Cash = $ <dynamic>");
		lblCashTotal.setBounds(764, 62, 220, 21);
		frame.getContentPane().add(lblCashTotal);
	
		cBHealth1 = new JProgressBar();
		cBHealth1.setBounds(244, 494, 146, 30);
		frame.getContentPane().add(cBHealth1);

		cBTired1 = new JProgressBar();
		cBTired1.setBounds(244, 558, 146, 30);
		frame.getContentPane().add(cBTired1);
	

		cBHunger1 = new JProgressBar();
		cBHunger1.setBounds(244, 628, 146, 30);
		frame.getContentPane().add(cBHunger1);
		
	
		cBHealth2 = new JProgressBar();
		cBHealth2.setBounds(449, 494, 146, 36);
		frame.getContentPane().add(cBHealth2);
		

		cBTired2 = new JProgressBar();
		cBTired2.setBounds(461, 558, 134, 30);
		frame.getContentPane().add(cBTired2);
		
	
		cBHunger2 = new JProgressBar();
		cBHunger2.setBounds(469, 628, 126, 30);
		frame.getContentPane().add(cBHunger2);
	

		cBHealth3 = new JProgressBar();
		cBHealth3.setBounds(646, 494, 146, 34);
		frame.getContentPane().add(cBHealth3);
		
	
		cBTired3 = new JProgressBar();
		cBTired3.setBounds(647, 552, 146, 52);
		frame.getContentPane().add(cBTired3);

		cBHunger3 = new JProgressBar();
		cBHunger3.setBounds(647, 616, 146, 52);
		frame.getContentPane().add(cBHunger3);



		cBHealth4 = new JProgressBar();
		cBHealth4.setBounds(831, 494, 146, 52);
		frame.getContentPane().add(cBHealth4);
		
	
		cBTired4 = new JProgressBar();
		cBTired4.setBounds(831, 558, 146, 52);
		frame.getContentPane().add(cBTired4);
		
	
		cBHunger4 = new JProgressBar();
		cBHunger4.setBounds(828, 616, 146, 52);
		frame.getContentPane().add(cBHunger4);

		cBName4 = new JLabel("...");
		cBName4.setBounds(831, 662, 127, 23);
		cBName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBName4);

		cBName3 = new JLabel("...");
		cBName3.setBounds(647, 662, 126, 23);
		cBName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBName3);

		cBName2 = new JLabel("...");
		cBName2.setBounds(459, 666, 119, 22);
		cBName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBName2);
		
		cBName1 = new JLabel("...");
		cBName1.setBounds(254, 660, 117, 28);
		cBName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBName1);
		
		JLabel label = new JLabel("Crew Info");
		label.setBounds(102, 429, 81, 15);
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label);
	

		JLabel label0 = new JLabel("Hunger:");
		label0.setBounds(100, 632, 81, 15);
		label0.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label0);

		JLabel label1 = new JLabel("Tiredness:");
		label1.setBounds(100, 575, 81, 15);
		label1.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label1);
	

		JLabel label2 = new JLabel("Health:");
		label2.setBounds(40, 387, 0, 0);
		label2.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label2);
		
		
		JLabel label3 = new JLabel("Name:");
		label3.setBounds(102, 665, 81, 15);
		label3.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label3);

	

		


		JLabel label4 = new JLabel("Type:");
		label4.setBounds(100, 472, 81, 15);
		label4.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label4);

		cBType1 = new JLabel("...");
		cBType1.setBounds(261, 456, 129, 30);
		cBType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBType1);

		cBType2 = new JLabel("...");
		cBType2.setBounds(472, 463, 119, 23);
		cBType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBType2);

		cBType3 = new JLabel("...");
		cBType3.setBounds(664, 466, 129, 21);
		cBType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(cBType3);
	

		cBType4 = new JLabel("...");
		cBType4.setBounds(843, 466, 134, 22);
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
		convenienceStore();
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