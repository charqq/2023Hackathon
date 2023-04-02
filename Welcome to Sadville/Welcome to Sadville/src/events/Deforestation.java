package events;

import java.io.IOException;

import main.jframe;

public class Deforestation extends EventTemplate{
	public Deforestation(jframe jf) {
		super(jf);
	}
	
	public void runEvent() throws IOException {
		jf.changeBackground("https://i.imgur.com/VBAFyRc.jpeg");
		jf.changeText("It has come to your attention that the \ndeforestation of a nearby forest is on \nthe rise");
		wait(3);
		jf.changeText("How should you respond?");
		
		jf.showOptions();
		jf.changeOption1("Tax the loggers");
		jf.changeOption2("Restrict deforestation");
		jf.changeOption3("Do nothing");
		jf.changeOption4("Set the forest on fire");
		
		int action = waitChoice(jf);
		if(action == 1) {
			jf.changeText("This should slow them down a bit and \n provide us with extra funds");
			funds.add(10);
			airQuality.subtract(3);
			landQuality.subtract(1);
		} else if(action == 2) {
			jf.changeText("Stopping deforestation is best for the \n environment");
			airQuality.add(5);
			landQuality.add(3);
		} else if(action == 3) {
			jf.changeText("Deforestation continues...");
			airQuality.subtract(5);
			landQuality.subtract(3);
			jf.changeBackground("https://i.imgur.com/WVIwmPD.jpeg");
		} else if(action == 4) {
			jf.changeText("You started a forest fire...");
			jf.hideOptions();
			airQuality.subtract(15);
			landQuality.subtract(5);
			population.subtract(10);
			happiness.subtract(10);
			jf.changeBackground("https://i.imgur.com/nrESVoV.jpeg");
			wait(3);
			jf.changeText("You started a forest fire... \n...but why though");
		}
		jf.turnOffButton();
		jf.hideOptions();
	}
}
