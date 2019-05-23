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
	private JButton btnCheckLoot, btnRecallToShip, btnFight, btnBag, btnRun, btnCrew, btnContinue;
	private JLabel lblCrewMembersLoot, lblCrewYou, lblBagYou, lblRunXHides, lblFightXDraws, lblHavingLocatedThe;
	
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
		btnRecallToShip.setBounds(1037, 537, 193, 88);
		frame.getContentPane().add(btnRecallToShip);
		
		lblCrewMembersLoot = new JLabel("What is found?");
		lblCrewMembersLoot.setVisible(false);
		lblCrewMembersLoot.setBounds(336, 440, 654, 25);
		frame.getContentPane().add(lblCrewMembersLoot);
	}
	
	private void loot()
	{
		btnCheckLoot = new JButton("Show Uncovered Loot");
		btnCheckLoot.setVisible(false);
		btnCheckLoot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				btnCheckLoot.setVisible(false);
				btnRecallToShip.setVisible(true);
				IOFile ioFile = new IOFile();
				IOFile ioFile1 = new IOFile();
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
				ArrayList<String> inventory2 = new ArrayList<String>();
				ArrayList<String> bank = new ArrayList<String>();
				ArrayList<String> bank1 = new ArrayList<String>();
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
						lblCrewMembersLoot.setText("You've Found this planets part!");
						
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
						lblCrewMembersLoot.setText("Youve Found " + y + "x Surgical Packages and Full Meals, these will completely fill up the health/hunger bars respectively");
						System.out.println("found some loot, the part is still out there");
					}
					
				}
				if (findPart.equals("true"))
				{
					int x = (int)(Math.random()*((2-0)+0))+0;
					System.out.println("You already have this planets piece");
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
						lblCrewMembersLoot.setText("Youve Found " + y + "x Medkits, this will partially restore health and $" + rand);
					}
					
					else if (x == 1) {

						inventory2 = ioFile1.fileRead(readStorage + ".txt");
						int z = (int)(Math.random()*((10-5)+5))+5;
						for (int i = 0; i < z; i++) {
							inventory2.add("pizza");
						}
						bank1 = ioFile1.fileRead("StoreGame/CashInfo.txt");
						int rand2 = (int)(Math.random()*((100-50)+50))+50;
						int cash2 = Integer.parseInt(bank1.get(0)) + rand2;
						bank1.set(0, "" + cash2);
						ioFile1.fileWrite(bank1, "StoreGame/CashInfo.txt");
						ioFile1.fileWrite(inventory2, readStorage + ".txt");
						lblCrewMembersLoot.setText("Youve Found " + z + "x Pizza, this will partially restore hunger and $" + rand2);
						ioFile1.fileWrite(inventory2, readStorage + ".txt");
					}

				}
			}
				
		});
		frame.getContentPane().setLayout(null);
		btnCheckLoot.setBounds(336, 508, 307, 122);
		frame.getContentPane().add(btnCheckLoot);
		
	}
	/*
	 * Initialize the contents of the frame.
	*/
	String transport;
	String terrain;
	String weapon;
	String sound;
	String hunter;
	String hide;
	String item;
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
		int x1 = (int)(Math.random()*((4-0)+0))+0;
		if (x1 == 0)
		{
			transport = "rider.";
		}
		if (x1 == 1)
		{
			transport = "glider.";
		}
		if (x1 == 2)
		{
			transport = "shuttle.";
		}
		if (x1 == 3)
		{
			transport = "teleporter.";
		}
			
		JLabel lblXLaunchesDown = new JLabel("<html>X launches down from the spaceship in the ships " + transport + "</html>");
		lblXLaunchesDown.setBounds(41, 27, 787, 15);
		frame.getContentPane().add(lblXLaunchesDown);
		int x2 = (int)(Math.random()*((4-0)+0))+0;
		if (x2 == 0)
		{
			terrain = " dusty ";
		}
		if (x2 == 1)
		{
			terrain = " murky ";
		}
		if (x2 == 2)
		{
			terrain = " clear ";
		}
		if (x2 == 3)
		{
			terrain = " mountainous ";
		}
		JLabel lblTheLandscapeIs = new JLabel("<html>The landscape is" + terrain + "and seems safe for the meantime</html>");
		lblTheLandscapeIs.setBounds(41, 81, 787, 15);
		frame.getContentPane().add(lblTheLandscapeIs);
		
		int x3 = (int)(Math.random()*((4-0)+0))+0;
		if (x3 == 0)
		{
			hunter = " thresher";
		}
		if (x3 == 1)
		{
			hunter = " goliath";
		}
		if (x3 == 2)
		{
			hunter = " spiderant";
		}
		if (x3 == 3)
		{
			hunter = " varkids";
		}
		int x4 = (int)(Math.random()*((4-0)+0))+0;
		if (x4 == 0)
		{
			sound = " scratches ";
		}
		if (x4 == 1)
		{
			sound = " howl ";
		}
		if (x4 == 2)
		{
			sound = " rattle ";
		}
		if (x4 == 3)
		{
			sound = " pattering ";
		}
		JLabel lblHoweverThisSoon = new JLabel("<html>However this soon changes when X hears the" + sound + "of the deadly" + hunter + "closing in</html>");
		lblHoweverThisSoon.setBounds(41, 128, 856, 15);
		frame.getContentPane().add(lblHoweverThisSoon);
		
		
		
		btnBag = new JButton("Bag");
		btnBag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBag.setEnabled(false);
				int x = (int)(Math.random()*((4-0)+0))+0;
				if (x == 0){
					item = " a bunch of wrinkly wrappers... ";
				}
				if (x == 1){
					item = " a handful of rusty screws... ";
				}
				if (x == 2){
					item = " a dirty hat... ";
				}
				if (x == 3){
					item = " a broken invisi-net... ";
				}
				
				
				lblBagYou.setText("<html>Bag - X didnt expect this sort of hostility, reaching into the bag, X finds" + item + "how useless!</html>");
			}
		});
		
		btnBag.setBounds(200, 155, 114, 25);
		frame.getContentPane().add(btnBag);
		


		btnCrew = new JButton("Crew");
		btnCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCrew.setEnabled(false);
				lblCrewYou.setText("<html>Crew - You have no backup, the rest of the crew is off world</html>");
			}
		});
		btnCrew.setBounds(41, 192, 114, 25);
		frame.getContentPane().add(btnCrew);
		
		

		btnFight = new JButton("Fight");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBag.setEnabled(false);
				btnCrew.setEnabled(false);
				btnRun.setEnabled(false);
				btnFight.setEnabled(false);
				int x = (int)(Math.random()*((4-0)+0))+0;
				if (x == 0){
					weapon = " repeater ";
				}
				if (x == 1){
					weapon = " thumper ";
				}
				if (x == 2){
					weapon = " scattergun ";
				}
				if (x == 3){
					weapon = " helix ";
				}
				lblFightXDraws.setText("<html>Fight: X draws their" + weapon + "and unloads into the"+ hunter + ". Emerging victorious</html>");
				btnContinue.setVisible(true);

			}
		});
		btnFight.setBounds(41, 155, 114, 25);
		frame.getContentPane().add(btnFight);
		

		btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBag.setEnabled(false);
				btnCrew.setEnabled(false);
				btnFight.setEnabled(false);
				btnRun.setEnabled(false);
				
				int x = (int)(Math.random()*((4-0)+0))+0;
				if (x == 0){
					hide = " bush ";
				}
				if (x == 1){
					hide = " rock ";
				}
				if (x == 2){
					hide = " crevasse ";
				}
				if (x == 3){
					hide = " cave ";
				}
				
				
				lblRunXHides.setText("<html>Run: X quickly hides by the nearby" + hide + ". Emerging later unscathed</html>");
				btnContinue.setVisible(true);
			}
		});
		btnRun.setBounds(200, 192, 114, 25);
		frame.getContentPane().add(btnRun);
		
		btnContinue = new JButton("Continue");
		btnContinue.setVisible(false);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCrewMembersLoot.setVisible(true);
				btnCheckLoot.setVisible(true);
				lblHavingLocatedThe.setText("<html>Having located the loot locker, X finds</html>");
				btnContinue.setVisible(false);
			}
		});
		btnContinue.setBounds(440, 410, 114, 25);
		frame.getContentPane().add(btnContinue);
		
		
		
		lblFightXDraws = new JLabel("");
		lblFightXDraws.setBounds(41, 270, 423, 47);
		frame.getContentPane().add(lblFightXDraws);
		
		lblRunXHides = new JLabel("");
		lblRunXHides.setBounds(503, 356, 423, 47);
		frame.getContentPane().add(lblRunXHides);
		
		lblHavingLocatedThe = new JLabel("");
		lblHavingLocatedThe.setBounds(41, 440, 300, 15);
		frame.getContentPane().add(lblHavingLocatedThe);
		
		lblBagYou = new JLabel("");
		lblBagYou.setBounds(503, 270, 423, 47);
		frame.getContentPane().add(lblBagYou);
		
		lblCrewYou = new JLabel("");
		lblCrewYou.setBounds(41, 356, 423, 47);
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
