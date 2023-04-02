package main;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import events.Deforestation;
import events.Littering;
import events.SewageLeak;
import events.TrashOverflow;
import events.lakepollution;
import events.publicpark;
import events.publictransport;
import events.taxes;
import intro.intro;

public class main {
	
	public static void main(String[]args) throws IOException {
		//Declare Variables and put them into an array
		StatVariable population = new StatVariable("Population", 100);
		StatVariable funds = new StatVariable("Funds", 100);
		StatVariable airQuality = new StatVariable("Air Quality", 25);
		StatVariable waterQuality = new StatVariable("Water Quality", 25);
		StatVariable landQuality = new StatVariable("Land Quality", 25);
		StatVariable happiness = new StatVariable("Happiness", 25);
		StatVariable[] variables = {population, funds, airQuality, waterQuality, landQuality, happiness};
		boolean park = false;
		boolean gameEnded = false;
		String LakeStatus = "NA";
		MusicPlayer music = null;
		
		try {
			//music = new MusicPlayer("C:\\Users\\Xiaof\\Downloads\\Easy Lemon.wav");
			music = new MusicPlayer("Welcome to Sadville\\easylemon.wav");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jframe jf = new jframe("https://i.imgur.com/kWFTfZl.jpeg", "", variables, music);
		jf.showFrame();
		
		
		//run events
		
		intro introduction = new intro(jf);
		introduction.runIntro();
		outputVariables(variables);
		
		int previousEvent = 4;
		while(gameEnded == false) {
			//Randomizer to determine which event will begin
			int rand = (int)(Math.random()*8);
			while(rand == previousEvent) {
				rand = (int)(Math.random()*8);
			}
			
			//because of how the Randomizer works, there is a chance that nothing will be done
			//in this case, workDone will remain false so the game does not take away people if your suffering an environmental catastrophe
			boolean workDone = false;
			
			//public park event
			if(rand == 0 && park == false) { 
				publicpark event = new publicpark(jf);
				event.runEvent();
				population.add(event.getPopulation());
				funds.add(event.getFunds());
				airQuality.add(event.getAir());
				waterQuality.add(event.getWater());
				landQuality.add(event.getLand());
				happiness.add(event.getHappiness());
				outputVariables(variables);
				park = event.getPublicPark();
				park = true;
				
				wait(3);
				jf.changeText("Parks are community centers."
						+ "\nThey provide fresh air, and "
						+ "\na place to play.");
				wait(3);
				jf.changeText("Parks encourage people to"
						+ "\nmaintain exercise levels"
						+ "\nand allow them to spend time"
						+ "\nwith one another!");
				wait(3);
				
				workDone = true;
			}
			//Trash Overflow event
			if(rand == 1) { 
				TrashOverflow event = new TrashOverflow(jf);
				event.runEvent();
				population.add(event.getPopulation());
				funds.add(event.getFunds());
				airQuality.add(event.getAir());
				waterQuality.add(event.getWater());
				landQuality.add(event.getLand());
				happiness.add(event.getHappiness());
				outputVariables(variables);
				
				wait(3);
				jf.changeText("Landfills are quickly filling up."
						+ "\nMuch of human trash is not biodegradable"
						+ "\nmeaning it stays in landfills for long times.");
				wait(3);
				jf.changeText("By recycling, we can take steps"
						+ "\nto reduce our negative impact on"
						+ "\nthis planet.");
				wait(3);
				
				workDone = true;
			}
			//Littering event
			if(rand == 2 && park == true) { 
				Littering event = new Littering(jf);
				event.runEvent();
				population.add(event.getPopulation());
				funds.add(event.getFunds());
				airQuality.add(event.getAir());
				waterQuality.add(event.getWater());
				landQuality.add(event.getLand());
				happiness.add(event.getHappiness());
				outputVariables(variables);
				if(event.getProblemResolved()) {
					park = false;
				}
				
				wait(3);
				jf.changeText("Littering leaves trash everywhere."
						+ "\nAnimals can get stuck or eat it,"
						+ "\nor it could pollute our water and land");
				wait(3);
				jf.changeText("Though we can't control individual actions,"
						+ "\ngiving the resources for people to clean"
						+ "\nup after themselves is important");
				wait(3);
				
				workDone = true;
			}
			//Lake Status event
			if(rand == 3 && !LakeStatus.equals("drained")) {
				lakepollution event = new lakepollution(jf);
				event.runEvent();
				population.add(event.getPopulation());
				funds.add(event.getFunds());
				airQuality.add(event.getAir());
				waterQuality.add(event.getWater());
				landQuality.add(event.getLand());
				happiness.add(event.getHappiness());
				outputVariables(variables);
				LakeStatus = event.getLake();
				
				wait(3);
				jf.changeText("Water pollution affects local"
						+ "\necosystems. It can harm wildlife,"
						+ "\nand also pollute water we drink.");
				wait(3);
				jf.changeText("Invasive species are dangerous"
						+ "\nas well. They drive out native species"
						+ "\nand affect the whole lake ecosystem.");
				wait(3);
				
				workDone = true;
			}
			//taxes event
			if(rand == 4) {
				taxes event = new taxes(jf);
				event.runEvent();
				population.add(event.getPopulation());
				funds.add(event.getFunds());
				airQuality.add(event.getAir());
				waterQuality.add(event.getWater());
				landQuality.add(event.getLand());
				happiness.add(event.getHappiness());
				outputVariables(variables);
				
				workDone = true;
			}
			//public transport event
			if(rand==5) {
				publictransport event = new publictransport(jf);
				event.runEvent();
				population.add(event.getPopulation());
				funds.add(event.getFunds());
				airQuality.add(event.getAir());
				waterQuality.add(event.getWater());
				landQuality.add(event.getLand());
				happiness.add(event.getHappiness());
				outputVariables(variables);
				
				wait(3);
				jf.changeText("Air pollution is a major issue"
						+ "\nand cars contribute with CO2 emissions."
						+ "\nOne strategy is public transport.");
				wait(3);
				jf.changeText("Public transport means less vehicles"
						+ "\nper person. It also means less"
						+ "\ntime wasted in traffic jams.");
				wait(3);
				
				workDone = true;
			}
			//Sewage Leak event
			if(rand == 6) {
				SewageLeak event = new SewageLeak(jf);
				event.runEvent();
				population.add(event.getPopulation());
				funds.add(event.getFunds());
				airQuality.add(event.getAir());
				waterQuality.add(event.getWater());
				landQuality.add(event.getLand());
				happiness.add(event.getHappiness());
				outputVariables(variables);
				
				wait(3);
				jf.changeText("Sewage leaks are very dangerous"
						+ "\nfor humans and wildlife. It"
						+ "\npoisons bodies of water.");
				wait(3);
				jf.changeText("It can also cause algal blooms,"
						+ "\nwhich kill native fish.");
				wait(3);
				
				
				workDone = true;
			}
			//Deforestation event
			if(rand == 7) {
				Deforestation event = new Deforestation(jf);
				event.runEvent();
				population.add(event.getPopulation());
				funds.add(event.getFunds());
				airQuality.add(event.getAir());
				waterQuality.add(event.getWater());
				landQuality.add(event.getLand());
				happiness.add(event.getHappiness());
				outputVariables(variables);
				
				wait(3);
                jf.changeText("Deforestation is on the rise,"
                        + "\nmore cities are being built."
                        + "\nAs a result, we've lost many trees.");
                wait(3);
                jf.changeText("Trees are important as habitats"
                        + "\nand for oxygen. Saving trees helps"
                        + "\nsave the world for the future.");
                wait(3);
				
				workDone = true;
			}
			
			//Update the new data to the Variables bar
			StatVariable[] temp = {population, funds, airQuality, waterQuality, landQuality, happiness};
			jf.updateVariables(temp);
			
			if(workDone == true) {
				jf.increaseDay();
				wait(3);
				//test environmental
				testEnv(variables, jf);
				
				//test happiness
				testHappiness(variables, jf);
				
				//make a note of the current event so the next event doesn't repeat
				previousEvent = rand;
				StatVariable[] temp2 = {population, funds, airQuality, waterQuality, landQuality, happiness};
				jf.updateVariables(temp2);
			} else {
				jf.changeBackground("https://i.imgur.com/kWFTfZl.jpeg");
			}
			
			
			//if the population is <= 0, game ends
			if(population.getValue() <= 0) {
				gameEnded = true;
				music.pause();
				jf.changeBackground("https://i.imgur.com/8KYyzGv.jpeg");
				jf.changeText("All the residents have left...");
				wait(3);
				jf.changeText("All the residents have left...\nThere's nothing for me here anymore.");
				wait(3);
				jf.changeText("All the residents have left...\nThere's nothing for me here anymore.\n...");
				wait(3);
				jf.changeText("All the residents have left...\nThere's nothing for me here anymore.\n...\nGame Over");
				wait(5);
				System.out.println("Game Over: Everyone Left");
				System.exit(1);
			} 
			//if funds <= 0, game ends -> (no funds ending)
			else if(funds.getValue() <= 0) {
				gameEnded = true;
				music.pause();
				jf.changeBackground("https://i.imgur.com/8KYyzGv.jpeg");
				jf.changeText("The money's gone...");
				wait(3);
				jf.changeText("The money's gone...\nWhat happened to it, mayor?");
				wait(3);
				jf.changeText("The money's gone...\nWhat happened to it, mayor?\n...");
				wait(3);
				jf.changeText("The money's gone...\nWhat happened to it, mayor?\n...\nGame Over");
				wait(5);
				System.out.println("Game Over: Ran out of money");
				System.exit(1);
				
			}
			//checks for win conditions
			gameEnded = checkWinConditions(variables);
			
		}
		//keep repeating the hasLost to make sure that at any point they can lose lol
		jf.changeBackground("https://i.imgur.com/QSlOaqx.jpeg");
		jf.changeText("Congradulations! \nWith your help, our city is thriving again \nPopulation: " + population.getValue() + "\nThanks for Playing!");
		System.out.println("You won! Congrats!");
		
	}
	

	
	
	
	
	
	@SuppressWarnings("static-access")
	public static void outputVariables(StatVariable[] variables) {
		System.out.println();
		System.out.println(variables[0].getValue() + " people");
		System.out.println(variables[1].getValue() + " funds");
		System.out.println(variables[2].getValue() + "% Air Quality");
		System.out.println(variables[3].getValue() + "% Water  Quality");
		System.out.println(variables[4].getValue() + "% Land  Quality");
		System.out.println(variables[5].getValue() + "% happiness");
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
	
	
	public static void testEnv(StatVariable[] variables, jframe jf) {
		//if any of the environment qualities are less than 0, people will begin leaving
		for(int i = 2; i < variables.length-1; i++) {
			if(variables[i].getValue() <= 0) {
				int rand = (int) (Math.random()*5+5);
				jf.changeText("The city is suffering from an \nenvironmental catastrophe!\n" + rand + " people have left");
				variables[0].subtract(rand);
				outputVariables(variables);
				wait(3);
				break;
			}
		}
	}
	
	public static void testHappiness(StatVariable[] variables, jframe jf) {
		//if happiness is less or equal to 0, people will begin leaving
		if(variables[5].getValue() <= 0) {
			int rand = (int) (Math.random()*5+5);
			jf.changeText("Your citizens are unhappy!\n" + rand + " people have left");
			variables[0].subtract(rand);
			outputVariables(variables);
			wait(3);
		}
	}
	
	public static boolean checkWinConditions(StatVariable[] variables) {
		//if all environmental qualities are greater than 100 and happiness is greater than or equal to 100,return true;
		boolean ans = true;
		for(int i = 2; i < variables.length; i++) {
			if(variables[i].getValue() < 100) {
				ans = false;
				break;
			}
		}
		return ans;
	}
	
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}
}
