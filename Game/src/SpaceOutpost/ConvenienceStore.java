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
	private JLabel cpType1, cpType2, cpType3, cpType4;
	private JLabel cpName1, cpName2, cpName3, cpName4;
	
	
	private JProgressBar cpHealth1, cpHealth2, cpHealth3, cpHealth4;
	private JProgressBar cpTired1, cpTired2, cpTired3, cpTired4;
	private JProgressBar cpHunger1, cpHunger2, cpHunger3, cpHunger4;
	
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
	private void cpHealth() 
	{
		health[0] = cpHealth1;
		health[1] = cpHealth2;
		health[2] = cpHealth3;
		health[3] = cpHealth4;
	}
	
	private void cpTired() 
	{
		tiredness[0] = cpTired1;
		tiredness[1] = cpTired2;
		tiredness[2] = cpTired3;
		tiredness[3] = cpTired4;
	}
	
	private void cpHunger() 
	{
		hunger[0] = cpHunger1;
		hunger[1] = cpHunger2;
		hunger[2] = cpHunger3;
		hunger[3] = cpHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void cpType() 
	{
		
		type[0] = cpType1;
		type[1] = cpType2;
		type[2] = cpType3;
		type[3] = cpType4;
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
	
	
	// organizing information from files
	private void organizeGameInfo()
	{
		// gather information stored in file
		IOFile ioFile = new IOFile();
		
		// Reading files
		ArrayList<String> crewInfo = ioFile.fileRead("StoreGame/CrewInfo.txt");
		
		// unwrap information
		decodeCrewInfo(crewInfo);
		
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
				cash3 = Integer.valueOf(((String)cBox3.getSelectedItem()).replace("x", "")) * 30;
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
		lblCurrentCash.setBounds(518, 80, 145, 15);
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
		cpHealth1 = new JProgressBar();
		cpHealth1.setBounds(331, 650, 146, 30);
		frame.getContentPane().add(cpHealth1);

		cpTired1 = new JProgressBar();
		cpTired1.setBounds(331, 714, 146, 30);
		frame.getContentPane().add(cpTired1);
	

		cpHunger1 = new JProgressBar();
		cpHunger1.setBounds(331, 784, 146, 30);
		frame.getContentPane().add(cpHunger1);
		
	
		cpHealth2 = new JProgressBar();
		cpHealth2.setBounds(536, 650, 146, 36);
		frame.getContentPane().add(cpHealth2);
		

		cpTired2 = new JProgressBar();
		cpTired2.setBounds(548, 714, 134, 30);
		frame.getContentPane().add(cpTired2);
		
	
		cpHunger2 = new JProgressBar();
		cpHunger2.setBounds(556, 784, 126, 30);
		frame.getContentPane().add(cpHunger2);
	

		cpHealth3 = new JProgressBar();
		cpHealth3.setBounds(734, 644, 146, 52);
		frame.getContentPane().add(cpHealth3);
		
	
		cpTired3 = new JProgressBar();
		cpTired3.setBounds(734, 708, 146, 52);
		frame.getContentPane().add(cpTired3);

		cpHunger3 = new JProgressBar();
		cpHunger3.setBounds(734, 772, 146, 52);
		frame.getContentPane().add(cpHunger3);



		cpHealth4 = new JProgressBar();
		cpHealth4.setBounds(918, 650, 146, 52);
		frame.getContentPane().add(cpHealth4);
		
	
		cpTired4 = new JProgressBar();
		cpTired4.setBounds(918, 714, 146, 52);
		frame.getContentPane().add(cpTired4);
		
	
		cpHunger4 = new JProgressBar();
		cpHunger4.setBounds(915, 772, 146, 52);
		frame.getContentPane().add(cpHunger4);

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

		cpType1 = new JLabel("...");
		cpType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpType1.setBounds(348, 612, 129, 30);
		frame.getContentPane().add(cpType1);

		cpType2 = new JLabel("...");
		cpType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpType2.setBounds(559, 619, 119, 23);
		frame.getContentPane().add(cpType2);

		cpType3 = new JLabel("...");
		cpType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpType3.setBounds(751, 622, 129, 21);
		frame.getContentPane().add(cpType3);
	

		cpType4 = new JLabel("...");
		cpType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		cpType4.setBounds(930, 622, 134, 22);
		frame.getContentPane().add(cpType4);
		
		frame.getContentPane().setLayout(null);
		
		

		//initialize storage arrays
		cpType();
		cpName();
		
		cpHealth();
		cpTired();
		cpHunger();
		
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
