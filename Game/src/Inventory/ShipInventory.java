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
	
	
	private JLabel pBarType1, pBarType2, pBarType3, pBarType4;
	private JLabel siName1, siName2, siName3, siName4;
	
	private JLabel lblCountcookie, lblCountPizza, lblCountFullMeal, lblCountBandages, lblCountMedkit, lblCountSurgical, lblCountPotion;

	private JProgressBar pBarHealth1, pBarHealth2, pBarHealth3, pBarHealth4;
	private JProgressBar pBarTired1, pBarTired2, pBarTired3, pBarTired4;
	private JProgressBar pBarHunger1, pBarHunger2, pBarHunger3, pBarHunger4;
	
	private JRadioButton rBCookie, rBPizza, rBFullMeal, rBPlague, rBSurgical, rBMedkit, rBBandages;
	private JRadioButton rdbtnCrew1, rdbtnCrew2, rdbtnCrew3, rdbtnCrew4;
	private JButton btnConfirmChoice;
	private boolean setectedState, setectedState2, btn3State, btn4State = false;
	private ArrayList<String> crew = new ArrayList<String>();
	
	// stores the selection type
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewName = new ArrayList<String>();

	private boolean stateOne, stateTwo  = false;

	private JLabel type[] = new JLabel[4];
	private JLabel member[] = new JLabel[4];
	
	private JProgressBar health[] = new JProgressBar[4];
	private JProgressBar tiredness[] = new JProgressBar[4];
	private JProgressBar hunger[] = new JProgressBar [4];
	
	private int cookies, pizzas, fullMeal, bandage, medkit, surgical, potion;
	

	// Store all progress bar so it can be used easily
	// Stores crew details in data arrays so it can be used easily
	private void pBarHealth() 
	{
		health[0] = pBarHealth1;
		health[1] = pBarHealth2;
		health[2] = pBarHealth3;
		health[3] = pBarHealth4;
	}
	
	private void pBarTired() 
	{
		tiredness[0] = pBarTired1;
		tiredness[1] = pBarTired2;
		tiredness[2] = pBarTired3;
		tiredness[3] = pBarTired4;
	}
	
	private void pBarHunger() 
	{
		hunger[0] = pBarHunger1;
		hunger[1] = pBarHunger2;
		hunger[2] = pBarHunger3;
		hunger[3] = pBarHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void pBarType() 
	{
		type[0] = pBarType1;
		type[1] = pBarType2;
		type[2] = pBarType3;
		type[3] = pBarType4;
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
	
	
	
	
	// Storing and displaying the characters health
	private void memberOne(ArrayList<String> crewMember1, IOFile ioFile)
	{
		crewMember1 = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
		
		pBarHealth1.setValue(Integer.valueOf(crewMember1.get(0)));
		pBarTired1.setValue(Integer.valueOf(crewMember1.get(1)));
		pBarHunger1.setValue(Integer.valueOf(crewMember1.get(2)));
	}
	
	private void memberTwo(ArrayList<String> crewMember2, IOFile ioFile)
	{
		crewMember2 = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
		
		pBarHealth2.setValue(Integer.valueOf(crewMember2.get(0)));
		pBarTired2.setValue(Integer.valueOf(crewMember2.get(1)));
		pBarHunger2.setValue(Integer.valueOf(crewMember2.get(2)));
	}
	
	private void memberThree(ArrayList<String> crewMember3, IOFile ioFile)
	{
		crewMember3 = ioFile.fileRead("StoreGame/CrewSelected/MemberThree.txt");
		
		pBarHealth3.setValue(Integer.valueOf(crewMember3.get(0)));
		pBarTired3.setValue(Integer.valueOf(crewMember3.get(1)));
		pBarHunger3.setValue(Integer.valueOf(crewMember3.get(2)));
	}
	
	private void memberFour(ArrayList<String> crewMember4, IOFile ioFile)
	{
		crewMember4 = ioFile.fileRead("StoreGame/CrewSelected/MemberFour.txt");
		
		pBarHealth4.setValue(Integer.valueOf(crewMember4.get(0)));
		pBarTired4.setValue(Integer.valueOf(crewMember4.get(1)));
		pBarHunger4.setValue(Integer.valueOf(crewMember4.get(2)));
	}
	
	
	private void readCrewRatings(IOFile ioFile)
	{ 
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
		ArrayList<String> storedItems= ioFile.fileRead("StoreGame/Inventory/Storage.txt");
		
		// unwrap information
		decodeCrewInfo(crewInfo);
		readCrewRatings(ioFile);  // Show levels
		
		for (int index = 0; index < crewType.size(); index++) {
			type[index].setText(crewType.get(index));
			member[index].setText(crewName.get(index));
		}
		
		btnStates(); // check status of buttons
		
		// Find out how many of the same items the player has
		for (int index = 0; index < storedItems.size(); index++) {
			if (storedItems.get(index).equals("cookie"))
				cookies++;
			if (storedItems.get(index).equals("pizza"))
				pizzas++;
			if (storedItems.get(index).equals("fullMeal"))
				fullMeal++;
			if (storedItems.get(index).equals("bandage"))
				bandage++;
			if (storedItems.get(index).equals("medkit"))
				medkit++;
			if (storedItems.get(index).equals("surgical"))
				surgical++; 
			if (storedItems.get(index).equals("potion"))
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
		
		checkcount(); // check count to see whether to disable button
	}
	
	
	private void checkcount()
	{
		// determine whether or no the button should be on
		if (cookies == 0)
			rBCookie.setEnabled(false);
		if (pizzas == 0) 
			rBPizza.setEnabled(false);
		if (fullMeal == 0)
			rBFullMeal.setEnabled(false);
		if (potion == 0) 
			rBPlague.setEnabled(false);
		if (bandage == 0)
			rBBandages.setEnabled(false);
		if (medkit == 0) 
			rBMedkit.setEnabled(false);
		if (surgical == 0) 
			rBSurgical.setEnabled(false);
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
			setectedState = true;
			if (setectedState2)
				btnConfirmChoice.setEnabled(true); // enable button
		} else {
			rbEnableFalse(true);
			btnConfirmChoice.setEnabled(false);
		}
		checkcount();
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
	}
	
	
	private void crewWrite(String crewSelected)
	{
		IOFile ioFile = new IOFile();
		crew = ioFile.fileRead("StoreGame/CrewSelected/" + crewSelected + ".txt");
		int valueChange;
		
		if (rBCookie.isSelected()) {
			valueChange = Integer.parseInt(crew.get(2)) + 20;
			crew.set(2, ""+valueChange);
		} else if (rBPizza.isSelected()) {
			valueChange = Integer.parseInt(crew.get(2)) + 50;
			crew.set(2, ""+valueChange);
		} else if (rBFullMeal.isSelected()) {
			valueChange = Integer.parseInt(crew.get(2)) + 100;
			crew.set(2, ""+valueChange);
		} else if (rBPlague.isSelected()) {
			if (crew.get(4).equals("true"))
				crew.set(4, "false");
		} else if (rBSurgical.isSelected()) {
			valueChange = Integer.parseInt(crew.get(0)) + 100;
			crew.set(2, ""+valueChange);
		} else if (rBMedkit.isSelected()) {
			valueChange = Integer.parseInt(crew.get(0)) + 50;
			crew.set(2, ""+valueChange);
		} else if (rBBandages.isSelected()) {
			valueChange = Integer.parseInt(crew.get(0)) + 20;
			crew.set(2, ""+valueChange);
		}
		
		if (setectedState)
			btnConfirmChoice.setEnabled(true); // enable button
		
		ioFile.fileWrite(crew, "StoreGame/CrewSelected/" + crewSelected + ".txt");
	}
	
	
	private void btnConfirm()
	{
		btnConfirmChoice = new JButton("Confirm Choice");
		btnConfirmChoice.setEnabled(false);
		btnConfirmChoice.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				IOFile ioFile = new IOFile();
				ArrayList<String> inventory = new ArrayList<String>();
				
				inventory = ioFile.fileRead("StoreGame/Inventory/Storage.txt");
				
		 		if (rdbtnCrew1.isSelected()) {
		 			crewWrite("MemberOne");
		 		} else if (rdbtnCrew2.isSelected()) {
		 			crewWrite("MemberTwo");
		 		} else if (rdbtnCrew3.isSelected()) {
		 			crewWrite("MemberThree");
		 		} else if (rdbtnCrew4.isSelected()) {
		 			crewWrite("MemberFour");
		 		}
		 		
		 		
				if (rBCookie.isSelected()) {
					inventory.remove("cookie");
				} else if (rBPizza.isSelected())
					inventory.remove("pizza");
				else if (rBFullMeal.isSelected())
					inventory.remove("fullMeal");
				else if (rBPlague.isSelected())
					inventory.remove("potion");
				else if (rBSurgical.isSelected())
					inventory.remove("surgical");
				else if (rBMedkit.isSelected())
					inventory.remove("medKit");
				else if (rBBandages.isSelected())
					inventory.remove("bandage");
				
				ioFile.fileWrite(inventory, "StoreGame/Inventory/Storage.txt");
				
				ShipInventory ship = new ShipInventory();
				ship.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);        // turn off screen
			}
		});
		btnConfirmChoice.setBounds(113, 422, 198, 101);
		frame.getContentPane().add(btnConfirmChoice);
	}
	
	
	private void rBClear()
	{
		rdbtnCrew1.setSelected(false);
		rdbtnCrew2.setSelected(false);
		rdbtnCrew3.setSelected(false);
		rdbtnCrew4.setSelected(false);
	}
	
	
	private void btnStates()
	{
		for (int index = 0; index < crewType.size(); index++) {
			if (index == 1) {
				rdbtnCrew3.setEnabled(false);
				rdbtnCrew4.setEnabled(false);
				btn3State = true;
				btn4State = true;
			} else if (index == 2) {
				rdbtnCrew4.setEnabled(false);
				btn4State = true;
			}
		}
	}
	
	
	private void btnCrew()
	{
		 rdbtnCrew1 = new JRadioButton("Choose");
		 rdbtnCrew1.addActionListener(new ActionListener() 
		 {
		 	public void actionPerformed(ActionEvent arg0) 
		 	{
		 		rBClear();
		 		rdbtnCrew1.setSelected(true);
		 		if (rdbtnCrew1.isSelected()) {
		 			btnConfirmChoice.setEnabled(true); // enable button
		 		}
		 	}
		 });
		rdbtnCrew1.setBounds(514, 683, 144, 23);
		frame.getContentPane().add(rdbtnCrew1);
		
		
		rdbtnCrew2 = new JRadioButton("Choose");
		rdbtnCrew2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				rBClear();
				rdbtnCrew2.setSelected(true);
		 		if (rdbtnCrew2.isSelected()) {
		 			btnConfirmChoice.setEnabled(true); // enable button
		 		}
			}
		});
		rdbtnCrew2.setBounds(731, 683, 144, 23);
		frame.getContentPane().add(rdbtnCrew2);
		
	
		rdbtnCrew3 = new JRadioButton("Choose");
		rdbtnCrew3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				rBClear();
				rdbtnCrew3.setSelected(true);
		 		if (rdbtnCrew3.isSelected()) {
		 			btnConfirmChoice.setEnabled(true); // enable button
		 		}
			}
		});
		rdbtnCrew3.setBounds(917, 683, 144, 23);
		frame.getContentPane().add(rdbtnCrew3);
		

		rdbtnCrew4 = new JRadioButton("Choose");
		rdbtnCrew4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				rBClear();
	 			rdbtnCrew4.setSelected(true);
		 		if (rdbtnCrew4.isSelected()) {
		 			btnConfirmChoice.setEnabled(true); // enable button
		 		}
			}
		});
		rdbtnCrew4.setBounds(1101, 683, 144, 23);
		frame.getContentPane().add(rdbtnCrew4);
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
		
		pBarHealth1 = new JProgressBar();
		pBarHealth1.setBounds(514, 460, 146, 30);
		frame.getContentPane().add(pBarHealth1);

		pBarTired1 = new JProgressBar();
		pBarTired1.setBounds(514, 524, 146, 30);
		frame.getContentPane().add(pBarTired1);
	

		pBarHunger1 = new JProgressBar();
		pBarHunger1.setBounds(514, 594, 146, 30);
		frame.getContentPane().add(pBarHunger1);
		
	
		pBarHealth2 = new JProgressBar();
		pBarHealth2.setBounds(719, 460, 146, 36);
		frame.getContentPane().add(pBarHealth2);
		

		pBarTired2 = new JProgressBar();
		pBarTired2.setBounds(731, 524, 134, 30);
		frame.getContentPane().add(pBarTired2);
		
	
		pBarHunger2 = new JProgressBar();
		pBarHunger2.setBounds(739, 594, 126, 30);
		frame.getContentPane().add(pBarHunger2);
	

		pBarHealth3 = new JProgressBar();
		pBarHealth3.setBounds(917, 454, 146, 52);
		frame.getContentPane().add(pBarHealth3);
		
	
		pBarTired3 = new JProgressBar();
		pBarTired3.setBounds(917, 518, 146, 52);
		frame.getContentPane().add(pBarTired3);

		pBarHunger3 = new JProgressBar();
		pBarHunger3.setBounds(917, 582, 146, 52);
		frame.getContentPane().add(pBarHunger3);

		pBarHealth4 = new JProgressBar();
		pBarHealth4.setBounds(1101, 460, 146, 52);
		frame.getContentPane().add(pBarHealth4);
		
		pBarTired4 = new JProgressBar();
		pBarTired4.setBounds(1101, 524, 146, 52);
		frame.getContentPane().add(pBarTired4);
		
	
		pBarHunger4 = new JProgressBar();
		pBarHunger4.setBounds(1098, 582, 146, 52);
		frame.getContentPane().add(pBarHunger4);

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

		pBarType1 = new JLabel("...");
		pBarType1.setBounds(531, 422, 129, 30);
		pBarType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(pBarType1);

		pBarType2 = new JLabel("...");
		pBarType2.setBounds(742, 429, 119, 23);
		pBarType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(pBarType2);

		pBarType3 = new JLabel("...");
		pBarType3.setBounds(934, 432, 129, 21);
		pBarType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(pBarType3);
		
		
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
	
		
		pBarType4 = new JLabel("...");
		pBarType4.setBounds(1113, 432, 134, 22);
		pBarType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(pBarType4);
		
		frame.getContentPane().setLayout(null);

		pBarType();
		siName();
		pBarHealth();
		pBarTired();
		pBarHunger();
		
		// Back Actions
		btnCrew();
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
