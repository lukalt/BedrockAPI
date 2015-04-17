package org.bedrockmc.api.event;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.bedrockmc.api.mod.Mod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EventManager {

	private Map<String,TreeMap<EventPriority, Set<RegisteredEvent>>> registeredEvents = new HashMap<String, TreeMap<EventPriority, Set<RegisteredEvent>>>();

	/**
	 * Register a new listener. All methods where the @EventHandler annotation is present will be registered.
	 * @param mod
	 * @param listener
	 */
	@SuppressWarnings("unchecked")
	public void registerEvents(Mod mod, Listener listener) {
		
		Class<? extends Listener> clazz = listener.getClass();

		for (Method method : clazz.getDeclaredMethods()) {
			try {
				Annotation an = method.getAnnotation(EventHandler.class);
				if(an == null) {
					continue;
				}
			}catch(Exception ex) {
				continue;
			}
			if (method.getParameterTypes().length != 1) {
				continue;
			}
			EventHandler eventHandler = method
					.getAnnotation(EventHandler.class);
			Class<? extends Event> eventClass = (Class<? extends Event>) method
					.getParameterTypes()[0];
			EventPriority priority = eventHandler.priority();
			RegisteredEvent registeredEvent = new RegisteredEvent(eventClass,
					priority, method, listener);
			TreeMap<EventPriority, Set<RegisteredEvent>> map = null;
			if (registeredEvents.containsKey(eventClass.getName())) {
				map = registeredEvents.get(eventClass.getName());
			} else {
				map = new TreeMap<EventPriority, Set<RegisteredEvent>>();
				registeredEvents.put(eventClass.getName(), map);
			}
			Set<RegisteredEvent> set = null;
			if (map.containsKey(priority)) {
				set = map.get(priority);
			} else {
				set = new HashSet<RegisteredEvent>();
			}
			set.add(registeredEvent);
			map.put(priority, set);			
		}

	}

	/**
	 * Call an event
	 * @param event
	 */
	public void callEvent(Event event) {
		if (registeredEvents.containsKey(event.getClass().getName())) {
			TreeMap<EventPriority, Set<RegisteredEvent>> treeMap = registeredEvents.get(event.getClass().getName());
			System.out.println(treeMap.size());
			for (EventPriority pr : treeMap.keySet()) {
				Set<RegisteredEvent> set = treeMap.get(pr);

				for (RegisteredEvent registeredEvent : set) {
					try {
						registeredEvent.getMethod().invoke(
								registeredEvent.getListener(), event);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
