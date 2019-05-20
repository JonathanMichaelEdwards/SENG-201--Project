package Inventory;

// Library imports
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import IOFile.IOFile;
import MainScreen.MainScreen;
import WindowSettings.Display;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JRadioButton;


public class ShipInventory
{
	public JFrame frame;
	
	private JLabel crType1, crType2, crType3, crType4;
	private JLabel siName1, siName2, siName3, siName4;
	
	private JProgressBar crHealth1, crHealth2, crHealth3, crHealth4;
	private JProgressBar crTired1, crTired2, crTired3, crTired4;
	private JProgressBar crHunger1, crHunger2, crHunger3, crHunger4;
	
	// File locations
	private String readCrew = "StoreGame/CrewRatings/";
	
	// stores the selection type
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewName = new ArrayList<String>();

	private JLabel type[] = new JLabel[4];
	private JLabel member[] = new JLabel[4];
	
	private JRadioButton btnCookie, btnPizza, btnFull, btnPlaguePotion, btnSurgical, btnMedkit, btnBandages;
	
	
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
	
	private void siName() 
	{
		member[0] = siName1;
		member[1] = siName2;
		member[2] = siName3;
		member[3] = siName4;
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

	private void clearSelection()
	{
		btnCookie.setSelected(false);
		btnPizza.setSelected(false);
		btnFull.setSelected(false);
		btnPlaguePotion.setSelected(false);
		btnSurgical.setSelected(false);
		btnMedkit.setSelected(false);
		btnBandages.setSelected(false);
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
		crewMember1 = ioFile.fileRead(readCrew + crewType.get(0) + ".txt");
		
		crHealth1.setValue(Integer.valueOf(crewMember1.get(0)));
		crTired1.setValue(Integer.valueOf(crewMember1.get(1)));
		crHunger1.setValue(Integer.valueOf(crewMember1.get(2)));
	}
	
	private void memberTwo(ArrayList<String> crewMember2, IOFile ioFile)
	{
		crewMember2 = ioFile.fileRead(readCrew + crewType.get(1) + ".txt");
		
		crHealth2.setValue(Integer.valueOf(crewMember2.get(0)));
		crTired2.setValue(Integer.valueOf(crewMember2.get(1)));
		crHunger2.setValue(Integer.valueOf(crewMember2.get(2)));
	}
	
	private void memberThree(ArrayList<String> crewMember3, IOFile ioFile)
	{
		crewMember3 = ioFile.fileRead(readCrew + crewType.get(2) + ".txt");
		
		crHealth3.setValue(Integer.valueOf(crewMember3.get(0)));
		crTired3.setValue(Integer.valueOf(crewMember3.get(1)));
		crHunger3.setValue(Integer.valueOf(crewMember3.get(2)));
	}
	
	private void memberFour(ArrayList<String> crewMember4, IOFile ioFile)
	{
		crewMember4 = ioFile.fileRead(readCrew + crewType.get(3) + ".txt");
		
		crHealth4.setValue(Integer.valueOf(crewMember4.get(0)));
		crTired4.setValue(Integer.valueOf(crewMember4.get(1)));
		crHunger4.setValue(Integer.valueOf(crewMember4.get(2)));
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
		
	
	private void Cookie()
	{
		btnCookie = new JRadioButton("");
		btnCookie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSelection();
				btnCookie.setSelected(true);
			}
		});
		btnCookie.setBounds(194, 170, 38, 23);
		frame.getContentPane().add(btnCookie);
	}
	
	private void Pizza()
	{
		btnPizza = new JRadioButton("");
		btnPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSelection();
				btnPizza.setSelected(true);
			}
		});
		
		btnPizza.setBounds(194, 206, 38, 23);
		frame.getContentPane().add(btnPizza);
	}
	
	private void Full()
	{
		btnFull = new JRadioButton("");
		btnFull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSelection();
				btnFull.setSelected(true);
			}
		});
		btnFull.setBounds(194, 245, 38, 23);
		frame.getContentPane().add(btnFull);
		
	}
	
	private void PlaguePotion()
	{
		btnPlaguePotion = new JRadioButton("");
		btnPlaguePotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSelection();
				btnPlaguePotion.setSelected(true);
			}
		});
		btnPlaguePotion.setBounds(514, 284, 38, 23);
		frame.getContentPane().add(btnPlaguePotion);
	}
	
	private void Surgical()
	{
		btnSurgical = new JRadioButton("");
		btnSurgical.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSelection();
				btnSurgical.setSelected(true);
			}
		});
		btnSurgical.setBounds(514, 246, 38, 23);
		frame.getContentPane().add(btnSurgical);
	}
		
	private void Medkit()
	{
		btnMedkit = new JRadioButton("");
		btnMedkit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSelection();
				btnMedkit.setSelected(true);
			}
		});
		btnMedkit.setBounds(514, 207, 38, 23);
		frame.getContentPane().add(btnMedkit);

	
	}

	
	
	private void Bandage()
	{
		
		btnBandages = new JRadioButton("");
		btnBandages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearSelection();
				btnBandages.setSelected(true);
			}
		});
		btnBandages.setBounds(514, 167, 38, 23);
		frame.getContentPane().add(btnBandages);
		
		JLabel lblCountcookie = new JLabel("xcookie");
		lblCountcookie.setBounds(120, 170, 66, 15);
		frame.getContentPane().add(lblCountcookie);
	}
	
	private void ItemChoice()
	{
		Cookie();
		Pizza();
		Full();
		PlaguePotion();
		Surgical();
		Medkit();
		Bandage();
		
	}
	
	
	
	private void btnBack()
	{
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(845, 862, 198, 112);
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().add(btnBack);


		
		JLabel lblFood = new JLabel("Food");
		lblFood.setBounds(54, 129, 66, 15);
		lblFood.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(lblFood);
		
		JLabel lblMedical = new JLabel("Medical");
		lblMedical.setBounds(258, 129, 110, 15);
		lblMedical.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(lblMedical);
		
		JLabel lblCookieX = new JLabel("Cookie");
		lblCookieX.setBounds(54, 170, 66, 15);
		frame.getContentPane().add(lblCookieX);
		
		JLabel lblPizzaX = new JLabel("Pizza");
		lblPizzaX.setBounds(54, 210, 66, 15);
		frame.getContentPane().add(lblPizzaX);
		
		JLabel lblFullMealX = new JLabel("Full meal");
		lblFullMealX.setBounds(54, 249, 91, 15);
		frame.getContentPane().add(lblFullMealX);
		
		JLabel lblBandages = new JLabel("Bandages");
		lblBandages.setBounds(258, 170, 126, 15);
		frame.getContentPane().add(lblBandages);
		
		JLabel lblMedKit = new JLabel("Med Kit");
		lblMedKit.setBounds(258, 210, 66, 15);
		frame.getContentPane().add(lblMedKit);
		
		JLabel lblSurgialSuite = new JLabel("Surgial Package");
		lblSurgialSuite.setBounds(258, 249, 126, 15);
		frame.getContentPane().add(lblSurgialSuite);
		
		JLabel lblSpacePlaguePotion = new JLabel("Space Plague Potion");
		lblSpacePlaguePotion.setBounds(258, 287, 177, 15);
		frame.getContentPane().add(lblSpacePlaguePotion);
		
	
		
		JRadioButton rdbtnCrew1 = new JRadioButton("Choose");
		rdbtnCrew1.setEnabled(false);
		rdbtnCrew1.setBounds(514, 683, 144, 23);
		frame.getContentPane().add(rdbtnCrew1);
		
		JRadioButton rdbtnCrew2 = new JRadioButton("Choose");
		rdbtnCrew2.setEnabled(false);
		rdbtnCrew2.setBounds(731, 683, 144, 23);
		frame.getContentPane().add(rdbtnCrew2);
		
		JRadioButton rdbtnCrew3 = new JRadioButton("Choose");
		rdbtnCrew3.setEnabled(false);
		rdbtnCrew3.setBounds(917, 683, 144, 23);
		frame.getContentPane().add(rdbtnCrew3);
		
		JRadioButton rdbtnCrew4 = new JRadioButton("Choose");
		rdbtnCrew4.setEnabled(false);
		rdbtnCrew4.setBounds(1101, 683, 144, 23);
		frame.getContentPane().add(rdbtnCrew4);
		
		JButton btnConfirmChoice = new JButton("Confirm Choice");
		btnConfirmChoice.setBounds(596, 282, 161, 25);
		frame.getContentPane().add(btnConfirmChoice);
	}
	
	private void numberItem()
	{
		IOFile ioFile = new IOFile();
		ArrayList<String> storeInventory = new ArrayList<String>();
		ArrayList<String> inventoryList = ioFile.fileRead("StoreGame/Inventory/Storage.txt");
		
		
		int i, cookies = 0, pizzas = 0, full = 0, bandage = 0, medkit = 0, surgical = 0, potion = 0;

		for (i = 0; i < inventoryList.size(); i++) {
			if (inventoryList.get(i).equals("Cookie")) {
				cookies++;
				System.out.println("Cookies" + cookies);
			}
			if (inventoryList.get(i).equals("Pizza")) {
				pizzas++;
				System.out.println("Pizza" + pizzas);
			}
			if (inventoryList.get(i).equals("Full Meal")) {
				full++;
				System.out.println("Full Meal" + full);
			}
			if (inventoryList.get(i).equals("Bandage")) {
				bandage++;
				System.out.println("Bandages" + bandage);
			}
			if (inventoryList.get(i).equals("Pizza")) {
				pizzas++;
				System.out.println("Pizza" + pizzas);
			}
			if (inventoryList.get(i).equals("Medkit")) {
				medkit++;
				System.out.println("Medkit" + medkit);
			}
			if (inventoryList.get(i).equals("Surgical")) {
				surgical++;
				System.out.println("Surgical Package" + surgical);
			}
			if (inventoryList.get(i).equals("Potion")) {
				potion++;
				System.out.println("Space Plague Potion" + potion);
			}
		}
		
		System.out.println(storeInventory);
//		Arrays.stream(inventoryList)
		
//		for (String i : inventoryList) 
//		{
//			System.out.println(i);
//		}
		
		
	}
	
	private void btnAccept()
	{
		JButton btnApplyChanges = new JButton("Apply Changes");
		btnApplyChanges.setEnabled(false);
		btnApplyChanges.setBounds(1104, 868, 208, 101);
		btnApplyChanges.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().add(btnApplyChanges);
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
		frame.getContentPane().setLayout(null);
//		frame.setUndecorated(true);  // Frame cannot be adjusted during game
		
		
		// Initialize displays
		JLabel lblShipsInventory = new JLabel("Ships inventory");
		lblShipsInventory.setBounds(503, 37, 188, 38);
		frame.getContentPane().add(lblShipsInventory);
		
		JLabel lblSelectAnItem = new JLabel("Select an Item to use");
		lblSelectAnItem.setBounds(133, 37, 177, 38);
		frame.getContentPane().add(lblSelectAnItem);
		
		JLabel lblSelectOneOf = new JLabel("Select one of your crew ");
		lblSelectOneOf.setBounds(581, 338, 188, 32);
		frame.getContentPane().add(lblSelectOneOf);
		
		crHealth1 = new JProgressBar();
		crHealth1.setBounds(514, 460, 146, 30);
		frame.getContentPane().add(crHealth1);

		crTired1 = new JProgressBar();
		crTired1.setBounds(514, 524, 146, 30);
		frame.getContentPane().add(crTired1);
	

		crHunger1 = new JProgressBar();
		crHunger1.setBounds(514, 594, 146, 30);
		frame.getContentPane().add(crHunger1);
		
	
		crHealth2 = new JProgressBar();
		crHealth2.setBounds(719, 460, 146, 36);
		frame.getContentPane().add(crHealth2);
		

		crTired2 = new JProgressBar();
		crTired2.setBounds(731, 524, 134, 30);
		frame.getContentPane().add(crTired2);
		
	
		crHunger2 = new JProgressBar();
		crHunger2.setBounds(739, 594, 126, 30);
		frame.getContentPane().add(crHunger2);
	

		crHealth3 = new JProgressBar();
		crHealth3.setBounds(917, 454, 146, 52);
		frame.getContentPane().add(crHealth3);
		
	
		crTired3 = new JProgressBar();
		crTired3.setBounds(917, 518, 146, 52);
		frame.getContentPane().add(crTired3);

		crHunger3 = new JProgressBar();
		crHunger3.setBounds(917, 582, 146, 52);
		frame.getContentPane().add(crHunger3);



		crHealth4 = new JProgressBar();
		crHealth4.setBounds(1101, 460, 146, 52);
		frame.getContentPane().add(crHealth4);
		
	
		crTired4 = new JProgressBar();
		crTired4.setBounds(1101, 524, 146, 52);
		frame.getContentPane().add(crTired4);
		
	
		crHunger4 = new JProgressBar();
		crHunger4.setBounds(1098, 582, 146, 52);
		frame.getContentPane().add(crHunger4);

		siName4 = new JLabel("...");
		siName4.setBounds(1101, 628, 127, 23);
		siName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(siName4);

		siName3 = new JLabel("...");
		siName3.setBounds(917, 628, 126, 23);
		siName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(siName3);

		siName2 = new JLabel("...");
		siName2.setBounds(729, 632, 119, 22);
		siName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(siName2);
		
		siName1 = new JLabel("...");
		siName1.setBounds(524, 626, 117, 28);
		siName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(siName1);
		
		JLabel label = new JLabel("Crew Info");
		label.setBounds(370, 389, 81, 15);
		label.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label);
	

		JLabel label0 = new JLabel("Hunger:");
		label0.setBounds(370, 598, 81, 15);
		label0.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label0);

		JLabel label1 = new JLabel("Tiredness:");
		label1.setBounds(370, 541, 81, 15);
		label1.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label1);
	

		JLabel label2 = new JLabel("Health:");
		label2.setBounds(310, 353, 0, 0);
		label2.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label2);
		
		
		JLabel label3 = new JLabel("Name:");
		label3.setBounds(372, 631, 81, 15);
		label3.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label3);

	

		


		JLabel label4 = new JLabel("Type:");
		label4.setBounds(370, 438, 81, 15);
		label4.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label4);

		crType1 = new JLabel("...");
		crType1.setBounds(531, 422, 129, 30);
		crType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(crType1);

		crType2 = new JLabel("...");
		crType2.setBounds(742, 429, 119, 23);
		crType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(crType2);

		crType3 = new JLabel("...");
		crType3.setBounds(934, 432, 129, 21);
		crType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(crType3);
	

		crType4 = new JLabel("...");
		crType4.setBounds(1113, 432, 134, 22);
		crType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(crType4);
		
		frame.getContentPane().setLayout(null);

		crType();
		siName();
<<<<<<< HEAD
		siHealth();
		siTired();
		siHunger();
=======
		
		crHealth();
		crTired();
		crHunger();
>>>>>>> master
		// Back Actions
		btnAccept();;
		btnBack();
		ItemChoice();
	}
	
	
	/*
	 * Create the application.
	*/
	public ShipInventory()
	{
		initialize();
		organizeGameInfo();
		numberItem();
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
					ShipInventory window = new ShipInventory();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
