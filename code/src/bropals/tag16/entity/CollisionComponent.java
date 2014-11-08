package bropals.tag16.entity;

import java.awt.Rectangle;

public class CollisionComponent extends EntityComponent {
	
	/**
		The size and shape of the boxes.
		The FIRST Rectangle in the array is where the
		Entity's position is based on. All the other
		rectangles' positions is the offset from the
		first rectangle's top left corner.
	*/
	private Rectangle[] boxes;
	
	public CollisionComponent(Rectangle[] b) {
		boxes = b;
	}
	
	public CollisionComponent(Rectangle box) {
		boxes = new Rectangle[]{box};
	}
	
	@Override
	public Object clone() {
		return new CollisionComponent(boxes);
	}
	
}