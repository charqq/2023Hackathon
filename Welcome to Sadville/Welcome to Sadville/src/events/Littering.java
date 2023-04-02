package events;

import java.io.IOException;

import main.jframe;

//this event is only accessible if the public park was built

public class Littering extends EventTemplate{
	boolean problemResolved = true;
	
	public Littering(jframe jf) {
		super(jf);
	}
	
	public void runEvent() throws IOException {
		jf.changeBackground("https://i.imgur.com/2z8k7yQ.jpeg");
		jf.changeText("People have begun littering at the new park");
		wait(3);
		jf.changeText("People have begun littering at the new park \nThey claim its because theres not enough \ntrash cans");
		wait(3);
		jf.changeText("People have begun littering at the new park \nThey claim its because theres not enough \ntrash cans\nWhat should we do?");
		
		jf.showOptions();
		jf.changeOption1("Add more trash cans");
		jf.changeOption2("Post no littering signs");
		jf.changeOption3("Do nothing");
		jf.changeOption4("Destroy the park");
		
		int action = waitChoice(jf);
		if(action == 1) {
			jf.changeText("These extra trash cans should keep people \nfrom littering");
			funds.subtract(5);
			landQuality.add(5);
			jf.changeBackground("https://i.imgur.com/Aie7lz6.jpeg");
		} else if(action == 2) {
			jf.changeText("You can only hope a public notice will do \nthe trick");
			funds.subtract(2);
			problemResolved = false;
			jf.changeBackground("https://i.imgur.com/RGPpVc0.jpeg");
		} else if(action == 3) {
			jf.changeText("Maybe the goodwill of the people will \nprevail");
			landQuality.subtract(1);
			airQuality.subtract(1);
			waterQuality.subtract(1);
			problemResolved = false;
		} else if(action == 4) {
			jf.turnOffButton();
			landQuality.subtract(5);
			airQuality.subtract(5);
			waterQuality.subtract(5);
			happiness.subtract(10);
			jf.changeText("...");
			wait(3);
			jf.changeText("...Your wish is my command");
			jf.changeBackground("https://i.imgur.com/lUTMOr3.jpeg");
		}
		jf.turnOffButton();
		jf.hideOptions();
	}
	
	public boolean getProblemResolved() {
		return problemResolved;
	}
}
