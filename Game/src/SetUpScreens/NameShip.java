package SetUpScreens;

// Library imports
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

// Self implemented
import WindowSettings.Display;
import MainScreen.MainScreen;
import IOFile.IOFile;


public class NameShip {

	public JFrame frame;
	
	private JTextField txtShipsName;
	private JLabel lblShipChosen;
	private JLabel lblNameOfShip;
	private JLabel lblPieces;
	
	// Setting up radio buttons that are being selected
	private JRadioButton rdbtnRepairShip, rdbtnAttackShip, rdbtnInvisibleShip, rdbtnStorageShip, rdbtnMedicalShip;
	
	private JButton btnStart;
	
	// Members chosen  with there name stored
	private JLabel lblMember1, lblMember2, lblMember3, lblMember4;
	private JLabel lblName1, lblName2, lblName3, lblName4; 
	
	// Stored list of crewType members chosen, there names and the number of pieces to collect
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewNames = new ArrayList<String>();
	private String shipType = "";
	private String shipName = "";
	
	
	
	//	Storing info for next screen
	private void crewInfo(ArrayList<String> type, ArrayList<String> name, int index)
	{
		crewType.add(type.get(index));
		crewNames.add(name.get(index));
	}
	
	
	// Retrieve data from previous screen
	public void getCrewInfo(ArrayList<String> type, ArrayList<String> name)
	{
		IOFile ioFile = new IOFile();
		
		// Displaying info collected info
		for (int index = 0; index < type.size(); index++) {
			if (index == 0) { 
				lblMember1.setText("1. " + type.get(index)); 
				lblName1.setText(name.get(index)); 
				// Store info
				crewInfo(type, name, index);
			} else if (index == 1) { 
				lblMember2.setText("2. " + type.get(index)); 
				lblName2.setText(name.get(index)); 
				// Store info
				crewInfo(type, name, index);
			} else if (index == 2) { 
				lblMember3.setText("3. " + type.get(index)); 
				lblName3.setText(name.get(index)); 
				crewInfo(type, name, index);
				// Store info
			} else if (index == 3) { 
				lblMember4.setText("4. " + type.get(index)); 
				lblName4.setText(name.get(index)); 
				// Store info
				crewInfo(type, name, index);
			}
		}

		// Storing number of pieces needed to be collected
		ArrayList<String> shipInfo = ioFile.fileRead("StoreGame/DaysInfo.txt");
		
		lblPieces.setText(shipInfo.get(1));
	}
	

	// Different type of ships that can be chosen
	private void repairShip()
	{
		rdbtnRepairShip = new JRadioButton("Repair Ship");
		rdbtnRepairShip.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Clear then set button
				rdbtnClear();
				rdbtnRepairShip.setSelected(true);
			}
		});
		rdbtnRepairShip.setActionCommand("Repair");
		rdbtnRepairShip.setBounds(244, 197, 144, 23);
		frame.getContentPane().add(rdbtnRepairShip);
	}
	
	private void attackShip()
	{
		rdbtnAttackShip = new JRadioButton("Attack Ship");
		rdbtnAttackShip.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Clear then set button
				rdbtnClear();
				rdbtnAttackShip.setSelected(true);
			}
		});
		rdbtnAttackShip.setActionCommand("Attack");
		rdbtnAttackShip.setBounds(244, 231, 144, 23);
		frame.getContentPane().add(rdbtnAttackShip);
	}

	private void invisibleShip()
	{
		rdbtnInvisibleShip = new JRadioButton("Invisible Ship");
		rdbtnInvisibleShip.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Clear then set button
				rdbtnClear();
				rdbtnInvisibleShip.setSelected(true);
			}
		});
		rdbtnInvisibleShip.setActionCommand("Invisible");
		rdbtnInvisibleShip.setBounds(244, 266, 144, 23);
		frame.getContentPane().add(rdbtnInvisibleShip);
	}
	
	private void storageShip()
	{
		rdbtnStorageShip = new JRadioButton("Storage Ship");
		rdbtnStorageShip.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Clear then set button
				rdbtnClear();
				rdbtnStorageShip.setSelected(true);
			}
		});
		rdbtnStorageShip.setActionCommand("Storage");
		rdbtnStorageShip.setBounds(244, 306, 144, 23);
		frame.getContentPane().add(rdbtnStorageShip);
	}
	
	private void medicShip()
	{
		rdbtnMedicalShip = new JRadioButton("Medical Ship");
		rdbtnMedicalShip.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// Clear then set button
				rdbtnClear();
				rdbtnMedicalShip.setSelected(true);
			}
		});
		rdbtnMedicalShip.setActionCommand("Medical");
		rdbtnMedicalShip.setBounds(244, 344, 144, 23);
		frame.getContentPane().add(rdbtnMedicalShip);
	}

	// The different range of ship choices
	private void shipChoices()
	{
		repairShip();
		attackShip();
		invisibleShip();
		storageShip();
		medicShip();
	}
	
	
	// Displays the ship the user selected and stores the output
	private void setShips()
	{
	    // Set your ship
	    JButton btnSetYourShips = new JButton("Set your ship's name");
	    btnSetYourShips.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (txtShipsName.getText().equals("")) JOptionPane.showMessageDialog(null, "Please enter the fields");  // displays error if not inputed or selected
	    		else if (rdbtnRepairShip.isSelected()) {
	    			lblShipChosen.setText("Repair");
	    			lblNameOfShip.setText(txtShipsName.getText());
	    			// Store ship info
	    			shipType = "Repair";
	    		} else if (rdbtnAttackShip.isSelected()) {
	    			lblShipChosen.setText("Attack");
	    			lblNameOfShip.setText(txtShipsName.getText());
	    			// Store ship info
	    			shipType = "Attack";
	    		} else if (rdbtnInvisibleShip.isSelected()) {
	    			lblShipChosen.setText("Invisible");
	    			lblNameOfShip.setText(txtShipsName.getText());
	    			// Store ship info
	    			shipType = "Invisible";
	    		} else if (rdbtnStorageShip.isSelected()) {
	    			lblShipChosen.setText("Storage");
	    			lblNameOfShip.setText(txtShipsName.getText());
	    			// Store ship info
	    			shipType = "Storage";
	    		} else if (rdbtnMedicalShip.isSelected()) {
	    			lblShipChosen.setText("Medical");
	    			lblNameOfShip.setText(txtShipsName.getText());
	    			// Store ship info
	    			shipType = "Medical";
	    		}

	    		// If both have been filled in, enable button 
	    		if (!lblShipChosen.getText().equals("...") && !lblNameOfShip.getText().equals("...")) 
	    			btnStart.setEnabled(true);
	    			
	    		// Store the names that are displayed
	    		shipType = lblShipChosen.getText();
	    		shipName = lblNameOfShip.getText();
	    		
	    		// Clear the field
	    		txtShipsName.setText("");
	    	}
	    });
	    btnSetYourShips.setBounds(560, 305, 218, 45);
	    frame.getContentPane().add(btnSetYourShips);
	}
	
	
	// Refreshing the radio button for the last pushed state
	private void rdbtnClear()
	{
		rdbtnRepairShip.setSelected(false);
		rdbtnAttackShip.setSelected(false);
		rdbtnInvisibleShip.setSelected(false);
		rdbtnStorageShip.setSelected(false);
		rdbtnMedicalShip.setSelected(false);
	}
	
	
	private void storeInfo()
	{
		// Store information in files
		IOFile ioFile = new IOFile();
		ArrayList<String> storeCrew = new ArrayList<String>();
		ArrayList<String> storeShip = new ArrayList<String>();
		ArrayList<String> storeCash = new ArrayList<String>();
		ArrayList<String> inventory = new ArrayList<String>();
		
		ArrayList<String> memberActions1 = new ArrayList<String>();
		ArrayList<String> memberActions2 = new ArrayList<String>();
		ArrayList<String> memberActions3 = new ArrayList<String>();
		ArrayList<String> memberActions4 = new ArrayList<String>();
		
		storeCrew.addAll(crewType);
		storeCrew.addAll(crewNames);
		
		storeShip.add(shipType);
		storeShip.add(shipName);
		
		storeShip.add("75");
		
		storeCash.add("200");
		
		inventory.add("Bandages");
		inventory.add("Bandages");
		inventory.add("Bandages");
		inventory.add("Bandages");
		inventory.add("Cookie");
		inventory.add("Cookie");
		inventory.add("Cookie");
		inventory.add("Cookie");
		
		ioFile.fileWrite(storeCrew, "StoreGame/CrewInfo.txt");
		ioFile.fileWrite(storeShip, "StoreGame/ShipInfo.txt");
		ioFile.fileWrite(storeCash, "StoreGame/CashInfo.txt");
<<<<<<< HEAD
		ioFile.fileWrite(inventory, "StoreGame/Inventory/Storage.txt");
=======
		
		for (int index = 0; index < crewType.size(); index++) {
			if (index == 0) {
				memberActions1 = ioFile.fileRead("StoreGame/CrewRatings/"+  crewType.get(0) + ".txt");
				memberActions1.add("2");
				ioFile.fileWrite(memberActions1, "StoreGame/CrewSelected/MemberOne.txt");
			} else if (index == 1) {
				memberActions2 = ioFile.fileRead("StoreGame/CrewRatings/"+  crewType.get(1) + ".txt");
				memberActions2.add("2");
				ioFile.fileWrite(memberActions2, "StoreGame/CrewSelected/MemberTwo.txt");
			} else if (index == 2) {
				memberActions3 = ioFile.fileRead("StoreGame/CrewRatings/"+  crewType.get(2) + ".txt");
				memberActions3.add("2");
				ioFile.fileWrite(memberActions3, "StoreGame/CrewSelected/MemberThree.txt");
			} else if (index == 3) {
				memberActions4 = ioFile.fileRead("StoreGame/CrewRatings/"+  crewType.get(3) + ".txt");
				memberActions4.add("2");
				ioFile.fileWrite(memberActions4, "StoreGame/CrewSelected/MemberFour.txt");
			}
		}
>>>>>>> master
	}
	
	// Go to game screen if all fields are completed
	private void startGameButton()
	{
		// if fields are complete, start game 
		btnStart = new JButton("Start game");
		btnStart.setEnabled(false);
		btnStart.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// if fields arn't completed, display error
				if (lblShipChosen.getText().equals("...") || lblNameOfShip.getText().equals("...")) 
					JOptionPane.showMessageDialog(null, "Please fill in the required fields");
				else {
					storeInfo();  // Store information in files
					
					// move to the main screen
					// Setting a new frame
					MainScreen mainScreen = new MainScreen();
					mainScreen.frame.setVisible(true);  // turn on screen
					frame.setVisible(false);            // turn off screen
				}
			}
		});
		btnStart.setBounds(618, 374, 125, 77);
		frame.getContentPane().add(btnStart);
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
		
		JLabel lblName = new JLabel("Please enter the name of your ship:");
		lblName.setBounds(464, 216, 257, 15);
		frame.getContentPane().add(lblName);
		
	
		// Button Actions
		shipChoices();
		setShips();
		startGameButton();
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
