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
	
	public CollisionComponent() {
		
	}
	
	public CollisionComponent(Rectangle[] b) {
		boxes = b;
	}
	
	public void setRectangles(Rectangle[] bs) {
		boxes = bs;
	}
	
	public CollisionComponent(Rectangle box) {
		boxes = new Rectangle[]{box};
	}
	
	public Rectangle[] getBoxes() {
		return boxes;
	}
	
	@Override
	public Object clone() {
		return new CollisionComponent(boxes);
	}

}