package org.bedrockmc.api.event.world;

import java.util.List;

import org.bedrockmc.api.Location;
import org.bedrockmc.api.chat.ChatMessage;
import org.bedrockmc.api.event.CancellableEvent;

public class SignUpdateEvent extends CancellableEvent {

	private Location location;
	private List<ChatMessage> text;

	public SignUpdateEvent(Location location, List<ChatMessage> text) {
		super();
		this.location = location;
		this.text = text;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<ChatMessage> getText() {
		return text;
	}

	public void setText(List<ChatMessage> text) {
		this.text = text;
	}

	@Override
	public void onInvoke() {
	}

	@Override
	public void onRegister() {
	}

	@Override
	public void onUnregister() {
	}
}
