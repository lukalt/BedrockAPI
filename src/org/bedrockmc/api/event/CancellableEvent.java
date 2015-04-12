package org.bedrockmc.api.event;

public abstract class CancellableEvent implements Event {

	private boolean cancelled = false;

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}
