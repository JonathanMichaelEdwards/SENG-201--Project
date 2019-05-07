import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JCheckBox;



public class CrewSelection {

	private JFrame frame;
	private JTextField txtCharacterSelectionYou;
	private JTextField txtClickOnEach;
	private JTextField textField;
	
	private ArrayList<String> crew = new ArrayList<String>();
	
	
	private void checkSoldier() 
	{
		final JCheckBox selectSoldier = new JCheckBox("select");
		selectSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (selectSoldier.isSelected()) {
					crew.add("Soldier");
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
		
		JLabel lblClassType = new JLabel("1. class type (VARIABLE) : name (VARIABLE)");
		lblClassType.setBounds(86, 372, 513, 15);
		frame.getContentPane().add(lblClassType);
		
		JLabel lblClassType_1 = new JLabel("2. class type (VARIABLE) : name (VARIABLE)");
		lblClassType_1.setBounds(86, 399, 513, 15);
		frame.getContentPane().add(lblClassType_1);
		
		JLabel lblClassType_2 = new JLabel("3. class type (VARIABLE) : name (VARIABLE)");
		lblClassType_2.setBounds(86, 426, 513, 15);
		frame.getContentPane().add(lblClassType_2);
		
		JLabel lblClassType_3 = new JLabel("4. class type (VARIABLE) : name (VARIABLE)");
		lblClassType_3.setBounds(86, 453, 513, 15);
		frame.getContentPane().add(lblClassType_3);
		
		
		
		selectedPlayers();
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(crew);
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
	}
}
