package org.bedrockmc.api.mod;

import java.util.List;

import org.bedrockmc.api.Client;
import org.bedrockmc.api.overlay.Overlay;

public interface Mod {

	/**
	 * Called when the mod is enabled.
	 */
	public void onEnable();
	
	/**
	 * Called when the mod is disabled.
	 */
	public void onDisable();
	
	/**
	 * Called when the mod is loaded.
	 */
	public void onLoad();
	
	/**
	 * Get the name of the mod
	 * @return mod name
	 */
	public String getName();
	
	/**
	 * Get the mod description
	 * @return mod description
	 */
	public ModDescriptionFile getDescription();
	
	public boolean isEnabled();
	
	/**
	 * Return the client instance
	 * @return
	 */
	public Client getClient();
	
	/**
	 * Get all overlays of the mod
	 * @return overlay
	 */
	public List<Overlay> getOverlays();

}
