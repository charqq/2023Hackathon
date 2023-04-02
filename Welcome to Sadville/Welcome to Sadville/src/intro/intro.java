package intro;

import main.jframe;

public class intro {
	private jframe jf;
	
	public intro(jframe jf) {
		this.jf = jf;
	}
	
	public void runIntro() {
		//first lines of text
		jf.hideOptions();
		jf.changeText("Welcome to Sadville, the happiest \nplace on earth!");
		wait(2);
		jf.changeText("Welcome to Sadville, the happiest \nplace on earth! Alas, due to an unfortunate \nturn of events "
				+ "we are currently out of a \nmayor to help get you situated!");
		jf.showOptions();
		jf.changeOption1("How unfortunate...");
		jf.changeOption2("Oh no!");
		jf.changeOption3("What can I do to help?");
		jf.hideOption4();
		
		//wait for the user to make a choice and respond accordingly
		int action = 4;
		
		while(action == 4) {
			action = waitChoice(jf);
			if(action == 1) {
				jf.changeText("Indeed! We're simply at the end of our \nwits.");
			} else if(action == 2) {
				jf.changeText("Oh noes...");
			} else if(action == 3) {
				jf.changeText("So glad you asked!");
			}
			jf.turnOffButton();
		}
		jf.hideOptions();
		
		//next lines of text
		wait(2);
		jf.changeText("We're rather in need of an interim mayor...");
		wait(2);
		jf.changeText("So what say you, neighbor?");
		wait(2);
		jf.changeText("So what say you, neighbor? \nWould you like to be the mayor?");
		
		//wait for the user to make a choice and respond accordingly
		jf.showOptions();
		jf.changeOption1("I suppose...");
		jf.changeOption2("Yes!");
		jf.changeOption3("OF COURSE!!!");
		jf.hideOption4();
		
		action = 4;
		
		while(action == 4) {
			action = waitChoice(jf);
			if(action == 1) {
				jf.changeText("Fantabulous.");
			} else if(action == 2) {
				jf.changeText("Awesome!");
			} else if(action == 3) {
				jf.changeText("Woah there...");
			}
			jf.turnOffButton();
		}
		jf.hideOptions();
		
		//final lines of text
		wait(1);
		jf.changeText(jf.getText() + "\nLet's begin!");
		
		wait(2);

	}
	
	public static int waitChoice(jframe jf) {
		System.out.println("Pick your choice");
		while(jf.getPressed() == false) {
			try {
			       Thread.sleep(200);
			    } catch(InterruptedException e) {
			    }
		}
		
		int temp = jf.getInput();
		System.out.println("Your choice was: " + temp);
		return temp;
	}
	
	//wait method
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}
}
