package org.bedrockmc.api.event;

public interface Event {
	
	public void onInvoke();
	
	public void onRegister();
	
	public void onUnregister();
	
}
