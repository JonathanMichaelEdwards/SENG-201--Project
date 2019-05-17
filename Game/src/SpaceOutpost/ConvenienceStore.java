package SpaceOutpost;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

//Self implemented
import WindowSettings.Display;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ConvenienceStore 
{
	public JFrame frame;


	private void backToOutpost()
	{
		JButton btnBackToOupost = new JButton("Back to Outpost");
		btnBackToOupost.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				SpaceOutpost spaceOutpost = new SpaceOutpost();
				spaceOutpost.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);              // turn off screen
			}
		});
		btnBackToOupost.setBounds(556, 500, 171, 57);
		frame.getContentPane().add(btnBackToOupost);
	}
	
	
	/*
	 * Create the application.
	*/
	public ConvenienceStore() 
	{
		initialize();
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
		JLabel lblConvenienceStore = new JLabel("Convenience Store");
		lblConvenienceStore.setBounds(269, 39, 217, 15);
		frame.getContentPane().add(lblConvenienceStore);
		
		JLabel lblBuyOtherItems = new JLabel("Buy other items to assist your journey");
		lblBuyOtherItems.setBounds(185, 66, 301, 15);
		frame.getContentPane().add(lblBuyOtherItems);
		
		JLabel lblWeaponsUpgrades = new JLabel("Weapons Upgrades (Fight off aliens, single use)");
		lblWeaponsUpgrades.setBounds(34, 130, 360, 15);
		frame.getContentPane().add(lblWeaponsUpgrades);
		
		JLabel lblGeoscanner = new JLabel("Geo-Scanner (Find rare loot easier)");
		lblGeoscanner.setBounds(34, 289, 360, 15);
		frame.getContentPane().add(lblGeoscanner);
		
		JLabel lblMoraleBoost = new JLabel("Morale Boost (1 free action for any crew member)");
		lblMoraleBoost.setBounds(34, 200, 376, 15);
		frame.getContentPane().add(lblMoraleBoost);
		
		JLabel label = new JLabel("$30");
		label.setBounds(406, 130, 66, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("$50");
		label_1.setBounds(406, 289, 66, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("$30");
		label_2.setBounds(406, 200, 66, 15);
		frame.getContentPane().add(label_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setMaximumRowCount(1);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1"}));
		comboBox.setBounds(518, 125, 66, 24);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setMaximumRowCount(1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1"}));
		comboBox_1.setBounds(518, 195, 66, 24);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1"}));
		comboBox_2.setMaximumRowCount(1);
		comboBox_2.setBounds(518, 284, 66, 24);
		frame.getContentPane().add(comboBox_2);
		
		JLabel label_3 = new JLabel("=");
		label_3.setBounds(614, 130, 66, 15);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("=");
		label_4.setBounds(614, 200, 66, 15);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("=");
		label_5.setBounds(614, 289, 66, 15);
		frame.getContentPane().add(label_5);
		
		JLabel lblCurrentCash = new JLabel("Current Cash = $");
		lblCurrentCash.setBounds(518, 80, 145, 15);
		frame.getContentPane().add(lblCurrentCash);
		
		JLabel label_6 = new JLabel("$");
		label_6.setBounds(672, 130, 66, 15);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("$");
		label_7.setBounds(672, 200, 66, 15);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("$");
		label_8.setBounds(672, 289, 66, 15);
		frame.getContentPane().add(label_8);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.setBounds(749, 500, 171, 57);
		frame.getContentPane().add(btnNewButton);
		

		
		// Button Actions
		backToOutpost();
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
					ConvenienceStore window = new ConvenienceStore();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
