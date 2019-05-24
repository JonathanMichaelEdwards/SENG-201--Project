package MainScreen;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class loseGame
{
	public JFrame frame;


	/**
	 * Create the application.
	 */
	public loseGame() 
	{
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game over! try agian if you think you can run a team better");
		lblGameOver.setBounds(12, 96, 409, 36);
		frame.getContentPane().add(lblGameOver);
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable()
		 {
			public void run() 
			{
				try {
					loseGame window = new loseGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
