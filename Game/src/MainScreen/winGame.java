package MainScreen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class winGame {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winGame window = new winGame();
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
	public winGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYouveFoundAll = new JLabel("Youve found all the parts! thanks for playing our game");
		lblYouveFoundAll.setBounds(12, 83, 410, 40);
		frame.getContentPane().add(lblYouveFoundAll);
	}
}
