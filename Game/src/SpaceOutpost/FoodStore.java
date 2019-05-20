package SpaceOutpost;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

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
	private JLabel cBType1, cBType2, cBType3, cBType4;
	private JLabel fsName1, fsName2, fsName3, fsName4;
	
	
	private JProgressBar cBHealth1, cBHealth2, cBHealth3, cBHealth4;
	private JProgressBar cBTired1, cBTired2, cBTired3, cBTired4;
	private JProgressBar cBHunger1, cBHunger2, cBHunger3, cBHunger4;
	
	// File locations
	private String readCrew = "StoreGame/CrewRatings/";
	
	// stores the selection type
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewName = new ArrayList<String>();

	private JLabel type[] = new JLabel[4];
	private JLabel member[] = new JLabel[4];
	
	
	private JProgressBar health[] = new JProgressBar[4];
	private JProgressBar tiredness[] = new JProgressBar[4];
	private JProgressBar hunger[] = new JProgressBar [4];
	

	// Store all progress bar so it can be used easily
	// Stores crew details in data arrays so it can be used easily
	private void cBHealth() 
	{
		health[0] = cBHealth1;
		health[1] = cBHealth2;
		health[2] = cBHealth3;
		health[3] = cBHealth4;
	}
	
	private void cBTired() 
	{
		tiredness[0] = cBTired1;
		tiredness[1] = cBTired2;
		tiredness[2] = cBTired3;
		tiredness[3] = cBTired4;
	}
	
	private void cBHunger() 
	{
		hunger[0] = cBHunger1;
		hunger[1] = cBHunger2;
		hunger[2] = cBHunger3;
		hunger[3] = cBHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void cBType() 
	{
		
		type[0] = cBType1;
		type[1] = cBType2;
		type[2] = cBType3;
		type[3] = cBType4;
	}
	
	private void fsName() 
	{
		member[0] = fsName1;
		member[1] = fsName2;
		member[2] = fsName3;
		member[3] = fsName4;
	}
	

	// helper function to find the correct member and name
	private void addCrew(ArrayList<String> crewInfo, int size)
	{	
		for (int index = 0; index < size; index ++) {
			crewType.add(crewInfo.get(index));
			crewName.add(crewInfo.get(index+size));
		}
		disableStatus(size);
	}
	
	
	// items to be disabled
	private void disableInfo(int index) 
	{

		type[index].setEnabled(false);
		member[index].setEnabled(false);
		hunger[index].setEnabled(false);
		health[index].setEnabled(false);
		tiredness[index].setEnabled(false);
	}
	
	// helper function to disable/(grey out) unused status information areas
	private void disableStatus(int size)
	{
		int lsSize = 4;
		
		// disable/(grey out) unused status information areas
		for (int index = 0; index < lsSize; index++) {
			if ((lsSize-size) == 2 && (index >= 2)) {
				disableInfo(index);
			} else if ((lsSize-size) == 3 && (index == 3)) {
				disableInfo(index);
			}
		}
	}
	
	
	// decode crew information to get correct data
	private void decodeCrewInfo(ArrayList<String> crewInfo)
	{
		// store crew member and there names at the correct index in separate lists
		// size is -1 because an empty value is added on to the end
		if ((crewInfo.size()) == 4) addCrew(crewInfo, 2);
		else if (crewInfo.size() == 6) addCrew(crewInfo, 3);
		else if (crewInfo.size() == 8) addCrew(crewInfo, 4);
	}
	
	
	// Storing and displaying the characters health
	private void memberOne(ArrayList<String> crewMember1, IOFile ioFile)
	{
		crewMember1 = ioFile.fileRead(readCrew + crewType.get(0) + ".txt");
		
		cBHealth1.setValue(Integer.valueOf(crewMember1.get(0)));
		cBTired1.setValue(Integer.valueOf(crewMember1.get(1)));
		cBHunger1.setValue(Integer.valueOf(crewMember1.get(2)));
	}
	
	private void memberTwo(ArrayList<String> crewMember2, IOFile ioFile)
	{
		crewMember2 = ioFile.fileRead(readCrew + crewType.get(1) + ".txt");
		
		cBHealth2.setValue(Integer.valueOf(crewMember2.get(0)));
		cBTired2.setValue(Integer.valueOf(crewMember2.get(1)));
		cBHunger2.setValue(Integer.valueOf(crewMember2.get(2)));
	}
	
	private void memberThree(ArrayList<String> crewMember3, IOFile ioFile)
	{
		crewMember3 = ioFile.fileRead(readCrew + crewType.get(2) + ".txt");
		
		cBHealth3.setValue(Integer.valueOf(crewMember3.get(0)));
		cBTired3.setValue(Integer.valueOf(crewMember3.get(1)));
		cBHunger3.setValue(Integer.valueOf(crewMember3.get(2)));
	}
	
	private void memberFour(ArrayList<String> crewMember4, IOFile ioFile)
	{
		crewMember4 = ioFile.fileRead(readCrew + crewType.get(3) + ".txt");
		
		cBHealth4.setValue(Integer.valueOf(crewMember4.get(0)));
		cBTired4.setValue(Integer.valueOf(crewMember4.get(1)));
		cBHunger4.setValue(Integer.valueOf(crewMember4.get(2)));
	}
	
	
	private void readCrewRatings()
	{ 
		ArrayList<String> crewMember1 = new ArrayList<String>();
		ArrayList<String> crewMember2 = new ArrayList<String>();
		ArrayList<String> crewMember3 = new ArrayList<String>();
		ArrayList<String> crewMember4 = new ArrayList<String>();
		IOFile ioFile = new IOFile();
		
		// Reading and storing the crew members health rating
		for (int index = 0; index < crewType.size(); index++) {
			// Storing the character types health rating
			if (index == 0) {
				memberOne(crewMember1, ioFile);
			} else if (index == 1) {
				memberTwo(crewMember2, ioFile);
			} else if (index == 2) {
				memberThree(crewMember3, ioFile);
			} else if (index == 3) {
				memberFour(crewMember4, ioFile);;
			}
		}
	}
	
	
	// organizing information from files
	private void organizeGameInfo()
	{
		// gather information stored in file
		IOFile ioFile = new IOFile();
		
		// Reading files
		ArrayList<String> crewInfo = ioFile.fileRead("StoreGame/CrewInfo.txt");
		// unwrap information
		decodeCrewInfo(crewInfo);
<<<<<<< HEAD
=======
		readCrewRatings();
		
>>>>>>> master
		for (int index = 0; index < crewType.size(); index++) {
			type[index].setText(crewType.get(index));
			member[index].setText(crewName.get(index));
		}
	}
		
	
	
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
		label.setBounds(72, 107, 183, 13);
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
		cBHealth1 = new JProgressBar();
		cBHealth1.setBounds(313, 733, 146, 30);
		frame.getContentPane().add(cBHealth1);

		cBTired1 = new JProgressBar();
		cBTired1.setBounds(313, 797, 146, 30);
		frame.getContentPane().add(cBTired1);
	

		cBHunger1 = new JProgressBar();
		cBHunger1.setBounds(313, 867, 146, 30);
		frame.getContentPane().add(cBHunger1);
		
	
		cBHealth2 = new JProgressBar();
		cBHealth2.setBounds(518, 733, 146, 36);
		frame.getContentPane().add(cBHealth2);
		

		cBTired2 = new JProgressBar();
		cBTired2.setBounds(530, 797, 134, 30);
		frame.getContentPane().add(cBTired2);
		
	
		cBHunger2 = new JProgressBar();
		cBHunger2.setBounds(538, 867, 126, 30);
		frame.getContentPane().add(cBHunger2);
	

		cBHealth3 = new JProgressBar();
		cBHealth3.setBounds(716, 727, 146, 52);
		frame.getContentPane().add(cBHealth3);
		
	
		cBTired3 = new JProgressBar();
		cBTired3.setBounds(716, 791, 146, 52);
		frame.getContentPane().add(cBTired3);

		cBHunger3 = new JProgressBar();
		cBHunger3.setBounds(716, 855, 146, 52);
		frame.getContentPane().add(cBHunger3);



		cBHealth4 = new JProgressBar();
		cBHealth4.setBounds(900, 733, 146, 52);
		frame.getContentPane().add(cBHealth4);
		
	
		cBTired4 = new JProgressBar();
		cBTired4.setBounds(900, 797, 146, 52);
		frame.getContentPane().add(cBTired4);
		
	
		cBHunger4 = new JProgressBar();
		cBHunger4.setBounds(897, 855, 146, 52);
		frame.getContentPane().add(cBHunger4);

		fsName4 = new JLabel("...");
		fsName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		fsName4.setBounds(900, 901, 127, 23);
		frame.getContentPane().add(fsName4);

		fsName3 = new JLabel("...");
		fsName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		fsName3.setBounds(716, 901, 126, 23);
		frame.getContentPane().add(fsName3);

		fsName2 = new JLabel("...");
		fsName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		fsName2.setBounds(528, 905, 119, 22);
		frame.getContentPane().add(fsName2);
		
		fsName1 = new JLabel("...");
		fsName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		fsName1.setBounds(323, 899, 117, 28);
		frame.getContentPane().add(fsName1);
		
		JLabel labell = new JLabel("Crew Info");
		labell.setFont(new Font("Dialog", Font.PLAIN, 16));
		labell.setBounds(544, 648, 112, 23);
		frame.getContentPane().add(labell);
	

		JLabel label0 = new JLabel("Hunger:");
		label0.setFont(new Font("Dialog", Font.PLAIN, 16));
		label0.setBounds(169, 871, 81, 15);
		frame.getContentPane().add(label0);

		JLabel label1 = new JLabel("Tiredness:");
		label1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label1.setBounds(169, 814, 81, 15);
		frame.getContentPane().add(label1);
	

		JLabel label2 = new JLabel("Health:");
		label2.setLocation(109, 626);
		label2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(60, 125, 81, 15);
		frame.getContentPane().add(label2);
		
		
		JLabel label3 = new JLabel("Name:");
		label3.setFont(new Font("Dialog", Font.PLAIN, 16));
		label3.setBounds(171, 904, 81, 15);
		frame.getContentPane().add(label3);

	

		


		JLabel label4 = new JLabel("Type:");
		label4.setFont(new Font("Dialog", Font.PLAIN, 16));
		label4.setBounds(169, 711, 81, 15);
		frame.getContentPane().add(label4);

		cBType1 = new JLabel("...");
		cBType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType1.setBounds(330, 695, 129, 30);
		frame.getContentPane().add(cBType1);

		cBType2 = new JLabel("...");
		cBType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType2.setBounds(541, 702, 119, 23);
		frame.getContentPane().add(cBType2);

		cBType3 = new JLabel("...");
		cBType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType3.setBounds(733, 705, 129, 21);
		frame.getContentPane().add(cBType3);
	

		cBType4 = new JLabel("...");
		cBType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType4.setBounds(912, 705, 134, 22);
		frame.getContentPane().add(cBType4);
		
		frame.getContentPane().setLayout(null);
		
		

		//initialize storage arrays
		cBType();
		fsName();
		
		cBHealth();
		cBTired();
		cBHunger();
		
		// Button Actions
		cBoxActions();
		backToOutpost();
		btnBuy();
		organizeGameInfo();
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
