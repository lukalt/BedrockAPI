package org.bedrockmc.api;

public enum Difficulty {

	PEACEFUL(0),
	EASY(1),
	NORMAL(2),
	HARD(3);
	
	private int id;
	
	
	private Difficulty(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
}
