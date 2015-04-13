package org.bedrockmc.api.gui;

public abstract class GuiListener {
	
	private ModGuiScreen guiScreen;
	
	public GuiListener(ModGuiScreen guiScreen) {
		this.guiScreen = guiScreen;
	}
	
	public ModGuiScreen getGuiScreen() {
		return this.guiScreen;
	}
	
	public abstract void initGui();
	
	public abstract void closeGui();
	
	public abstract void buttonClicked(Button button);
	
	public abstract void mouseClicked(int mouseX, int mouseY);
	
	public abstract void drawGui(int mouseX, int mouseY);
}
