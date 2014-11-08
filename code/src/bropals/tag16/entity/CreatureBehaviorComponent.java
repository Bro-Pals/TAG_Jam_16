package bropals.tag16.entity;

import java.awt.Rectangle;

public class CreatureBehaviorComponent extends BehaviorComponent {
	
	@Override
	public void updateParent() {
		Entity t = getParent();
		// move the entity
		t.setVelX(t.getVelX() + t.getAccX());
		t.setVelY(t.getVelY() + t.getAccY());
		t.setX(t.getX() + t.getVelX());
		t.setY(t.getY() + t.getVelY());
	}
	
	@Override
	public void attack() {
		//to override
	}
	
	@Override
	public void onCollide(Entity e) {
		//if you hit a wall
		if (e.getName().equals("Wall")) {
			Rectangle[] yourBoxes = getParent().getCollision().getBoxes();
			Rectangle[] theirBoxes = e.getCollision().getBoxes();
			double xTrans = yourBoxes[0].getX();
			double yTrans = yourBoxes[0].getY();
			for (int i=0; i<yourBoxes.length; i++) {
				for (int j=0; j<theirBoxes.length; j++) {
					// put them both in the same local coordinate space
					yourBoxes[i].translate(-xTrans, -yTrans);
					theirBoxes[j].translate(-xTrans, -yTrans);
				}
			}
			
			for (int i=0; i<yourBoxes.length; i++) {
				for (int j=0; j<theirBoxes.length; j++) {
					// check collisions and then deal with it
					Rectangle ir = yourBoxes[i].intersection(theirBoxes[j]);
					if (ir.getWidth() > 0 || ir.getHeight() > 0) {
						yourBoxes[0].translate(ir.getWidth(), ir.getHeight());
					}
				}
			}
			
			for (int i=0; i<yourBoxes.length; i++) {
				for (int j=0; j<theirBoxes.length; j++) {
					// put them both back into the world space
					yourBoxes[i].translate(xTrans, yTrans);
					theirBoxes[j].translate(xTrans, yTrans);
				}
			}
			
		}
	}
	
	@Override
	public Object clone() {
		return new BehaviorComponent();
	}
	
}