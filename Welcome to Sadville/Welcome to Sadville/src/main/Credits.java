package main;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Credits {
	private JFrame frame = new JFrame("Credits");
	
	public Credits() {
		//Creating the credits frame
		frame.setSize(500, 600);
		frame.setLayout(null);
		
		JTextPane topBar = new JTextPane();
		JTextPane info = new JTextPane();
		JTextPane title = new JTextPane();
		
		topBar.setBounds(0, 0, 500, 50);
		title.setBounds(0, 50, 500, 50);
		info.setBounds(0, 100, 500, 500);
		
		centerAlign(title);
		centerAlign(info);
		
		//formatting and text info
		Font font = new Font("Verdana", Font.BOLD, 12);
		title.setFont(new Font("Serif",font.BOLD,26));
		title.setText("Credits");
		
		info.setFont(new Font("Serif", font.PLAIN, 18));
		info.setText("Developers" 
		+ "\nCharise, Xiaofan" 
		+ "\n\nArt by"
		+ "\nKatherine"
		+ "\n\nMoral Support"
		+ "\nAngela"
		+ "\n\nMusic"
		+ "\nEasy Lemon by Kevin MacLeod"
		+ "\n\n Special thanks to"
		+ "\nGoogle, StackOverflow, Imgurl, GeeksforGeeks");
		
		//finalizing
		frame.add(topBar);
		frame.add(title);
		frame.add(info);
	}
	
	public void centerAlign(JTextPane pane) {
		StyledDocument documentStyle = pane.getStyledDocument();
		SimpleAttributeSet centerAttribute = new SimpleAttributeSet();
		StyleConstants.setAlignment(centerAttribute, StyleConstants.ALIGN_CENTER);
		documentStyle.setParagraphAttributes(0, documentStyle.getLength(), centerAttribute, false);
	}
	
	public void showMenu() {
		frame.setVisible(true);
	}
	
	public void hideMenu() {
		frame.setVisible(false);
	}
}
