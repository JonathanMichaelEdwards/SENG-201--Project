package RandomEvents;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import IOFile.IOFile;
import MainScreen.MainScreen;
import NewPlanet.TravelPlanet;
import WindowSettings.Display;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class spacePlague {

	public JFrame frmEliteDangerousBeta;

	private JButton btnCheckInfection, btnLetsGetGoing;
	private String readFile = "src/StoreGame/CrewSelected/";	

	
	private JLabel lblCrewMembersInfected;
	private void btnBack()
	{
		btnLetsGetGoing = new JButton("Back to Base");
		btnLetsGetGoing.setVisible(false);
		btnLetsGetGoing.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainScreen screen = new MainScreen();
				screen.frmEliteDangerousBeta.setVisible(true);    // turn on screen
				frmEliteDangerousBeta.setVisible(false);          // turn off screen
			}
		});
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		btnLetsGetGoing.setBounds(940, 700, 250, 100);
		frmEliteDangerousBeta.getContentPane().add(btnLetsGetGoing);
		
		lblCrewMembersInfected = new JLabel("Crew Members infected :");
		lblCrewMembersInfected.setOpaque(true);
		lblCrewMembersInfected.setFont(new Font("Dialog", Font.BOLD, 19));
		lblCrewMembersInfected.setBounds(940, 615, 510, 61);
		frmEliteDangerousBeta.getContentPane().add(lblCrewMembersInfected);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(spacePlague.class.getResource("/gameImages/plague.png")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		frmEliteDangerousBeta.getContentPane().add(lblNewLabel);
	}

	private void infection()
	{
		btnCheckInfection = new JButton("Check Scan of who is infected");
		btnCheckInfection.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				IOFile ioFile = new IOFile();
				ArrayList<String> member = new ArrayList<String>();
				ArrayList<String> memberboth = new ArrayList<String>();
				ArrayList<String> member2 = new ArrayList<String>();
				String name;
				String nameboth;
				String name2;
				ArrayList<String> type = new ArrayList<String>();
				
//				((max - min)+min))+min
				int x = (int)(Math.random()*((3-0)+0))+0;
	
				if (x == 1) {
					System.out.println("selects 1 fella");
					member = ioFile.fileRead(readFile + "MemberOne.txt");
					member.set(4, "true");
					
					int health = Integer.parseInt(member.get(0)) - 30;
					member.set(0, "" + health);
					
					if (health <= 0)
					{
						member.set(7, "dead");
						member.set(0, "" + 0);
						member.set(1, "" + 0);
						member.set(2, "" + 0);
						member.set(3, "" + 0); //if dead no more turns
					}

					
					ioFile.fileWrite(member, readFile + "MemberOne.txt");
					btnCheckInfection.setEnabled(false);
					name = member.get(5);
					lblCrewMembersInfected.setText("<html>" + name + " is Infected</html>");
					btnLetsGetGoing.setVisible(true);
				}
				if (x == 0) {
					System.out.println("selects both fella");

					member = ioFile.fileRead(readFile + "MemberOne.txt");
					memberboth = ioFile.fileRead(readFile + "MemberTwo.txt");
					member.set(4, "true");
					memberboth.set(4, "true");
					
					int health = Integer.parseInt(member.get(0)) - 30;
					int healthboth = Integer.parseInt(memberboth.get(0)) - 30;
					if (health <= 0)
					{
						member.set(7, "dead");
						member.set(0, "" + 0);
						member.set(1, "" + 0);
						member.set(2, "" + 0);
						member.set(3, "" + 0); //if dead no more turns
					}
					if (healthboth <= 0)
					{
						memberboth.set(7, "dead");
						memberboth.set(0, "" + 0);
						memberboth.set(1, "" + 0);
						memberboth.set(2, "" + 0);
						memberboth.set(3, "" + 0); //if dead no more turns
					}
					member.set(0, "" + health);
					memberboth.set(0, "" + healthboth);
					ioFile.fileWrite(member, readFile + "MemberOne.txt");
					ioFile.fileWrite(memberboth, readFile + "MemberTwo.txt");
					btnCheckInfection.setEnabled(false);
					name = member.get(5);
					nameboth = memberboth.get(5);
					lblCrewMembersInfected.setText("<html>Both " + name + " and " + nameboth + " are infected/<html>");
					btnLetsGetGoing.setVisible(true);
					
				}
				if (x == 2){
					System.out.println("selects 2nd fella");

					member2 = ioFile.fileRead(readFile + "MemberTwo.txt");
					member2.set(4, "true");
					int health = Integer.parseInt(member2.get(0)) - 30;
					member2.set(0, "" + health);
					if (health <= 0)
					{
						member2.set(7, "dead");
						member2.set(0, "" + 0);
						member.set(1, "" + 0);
						member.set(2, "" + 0);
						member2.set(3, "" + 0); //if dead no more turns
					}
					btnCheckInfection.setEnabled(false);
					name2 = member2.get(5);
					lblCrewMembersInfected.setText("<html>" + name2 + " is Infected</html>");
					btnLetsGetGoing.setVisible(true);
				}
			}
		});
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		btnCheckInfection.setBounds(1200, 700, 250, 100);
		frmEliteDangerousBeta.getContentPane().add(btnCheckInfection);
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					spacePlague window = new spacePlague();
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public spacePlague() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEliteDangerousBeta = new JFrame();
		frmEliteDangerousBeta.setTitle("Elite Dangerous beta");
		Display display = new Display();
		frmEliteDangerousBeta.setBounds(display.x, display.y, display.width, display.height);
		frmEliteDangerousBeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliteDangerousBeta.setResizable(false);
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		
		JLabel lblFdf = new JLabel("<html>The re-emergence of the Space Plague took the craft while we were sleeping! I'll scan the crew members quickly, one or more of your crew has been infected and must be treated immediately! Use Plague Potion in your inventory or if you don't have it,  purchase Plague Potion from the Outpost. We must contain the spread before it gets worse, each crew member will lose 30hp every new day they are infected.</html>");
		lblFdf.setOpaque(true);
		lblFdf.setFont(new Font("Dialog", Font.BOLD, 19));
		lblFdf.setBounds(526, 332, 905, 204);
		frmEliteDangerousBeta.getContentPane().add(lblFdf);
		
		JLabel lblSpacePlague = new JLabel("Space Plague");
		lblSpacePlague.setOpaque(true);
		lblSpacePlague.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpacePlague.setFont(new Font("Dialog", Font.BOLD, 24));
		lblSpacePlague.setBounds(650, 50, 600, 50);
		frmEliteDangerousBeta.getContentPane().add(lblSpacePlague);
		
		
		infection();
		btnBack();
	}
}
