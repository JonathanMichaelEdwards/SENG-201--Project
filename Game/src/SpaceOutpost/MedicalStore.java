package SpaceOutpost;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Self implemented
import GameSettings.Display;



public class MedicalStore 
{
	public JFrame frame;

	
	// Go back to the space outpost
	private void backToOutpost()
	{
		JButton btnBackToOutpost = new JButton("Back to Outpost");
		btnBackToOutpost.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SpaceOutpost spaceOutpost = new SpaceOutpost();
				spaceOutpost.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);              // turn off screen
			}
		});
		btnBackToOutpost.setBounds(437, 441, 199, 53);
		frame.getContentPane().add(btnBackToOutpost);
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
		JLabel lblMedicalStore = new JLabel("Medical Store");
		lblMedicalStore.setBounds(350, 31, 158, 30);
		frame.getContentPane().add(lblMedicalStore);
		
		JLabel lblBandages = new JLabel("Bandages - 2 health restored");
		lblBandages.setBounds(59, 106, 205, 13);
		frame.getContentPane().add(lblBandages);
		
		JLabel lblMedKit = new JLabel("Med Kit - 5 health restored");
		lblMedKit.setBounds(59, 147, 205, 13);
		frame.getContentPane().add(lblMedKit);
		
		JLabel lblSurgicalPackage = new JLabel("Surgical Package - Max health restored");
		lblSurgicalPackage.setBounds(59, 197, 205, 13);
		frame.getContentPane().add(lblSurgicalPackage);
		
		JLabel lblCommon = new JLabel("Common (Found by exploring planets)");
		lblCommon.setBounds(59, 72, 183, 13);
		frame.getContentPane().add(lblCommon);
		
		JLabel lblRare = new JLabel("Rare (Unlockable by exploring planets only)");
		lblRare.setBounds(59, 239, 296, 13);
		frame.getContentPane().add(lblRare);
		
		JLabel lblInfiniteHealthFor = new JLabel("Infinite health for all crew members for a day");
		lblInfiniteHealthFor.setBounds(59, 280, 218, 13);
		frame.getContentPane().add(lblInfiniteHealthFor);
		
		JLabel lblNewLabel = new JLabel("Permanent Doubled health capacity for all crew");
		lblNewLabel.setBounds(59, 327, 227, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBoxBandages = new JComboBox();
		comboBoxBandages.setModel(new DefaultComboBoxModel(new String[] {"x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		comboBoxBandages.setMaximumRowCount(9);
		comboBoxBandages.setBounds(342, 102, 90, 21);
		frame.getContentPane().add(comboBoxBandages);
		
		JComboBox comboBoxMedkit = new JComboBox();
		comboBoxMedkit.setModel(new DefaultComboBoxModel(new String[] {"x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		comboBoxMedkit.setSelectedIndex(0);
		comboBoxMedkit.setMaximumRowCount(9);
		comboBoxMedkit.setBounds(342, 143, 90, 21);
		frame.getContentPane().add(comboBoxMedkit);
		
		JComboBox comboBoxSurgical = new JComboBox();
		comboBoxSurgical.setModel(new DefaultComboBoxModel(new String[] {"x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		comboBoxSurgical.setSelectedIndex(0);
		comboBoxSurgical.setMaximumRowCount(9);
		comboBoxSurgical.setBounds(342, 193, 90, 21);
		frame.getContentPane().add(comboBoxSurgical);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1"}));
		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(2);
		comboBox.setBounds(342, 276, 77, 21);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setMaximumRowCount(1);
		comboBox_1.setBounds(342, 323, 77, 21);
		frame.getContentPane().add(comboBox_1);
		
		JLabel label = new JLabel("$5");
		label.setBounds(291, 106, 46, 13);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("$8");
		label_1.setBounds(291, 147, 46, 13);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("$14");
		label_2.setBounds(291, 197, 46, 13);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("=");
		label_3.setBounds(494, 106, 46, 13);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("=");
		label_4.setBounds(494, 147, 46, 13);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("=");
		label_5.setBounds(494, 197, 46, 13);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("$50");
		label_6.setBounds(291, 280, 46, 13);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("$50");
		label_7.setBounds(291, 327, 46, 13);
		frame.getContentPane().add(label_7);
		

		
		JLabel label_8 = new JLabel("=");
		label_8.setBounds(494, 280, 46, 13);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("=");
		label_9.setBounds(494, 327, 46, 13);
		frame.getContentPane().add(label_9);
		
		JLabel lblCurrentCash = new JLabel("Current Cash = $");
		lblCurrentCash.setBounds(401, 71, 127, 13);
		frame.getContentPane().add(lblCurrentCash);
		
		JLabel label_10 = new JLabel("$");
		label_10.setBounds(540, 106, 46, 13);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("$");
		label_11.setBounds(540, 147, 46, 13);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("$");
		label_12.setBounds(524, 197, 62, 13);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("$");
		label_13.setBounds(540, 280, 46, 13);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("$");
		label_14.setBounds(524, 327, 46, 13);
		frame.getContentPane().add(label_14);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(646, 441, 194, 53);
		frame.getContentPane().add(btnBuy);
		
		
		// Button Actions
		backToOutpost();
	}
	

	/*
	 * Create the application.
	*/
	public MedicalStore() 
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
					MedicalStore window = new MedicalStore();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
