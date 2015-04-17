package org.bedrockmc.api.event;

public enum EventPriority {
	
	LOWEST,
	
	LOW,
	
	NORMAL,
	
	HIGH,
	
	HIGHEST,
	
	MONITOR;
	
	public String toString() {
		return name();
	}
}
