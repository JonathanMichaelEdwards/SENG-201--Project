import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JList;import java.awt.EventQueue;
2
import javax.swing.JFrame;
3
import javax.swing.JLabel;
4
import java.awt.BorderLayout;
5
import java.awt.Font;
6
import javax.swing.JList;
7
import javax.swing.AbstractListModel;
8
import javax.swing.JTextField;
9
import javax.swing.JButton;
10
​
11
​
12
public class NameShip {
13
​
14
        private JFrame frame;
15
        private JTextField textField;
16
​
17
        
18
        /*
19
         * Initialize the contents of the frame.
20
        */
21
        private void initialize() 
22
        {
23
                frame = new JFrame();
24
                frame.setBounds(100, 100, 864, 525);
25
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
26
                frame.getContentPane().setLayout(null);
27
                
28
                JLabel lblNewLabel = new JLabel("Crew:");
29
                lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 19));
30
                lblNewLabel.setBounds(40, 126, 81, 53);
31
                frame.getContentPane().add(lblNewLabel);
32
                
33
                JLabel lblNameYourShip = new JLabel("Name Your ship");
34
                lblNameYourShip.setFont(new Font("Dialog", Font.BOLD, 25));
35
                lblNameYourShip.setBounds(298, 12, 253, 107);
36
                frame.getContentPane().add(lblNameYourShip);
37
                
38
                textField = new JTextField();
39
                textField.setBounds(560, 244, 186, 68);
40
                frame.getContentPane().add(textField);
41
                textField.setColumns(10);
42
                
43
                JLabel lblShipType = new JLabel("Ship Type");
44
                lblShipType.setFont(new Font("Dialog", Font.BOLD, 19));
45
                lblShipType.setBounds(298, 126, 125, 94);
46
                frame.getContentPane().add(lblShipType);
47
                
48
                JLabel lblNameShip = new JLabel("Name Ship");
49
                lblNameShip.setFont(new Font("Dialog", Font.BOLD, 19));
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
