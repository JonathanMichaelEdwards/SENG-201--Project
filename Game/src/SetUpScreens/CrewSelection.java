package SetUpScreens;

import java.awt.Color;
// Libary imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;

import CrewTypes.Leader;
import CrewTypes.Mechanic;
import CrewTypes.Medic;
import CrewTypes.Pilot;
import CrewTypes.Soldier;
import CrewTypes.Thief;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JProgressBar;

// Self implemented
import WindowSettings.Display;
import java.awt.Font;



public class CrewSelection {

	public JFrame frame; // Frame for screen
	
	private JTextField txtFdName;
	private JProgressBar progressBar;
	private JLabel label;
	private JComboBox<Object> comBoxCharChosen;
	
	// Setting up player selection varibles
	private JCheckBox selectSoldier, selectMedic, selectLeader, selectMechanic, selectPilot, selectThief;
	private JComboBox<Object> comboBoxSoldier, comboBoxMedic, comboBoxLeader, comboBoxMechanic, comboBoxPilot, comboBoxThief;
	
	// Members chosen  with there name stored
	private JLabel lblMember1, lblMember2, lblMember3, lblMember4;
	private JLabel name1, name2, name3, name4; 
	
	// keep track the added and removed players
	private int days, piecesToCollect, previousCount = 0;
	
	// Button Actions
	private JButton btnAcceptChars;
	private JButton btnAcceptName;
	private JButton btnNext;
	private JButton btnReset;
	
	// go to new windows
	private JButton soldierInfo, leaderInfo, pilotInfo, medicInfo, mechanicInfo, thiefInfo;
	
	// Stored list of crewType members and there names
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewNames = new ArrayList<String>();
	
	// stores the selection type
	private JCheckBox charSelect[] = new JCheckBox[6];
	private JComboBox<?> charNumber[] = new JComboBox<?>[6];
	
	
	
	// Retrives current status of selection check boxes of the player type
	// stores the select state (checkboxes of each character) for each character
	private void settingChar() 
	{
		charSelect[0] = selectSoldier;
		charSelect[1] = selectMedic;
		charSelect[2] = selectLeader;
		charSelect[3] = selectMechanic;
		charSelect[4] = selectPilot;
		charSelect[5] = selectThief;
	}
	
	// Retrives current status of combo boxes (number of players selected)
	// stores the slected state (comboboxes of each character) for each character
	private void settingNumber() 
	{
		charNumber[0] = comboBoxSoldier;
		charNumber[1] = comboBoxMedic;
		charNumber[2] = comboBoxLeader;
		charNumber[3] = comboBoxMechanic;
		charNumber[4] = comboBoxPilot;
		charNumber[5] = comboBoxThief;
	}
	
	
	// Disable player type check boxes
	private void disableCharBoxes(JCheckBox charSelect, JComboBox<?> charNumber) 
	{
		charSelect.setEnabled(false);
		charNumber.setEnabled(false);
		
		if (charNumber.getSelectedIndex() == -1) {
			charSelect.setSelected(false);  // disable if pushed and no number is given
			charNumber.setVisible(false);   // disable boxes
		}
	}
	

	// reseting the screen
	private void resetScreen()
	{
		// Setting a new frame
		CrewSelection selectCrew = new CrewSelection();
		selectCrew.frame.setVisible(true);  // turn on screen
		frame.setVisible(false);   // turn off screen
	}
	
	
	// Adding characters names to the list and displaying their given names as labels
	private void addNames(JLabel name)
	{
		for (int index = 0; index < crewType.size(); index++) {
			if (name.getText().equals("...")) {
				name.setText(txtFdName.getText());
				crewNames.add(name.getText());
			} else {
				crewNames.remove(name.getText());  // remove previous name
				name.setText(txtFdName.getText());
				crewNames.add(name.getText());     // add new name
			}
		}
	}
	
	
	// Adding the character Type to the list and displaying the type chosen as labels
	private void addMember(JCheckBox selectedChar, JComboBox<?> selectedNumber, String playerType) 
	{
		String removeX = (String) selectedNumber.getSelectedItem();  // get the item
		
		if (selectedChar.isSelected()) { // check if selected
			selectedNumber.setVisible(true);  // make the players combo box visible
			
			// remove the old amount to the list
			for (int index = 0; index < previousCount; index++) 
				crewType.remove(playerType);
			
			// added the new amount to the list
			int value = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string to int)
			for (int index = 0; index < value; index++)
				crewType.add(playerType);
			
			previousCount = crewType.size();  // store first count
			
		} else {
			// change the combo box visibility
			selectedNumber.setVisible(false);
			selectedNumber.setSelectedIndex(0);
			
			// remove the old amount to the list
			for (int i = 0; i < previousCount; i++) 
				crewType.remove(playerType);
			
			previousCount = crewType.size();  // store the previous value count size
		}
	}
	
	
	private void setMembersChosen()
	{
		// Update names and types arrays
		settingChar();
		settingNumber();
		
		// turning non-active areas on
		comBoxCharChosen.setEnabled(true);
		txtFdName.setEnabled(true);
		btnAcceptName.setEnabled(true);
		btnReset.setEnabled(true);
		
		
		// Disable the combo boxes if player is not selected
		for (int index = 0; index < 6; index++) {   // number of possible numbers
			disableCharBoxes(charSelect[index], charNumber[index]);
		}
		
		// Add Members that were chosen to the combo box
		for (int index = 0; index < crewType.size(); index++) {
			comBoxCharChosen.addItem(index+1 + ": " + crewType.get(index));
		
			if (index == 0) lblMember1.setText(1 + ": " + crewType.get(0).toString());
			else if (index == 1) lblMember2.setText(2 + ": " + crewType.get(1).toString());
			else if (index == 2) lblMember3.setText(3 + ": " + crewType.get(2).toString());
			else if (index == 3) lblMember4.setText(4 + ": " + crewType.get(3).toString());
		}
	}


	/* ----------------------------------------------------------------------- */
	// Add a new check box for each character,
	// Add a new member that if check box set
	private void checkSoldier() 
	{
		selectSoldier = new JCheckBox("select");
		selectSoldier.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[0], charNumber[0], "Soldier");
			}
		});
		selectSoldier.setBounds(58, 506, 126, 23);
		frame.getContentPane().add(selectSoldier);
	}
	
	private void checkMedic() 
	{
		selectMedic = new JCheckBox("select");
		selectMedic.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[1], charNumber[1], "Medic");
			}
		});
		selectMedic.setBounds(311, 506, 126, 23);
		frame.getContentPane().add(selectMedic);
	}
	
	private void checkLeader() 
	{
		selectLeader = new JCheckBox("select");
		selectLeader.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[2], charNumber[2], "Leader");

			}
		});
		selectLeader.setBounds(574, 506, 126, 23);
		frame.getContentPane().add(selectLeader);
	}
	
	private void checkMechanic() 
	{
		selectMechanic = new JCheckBox("select");
		selectMechanic.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[3], charNumber[3], "Mechanic");
			}
		});
		selectMechanic.setBounds(851, 506, 126, 23);
		frame.getContentPane().add(selectMechanic);
	}
	
	private void checkPilot() 
	{
		selectPilot = new JCheckBox("select");
		selectPilot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[4], charNumber[4], "Pilot");
			}
		});
		selectPilot.setBounds(1073, 509, 126, 23);
		frame.getContentPane().add(selectPilot);
	}
	
	private void checkThief() 
	{
		selectThief = new JCheckBox("select");
		selectThief.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
			
				addMember(charSelect[5], charNumber[5], "Thief");
			}
		});
		selectThief.setBounds(1313, 512, 126, 23);
		frame.getContentPane().add(selectThief);
	}
	
	// number of players that could be selected
	// characters either are added or removed from lists
	private void characterChoices()
	{
		checkSoldier();
		checkMedic();
		checkLeader();
		checkMechanic();
		checkPilot();
		checkThief();
	}
	
	/* ----------------------------------------------------------------------- */
	
	
	/* ----------------------------------------------------------------------- */
	// Add a new combo box for each character,
	// Add or remove member that is chosen when the characters check box number is chosen
	private void soldierNumber()
	{
		comboBoxSoldier = new JComboBox<Object>();
		comboBoxSoldier.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[0], charNumber[0], "Soldier");
			}
		});
		
		comboBoxSoldier.setVisible(false);
		comboBoxSoldier.setToolTipText("");
		comboBoxSoldier.setModel(new DefaultComboBoxModel<Object>(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxSoldier.setMaximumRowCount(4);
		comboBoxSoldier.setBounds(58, 561, 72, 36);
		frame.getContentPane().add(comboBoxSoldier);
	}
	
	private void medicNumber()
	{
		comboBoxMedic = new JComboBox<Object>();
		comboBoxMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[1], charNumber[1], "Medic");
			}
		});
		
		comboBoxMedic.setToolTipText("");
		comboBoxMedic.setVisible(false);
		comboBoxMedic.setModel(new DefaultComboBoxModel<Object>(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxMedic.setMaximumRowCount(4);
		comboBoxMedic.setBounds(320, 561, 72, 36);
		frame.getContentPane().add(comboBoxMedic);
	}
	
	private void leaderNumber()
	{
		comboBoxLeader = new JComboBox<Object>();
		comboBoxLeader.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[2], charNumber[2], "Leader");
			}
		});
		comboBoxLeader.setToolTipText("");
		comboBoxLeader.setVisible(false);
		comboBoxLeader.setModel(new DefaultComboBoxModel<Object>(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxLeader.setMaximumRowCount(4);
		comboBoxLeader.setBounds(574, 561, 72, 36);
		frame.getContentPane().add(comboBoxLeader);
	}
	
	private void mechanicNumber()
	{
		comboBoxMechanic = new JComboBox<Object>();
		comboBoxMechanic.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[3], charNumber[3], "Mechanic");
			}
		});
		
		comboBoxMechanic.setToolTipText("");
		comboBoxMechanic.setVisible(false);
		comboBoxMechanic.setModel(new DefaultComboBoxModel<Object>(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxMechanic.setMaximumRowCount(4);
		comboBoxMechanic.setBounds(837, 561, 72, 36);
		frame.getContentPane().add(comboBoxMechanic);
	}
	
	private void pilotNumber()
	{
		comboBoxPilot = new JComboBox<Object>();
		comboBoxPilot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[4], charNumber[4], "Pilot");
			}
		});
		
		comboBoxPilot.setToolTipText("");
		comboBoxPilot.setVisible(false);
		comboBoxPilot.setModel(new DefaultComboBoxModel<Object>(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxPilot.setMaximumRowCount(4);
		comboBoxPilot.setBounds(1073, 561, 72, 36);
		frame.getContentPane().add(comboBoxPilot);
	}
	
	private void thiefNumber()
	{
		comboBoxThief = new JComboBox<Object>();
		comboBoxThief.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[5], charNumber[5], "Thief");
			}
		});
		
		comboBoxThief.setToolTipText("");
		comboBoxThief.setVisible(false);
		comboBoxThief.setModel(new DefaultComboBoxModel<Object>(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxThief.setSelectedIndex(0);
		comboBoxThief.setMaximumRowCount(4);
		comboBoxThief.setBounds(1313, 559, 72, 41);
		frame.getContentPane().add(comboBoxThief);
	}
	
	// creating combo boxes for each players and determining there states
	private void characterNumber()
	{
		soldierNumber();
		medicNumber();
		leaderNumber();
		mechanicNumber();
		pilotNumber();
		thiefNumber();
	}
	
	/* ----------------------------------------------------------------------- */
	
	
	// If the user has selected between 2 to 4 players, allow the user to input names
	// for that player type
	private void acceptCharacters()
	{
		btnAcceptChars = new JButton("Accept Team Composition");
		btnAcceptChars.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// If the user doesnt select between 2 to 4 players, an error will occur
				if ((crewType.size() < 2) || (crewType.size() > 4)) JOptionPane.showMessageDialog(null, "Please select 2 to 4 crewType members only"); 
				else {
					// Display the information the user selected
					setMembersChosen();	
					btnAcceptChars.setEnabled(false);  // disable button
					
					// Disable info windows					
					soldierInfo.setEnabled(false);
					leaderInfo.setEnabled(false);
					pilotInfo.setEnabled(false);
					medicInfo.setEnabled(false);
					mechanicInfo.setEnabled(false);
					thiefInfo.setEnabled(false);
				}
			}
		});
		btnAcceptChars.setBounds(741, 663, 157, 54);
		frame.getContentPane().add(btnAcceptChars);
	}


	// If user pushes the Next button, send info and move to next screen
	private void nextButton()
	{
		btnNext = new JButton("Next");
		btnNext.setEnabled(false);
		btnNext.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Only can move forward if names have been allocated to a player
				// Error messages
				if ((crewNames.size() == 0) || (crewType.size() == 0)) JOptionPane.showMessageDialog(null, "Please complete the fields");
				else if (crewNames.size() == crewType.size()) {
					// Setting a new frame
					NameShip nameShip = new NameShip();
					nameShip.frame.setVisible(true);  // turn on screen
					frame.setVisible(false);          // turn off screen
					
					// Send info to next screen
					nameShip.getCrewInfo(crewType, crewNames);
					
				} else JOptionPane.showMessageDialog(null, "Please complete the fields");  // Error message
			}
		});
		btnNext.setBounds(1376, 778, 136, 47);
		frame.getContentPane().add(btnNext);
	}

	
	private void resetButton()
	{
		// If Reset button is pushed, Reset (Clear) the Screen
		btnReset = new JButton("Reset");
		btnReset.setEnabled(false);
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				resetScreen();
			}
		});
		btnReset.setBounds(1238, 774, 109, 54);
		frame.getContentPane().add(btnReset);
	}

	
	// Acept the characters name and set it to the character
	private void acceptName()
	{
		btnAcceptName = new JButton("Accept Name");
		btnAcceptName.setEnabled(false);
		btnAcceptName.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// display error message
				if (crewType.size() == 0) JOptionPane.showMessageDialog(null, "Enter a crewType member first");
				// checking how many names we have to input & output
				else if (txtFdName.getText().equals("")) JOptionPane.showMessageDialog(null, "Please enter a name");  
				else {	
					// Add the correct name with the selected player
					if (comBoxCharChosen.getSelectedIndex() == 0) addNames(name1);
					if (comBoxCharChosen.getSelectedIndex() == 1) addNames(name2);
					if (comBoxCharChosen.getSelectedIndex() == 2) addNames(name3);
					if (comBoxCharChosen.getSelectedIndex() == 3) addNames(name4);
					
					// show the next button when fields are completed
					if (crewNames.size() == crewType.size()) btnNext.setEnabled(true);  
				}
				
				// clear & reset nameing field
				txtFdName.setText("");
		
			}
		});
		btnAcceptName.setBounds(482, 750, 157, 59);
		frame.getContentPane().add(btnAcceptName);
	}
	
	
	private void thiefWindow()
	{
		thiefInfo = new JButton("More Info");
		thiefInfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Setting a new frame
				Thief thief = new Thief();
				thief.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		thiefInfo.setBounds(1313, 402, 85, 21);
		frame.getContentPane().add(thiefInfo);
	}
	
	
	private void pilotWindow()
	{
		pilotInfo = new JButton("More Info");
		pilotInfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Setting a new frame
				Pilot pilot = new Pilot();
				pilot.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		pilotInfo.setBounds(1082, 402, 85, 21);
		frame.getContentPane().add(pilotInfo);
	}
	
	
	private void mechanicWindow()
	{
		mechanicInfo = new JButton("More Info");
		mechanicInfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Setting a new frame
				Mechanic mechanic = new Mechanic();
				mechanic.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		mechanicInfo.setBounds(837, 402, 85, 21);
		frame.getContentPane().add(mechanicInfo);
	}
	
	
	private void leaderWindow()
	{
		leaderInfo = new JButton("More Info");
		leaderInfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Setting a new frame
				Leader medic = new Leader();
				medic.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		leaderInfo.setBounds(574, 402, 85, 21);
		frame.getContentPane().add(leaderInfo);
	}
	
	
	private void soldierWindow()
	{
		soldierInfo = new JButton("More Info");
		soldierInfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Setting a new frame
				Soldier soldier = new Soldier();
				soldier.frame.setVisible(true);  // turn on screen
				frame.setVisible(false); 
			}
		});
		soldierInfo.setBounds(58, 402, 85, 21);
		frame.getContentPane().add(soldierInfo);
	}
	
	
	private void medicWindow()
	{
		medicInfo = new JButton("More Info");
		medicInfo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Setting a new frame
				Medic medic = new Medic();
				medic.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		medicInfo.setBounds(320, 403, 85, 21);
		frame.getContentPane().add(medicInfo);
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
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(false);  // Frame cannot be adjusted during game
		frame.setResizable(false);
		
		
		// Initializing displays
		JLabel lblCurrentTeam = new JLabel("Current Team");
		lblCurrentTeam.setBounds(43, 683, 109, 15);
		frame.getContentPane().add(lblCurrentTeam);
		
		txtFdName = new JTextField();
		txtFdName.setEnabled(false);
		txtFdName.setBounds(251, 748, 183, 36);
		frame.getContentPane().add(txtFdName);
		txtFdName.setColumns(10);
		
		JLabel lblEntername = new JLabel("Names");
		lblEntername.setBounds(175, 683, 66, 15);
		frame.getContentPane().add(lblEntername);
	
		lblMember1 = new JLabel("1. ...");

		lblMember1.setBounds(30, 713, 109, 15);
		frame.getContentPane().add(lblMember1);
		
		lblMember2 = new JLabel("2. ...");
		lblMember2.setBounds(30, 740, 117, 15);
		frame.getContentPane().add(lblMember2);
		
		lblMember3 = new JLabel("3. ...");
		lblMember3.setBounds(30, 767, 117, 15);
		frame.getContentPane().add(lblMember3);
		
		lblMember4 = new JLabel("4. ...");
		lblMember4.setBounds(30, 794, 117, 15);
		frame.getContentPane().add(lblMember4);
		
		name1 = new JLabel("...");
		name1.setBounds(152, 712, 109, 15);
		frame.getContentPane().add(name1);
		
		name2 = new JLabel("...");
		name2.setBounds(152, 740, 109, 15);
		frame.getContentPane().add(name2);
		
		name3 = new JLabel("...");
		name3.setBounds(152, 766, 109, 15);
		frame.getContentPane().add(name3);
		
		name4 = new JLabel("...");
		name4.setBounds(152, 793, 109, 15);
		frame.getContentPane().add(name4);
		
		progressBar = new JProgressBar();
		progressBar.setValue(1);
		progressBar.setStringPainted(true);
		progressBar.setMaximum(3);
		progressBar.setBounds(12, 52, 148, 25);
		frame.getContentPane().add(progressBar);
		
		label = new JLabel("Setup progress");
		label.setBounds(18, 22, 116, 18);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("Character selection, you can choose VARIABLE characters in any combination to form your astronaut team");
		lblNewLabel.setBounds(213, 65, 820, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Click on any to view information");
		lblNewLabel_1.setBounds(357, 158, 415, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblSoldier = new JLabel("Soldier");
		lblSoldier.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSoldier.setBounds(58, 434, 117, 54);
		frame.getContentPane().add(lblSoldier);
		
		JLabel lblMedic = new JLabel("Medic");
		lblMedic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMedic.setBounds(320, 434, 117, 54);
		frame.getContentPane().add(lblMedic);
		
		JLabel lblLeader = new JLabel("Leader");
		lblLeader.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLeader.setBounds(574, 434, 117, 54);
		frame.getContentPane().add(lblLeader);
		
		JLabel lblMechanic = new JLabel("Mechanic");
		lblMechanic.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMechanic.setBounds(837, 434, 117, 54);
		frame.getContentPane().add(lblMechanic);
		
		JLabel lblPilot = new JLabel("Pilot");
		lblPilot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPilot.setBounds(1082, 427, 117, 47);
		frame.getContentPane().add(lblPilot);
		
		JLabel lblThief = new JLabel("Thief");
		lblThief.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThief.setBounds(1313, 428, 150, 47);
		frame.getContentPane().add(lblThief);
		
		JLabel lblPleaseInputA = new JLabel("Please input a name for:");
		lblPleaseInputA.setBounds(251, 689, 157, 15);
		frame.getContentPane().add(lblPleaseInputA);
		
		comBoxCharChosen = new JComboBox<Object>();
		comBoxCharChosen.setEnabled(false);
		comBoxCharChosen.setBounds(251, 716, 142, 27);
		frame.getContentPane().add(comBoxCharChosen);
		
		JProgressBar soldierHealth = new JProgressBar();
		soldierHealth.setStringPainted(true);
		soldierHealth.setForeground(Color.black);
		soldierHealth.setValue(80);
		soldierHealth.setBounds(79, 259, 146, 11);
		frame.getContentPane().add(soldierHealth);
		
		JProgressBar soldierTired = new JProgressBar();
		soldierTired.setStringPainted(true);
		soldierTired.setForeground(Color.black);
		soldierTired.setValue(50);
		soldierTired.setBounds(79, 282, 146, 11);
		frame.getContentPane().add(soldierTired);
		
		JProgressBar soldierHunger = new JProgressBar();
		soldierHunger.setStringPainted(true);
		soldierHunger.setForeground(Color.black);
		soldierHunger.setValue(70);
		soldierHunger.setBounds(79, 319, 146, 11);
		frame.getContentPane().add(soldierHunger);
		
		JProgressBar medicHealth = new JProgressBar();
		medicHealth.setStringPainted(true);
		medicHealth.setForeground(Color.black);
		medicHealth.setValue(100);
		medicHealth.setBounds(309, 259, 146, 11);
		frame.getContentPane().add(medicHealth);
		
		JProgressBar medicTired = new JProgressBar();
		medicTired.setStringPainted(true);
		medicTired.setForeground(Color.black);
		medicTired.setValue(50);
		medicTired.setBounds(309, 286, 146, 11);
		frame.getContentPane().add(medicTired);
		
		JProgressBar medicHunger = new JProgressBar();
		medicHunger.setStringPainted(true);
		medicHunger.setForeground(Color.black);
		medicHunger.setValue(50);
		medicHunger.setBounds(309, 319, 146, 11);
		frame.getContentPane().add(medicHunger);
		
		JLabel lblHealth = new JLabel("Health");
		lblHealth.setBounds(12, 259, 46, 13);
		frame.getContentPane().add(lblHealth);
		
		JLabel lblTiredness = new JLabel("Tiredness");
		lblTiredness.setBounds(12, 284, 66, 13);
		frame.getContentPane().add(lblTiredness);
		
		JLabel lblHunger = new JLabel("Hunger");
		lblHunger.setBounds(12, 317, 46, 13);
		frame.getContentPane().add(lblHunger);
		
		JProgressBar leaderHealth = new JProgressBar();
		leaderHealth.setStringPainted(true);
		leaderHealth.setForeground(Color.black);
		leaderHealth.setValue(40);
		leaderHealth.setBounds(574, 259, 146, 11);
		frame.getContentPane().add(leaderHealth);
		
		JProgressBar leaderTired = new JProgressBar();
		leaderTired.setStringPainted(true);
		leaderTired.setForeground(Color.black);
		leaderTired.setValue(60);
		leaderTired.setBounds(574, 286, 146, 11);
		frame.getContentPane().add(leaderTired);
		
		JProgressBar leaderHunger = new JProgressBar();
		leaderHunger.setStringPainted(true);
		leaderHunger.setForeground(Color.black);
		leaderHunger.setValue(100);
		leaderHunger.setBounds(574, 319, 146, 11);
		frame.getContentPane().add(leaderHunger);
		
		JProgressBar mechanicHealth = new JProgressBar();
		mechanicHealth.setStringPainted(true);
		mechanicHealth.setForeground(Color.black);
		mechanicHealth.setValue(80);
		mechanicHealth.setBounds(837, 259, 146, 11);
		frame.getContentPane().add(mechanicHealth);
		
		JProgressBar mechanicTired = new JProgressBar();
		mechanicTired.setStringPainted(true);
		mechanicTired.setForeground(Color.black);
		mechanicTired.setValue(50);
		mechanicTired.setBounds(837, 286, 146, 11);
		frame.getContentPane().add(mechanicTired);
		
		JProgressBar mechanicHunger = new JProgressBar();
		mechanicHunger.setStringPainted(true);
		mechanicHunger.setForeground(Color.black);
		mechanicHunger.setValue(70);
		mechanicHunger.setBounds(837, 319, 146, 11);
		frame.getContentPane().add(mechanicHunger);
		
		JProgressBar pilotHealth = new JProgressBar();
		pilotHealth.setStringPainted(true);
		pilotHealth.setForeground(Color.black);
		pilotHealth.setValue(50);
		pilotHealth.setBounds(1082, 259, 146, 11);
		frame.getContentPane().add(pilotHealth);
		
		JProgressBar pilotTired = new JProgressBar();
		pilotTired.setStringPainted(true);
		pilotTired.setForeground(Color.black);
		pilotTired.setValue(100);
		pilotTired.setBounds(1082, 286, 146, 11);
		frame.getContentPane().add(pilotTired);
		
		JProgressBar pilotHunger = new JProgressBar();
		pilotHunger.setStringPainted(true);
		pilotHunger.setForeground(Color.black);
		pilotHunger.setValue(50);
		pilotHunger.setBounds(1082, 319, 146, 11);
		frame.getContentPane().add(pilotHunger);
		
		JProgressBar thiefHealth = new JProgressBar();
		thiefHealth.setStringPainted(true);
		thiefHealth.setForeground(Color.black);
		thiefHealth.setValue(70);
		thiefHealth.setBounds(1313, 259, 146, 11);
		frame.getContentPane().add(thiefHealth);
		
		JProgressBar thiefTired = new JProgressBar();
		thiefTired.setStringPainted(true);
		thiefTired.setForeground(Color.black);
		thiefTired.setValue(60);
		thiefTired.setBounds(1313, 286, 146, 11);
		frame.getContentPane().add(thiefTired);
		
		JProgressBar thiefHunger = new JProgressBar();
		thiefHunger.setStringPainted(true);
		thiefHunger.setForeground(Color.black);
		thiefHunger.setValue(70);
		thiefHunger.setBounds(1313, 319, 146, 11);
		frame.getContentPane().add(thiefHunger);
		
		

		// Button Actions
		characterChoices();
		characterNumber();
		acceptCharacters();
		nextButton();
		resetButton();
		acceptName();
		
		// Information window
		mechanicWindow();
		pilotWindow();
		leaderWindow();
		soldierWindow();
		medicWindow();
		thiefWindow();
	}
	
	
	/*
	 * Create the application.
	*/
	public CrewSelection() {
		initialize();
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
					CrewSelection window = new CrewSelection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
