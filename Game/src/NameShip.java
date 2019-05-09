import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;



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
		frame = new JFrame();
		frame.setBounds(100, 100, 864, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Crew:");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNewLabel.setBounds(40, 126, 81, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNameYourShip = new JLabel("Choose & Name Your ship");
		lblNameYourShip.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNameYourShip.setBounds(223, 12, 430, 107);
		frame.getContentPane().add(lblNameYourShip);
		
		txtShipsName = new JTextField();
		txtShipsName.setBounds(560, 262, 186, 31);
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
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// move to main screen
			}
		});
		btnStart.setBounds(672, 374, 125, 77);
		frame.getContentPane().add(btnStart);
		
		
		
		
		
		final JLabel lblName = new JLabel("Please enter the name of your ship:");
		lblName.setBounds(402, 235, 237, 15);
		frame.getContentPane().add(lblName);
		
//		JButton btnConfirm = new JButton("Click here to set name");
//		btnConfirm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				confirmShip.setText("The current name of your ship is: " + textField.getText());
//			}
//		});
//		btnConfirm.setBounds(560, 305, 201, 25);
//		frame.getContentPane().add(btnConfirm);
		
		
		

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
	    		if (txtShipsName.getText().equals("")) JOptionPane.showMessageDialog(null, "Please enter a name");
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
	    		} else {
	    			JOptionPane.showMessageDialog(null, "Please Select a Ship type first");
	    			lblNameOfShip.setText("...");
	    		}
	    		
	    		// Clear the field
	    		txtShipsName.setText("");
	    	}
	    });
	    btnSetYourShips.setBounds(560, 305, 174, 45);
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
	    lblShipStatus.setBounds(50, 344, 112, 23);
	    frame.getContentPane().add(lblShipStatus);
	    
	    
	    
	    
//	     String choice = group.getSelection().getActionCommand();
	     
//		   confirmShip.setText("The current name of your " + choice + " ship is: ");		
//		
//		   
//		   JButton btnConfirm = new JButton("Click here to set name");
//		   btnConfirm.addActionListener(new ActionListener() {
//
//			confirmShip.setText("The current name of your " + choice +" ship is: " + textField.getText());
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
