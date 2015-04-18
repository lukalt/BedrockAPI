package org.bedrockmc.api.mod.java;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bedrockmc.api.Client;
import org.bedrockmc.api.mod.Mod;
import org.bedrockmc.api.mod.ModDescriptionFile;
import org.bedrockmc.api.mod.ModIcon;
import org.bedrockmc.api.overlay.Overlay;

public abstract class JavaMod implements Mod {

	private boolean enabled = false;
	private Client client;
	private ModDescriptionFile modDescriptionFile;
	private File file;
	private List<Overlay> overlays = new ArrayList<Overlay>();
	private ModIcon icon;
	
	public JavaMod(Client client, ModDescriptionFile modDescriptionFile) {
		super();
		this.client = client;
		this.modDescriptionFile = modDescriptionFile;
	}


	@Override
	public ModIcon getIcon() {
		return this.icon;
	}

	void setModIcon(ModIcon icon) {
		this.icon = icon;
	}
	
	@Override
	public void onLoad() {
		System.out.println("[" + getDescription().getName()
				+ "] Loading version " + getDescription().getVersion() + " by "
				+ getDescription().getAuthor());

	}

	@Override
	public String getName() {
		return this.getDescription().getName();
	}

	@Override
	public void onDisable() {
		System.out.println("[" + getDescription().getName() + "] Disabling...");
	}

	@Override
	public void onEnable() {
		System.out.println("[" + getDescription().getName()
				+ "] Enabling version " + getDescription().getVersion()
				+ " by " + getDescription().getAuthor());
	}

	public File getFile() {
		return this.file;
	}

	@Override
	public ModDescriptionFile getDescription() {
		return this.modDescriptionFile;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	@Override
	public Client getClient() {
		return client;
	}

	protected void setEnabled(boolean flag) {
		this.enabled = flag;
	}

	@Override
	public List<Overlay> getOverlays() {
		return this.overlays;
	}

	public void addOverlay(Overlay o) {
		overlays.add(o);
	}

	public void removeOverlay(Overlay o) {
		overlays.remove(o);
	}

}
