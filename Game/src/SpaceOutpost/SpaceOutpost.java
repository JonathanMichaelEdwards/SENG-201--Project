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
	private JLabel soType1, soType2, soType3, soType4;
	private JLabel soName1, soName2, soName3, soName4;
	
	
	private JProgressBar soHealth1, soHealth2, soHealth3, soHealth4;
	private JProgressBar soTired1, soTired2, soTired3, soTired4;
	private JProgressBar soHunger1, soHunger2, soHunger3, soHunger4;
	
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
	private void soHealth() 
	{
		health[0] = soHealth1;
		health[1] = soHealth2;
		health[2] = soHealth3;
		health[3] = soHealth4;
	}
	
	private void soTired() 
	{
		tiredness[0] = soTired1;
		tiredness[1] = soTired2;
		tiredness[2] = soTired3;
		tiredness[3] = soTired4;
	}
	
	private void soHunger() 
	{
		hunger[0] = soHunger1;
		hunger[1] = soHunger2;
		hunger[2] = soHunger3;
		hunger[3] = soHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void soType() 
	{
		
		type[0] = soType1;
		type[1] = soType2;
		type[2] = soType3;
		type[3] = soType4;
	}
	
	private void soName() 
	{
		member[0] = soName1;
		member[1] = soName2;
		member[2] = soName3;
		member[3] = soName4;
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
	
		soHealth1 = new JProgressBar();
		soHealth1.setBounds(244, 494, 146, 30);
		frame.getContentPane().add(soHealth1);

		soTired1 = new JProgressBar();
		soTired1.setBounds(244, 558, 146, 30);
		frame.getContentPane().add(soTired1);
	

		soHunger1 = new JProgressBar();
		soHunger1.setBounds(244, 628, 146, 30);
		frame.getContentPane().add(soHunger1);
		
	
		soHealth2 = new JProgressBar();
		soHealth2.setBounds(449, 494, 146, 36);
		frame.getContentPane().add(soHealth2);
		

		soTired2 = new JProgressBar();
		soTired2.setBounds(461, 558, 134, 30);
		frame.getContentPane().add(soTired2);
		
	
		soHunger2 = new JProgressBar();
		soHunger2.setBounds(469, 628, 126, 30);
		frame.getContentPane().add(soHunger2);
	

		soHealth3 = new JProgressBar();
		soHealth3.setBounds(646, 494, 146, 34);
		frame.getContentPane().add(soHealth3);
		
	
		soTired3 = new JProgressBar();
		soTired3.setBounds(647, 552, 146, 52);
		frame.getContentPane().add(soTired3);

		soHunger3 = new JProgressBar();
		soHunger3.setBounds(647, 616, 146, 52);
		frame.getContentPane().add(soHunger3);



		soHealth4 = new JProgressBar();
		soHealth4.setBounds(831, 494, 146, 52);
		frame.getContentPane().add(soHealth4);
		
	
		soTired4 = new JProgressBar();
		soTired4.setBounds(831, 558, 146, 52);
		frame.getContentPane().add(soTired4);
		
	
		soHunger4 = new JProgressBar();
		soHunger4.setBounds(828, 616, 146, 52);
		frame.getContentPane().add(soHunger4);

		soName4 = new JLabel("...");
		soName4.setBounds(831, 662, 127, 23);
		soName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(soName4);

		soName3 = new JLabel("...");
		soName3.setBounds(647, 662, 126, 23);
		soName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(soName3);

		soName2 = new JLabel("...");
		soName2.setBounds(459, 666, 119, 22);
		soName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(soName2);
		
		soName1 = new JLabel("...");
		soName1.setBounds(254, 660, 117, 28);
		soName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(soName1);
		
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

		soType1 = new JLabel("...");
		soType1.setBounds(261, 456, 129, 30);
		soType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(soType1);

		soType2 = new JLabel("...");
		soType2.setBounds(472, 463, 119, 23);
		soType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(soType2);

		soType3 = new JLabel("...");
		soType3.setBounds(664, 466, 129, 21);
		soType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(soType3);
	

		soType4 = new JLabel("...");
		soType4.setBounds(843, 466, 134, 22);
		soType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(soType4);
		
		frame.getContentPane().setLayout(null);
		
		

		//initialize storage arrays
		soType();
		soName();
		
		soHealth();
		soTired();
		soHunger();

		
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