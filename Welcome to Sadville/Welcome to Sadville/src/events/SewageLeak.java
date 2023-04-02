package events;

import java.io.IOException;

import main.jframe;

public class SewageLeak extends EventTemplate {
	public SewageLeak(jframe jf) {
		super(jf);
	}
	public void runEvent() throws IOException {
		jf.changeText("Our sewage system is in \ndire need of repairs");
		wait(3);
		jf.changeText("Our sewage system is in \ndire need of repairs \nHow would you like to respond?");
		jf.changeBackground("https://i.imgur.com/mzlf3L9.jpeg");
		jf.showOptions();
		jf.changeOption1("Upgrade the sewage system");
		jf.changeOption2("Conduct Basic Reparis");
		jf.changeOption3("Do Nothing");
		jf.changeOption4("");
		jf.hideOption4();
		
		int action = 4;
		while(action == 4) {
			jf.showOptions();
			action = waitChoice(jf);
			if(action == 1) {
				jf.changeText("The Sewage System has been upgraded!\nthis should improve our water quality \nsignificantly.");
				funds.subtract(5);
				happiness.add(2);
				waterQuality.add(5);
				jf.changeBackground("https://i.imgur.com/bl3XxIU.jpeg");
			} else if(action == 2) {
				jf.changeText("Basic repairs complete\nOur water quality should be \nsatisfactory");
				funds.subtract(3);
				jf.changeBackground("https://i.imgur.com/mzlf3L9.jpeg");
			} else if(action == 3) {
				jf.changeText("Nothing is done about the \nsewage problem");
				happiness.subtract(2);
				waterQuality.subtract(3);
			}
			jf.turnOffButton();
			jf.hideOptions();
		}
	}
}
