package org.bedrockmc.api.event.player;

import org.bedrockmc.api.entity.Player;
import org.bedrockmc.api.event.SimpleEvent;

public class PlayerRespawnEvent extends SimpleEvent {

	private Player player;

	public PlayerRespawnEvent(Player player) {
		super();
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
