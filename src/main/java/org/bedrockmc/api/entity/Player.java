package org.bedrockmc.api.entity;

import java.util.UUID;

import org.bedrockmc.api.Location;

public interface Player extends Damageable, Entity, LivingEntity{

	public Location getLocation();
	
	public UUID getUniqueId();
	
	public String getName();
	
	public boolean isDead();
	
	public boolean isAlive();
	
	public int getDimension();
	
	public float getExp();
	
	public float getTotalExperience();
	
	public int getLevel();
	
	public boolean isSneaking();
	
	public boolean isBlocking();
	
	public void setSneaking(boolean flag);
	
	public void setBlocking(boolean flag);
	
	public float getCameraYaw();
	
	public float getCameraPitch();
	
	public Location getEyeLocation();
	
	public boolean isBurning();
	
}
