package org.bedrockmc.api.event.player;

import org.bedrockmc.api.entity.Player;
import org.bedrockmc.api.event.SimpleEvent;

public class PlayerJoinGameEvent extends SimpleEvent implements PlayerEvent {

	private boolean singlePlayer;
	private Player player;
	private String serverAddress;

	public PlayerJoinGameEvent(boolean singlePlayer, Player player,
			String serverAddress) {
		super();
		this.singlePlayer = singlePlayer;
		this.player = player;
		this.serverAddress = serverAddress;
	}

	@Override
	public Player getPlayer() {
		return this.player;
	}

	public boolean isSinglePlayer() {
		return singlePlayer;
	}

	public void setSinglePlayer(boolean singlePlayer) {
		this.singlePlayer = singlePlayer;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
