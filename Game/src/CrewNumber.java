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
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(454, 380, 136, 75);
		frame.getContentPane().add(btnBack);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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

		
//		JRadioButton twoCrew = new JRadioButton("2 Crew Members");
//		twoCrew.setBounds(105, 205, 144, 23);
//		frame.getContentPane().add(twoCrew);
//		
//		JRadioButton threeCrew = new JRadioButton("3 Crew Members");
//		threeCrew.setBounds(302, 205, 144, 23);
//		frame.getContentPane().add(threeCrew);
//		
//		JRadioButton fourCrew = new JRadioButton("4 Crew Members");
//		fourCrew.setBounds(535, 205, 144, 23);
//		frame.getContentPane().add(fourCrew);
//		
//		ButtonGroup bg1 = new ButtonGroup();
//		bg1.add(twoCrew);
//		bg1.add(threeCrew);
//		bg1.add(fourCrew);
		
//		twoCrew.addActionListener(l);
//		threeCrew.addActionListener(l);
//		fourCrew.addActionListener(l);
		
//		JLabel crewListener = new JLabel("There are \"\" on your team");
//		crewListener.setBounds(318, 313, 176, 15);
//		frame.getContentPane().add(crewListener);

//		ActionListener l = new ActionListener() {
//		      public void actionPerformed(ActionEvent actionEvent) {
//		       System.out.println("Selected: " + aButton.getText());
//		      }
		
		
		


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
