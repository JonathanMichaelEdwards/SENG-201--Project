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
import javax.swing.JComboBox;


public class ShipInventory
{
	public JFrame frame;
	
	
	private JLabel siType1, siType2, siType3, siType4;
	private JLabel siName1, siName2, siName3, siName4;
	
	private JLabel lblCountcookie, lblCountPizza, lblCountFullMeal, lblCountBandages, lblCountMedkit, lblCountSurgical, lblCountPotion;

	private JProgressBar siHealth1, siHealth2, siHealth3, siHealth4;
	private JProgressBar siTired1, siTired2, siTired3, siTired4;
	private JProgressBar siHunger1, siHunger2, siHunger3, siHunger4;
	private JRadioButton rBCookie, rBPizza, rBFullMeal;
	
	// stores the selection type
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewName = new ArrayList<String>();
	ArrayList<String> storedItems = new ArrayList<String>();

	private JLabel type[] = new JLabel[4];
	private JLabel member[] = new JLabel[4];
	
	private JRadioButton rBPlague, rBSurgical, rBMedkit, rBBandages;
	
	
	private JProgressBar health[] = new JProgressBar[4];
	private JProgressBar tiredness[] = new JProgressBar[4];
	private JProgressBar hunger[] = new JProgressBar [4];
	
	private int cookies, pizzas, fullMeal, bandage, medkit, surgical, potion;
	

	// Store all progress bar so it can be used easily
	// Stores crew details in data arrays so it can be used easily
	private void siHealth() 
	{
		health[0] = siHealth1;
		health[1] = siHealth2;
		health[2] = siHealth3;
		health[3] = siHealth4;
	}
	
	private void siTired() 
	{
		tiredness[0] = siTired1;
		tiredness[1] = siTired2;
		tiredness[2] = siTired3;
		tiredness[3] = siTired4;
	}
	
	private void siHunger() 
	{
		hunger[0] = siHunger1;
		hunger[1] = siHunger2;
		hunger[2] = siHunger3;
		hunger[3] = siHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void siType() 
	{
		type[0] = siType1;
		type[1] = siType2;
		type[2] = siType3;
		type[3] = siType4;
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
		ArrayList<String> storedItems= ioFile.fileRead("StoreGame/Inventory/Storage.txt");
		
		// unwrap information
		decodeCrewInfo(crewInfo);
		
		for (int index = 0; index < crewType.size(); index++) {
			type[index].setText(crewType.get(index));
			member[index].setText(crewName.get(index));
		}
		
		// Find out how many of the same items the player has
		for (int index = 0; index < storedItems.size(); index++) {
			if (storedItems.get(index).equals("cookie"))
				cookies++;
			else if (storedItems.get(index).equals("pizza"))
				pizzas++;
			else if (storedItems.get(index).equals("fullMeal"))
				fullMeal++;
			else if (storedItems.get(index).equals("bandage"))
				bandage++;
			else if (storedItems.get(index).equals("medkit"))
				medkit++;
			else if (storedItems.get(index).equals("surgical"))
				surgical++; 
			else if (storedItems.get(index).equals("potion"))
				potion++;
		}
		
		// Display the item amounts
		lblCountcookie.setText("x" + Integer.toString(cookies));
		lblCountPizza.setText("x" + Integer.toString(pizzas));
		lblCountFullMeal.setText("x" + Integer.toString(fullMeal));
		lblCountBandages.setText("x" + Integer.toString(bandage));
		lblCountMedkit.setText("x" + Integer.toString(medkit));
		lblCountSurgical.setText("x" + Integer.toString(surgical));
		lblCountPotion.setText("x" + Integer.toString(potion));
	}
	
	
	// disables the radio buttons
	private void rbEnableFalse(boolean state)
	{
		rBCookie.setEnabled(state);
		rBPizza.setEnabled(state);
		rBFullMeal.setEnabled(state);
		rBPlague.setEnabled(state);
		rBSurgical.setEnabled(state);
		rBMedkit.setEnabled(state);
		rBBandages.setEnabled(state);
	}
	
	
	private void setradioButtons(JRadioButton button)
	{
		if (button.isSelected()) {
			rbEnableFalse(false);
			button.setEnabled(true);
		} else {
			rbEnableFalse(true);
		}
	}
	
	
	private void cBoxActions()
	{
		rBCookie = new JRadioButton("");
		rBCookie.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{	
				setradioButtons(rBCookie);
			}
		});
		rBCookie.setBounds(206, 166, 38, 23);
		frame.getContentPane().add(rBCookie);
		
		
		rBPizza = new JRadioButton("");
		rBPizza.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setradioButtons(rBPizza);
			}
		});
		rBPizza.setBounds(200, 206, 38, 23);
		frame.getContentPane().add(rBPizza);
		
		
		rBFullMeal = new JRadioButton("");
		rBFullMeal.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setradioButtons(rBFullMeal);
			}
		});
		rBFullMeal.setBounds(200, 245, 38, 23);
		frame.getContentPane().add(rBFullMeal);
		
		
		rBPlague = new JRadioButton("");
		rBPlague.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setradioButtons(rBPlague);
			}
		});
		rBPlague.setBounds(514, 284, 38, 23);
		frame.getContentPane().add(rBPlague);
		
		
		rBSurgical = new JRadioButton("");
		rBSurgical.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setradioButtons(rBSurgical);
			}
		});
		rBSurgical.setBounds(514, 246, 38, 23);
		frame.getContentPane().add(rBSurgical);
		
		
		rBMedkit = new JRadioButton("");
		rBMedkit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setradioButtons(rBMedkit);
			}
		});
		rBMedkit.setBounds(514, 207, 38, 23);
		frame.getContentPane().add(rBMedkit);
		
		
		rBBandages = new JRadioButton("");
		rBBandages.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				setradioButtons(rBBandages);
			}
		});
		rBBandages.setBounds(514, 167, 38, 23);
		frame.getContentPane().add(rBBandages);
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
	
	
	
	private void btnConfirm()
	{
		JButton btnConfirmChoice = new JButton("Confirm Choice");
		btnConfirmChoice.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				lblCountcookie.setText(Integer.toString(cookies));
			}
		});
		btnConfirmChoice.setBounds(596, 282, 161, 25);
		frame.getContentPane().add(btnConfirmChoice);
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
		
		siHealth1 = new JProgressBar();
		siHealth1.setBounds(514, 460, 146, 30);
		frame.getContentPane().add(siHealth1);

		siTired1 = new JProgressBar();
		siTired1.setBounds(514, 524, 146, 30);
		frame.getContentPane().add(siTired1);
	

		siHunger1 = new JProgressBar();
		siHunger1.setBounds(514, 594, 146, 30);
		frame.getContentPane().add(siHunger1);
		
	
		siHealth2 = new JProgressBar();
		siHealth2.setBounds(719, 460, 146, 36);
		frame.getContentPane().add(siHealth2);
		

		siTired2 = new JProgressBar();
		siTired2.setBounds(731, 524, 134, 30);
		frame.getContentPane().add(siTired2);
		
	
		siHunger2 = new JProgressBar();
		siHunger2.setBounds(739, 594, 126, 30);
		frame.getContentPane().add(siHunger2);
	

		siHealth3 = new JProgressBar();
		siHealth3.setBounds(917, 454, 146, 52);
		frame.getContentPane().add(siHealth3);
		
	
		siTired3 = new JProgressBar();
		siTired3.setBounds(917, 518, 146, 52);
		frame.getContentPane().add(siTired3);

		siHunger3 = new JProgressBar();
		siHunger3.setBounds(917, 582, 146, 52);
		frame.getContentPane().add(siHunger3);



		siHealth4 = new JProgressBar();
		siHealth4.setBounds(1101, 460, 146, 52);
		frame.getContentPane().add(siHealth4);
		
	
		siTired4 = new JProgressBar();
		siTired4.setBounds(1101, 524, 146, 52);
		frame.getContentPane().add(siTired4);
		
	
		siHunger4 = new JProgressBar();
		siHunger4.setBounds(1098, 582, 146, 52);
		frame.getContentPane().add(siHunger4);

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

		lblCountcookie = new JLabel("<dynamic>");
		lblCountcookie.setBounds(113, 170, 84, 15);
		frame.getContentPane().add(lblCountcookie);
		lblCountcookie.setText(Integer.toString(cookies));
			
		lblCountPizza = new JLabel("New label");
		lblCountPizza.setBounds(113, 210, 84, 15);
		frame.getContentPane().add(lblCountPizza);
		lblCountPizza.setText(Integer.toString(pizzas));
		
		lblCountFullMeal = new JLabel("New label");
		lblCountFullMeal.setBounds(113, 249, 84, 15);
		frame.getContentPane().add(lblCountFullMeal);
		lblCountFullMeal.setText(Integer.toString(fullMeal));
		
		lblCountBandages = new JLabel("New label");
		lblCountBandages.setBounds(434, 170, 66, 15);
		frame.getContentPane().add(lblCountBandages);
		lblCountBandages.setText(Integer.toString(bandage));
		
		lblCountMedkit = new JLabel("New label");
		lblCountMedkit.setBounds(434, 210, 66, 15);
		frame.getContentPane().add(lblCountMedkit);
		lblCountMedkit.setText(Integer.toString(medkit));
		
		lblCountSurgical = new JLabel("New label");
		lblCountSurgical.setBounds(434, 249, 66, 15);
		frame.getContentPane().add(lblCountSurgical);
		lblCountSurgical.setText(Integer.toString(surgical));
		
		lblCountPotion = new JLabel("New label");
		lblCountPotion.setBounds(434, 287, 66, 15);
		frame.getContentPane().add(lblCountPotion);
		lblCountPotion.setText(Integer.toString(potion));

		JLabel label4 = new JLabel("Type:");
		label4.setBounds(370, 438, 81, 15);
		label4.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label4);

		siType1 = new JLabel("...");
		siType1.setBounds(531, 422, 129, 30);
		siType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(siType1);

		siType2 = new JLabel("...");
		siType2.setBounds(742, 429, 119, 23);
		siType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(siType2);

		siType3 = new JLabel("...");
		siType3.setBounds(934, 432, 129, 21);
		siType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(siType3);
		
		
		JLabel lblFood = new JLabel("Food");
		lblFood.setBounds(54, 129, 66, 15);
		lblFood.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(lblFood);
		
		JLabel lblMedical = new JLabel("Medical");
		lblMedical.setBounds(258, 129, 110, 15);
		lblMedical.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(lblMedical);
		
		JLabel lblCookieX = new JLabel("Cookie");
		lblCookieX.setBounds(24, 170, 66, 15);
		frame.getContentPane().add(lblCookieX);
		
		JLabel lblPizzaX = new JLabel("Pizza");
		lblPizzaX.setBounds(24, 210, 66, 15);
		frame.getContentPane().add(lblPizzaX);
		
		JLabel lblFullMealX = new JLabel("Full meal");
		lblFullMealX.setBounds(24, 249, 91, 15);
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
		


	

		siType4 = new JLabel("...");
		siType4.setBounds(1113, 432, 134, 22);
		siType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(siType4);
		
		frame.getContentPane().setLayout(null);

		siType();
		siName();
		siHealth();
		siTired();
		siHunger();
		
		// Back Actions
		cBoxActions();
		btnConfirm();
		btnAccept();;
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public ShipInventory()
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
					ShipInventory window = new ShipInventory();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
