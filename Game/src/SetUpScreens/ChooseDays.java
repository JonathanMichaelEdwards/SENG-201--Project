package SetUpScreens;

// Libary imports
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

// Self implemented
import GameSettings.Display;



public class ChooseDays 
{
	public JFrame frame;
	
	private JSlider slider;
	private JLabel lblSliderDays;
	private int piecesToCollect = 2;  // Pieces player selected
	
	
	// Retrieving the number of days, selected from the slider
	void getDays()
	{
		lblSliderDays = new JLabel("Number of Spaceship parts: " + piecesToCollect);
		// Add a new slider listener
		// Get the value the user selected and times it by 2/3 (0.667) to find the pieces
		slider.addChangeListener(new ChangeListener() 
		{
	        public void stateChanged(ChangeEvent e) 
	        {
	        	piecesToCollect = (int)(slider.getValue()*(0.667));   // Formula days 2/3 (now correct)
	        	lblSliderDays.setText("Number of Spaceship parts: " + (piecesToCollect));
	        }
		});
		
		lblSliderDays.setBounds(156, 494, 266, 25);
		frame.getContentPane().add(lblSliderDays);
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
				
				// Transfering from ChooseDays class to CrewSelection class  
				crewSelect.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);   // turn off screen
				
				// Send pieces over
				crewSelect.storeDays(piecesToCollect);
			}
		});
		btnAccept.setBounds(779, 494, 151, 103);
		frame.getContentPane().add(btnAccept);
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
		JLabel lblWelcomeToThe = new JLabel("Welcome to the game");
		lblWelcomeToThe.setFont(new Font("Dialog", Font.BOLD, 24));
		lblWelcomeToThe.setBounds(351, 41, 310, 111);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(3);
		progressBar.setStringPainted(true);
		progressBar.setBounds(40, 53, 148, 25);
		frame.getContentPane().add(progressBar);
		
		JLabel lblSetupProgress = new JLabel("Setup progress");
		lblSetupProgress.setBounds(52, 23, 116, 18);
		frame.getContentPane().add(lblSetupProgress);
		
		// Initializing a new slider to choose days
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setValue(3);
		slider.setFont(new Font("Dialog", Font.BOLD, 17));
		slider.setMinimum(3);
		slider.setMaximum(10);
		slider.setBounds(278, 246, 406, 135);
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
		frame.getContentPane().add(slider);
		
	
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
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
