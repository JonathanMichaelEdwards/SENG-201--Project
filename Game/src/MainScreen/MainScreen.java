package MainScreen;

//Libary imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JPanel;


//Self implemented
import GameSettings.Display;
import SpaceOutpost.SpaceOutpost;



public class MainScreen
{
	public JFrame frame;
	
	// Setting action buttons to be scoped globally
	private JButton btnSpaceOutpost;
	private JButton btnNewPlanet;
	private JButton btnRepairShields;

	// Stored information that the user has chosen
	public static ArrayList<String> crewType = new ArrayList<String>();
	public static ArrayList<String> crewName = new ArrayList<String>();
	public static String shipType;
	public static String shipName;
	public static int piecesToCollect;
	private JLabel lblDayXy;
	private JLabel lblCrew;
	private JLabel lblTurns;
	private JButton btnExplorePlanet;
	private JButton btnViewuseShipSupplies;
	private JLabel lblShipShields;
	private JButton btnGoToNext;
	private JLabel label_4;
	private JLabel lblNames;
	private JLabel lblHealth;
	private JLabel lblHunger_1;
	private JLabel lblMember1;
	private JProgressBar pBarShipHealth;
	private JProgressBar pBarHunger1;
	private JLabel lblShipType;
	private JLabel lblSp;
	private JLabel lblCrew_1;
	private JProgressBar pBarHealth1;
	private JLabel lblStatus;
	private JLabel lblHunger;
	private JProgressBar pBarStrength1;
	private JLabel lblShipName;
	private JPanel panelCrew;
	private JLabel lblHunger_2;
	private JPanel panelShip;
	private JPanel panel;
	
	String a;
	
	
	// Retrieve data from previous screen
	public void getCrewInfo(ArrayList<String> memberType, ArrayList<String> memberName, int pieces, String shipType, String shipName)
	{
		for (int index = 0; index < memberType.size(); index++) {
			if (index == 0) { 
				crewType.add(memberType.get(index));
				crewName.add(memberName.get(index));
			} else if (index == 1) { 
				crewType.add(memberType.get(index));
				crewName.add(memberName.get(index));
			} else if (index == 2) { 
				crewType.add(memberType.get(index));
				crewName.add(memberName.get(index));
			} else if (index == 3) { 
				crewType.add(memberType.get(index));
				crewName.add(memberName.get(index));
			}
		}
		
		// Storing number of pieces needed to be collected
		piecesToCollect = pieces;
	}
	
	
	// Go to the space outpost screen
	private void spaceOutpost()
	{
		btnSpaceOutpost = new JButton("Space Outpost");
		btnSpaceOutpost.setBounds(389, 148, 263, 75);
		btnSpaceOutpost.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnSpaceOutpost.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				SpaceOutpost outpost = new SpaceOutpost();
				outpost.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);         // turn off screen
			}
		});
	}
	
	
	// Go to the newPlanet screen
	private void newPlanet()
	{
		btnNewPlanet = new JButton("Travel to a new planet");
		btnNewPlanet.setBounds(340, 887, 198, 139);
		btnNewPlanet.setEnabled(false);
		btnNewPlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
	}
	
	
	// Go to the explore planet screen
	private void explorePlanet()
	{
		btnExplorePlanet = new JButton("Explore current planet");
		btnExplorePlanet.setBounds(351, 645, 177, 59);
		btnExplorePlanet.setEnabled(false);
		btnExplorePlanet.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
	}
	
	
	// repai shields
	private void repairShields()
	{
		btnRepairShields = new JButton("Repair Shields!");
		btnRepairShields.setBounds(197, 1025, 169, 33);
		btnRepairShields.setEnabled(false);
		btnRepairShields.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(lblDayXy);
		frame.getContentPane().add(lblCrew);
		frame.getContentPane().add(btnSpaceOutpost);
		frame.getContentPane().add(lblTurns);
		frame.getContentPane().add(btnExplorePlanet);
		frame.getContentPane().add(btnViewuseShipSupplies);
		frame.getContentPane().add(lblShipShields);
		frame.getContentPane().add(btnRepairShields);
		frame.getContentPane().add(btnNewPlanet);
		frame.getContentPane().add(btnGoToNext);
		
		panel = new JPanel();
		panel.setBounds(770, 111, 1012, 593);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		panelShip = new JPanel();
		panelShip.setBounds(23, 42, 530, 170);
		panel.add(panelShip);
		panelShip.setLayout(null);
		
		JLabel label = new JLabel("Name:");
		label.setBounds(60, 71, 55, 15);
		panelShip.add(label);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		label_4 = new JLabel("Type:");
		label_4.setBounds(60, 112, 55, 15);
		panelShip.add(label_4);
		label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblShipName = new JLabel("...");
		lblShipName.setBounds(127, 71, 114, 15);
		panelShip.add(lblShipName);
		lblShipName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblShipType = new JLabel("...");
		lblShipType.setBounds(127, 112, 132, 15);
		panelShip.add(lblShipType);
		lblShipType.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblHealth = new JLabel("Health");
		lblHealth.setBounds(326, 36, 112, 23);
		panelShip.add(lblHealth);
		lblHealth.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		pBarShipHealth = new JProgressBar();
		pBarShipHealth.setBounds(259, 93, 223, 34);
		panelShip.add(pBarShipHealth);
		
		lblSp = new JLabel("Ship Info");
		lblSp.setBounds(175, 6, 84, 20);
		panelShip.add(lblSp);
		lblSp.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(497, 6, 81, 33);
		panel.add(lblStatus);
		lblStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		
		panelCrew = new JPanel();
		panelCrew.setBounds(23, 249, 965, 317);
		panel.add(panelCrew);
		panelCrew.setLayout(null);
		
		pBarHealth1 = new JProgressBar();
		pBarHealth1.setBounds(204, 107, 146, 30);
		panelCrew.add(pBarHealth1);
		
		pBarStrength1 = new JProgressBar();
		pBarStrength1.setBounds(204, 171, 146, 30);
		panelCrew.add(pBarStrength1);
		
		JProgressBar progressBar_4 = new JProgressBar();
		progressBar_4.setBounds(607, 165, 146, 52);
		panelCrew.add(progressBar_4);
		
		JProgressBar progressBar_7 = new JProgressBar();
		progressBar_7.setBounds(791, 171, 146, 52);
		panelCrew.add(progressBar_7);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(409, 229, 146, 52);
		panelCrew.add(progressBar_2);
		
		pBarHunger1 = new JProgressBar();
		pBarHunger1.setBounds(204, 251, 146, 30);
		panelCrew.add(pBarHunger1);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(409, 165, 146, 52);
		panelCrew.add(progressBar_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(409, 101, 146, 52);
		panelCrew.add(progressBar);
		
		JProgressBar progressBar_5 = new JProgressBar();
		progressBar_5.setBounds(607, 229, 146, 52);
		panelCrew.add(progressBar_5);
		
		JProgressBar progressBar_8 = new JProgressBar();
		progressBar_8.setBounds(788, 229, 146, 52);
		panelCrew.add(progressBar_8);
		
		JLabel label_3 = new JLabel("...");
		label_3.setBounds(791, 71, 109, 15);
		panelCrew.add(label_3);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("...");
		label_2.setBounds(626, 71, 109, 15);
		panelCrew.add(label_2);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("...");
		label_1.setBounds(435, 71, 109, 15);
		panelCrew.add(label_1);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblCrew_1 = new JLabel("Crew Info");
		lblCrew_1.setBounds(435, 22, 112, 23);
		panelCrew.add(lblCrew_1);
		lblCrew_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblHunger_2 = new JLabel("Hunger:");
		lblHunger_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblHunger_2.setBounds(60, 245, 81, 15);
		panelCrew.add(lblHunger_2);
		
		lblHunger_1 = new JLabel("Strength:");
		lblHunger_1.setBounds(60, 188, 81, 15);
		panelCrew.add(lblHunger_1);
		lblHunger_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblHunger = new JLabel("Health:");
		lblHunger.setBounds(60, 125, 81, 15);
		panelCrew.add(lblHunger);
		lblHunger.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblNames = new JLabel("Name:");
		lblNames.setBounds(60, 71, 81, 15);
		panelCrew.add(lblNames);
		lblNames.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblMember1 = new JLabel("...");
		lblMember1.setBounds(217, 71, 109, 15);
		panelCrew.add(lblMember1);
		lblMember1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(607, 101, 146, 52);
		panelCrew.add(progressBar_3);
		
		JProgressBar progressBar_6 = new JProgressBar();
		progressBar_6.setBounds(791, 107, 146, 52);
		panelCrew.add(progressBar_6);
	}
	
	
	// go to the nezt day
	private void nextDay()
	{

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
		frame.setUndecorated(true);  // Frame cannot be adjusted during game
//		frame.setResizable(false);
		
		
//		lblShipName.setText("1"); getting error
		
		// Initializing displays
		lblShipShields = new JLabel("Ship Shields");
		lblShipShields.setBounds(214, 887, 114, 44);
		lblCrew = new JLabel("Crew");
		lblCrew.setBounds(79, 433, 41, 13);
		lblTurns = new JLabel("Turns");
		lblTurns.setBounds(179, 691, 46, 13);
		lblDayXy = new JLabel("Day x");
		lblDayXy.setBounds(100, 193, 46, 13);
		
		btnGoToNext = new JButton("Sleep crew to next day");
		btnGoToNext.setBounds(601, 997, 223, 21);
		btnGoToNext.setEnabled(false);
		
		
		// Might not be a button (might not)
		btnViewuseShipSupplies = new JButton("View/Use Ship Supplies");
		btnViewuseShipSupplies.setBounds(253, 748, 275, 122);
		btnViewuseShipSupplies.setEnabled(false);
		////
		
		
		// Button Actions
		spaceOutpost();
		newPlanet();
		explorePlanet();
		repairShields();
		nextDay();
	}
	
	
	/*
	 * Create the application.
	*/
	public MainScreen() 
	{
		initialize();
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
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public void getA(String string) 
	{
		lblShipName.setText(string);
		a = string;
	}
}