package org.bedrockmc.api.event;

import java.lang.reflect.Method;

public class RegisteredEvent {

	private Class<? extends Event> eventType;

	private EventPriority priority;

	private Method method;

	private Listener listener;

	public RegisteredEvent(Class<? extends Event> eventType,
			EventPriority priority, Method method, Listener listener) {
		super();
		this.eventType = eventType;
		this.priority = priority;
		this.method = method;
		this.listener = listener;
	}

	public Listener getListener() {
		return listener;
	}

	public void setListener(Listener listener) {
		this.listener = listener;
	}

	public Class<? extends Event> getEventType() {
		return eventType;
	}

	public void setEventType(Class<? extends Event> eventType) {
		this.eventType = eventType;
	}

	public EventPriority getPriority() {
		return priority;
	}

	public void setPriority(EventPriority priority) {
		this.priority = priority;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

}
