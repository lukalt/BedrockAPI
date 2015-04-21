package org.bedrockmc.api.event;

public abstract class CancellableEvent implements Event {

	@Override
	public void onInvoke() {
	}

	@Override
	public void onRegister() {
	}

	@Override
	public void onUnregister() {
	}

	private boolean cancelled = false;

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}
