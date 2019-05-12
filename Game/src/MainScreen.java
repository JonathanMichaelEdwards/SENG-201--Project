import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 973, 654);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Space Outpost");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(313, 20, 263, 75);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnTravelToA = new JButton("Travel to a new planet");
		btnTravelToA.setBounds(730, 403, 169, 139);
		frame.getContentPane().add(btnTravelToA);
		
		JButton btnViewuseShipSupplies = new JButton("View/Use Ship Supplies");
		btnViewuseShipSupplies.setBounds(635, 144, 275, 122);
		frame.getContentPane().add(btnViewuseShipSupplies);
		
		JButton btnRepairShields = new JButton("Repair Shields!");
		btnRepairShields.setBounds(46, 475, 169, 33);
		frame.getContentPane().add(btnRepairShields);
		
		JLabel lblShipShields = new JLabel("Ship Shields");
		lblShipShields.setBounds(94, 403, 114, 44);
		frame.getContentPane().add(lblShipShields);
		
		JLabel lblCrew = new JLabel("Crew");
		lblCrew.setBounds(84, 229, 41, 13);
		frame.getContentPane().add(lblCrew);
		
		JButton btnExploreCurrentPlanet = new JButton("Explore current planet");
		btnExploreCurrentPlanet.setBounds(348, 229, 177, 59);
		frame.getContentPane().add(btnExploreCurrentPlanet);
		
		JButton btnGoToNext = new JButton("Sleep crew to next day");
		btnGoToNext.setBounds(374, 521, 151, 21);
		frame.getContentPane().add(btnGoToNext);
		
		JLabel lblTurns = new JLabel("Turns");
		lblTurns.setBounds(152, 229, 46, 13);
		frame.getContentPane().add(lblTurns);
		
		JLabel lblDayXy = new JLabel("Day x");
		lblDayXy.setBounds(22, 20, 46, 13);
		frame.getContentPane().add(lblDayXy);
		
		
		
	}
}
