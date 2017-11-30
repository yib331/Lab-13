package button;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonFrame extends JFrame {
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	
	private static final int DEFAULT_HEIGHT = 200;
	
	public ButtonFrame() {
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//create buttons
		JButton yellowButton = new JButton("change"); //yellow - change
		JButton blueButton = new JButton("reset");//blue - reset
		JButton redButton = new JButton("close");//red - close
		
		buttonPanel = new JPanel();
		
		//add buttons to panel
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		
		//add panel to frame
		add(buttonPanel);
		
		//create button actions
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);
		
		//associate actions with buttons
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);	
	}
	
	/* An action listener that sets the panel's background color */
	private class ColorAction implements ActionListener
	{
		private Color backgroundColor;
		int numClicks = 0;
		public ColorAction(Color c)
		{
			backgroundColor = c;
		}
		
		public void actionPerformed(ActionEvent event)
		{
			if (backgroundColor.equals(Color.BLUE)) {
				numClicks = 0;
				buttonPanel.setBackground(Color.GRAY);
				System.out.println(numClicks);
			}
				
			if(backgroundColor.equals(Color.RED))
				System.exit(0);
			if(backgroundColor.equals(Color.YELLOW)) {
				numClicks = numClicks%4;
				switch(numClicks) {
				case 0: buttonPanel.setBackground(Color.BLACK);
						break;
				case 1: buttonPanel.setBackground(Color.GREEN);
						break;
				case 2: buttonPanel.setBackground(Color.ORANGE);
						break;
				case 3: buttonPanel.setBackground(Color.PINK);
						break;
				}
				numClicks++;
				System.out.println(numClicks);
			}
		}
	}
}
