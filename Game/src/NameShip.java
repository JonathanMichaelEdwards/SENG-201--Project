import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;



public class NameShip {

	public JFrame frame;
	private JTextField txtShipsName;
	
	JRadioButton rdbtnRepairShip;
	JRadioButton rdbtnAttackShip;
	JRadioButton rdbtnInvisibleShip;
	JRadioButton rdbtnStorageShip;
	JRadioButton rdbtnMedicalShip;
	
	JLabel lblShipChosen;
	JLabel lblNameOfShip;
	JLabel lblPieces;
	
	JLabel lblMember1;
	JLabel lblMember2;
	JLabel lblMember3;
	JLabel lblMember4;
	
	JLabel lblName1;
	JLabel lblName2;
	JLabel lblName3;
	JLabel lblName4;
	
	// Stored list of crewType members and there names
	public ArrayList<String> crewType = new ArrayList<String>();
	public ArrayList<String> crewName = new ArrayList<String>();
	int piecesToCollect = 2;  // default value
	
	
	// Retrieve data from selection
	void getCrewInfo(ArrayList<String> crewType, ArrayList<String> crewName, int pieces)
	{
		for (int index = 0; index < crewType.size(); index++) {
			if (index == 0) { lblMember1.setText("1. " + crewType.get(0)); lblName1.setText(crewName.get(0)); }
			else if (index == 1) { lblMember2.setText("2. " + crewType.get(1)); lblName2.setText(crewName.get(1)); }
			else if (index == 2) { lblMember3.setText("3. " + crewType.get(2)); lblName3.setText(crewName.get(2)); }
			else if (index == 3) { lblMember4.setText("4. " + crewType.get(3)); lblName4.setText(crewName.get(3)); }
		}
		
		piecesToCollect = pieces;
		lblPieces.setText("" + pieces);
	}
	
	
	
	void SetInfo()
	{
		ChooseDays chooseDays = new ChooseDays();
		CrewSelection crewSelect = new CrewSelection();
		
		// Display Pieces
		lblPieces.setText("" + chooseDays.piecesToCollect);
		
		// Go through how many players were selected
		for (int index = 0; index < crewSelect.crewType.size(); index++) {
			// Display crew members and names
			if (index == 0) {
				lblMember1.setText(crewSelect.crewType.get(index));
				lblName1.setText(crewSelect.crewNames.get(index));
			} else if (index == 1) {
				lblMember2.setText(crewSelect.crewType.get(index));
				lblName2.setText(crewSelect.crewNames.get(index));
			} else if (index == 2) {
				lblMember3.setText(crewSelect.crewType.get(index));
				lblName3.setText(crewSelect.crewNames.get(index));
			} else if (index == 3) {
				lblMember4.setText(crewSelect.crewType.get(index));
				lblName4.setText(crewSelect.crewNames.get(index));
			}
		}
		
	}
	
	
	
	void rdbtnClear()
	{
		rdbtnRepairShip.setSelected(false);
		rdbtnAttackShip.setSelected(false);
		rdbtnInvisibleShip.setSelected(false);
		rdbtnStorageShip.setSelected(false);
		rdbtnMedicalShip.setSelected(false);
	}
	
	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{
//		SetInfo();   // Fix Function
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 869, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNameYourShip = new JLabel("Choose & Name Your ship");
		lblNameYourShip.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNameYourShip.setBounds(223, 12, 430, 107);
		frame.getContentPane().add(lblNameYourShip);
		
		txtShipsName = new JTextField();
		txtShipsName.setBounds(504, 246, 186, 31);
		frame.getContentPane().add(txtShipsName);
		txtShipsName.setColumns(10);
		
		JLabel lblShipType = new JLabel("Ship Type");
		lblShipType.setFont(new Font("Dialog", Font.BOLD, 19));
		lblShipType.setBounds(250, 105, 125, 94);
		frame.getContentPane().add(lblShipType);
		
		JLabel lblNameShip = new JLabel("Name Ship");
		lblNameShip.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNameShip.setBounds(560, 126, 134, 94);
		frame.getContentPane().add(lblNameShip);
		
		
		// Buttons
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Setting a new frame
				CrewSelection crewSelect = new CrewSelection();
				crewSelect.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);            // turn off screen
			}
		});
		btnBack.setBounds(504, 374, 125, 77);
		frame.getContentPane().add(btnBack);
		
		
		
		// Buttons
		JButton btnStart = new JButton("Start game");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if fields arn't completed, display error
				if (lblShipChosen.getText().equals("...") || lblNameOfShip.getText().equals("...")) 
					JOptionPane.showMessageDialog(null, "Please fill in the required fields");
				else {
					// move to the main screen
					// Setting a new frame
//					MainScreen mainScreen = new MainScreen();
//					mainScreen.frame.setVisible(true);  // turn on screen
//					frame.setVisible(false);            // turn off screen
				}
			}
		});
		btnStart.setBounds(672, 374, 125, 77);
		frame.getContentPane().add(btnStart);
		
		
		
		
		
		final JLabel lblName = new JLabel("Please enter the name of your ship:");
		lblName.setBounds(464, 216, 257, 15);
		frame.getContentPane().add(lblName);
		
		
		

		rdbtnRepairShip = new JRadioButton("Repair Ship");
		rdbtnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear then set button
				rdbtnClear();
				rdbtnRepairShip.setSelected(true);
			}
		});
		rdbtnRepairShip.setActionCommand("Repair");
		rdbtnRepairShip.setBounds(244, 197, 144, 23);
		frame.getContentPane().add(rdbtnRepairShip);
		
		
		rdbtnAttackShip = new JRadioButton("Attack Ship");
		rdbtnAttackShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear then set button
				rdbtnClear();
				rdbtnAttackShip.setSelected(true);
			}
		});
		rdbtnAttackShip.setActionCommand("Attack");
		rdbtnAttackShip.setBounds(244, 231, 144, 23);
		frame.getContentPane().add(rdbtnAttackShip);
		
		
		rdbtnInvisibleShip = new JRadioButton("Invisible Ship");
		rdbtnInvisibleShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear then set button
				rdbtnClear();
				rdbtnInvisibleShip.setSelected(true);
			}
		});
		rdbtnInvisibleShip.setActionCommand("Invisible");
		rdbtnInvisibleShip.setBounds(244, 266, 144, 23);
		frame.getContentPane().add(rdbtnInvisibleShip);
		
		rdbtnStorageShip = new JRadioButton("Storage Ship");
		rdbtnStorageShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear then set button
				rdbtnClear();
				rdbtnStorageShip.setSelected(true);
			}
		});
		rdbtnStorageShip.setActionCommand("Storage");
		rdbtnStorageShip.setBounds(244, 306, 144, 23);
		frame.getContentPane().add(rdbtnStorageShip);
		
		rdbtnMedicalShip = new JRadioButton("Medical Ship");
		rdbtnMedicalShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear then set button
				rdbtnClear();
				rdbtnMedicalShip.setSelected(true);
			}
		});
		rdbtnMedicalShip.setActionCommand("Medical");
		rdbtnMedicalShip.setBounds(244, 344, 144, 23);
		frame.getContentPane().add(rdbtnMedicalShip);
		
		
	    // Set your ship
	    JButton btnSetYourShips = new JButton("Set your ship's name");
	    btnSetYourShips.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (txtShipsName.getText().equals("")) JOptionPane.showMessageDialog(null, "Please enter the fields");  // displays error if not inputed or selected
	    		else if (rdbtnRepairShip.isSelected()) {
	    			lblShipChosen.setText("Repair");
	    			lblNameOfShip.setText(txtShipsName.getText());
	    		} else if (rdbtnAttackShip.isSelected()) {
	    			lblShipChosen.setText("Attack");
	    			lblNameOfShip.setText(txtShipsName.getText());
	    		} else if (rdbtnInvisibleShip.isSelected()) {
	    			lblShipChosen.setText("Invisible");
	    			lblNameOfShip.setText(txtShipsName.getText());
	    		} else if (rdbtnStorageShip.isSelected()) {
	    			lblShipChosen.setText("Storage");
	    			lblNameOfShip.setText(txtShipsName.getText());
	    		} else if (rdbtnMedicalShip.isSelected()) {
	    			lblShipChosen.setText("Medical");
	    			lblNameOfShip.setText(txtShipsName.getText());
	    		}
	    		
	    		// Clear the field
	    		txtShipsName.setText("");
	    	}
	    });
	    btnSetYourShips.setBounds(560, 305, 218, 45);
	    frame.getContentPane().add(btnSetYourShips);
	    
	    
	    
	    lblShipChosen = new JLabel("...");
	    lblShipChosen.setBounds(75, 393, 212, 15);
	    frame.getContentPane().add(lblShipChosen);
	    
	    lblNameOfShip = new JLabel("...");
	    lblNameOfShip.setBounds(75, 436, 212, 15);
	    frame.getContentPane().add(lblNameOfShip);
	    
	    JLabel lblShipType_1 = new JLabel("Type:");
	    lblShipType_1.setBounds(9, 393, 54, 15);
	    frame.getContentPane().add(lblShipType_1);
	    
	    JLabel lblShipsName = new JLabel("Name:");
	    lblShipsName.setBounds(9, 436, 47, 15);
	    frame.getContentPane().add(lblShipsName);
	    
	    JLabel lblShipStatus = new JLabel("Ship Status");
	    lblShipStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
	    lblShipStatus.setBounds(28, 343, 112, 23);
	    frame.getContentPane().add(lblShipStatus);
	    
	    JLabel label = new JLabel("Setup progress");
	    label.setBounds(28, 12, 116, 18);
	    frame.getContentPane().add(label);
	    
	    JProgressBar progressBar = new JProgressBar();
	    progressBar.setValue(2);
	    progressBar.setStringPainted(true);
	    progressBar.setMaximum(3);
	    progressBar.setBounds(9, 42, 148, 25);
	    frame.getContentPane().add(progressBar);
	   
	    
	    lblMember1 = new JLabel("1. ...");
	    lblMember1.setBounds(12, 198, 109, 15);
	    frame.getContentPane().add(lblMember1);
	    
	    lblMember2 = new JLabel("2. ...");
	    lblMember2.setBounds(12, 225, 117, 15);
	    frame.getContentPane().add(lblMember2);
	    
	    lblMember3 = new JLabel("3. ...");
	    lblMember3.setBounds(12, 252, 117, 15);
	    frame.getContentPane().add(lblMember3);
	    
	    lblMember4 = new JLabel("4. ...");
	    lblMember4.setBounds(12, 279, 117, 15);
	    frame.getContentPane().add(lblMember4);
	    

	    
	    lblName1 = new JLabel("...");
	    lblName1.setBounds(134, 197, 109, 15);
	    frame.getContentPane().add(lblName1);
	    
	    lblName2 = new JLabel("...");
	    lblName2.setBounds(134, 225, 109, 15);
	    frame.getContentPane().add(lblName2);
	    
	    lblName3 = new JLabel("...");
	    lblName3.setBounds(134, 251, 109, 15);
	    frame.getContentPane().add(lblName3);
	    
	    lblName4 = new JLabel("...");
	    lblName4.setBounds(134, 278, 109, 15);
	    frame.getContentPane().add(lblName4);
	    
	    
	    JLabel lblCrewStatus = new JLabel("Crew");
	    lblCrewStatus.setFont(new Font("Dialog", Font.PLAIN, 16));
	    lblCrewStatus.setBounds(66, 142, 74, 23);
	    frame.getContentPane().add(lblCrewStatus);
	    
	    JLabel lblPiecesToCollect = new JLabel("Pieces to Collect");
	    lblPiecesToCollect.setFont(new Font("Dialog", Font.PLAIN, 16));
	    lblPiecesToCollect.setBounds(28, 79, 144, 23);
	    frame.getContentPane().add(lblPiecesToCollect);
	    
	    lblPieces = new JLabel("...");
	    lblPieces.setBounds(67, 105, 54, 15);
	    frame.getContentPane().add(lblPieces);
	    
	    JLabel label_9 = new JLabel("Current Team");
	    label_9.setBounds(12, 171, 109, 15);
	    frame.getContentPane().add(label_9);
	    
	    JLabel label_10 = new JLabel("Names");
	    label_10.setBounds(144, 171, 66, 15);
	    frame.getContentPane().add(label_10);
	}
	
	
	/*
	 * Create the application.
	*/
	public NameShip() 
	{
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
					NameShip window = new NameShip();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
