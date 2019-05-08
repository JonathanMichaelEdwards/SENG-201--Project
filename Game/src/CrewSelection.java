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
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;




public class CrewSelection {

	private JFrame frame;
	private JTextField txtCharacterSelectionYou;
	private JTextField txtClickOnEach;
	private JTextField textField;
	
	JLabel lblMember1;
	JLabel lblMember2;
	JLabel lblMember3;
	JLabel lblMember4;
	
	@SuppressWarnings("rawtypes")
	JComboBox comboBoxSoldier;
	
	private ArrayList<String> crew = new ArrayList<String>();
	
	
	private void checkSoldier() 
	{
		final JCheckBox selectSoldier = new JCheckBox("select");
		selectSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectSoldier.isSelected()) {
					crew.add("Soldier");
					
					System.out.println(comboBoxSoldier.getSelectedItem());
				} else {
					crew.remove("Soldier");
				}
			}
		});
		selectSoldier.setBounds(25, 259, 126, 23);
		frame.getContentPane().add(selectSoldier);
	}
	
	
	private void checkMedic() 
	{
		final JCheckBox selectMedic = new JCheckBox("select");
		selectMedic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectMedic.isSelected()) {
					crew.add("Medic");
				} else {
					crew.remove("Medic");
				}
			}
		});
		selectMedic.setBounds(157, 259, 126, 23);
		frame.getContentPane().add(selectMedic);
	}
	
	
	private void checkLeader() 
	{
		final JCheckBox selectLeader = new JCheckBox("select");
		selectLeader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectLeader.isSelected()) {
					crew.add("Leader");
				} else {
					crew.remove("Leader");
				}
			}
		});
		selectLeader.setBounds(300, 259, 126, 23);
		frame.getContentPane().add(selectLeader);
	}
	
	
	private void checkMechanic() 
	{
		final JCheckBox selectMechanic = new JCheckBox("select");
		selectMechanic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectMechanic.isSelected()) {
					crew.add("Mechanic");
				} else {
					crew.remove("Mechanic");
				}
			}
		});
		selectMechanic.setBounds(448, 259, 126, 23);
		frame.getContentPane().add(selectMechanic);
	}
	
	
	private void checkPilot() 
	{
		final JCheckBox selectPilot = new JCheckBox("select");
		selectPilot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectPilot.isSelected()) {
					crew.add("Pilot");
				} else {
					crew.remove("Pilot");
				}
			}
		});
		selectPilot.setBounds(583, 259, 126, 23);
		frame.getContentPane().add(selectPilot);
	}
	
	
	private void checkThief() 
	{
		final JCheckBox selectThief = new JCheckBox("select");
		selectThief.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectThief.isSelected()) {
					crew.add("Thief");
				} else {
					crew.remove("Thief");
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
		
		textField = new JTextField();
		textField.setBounds(261, 340, 227, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEntername = new JLabel("Enter Name:");
		lblEntername.setBounds(146, 342, 97, 15);
		frame.getContentPane().add(lblEntername);
		
		
		
		
		lblMember1 = new JLabel("1. class type (VARIABLE) : name (VARIABLE)");

		lblMember1.setBounds(86, 372, 513, 15);
		frame.getContentPane().add(lblMember1);
		
		lblMember2 = new JLabel("2. class type (VARIABLE) : name (VARIABLE)");
		lblMember2.setBounds(86, 399, 513, 15);
		frame.getContentPane().add(lblMember2);
		
		lblMember3 = new JLabel("3. class type (VARIABLE) : name (VARIABLE)");
		lblMember3.setBounds(86, 426, 513, 15);
		frame.getContentPane().add(lblMember3);
		
		lblMember4 = new JLabel("4. class type (VARIABLE) : name (VARIABLE)");
		lblMember4.setBounds(86, 453, 513, 15);
		frame.getContentPane().add(lblMember4);
		
		
		
		selectedPlayers();
		
		
		
		
		JButton btnAccept = new JButton("Accept");
		
		btnAccept.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				if ((crew.size() > 4) || (crew.size() < 2)) {
					JOptionPane.showMessageDialog(null, "Please select 2 to 4 crew members only");
				} else {
					for (int i = 0; i < crew.size(); i++) {
						// Refresh labels
						lblMember1.setText("");
						lblMember2.setText("");
						lblMember3.setText("");
						lblMember4.setText("");
						
						try { 
							// Add Members that are chosen
							lblMember1.setText(crew.get(0).toString());
							lblMember2.setText(crew.get(1).toString());
							lblMember3.setText(crew.get(2).toString());
							lblMember4.setText(crew.get(3).toString());
						} catch (Exception e) {
							continue; // continue if list is greater
						}
					}
					
				}
			}
		});
		
		btnAccept.setBounds(515, 337, 114, 25);
		frame.getContentPane().add(btnAccept);
		
		

		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancel.setBounds(672, 332, 114, 25);
		frame.getContentPane().add(btnCancel);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(720, 448, 114, 25);
		frame.getContentPane().add(btnNext);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(588, 448, 114, 25);
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
		comboBoxSoldier.setToolTipText("");
		comboBoxSoldier.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1", "x2", "x3", "x4"}));
		comboBoxSoldier.setMaximumRowCount(4);
		comboBoxSoldier.setBounds(35, 282, 72, 36);
		frame.getContentPane().add(comboBoxSoldier);
		
		
		JComboBox comboBoxMedic = new JComboBox();
		comboBoxMedic.setToolTipText("");
		comboBoxMedic.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1", "x2", "x3", "x4"}));
		comboBoxMedic.setSelectedIndex(0);
		comboBoxMedic.setMaximumRowCount(4);
		comboBoxMedic.setBounds(171, 282, 72, 36);
		frame.getContentPane().add(comboBoxMedic);
		
		JComboBox comboBoxLeader = new JComboBox();
		comboBoxLeader.setToolTipText("");
		comboBoxLeader.setModel(new DefaultComboBoxModel(new String[] {"0x", "x1", "x2", "x3", "x4"}));
		comboBoxLeader.setSelectedIndex(0);
		comboBoxLeader.setMaximumRowCount(4);
		comboBoxLeader.setBounds(310, 282, 72, 36);
		frame.getContentPane().add(comboBoxLeader);
		
		JComboBox<Object> comboBoxMechanic = new JComboBox<Object>();
		comboBoxMechanic.setToolTipText("");
		comboBoxMechanic.setModel(new DefaultComboBoxModel(new String[] {"0x", "x1", "x2", "x3", "x4"}));
		comboBoxMechanic.setSelectedIndex(0);
		comboBoxMechanic.setMaximumRowCount(4);
		comboBoxMechanic.setBounds(448, 282, 72, 36);
		frame.getContentPane().add(comboBoxMechanic);
		
		JComboBox comboBoxPilot = new JComboBox();
		comboBoxPilot.setToolTipText("");
		comboBoxPilot.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1", "x2", "x3", "x4"}));
		comboBoxPilot.setSelectedIndex(0);
		comboBoxPilot.setMaximumRowCount(4);
		comboBoxPilot.setBounds(577, 282, 72, 36);
		frame.getContentPane().add(comboBoxPilot);
		
		JComboBox comboBoxThief = new JComboBox();
		comboBoxThief.setToolTipText("");
		comboBoxThief.setModel(new DefaultComboBoxModel(new String[] {"0x", "x1", "x2", "x3", "x4"}));
		comboBoxThief.setSelectedIndex(0);
		comboBoxThief.setMaximumRowCount(4);
		comboBoxThief.setBounds(722, 282, 72, 41);
		frame.getContentPane().add(comboBoxThief);
	}
}
