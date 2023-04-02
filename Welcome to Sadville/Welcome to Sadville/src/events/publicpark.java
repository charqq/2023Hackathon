package events;

import java.io.IOException;

import main.jframe;

public class publicpark extends EventTemplate {
	private boolean parkBuilt = false;
	
	public publicpark(jframe jf) {
		super(jf);
	}
	
	public void runEvent() throws IOException {
		//first lines of text
		//premise
		jf.changeText("A couple of residents have petitioned you \nfor a new park!");
		//image change
		
		wait(3);
		jf.changeText("They currently have no where to run..."
				+ "\nor walk their pets..."
				+ "\nor play sports...");
		wait(3);
		jf.changeText("Do you want to grant this request?");
		
		
		//options
		jf.showOptions();
		jf.changeOption1("Yes.");
		jf.changeOption2("No.");
		jf.changeOption3("Get rid of some trees!");
		jf.changeOption4("");
		jf.hideOption4();
		
		//wait for the user to make a choice and respond accordingly
		int action = 4;
		while(action == 4) {
			action = waitChoice(jf);
			if(action == 1) {
				jf.changeText("The townspeople are happy!"
						+ "\nthe trees provide oxygen for Sadville");
				funds.subtract(5);
				happiness.add(5);
				airQuality.add(5);
				parkBuilt = true;
				jf.changeBackground("https://i.imgur.com/WgVJBQ6.jpeg");
			} else if(action == 2) {
				jf.changeText("The air feels staler these days..."
						+ "\nthe townspeople grow sedentary");
				population.subtract(2);
				happiness.subtract(1);
				airQuality.subtract(5);
			} else if(action == 3) {
				jf.changeText("The next day, a company comes and"
						+ "\ntears up every inch of grass...");
				population.subtract(10);
				airQuality.subtract(15);
				happiness.subtract(10);
				jf.changeBackground("https://i.imgur.com/u8GEPOl.jpeg");
			}
			jf.turnOffButton();
		}
		jf.hideOptions();

		
		
	}
	
	public boolean getPublicPark() {
		return parkBuilt;
	}

}
