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
public class CrewNumber 

{

	public JFrame frame;

	/*
	 * Initialize the contents of the frame.
	*/
	private void initialize() 
	{	
		Settings set = new Settings();
		frame = new JFrame();
		frame.setBounds(set.x, set.y, 828, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("How many Crew members do you want?");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setBounds(141, 44, 595, 109);
		frame.getContentPane().add(lblNewLabel);
	
		final JLabel lblCrewListener = new JLabel("Number of Astronauts in your adventure: 2");
		
		
		
		
		// Buttons
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Setting a new frame
				ChooseDays days = new ChooseDays();
				days.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);   // turn off screen
			}
		});
		btnBack.setBounds(454, 380, 136, 75);
		frame.getContentPane().add(btnBack);
		
		
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Setting a new frame
				CrewSelection selectCrew = new CrewSelection();
				selectCrew.frame.setVisible(true);  // turn on screen
				frame.setVisible(false);   // turn off screen
			}
		});

		
//		JButton btnNewButton
//		btnNewButton.setBounds(663, 380, 136, 75);
//		frame.getContentPane().add(btnNewButton);
		final JSlider slider = new JSlider();
		slider.setValue(2);
		slider.setFont(new Font("Dialog", Font.BOLD, 17));
		slider.setMinimum(2);
		slider.setMaximum(4);
		slider.setBounds(207, 182, 381, 135);
		slider.setMajorTickSpacing(1);
		slider.setPaintTicks(true);
		// Set the labels to be painted on the slider
		slider.setPaintLabels(true);
		         
		// Add positions label in the slider
		Hashtable<Integer, JLabel> position = new Hashtable<Integer, JLabel>();
		position.put(2, new JLabel("2"));
		position.put(3, new JLabel("3"));
		position.put(4, new JLabel("4"));
		// Set the label to be drawn
		slider.setLabelTable(position); 
		
		frame.getContentPane().add(slider);
		
	
		slider.addChangeListener(new ChangeListener() 
		{
        public void stateChanged(ChangeEvent e) {
            int pieces = (int)(slider.getValue());
            lblCrewListener.setText("Number of Astronauts in your adventure: " + (pieces));
            }
        });
		
	
		
		
		JButton btnAccept = new JButton("Next");
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAccept.setBounds(779, 494, 151, 103);
		frame.getContentPane().add(btnAccept);
		

		btnNext.setBounds(663, 380, 136, 75);
		frame.getContentPane().add(btnNext);

		
		lblCrewListener.setBounds(25, 334, 408, 25);
		frame.getContentPane().add(lblCrewListener);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(1);
		progressBar.setStringPainted(true);
		progressBar.setMaximum(4);
		progressBar.setBounds(12, 38, 148, 25);
		frame.getContentPane().add(progressBar);
		
		JLabel label = new JLabel("Setup progress");
		label.setBounds(25, 12, 116, 18);
		frame.getContentPane().add(label);
	}
	
	
	/*
	 * Create the application.
	*/
	public CrewNumber() 
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
					CrewNumber window = new CrewNumber();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
