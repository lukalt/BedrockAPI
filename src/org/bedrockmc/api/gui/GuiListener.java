package org.bedrockmc.api.gui;

public abstract class GuiListener {
	
	private ModGuiScreen guiScreen;
	
	public GuiListener(ModGuiScreen guiScreen) {
		this.guiScreen = guiScreen;
	}
	
	public ModGuiScreen getGuiScreen() {
		return this.guiScreen;
	}
	
	/**
	 * Invoked when the gui is openen or resized
	 */
	public abstract void initGui();
	
	/**
	 * Invoked when the gui is closed
	 */
	public abstract void closeGui();
	
	/**
	 * Invoked when a button is clicked
	 * @param button
	 */
	public abstract void buttonClicked(Button button);
	
	/**
	 * Invoked when the mouse is clicked on the gui
	 * @param mouseX
	 * @param mouseY
	 */
	public abstract void mouseClicked(int mouseX, int mouseY);
	
	/**
	 * Invoked when the gui is drawn
	 * @param mouseX
	 * @param mouseY
	 */
	public abstract void drawGui(int mouseX, int mouseY);
}
