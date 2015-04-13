package org.bedrockmc.api.overlay;

public interface RenderManager {

	/**
	 * Draw a string on the gui
	 * @param x-Position
	 * @param y-Position
	 * @param String
	 */
	public void drawString(int x, int y, String s);
	
	/**
	 * Draw a string on the gui
	 * @param x
	 * @param y
	 * @param string
	 * @param color
	 */
	public void drawString(int x, int y, String s, int color);
	
	/**
	 * Draw a rectangle on the screen
	 * @param left
	 * @param top
	 * @param right
	 * @param bottom
	 * @param color
	 */
	public void drawRect(int left, int top, int right, int bottom, int color);
	
	/**
	 * Draw a horizontal line on the screen
	 * @param x from
	 * @param x to
	 * @param y
	 * @param color
	 */
	public void drawHorizontalLine(int x, int x2, int y, int color);
	
	/**
	 * Draw a vertical line on the screen
	 * @param x
	 * @param y from
	 * @param y to
	 * @param color
	 */
	public void drawVerticalLine(int x, int y1, int y2, int color);
	
	/**
	 * Get the scaled width
	 * @return scaled width
	 */
	public int getWidth();
	
	/**
	 * Get the scaled height
	 * @return scaled height
	 */
	public int getHeight();
	
}
