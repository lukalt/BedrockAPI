package org.bedrockmc.api.entity;

public interface Damageable {

	public double getHealth();
	
	public double getMaxHealth();
	
	public void setHealth(double d);
	
	public void setMaxHealth(double d);
}
