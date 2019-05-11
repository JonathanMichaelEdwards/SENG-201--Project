import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
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



public class CrewSelection {

	public JFrame frame;
	private JTextField txtFdName;
	
	JCheckBox selectSoldier, selectMedic, selectLeader, selectMechanic, selectPilot, selectThief;
	
	JLabel lblMember1;
	JLabel lblMember2;
	JLabel lblMember3;
	JLabel lblMember4;

	
	JComboBox<Object> comboBoxSoldier;
	JComboBox<Object> comboBoxMedic;
	JComboBox<Object> comboBoxLeader;
	JComboBox<Object> comboBoxMechanic;
	JComboBox<Object> comboBoxPilot;
	JComboBox<Object> comboBoxThief;
	
	JComboBox<Object> comBoxCharChosen;
	
	int countSoldier, countMedic, countLeader, countMechanic, countPilot, countThief, countNames = 0;  // initial value
	int piecesToCollect = 0;
	int previousCount = 0;
	
	boolean checkedState = false;
	
	
	JButton btnAcceptName;
	JButton btnReset;
	

	// Stored list of crewType members and there names
	public ArrayList<String> crewType = new ArrayList<String>();
	public ArrayList<String> crewNames = new ArrayList<String>();
	
	
	
	private JLabel name1, name2, name3, name4;  // nameing labels
	private JProgressBar progressBar;
	private JLabel label;
	
	JCheckBox charSelect[] = new JCheckBox[6];
	JComboBox<?> charNumber[] = new JComboBox<?>[6];
	
	
	// Retrives current status of varibles for array
	void settingChar() 
	{
		charSelect[0] = selectSoldier;
		charSelect[1] = selectMedic;
		charSelect[2] = selectLeader;
		charSelect[3] = selectMechanic;
		charSelect[4] = selectPilot;
		charSelect[5] = selectThief;
	}
	
	// Retrives current status of varibles for array
	void settingNumber() 
	{
		charNumber[0] = comboBoxSoldier;
		charNumber[1] = comboBoxMedic;
		charNumber[2] = comboBoxLeader;
		charNumber[3] = comboBoxMechanic;
		charNumber[4] = comboBoxPilot;
		charNumber[5] = comboBoxThief;
	}
	
	
	// Disable tick boxes
	void disableCharBoxes(JCheckBox charSelect, JComboBox<?> charNumber) 
	{
		charSelect.setEnabled(false);
		charNumber.setEnabled(false);
		
		if (charNumber.getSelectedIndex() == -1) {
			charSelect.setSelected(false);  // disable if pushed and no number is given
			charNumber.setVisible(false);   // disable boxes
		}
	}
	
	
	// Store pieces
	public void storeDays(int pieces)
	{
		piecesToCollect = pieces;
		System.out.println("1. " + piecesToCollect);
		
	}
	
	
	// If character is selected, if selected diplay combo box,  else remove if character exists and change box
	void selectedChar(JCheckBox selectedChar, JComboBox<?> selectedNumber, int counter, String playerType)
	{
		if (selectedChar.isSelected()) {
			selectedNumber.setVisible(true);
		} else {
			// removing crew member from list if check box disabled
			for (int index = 0; index < counter; index++)
				crewType.remove(playerType);
			
			selectedNumber.setVisible(false);
			selectedNumber.setSelectedIndex(0);
		}
	}
	
	
	private void checkSoldier() 
	{
		selectSoldier = new JCheckBox("select");
		selectSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				selectedChar(charSelect[0], charNumber[0], countSoldier, "Soldier");
				addMember(charSelect[0], charNumber[0], countSoldier, "Soldier");
			}
		});
		selectSoldier.setBounds(25, 259, 126, 23);
		frame.getContentPane().add(selectSoldier);
	}
	
	
	private void checkMedic() 
	{
		selectMedic = new JCheckBox("select");
		selectMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				selectedChar(charSelect[1], charNumber[1], countMedic, "Medic");
				addMember(charSelect[1], charNumber[1], countMedic, "Medic");
			}
		});
		selectMedic.setBounds(157, 259, 126, 23);
		frame.getContentPane().add(selectMedic);
	}
	
	
	private void checkLeader() 
	{
		selectLeader = new JCheckBox("select");
		selectLeader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				selectedChar(charSelect[2], charNumber[2], countLeader, "Leader");
				addMember(charSelect[2], charNumber[2], countLeader, "Leader");

			}
		});
		selectLeader.setBounds(300, 259, 126, 23);
		frame.getContentPane().add(selectLeader);
	}
	
	
	private void checkMechanic() 
	{
		selectMechanic = new JCheckBox("select");
		selectMechanic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				selectedChar(charSelect[3], charNumber[3], countMechanic, "Mechanic");
				addMember(charSelect[3], charNumber[3], countMechanic, "Mechanic");
			}
		});
		selectMechanic.setBounds(448, 259, 126, 23);
		frame.getContentPane().add(selectMechanic);
	}
	
	
	private void checkPilot() 
	{
		selectPilot = new JCheckBox("select");
		selectPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				selectedChar(charSelect[4], charNumber[4], countPilot, "Pilot");
				addMember(charSelect[4], charNumber[4], countPilot, "Pilot");
			}
		});
		selectPilot.setBounds(583, 259, 126, 23);
		frame.getContentPane().add(selectPilot);
	}
	
	
	private void checkThief() 
	{
		selectThief = new JCheckBox("select");
		selectThief.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				selectedChar(charSelect[5], charNumber[5], countThief, "Thief");
				addMember(charSelect[5], charNumber[5], countThief, "Thief");
			}
		});
		selectThief.setBounds(730, 259, 126, 23);
		frame.getContentPane().add(selectThief);
	}
	
	
	private void selectedPlayers()
	{
		checkSoldier();
		checkMedic();
		checkLeader();
		checkMechanic();
		checkPilot();
		checkThief();
	}
	
	
	
	// Adding names to list
	void addNames(JLabel name)
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
	
	
	// reseting 
	void resetScreen()
	{
		// Setting a new frame
		CrewSelection selectCrew = new CrewSelection();
		selectCrew.frame.setVisible(true);  // turn on screen
		frame.setVisible(false);   // turn off screen

	}
	
	void addMember(JCheckBox selectedChar, JComboBox<?> selectedNumber, int count, String playerType) 
	{
		String removeX = (String) selectedNumber.getSelectedItem();  // get the item
		
		if (selectedChar.isSelected()) { // check if selected
			// remove the old amount to the list
			for (int i = 0; i < previousCount; i++) 
				crewType.remove(playerType);
			
			
			// added the new amount to the list
			int value = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string to int)
			System.out.println(value);
			for (int i = 0; i < value; i++)
				crewType.add(playerType);
			
			previousCount = crewType.size();  // store first count
			
		} else {
			// remove the old amount to the list
			for (int i = 0; i < previousCount; i++) 
				crewType.remove(playerType);
			
			previousCount = crewType.size();  // store first count  (update again)
		}
	}
	
	void setMembersChosen()
	{
		settingChar();
		settingNumber();
		
		// turning greyed areas on
		comBoxCharChosen.setEnabled(true);
		txtFdName.setEnabled(true);
		btnAcceptName.setEnabled(true);
		btnReset.setEnabled(true);
		
		
		for (int index = 0; index < 6; index++) { // 6 because number of possible character selections
			disableCharBoxes(charSelect[index], charNumber[index]);
		}
		
		// Add Members that were chosen to the combo box
		for (int index = 0; index < crewType.size(); index++) {
			comBoxCharChosen.addItem(index+1 + ": " + crewType.get(index));
		}

		lblMember1.setText(1 + ": " + crewType.get(0).toString());
		lblMember2.setText(2 + ": " + crewType.get(1).toString());
		lblMember3.setText(3 + ": " + crewType.get(2).toString());
		lblMember4.setText(4 + ": " + crewType.get(3).toString());
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrewSelection window = new CrewSelection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public CrewSelection() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 908, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCurrentTeam = new JLabel("Current Team");
		lblCurrentTeam.setBounds(25, 342, 109, 15);
		frame.getContentPane().add(lblCurrentTeam);
		
		txtFdName = new JTextField();
		txtFdName.setEnabled(false);
		txtFdName.setBounds(448, 361, 183, 36);
		frame.getContentPane().add(txtFdName);
		txtFdName.setColumns(10);
		
		JLabel lblEntername = new JLabel("Names");
		lblEntername.setBounds(157, 342, 66, 15);
		frame.getContentPane().add(lblEntername);
		
		
		
		
		lblMember1 = new JLabel("1. ...");

		lblMember1.setBounds(12, 372, 109, 15);
		frame.getContentPane().add(lblMember1);
		
		lblMember2 = new JLabel("2. ...");
		lblMember2.setBounds(12, 399, 117, 15);
		frame.getContentPane().add(lblMember2);
		
		lblMember3 = new JLabel("3. ...");
		lblMember3.setBounds(12, 426, 117, 15);
		frame.getContentPane().add(lblMember3);
		
		lblMember4 = new JLabel("4. ...");
		lblMember4.setBounds(12, 453, 117, 15);
		frame.getContentPane().add(lblMember4);
		
		
		
		selectedPlayers();
		

		
		// Buttons
		final JButton btnAcceptChars = new JButton("Accept Characters");
		btnAcceptChars.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(crewType);
				if ((crewType.size() < 2) || (crewType.size() > 4)) {
					JOptionPane.showMessageDialog(null, "Please select 2 to 4 crewType members only"); 
				} else {
					try { 
						setMembersChosen();
						
					} catch (Exception e) {
						 // continue if list is greater
					}
					btnAcceptChars.setEnabled(false);  // disable button
				}
			}
		});
		
		btnAcceptChars.setBounds(692, 333, 157, 54);
		frame.getContentPane().add(btnAcceptChars);
		
		
		
		
		
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Only can move forward if names have been allocated to a player
				//Error messages
				if ((crewNames.size() == 0) || (crewType.size() == 0)) { JOptionPane.showMessageDialog(null, "Please complete the fields");}
				else if (crewNames.size() == crewType.size()) {
					// Setting a new frame
					NameShip nameShip = new NameShip();
					nameShip.frame.setVisible(true);  // turn on screen
					frame.setVisible(false);          // turn off screen
					
					System.out.println(piecesToCollect);
					// Send data to name ship
					nameShip.getCrewInfo(crewType, crewNames, piecesToCollect);

					
				} else JOptionPane.showMessageDialog(null, "Please complete the fields");  // Error message
			}
		});
		btnNext.setBounds(742, 438, 136, 47);
		frame.getContentPane().add(btnNext);
		
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Setting a new frame
				ChooseDays chooseDays = new ChooseDays();
				
				// Set stored pieces from last time
				chooseDays.getDays(piecesToCollect);  // Send back to choose days
				chooseDays.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);              // turn off screen
			}
		});
		btnBack.setBounds(583, 438, 126, 47);
		frame.getContentPane().add(btnBack);
		
		btnReset = new JButton("Reset");
		btnReset.setEnabled(false);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetScreen();
			}
		});
		btnReset.setBounds(465, 426, 109, 54);
		frame.getContentPane().add(btnReset);
		
		
		
		
		
		
		JLabel lblSoldier = new JLabel("Soldier");
		lblSoldier.setBounds(25, 90, 117, 161);
		frame.getContentPane().add(lblSoldier);
		
		JLabel lblMedic = new JLabel("Medic");
		lblMedic.setBounds(146, 90, 117, 161);
		frame.getContentPane().add(lblMedic);
		
		JLabel lblLeader = new JLabel("Leader");
		lblLeader.setBounds(300, 90, 117, 161);
		frame.getContentPane().add(lblLeader);
		
		JLabel lblMechanic = new JLabel("Mechanic");
		lblMechanic.setBounds(448, 90, 117, 161);
		frame.getContentPane().add(lblMechanic);
		
		JLabel lblPilot = new JLabel("Pilot");
		lblPilot.setBounds(574, 90, 117, 161);
		frame.getContentPane().add(lblPilot);
		
		JLabel lblThief = new JLabel("Thief");
		lblThief.setBounds(706, 90, 117, 161);
		frame.getContentPane().add(lblThief);
		
		
		comboBoxSoldier = new JComboBox();
		comboBoxSoldier.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[0], charNumber[0], countSoldier, "Soldier");
			}
		});
		
		comboBoxSoldier.setVisible(false);
		comboBoxSoldier.setToolTipText("");
		comboBoxSoldier.setModel(new DefaultComboBoxModel(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxSoldier.setMaximumRowCount(4);
		comboBoxSoldier.setBounds(35, 282, 72, 36);
		frame.getContentPane().add(comboBoxSoldier);
		
		
		
		
		
		comboBoxMedic = new JComboBox();
		comboBoxMedic.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[1], charNumber[1], countMedic, "Medic");
			}
		});
		
		comboBoxMedic.setToolTipText("");
		comboBoxMedic.setVisible(false);
		comboBoxMedic.setModel(new DefaultComboBoxModel(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxMedic.setMaximumRowCount(4);
		comboBoxMedic.setBounds(171, 282, 72, 36);
		frame.getContentPane().add(comboBoxMedic);
		
		
		
		comboBoxLeader = new JComboBox();
		comboBoxLeader.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[2], charNumber[2], countLeader, "Leader");
			}
		});
		
		comboBoxLeader.setToolTipText("");
		comboBoxLeader.setVisible(false);
		comboBoxLeader.setModel(new DefaultComboBoxModel(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxLeader.setMaximumRowCount(4);
		comboBoxLeader.setBounds(310, 282, 72, 36);
		frame.getContentPane().add(comboBoxLeader);
		
		
		
		comboBoxMechanic = new JComboBox<Object>();
		comboBoxMechanic.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[3], charNumber[3], countMechanic, "Mechanic");
			}
		});
		
		comboBoxMechanic.setToolTipText("");
		comboBoxMechanic.setVisible(false);
		comboBoxMechanic.setModel(new DefaultComboBoxModel(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxMechanic.setMaximumRowCount(4);
		comboBoxMechanic.setBounds(448, 282, 72, 36);
		frame.getContentPane().add(comboBoxMechanic);
		
		
		
		comboBoxPilot = new JComboBox();
		comboBoxPilot.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[4], charNumber[4], countPilot, "Pilot");
			}
		});
		
		comboBoxPilot.setToolTipText("");
		comboBoxPilot.setVisible(false);
		comboBoxPilot.setModel(new DefaultComboBoxModel(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxPilot.setMaximumRowCount(4);
		comboBoxPilot.setBounds(577, 282, 72, 36);
		frame.getContentPane().add(comboBoxPilot);
		
		
		
		comboBoxThief = new JComboBox();
		comboBoxThief.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// set values for global array's
				settingChar();
				settingNumber();
				
				addMember(charSelect[5], charNumber[5], countThief, "Thief");
			}
		});
		
		comboBoxThief.setToolTipText("");
		comboBoxThief.setVisible(false);
		comboBoxThief.setModel(new DefaultComboBoxModel(new String[] {"x1", "x2", "x3", "x4"}));
		comboBoxThief.setSelectedIndex(0);
		comboBoxThief.setMaximumRowCount(4);
		comboBoxThief.setBounds(722, 282, 72, 41);
		frame.getContentPane().add(comboBoxThief);
		
		
		
		
		JLabel lblPleaseInputA = new JLabel("Please input a name for:");
		lblPleaseInputA.setBounds(300, 330, 157, 15);
		frame.getContentPane().add(lblPleaseInputA);
		
		comBoxCharChosen = new JComboBox();
		comBoxCharChosen.setEnabled(false);
		comBoxCharChosen.setBounds(300, 360, 142, 27);
		frame.getContentPane().add(comBoxCharChosen);
		
		
		

		
		
		
		
		
		btnAcceptName = new JButton("Accept Name");
		btnAcceptName.setEnabled(false);
		btnAcceptName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// display error message
				if (crewType.size() == 0) JOptionPane.showMessageDialog(null, "Enter a crewType member first");
				// checking how many names we have to input & output
				else if (txtFdName.getText().equals("")) JOptionPane.showMessageDialog(null, "Please enter a name");  
				
				else {	
					if (comBoxCharChosen.getSelectedIndex() == 0) addNames(name1);
					if (comBoxCharChosen.getSelectedIndex() == 1) addNames(name2);
					if (comBoxCharChosen.getSelectedIndex() == 2) addNames(name3);
					if (comBoxCharChosen.getSelectedIndex() == 3) addNames(name4);
				}
		
				// clear & reset nameing field
				txtFdName.setText("");
		
			}
		});
		btnAcceptName.setBounds(300, 405, 157, 59);
		frame.getContentPane().add(btnAcceptName);
		
		
		
		
		
		
		name1 = new JLabel("...");
		name1.setBounds(134, 371, 109, 15);
		frame.getContentPane().add(name1);
		
		name2 = new JLabel("...");
		name2.setBounds(134, 399, 109, 15);
		frame.getContentPane().add(name2);
		
		name3 = new JLabel("...");
		name3.setBounds(134, 425, 109, 15);
		frame.getContentPane().add(name3);
		
		name4 = new JLabel("...");
		name4.setBounds(134, 452, 109, 15);
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
		lblNewLabel.setBounds(165, 64, 691, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Click on each to select or view extra information");
		lblNewLabel_1.setBounds(304, 113, 327, 16);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
