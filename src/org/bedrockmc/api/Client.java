package org.bedrockmc.api;

import java.awt.image.BufferedImage;

import org.bedrockmc.api.entity.Player;
import org.bedrockmc.api.event.EventManager;
import org.bedrockmc.api.gui.GuiListener;
import org.bedrockmc.api.gui.GuiScreenType;
import org.bedrockmc.api.gui.ModGuiScreen;
import org.bedrockmc.api.mod.ModIcon;
import org.bedrockmc.api.overlay.RenderManager;
import org.bedrockmc.api.world.World;

public interface Client {

	/**
	 * Add a chat message to the client chat
	 * @param message
	 */
	public void addChatMessage(String message);
	
	/**
	 * Send a chat message to the server
	 * @param message
	 */
	public void sendChatMessage(String message);
	
	/**
	 * Gets the current player.
	 * @return
	 */
	public Player getPlayer();
	
	/**
	 * Returns wether the player is ingame or not
	 * @return
	 */
	public boolean isIngame();
	
	/**
	 * Connects to the specified address
	 */
	public void connectToServer(String address);
	
	/**
	 * Gets the current ModManager instance
	 * @return ModManager instance
	 */
	public ModManager getModManager();
	
	/**
	 *	Returns the current EventManager 
	 * @return EventManager
	 */
	public EventManager getEventManager();
	
	/**
	 * Stop Minecraft
	 */
	public void shutdown();
	
	/**
	 * Return the current Server Name
	 * @return Server Port
	 */
	public String getServerName();
	
	/**
	 * Returns the current Server Port
	 * @return Server Port
	 */
	public int getServerPort();
	
	/**
	 * Returns the current world
	 * @return loaded wolrd
	 */
	public World getWorld();
	
	/**
	 * Open a gui screen
	 * @param gui
	 */	
	public void openGuiScreen(ModGuiScreen gui);
	
	/**
	 * Create a new gui screen
	 * @param listener
	 * @param type
	 * @return gui screen
	 */
	public ModGuiScreen createGuiScreen(GuiListener listener, GuiScreenType type);
	
	/**
	 * Create a new gui screen
	 * @param listener
	 * @return gui screen
	 */
	public ModGuiScreen createGuiScreen(GuiListener listener);
	
	/**
	 * Get current system time
	 * @return system time
	 */
	public long getSystemTime();
	
	/**
	 * @return isUnicode
	 */
	public boolean isUnicode();
	
	/**
	 * @returm render manager
	 */
	public RenderManager getRenderManager();
	
	public ModIcon createModIcon(BufferedImage image);
	
	public int getMinecraftVersionCode();
	
	public String getMinecraftVersion();
	
	public int getBedrockVersionCode();
	
	public String getBedrockVersion();

}
