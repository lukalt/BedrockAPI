package org.bedrockmc.api.event.player;

import org.bedrockmc.api.chat.ChatMessage;
import org.bedrockmc.api.entity.Player;
import org.bedrockmc.api.event.SimpleEvent;

public class PlayerKickEvent extends SimpleEvent implements PlayerEvent  {
	
	private Player player;
	private ChatMessage message;
	
	public PlayerKickEvent(Player player,ChatMessage message) {
		this.player = player;
		this.message = message;
	}
	
	@Override
	public Player getPlayer() {
		return this.player;
	}

	public ChatMessage getMessage() {
		return message;
	}

	public void setMessage(ChatMessage message) {
		this.message = message;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	

}
