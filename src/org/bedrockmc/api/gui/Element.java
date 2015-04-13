package org.bedrockmc.api.gui;

public interface Element {

	/**
	 * Set the x-Position of the element
	 * @param x
	 */
	public void setX(int x);

	/**
	 * Set the y-Position of the element
	 * @param y
	 */
	public void setY(int y);

	/**
	 * Get the x-Positon of the element
	 * @return x-Position
	 */
	public int getX();

	/**
	 * Get the y-Positon of the element
	 * @return y-Positon
	 */
	public int getY();

	/**
	 * Draws the element to the screen. You do not have to invoke this method, it is done automatically once the element is registered.
	 */
	public void drawElement();
	
}
