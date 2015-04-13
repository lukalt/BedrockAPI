package org.bedrockmc.api.gui;

public interface Button {

	public void drawButton();
	
	public int getX();
	
	public int getY();
	
	public int getWidth();
	
	public int getHeight();
	
	public boolean isEnabled();
	
	public void setHeight(int height);
	
	public void setWidth(int width);
	
	public void setX(int x);
	
	public void setY(int y);
	
	public void setLabel(String label);
	
	public String getLabel();
	
}
