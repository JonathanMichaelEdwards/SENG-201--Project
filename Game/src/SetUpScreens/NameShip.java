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
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;


public class NameShip extends CrewSelection
{

	public JFrame frmEliteDangerousBeta;
	
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
	public ArrayList<String> crewType = new ArrayList<String>();
	public ArrayList<String> crewNames = new ArrayList<String>();
	private String shipType = "";
	private String shipName = "";
	private JLabel lblNewLabel;
	
	
	
	//	Storing info for next screen
	protected void crewInfo(ArrayList<String> type, ArrayList<String> name, int index)
	{
		crewType.add(type.get(index));
		crewNames.add(name.get(index));
	}
	
	
	// Retrieve data from previous screen
	protected void getCrewInfo(ArrayList<String> type, ArrayList<String> name)
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
		ArrayList<String> shipInfo = ioFile.fileRead("src/StoreGame/DaysInfo.txt");
		
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
		rdbtnRepairShip.setBounds(716, 250, 144, 23);
		frmEliteDangerousBeta.getContentPane().add(rdbtnRepairShip);
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
		rdbtnAttackShip.setBounds(716, 284, 144, 23);
		frmEliteDangerousBeta.getContentPane().add(rdbtnAttackShip);
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
		rdbtnInvisibleShip.setBounds(716, 319, 144, 23);
		frmEliteDangerousBeta.getContentPane().add(rdbtnInvisibleShip);
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
		rdbtnStorageShip.setBounds(716, 359, 144, 23);
		frmEliteDangerousBeta.getContentPane().add(rdbtnStorageShip);
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
		rdbtnMedicalShip.setBounds(716, 397, 144, 23);
		frmEliteDangerousBeta.getContentPane().add(rdbtnMedicalShip);
	}

	// The different range of ship choices
	protected void shipChoices()
	{
		repairShip();
		attackShip();
		invisibleShip();
		storageShip();
		medicShip();
	}
	
	
	// Displays the ship the user selected and stores the output
	protected void setShips()
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
	    btnSetYourShips.setBounds(904, 352, 250, 30);
	    frmEliteDangerousBeta.getContentPane().add(btnSetYourShips);
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
	
	
	protected void storeInfo()
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
		storeShip.add("false");  //true false for whether we've found this planets piece
		storeShip.add("0");      //counter for how many planets we've been to
		
		storeCash.add("500");
		
		inventory.add("cookie");
		inventory.add("cookie");
		inventory.add("cookie");
		inventory.add("cookie");
		inventory.add("surgical");
		inventory.add("surgical");
		inventory.add("bandage");
		inventory.add("bandage");
		inventory.add("bandage");
		inventory.add("medkit");
		
		ioFile.fileWrite(storeCrew, "src/StoreGame/CrewInfo.txt");
		ioFile.fileWrite(storeShip, "src/StoreGame/ShipInfo.txt");
		ioFile.fileWrite(storeCash, "src/StoreGame/CashInfo.txt");
		ioFile.fileWrite(inventory, "src/StoreGame/Inventory/Storage.txt");
		
		// Creating crew member each crew member there own information file
		for (int index = 0; index < crewType.size(); index++) {
			if (index == 0) {
				memberActions1 = ioFile.fileRead("src/StoreGame/CrewRatings/"+  crewType.get(0) + ".txt");
				memberActions1.add("2");
				memberActions1.add("false");
				memberActions1.add(crewNames.get(0));
				memberActions1.add(crewType.get(0));
				memberActions1.add("alive");
				ioFile.fileWrite(memberActions1, "src/StoreGame/CrewSelected/MemberOne.txt");
			} else if (index == 1) {
				memberActions2 = ioFile.fileRead("src/StoreGame/CrewRatings/"+  crewType.get(1) + ".txt");
				memberActions2.add("2");
				memberActions2.add("false");
				memberActions2.add(crewNames.get(1));
				memberActions2.add(crewType.get(1));
				memberActions2.add("alive");
				ioFile.fileWrite(memberActions2, "src/StoreGame/CrewSelected/MemberTwo.txt");
			} else if (index == 2) {
				memberActions3 = ioFile.fileRead("src/StoreGame/CrewRatings/"+  crewType.get(2) + ".txt");
				memberActions3.add("2");
				memberActions3.add("false");
				memberActions3.add(crewNames.get(2));
				memberActions3.add(crewType.get(2));
				memberActions3.add("alive");
				ioFile.fileWrite(memberActions3, "src/StoreGame/CrewSelected/MemberThree.txt");
			} else if (index == 3) {
				memberActions4 = ioFile.fileRead("src/StoreGame/CrewRatings/"+  crewType.get(3) + ".txt");
				memberActions4.add("2");
				memberActions4.add("false");
				memberActions4.add(crewNames.get(3));
				memberActions4.add(crewType.get(3));
				memberActions4.add("alive");
				ioFile.fileWrite(memberActions4, "src/StoreGame/CrewSelected/MemberFour.txt");
			}
		}
	}
	
	
	// Go to game screen if all fields are completed
	protected void startGameButton()
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
					mainScreen.frmEliteDangerousBeta.setVisible(true);  // turn on screen
					frmEliteDangerousBeta.setVisible(false);            // turn off screen
				}
			}
		});
		btnStart.setBounds(1200, 700, 250, 100);
		frmEliteDangerousBeta.getContentPane().add(btnStart);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NameShip.class.getResource("/gameImages/startup.jpg")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		frmEliteDangerousBeta.getContentPane().add(lblNewLabel);
	}
	
	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{	
		// Setting Layout dimensions
		frmEliteDangerousBeta = new JFrame();
		frmEliteDangerousBeta.setTitle("Elite Dangerous beta");
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
		frmEliteDangerousBeta.setBounds(display.x, display.y, display.width, display.height);
		frmEliteDangerousBeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		frmEliteDangerousBeta.setUndecorated(false);  // Frame cannot be adjusted during game
		frmEliteDangerousBeta.setResizable(false);
		
		
		// Initializing displays
		JLabel lblNameYourShip = new JLabel("Choose & Name Your ship");
		lblNameYourShip.setOpaque(true);
		lblNameYourShip.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameYourShip.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNameYourShip.setBounds(650, 50, 600, 50);
		frmEliteDangerousBeta.getContentPane().add(lblNameYourShip);
		
		txtShipsName = new JTextField();
		txtShipsName.setBounds(904, 298, 250, 30);
		frmEliteDangerousBeta.getContentPane().add(txtShipsName);
		txtShipsName.setColumns(10);
		
		JLabel lblShipType = new JLabel("Ship Type");
		lblShipType.setOpaque(true);
		lblShipType.setFont(new Font("Dialog", Font.BOLD, 19));
		lblShipType.setBounds(716, 179, 125, 50);
		frmEliteDangerousBeta.getContentPane().add(lblShipType);
		
		JLabel lblNameShip = new JLabel("Name Ship");
		lblNameShip.setOpaque(true);
		lblNameShip.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNameShip.setBounds(961, 213, 134, 30);
		frmEliteDangerousBeta.getContentPane().add(lblNameShip);
		
	    lblShipChosen = new JLabel("...");
	    lblShipChosen.setOpaque(true);
	    lblShipChosen.setBounds(970, 505, 212, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblShipChosen);
	    
	    lblNameOfShip = new JLabel("...");
	    lblNameOfShip.setOpaque(true);
	    lblNameOfShip.setBounds(970, 548, 212, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblNameOfShip);
	    
	    JLabel lblShipType_1 = new JLabel("Type:");
	    lblShipType_1.setOpaque(true);
	    lblShipType_1.setBounds(904, 505, 54, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblShipType_1);
	    
	    JLabel lblShipsName = new JLabel("Name:");
	    lblShipsName.setOpaque(true);
	    lblShipsName.setBounds(904, 548, 47, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblShipsName);
	    
	    JLabel lblShipStatus = new JLabel("Ship Status");
	    lblShipStatus.setOpaque(true);
	    lblShipStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
	    lblShipStatus.setBounds(923, 455, 112, 23);
	    frmEliteDangerousBeta.getContentPane().add(lblShipStatus);
	    
	    JLabel label = new JLabel("Setup progress");
	    label.setOpaque(true);
	    label.setHorizontalAlignment(SwingConstants.CENTER);
	    label.setBounds(230, 125, 150, 30);
	    frmEliteDangerousBeta.getContentPane().add(label);
	    
	    JProgressBar progressBar = new JProgressBar();
	    progressBar.setValue(2);
	    progressBar.setStringPainted(true);
	    progressBar.setMaximum(3);
	    progressBar.setBounds(230, 170, 150, 30);
	    frmEliteDangerousBeta.getContentPane().add(progressBar);
	   
	    lblMember1 = new JLabel("1. ...");
	    lblMember1.setOpaque(true);
	    lblMember1.setBounds(230, 386, 117, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblMember1);
	    
	    lblMember2 = new JLabel("2. ...");
	    
	    lblMember2.setOpaque(true);
	    lblMember2.setBounds(230, 413, 117, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblMember2);
	    
	    lblMember3 = new JLabel("3. ...");
	    lblMember3.setOpaque(true);
	    lblMember3.setBounds(230, 440, 117, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblMember3);
	    
	    lblMember4 = new JLabel("4. ...");
	    lblMember4.setOpaque(true);
	    lblMember4.setBounds(230, 467, 117, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblMember4);
	    
	    lblName1 = new JLabel("...");
	    lblName1.setOpaque(true);
	    lblName1.setBounds(352, 385, 109, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblName1);
	    
	    lblName2 = new JLabel("...");
	    lblName2.setOpaque(true);
	    lblName2.setBounds(352, 413, 109, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblName2);
	    
	    lblName3 = new JLabel("...");
	    lblName3.setOpaque(true);
	    lblName3.setBounds(352, 439, 109, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblName3);
	    
	    lblName4 = new JLabel("...");
	    lblName4.setOpaque(true);
	    lblName4.setBounds(352, 466, 109, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblName4);
	    
	    JLabel lblCrewStatus = new JLabel("Crew");
	    lblCrewStatus.setOpaque(true);
	    lblCrewStatus.setHorizontalAlignment(SwingConstants.CENTER);
	    lblCrewStatus.setFont(new Font("Dialog", Font.PLAIN, 16));
	    lblCrewStatus.setBounds(230, 324, 150, 23);
	    frmEliteDangerousBeta.getContentPane().add(lblCrewStatus);
	    
	    JLabel lblPiecesToCollect = new JLabel("Pieces to Collect");
	    lblPiecesToCollect.setOpaque(true);
	    lblPiecesToCollect.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPiecesToCollect.setFont(new Font("Dialog", Font.PLAIN, 16));
	    lblPiecesToCollect.setBounds(230, 247, 150, 23);
	    frmEliteDangerousBeta.getContentPane().add(lblPiecesToCollect);
	    
	    lblPieces = new JLabel("...");
	    lblPieces.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPieces.setBounds(230, 279, 150, 15);
	    frmEliteDangerousBeta.getContentPane().add(lblPieces);
	    
	    JLabel label_9 = new JLabel("Current Team");
	    label_9.setOpaque(true);
	    label_9.setBounds(230, 359, 109, 15);
	    frmEliteDangerousBeta.getContentPane().add(label_9);
	    
	    JLabel label_10 = new JLabel("Names");
	    label_10.setOpaque(true);
	    label_10.setBounds(352, 358, 66, 15);
	    frmEliteDangerousBeta.getContentPane().add(label_10);
		
		JLabel lblName = new JLabel("Please enter the name of your ship:");
		lblName.setOpaque(true);
		lblName.setBounds(904, 256, 250, 30);
		frmEliteDangerousBeta.getContentPane().add(lblName);
		
	
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
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
