package main;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class jframe {
	private String backgroundFile;
	private String textFile;
	private int input;
	private boolean buttonPressed = false;
	private JFrame frame;
	private JLabel background;
	private JTextArea problem;
	private JButton RightButton;
	private JButton LeftButton;
	private JButton RightDButton;
	private JButton LeftDButton;
	private JTextArea AnswerOptions;
	private String Option1 = "";
	private String Option2 = "";
	private String Option3 = "";
	private String Option4 = "";
	private StatVariable[] variables;
	private JTextField PValue;
	private JTextField FValue;
	private JTextField AValue;
	private JTextField LValue;
	private JTextField WValue;
	private JTextField HValue;
	private MusicPlayer music;
	private String musicStatus = "playing";
	private int day = 1;
	private JTextField variableTitle;
	
	public jframe(String bgF, String tF, StatVariable[] var, MusicPlayer song) {
		backgroundFile = bgF;
		textFile = tF;
		variables = var;
		this.music = song;
	}
	
	
	
	public void showFrame() throws IOException{
		//Create the frame and set its size. Remove the default layout so you can directly position objects
				frame = new JFrame("Welcome to Sadville");
				frame.setSize(1000, 750);
				frame.setLayout(null);
				
				String path = backgroundFile; 
				URL url = new URL(path); 
				Image image = ImageIO.read(url).getScaledInstance(600, 600, Image.SCALE_DEFAULT); 
				background = new JLabel(new ImageIcon(image)); 
				
				//background
				
				background.setBounds(0, 0, 1000, 575);
				
				//the text that displays the problem/request
				problem = new JTextArea(textFile);
				// set the margin for all four sides
				problem.setMargin( new Insets(10,10,10,10) );
				problem.setBounds(200, 575, 350, 150);
				//font customizatoin
				Font font = new Font("Verdana", Font.BOLD, 12);
				problem.setFont(new Font("Serif",font.PLAIN,20));
				//answer options
				AnswerOptions = new JTextArea("1) " + Option1 + "\n2) " + Option2 + "\n3) " + Option3 + "\n4) " + Option4);
				AnswerOptions.setMargin( new Insets(10,10,0,0) );
				AnswerOptions.setFont(new Font("Serif", font.PLAIN, 20));
				AnswerOptions.setBounds(550, 575, 250, 150);
				
				//buttons to choose answers
				RightButton = new JButton();
				RightButton.setBounds(800, 575, 150, 75);
				RightButton.setText("2");
				RightButton.setFont(font);
				RightButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						input = 2;
						buttonPressed = true;
					}
				});
				
				LeftButton = new JButton();
				LeftButton.setBounds(50, 575, 150, 75);
				LeftButton.setText("1");
				LeftButton.setFont(font);
				LeftButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						input = 1;
						buttonPressed = true;
					}
				});
				
				
				RightDButton = new JButton();
				RightDButton.setBounds(800, 650, 150, 75);
				RightDButton.setText("4");
				RightDButton.setFont(font);
				RightDButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						input = 4;
						buttonPressed = true;
					}
				});
				LeftDButton = new JButton();
				LeftDButton.setBounds(50, 650, 150, 75);
				LeftDButton.setText("3");
				LeftDButton.setFont(font);
				LeftDButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						input = 3;
						buttonPressed = true;
					}
				});
				//Create table of variables
				variableTitle = new JTextField(" Day " + day);
				variableTitle.setFont(new Font("Serif", font.BOLD, 16));
				variableTitle.setBounds(50, 395, 150, 30);
				
				JTextField Population = new JTextField("  Population");
				Population.setBounds(50,425,100,25);
				PValue = new JTextField(variables[0].getValue() + " ");
				PValue.setBounds(150,425,50,25);
				
				JTextField Funds = new JTextField("  Funds");
				Funds.setBounds(50,450,100,25);
				FValue = new JTextField("$" + variables[1].getValue() );
				FValue.setBounds(150,450,50,25);
				
				JTextField AirQuality = new JTextField("  Air Quality");
				AirQuality.setBounds(50,475,100,25);
				AValue = new JTextField(variables[2].getValue() + "%");
				AValue.setBounds(150, 475, 50, 25);
				
				JTextField WaterQuality = new JTextField("  Land Quality");
				WaterQuality.setBounds(50,500,100,25);
				WValue = new JTextField(variables[3].getValue() + "%");
				WValue.setBounds(150, 500, 50, 25);
				
				JTextField LandQuality = new JTextField("  Water Quality");
				LandQuality.setBounds(50,525,100,25);
				LValue = new JTextField(variables[4].getValue()+ "%");
				LValue.setBounds(150, 525, 50, 25);
				
				JTextField Happiness = new JTextField("  Happiness");
				Happiness.setBounds(50,550,100,25);
				HValue = new JTextField(variables[5].getValue() + "%");
				HValue.setBounds(150, 550, 50, 25);
				
				//Create the credits menu and create a button for it
				Credits c = new Credits();
				
				JButton creditsButton = new JButton("Credits");
				creditsButton.setBounds(800, 500, 150, 75);
				creditsButton.setFont(font);
				creditsButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						c.showMenu();
					}
				});
				
				//Create the help menu and create a button for it
				HelpMenu h = new HelpMenu();
				
				JButton helpButton = new JButton("Help");
				helpButton.setBounds(800,425,150,75);
				helpButton.setFont(font);
				helpButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						h.showMenu();
					}
				});
				
				//Create the music playback button
				JButton musicButton = new JButton("Disable Music");
				musicButton.setBounds(800,350,150,75);
				musicButton.setFont(font);
				musicButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						if(musicStatus.equals("playing")) {
							music.pause();
							musicStatus = "paused";
							musicButton.setText("Enable Music");
						}
						else if(musicStatus.equals("paused")) {
							music.play();
							musicStatus = "playing";
							musicButton.setText("Disable Music");
						}
					}
				});
				
				//Add all components and finalize the JFrame
				frame.add(creditsButton);
				frame.add(helpButton);
				frame.add(musicButton);
				
				frame.add(variableTitle);
				frame.add(Population);
				frame.add(Funds);
				frame.add(AirQuality);
				frame.add(LandQuality);
				frame.add(WaterQuality);
				frame.add(Happiness);
				frame.add(PValue);
				frame.add(FValue);
				frame.add(AValue);
				frame.add(LValue);
				frame.add(WValue);
				frame.add(HValue);
				
				frame.add(LeftButton);
				frame.add(RightButton);
				frame.add(RightDButton);
				frame.add(LeftDButton);
				
				frame.add(problem);
				frame.add(AnswerOptions);
				frame.add(background);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
	}
	
	
	
	public int getInput() {
		return input;
		
	}
	
	public void changeBackground(String s) throws IOException {
		backgroundFile = s;
		String path = backgroundFile; 
		URL url = new URL(path); 
		Image image = ImageIO.read(url).getScaledInstance(600, 600, Image.SCALE_DEFAULT); 
		ImageIcon icon = new ImageIcon(image);
		background.setIcon(icon);
		
		//background
		background.setBounds(0, 0, 1000, 575);
	}
	
	public void changeText(String s) {
		textFile = s;
		problem.setText(s);
	}
	
	public void showText() {
		problem.setVisible(true);
	}
	
	public void changeOption1(String s) {
		Option1 = s;
		AnswerOptions.setText("1) " + Option1 + "\n2) " + Option2 + "\n3) " + Option3 + "\n4) " + Option4);
		if(Option4.equals("")) {
			hideOption4();
		}
	}
	
	public void changeOption2(String s) {
		Option2 = s;
		AnswerOptions.setText("1) " + Option1 + "\n2) " + Option2 + "\n3) " + Option3 + "\n4) " + Option4);
		if(Option4.equals("")) {
			hideOption4();
		}
	}
	
	public void changeOption3(String s) {
		Option3 = s;
		AnswerOptions.setText("1) " + Option1 + "\n2) " + Option2 + "\n3) " + Option3 + "\n4) " + Option4);
		if(Option4.equals("")) {
			hideOption4();
		}
	}
	
	public void changeOption4(String s) {
		Option4 = s;
		AnswerOptions.setText("1) " + Option1 + "\n2) " + Option2 + "\n3) " + Option3 + "\n4) " + Option4);
	}
	
	public void hideOption4() {
		AnswerOptions.setText("1) " + Option1 + "\n2) " + Option2 + "\n3) " + Option3);
	}
	
	public void showOptions() {
		AnswerOptions.setVisible(true);
	}
	
	public void hideOptions() {
		AnswerOptions.setVisible(false);
	}
	
	public void resetButtonText() {
		LeftButton.setText("1");
		RightButton.setText("2");
		LeftDButton.setText("3");
		RightDButton.setText("4");
	}
	
	public String getText() {
		return textFile;
	}
	
	public boolean getPressed() {
		return buttonPressed;
	}
	public void turnOffButton() {
		buttonPressed = false;
	}
	
	public void increaseDay() {
		day++;
		variableTitle.setText(" Day " + day);
	}
	
	public void updateVariables(StatVariable[] var) {
		variables = var;
		PValue.setText(variables[0].getValue() + " ");
		FValue.setText("$" + variables[1].getValue());
		AValue.setText(variables[2].getValue() + "%");
		LValue.setText(variables[3].getValue() + "%");
		WValue.setText(variables[4].getValue() + "%");
		HValue.setText(variables[5].getValue() + "%");
	}
	
	
}
