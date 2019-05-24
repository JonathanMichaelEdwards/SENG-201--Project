package SetUpScreens;

// Library imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import IOFile.IOFile;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

// Self implemented
import WindowSettings.Display;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

/**
 * description of class
 * @author jmy39
 *
 */

public class ChooseDays 
{
	public JFrame frmEliteDangerousBeta;
	
	private JSlider slider;
	private JLabel lblSliderDays;
	private int days = 3;
	private int piecesToCollect = 2;  // Pieces player selected
	
	
	/**
	 *  Retrieving the number of days, selected from the slider
	 *  @param name <-name description
	 */
	void getDays()
	{
		lblSliderDays = new JLabel("Number of Spaceship parts: " + piecesToCollect);
		lblSliderDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblSliderDays.setOpaque(true);
		// Add a new slider listener
		// Get the value the user selected and times it by 2/3 (0.667) to find the pieces
		slider.addChangeListener(new ChangeListener() 
		{
	        public void stateChanged(ChangeEvent e) 
	        {
	        	days = slider.getValue();
	        	piecesToCollect = (int)(slider.getValue()*(0.667));   // Formula days 2/3 (now correct)
	        	lblSliderDays.setText("Number of Spaceship parts: " + (piecesToCollect));
	        }
		});
		
		lblSliderDays.setBounds(817, 468, 266, 25);
		frmEliteDangerousBeta.getContentPane().add(lblSliderDays);
	}
	
	
	// goes to next screen
	void nextButton()
	{
		// Add a new button listener
		// Take the pieces information to the next screen
		JButton btnAccept = new JButton("Next");
		btnAccept.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				// Setting a new frame
				CrewSelection crewSelect = new CrewSelection();
				
				// Transferring from ChooseDays class to CrewSelection class  
				crewSelect.frmEliteDangerousBeta.setVisible(true);  // turn on screen
				frmEliteDangerousBeta.setVisible(false);   // turn off screen
				
				// Send pieces and days to next screen
				IOFile ioFile = new IOFile();
				ArrayList<String> storeDays = new ArrayList<String>();
				
				// storing information
				storeDays.add(""+days);
				storeDays.add(""+piecesToCollect);
				
				ioFile.fileWrite(storeDays, "src/StoreGame/DaysInfo.txt");
			}
		});
		btnAccept.setBounds(1200, 700, 250, 100);
		frmEliteDangerousBeta.getContentPane().add(btnAccept);
		
		JLabel lblPleaseSelectThe = new JLabel("Please select the amount of days");
		lblPleaseSelectThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseSelectThe.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPleaseSelectThe.setBounds(650, 195, 600, 50);
		lblPleaseSelectThe.setOpaque(true);
		frmEliteDangerousBeta.getContentPane().add(lblPleaseSelectThe);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ChooseDays.class.getResource("/gameImages/startup.jpg")));
		lblNewLabel.setBounds(0, 0, 1920, 1080);
		frmEliteDangerousBeta.getContentPane().add(lblNewLabel);
	}
	
	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{	
		// Setting Layout dimensions
		frmEliteDangerousBeta = new JFrame();
		frmEliteDangerousBeta.setTitle("Elite Dangerous beta");
		Display display = new Display();  // Retrieving game window size
		
		// Setting frame of window
		frmEliteDangerousBeta.setBounds(display.x, display.y, display.width, display.height);
		frmEliteDangerousBeta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEliteDangerousBeta.getContentPane().setLayout(null);
		frmEliteDangerousBeta.setResizable(false);
//		frame.setUndecorated(false);  // Frame cannot be adjusted during game

		
		
		// Initializing displays
		JLabel lblWelcomeToThe = new JLabel("Welcome to the game");
		lblWelcomeToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToThe.setFont(new Font("Dialog", Font.BOLD, 24));
		lblWelcomeToThe.setOpaque(true);
		lblWelcomeToThe.setBounds(650, 50, 600, 50);
		frmEliteDangerousBeta.getContentPane().add(lblWelcomeToThe);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(3);
		progressBar.setStringPainted(true);
		progressBar.setBounds(230, 170, 150, 30);
		frmEliteDangerousBeta.getContentPane().add(progressBar);
		
		JLabel lblSetupProgress = new JLabel("Setup progress");
		lblSetupProgress.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetupProgress.setBounds(230, 125, 150, 30);
		lblSetupProgress.setOpaque(true);
		frmEliteDangerousBeta.getContentPane().add(lblSetupProgress);
		
		// Initializing a new slider to choose days
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setValue(3);
		slider.setFont(new Font("Dialog", Font.BOLD, 17));
		slider.setMinimum(3);
		slider.setMaximum(10);
		slider.setBounds(735, 304, 406, 135);
		slider.setMajorTickSpacing(1);
		         
		// Add positions label in the slider
		Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
		position.put(3, new JLabel("3"));
		position.put(4, new JLabel("4"));
		position.put(5, new JLabel("5"));
		position.put(6, new JLabel("6"));
		position.put(7, new JLabel("7"));
		position.put(8, new JLabel("8"));
		position.put(9, new JLabel("9"));
		position.put(10, new JLabel("10"));
		
		// Set the label to be drawn
		slider.setLabelTable(position); 
		frmEliteDangerousBeta.getContentPane().add(slider);
		
	
		// Button Actions
		getDays();
		nextButton();

	}
	
	
	/*
	 * Create the application.
	*/
	public ChooseDays() 
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
					ChooseDays window = new ChooseDays();
					window.frmEliteDangerousBeta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
