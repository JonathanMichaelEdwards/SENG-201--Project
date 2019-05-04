import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;



public class ChooseDays 
{

	private JFrame frame;

	
	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{
		Settings set = new Settings();
		
		frame = new JFrame();
		frame.setBounds(set.x, set.y, set.width, set.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the game");
		lblWelcomeToThe.setFont(new Font("Dialog", Font.BOLD, 24));
		lblWelcomeToThe.setBounds(351, 41, 310, 111);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JSlider slider = new JSlider();
		slider.setFont(new Font("Dialog", Font.BOLD, 17));
		slider.setMinimum(3);
		slider.setMaximum(10);
		slider.setBounds(276, 282, 406, 135);
		frame.getContentPane().add(slider);
		
		JLabel lblHowManyDays = new JLabel("How many Days?");
		lblHowManyDays.setFont(new Font("Dialog", Font.BOLD, 24));
		lblHowManyDays.setBounds(351, 131, 310, 111);
		frame.getContentPane().add(lblHowManyDays);
		
		JButton btnAccept = new JButton("Accept");
		btnAccept.setBounds(779, 494, 151, 103);
		frame.getContentPane().add(btnAccept);
		
		JLabel lblPieces = new JLabel("Pieces: ...");
		lblPieces.setFont(new Font("Dialog", Font.BOLD, 24));
		lblPieces.setBounds(171, 486, 197, 111);
		frame.getContentPane().add(lblPieces);
		
		JLabel lblSelection = new JLabel("Selection");
		lblSelection.setBounds(432, 315, 208, 57);
		frame.getContentPane().add(lblSelection);
		
		JLabel lblSelection_1 = new JLabel("Selection(From slide bar) ..");
		lblSelection_1.setBounds(384, 424, 266, 25);
		frame.getContentPane().add(lblSelection_1);
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
