package org.bedrockmc.api.event.chat;

import org.bedrockmc.api.event.CancellableEvent;

public class ChatReceiveEvent extends CancellableEvent {

	private String message;
	private String coloredMessage;
	private int position;
	
	public ChatReceiveEvent(String message, String coloredMessage, int position) {
		super();
		this.message = message;
		this.coloredMessage = coloredMessage;
		this.position = position;
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

	public String getMessage() {
		return message;
	}

	public String getColoredMessage() {
		return coloredMessage;
	}
	
	public int getPosition() {
		return this.position;
	}

}
