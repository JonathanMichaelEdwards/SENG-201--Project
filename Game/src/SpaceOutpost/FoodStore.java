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



public class FoodStore 
{
	public JFrame frame;
	
	private JLabel lblCurrentCash;
	private JComboBox<?> cBox1, cBox2, cBox3, cBox4, cBox5;
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
		btnBackToOutpost.setBounds(526, 512, 183, 59);
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
		btnBuy.setBounds(719, 510, 205, 61);
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
		cBox1.setSelectedIndex(0);
		cBox1.setMaximumRowCount(9);
		cBox1.setBounds(342, 128, 90, 21);
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

		cBox2.setBounds(342, 172, 90, 21);
		frame.getContentPane().add(cBox2);
		
		
		cBox3 = new JComboBox();
		cBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash3 = Integer.valueOf(((String)cBox3.getSelectedItem()).replace("x", "")) * 8;
				lbl3.setText("= $" + cash3);
				totalAmount = cash1 + cash2 + cash3 + cash4 + cash5;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
			}
		});
		cBox3.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		cBox3.setBounds(342, 217, 90, 21);
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
		cBox4.setBounds(355, 318, 77, 21);
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
		cBox5.setBounds(355, 373, 77, 21);
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
		JLabel lblFoodStore = new JLabel("Food Store");
		lblFoodStore.setBounds(368, 39, 183, 13);
		frame.getContentPane().add(lblFoodStore);
		
		JLabel label = new JLabel("Common (Found by exploring planets)");
		label.setBounds(72, 93, 183, 13);
		frame.getContentPane().add(label);
		
		lblAmount = new JLabel("Selected Amount = $ 0");
		lblAmount.setBounds(423, 423, 220, 21);
		frame.getContentPane().add(lblAmount);
		
		lblCurrentCash = new JLabel("Current Cash = $");
		lblCurrentCash.setBounds(368, 85, 253, 21);
		frame.getContentPane().add(lblCurrentCash);
		
		JLabel lblCookie = new JLabel("Cookie - 2 hunger replenished");
		lblCookie.setBounds(72, 132, 205, 13);
		frame.getContentPane().add(lblCookie);
		
		JLabel label_3 = new JLabel("$5");
		label_3.setBounds(304, 132, 46, 13);
		frame.getContentPane().add(label_3);
		
		lbl1 = new JLabel("=$ 0");
		lbl1.setBounds(539, 132, 46, 13);
		frame.getContentPane().add(lbl1);
		
		JLabel lblPizza = new JLabel("Pizza - 5 hunger replenished");
		lblPizza.setBounds(72, 176, 205, 13);
		frame.getContentPane().add(lblPizza);
		
		JLabel label_6 = new JLabel("$8");
		label_6.setBounds(304, 176, 46, 13);
		frame.getContentPane().add(label_6);
		
		lbl2 = new JLabel("=$ 0");
		lbl2.setBounds(539, 176, 46, 13);
		frame.getContentPane().add(lbl2);
		
		JLabel lblHealth = new JLabel("Full meal - Full hunger replenished");
		lblHealth.setBounds(72, 221, 205, 13);
		frame.getContentPane().add(lblHealth);
		
		JLabel label_9 = new JLabel("$8");
		label_9.setBounds(304, 221, 46, 13);
		frame.getContentPane().add(label_9);
		
		lbl3 = new JLabel("=$ 0");
		lbl3.setBounds(539, 221, 46, 13);
		frame.getContentPane().add(lbl3);
		
		JLabel label_2 = new JLabel("Rare (Unlockable by exploring planets only)");
		label_2.setBounds(72, 277, 296, 13);
		frame.getContentPane().add(label_2);
		
		JLabel lblCrewDoNot = new JLabel("Crew do not get hungry for a day");
		lblCrewDoNot.setBounds(72, 322, 218, 13);
		frame.getContentPane().add(lblCrewDoNot);
		
		JLabel label_13 = new JLabel("$50");
		label_13.setBounds(304, 322, 46, 13);
		frame.getContentPane().add(label_13);
		
		lbl4 = new JLabel("=$ 0");
		lbl4.setBounds(539, 322, 46, 13);
		frame.getContentPane().add(lbl4);
		
		JLabel lblHungerDecreasesAt = new JLabel("Hunger decreases at half the rate permanently");
		lblHungerDecreasesAt.setBounds(72, 377, 218, 13);
		frame.getContentPane().add(lblHungerDecreasesAt);
		
		JLabel label_16 = new JLabel("$50");
		label_16.setBounds(304, 377, 46, 13);
		frame.getContentPane().add(label_16);
		
		lbl5 = new JLabel("=$ 0");
		lbl5.setBounds(539, 377, 46, 13);
		frame.getContentPane().add(lbl5);
		
		JLabel lblCurrentlyOwned = new JLabel("Currently Owned");
		lblCurrentlyOwned.setBounds(689, 92, 138, 15);
		frame.getContentPane().add(lblCurrentlyOwned);
		
		
		// Button Actions
		cBoxActions();
		backToOutpost();
		btnBuy();
	}

	
	/*
	 * Create the application.
	*/
	public FoodStore() 
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
					FoodStore window = new FoodStore();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
