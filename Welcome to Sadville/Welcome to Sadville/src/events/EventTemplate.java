package events;

import java.io.IOException;

import main.StatVariable;
import main.jframe;

public class EventTemplate {
	protected jframe jf;
	protected StatVariable population = new StatVariable("Population", 0);
	protected StatVariable funds = new StatVariable("Funds", 0);
	protected StatVariable airQuality = new StatVariable("Air Quality", 0);
	protected StatVariable waterQuality = new StatVariable("Water Quality", 0);
	protected StatVariable landQuality = new StatVariable("Land Quality", 0);
	protected StatVariable happiness = new StatVariable("Happiness", 0);
	protected StatVariable[] variables = {population, funds, airQuality, waterQuality, landQuality, happiness};
	
	public EventTemplate(jframe jf) {
		this.jf=jf;
	}
	
	public void runEvent() throws IOException {
		jf.changeText("This is a default event");
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
	
	public int getPopulation() {
		return population.getValue();
	}
	
	public int getFunds() {
		return funds.getValue();
	}
	
	public int getWater() {
		return waterQuality.getValue();
	}
	public int getAir() {
		return airQuality.getValue();
	}
	public int getLand() {
		return landQuality.getValue();
	}
	public int getHappiness() {
		return happiness.getValue();
	}
	
}
