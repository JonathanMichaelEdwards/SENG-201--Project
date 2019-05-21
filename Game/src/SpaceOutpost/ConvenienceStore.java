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



public class ConvenienceStore 
{
	public JFrame frame;


	private JLabel lblCurrentCash;
	private JComboBox cBox1, cBox2, cBox3;
	private JLabel lbl1, lbl2, lbl3;
	private JLabel lblAmount;
	
	private int cashSpent, totalAmount, cash1, cash2, cash3, cash4, cash5 = 0;
	private JLabel cBType1, cBType2, cBType3, cBType4;
	private JLabel cpName1, cpName2, cpName3, cpName4;
	
	// File locations
	private String readCrew = "StoreGame/CrewRatings/";
	
	
	private JProgressBar cBHealth1, cBHealth2, cBHealth3, cBHealth4;
	private JProgressBar cBTired1, cBTired2, cBTired3, cBTired4;
	private JProgressBar cBHunger1, cBHunger2, cBHunger3, cBHunger4;
	
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
	
	private void cpName() 
	{
		member[0] = cpName1;
		member[1] = cpName2;
		member[2] = cpName3;
		member[3] = cpName4;
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
		crewMember1 = ioFile.fileRead("StoreGame/CrewSelected/MemberOne.txt");
		
		cBHealth1.setValue(Integer.valueOf(crewMember1.get(0)));
		cBTired1.setValue(Integer.valueOf(crewMember1.get(1)));
		cBHunger1.setValue(Integer.valueOf(crewMember1.get(2)));
	}
	
	private void memberTwo(ArrayList<String> crewMember2, IOFile ioFile)
	{
		crewMember2 = ioFile.fileRead("StoreGame/CrewSelected/MemberTwo.txt");
		
		cBHealth2.setValue(Integer.valueOf(crewMember2.get(0)));
		cBTired2.setValue(Integer.valueOf(crewMember2.get(1)));
		cBHunger2.setValue(Integer.valueOf(crewMember2.get(2)));
	}
	
	private void memberThree(ArrayList<String> crewMember3, IOFile ioFile)
	{
		crewMember3 = ioFile.fileRead("StoreGame/CrewSelected/MemberThree.txt");
		
		cBHealth3.setValue(Integer.valueOf(crewMember3.get(0)));
		cBTired3.setValue(Integer.valueOf(crewMember3.get(1)));
		cBHunger3.setValue(Integer.valueOf(crewMember3.get(2)));
	}
	
	private void memberFour(ArrayList<String> crewMember4, IOFile ioFile)
	{
		crewMember4 = ioFile.fileRead("StoreGame/CrewSelected/MemberFour.txt");
		
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
		readCrewRatings();
		
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
		cBHealth1 = new JProgressBar();
		cBHealth1.setBounds(331, 650, 146, 30);
		frame.getContentPane().add(cBHealth1);

		cBTired1 = new JProgressBar();
		cBTired1.setBounds(331, 714, 146, 30);
		frame.getContentPane().add(cBTired1);
	

		cBHunger1 = new JProgressBar();
		cBHunger1.setBounds(331, 784, 146, 30);
		frame.getContentPane().add(cBHunger1);
		
	
		cBHealth2 = new JProgressBar();
		cBHealth2.setBounds(536, 650, 146, 36);
		frame.getContentPane().add(cBHealth2);
		

		cBTired2 = new JProgressBar();
		cBTired2.setBounds(548, 714, 134, 30);
		frame.getContentPane().add(cBTired2);
		
	
		cBHunger2 = new JProgressBar();
		cBHunger2.setBounds(556, 784, 126, 30);
		frame.getContentPane().add(cBHunger2);
	

		cBHealth3 = new JProgressBar();
		cBHealth3.setBounds(734, 644, 146, 52);
		frame.getContentPane().add(cBHealth3);
		
	
		cBTired3 = new JProgressBar();
		cBTired3.setBounds(734, 708, 146, 52);
		frame.getContentPane().add(cBTired3);

		cBHunger3 = new JProgressBar();
		cBHunger3.setBounds(734, 772, 146, 52);
		frame.getContentPane().add(cBHunger3);



		cBHealth4 = new JProgressBar();
		cBHealth4.setBounds(918, 650, 146, 52);
		frame.getContentPane().add(cBHealth4);
		
	
		cBTired4 = new JProgressBar();
		cBTired4.setBounds(918, 714, 146, 52);
		frame.getContentPane().add(cBTired4);
		
	
		cBHunger4 = new JProgressBar();
		cBHunger4.setBounds(915, 772, 146, 52);
		frame.getContentPane().add(cBHunger4);

		cpName4 = new JLabel("...");
		cpName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName4.setBounds(918, 818, 127, 23);
		frame.getContentPane().add(cpName4);

		cpName3 = new JLabel("...");
		cpName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName3.setBounds(734, 818, 126, 23);
		frame.getContentPane().add(cpName3);

		cpName2 = new JLabel("...");
		cpName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName2.setBounds(546, 822, 119, 22);
		frame.getContentPane().add(cpName2);
		
		cpName1 = new JLabel("...");
		cpName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpName1.setBounds(341, 816, 117, 28);
		frame.getContentPane().add(cpName1);
		
		JLabel labell = new JLabel("Crew Info");
		labell.setFont(new Font("Dialog", Font.PLAIN, 16));
		labell.setBounds(562, 565, 112, 23);
		frame.getContentPane().add(labell);
	

		JLabel label0 = new JLabel("Hunger:");
		label0.setFont(new Font("Dialog", Font.PLAIN, 16));
		label0.setBounds(187, 788, 81, 15);
		frame.getContentPane().add(label0);

		JLabel label1 = new JLabel("Tiredness:");
		label1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label1.setBounds(187, 731, 81, 15);
		frame.getContentPane().add(label1);
	

		JLabel label2 = new JLabel("Health:");
		label2.setLocation(127, 543);
		label2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(60, 125, 81, 15);
		frame.getContentPane().add(label2);
		
		
		JLabel label3 = new JLabel("Name:");
		label3.setFont(new Font("Dialog", Font.PLAIN, 16));
		label3.setBounds(189, 821, 81, 15);
		frame.getContentPane().add(label3);

	

		


		JLabel label4 = new JLabel("Type:");
		label4.setFont(new Font("Dialog", Font.PLAIN, 16));
		label4.setBounds(187, 628, 81, 15);
		frame.getContentPane().add(label4);

		cBType1 = new JLabel("...");
		cBType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType1.setBounds(348, 612, 129, 30);
		frame.getContentPane().add(cBType1);

		cBType2 = new JLabel("...");
		cBType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType2.setBounds(559, 619, 119, 23);
		frame.getContentPane().add(cBType2);

		cBType3 = new JLabel("...");
		cBType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType3.setBounds(751, 622, 129, 21);
		frame.getContentPane().add(cBType3);
	

		cBType4 = new JLabel("...");
		cBType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType4.setBounds(930, 622, 134, 22);
		frame.getContentPane().add(cBType4);
		
		frame.getContentPane().setLayout(null);
		
		

		//initialize storage arrays
		cBType();
		cpName();
		
		cBHealth();
		cBTired();
		cBHunger();
		
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
		organizeGameInfo();
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
