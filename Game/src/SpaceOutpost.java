import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class SpaceOutpost {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SpaceOutpost window = new SpaceOutpost();
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
	public SpaceOutpost() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1008, 594);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToYour = new JLabel("Welcome to your local Space Station");
		lblWelcomeToYour.setBounds(348, 47, 444, 45);
		frame.getContentPane().add(lblWelcomeToYour);
		
		JLabel lblCrew = new JLabel("Crew");
		lblCrew.setBounds(72, 293, 46, 13);
		frame.getContentPane().add(lblCrew);
		
		JLabel lblMedicalShop = new JLabel("Purchase items to heal/boost your crew");
		lblMedicalShop.setBounds(137, 379, 198, 55);
		frame.getContentPane().add(lblMedicalShop);
		
		JLabel lblFoodShop = new JLabel("Purchase items to replenish Hunger");
		lblFoodShop.setBounds(373, 400, 183, 13);
		frame.getContentPane().add(lblFoodShop);
		
		JLabel lblConvenienceStore = new JLabel("Purchase items to aid your quest");
		lblConvenienceStore.setBounds(608, 400, 169, 13);
		frame.getContentPane().add(lblConvenienceStore);
		
		JButton btnClickHereTo = new JButton("Medical Shop");
		btnClickHereTo.setBounds(140, 181, 183, 188);
		frame.getContentPane().add(btnClickHereTo);
		
		JButton btnFoodShop = new JButton("Food Shop");
		btnFoodShop.setBounds(373, 181, 183, 188);
		frame.getContentPane().add(btnFoodShop);
		
		JButton btnConvenienceStore = new JButton("Convenience Store");
		btnConvenienceStore.setBounds(594, 181, 183, 188);
		frame.getContentPane().add(btnConvenienceStore);
		
		JButton btnBackToYour = new JButton("Back to your ship");
		btnBackToYour.setBounds(801, 475, 160, 55);
		frame.getContentPane().add(btnBackToYour);
	}

}
