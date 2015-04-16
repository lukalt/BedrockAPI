package org.bedrockmc.api.event.player;

import org.bedrockmc.api.entity.Player;
import org.bedrockmc.api.event.SimpleEvent;

public class PlayerKickEvent extends SimpleEvent implements PlayerEvent  {
	
	private Player player;
	
	public PlayerKickEvent(Player player) {
		
	}
	
	@Override
	public Player getPlayer() {
		return this.player;
	}

}
