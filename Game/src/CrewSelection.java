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
	private JTextField txtCharacterSelectionYou;
	private JTextField txtClickOnEach;
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
	
	int countSoldier, countMedic, countLeader, countMechanic, countPilot, countThief = 0, countNames = 0;;  // initial value
	
	

	// Stored list of crewType members and there names
	public ArrayList<String> crewType = new ArrayList<String>();
	public ArrayList<String> crewNames = new ArrayList<String>();
	
	
	
	private JLabel name1;
	private JLabel name2;
	private JLabel name3;
	private JLabel name4;
	private JProgressBar progressBar;
	private JLabel label;
	
	
	private void checkSoldier() 
	{
		selectSoldier = new JCheckBox("select");
		selectSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectSoldier.isSelected()) {
					comboBoxSoldier.setVisible(true);
				} else {
					// removing Soldier from list if deselected
					for (int i = 0; i < countSoldier; i++)
						crewType.remove("Soldier");
					
					comboBoxSoldier.setVisible(false);
					comboBoxSoldier.setSelectedIndex(0);
				}
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
				if (selectMedic.isSelected()) {
//					crewType.add("Medic");
					comboBoxMedic.setVisible(true);
				} else {
					// removing Soldier from list if deselected
					for (int i = 0; i < countMedic; i++)
						crewType.remove("Medic");
					comboBoxMedic.setVisible(false);
					comboBoxMedic.setSelectedIndex(0);
				}
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
				if (selectLeader.isSelected()) {
//					crewType.add("Leader");
					comboBoxLeader.setVisible(true);
				} else {
					// removing Soldier from list if deselected
					for (int i = 0; i < countLeader; i++)
						crewType.remove("Leader");
					comboBoxLeader.setVisible(false);
					comboBoxLeader.setSelectedIndex(0);
				}
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
				if (selectMechanic.isSelected()) {
					// removing Soldier from list if deselected
//					crewType.add("Mechanic");
					comboBoxMechanic.setVisible(true);
				} else {
					for (int i = 0; i < countMechanic; i++)
						crewType.remove("Mechanic");
					comboBoxMechanic.setVisible(false);
					comboBoxMechanic.setSelectedIndex(0);
				}
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
				if (selectPilot.isSelected()) {
//					crewType.add("Pilot");
					comboBoxPilot.setVisible(true);
				} else {
					// removing Soldier from list if deselected
					for (int i = 0; i < countPilot; i++)
						crewType.remove("Pilot");
					comboBoxPilot.setVisible(false);
					comboBoxPilot.setSelectedIndex(0);
				}
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
				if (selectThief.isSelected()) {
//					crewType.add("Thief");
					comboBoxThief.setVisible(true);
				} else {
					// removing Soldier from list if deselected
					for (int i = 0; i < countThief; i++)
						crewType.remove("Thief");
					comboBoxThief.setVisible(false);
					comboBoxThief.setSelectedIndex(0);
				}
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
		
		txtCharacterSelectionYou = new JTextField();
		txtCharacterSelectionYou.setText("Character selection, you can choose VARIABLE characters in any combination to form your astronaut team");
		txtCharacterSelectionYou.setBounds(202, 12, 654, 36);
		frame.getContentPane().add(txtCharacterSelectionYou);
		txtCharacterSelectionYou.setColumns(10);
		
		txtClickOnEach = new JTextField();
		txtClickOnEach.setText("Click on each to select or view extra information");
		txtClickOnEach.setBounds(217, 59, 308, 19);
		frame.getContentPane().add(txtClickOnEach);
		txtClickOnEach.setColumns(10);
		
		JLabel lblCurrentTeam = new JLabel("Current Team");
		lblCurrentTeam.setBounds(25, 342, 109, 15);
		frame.getContentPane().add(lblCurrentTeam);
		
		txtFdName = new JTextField();
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
		JButton btnAcceptChars = new JButton("Accept Characters");
		
		btnAcceptChars.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if ((crewType.size() > 4) || (crewType.size() < 2)) {
					JOptionPane.showMessageDialog(null, "Please select 2 to 4 crewType members only");
				} else {
					for (int i = 0; i < crewType.size(); i++) {
						
						// Refresh labels and boxes
						name1.setText("...");
						name2.setText("...");
						name3.setText("...");
						name4.setText("...");
						
						comBoxCharChosen.removeAllItems();
						
						for (int index = 0; index < crewNames.size(); index++)
							crewNames.remove(index);
						
						lblMember1.setText("...");
						lblMember2.setText("...");
						lblMember3.setText("...");
						lblMember4.setText("...");
						try { 
							// Add Members that are chosen
							for (int j = 0; j < crewType.size(); j++)
								comBoxCharChosen.addItem(j+1 + ": " + crewType.get(j));
								
							lblMember1.setText(1 + ": " + crewType.get(0).toString());
							lblMember2.setText(2 + ": " + crewType.get(1).toString());
							lblMember3.setText(3 + ": " + crewType.get(2).toString());
							lblMember4.setText(4 + ": " + crewType.get(3).toString());
						} catch (Exception e) {
							continue; // continue if list is greater
						}
					}
					
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
				if ((crewNames.size() == 0) || (crewType.size() == 0)) JOptionPane.showMessageDialog(null, "Please complete the fields");  
				else if (crewNames.size() == crewType.size()) {
					// Setting a new frame
					NameShip nameShip = new NameShip();
					nameShip.frame.setVisible(true);  // turn on screen
					frame.setVisible(false);   // turn off screen
				} else JOptionPane.showMessageDialog(null, "Please complete the fields");  // Error message
			}
		});
		btnNext.setBounds(742, 438, 136, 47);
		frame.getContentPane().add(btnNext);
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Setting a new frame
				ChooseDays choseDays = new ChooseDays();
				choseDays.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);         // turn off screen
			}
		});
		btnBack.setBounds(583, 438, 126, 47);
		frame.getContentPane().add(btnBack);
		
		
		
		
		
		
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
				String removeX = (String) comboBoxSoldier.getSelectedItem();  // get the item
				
				if (selectSoldier.isSelected()) { // check if selected
					// remove the old amount to the list
					for (int i = 0; i < countSoldier; i++) // countSoldier-1 because we added one when we selected the checkbox
						crewType.remove("Soldier");
					
					// added the new amount to the list
					countSoldier = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string to int)
					for (int i = 0; i < countSoldier; i++)
						crewType.add("Soldier");
				}
			}
		});
		comboBoxSoldier.setVisible(false);
		comboBoxSoldier.setToolTipText("");
		comboBoxSoldier.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4"}));
		comboBoxSoldier.setSelectedIndex(0);
		comboBoxSoldier.setMaximumRowCount(4);
		comboBoxSoldier.setBounds(35, 282, 72, 36);
		frame.getContentPane().add(comboBoxSoldier);
		
		
		comboBoxMedic = new JComboBox();
		comboBoxMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String removeX = (String) comboBoxMedic.getSelectedItem();  // get the item
				
				if (selectMedic.isSelected()) { // check if selected
					// remove the old amount to the list
					for (int i = 0; i < countMedic; i++) // countSoldier-1 because we added one when we selected the checkbox
						crewType.remove("Medic");
					
					// added the new amount to the list
					countMedic = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string to int)
					for (int i = 0; i < countMedic; i++)
						crewType.add("Medic");
				}
			}
		});
		comboBoxMedic.setToolTipText("");
		comboBoxMedic.setVisible(false);
		comboBoxMedic.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4"}));
		comboBoxMedic.setSelectedIndex(0);
		comboBoxMedic.setMaximumRowCount(4);
		comboBoxMedic.setBounds(171, 282, 72, 36);
		frame.getContentPane().add(comboBoxMedic);
		
		
		
		comboBoxLeader = new JComboBox();
		comboBoxLeader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String removeX = (String) comboBoxLeader.getSelectedItem();  // get the item in the combo box
				
				if (selectLeader.isSelected()) { // check if selected
					// remove the old amount to the list
					for (int i = 0; i < countLeader; i++) // countSoldier-1 because we added one when we selected the checkbox
						crewType.remove("Leader");
					
					// added the new amount to the list
					countLeader = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string -> int)
					for (int i = 0; i < countLeader; i++)
						crewType.add("Leader");
				}
			}
		});
		comboBoxLeader.setToolTipText("");
		comboBoxLeader.setVisible(false);
		comboBoxLeader.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4"}));
		comboBoxLeader.setSelectedIndex(0);
		comboBoxLeader.setMaximumRowCount(4);
		comboBoxLeader.setBounds(310, 282, 72, 36);
		frame.getContentPane().add(comboBoxLeader);
		
		
		
		comboBoxMechanic = new JComboBox<Object>();
		comboBoxMechanic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String removeX = (String) comboBoxMechanic.getSelectedItem();  // get the item
				
				if (selectMechanic.isSelected()) { // check if selected
					// remove the old amount to the list
					for (int i = 0; i < countMechanic; i++) // countSoldier-1 because we added one when we selected the checkbox
						crewType.remove("Mechanic");
					
					// added the new amount to the list
					countMechanic = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string -> int)
					for (int i = 0; i < countMechanic; i++)
						crewType.add("Mechanic");
				}
			}
		});
		comboBoxMechanic.setToolTipText("");
		comboBoxMechanic.setVisible(false);
		comboBoxMechanic.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4"}));
		comboBoxMechanic.setSelectedIndex(0);
		comboBoxMechanic.setMaximumRowCount(4);
		comboBoxMechanic.setBounds(448, 282, 72, 36);
		frame.getContentPane().add(comboBoxMechanic);
		
		
		
		comboBoxPilot = new JComboBox();
		comboBoxPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String removeX = (String) comboBoxPilot.getSelectedItem();  // get the item
				
				if (selectPilot.isSelected()) { // check if selected
					// remove the old amount to the list
					for (int i = 0; i < countPilot; i++) // countSoldier-1 because we added one when we selected the checkbox
						crewType.remove("Pilot");
					
					// added the new amount to the list
					countPilot = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string -> int)
					for (int i = 0; i < countPilot; i++)
						crewType.add("Pilot");
				}
			}
		});
		comboBoxPilot.setToolTipText("");
		comboBoxPilot.setVisible(false);
		comboBoxPilot.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4"}));
		comboBoxPilot.setSelectedIndex(0);
		comboBoxPilot.setMaximumRowCount(4);
		comboBoxPilot.setBounds(577, 282, 72, 36);
		frame.getContentPane().add(comboBoxPilot);
		
		
		
		comboBoxThief = new JComboBox();
		comboBoxThief.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String removeX = (String) comboBoxThief.getSelectedItem();  // get the item
				
				if (selectThief.isSelected()) { // check if selected
					// remove the old amount to the list
					for (int i = 0; i < countThief; i++) // countSoldier-1 because we added one when we selected the checkbox
						crewType.remove("Thief");
					
					// added the new amount to the list
					countThief = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string -> int)
					for (int i = 0; i < countThief; i++)
						crewType.add("Thief");
				}
			}
		});
		comboBoxThief.setToolTipText("");
		comboBoxThief.setVisible(false);
		comboBoxThief.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4"}));
		comboBoxThief.setSelectedIndex(0);
		comboBoxThief.setMaximumRowCount(4);
		comboBoxThief.setBounds(722, 282, 72, 41);
		frame.getContentPane().add(comboBoxThief);
		
		JLabel lblPleaseInputA = new JLabel("Please input a name for:\n");
		lblPleaseInputA.setBounds(300, 330, 157, 15);
		frame.getContentPane().add(lblPleaseInputA);
		
		comBoxCharChosen = new JComboBox();
		comBoxCharChosen.setBounds(300, 360, 142, 27);
		frame.getContentPane().add(comBoxCharChosen);
		
		
		

		
		
		JButton btnAcceptName = new JButton("Accept Name");
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
		
				// clear & reset
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
		
		
	}
}
