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
	
	private int cashSpent, totalAmount, cash1, cash2, cash3, cash4, cash5 = 0;
	private JLabel msType1, msType2, msType3, msType4;
	private JLabel msName1, msName2, msName3, msName4;
	
	
	private JProgressBar msHealth1, msHealth2, msHealth3, msHealth4;
	private JProgressBar msTired1, msTired2, msTired3, msTired4;
	private JProgressBar msHunger1, msHunger2, msHunger3, msHunger4;
	
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
	private void msHealth() 
	{
		health[0] = msHealth1;
		health[1] = msHealth2;
		health[2] = msHealth3;
		health[3] = msHealth4;
	}
	
	private void msTired() 
	{
		tiredness[0] = msTired1;
		tiredness[1] = msTired2;
		tiredness[2] = msTired3;
		tiredness[3] = msTired4;
	}
	
	private void msHunger() 
	{
		hunger[0] = msHunger1;
		hunger[1] = msHunger2;
		hunger[2] = msHunger3;
		hunger[3] = msHunger4;
	}
	
	
	// Stores crew details in data arrays so it can be used easily
	private void msType() 
	{
		
		type[0] = msType1;
		type[1] = msType2;
		type[2] = msType3;
		type[3] = msType4;
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
		
		JLabel lblPlaguePotion = new JLabel("Space Plague Potion");
		lblPlaguePotion.setBounds(59, 280, 218, 13);
		frame.getContentPane().add(lblPlaguePotion);
		
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
		msHealth1 = new JProgressBar();
		msHealth1.setBounds(241, 609, 146, 30);
		frame.getContentPane().add(msHealth1);

		msTired1 = new JProgressBar();
		msTired1.setBounds(241, 673, 146, 30);
		frame.getContentPane().add(msTired1);
	

		msHunger1 = new JProgressBar();
		msHunger1.setBounds(241, 743, 146, 30);
		frame.getContentPane().add(msHunger1);
		
	
		msHealth2 = new JProgressBar();
		msHealth2.setBounds(446, 609, 146, 36);
		frame.getContentPane().add(msHealth2);
		

		msTired2 = new JProgressBar();
		msTired2.setBounds(458, 673, 134, 30);
		frame.getContentPane().add(msTired2);
		
	
		msHunger2 = new JProgressBar();
		msHunger2.setBounds(466, 743, 126, 30);
		frame.getContentPane().add(msHunger2);
	

		msHealth3 = new JProgressBar();
		msHealth3.setBounds(644, 603, 146, 52);
		frame.getContentPane().add(msHealth3);
		
	
		msTired3 = new JProgressBar();
		msTired3.setBounds(644, 667, 146, 52);
		frame.getContentPane().add(msTired3);

		msHunger3 = new JProgressBar();
		msHunger3.setBounds(644, 731, 146, 52);
		frame.getContentPane().add(msHunger3);



		msHealth4 = new JProgressBar();
		msHealth4.setBounds(828, 609, 146, 52);
		frame.getContentPane().add(msHealth4);
		
	
		msTired4 = new JProgressBar();
		msTired4.setBounds(828, 673, 146, 52);
		frame.getContentPane().add(msTired4);
		
	
		msHunger4 = new JProgressBar();
		msHunger4.setBounds(825, 731, 146, 52);
		frame.getContentPane().add(msHunger4);

		msName4 = new JLabel("...");
		msName4.setFont(new Font("Dialog", Font.PLAIN, 18));
		msName4.setBounds(828, 777, 127, 23);
		frame.getContentPane().add(msName4);

		msName3 = new JLabel("...");
		msName3.setFont(new Font("Dialog", Font.PLAIN, 18));
		msName3.setBounds(644, 777, 126, 23);
		frame.getContentPane().add(msName3);

		msName2 = new JLabel("...");
		msName2.setFont(new Font("Dialog", Font.PLAIN, 18));
		msName2.setBounds(456, 781, 119, 22);
		frame.getContentPane().add(msName2);
		
		msName1 = new JLabel("...");
		msName1.setFont(new Font("Dialog", Font.PLAIN, 18));
		msName1.setBounds(251, 775, 117, 28);
		frame.getContentPane().add(msName1);
		
		JLabel labell = new JLabel("Crew Info");
		labell.setFont(new Font("Dialog", Font.PLAIN, 16));
		labell.setBounds(472, 524, 112, 23);
		frame.getContentPane().add(labell);
	

		JLabel label0 = new JLabel("Hunger:");
		label0.setFont(new Font("Dialog", Font.PLAIN, 16));
		label0.setBounds(97, 747, 81, 15);
		frame.getContentPane().add(label0);

		JLabel label1 = new JLabel("Tiredness:");
		label1.setFont(new Font("Dialog", Font.PLAIN, 16));
		label1.setBounds(97, 690, 81, 15);
		frame.getContentPane().add(label1);
	

		JLabel label2 = new JLabel("Health:");
		label2.setLocation(37, 502);
		label2.setFont(new Font("Dialog", Font.PLAIN, 16));
		label.setBounds(60, 125, 81, 15);
		frame.getContentPane().add(label2);
		
		
		JLabel label3 = new JLabel("Name:");
		label3.setFont(new Font("Dialog", Font.PLAIN, 16));
		label3.setBounds(99, 780, 81, 15);
		frame.getContentPane().add(label3);

	

		


		JLabel label4 = new JLabel("Type:");
		label4.setFont(new Font("Dialog", Font.PLAIN, 16));
		label4.setBounds(97, 587, 81, 15);
		frame.getContentPane().add(label4);

		msType1 = new JLabel("...");
		msType1.setFont(new Font("Dialog", Font.PLAIN, 18));
		msType1.setBounds(258, 571, 129, 30);
		frame.getContentPane().add(msType1);

		msType2 = new JLabel("...");
		msType2.setFont(new Font("Dialog", Font.PLAIN, 18));
		msType2.setBounds(469, 578, 119, 23);
		frame.getContentPane().add(msType2);

		msType3 = new JLabel("...");
		msType3.setFont(new Font("Dialog", Font.PLAIN, 18));
		msType3.setBounds(661, 581, 129, 21);
		frame.getContentPane().add(msType3);
	

		msType4 = new JLabel("...");
		msType4.setFont(new Font("Dialog", Font.PLAIN, 18));
		msType4.setBounds(840, 581, 134, 22);
		frame.getContentPane().add(msType4);
		
		frame.getContentPane().setLayout(null);
		
		

		//initialize storage arrays
		msType();
		msName();
		
		msHealth();
		msTired();
		msHunger();
		
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
