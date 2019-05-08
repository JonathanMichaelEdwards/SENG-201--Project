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
	
	int countSoldier, countMedic, countLeader, countMechanic, countPilot, countThief = 0;  // initial value
	
	

	private ArrayList<String> crew = new ArrayList<String>();
	private JLabel name1;
	private JLabel name2;
	private JLabel name3;
	private JLabel name4;
	
	
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
						crew.remove("Soldier");
					
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
//					crew.add("Medic");
					comboBoxMedic.setVisible(true);
				} else {
					// removing Soldier from list if deselected
					for (int i = 0; i < countMedic; i++)
						crew.remove("Medic");
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
//					crew.add("Leader");
					comboBoxLeader.setVisible(true);
				} else {
					// removing Soldier from list if deselected
					for (int i = 0; i < countLeader; i++)
						crew.remove("Leader");
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
//					crew.add("Mechanic");
					comboBoxMechanic.setVisible(true);
				} else {
					for (int i = 0; i < countMechanic; i++)
						crew.remove("Mechanic");
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
//					crew.add("Pilot");
					comboBoxPilot.setVisible(true);
				} else {
					// removing Soldier from list if deselected
					for (int i = 0; i < countPilot; i++)
						crew.remove("Pilot");
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
//					crew.add("Thief");
					comboBoxThief.setVisible(true);
				} else {
					// removing Soldier from list if deselected
					for (int i = 0; i < countThief; i++)
						crew.remove("Thief");
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
		txtCharacterSelectionYou.setBounds(48, 12, 654, 36);
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
		lblEntername.setBounds(186, 342, 66, 15);
		frame.getContentPane().add(lblEntername);
		
		
		
		
		lblMember1 = new JLabel("1.");

		lblMember1.setBounds(12, 372, 109, 15);
		frame.getContentPane().add(lblMember1);
		
		lblMember2 = new JLabel("2.");
		lblMember2.setBounds(12, 399, 117, 15);
		frame.getContentPane().add(lblMember2);
		
		lblMember3 = new JLabel("3.");
		lblMember3.setBounds(12, 426, 117, 15);
		frame.getContentPane().add(lblMember3);
		
		lblMember4 = new JLabel("4.");
		lblMember4.setBounds(12, 453, 117, 15);
		frame.getContentPane().add(lblMember4);
		
		
		
		selectedPlayers();
		
		
		
		
		JButton btnAcceptChars = new JButton("Accept Characters");
		
		btnAcceptChars.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				
				

				if ((crew.size() > 4) || (crew.size() < 2)) {
					JOptionPane.showMessageDialog(null, "Please select 2 to 4 crew members only");
				} else {
					for (int i = 0; i < crew.size(); i++) {
						
						// Refresh labels and boxes
						name1.setText("...");
						name2.setText("...");
						name3.setText("...");
						name4.setText("...");
						
						comBoxCharChosen.removeAllItems();
						
						lblMember1.setText("...");
						lblMember2.setText("...");
						lblMember3.setText("...");
						lblMember4.setText("...");
						try { 
							// Add Members that are chosen
							for (int j = 0; j < crew.size(); j++)
								comBoxCharChosen.addItem(j+1 + ": " + crew.get(j));
								
							lblMember1.setText(1 + ": " + crew.get(0).toString());
							lblMember2.setText(2 + ": " + crew.get(1).toString());
							lblMember3.setText(3 + ": " + crew.get(2).toString());
							lblMember4.setText(4 + ": " + crew.get(3).toString());
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
		btnNext.setBounds(742, 438, 136, 47);
		frame.getContentPane().add(btnNext);
		
		JButton btnBack = new JButton("Back");
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
						crew.remove("Soldier");
					
					// added the new amount to the list
					countSoldier = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string to int)
					for (int i = 0; i < countSoldier; i++)
						crew.add("Soldier");
				}
			}
		});
		comboBoxSoldier.setVisible(false);
		comboBoxSoldier.setToolTipText("");
		comboBoxSoldier.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4"}));
		comboBoxSoldier.setSelectedIndex(0);
		comboBoxSoldier.setMaximumRowCount(4);
		comboBoxSoldier.setBounds(35, 282, 72, 48);
		frame.getContentPane().add(comboBoxSoldier);
		
		
		comboBoxMedic = new JComboBox();
		comboBoxMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String removeX = (String) comboBoxMedic.getSelectedItem();  // get the item
				
				if (selectMedic.isSelected()) { // check if selected
					// remove the old amount to the list
					for (int i = 0; i < countMedic; i++) // countSoldier-1 because we added one when we selected the checkbox
						crew.remove("Medic");
					
					// added the new amount to the list
					countMedic = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string to int)
					for (int i = 0; i < countMedic; i++)
						crew.add("Medic");
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
						crew.remove("Leader");
					
					// added the new amount to the list
					countLeader = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string -> int)
					for (int i = 0; i < countLeader; i++)
						crew.add("Leader");
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
						crew.remove("Mechanic");
					
					// added the new amount to the list
					countMechanic = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string -> int)
					for (int i = 0; i < countMechanic; i++)
						crew.add("Mechanic");
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
						crew.remove("Pilot");
					
					// added the new amount to the list
					countPilot = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string -> int)
					for (int i = 0; i < countPilot; i++)
						crew.add("Pilot");
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
						crew.remove("Thief");
					
					// added the new amount to the list
					countThief = Integer.valueOf(removeX.replace("x", ""));  // converting x1 -> 1 (string -> int)
					for (int i = 0; i < countThief; i++)
						crew.add("Thief");
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
				
				if (comBoxCharChosen.getSelectedIndex() == 0) name1.setText(txtFdName.getText());
				else if (comBoxCharChosen.getSelectedIndex() == 1) name2.setText(txtFdName.getText());
				else if (comBoxCharChosen.getSelectedIndex() == 2) name3.setText(txtFdName.getText());
				else if (comBoxCharChosen.getSelectedIndex() == 3) name4.setText(txtFdName.getText());
		
			}
		});
		btnAcceptName.setBounds(314, 409, 157, 59);
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
		
		
	}
}
