package SpaceOutpost;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

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
	private JComboBox cBox1, cBox2, cBox3, cBox4;
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JLabel lblAmount;
	
	private int cashSpent, totalAmount, cash1, cash2, cash3, cash4 = 0;
	private JLabel cBType1, cBType2, cBType3, cBType4;
	private JLabel msName1, msName2, msName3, msName4;
	private JButton btnBuy;
	
	private JProgressBar cBHealth1, cBHealth2, cBHealth3, cBHealth4;
	private JProgressBar cBTired1, cBTired2, cBTired3, cBTired4;
	private JProgressBar cBHunger1, cBHunger2, cBHunger3, cBHunger4;
	private int bandage, medkit, surgical, potion;
	private JLabel lblCountBandages, lblCountMedkit, lblCountSurgical, lblCountPotion;
	
	// stores the selection type
	private ArrayList<String> crewType = new ArrayList<String>();
	private ArrayList<String> crewName = new ArrayList<String>();
	private ArrayList<String> broughtItems1 = new ArrayList<String>();
	private ArrayList<String> broughtItems2 = new ArrayList<String>();
	private ArrayList<String> broughtItems3 = new ArrayList<String>();
	private ArrayList<String> broughtItems4 = new ArrayList<String>();

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
	
	private void msName() 
	{
		member[0] = msName1;
		member[1] = msName2;
		member[2] = msName3;
		member[3] = msName4;
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
			} else if ((lsSize-size) == 1 && (index == 3)) {
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
		crewMember1 = ioFile.fileRead("src/StoreGame/CrewSelected/MemberOne.txt");
		
		cBHealth1.setValue(Integer.valueOf(crewMember1.get(0)));
		cBTired1.setValue(Integer.valueOf(crewMember1.get(1)));
		cBHunger1.setValue(Integer.valueOf(crewMember1.get(2)));
	}
	
	private void memberTwo(ArrayList<String> crewMember2, IOFile ioFile)
	{
		crewMember2 = ioFile.fileRead("src/StoreGame/CrewSelected/MemberTwo.txt");
		
		cBHealth2.setValue(Integer.valueOf(crewMember2.get(0)));
		cBTired2.setValue(Integer.valueOf(crewMember2.get(1)));
		cBHunger2.setValue(Integer.valueOf(crewMember2.get(2)));
	}
	
	private void memberThree(ArrayList<String> crewMember3, IOFile ioFile)
	{
		crewMember3 = ioFile.fileRead("src/StoreGame/CrewSelected/MemberThree.txt");
		
		cBHealth3.setValue(Integer.valueOf(crewMember3.get(0)));
		cBTired3.setValue(Integer.valueOf(crewMember3.get(1)));
		cBHunger3.setValue(Integer.valueOf(crewMember3.get(2)));
	}
	
	private void memberFour(ArrayList<String> crewMember4, IOFile ioFile)
	{
		crewMember4 = ioFile.fileRead("src/StoreGame/CrewSelected/MemberFour.txt");
		
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
		ArrayList<String> storedItems= ioFile.fileRead("src/StoreGame/Inventory/Storage.txt");
		ArrayList<String> crewInfo = ioFile.fileRead("src/StoreGame/CrewInfo.txt");
		
		// unwrap information
		decodeCrewInfo(crewInfo);
		readCrewRatings();
		
		for (int index = 0; index < crewType.size(); index++) {
			type[index].setText(crewType.get(index));
			member[index].setText(crewName.get(index));
		}
		
		
		// Find out how many of the same items the player has
		for (int index = 0; index < storedItems.size(); index++) {
			if (storedItems.get(index).equals("bandage"))
				bandage++;
			if (storedItems.get(index).equals("medkit"))
				medkit++;
			if (storedItems.get(index).equals("surgical"))
				surgical++; 
			if (storedItems.get(index).equals("potion"))
				potion++;	
		}
		lblCountBandages.setText("x" + Integer.toString(bandage));
		lblCountMedkit.setText("x" + Integer.toString(medkit));
		lblCountSurgical.setText("x" + Integer.toString(surgical));
		lblCountPotion.setText("x" + Integer.toString(potion));
	}
	
	// get the amount of cash the player has in his bank
	private void totalCash()
	{
		ArrayList<String> bank = new ArrayList<String>();
		IOFile ioFile = new IOFile();
		
		bank = ioFile.fileRead("src/StoreGame/CashInfo.txt");
		lblCurrentCash.setText("Current Cash = $ " + bank.get(0).toString());
	}
	
	
	// Go back to the space outpost
	private void backToOutpost()
	{
		JButton btnBackToOutpost = new JButton("Back to Outpost");
		btnBackToOutpost.setBounds(437, 441, 199, 53);
		btnBackToOutpost.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SpaceOutpost spaceOutpost = new SpaceOutpost();
				spaceOutpost.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);              // turn off screen
			}
		});
		frame.getContentPane().add(btnBackToOutpost);
	}
	
	
	private void btnBuy()
	{
		btnBuy = new JButton("Buy");
		btnBuy.setBounds(646, 441, 194, 53);
		btnBuy.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{		
				ArrayList<String> totalCash = new ArrayList<String>();
				ArrayList<String> inventory = new ArrayList<String>();
				IOFile ioFile = new IOFile();
				
				cashSpent += cash1 + cash2 + cash3 + cash4;
				totalCash = ioFile.fileRead("src/StoreGame/CashInfo.txt");
				inventory = ioFile.fileRead("src/StoreGame/Inventory/Storage.txt");
				
				// Storing information
				int bank = Integer.parseInt(totalCash.get(0)) - cashSpent;
				totalCash.set(0, "" + bank);
				inventory.addAll(broughtItems1);
				inventory.addAll(broughtItems2);
				inventory.addAll(broughtItems3);
				inventory.addAll(broughtItems4);
				
				// store the new cash amount
				ioFile.fileWrite(totalCash, "src/StoreGame/CashInfo.txt");  // Writing in new days
				ioFile.fileWrite(inventory, "src/StoreGame/Inventory/Storage.txt");  // Writing new items in inventory
				
				// Refresh screen
				MedicalStore screen = new MedicalStore();
				screen.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);        // turn off screen
			}
		});
		frame.getContentPane().add(btnBuy);
	}
	
	
	
	// Add and remove previous items to the inventory store
	private void storeItems(String item, int amount, int factor, ArrayList<String> listClear)
	{	
		listClear.clear();
		btnBuy.setEnabled(false);
		
		for (int index = 0; index < (amount/factor); index++) {
			if (item == "bandage") {
				broughtItems1.add(item);
				btnBuy.setEnabled(true);
			} else if (item == "medkit") {
				broughtItems2.add(item);
				btnBuy.setEnabled(true);
			} else if (item == "surgical") {
				broughtItems3.add(item);
				btnBuy.setEnabled(true);
			} else if (item == "potion") {
				broughtItems4.add(item);
				btnBuy.setEnabled(true);
			}
		}
	}
	
	
	private void cBoxActions()
	{
		cBox1 = new JComboBox();
		cBox1.setBounds(342, 102, 90, 21);
		cBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash1 = Integer.valueOf(((String)cBox1.getSelectedItem()).replace("x", "")) * 5;
				lbl1.setText("= $" + cash1);
				totalAmount = cash1 + cash2 + cash3 + cash4;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
				 storeItems("bandage", cash1, 5, broughtItems1);
			}
		});
		cBox1.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		cBox1.setMaximumRowCount(9);
		frame.getContentPane().add(cBox1);
		
		
		
		cBox2 = new JComboBox();
		cBox2.setBounds(342, 143, 90, 21);
		cBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash2 = Integer.valueOf(((String)cBox2.getSelectedItem()).replace("x", "")) * 8;
				lbl2.setText("= $" + cash2);
				totalAmount = cash1 + cash2 + cash3 + cash4;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
				storeItems("medkit", cash2, 8, broughtItems2);
			}
		});
		cBox2.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		cBox2.setSelectedIndex(0);
		cBox2.setMaximumRowCount(9);
		frame.getContentPane().add(cBox2);
		
		cBox3 = new JComboBox();
		cBox3.setBounds(342, 193, 90, 21);
		cBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash3 = Integer.valueOf(((String)cBox3.getSelectedItem()).replace("x", "")) * 14;
				lbl3.setText("= $" + cash3);
				totalAmount = cash1 + cash2 + cash3 + cash4;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
				storeItems("surgical", cash3, 14, broughtItems3);
			}
		});
		cBox3.setModel(new DefaultComboBoxModel(new String[] {"0", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		cBox3.setSelectedIndex(0);
		cBox3.setMaximumRowCount(9);
		frame.getContentPane().add(cBox3);
		
		cBox4 = new JComboBox();
		cBox4.setBounds(342, 276, 77, 21);
		cBox4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cash4 = Integer.valueOf(((String)cBox4.getSelectedItem()).replace("x", "")) * 50;
				lbl4.setText("= $" + cash4);
				totalAmount = cash1 + cash2 + cash3 + cash4;
				lblAmount.setText("Selected Amount = $ " + totalAmount);
				storeItems("potion", cash4, 50, broughtItems4);
			}
		});
		cBox4.setModel(new DefaultComboBoxModel(new String[] {"0", "x1"}));
		cBox4.setSelectedIndex(0);
		cBox4.setMaximumRowCount(2);
		frame.getContentPane().add(cBox4);
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
		frame.setUndecorated(false);  // Frame cannot be adjusted during game
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		
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
		
		JLabel lblPlaguePotion = new JLabel("Space Plague Potion");
		lblPlaguePotion.setBounds(59, 280, 218, 13);
		frame.getContentPane().add(lblPlaguePotion);
		
		JLabel label = new JLabel("$5");
		label.setBounds(287, 105, 46, 15);
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
		cBHealth1 = new JProgressBar();
		cBHealth1.setBounds(241, 609, 146, 30);
		frame.getContentPane().add(cBHealth1);
		
		lblCountBandages = new JLabel("New label");
		lblCountBandages.setBounds(586, 105, 112, 15);
		frame.getContentPane().add(lblCountBandages);
		lblCountBandages.setText(Integer.toString(bandage));
		
		lblCountMedkit = new JLabel("New label");
		lblCountMedkit.setBounds(586, 135, 127, 15);
		frame.getContentPane().add(lblCountMedkit);
		lblCountMedkit.setText(Integer.toString(medkit));
		
		lblCountSurgical = new JLabel("New label");
		lblCountSurgical.setBounds(586, 196, 112, 15);
		frame.getContentPane().add(lblCountSurgical);
		lblCountSurgical.setText(Integer.toString(surgical));
		
		lblCountPotion = new JLabel("New label");
		lblCountPotion.setBounds(586, 279, 112, 15);
		frame.getContentPane().add(lblCountPotion);
		lblCountPotion.setText(Integer.toString(potion));

		cBTired1 = new JProgressBar();
		cBTired1.setBounds(241, 673, 146, 30);
		frame.getContentPane().add(cBTired1);
	
		cBHunger1 = new JProgressBar();
		cBHunger1.setBounds(241, 743, 146, 30);
		frame.getContentPane().add(cBHunger1);
		
		cBHealth2 = new JProgressBar();
		cBHealth2.setBounds(446, 609, 146, 36);
		frame.getContentPane().add(cBHealth2);
		
		cBTired2 = new JProgressBar();
		cBTired2.setBounds(458, 673, 134, 30);
		frame.getContentPane().add(cBTired2);
		
		cBHunger2 = new JProgressBar();
		cBHunger2.setBounds(466, 743, 126, 30);
		frame.getContentPane().add(cBHunger2);
	
		cBHealth3 = new JProgressBar();
		cBHealth3.setBounds(644, 603, 146, 52);
		frame.getContentPane().add(cBHealth3);
		
		cBTired3 = new JProgressBar();
		cBTired3.setBounds(644, 667, 146, 52);
		frame.getContentPane().add(cBTired3);

		cBHunger3 = new JProgressBar();
		cBHunger3.setBounds(644, 731, 146, 52);
		frame.getContentPane().add(cBHunger3);

		cBHealth4 = new JProgressBar();
		cBHealth4.setBounds(828, 609, 146, 52);
		frame.getContentPane().add(cBHealth4);
		
		cBTired4 = new JProgressBar();
		cBTired4.setBounds(828, 673, 146, 52);
		frame.getContentPane().add(cBTired4);
	
		cBHunger4 = new JProgressBar();
		cBHunger4.setBounds(825, 731, 146, 52);
		frame.getContentPane().add(cBHunger4);

		msName4 = new JLabel("...");
		msName4.setBounds(828, 777, 127, 23);
		msName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(msName4);

		msName3 = new JLabel("...");
		msName3.setBounds(644, 777, 126, 23);
		msName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(msName3);

		msName2 = new JLabel("...");
		msName2.setBounds(456, 781, 119, 22);
		msName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(msName2);
		
		msName1 = new JLabel("...");
		msName1.setBounds(251, 775, 117, 28);
		msName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().add(msName1);
		
		JLabel labell = new JLabel("Crew Info");
		labell.setBounds(472, 524, 112, 23);
		labell.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(labell);
	
		JLabel label0 = new JLabel("Hunger:");
		label0.setBounds(97, 747, 81, 15);
		label0.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label0);

		JLabel label1 = new JLabel("Tiredness:");
		label1.setBounds(97, 690, 81, 15);
		label1.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label1);
	
		JLabel label2 = new JLabel("Health:");
		label2.setBounds(37, 502, 0, 0);
		label2.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("Name:");
		label3.setBounds(99, 780, 81, 15);
		label3.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label3);

		JLabel label4 = new JLabel("Type:");
		label4.setBounds(97, 587, 81, 15);
		label4.setFont(new Font("Dialog", Font.PLAIN, 16));
		frame.getContentPane().add(label4);

		cBType1 = new JLabel("...");
		cBType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType1.setBounds(258, 571, 129, 30);
		frame.getContentPane().add(cBType1);

		cBType2 = new JLabel("...");
		cBType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType2.setBounds(469, 578, 119, 23);
		frame.getContentPane().add(cBType2);

		cBType3 = new JLabel("...");
		cBType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType3.setBounds(661, 581, 129, 21);
		frame.getContentPane().add(cBType3);
	
		cBType4 = new JLabel("...");
		cBType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		cBType4.setBounds(840, 581, 134, 22);
		frame.getContentPane().add(cBType4);
		
		frame.getContentPane().setLayout(null);
		
		

		//initialize storage arrays
		cBType();
		msName();
		
		cBHealth();
		cBTired();
		cBHunger();
		
		// Button Actions
		btnBuy();
		cBoxActions();
		backToOutpost();
	}
	
	
	/*
	 * Create the application.
	*/
	public MedicalStore() 
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
					MedicalStore window = new MedicalStore();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
