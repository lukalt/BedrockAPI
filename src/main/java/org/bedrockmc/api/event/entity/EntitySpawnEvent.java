package org.bedrockmc.api.event.entity;

import org.bedrockmc.api.Location;

public class EntitySpawnEvent {
	
	private Location location;
	private int entityId;
	private int entityType;

	public EntitySpawnEvent(Location location, int entityId, int entityType) {
		super();
		this.location = location;
		this.entityId = entityId;
		this.entityType = entityType;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	public int getEntityType() {
		return entityType;
	}

	public void setEntityType(int entityType) {
		this.entityType = entityType;
	}

}
