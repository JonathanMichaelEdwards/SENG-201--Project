import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;


public class NameShip {

	private JFrame frame;
	private JTextField textField;

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
		
		textField = new JTextField();
		textField.setBounds(560, 262, 186, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblShipType = new JLabel("Ship Type");
		lblShipType.setFont(new Font("Dialog", Font.BOLD, 19));
		lblShipType.setBounds(250, 105, 125, 94);
		frame.getContentPane().add(lblShipType);
		
		JLabel lblNameShip = new JLabel("Name Ship");
		lblNameShip.setFont(new Font("Dialog", Font.BOLD, 19));
		lblNameShip.setBounds(560, 126, 134, 94);
		frame.getContentPane().add(lblNameShip);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(504, 374, 125, 77);
		frame.getContentPane().add(btnBack);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(672, 374, 125, 77);
		frame.getContentPane().add(btnStart);
		
		final JLabel confirmShip = new JLabel("Please enter the name of your ship");
		confirmShip.setBounds(402, 235, 436, 15);
		frame.getContentPane().add(confirmShip);
		
//		JButton btnConfirm = new JButton("Click here to set name");
//		btnConfirm.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) 
//			{
//				confirmShip.setText("The current name of your ship is: " + textField.getText());
//			}
//		});
//		btnConfirm.setBounds(560, 305, 201, 25);
//		frame.getContentPane().add(btnConfirm);
		
		JRadioButton rdbtnRepairShip = new JRadioButton("Repair Ship");
		rdbtnRepairShip.setActionCommand("Repair");
		rdbtnRepairShip.setBounds(244, 197, 144, 23);
		frame.getContentPane().add(rdbtnRepairShip);
		
		JRadioButton rdbtnAttackShip = new JRadioButton("Attack Ship");
		rdbtnAttackShip.setActionCommand("Attack");
		rdbtnAttackShip.setBounds(244, 231, 144, 23);
		frame.getContentPane().add(rdbtnAttackShip);
		
		JRadioButton rdbtnInvisibleShip = new JRadioButton("Invisible Ship");
		rdbtnInvisibleShip.setActionCommand("Invisible");
		rdbtnInvisibleShip.setBounds(244, 266, 144, 23);
		frame.getContentPane().add(rdbtnInvisibleShip);
		
		JRadioButton rdbtnStorageShip = new JRadioButton("Storage Ship");
		rdbtnStorageShip.setActionCommand("Storage");
		rdbtnStorageShip.setBounds(244, 306, 144, 23);
		frame.getContentPane().add(rdbtnStorageShip);
		
		JRadioButton rdbtnMedicalShip = new JRadioButton("Medical Ship");
		rdbtnMedicalShip.setActionCommand("Medical");
		rdbtnMedicalShip.setBounds(244, 344, 144, 23);
		frame.getContentPane().add(rdbtnMedicalShip);
		
	    final ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnRepairShip);
	    group.add(rdbtnAttackShip);
	    group.add(rdbtnInvisibleShip);
	    group.add(rdbtnStorageShip);
	    group.add(rdbtnMedicalShip);
		
	    class VoteActionListener implements ActionListener {
	    	public void actionPerformed(ActionEvent ev) {
	    		   final String choice = group.getSelection( ).getActionCommand( );
	    		   confirmShip.setText("The current name of your " + choice + " ship is: ");		
	    		   
	    		   JButton btnConfirm = new JButton("Click here to set name");
	    		   btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					confirmShip.setText("The current name of your " + choice +" ship is: " + textField.getText());
				}
			});
			btnConfirm.setBounds(560, 305, 201, 25);
			frame.getContentPane().add(btnConfirm); 	
	    	
	    	   }
	    }

	// Add listeners to each button.
			ActionListener alisten = new VoteActionListener( );
			rdbtnRepairShip.addActionListener(alisten);
			rdbtnAttackShip.addActionListener(alisten);
			rdbtnInvisibleShip.addActionListener(alisten);
			rdbtnStorageShip.addActionListener(alisten);
			rdbtnMedicalShip.addActionListener(alisten);
		
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
