package events;
import java.io.IOException;


import main.StatVariable;
import main.jframe;

public class taxes extends EventTemplate{
	
	public taxes(jframe jf) {
		super(jf);
	}
	public void runEvent() throws IOException {
		//first lines of text
		//premise
		jf.changeText("It's that time of the month!");
		//image change
		jf.changeBackground("https://i.imgur.com/HXr1mAD.jpeg");
		wait(3);
		jf.changeText("Taxes... can't live without them!"
				+ "\nno one likes paying them..."
				+ "\nbut you get to collect them!");
		wait(3);
		jf.changeText("How much will you collect?");
		
		
		//options
		jf.showOptions();
		jf.changeOption1("10%");
		jf.changeOption2("5%");
		jf.changeOption3("15%");
		jf.hideOption4();
		
		//wait for the user to make a choice and respond accordingly
		int action = 4;
		while(action == 4) {
			action = waitChoice(jf);
			if(action == 1) {
				jf.changeText("Nice and moderate");
				funds.add(10);
				population.add(5);
			} else if(action == 2) {
				jf.changeText("Hmmm...are you sure"
						+ "\n that's enough?");
				funds.add(5);
				population.add(10);
			} else if(action == 3) {
				jf.changeText("Quite a bit..."
						+ "\nNot a lot of people want to move"
						+ "\nto your town.");
				population.add(2);
				funds.add(20);
			}
			jf.turnOffButton();
		}
		jf.hideOptions();
		
		
	}
	
}
