package org.bedrockmc.api.entity;

public interface Zombie extends Entity {

	public boolean isBaby();

	public void setBaby(boolean flag);

	public boolean isVillager();

	public void setVillager(boolean flag);
}