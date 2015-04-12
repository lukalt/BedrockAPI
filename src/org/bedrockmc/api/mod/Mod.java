package org.bedrockmc.api.mod;

import java.util.List;

import org.bedrockmc.api.Client;
import org.bedrockmc.api.overlay.Overlay;

public interface Mod {

	public void onEnable();
	
	public void onDisable();
	
	public void onLoad();
	
	public String getName();
	
	public ModDescriptionFile getDescription();
	
	public boolean isEnabled();
	
	public Client getClient();
	
	public List<Overlay> getOverlays();
}
