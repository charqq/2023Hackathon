package main;

public class StatVariable {
	private String name = "";
	private int value = 0;
	private String description = "No Description Found";
	
	public StatVariable(String name, int initalValue) {
		this.name=name;
		value=initalValue;
	}
	
	public StatVariable(String name, int initalValue, String description) {
		this.name=name;
		value=initalValue;
		this.description = description;
	}
	
	public void add(int change) {
		value += change;
	}
	
	public void subtract(int change) {
		value -= change;
	}
	
	public void setValue(int newValue) {
		value = newValue;
	}
	
	public void changeDescription(String newDescription) {
		description = newDescription;
	}
	
	public int getValue() {
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
}
