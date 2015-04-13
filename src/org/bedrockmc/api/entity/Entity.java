package org.bedrockmc.api.entity;

import org.bedrockmc.api.Location;

public interface Entity {

	public int getEntityId();
	
	public Location getLocation();

	public void setPostion(Location location);
	
	public boolean isBurning();
	
	public void setFireTicks(int fire);
	
	public void remove();
	
	public EntityType getType();
}
