package SearchPlanet;

//Library imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import IOFile.IOFile;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Self implemented
import MainScreen.MainScreen;
import MainScreen.loseGame;
import WindowSettings.Display;
import MainScreen.winGame;


public class ExplorePlanet 
{
	public JFrame frame;
	private JButton btnCheckLoot, btnRecallToShip;
	private JLabel lblCrewMembersLoot;
	
	private String readFile = "StoreGame/ShipInfo"; //file helper string
	private String readStorage = "StoreGame/Inventory/Storage";
	
	
	private void btnBack()
	{
		btnRecallToShip = new JButton("Re-call to ship");
		btnRecallToShip.setVisible(false);
		btnRecallToShip.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		btnRecallToShip.setBounds(370, 635, 193, 88);
		frame.getContentPane().add(btnRecallToShip);
		
		lblCrewMembersLoot = new JLabel("What is found?");
		lblCrewMembersLoot.setBounds(277, 735, 385, 61);
		frame.getContentPane().add(lblCrewMembersLoot);
	}
	
	private void loot()
	{
		btnCheckLoot = new JButton("Show Uncovered Loot");
		btnCheckLoot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				btnCheckLoot.setVisible(false);
				btnRecallToShip.setVisible(true);
				IOFile ioFile = new IOFile();
//				ArrayList<String> member = new ArrayList<String>();
//				ArrayList<String> memberboth = new ArrayList<String>();
//				ArrayList<String> member2 = new ArrayList<String>();
//				String name;
//				String nameboth;
//				String name2;
				//ArrayList<String> type = new ArrayList<String>();
				ArrayList<String> shipInfo = new ArrayList<String>();
				String findPart;
				ArrayList<String> inventory = new ArrayList<String>();
				ArrayList<String> bank = new ArrayList<String>();
				ArrayList<String> updatePart = new ArrayList<String>();
				String count;
				
				
				// changes the member selected file
//				if (character1.isSelected()) {
//					member = ioFile.fileRead(readFile + "MemberOne.txt");
//					tiredRate(member, ioFile, "MemberOne");
//				} 
				
				shipInfo = ioFile.fileRead(readFile + ".txt");
				findPart = shipInfo.get(3);
				if (findPart.equals("false"))
				{
					int x = (int)(Math.random()*((100-0)+0))+0;
					System.out.println(x);
					if (x >= 25) {
						shipInfo.set(3, "true");
						System.out.println("found part");
						ioFile.fileWrite(shipInfo, readFile + ".txt");
						lblCrewMembersLoot.setText("Youve Found a part");
						
						updatePart = ioFile.fileRead("StoreGame/DaysInfo.txt");
						int sub = Integer.parseInt(updatePart.get(1)) - 1;
						updatePart.set(1, "" + sub);
						count = updatePart.get(1);
						ioFile.fileWrite(updatePart, "StoreGame/DaysInfo.txt");
						if (count.equals("0"))
						{
							System.out.println("Congrats! youve found all the parts and ended the game, you WIN!");
							winGame outpost = new winGame();
							outpost.frame.setVisible(true);
							frame.setVisible(false);
						}
						
						
					}
					if(x < 25) {
						inventory = ioFile.fileRead(readStorage + ".txt");
						int y = (int)(Math.random()*((5-1)+1))+1;
						for (int i = 0; i < y; i++) {
							inventory.add("surgical");
							inventory.add("fullMeal");
						}
						
						ioFile.fileWrite(inventory, readStorage + ".txt");
						lblCrewMembersLoot.setText("Youve Found " + y + "x Surgical Packages and Full Meals");
						System.out.println("found some loot, the part is still out there");
					}
					
				}
				if (findPart.equals("true"))
				{
					int x = (int)(Math.random()*((2-0)+0))+0;
					System.out.println(x);
					if (x == 0) {
						inventory = ioFile.fileRead(readStorage + ".txt");
						int y = (int)(Math.random()*((10-5)+5))+5;
						for (int i = 0; i < y; i++) {
							inventory.add("medkit");
							}
						bank = ioFile.fileRead("StoreGame/CashInfo.txt");
						int rand = (int)(Math.random()*((100-50)+50))+50;
						int cash = Integer.parseInt(bank.get(0)) + rand;
						bank.set(0, "" + cash);
						ioFile.fileWrite(bank, "StoreGame/CashInfo.txt");
						ioFile.fileWrite(inventory, readStorage + ".txt");
						lblCrewMembersLoot.setText("Youve Found " + y + "x Medkits and $" + rand);
					if(x == 1) {
						inventory = ioFile.fileRead(readStorage + ".txt");
						int z = (int)(Math.random()*((10-5)+5))+5;
						for (int i = 0; i < z; i++) {
							inventory.add("pizza");
						}
						bank = ioFile.fileRead("StoreGame/CashInfo.txt");
						int rand2 = (int)(Math.random()*((100-50)+50))+50;
						int cash2 = Integer.parseInt(bank.get(0)) + rand2;
						bank.set(0, "" + cash2);
						ioFile.fileWrite(bank, "StoreGame/CashInfo.txt");
						lblCrewMembersLoot.setText("Youve Found " + z + "x Pizza and $" + rand2);
						
						ioFile.fileWrite(inventory, readStorage + ".txt");
						System.out.println("found some loot, the part is still out there");
					}

				}
			}
				
		}});
		frame.getContentPane().setLayout(null);
		btnCheckLoot.setBounds(336, 508, 307, 122);
		frame.getContentPane().add(btnCheckLoot);
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
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
//		frame.setUndecorated(true);  // Frame cannot be adjusted during game
		
		// Initialize displays
		JLabel lblXLaunchesDown = new JLabel("X launches down from the spaceship in the ships rider/glider/shuttle/teleporter.");
		lblXLaunchesDown.setBounds(41, 27, 787, 15);
		frame.getContentPane().add(lblXLaunchesDown);
		
		JLabel lblTheLandscapeIs = new JLabel("The landscape is dusty/murky/clear/mountainous and seems safe for the meantime");
		lblTheLandscapeIs.setBounds(41, 81, 787, 15);
		frame.getContentPane().add(lblTheLandscapeIs);
		
		JLabel lblHoweverThisSoon = new JLabel("However this soon changes when X hears the scratches/howl/rattle of the deadly thresher/goliath/spiderants closing in");
		lblHoweverThisSoon.setBounds(41, 128, 856, 15);
		frame.getContentPane().add(lblHoweverThisSoon);
		
		JButton btnFight = new JButton("Fight");
		btnFight.setBounds(41, 155, 114, 25);
		frame.getContentPane().add(btnFight);
		
		JButton btnBag = new JButton("Bag");
		btnBag.setBounds(200, 155, 114, 25);
		frame.getContentPane().add(btnBag);
		
		JButton btnCrew = new JButton("Crew");
		btnCrew.setBounds(41, 192, 114, 25);
		frame.getContentPane().add(btnCrew);
		
		JButton btnRun = new JButton("Run");
		btnRun.setBounds(200, 192, 114, 25);
		frame.getContentPane().add(btnRun);
		
		JLabel lblFightXDraws = new JLabel("Fight: X draws their reapeater/thumper/scattergun and unloads. Emerging victorious");
		lblFightXDraws.setBounds(41, 309, 787, 15);
		frame.getContentPane().add(lblFightXDraws);
		
		JLabel lblRunXHides = new JLabel("Run: X hides under/in the nearby bush/rock/tree. Emerging unscathed");
		lblRunXHides.setBounds(41, 344, 787, 15);
		frame.getContentPane().add(lblRunXHides);
		
		JLabel lblHavingLocatedThe = new JLabel("Having located the loot locker, X finds");
		lblHavingLocatedThe.setBounds(41, 433, 787, 15);
		frame.getContentPane().add(lblHavingLocatedThe);
		
		JLabel lblHeaapsOfStufff = new JLabel("HEAAPS OF STUFFF :)))))");
		lblHeaapsOfStufff.setBounds(205, 460, 465, 75);
		frame.getContentPane().add(lblHeaapsOfStufff);
		
		JLabel lblBagYou = new JLabel("Bag - You lost your only camo net/sentry/air support beacon in the trip down");
		lblBagYou.setBounds(41, 250, 787, 15);
		frame.getContentPane().add(lblBagYou);
		
		JLabel lblCrewYou = new JLabel("Crew - You have no backup, the rest of the crew is off world");
		lblCrewYou.setBounds(41, 371, 414, 15);
		frame.getContentPane().add(lblCrewYou);
		
		// Back button
		btnBack();
		loot();
	}
	
	
	/*
	 * Create the application.
	*/
	public ExplorePlanet() {
		initialize();
	}
	
	
	/*
	 * Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExplorePlanet window = new ExplorePlanet();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
