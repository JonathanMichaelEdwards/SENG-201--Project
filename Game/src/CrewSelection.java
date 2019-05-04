import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrewSelection {

	private JFrame frame;
	private JTextField txtCharacterSelectionYou;
	private JTextField txtClickOnEach;
	private JTextField textField;

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
		
		JButton btnSoldier = new JButton("Soldier");
		btnSoldier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSoldier.setBounds(25, 90, 123, 161);
		frame.getContentPane().add(btnSoldier);
		
		JButton btnMedic = new JButton("medic");
		btnMedic.setBounds(160, 90, 123, 161);
		frame.getContentPane().add(btnMedic);
		
		JButton btnLeader = new JButton("Leader");
		btnLeader.setBounds(303, 90, 123, 161);
		frame.getContentPane().add(btnLeader);
		
		JButton btnMechanic = new JButton("Mechanic");
		btnMechanic.setBounds(448, 90, 123, 161);
		frame.getContentPane().add(btnMechanic);
		
		JButton btnPilot = new JButton("Pilot");
		btnPilot.setBounds(583, 90, 123, 161);
		frame.getContentPane().add(btnPilot);
		
		JButton btnThief = new JButton("Thief");
		btnThief.setBounds(730, 90, 123, 161);
		frame.getContentPane().add(btnThief);
		
		txtClickOnEach = new JTextField();
		txtClickOnEach.setText("Click on each to select or view extra information");
		txtClickOnEach.setBounds(217, 59, 308, 19);
		frame.getContentPane().add(txtClickOnEach);
		txtClickOnEach.setColumns(10);
		
		JLabel lblCurrentTeam = new JLabel("Current Team");
		lblCurrentTeam.setBounds(25, 333, 109, 15);
		frame.getContentPane().add(lblCurrentTeam);
		
		textField = new JTextField();
		textField.setBounds(259, 282, 227, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEntername = new JLabel("Enter Name:");
		lblEntername.setBounds(148, 284, 97, 15);
		frame.getContentPane().add(lblEntername);
		
		JLabel lblClassType = new JLabel("1. class type (VARIABLE) : name (VARIABLE)");
		lblClassType.setBounds(153, 372, 513, 15);
		frame.getContentPane().add(lblClassType);
		
		JLabel lblClassType_1 = new JLabel("2. class type (VARIABLE) : name (VARIABLE)");
		lblClassType_1.setBounds(153, 399, 513, 15);
		frame.getContentPane().add(lblClassType_1);
		
		JLabel lblClassType_2 = new JLabel("3. class type (VARIABLE) : name (VARIABLE)");
		lblClassType_2.setBounds(153, 426, 513, 15);
		frame.getContentPane().add(lblClassType_2);
		
		JLabel lblClassType_3 = new JLabel("4. class type (VARIABLE) : name (VARIABLE)");
		lblClassType_3.setBounds(153, 453, 513, 15);
		frame.getContentPane().add(lblClassType_3);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(514, 279, 114, 25);
		frame.getContentPane().add(btnAccept);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(655, 279, 114, 25);
		frame.getContentPane().add(btnCancel);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(720, 448, 114, 25);
		frame.getContentPane().add(btnNext);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(588, 448, 114, 25);
		frame.getContentPane().add(btnBack);
	}
}
