package org.bedrockmc.api.world;

public interface Chunk {

	public int getX();
	
	public int getY();
	
	public World getWorld();
	
	public boolean isLoaded();
	
	public void load();
	
	public void unload();
}
