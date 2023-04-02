package events;

import java.io.IOException;

import main.jframe;

public class TrashOverflow extends EventTemplate{

	public TrashOverflow(jframe jf) {
		super(jf);
	}
	
	public void runEvent() throws IOException {
		//first lines of text
		//premise
		jf.changeBackground("https://i.imgur.com/JCfKylI.jpeg");
		jf.changeText("Our trash system is reaching \nmaximum capacity.");
		wait(3);
		jf.changeText("Our trash system is reaching \nmaximum capacity \nHow would you like to respond?");
		
		//options
		jf.showOptions();
		jf.changeOption1("Create a recycling plant");
		jf.changeOption2("Build more landfills");
		jf.changeOption3("Do Nothing");
		jf.changeOption4("Throw a party in the streets!");
		
		//wait for the user to make a choice and respond accordingly
		int action = waitChoice(jf);
		if(action == 1) {
			jf.changeText("This is expensive, but the best solution");
			funds.subtract(5);
			happiness.add(3);
			landQuality.add(5);
			waterQuality.add(3);
			jf.changeBackground("https://i.imgur.com/yxNqKu4.jpeg");
		} else if(action == 2) {
			jf.changeText("This'll do for now, but we might need to \nupgrade later");
			funds.subtract(3);
			jf.changeBackground("https://i.imgur.com/zVeR7MV.jpeg");
		} else if(action == 3) {
			jf.changeText("Trash begins to pile up on the streets");
			landQuality.subtract(3);
			waterQuality.subtract(3);
			airQuality.subtract(2);
			happiness.subtract(1);
		} else if(action == 4) {
			jf.changeText("You throw a big party in the streets.\nPeople enjoy it, but theres more trash than \never");
			funds.subtract(5);
			landQuality.subtract(5);
			waterQuality.subtract(5);
			airQuality.subtract(1);
			happiness.add(10);
			jf.changeBackground("https://i.imgur.com/FwbKXKk.jpeg");
		}
		jf.turnOffButton();
		jf.hideOptions();
	}
	
	
}


