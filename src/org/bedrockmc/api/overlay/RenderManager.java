package org.bedrockmc.api.overlay;

public interface RenderManager {

	public void drawString(int x, int y, String s);
	
	public void drawString(int x, int y, String s, int color);
	
	public void drawRect(int left, int top, int right, int bottom, int color);
	
	public void drawHorizontalLine(int x, int x2, int y, int color);
	
	public void drawVerticalLine(int x, int y1, int y2, int color);
	
	public int getWidth();
	
	public int getHeight();
	
}
