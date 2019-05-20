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

public class spacePlague {

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
					spacePlague window = new spacePlague();
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
	public spacePlague() {
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
		
		JLabel lblFdf = new JLabel("<html>The re-emergence of the Space Plague took the craft while we were sleeping! _____ and _____ has been infected and must be treated immediately! Use Plague Potion it in your inventory on _____ and _____ or if you don't have it,  purchase Plague Potion from the Outpost. We must contain the spread before it gets worse.</html>");
		lblFdf.setFont(new Font("Dialog", Font.BOLD, 23));
		lblFdf.setBounds(201, 194, 905, 400);
		frame.getContentPane().add(lblFdf);
		
		JLabel lblSpacePlague = new JLabel("Space Plague");
		lblSpacePlague.setFont(new Font("Dialog", Font.BOLD, 39));
		lblSpacePlague.setBounds(304, 37, 533, 82);
		frame.getContentPane().add(lblSpacePlague);
		btnBack();
	}

}
