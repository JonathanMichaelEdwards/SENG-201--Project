import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
<<<<<<< HEAD
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
=======
import java.util.Hashtable;
>>>>>>> 1077cbcd75bb397d2bc39762b1b4a54b89c48716


public class ChooseDays 
{

	private JFrame frame;

	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{
		
		
		Settings set = new Settings();
		JSlider sliderDays = new JSlider();
		JLabel lblSliderDays = new JLabel("Number of Spaceship parts: ");
		
		frame = new JFrame();
		frame.setBounds(set.x, set.y, set.width, set.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the game");
		lblWelcomeToThe.setFont(new Font("Dialog", Font.BOLD, 24));
		lblWelcomeToThe.setBounds(351, 41, 310, 111);
		frame.getContentPane().add(lblWelcomeToThe);
		
<<<<<<< HEAD
=======
		JSlider slider = new JSlider();
		slider.setFont(new Font("Dialog", Font.BOLD, 17));
		slider.setMinimum(3);
		slider.setMaximum(10);
		slider.setBounds(276, 282, 406, 135);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		// Set the labels to be painted on the slider
		slider.setPaintLabels(true);
		         
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
>>>>>>> 1077cbcd75bb397d2bc39762b1b4a54b89c48716
		
		sliderDays.setMajorTickSpacing(1);
		sliderDays.setFont(new Font("Dialog", Font.BOLD, 17));
		sliderDays.setMinimum(3);
		sliderDays.setMaximum(10);
		sliderDays.setBounds(255, 329, 406, 51);
		
		frame.getContentPane().add(sliderDays);
		
		
	
		sliderDays.addChangeListener(new ChangeListener() {
			
            public void stateChanged(ChangeEvent e) {
            	int pieces = (int)(sliderDays.getValue()*(0.666));
            	lblSliderDays.setText("Number of Spaceship parts: " + (pieces));
            }
        });
		
	
		
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAccept.setBounds(779, 494, 151, 103);
		frame.getContentPane().add(btnAccept);
		
		
		lblSliderDays.setBounds(189, 533, 266, 25);
		frame.getContentPane().add(lblSliderDays);
		
		JLabel label = new JLabel("3");
		label.setBounds(255, 282, 66, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("10");
		label_1.setBounds(670, 292, 66, 15);
		frame.getContentPane().add(label_1);
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
