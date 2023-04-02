package events;
import java.io.IOException;
import main.StatVariable;
import main.jframe;


public class lakepollution extends EventTemplate{
	private String LakeStatus;
	
	public lakepollution(jframe jf) {
		super(jf);
	}
	
	public void runEvent() throws IOException {
		//premise
			jf.changeText("Some houses have begun dumping \ntrash in the lake!");
			//image change
			jf.changeBackground("https://i.imgur.com/mzlf3L9.jpeg");
			wait(3);
			jf.changeText("Plastic floats on the surface..."
					+ "\nrecently, many fish were witnessed"
					+ "\nfloating belly-up in the water");
			wait(3);
			jf.changeText("What will we do???");
			
			
			//options
			jf.showOptions();
			jf.changeOption1("Enforce regulations");
			jf.changeOption2("Use trash-eating fish");
			jf.changeOption3("Drain the lake!");
			jf.changeOption4("Just eat the fish.");
			
			//wait for the user to make a choice and respond accordingly
			int action = waitChoice(jf);
			if(action == 1) {
				jf.changeText("you cleaned up the area!"
						+ "\nthough some townspeople were unhappy,"
						+ "\noverall the community is cleaner and "
						+ "\nhealthier.");
				funds.subtract(5);
				happiness.add(5);
				waterQuality.add(10);
				LakeStatus = "good";
				jf.changeBackground("https://i.imgur.com/mzlf3L9.jpeg");
			} else if(action == 2) {
				jf.changeText("You tried your best..."
						+ "\nInvasive fish species outcompeted"
						+ "\nour native ecosystem, damaging the "
						+ "\nlake...");
				happiness.subtract(5);
				waterQuality.subtract(15);
				funds.subtract(5);
				LakeStatus = "invasive";
				jf.changeBackground("https://i.imgur.com/FL1rf9j.jpeg");
			} else if(action == 3) {
				jf.changeText("There is no lake now...");
				population.subtract(5);
				waterQuality.subtract(15);
				happiness.subtract(10);
				LakeStatus = "drained";
				jf.changeBackground("https://i.imgur.com/EDGvgEp.jpeg");
			} else if(action == 4) {
				jf.changeText("Townspeople fall sick..."
						+ "\nit seemed like polluted water did"
						+ "\nnot make for healthy fish."
						+ "\npollution gets worse.");
				population.subtract(5);
				waterQuality.subtract(5);
				happiness.subtract(15);
				LakeStatus = "sick";
				jf.changeBackground("https://i.imgur.com/WHphozo.jpeg");
			}
			jf.turnOffButton();
			jf.hideOptions();
				
	}
	
	public String getLake() {
		return LakeStatus;
	}
	
}
