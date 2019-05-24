package SearchPlanet;

//Library imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

import IOFile.IOFile;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Self implemented
import MainScreen.MainScreen;
import MainScreen.loseGame;
import WindowSettings.Display;
import MainScreen.winGame;
import SetUpScreens.ChooseDays;

import javax.swing.SwingConstants;


public class ExplorePlanet 
{
	public JFrame frmEliteDangerousBeta;
	private JButton btnCheckLoot, btnRecallToShip, btnFight, btnBag, btnRun, btnCrew, btnContinue;
	private JLabel lblCrewMembersLoot, lblCrewYou, lblBagYou, lblRunXHides, lblFightXDraws, lblHavingLocatedThe;
	
	private String readFile = "src/StoreGame/ShipInfo"; //file helper string
	private String readStorage = "src/StoreGame/Inventory/Storage";
	private JLabel lblNewLabel;
	
	
	private void btnBack()
	{
		btnRecallToShip = new JButton("Re-call to ship");
		btnRecallToShip.setVisible(false);
		btnRecallToShip.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainScreen screen = new MainScreen();
				screen.frmEliteDangerousBeta.setVisible(true);    // turn on screen
				frmEliteDangerousBeta.setVisible(false);          // turn off screen
			}
		});
		btnRecallToShip.setBounds(1037, 537, 193, 88);
		frmEliteDangerousBeta.getContentPane().add(btnRecallToShip);
		
		lblCrewMembersLoot = new JLabel("What is found?");
		lblCrewMembersLoot.setOpaque(true);
		lblCrewMembersLoot.setVisible(false);
		lblCrewMembersLoot.setBounds(674, 436, 654, 30);
		frmEliteDangerousBeta.getContentPane().add(lblCrewMembersLoot);
	}
	
	private void loot()
	{
		btnCheckLoot = new JButton("Show Uncovered Loot");
		btnCheckLoot.setVisible(false);
		btnCheckLoot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				lblHavingLocatedThe.setVisible(false);
				btnCheckLoot.setVisible(false);
				btnRecallToShip.setVisible(true);
				IOFile ioFile = new IOFile();
				IOFile ioFile1 = new IOFile();

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
						
						updatePart = ioFile.fileRead("src/StoreGame/DaysInfo.txt");
						int sub = Integer.parseInt(updatePart.get(1)) - 1;
						updatePart.set(1, "" + sub);
						count = updatePart.get(1);
						ioFile.fileWrite(updatePart, "src/StoreGame/DaysInfo.txt");
						if (count.equals("0"))
						{
							System.out.println("Congrats! youve found all the parts and ended the game, you WIN!");
							winGame outpost = new winGame();
							outpost.frame.setVisible(true);
							frmEliteDangerousBeta.setVisible(false);
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
						bank = ioFile.fileRead("src/StoreGame/CashInfo.txt");
						int rand = (int)(Math.random()*((100-50)+50))+50;
						int cash = Integer.parseInt(bank.get(0)) + rand;
						bank.set(0, "" + cash);
						ioFile.fileWrite(bank, "src/StoreGame/CashInfo.txt");
						ioFile.fileWrite(inventory, readStorage + ".txt");
						lblCrewMembersLoot.setText("Youve Found " + y + "x Medkits, this will partially restore health and $" + rand);
					}
					
					else if (x == 1) {

						inventory2 = ioFile1.fileRead(readStorage + ".txt");
						int z = (int)(Math.random()*((10-5)+5))+5;
						for (int i = 0; i < z; i++) {
							inventory2.add("pizza");
						}

						bank = ioFile.fileRead("src/StoreGame/CashInfo.txt");
						int rand2 = (int)(Math.random()*((100-50)+50))+50;
						int cash2 = Integer.parseInt(bank.get(0)) + rand2;
						bank.set(0, "" + cash2);
						ioFile.fileWrite(bank, "src/StoreGame/CashInfo.txt");

						lblCrewMembersLoot.setText("Youve Found " + z + "x Pizza, this will partially restore hunger and $" + rand2);
						ioFile1.fileWrite(inventory2, readStorage + ".txt");
					}

				}
			}
				
		});
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		btnCheckLoot.setBounds(336, 508, 307, 122);
		frmEliteDangerousBeta.getContentPane().add(btnCheckLoot);
		
		System.out.println("make pic");
		//		frame.setUndecorated(true);  // Frame cannot be adjusted during game
				
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		frmEliteDangerousBeta.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(ChooseDays.class.getResource("/gameImages/dusty.jpg")));
		

		
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
		frmEliteDangerousBeta = new JFrame();
		frmEliteDangerousBeta.setTitle("Elite Dangerous beta");
		Display display = new Display();  // Retrieving game window size

		// Setting frame of window
		frmEliteDangerousBeta.setBounds(display.x, display.y, display.width, display.height);
		frmEliteDangerousBeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliteDangerousBeta.setResizable(false);
		frmEliteDangerousBeta.getContentPane().setLayout(null);
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
			
		JLabel lblXLaunchesDown = new JLabel("<html>Your Crew member launches down from the spaceship in the ships " + transport + "</html>");
		lblXLaunchesDown.setOpaque(true);
		lblXLaunchesDown.setHorizontalAlignment(SwingConstants.CENTER);
		lblXLaunchesDown.setBounds(429, 28, 787, 30);
		frmEliteDangerousBeta.getContentPane().add(lblXLaunchesDown);
		int x2 = (int)(Math.random()*((4-0)+0))+0;
		if (x2 == 0)
		{
			terrain = " dusty ";
			System.out.println("dusty");

		}
		if (x2 == 1)
		{
			terrain = " murky ";
			System.out.println("murky");

		}
		if (x2 == 2)
		{
			terrain = " clear ";
			System.out.println("clear");

		}
		if (x2 == 3)
		{
			terrain = " mountainous ";
			System.out.println("mountanous");
		}
		JLabel lblTheLandscapeIs = new JLabel("<html>The landscape is" + terrain + "and seems safe for the meantime</html>");
		lblTheLandscapeIs.setOpaque(true);
		lblTheLandscapeIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheLandscapeIs.setBounds(429, 82, 787, 30);
		frmEliteDangerousBeta.getContentPane().add(lblTheLandscapeIs);
		
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
		JLabel lblHoweverThisSoon = new JLabel("<html>However this soon changes when your Crew member hears the" + sound + "of the deadly" + hunter + "closing in</html>");
		lblHoweverThisSoon.setOpaque(true);
		lblHoweverThisSoon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoweverThisSoon.setBounds(429, 129, 787, 30);
		frmEliteDangerousBeta.getContentPane().add(lblHoweverThisSoon);
		
		
		
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
				
				lblBagYou.setVisible(true);
				lblBagYou.setText("<html>Bag - Your Crew member didnt expect this sort of hostility, reaching into the bag, your Crew member finds" + item + "how useless!</html>");
			}
		});
		
		btnBag.setBounds(863, 171, 114, 30);
		frmEliteDangerousBeta.getContentPane().add(btnBag);
		


		btnCrew = new JButton("Crew");
		btnCrew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCrew.setEnabled(false);
				lblCrewYou.setVisible(true);
				lblCrewYou.setText("<html>Crew - You have no backup, the rest of the crew is off world</html>");
			}
		});
		btnCrew.setBounds(704, 208, 114, 30);
		frmEliteDangerousBeta.getContentPane().add(btnCrew);
		
		

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
				lblFightXDraws.setVisible(true);
				lblFightXDraws.setText("<html>Fight: Your Crew member draws their" + weapon + "and unloads into the"+ hunter + ". Emerging victorious</html>");
				btnContinue.setVisible(true);

			}
		});
		btnFight.setBounds(704, 171, 114, 30);
		frmEliteDangerousBeta.getContentPane().add(btnFight);
		

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
				
				lblRunXHides.setVisible(true);
				lblRunXHides.setText("<html>Run: Your Crew member quickly hides by the nearby" + hide + ". Emerging later unscathed</html>");
				
				btnContinue.setVisible(true);
			}
		});
		btnRun.setBounds(863, 208, 114, 30);
		frmEliteDangerousBeta.getContentPane().add(btnRun);
		
		btnContinue = new JButton("Continue");
		btnContinue.setVisible(false);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblCrewMembersLoot.setVisible(true);
				btnCheckLoot.setVisible(true);
				lblHavingLocatedThe.setVisible(true);
				lblHavingLocatedThe.setText("<html>Having located the loot locker, your Crew member finds</html>");
				btnContinue.setVisible(false);
			}
		});
		btnContinue.setBounds(440, 401, 114, 30);
		frmEliteDangerousBeta.getContentPane().add(btnContinue);
		
		
		
		lblFightXDraws = new JLabel("");
		lblFightXDraws.setOpaque(true);
		lblFightXDraws.setVisible(false);
		lblFightXDraws.setBounds(370, 244, 423, 47);
		frmEliteDangerousBeta.getContentPane().add(lblFightXDraws);
		
		lblRunXHides = new JLabel("");
		lblRunXHides.setOpaque(true);
		lblRunXHides.setVisible(false);
		lblRunXHides.setBounds(832, 330, 423, 47);
		frmEliteDangerousBeta.getContentPane().add(lblRunXHides);
		
		lblHavingLocatedThe = new JLabel("");
		lblHavingLocatedThe.setOpaque(true);
		lblHavingLocatedThe.setVisible(false);
		lblHavingLocatedThe.setBounds(362, 436, 300, 30);
		frmEliteDangerousBeta.getContentPane().add(lblHavingLocatedThe);
		
		lblBagYou = new JLabel("");
		lblBagYou.setOpaque(true);
		lblBagYou.setVisible(false);
		lblBagYou.setBounds(832, 244, 423, 47);
		frmEliteDangerousBeta.getContentPane().add(lblBagYou);
		
		lblCrewYou = new JLabel("");
		lblCrewYou.setOpaque(true);
		lblCrewYou.setVisible(false);
		lblCrewYou.setBounds(370, 330, 423, 47);
		frmEliteDangerousBeta.getContentPane().add(lblCrewYou);
		
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
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
