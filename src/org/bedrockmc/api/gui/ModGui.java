package org.bedrockmc.api.gui;

public interface ModGui extends Gui {

	public int getWidth();
	
	public int getHeight();
	
	public void drawString(int x, int y, String text);

}
