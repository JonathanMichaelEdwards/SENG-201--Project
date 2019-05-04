import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


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
