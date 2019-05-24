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
import WindowSettings.Display;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class alienPirates 
{

	public JFrame frmEliteDangerousBeta;
	
	
	private void btnBack()
	{
		JButton btnLetsGetGoing = new JButton("Back to Base");
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
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(alienPirates.class.getResource("/gameImages/pirates.jpg")));
			lblNewLabel.setBounds(0, 0, 1920, 1080);
			frmEliteDangerousBeta.getContentPane().add(lblNewLabel);
		}
	}

	
	private void randSelect()
	{
		IOFile ioFile = new IOFile();
		ArrayList<String> inventory = new ArrayList<String>();
		
		inventory = ioFile.fileRead("src/StoreGame/Inventory/Storage.txt");
		int x = (int)((Math.random()*(3-0)+0)+0);
		String taken = inventory.get(x);
		inventory.remove(taken);
		
		ioFile.fileWrite(inventory, "src/StoreGame/Inventory/Storage.txt");
	
		JLabel lblFdf = new JLabel("<html>Your team has awoken to the screeching sound of boarding Alien Pirates, "
				+ "raiding your ship for the supplies you carry, your team puts up a strong fight, and were lucky to have lost only &emsp;" + taken 
				+ "  &emsp; from the inventory</html>");
		lblFdf.setOpaque(true);
		lblFdf.setFont(new Font("Dialog", Font.BOLD, 19));
		lblFdf.setBounds(525, 259, 905, 170);
		frmEliteDangerousBeta.getContentPane().add(lblFdf);
		
		ioFile.fileWrite(inventory, "src/StoreGame/Inventory/Storage.txt");
	}
	
	
	/*
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
		
		randSelect();

		JLabel lblPirates = new JLabel("PIRATES!");
		lblPirates.setOpaque(true);
		lblPirates.setHorizontalAlignment(SwingConstants.CENTER);
		lblPirates.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPirates.setBounds(650, 50, 600, 50);
		frmEliteDangerousBeta.getContentPane().add(lblPirates);
		btnBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public alienPirates() {
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
					alienPirates window = new alienPirates();
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
