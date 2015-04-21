package org.bedrockmc.api.event.player;

import org.bedrockmc.api.chat.ChatMessage;
import org.bedrockmc.api.event.CancellableEvent;

public class InventoryOpenEvent extends CancellableEvent {
	private int windowId;
	private String type;
	private ChatMessage title;

	public InventoryOpenEvent(int windowId, String type, ChatMessage title) {
		super();
		this.windowId = windowId;
		this.type = type;
		this.title = title;
	}

	public ChatMessage getTitle() {
		return title;
	}

	public int getWindowId() {
		return windowId;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
