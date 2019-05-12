import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FoodStore {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodStore window = new FoodStore();
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
	public FoodStore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 995, 646);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFoodStore = new JLabel("Food Store");
		lblFoodStore.setBounds(368, 39, 70, 13);
		frame.getContentPane().add(lblFoodStore);
		
		JLabel label = new JLabel("Common (Found by exploring planets)");
		label.setBounds(72, 93, 183, 13);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Current Cash = $");
		label_1.setBounds(368, 93, 127, 13);
		frame.getContentPane().add(label_1);
		
		JLabel lblCookie = new JLabel("Cookie - 2 hunger replenished");
		lblCookie.setBounds(72, 132, 205, 13);
		frame.getContentPane().add(lblCookie);
		
		JLabel label_3 = new JLabel("$5");
		label_3.setBounds(304, 132, 46, 13);
		frame.getContentPane().add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		comboBox.setMaximumRowCount(9);
		comboBox.setBounds(355, 128, 44, 21);
		frame.getContentPane().add(comboBox);
		
		JLabel label_4 = new JLabel("=");
		label_4.setBounds(429, 132, 46, 13);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("$");
		label_5.setBounds(485, 132, 46, 13);
		frame.getContentPane().add(label_5);
		
		JLabel lblPizza = new JLabel("Pizza - 5 hunger replenished");
		lblPizza.setBounds(72, 176, 205, 13);
		frame.getContentPane().add(lblPizza);
		
		JLabel label_6 = new JLabel("$8");
		label_6.setBounds(304, 176, 46, 13);
		frame.getContentPane().add(label_6);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		comboBox_1.setMaximumRowCount(9);
		comboBox_1.setBounds(355, 172, 44, 21);
		frame.getContentPane().add(comboBox_1);
		
		JLabel label_7 = new JLabel("=");
		label_7.setBounds(429, 176, 46, 13);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("$");
		label_8.setBounds(485, 176, 46, 13);
		frame.getContentPane().add(label_8);
		
		JLabel lblHealth = new JLabel("Full meal - Full hunger replenished");
		lblHealth.setBounds(72, 221, 205, 13);
		frame.getContentPane().add(lblHealth);
		
		JLabel label_9 = new JLabel("$8");
		label_9.setBounds(304, 221, 46, 13);
		frame.getContentPane().add(label_9);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1", "x2", "x3", "x4", "x5", "x6", "x7", "x8", "x9"}));
		comboBox_2.setMaximumRowCount(9);
		comboBox_2.setBounds(355, 217, 44, 21);
		frame.getContentPane().add(comboBox_2);
		
		JLabel label_10 = new JLabel("=");
		label_10.setBounds(429, 221, 46, 13);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("$");
		label_11.setBounds(485, 221, 46, 13);
		frame.getContentPane().add(label_11);
		
		JLabel label_2 = new JLabel("Rare (Unlockable by exploring planets only)");
		label_2.setBounds(72, 277, 296, 13);
		frame.getContentPane().add(label_2);
		
		JLabel lblCrewDoNot = new JLabel("Crew do not get hungry for a day");
		lblCrewDoNot.setBounds(72, 322, 218, 13);
		frame.getContentPane().add(lblCrewDoNot);
		
		JLabel label_13 = new JLabel("$50");
		label_13.setBounds(304, 322, 46, 13);
		frame.getContentPane().add(label_13);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1"}));
		comboBox_3.setMaximumRowCount(1);
		comboBox_3.setBounds(355, 318, 44, 21);
		frame.getContentPane().add(comboBox_3);
		
		JLabel label_14 = new JLabel("=");
		label_14.setBounds(429, 322, 46, 13);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("$");
		label_15.setBounds(485, 322, 46, 13);
		frame.getContentPane().add(label_15);
		
		JLabel lblHungerDecreasesAt = new JLabel("Hunger decreases at half the rate permanently");
		lblHungerDecreasesAt.setBounds(72, 377, 218, 13);
		frame.getContentPane().add(lblHungerDecreasesAt);
		
		JLabel label_16 = new JLabel("$50");
		label_16.setBounds(304, 377, 46, 13);
		frame.getContentPane().add(label_16);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"x0", "x1"}));
		comboBox_4.setMaximumRowCount(1);
		comboBox_4.setBounds(355, 373, 44, 21);
		frame.getContentPane().add(comboBox_4);
		
		JLabel label_17 = new JLabel("=");
		label_17.setBounds(429, 377, 46, 13);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("$");
		label_18.setBounds(485, 377, 46, 13);
		frame.getContentPane().add(label_18);
		
		JButton btnBackToOutpost = new JButton("Back to Outpost");
		btnBackToOutpost.setBounds(526, 512, 183, 59);
		frame.getContentPane().add(btnBackToOutpost);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(719, 510, 205, 61);
		frame.getContentPane().add(btnBuy);
	}

}
