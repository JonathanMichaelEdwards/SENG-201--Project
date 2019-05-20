package RandomEvents;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import MainScreen.MainScreen;
import WindowSettings.Display;

public class alienPirates {

	private JFrame frame;
	private void btnBack()
	{
		JButton btnLetsGetGoing = new JButton("Back to Base");
		btnLetsGetGoing.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainScreen screen = new MainScreen();
				screen.frame.setVisible(true);    // turn on screen
				frame.setVisible(false);          // turn off screen
			}
		});
		frame.getContentPane().setLayout(null);
		btnLetsGetGoing.setBounds(655, 508, 210, 56);
		frame.getContentPane().add(btnLetsGetGoing);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alienPirates window = new alienPirates();
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
	public alienPirates() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		Display display = new Display();
		frame.setBounds(display.x, display.y, display.width, display.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFdf = new JLabel("<html>Your team has awoken to the screeching sound of boarding Alien Pirates, raiding your ship for the supplies you carry, your team puts up a strong fight, and were lucky to have lost only ____ from the inventory</html>");
		lblFdf.setFont(new Font("Dialog", Font.BOLD, 23));
		lblFdf.setBounds(201, 194, 905, 400);
		frame.getContentPane().add(lblFdf);
		
		JLabel lblPirates = new JLabel("PIRATES!");
		lblPirates.setFont(new Font("Dialog", Font.BOLD, 39));
		lblPirates.setBounds(304, 37, 533, 82);
		frame.getContentPane().add(lblPirates);
		btnBack();
	}

}
