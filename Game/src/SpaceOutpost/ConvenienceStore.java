package SpaceOutpost;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import IOFile.IOFile;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

//Self implemented
import WindowSettings.Display;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;



public class ConvenienceStore 
{
	public JFrame frame;


	private JLabel lblCurrentCash;
	private JComboBox cBox1, cBox2, cBox3;
	private JLabel lbl1, lbl2, lbl3;
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
				cash1 = Integer.valueOf(((String)cBox1.getSelectedItem()).replace("x", "")) * 30;
				lbl1.setText("= $" + cash1);
				totalAmount = cash1 + cash2 + cash3 + cash4 + cash5;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
			}
		});
		cBox1.setModel(new DefaultComboBoxModel(new String[] {"0", "x1"}));
		cBox1.setMaximumRowCount(9);
		cBox1.setBounds(478, 127, 90, 21);
		frame.getContentPane().add(cBox1);
		
		
		
		cBox2 = new JComboBox();
		cBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash2 = Integer.valueOf(((String)cBox2.getSelectedItem()).replace("x", "")) * 30;
				lbl2.setText("= $" + cash2);
				totalAmount = cash1 + cash2 + cash3 + cash4 + cash5;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
			}
		});
		cBox2.setModel(new DefaultComboBoxModel(new String[] {"0", "x1"}));
		cBox2.setSelectedIndex(0);
		cBox2.setMaximumRowCount(9);
		cBox2.setBounds(478, 197, 90, 21);
		frame.getContentPane().add(cBox2);
		
		cBox3 = new JComboBox();
		cBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash3 = Integer.valueOf(((String)cBox3.getSelectedItem()).replace("x", "")) * 50;
				lbl3.setText("= $" + cash3);
				totalAmount = cash1 + cash2 + cash3 + cash4 + cash5;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
			}
		});
		cBox3.setModel(new DefaultComboBoxModel(new String[] {"0", "x1"}));
		cBox3.setSelectedIndex(0);
		cBox3.setMaximumRowCount(9);
		cBox3.setBounds(490, 286, 90, 21);
		frame.getContentPane().add(cBox3);
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
//		frame.setUndecorated(false);  // Frame cannot be adjusted during game
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
		
		lblCurrentCash = new JLabel("Current Cash = $");
		lblCurrentCash.setBounds(518, 74, 221, 21);
		frame.getContentPane().add(lblCurrentCash);
		
		lbl1 = new JLabel("= $ 0");
		lbl1.setBounds(612, 127, 127, 21);
		frame.getContentPane().add(lbl1);
		
		lbl2 = new JLabel("= $ 0");
		lbl2.setBounds(621, 192, 158, 31);
		frame.getContentPane().add(lbl2);
		
		lbl3 = new JLabel("= $ 0");
		lbl3.setBounds(610, 281, 112, 30);
		frame.getContentPane().add(lbl3);
		
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
	public ConvenienceStore() 
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
					ConvenienceStore window = new ConvenienceStore();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
