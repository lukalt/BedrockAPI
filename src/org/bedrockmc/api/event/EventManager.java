package org.bedrockmc.api.event;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.bedrockmc.api.mod.Mod;

public class EventManager {

	private Map<Class<? extends Event>,
	TreeMap<EventPriority, Set<RegisteredEvent>>> registeredEvents = new HashMap<Class<? extends Event>, TreeMap<EventPriority, Set<RegisteredEvent>>>();

	@SuppressWarnings("unchecked")
	public void registerEvents(Mod mod, Listener listener) {
		
		Class<? extends Listener> clazz = listener.getClass();

		for (Method method : clazz.getDeclaredMethods()) {
			System.out.println(method.getName());
			System.out.println(method.getAnnotations().length);
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
			if (registeredEvents.containsKey(eventClass)) {
				map = registeredEvents.get(eventClass);
			} else {
				map = new TreeMap<EventPriority, Set<RegisteredEvent>>();
				registeredEvents.put(eventClass, map);
			}
			Set<RegisteredEvent> set = null;
			if (map.containsKey(priority)) {
				set = map.get(priority);
			} else {
				set = new HashSet<RegisteredEvent>();
			}
			set.add(registeredEvent);
			map.put(priority, set);
			System.out.println("Registered event: "
					+ method.getDeclaringClass().getName() + "#"
					+ method.getName() + "(" + eventClass.getName()
					+ ")  Priority: " + priority.name());
			System.out.println(registeredEvents);
		}

	}

	public void callEvent(Event event) {
		System.out.println("Calling event " + event.getClass().getSimpleName());
		if (registeredEvents.containsKey(event.getClass())) {
			System.out.println("seems to be registered");
			TreeMap<EventPriority, Set<RegisteredEvent>> treeMap = registeredEvents
					.get(event);
			for (EventPriority pr : treeMap.keySet()) {
				System.out.println(pr);
				for (RegisteredEvent registeredEvent : treeMap.get(pr)) {
					try {
						System.out.println("Invoking method");
						registeredEvent.getMethod().invoke(
								registeredEvent.getListener(), registeredEvent);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
