package org.bedrockmc.api.world;

import java.util.Collection;

import org.bedrockmc.api.Difficulty;
import org.bedrockmc.api.GameMode;
import org.bedrockmc.api.Location;

public interface World {

	public String getName();
	
	public int getDimension();
	
	public boolean isRaining();
	
	public boolean isThundering();
	
	public GameMode getDefaultGameMode();
	
	public void setDefaultGameMode(GameMode gameMode);
	
	public long getWorldTime();
	
	public Location getSpawn();
	
	public void setSpawn(Location location);
	
	public long getSeed();
	
	public Difficulty getDifficulty();
	
	public boolean isDifficultyLocked();
	
	public Collection<Chunk> getChunks();
	
	public Chunk getChunkAt(int x, int y);
	
	public Chunk getChunkAt(Location location);
	
}
