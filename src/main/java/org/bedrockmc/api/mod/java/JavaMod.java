package org.bedrockmc.api.mod.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bedrockmc.api.Client;
import org.bedrockmc.api.config.Config;
import org.bedrockmc.api.config.PropertiesConfig;
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
	private File dataFolder;
	private Config config;
	
	public JavaMod(Client client, ModDescriptionFile modDescriptionFile) {
		super();
		this.client = client;
		this.modDescriptionFile = modDescriptionFile;
		this.dataFolder = new File("bedrock-mods", this.modDescriptionFile.getName());
		if(!this.dataFolder.exists()) {
			this.dataFolder.mkdir();
		}
		File configFile = new File(this.dataFolder, "config.properties");
		if(configFile.exists()) {
			try {
				this.config = PropertiesConfig.loadFromFile(configFile);
			}catch(IOException ex) {
				System.out.println("Could not load config of mod " + this.modDescriptionFile.getName());
				ex.printStackTrace();
			}
		}else {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
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
	
	void setFile(File file) {
		this.file = file;
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


	@Override
	public Config getConfig() {
		return this.config;
	}


	@Override
	public void saveConfig() throws IOException {
		this.config.save(new File(this.dataFolder, "config.properties"));
	}


	@Override
	public void reloadConfig() throws IOException {
		throw new IllegalStateException("Not implemented yet.");
	}


	@Override
	public File getDataFolder() {
		return this.dataFolder;
	}
}
