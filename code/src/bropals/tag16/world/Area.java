package bropals.tag16.world;

import java.util.ArrayList;
import bropals.tag16.entity.Entity;

public class Area {
	
	private ArrayList<Entity> entities;
	
	public Area() {
		entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void removeEntity(Entity e) {
		entities.remove(e);
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
}