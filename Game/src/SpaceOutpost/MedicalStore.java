package SpaceOutpost;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

//Self implemented
import WindowSettings.Display;
import IOFile.IOFile;


public class MedicalStore 
{
	public JFrame frame;

	private JLabel lblCurrentCash;
	private JComboBox cBox1, cBox2, cBox3, cBox4, cBox5;
	private JLabel lbl1, lbl2, lbl3, lbl4, lbl5;
	private JLabel lblAmount;
	
	private int cashSpent, totalAmount, cash1, cash2, cash3, cash4, cash5 = 0;
	
	
	// get the amount of cash the player has in his bank
	private void totalCash()
	{
		ArrayList<String> bank = new ArrayList<String>();
		IOFile ioFile = new IOFile();
		
		bank = ioFile.fileRead("StoreGame/CashInfo.txt");
		lblCurrentCash.setText("Current Cash = $ " + bank.get(0).toString());
	}
	
	
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
	
	
	private void btnBuy()
	{
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{		
				ArrayList<String> totalCash = new ArrayList<String>();
				IOFile ioFile = new IOFile();
				
				cashSpent += cash1 + cash2 + cash3 + cash4 + cash5;
				totalCash = ioFile.fileRead("StoreGame/CashInfo.txt");
				int bank = Integer.parseInt(totalCash.get(0)) - cashSpent;
				totalCash.set(0, "" + bank);
				
				// store the new cash amount
				ioFile.fileWrite(totalCash, "StoreGame/CashInfo.txt");  // Writing in new days
				lblCurrentCash.setText("Current Cash = $ " + totalCash.get(0).toString());
				
				// Go back to outpost
				SpaceOutpost screen = new SpaceOutpost();
				screen.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);        // turn off screen
			}
		});
		btnBuy.setBounds(646, 441, 194, 53);
		frame.getContentPane().add(btnBuy);
	}
	
	
	private void cBoxActions()
	{
		cBox1 = new JComboBox();
		cBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash1 = Integer.valueOf(((String)cBox1.getSelectedItem()).replace("x", "")) * 5;
				lbl1.setText("= $" + cash1);
				totalAmount = cash1 + cash2 + cash3 + cash4 + cash5;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
			}
		});
		cBox1.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		cBox1.setMaximumRowCount(9);
		cBox1.setBounds(342, 102, 90, 21);
		frame.getContentPane().add(cBox1);
		
		
		
		cBox2 = new JComboBox();
		cBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash2 = Integer.valueOf(((String)cBox2.getSelectedItem()).replace("x", "")) * 8;
				lbl2.setText("= $" + cash2);
				totalAmount = cash1 + cash2 + cash3 + cash4 + cash5;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
			}
		});
		cBox2.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		cBox2.setSelectedIndex(0);
		cBox2.setMaximumRowCount(9);
		cBox2.setBounds(342, 143, 90, 21);
		frame.getContentPane().add(cBox2);
		
		cBox3 = new JComboBox();
		cBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash3 = Integer.valueOf(((String)cBox3.getSelectedItem()).replace("x", "")) * 14;
				lbl3.setText("= $" + cash3);
				totalAmount = cash1 + cash2 + cash3 + cash4 + cash5;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
			}
		});
		cBox3.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		cBox3.setSelectedIndex(0);
		cBox3.setMaximumRowCount(9);
		cBox3.setBounds(342, 193, 90, 21);
		frame.getContentPane().add(cBox3);
		
		cBox4 = new JComboBox();
		cBox4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash4 = Integer.valueOf(((String)cBox4.getSelectedItem()).replace("x", "")) * 50;
				lbl4.setText("= $" + cash4);
				totalAmount = cash1 + cash2 + cash3 + cash4 + cash5;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
			}
		});
		cBox4.setModel(new DefaultComboBoxModel(new String[] {"0", "x1"}));
		cBox4.setSelectedIndex(0);
		cBox4.setMaximumRowCount(2);
		cBox4.setBounds(342, 276, 77, 21);
		frame.getContentPane().add(cBox4);
		
		cBox5 = new JComboBox();
		cBox5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash5 = Integer.valueOf(((String)cBox5.getSelectedItem()).replace("x", "")) * 50;
				lbl5.setText("= $" + cash5);
				totalAmount = cash1 + cash2 + cash3 + cash4 + cash5;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
			}
		});
		cBox5.setModel(new DefaultComboBoxModel(new String[] {"0", "x1"}));
		cBox5.setSelectedIndex(0);
		cBox5.setMaximumRowCount(2);
		cBox5.setBounds(342, 321, 77, 21);
		frame.getContentPane().add(cBox5);
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
		lblCommon.setBounds(59, 72, 283, 13);
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
		
		JLabel label = new JLabel("$5");
		label.setBounds(291, 106, 46, 13);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("$8");
		label_1.setBounds(291, 147, 46, 13);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("$14");
		label_2.setBounds(291, 197, 46, 13);
		frame.getContentPane().add(label_2);
		
		JLabel label_6 = new JLabel("$50");
		label_6.setBounds(291, 280, 46, 13);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("$50");
		label_7.setBounds(291, 327, 46, 13);
		frame.getContentPane().add(label_7);
		
		lbl5 = new JLabel("= $ 0");
		lbl5.setBounds(494, 325, 105, 17);
		frame.getContentPane().add(lbl5);
		
		lblCurrentCash = new JLabel("Current Cash = $");
		lblCurrentCash.setBounds(401, 63, 220, 21);
		frame.getContentPane().add(lblCurrentCash);
		
		lbl1 = new JLabel("= $ 0");
		lbl1.setBounds(494, 102, 127, 21);
		frame.getContentPane().add(lbl1);
		
		lbl2 = new JLabel("= $ 0");
		lbl2.setBounds(494, 131, 158, 31);
		frame.getContentPane().add(lbl2);
		
		lbl3 = new JLabel("= $ 0");
		lbl3.setBounds(494, 188, 112, 30);
		frame.getContentPane().add(lbl3);
		
		lbl4 = new JLabel("= $ 0");
		lbl4.setBounds(483, 271, 138, 30);
		frame.getContentPane().add(lbl4);
		
		lblAmount = new JLabel("Selected Amount = $ 0");
		lblAmount.setBounds(416, 364, 220, 21);
		frame.getContentPane().add(lblAmount);

		
		// Button Actions
		cBoxActions();
		btnBuy();
		backToOutpost();
	}
	
	
	/*
	 * Create the application.
	*/
	public MedicalStore() 
	{
		initialize();
		totalCash();
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
