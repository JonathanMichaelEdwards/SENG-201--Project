import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class ShipInventory {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShipInventory window = new ShipInventory();
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
	public ShipInventory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 998, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblShipsInventory = new JLabel("Ships inventory");
		lblShipsInventory.setBounds(401, 37, 188, 38);
		frame.getContentPane().add(lblShipsInventory);
		
		JLabel lblSelectAnItem = new JLabel("Select an Item to use");
		lblSelectAnItem.setBounds(120, 126, 121, 38);
		frame.getContentPane().add(lblSelectAnItem);
		
		JLabel lblSelectOneOf = new JLabel("Select one of your crew ");
		lblSelectOneOf.setBounds(645, 139, 121, 13);
		frame.getContentPane().add(lblSelectOneOf);
		
		JButton btnApplyChanges = new JButton("Apply Changes");
		btnApplyChanges.setBounds(768, 521, 171, 53);
		frame.getContentPane().add(btnApplyChanges);
		
		JButton btnBack = new JButton("Back ");
		btnBack.setBounds(537, 521, 188, 53);
		frame.getContentPane().add(btnBack);
	}
}
