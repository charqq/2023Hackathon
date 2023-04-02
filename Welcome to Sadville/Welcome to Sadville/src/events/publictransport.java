package events;

import java.io.IOException;


import main.StatVariable;
import main.jframe;

public class publictransport extends EventTemplate{
	public publictransport(jframe jf) {
		super(jf);
	}
	
	public void runEvent() throws IOException {
		//first lines of text
		//premise
		jf.changeText("Mayor, we're having issues with"
				+ "\ntransportation.");
		//image change
		wait(3);
		jf.changeBackground("https://i.imgur.com/4EM28pY.jpeg");
		jf.changeText("Cars are clogging up the street"
				+ "\npedestrians feel unsafe"
				+ "\nour last census showed more allergies");
		wait(3);
		jf.changeText("What shall we do?");
		
		
		//options
		jf.showOptions();
		jf.changeOption1("Add buses");
		jf.changeOption2("Add traffic lanes");
		jf.changeOption3("Gift helicopters");
		jf.hideOption4();
		
		//wait for the user to make a choice and respond accordingly
		int action = 4;
		while(action == 4) {
			action = waitChoice(jf);
			if(action == 1) {
				jf.changeText("More people use buses!"
						+ "\nIt cost a lot... but people are"
						+ "\nusing this service, making some money"
						+ "\nThe air feels cleaner");
				funds.add(5);
				airQuality.add(10);
				happiness.add(5);
				jf.changeBackground("https://i.imgur.com/ybIL8d3.jpeg");
			} else if(action == 2) {
				jf.changeText("More people drive than ever..."
						+ "\nfor some reason traffic is"
						+ "\nstill horrible."
						+ "\nIt's getting harder to breathe");
				funds.subtract(10);
				airQuality.subtract(10);
				happiness.subtract(5);
			} else if(action == 3) {
				jf.changeText("Your bank account couldn't take it...");
				funds.subtract(30);
				happiness.add(10);
				airQuality.subtract(10);
				jf.changeBackground("https://i.imgur.com/HoverVW.jpeg");
			}
			jf.turnOffButton();
		}
		jf.turnOffButton();
		jf.hideOptions();
		
	}
	
}
