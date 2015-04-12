package org.bedrockmc.api.gui;

public abstract class ModGuiScreen implements ModGui {
	
	public abstract void initGui();
	
	public abstract void guiClosed();
	
	public void drawHoveringText(int x, int y, String text) {
		
	}
	
	public int getWidth() {
		return 0;
	}

}
