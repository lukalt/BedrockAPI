package org.bedrockmc.api.gui;

public interface TextField extends Element {

	public void setText(String text);
	
	public String getText();
	
	public void setMaxLength(int length);
	
	public int getMaxLength();
	
	public void setCursor(int pos);
	
	public int getCursor();
	
	public void setFocused(boolean flag);
	
	public boolean isFocused();
}
