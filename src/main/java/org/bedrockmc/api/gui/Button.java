package org.bedrockmc.api.gui;

public interface Button extends Element {

	/**
	 * Draw the button to the screen
	 */
	public void drawButton();
	
	/**
	 * Get the width of the button
	 * @return width
	 */
	public int getWidth();
	
	/**
	 * Get the height of the button
	 * @return height
	 */
	public int getHeight();
	
	/**
	 * @return isEnabled
	 */
	public boolean isEnabled();
	
	/**
	 * Set the height of the button
	 * @param height
	 */
	public void setHeight(int height);
	
	/**
	 * Set the width of buttn
	 * @param width
	 */
	public void setWidth(int width);
	
	/**
	 * Set the the text of the button
	 * @param text
	 */
	public void setLabel(String label);
	
	/**
	 * Get the text of the button
	 * @return
	 */
	public String getLabel();
	
	public int getId();
	
}
