package org.bedrockmc.api.event.chat;

import org.bedrockmc.api.event.CancellableEvent;

public class ChatSendEvent extends CancellableEvent {

	private String message;

	public ChatSendEvent(String message) {
		this.message = message;
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

	public void setMessage(String message) {
		this.message = message;
	}

}
