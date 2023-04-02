package main;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class HelpMenu {
	private JFrame frame = new JFrame("Help");
	
	public HelpMenu() {
		frame.setSize(600, 800);
		frame.setLayout(null);
		
		JTextPane topBar = new JTextPane();
		JTextPane info = new JTextPane();
		JTextPane title = new JTextPane();
		JTextPane subTitle = new JTextPane();
		JTextPane info2 = new JTextPane();
		
		topBar.setBounds(0, 0, 600, 25);
		title.setBounds(0, 25, 600, 50);
		info.setBounds(0, 75, 600, 450);
		subTitle.setBounds(0, 525, 600, 40);
		info2.setBounds(0, 565, 600, 235);
		
		Font font = new Font("Verdana", Font.BOLD, 12);
		title.setFont(new Font("Serif",font.BOLD,26));
		title.setText("Help");
		
		info.setFont(font);
		info.setText("Population: The current number of people in the city" 
		+ "\nIf Population reaches 0, you lose" 
		+ "\nAffected by other variables and certain events"
		+ "\n"
		+ "\nFunds: The amount of funds avaiable. Required to perform certain actions"
		+ "\nIf Funds reaches $0, you will be kicked out of the city"
		+ "\nAffected by events"
		+ "\n"
		+ "\nAir Quality: The quality of the air"
		+ "\nIf Air Quality reaches 0%, people will begin leaving the city"
		+ "\nAffected by events"
		+ "\nNeeds to reach 100% to win"
		+ "\n"
		+ "\nLand Quality: The quality of the land"
		+ "\nIf Land Quality reaches 0%, people will begin leaving the city"
		+ "\nAffected by events"
		+ "\nNeeds to reach 100% to win"
		+ "\n"
		+ "\nWater Quality: The quality of the water"
		+ "\nIf Water Quality reaches 0%, people will begin leaving the city"
		+ "\nAffected by events"
		+ "\nNeeds to Reach 100% to win"
		+ "\n"
		+ "\nHappiness: How happy your people are"
		+ "\nIf Happiness reaches 0%, people will begin leaving the city"
		+ "\nAffected by events"
		+ "\nNeeds to Reach 100% to win");
		
		subTitle.setFont(new Font("Serif", font.BOLD, 20));
		subTitle.setText("How to Play");
		
		info2.setFont(font);
		info2.setText("Every day, a problem will occur in your city. You must fix the problem. Choose one of "
				+ "\nthe 3 or 4 options that are most appealing by clicking the button. Each action will have "
				+ "\ndifferent positive and negative affects, so choose wisely.");
		
		frame.add(subTitle);
		frame.add(info2);
		frame.add(topBar);
		frame.add(title);
		frame.add(info);
	}

	
	public void showMenu() {
		frame.setVisible(true);
	}
	
	public void hideMenu() {
		frame.setVisible(false);
	}
}
