package org.bedrockmc.api.overlay;

public abstract class Overlay {

	private RenderManager renderManager;
	
	public Overlay(RenderManager renderManager) {
		this.renderManager = renderManager;
	}
	
	public abstract void render(int mouseX, int mouseY);
	
}
