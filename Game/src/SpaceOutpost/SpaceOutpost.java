package SpaceOutpost;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

//Self implemented
import WindowSettings.Display;
import SpaceOutpost.SpaceOutpost;
import MainScreen.MainScreen;



public class SpaceOutpost 
{

	public JFrame frame;

	
	// Go to the medical shop
	private void medicalShop()
	{
		JButton btnClickHereTo = new JButton("Medical Shop");
		btnClickHereTo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				MedicalStore medicalStore = new MedicalStore();
				medicalStore.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);              // turn off screen
			}
		});
		btnClickHereTo.setBounds(140, 181, 183, 188);
		frame.getContentPane().add(btnClickHereTo);
	}
	
	
	// Go to the Convenience Store
	private void convenienceStore()
	{
		JButton btnConvenienceStore = new JButton("Convenience Store");
		btnConvenienceStore.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				ConvenienceStore convenienceStore = new ConvenienceStore();
				convenienceStore.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);                  // turn off screen
			}
		});
		btnConvenienceStore.setBounds(594, 181, 183, 188);
		frame.getContentPane().add(btnConvenienceStore);
	}
	
	
	// Go to the food shop
	private void foodShop()
	{
		JButton btnFoodShop = new JButton("Food Shop");
		btnFoodShop.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				FoodStore foodStore = new FoodStore();
				foodStore.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);           // turn off screen
			}
		});
		btnFoodShop.setBounds(373, 181, 183, 188);
		frame.getContentPane().add(btnFoodShop);
	}
	
	
	// Returning back to main screen
	private void goBack()
	{
		JButton btnBackToYour = new JButton("Back to your ship");
		btnBackToYour.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				MainScreen mainScreen = new MainScreen();
				mainScreen.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);            // turn off screen
			}
		});
		btnBackToYour.setBounds(801, 475, 160, 55);
		frame.getContentPane().add(btnBackToYour);
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
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(false);  // Frame cannot be adjusted during game
		frame.setResizable(false);
		
		
		// Initializing displays
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
		
		
		// Button Actions
		foodShop();
		medicalShop();
		convenienceStore();
		goBack();
	}
	
	
	/*
	 * Create the application.
	*/
	public SpaceOutpost() 
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
					SpaceOutpost window = new SpaceOutpost();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}