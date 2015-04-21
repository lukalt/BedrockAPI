package org.bedrockmc.api;

import java.io.File;
import java.util.Collection;

import org.bedrockmc.api.mod.Mod;

public interface ModManager {

	public boolean isLoaded(String mod);
	
	public boolean isEnabled(Mod mod);
	
	public Mod getMod(String name);
	
	public Mod loadMod(File file);
	
	public void enableMod(Mod mod);
	
	public void disableMod(Mod mod);
	
	public Collection<Mod> getLoadedMods();
	
	public void reloadMod(Mod mod);
	
	public void unloadMods();
	
	public void unloadMod(Mod mod);
}
