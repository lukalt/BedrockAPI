package org.bedrockmc.api.overlay;

public abstract class Overlay {

	private RenderManager renderManager;
	
	public Overlay(RenderManager renderManager) {
		this.renderManager = renderManager;
	}
	
	/**
	 * Get the render manager
	 * @return render maanger
	 */
	public RenderManager getRenderManager() {
		return this.renderManager;
	}
	
	/**
	 * Called when the overlay is rendered
	 * @param mouseX
	 * @param mouseY
	 */
	public abstract void render(int mouseX, int mouseY);
	
}
