package bropals.tag16.entity;

import java.util.HashMap;
import java.awt.Rectangle;

public class Entities {
	
	private static Entities entities = new Entities();
	
	public static Entities getEntities() {
		return entities;
	}
	
	private HashMap<String, Entity> es;
	
	public Entities() {
		es = new HashMap<String, Entity>();
	}
	
	/**
		Make a new entity of the given name
		@param entityName The name of the entity. This is the entity's type
		@param x the new entity's world coordinate X
		@param y the new entity's world coordinate Y
		@return the newly created Entity
	*/
	public Entity createEntity(String entityName, float x, float y) {
		Entity copy = (Entity)es.get(entityName).clone();
		copy.setX(x);
		copy.setY(y);
		return copy;
	}
	
	/**
		Make a parse string based on an Entity
	*/
	public String makeEntityParseString(Entity e) {
		return "" + e.getName() + " " + e.getX() + " " + e.getY();
	}
	
	/**
		Adds an entity to the list by being given the parse string from
		entities.data.
		@param parseString the string used to represent the entity
	*/
	public void mapEntity(String parseString) {
		/*
			Format:
			name behavior-class collision-class block-num w h x y w h y w h ... animation
		*/
		String[] split = parseString.split(" ");
		String name = split[0];
		BehaviorComponent bc = null;
		CollisionComponent cc = null;
		SpriteComponent sc = null;
		try {
			Class bcc = Class.forName("bropals.tag16.entity." + split[1]);
			bc = (BehaviorComponent)bcc.newInstance();
		} catch(Exception e) {
			System.out.println("Could not instantiate behavior component: " + e.toString());
		}
		try {
			Class ccc = Class.forName("bropals.tag16.entity." + split[2]);
			int blockNum = Integer.parseInt(split[3]);
			Rectangle[] rects = new Rectangle[blockNum];
			int index = 4;
			for (int i=0; i<blockNum; i++) {
				int x = Integer.parseInt(split[index]);
				index++;
				int y = Integer.parseInt(split[index]);
				index++;
				int w = Integer.parseInt(split[index]);
				index++;
				int h = Integer.parseInt(split[index]);
				index++;
				rects[i] = new Rectangle(x, y, w, h);
			}
			cc = (CollisionComponent)ccc.newInstance();
			cc.setRectangles(rects);
		} catch(Exception e) {
			System.out.println("Could not instantiate collision component: " + e.toString());
		}
		try {
			
		} catch(Exception e) {
			System.out.println("Could not instantiate sprite component: " + e.toString());
		}
		//Now put it all into an entity and map it
		Entity e = new Entity(name, bc, cc, sc, 0, 0);
		es.put(name, e);
	}
}