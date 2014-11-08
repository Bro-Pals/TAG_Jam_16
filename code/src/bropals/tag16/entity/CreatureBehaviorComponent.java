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
		String[] stuffYouCantCollide = getThingsCantCollideWith();
		for (int i = 0; i<stuffYouCantCollide.length; i++) {
			if (e.getName().equals(stuffYouCantCollide[i])) {
				return; // STOP because we can't collide with that thing
			}
		}
		Rectangle[] yourBoxes = getParent().getCollision().getBoxes();
		Rectangle[] theirBoxes = e.getCollision().getBoxes();
		int yourxTrans = (int)getParent().getX();
		int youryTrans = (int)getParent().getY();
		int theirxTrans = (int)e.getX();
		int theiryTrans = (int)e.getY();
		for (int i=0; i<yourBoxes.length; i++) {
			for (int j=0; j<theirBoxes.length; j++) {
				// put them both in the extreme world coordinates for checking
				yourBoxes[i].translate(yourxTrans, youryTrans);
				theirBoxes[j].translate(theirxTrans, theiryTrans);
			}
		}
		
		// check collisions and then deal with it
		for (int i=0; i<yourBoxes.length; i++) {
			for (int j=0; j<theirBoxes.length; j++) {
				Rectangle ir = yourBoxes[i].intersection(theirBoxes[j]);
				if (ir.getWidth() > 0 || ir.getHeight() > 0) {
					// this should totally deal with it now and move everything
					getParent().setX(getParent().getX() - (float)ir.getWidth());
					getParent().setX(getParent().getY() - (float)ir.getHeight());
					break;
				}
			}
		}
		
		// put them both back into the local space
		for (int i=0; i<yourBoxes.length; i++) {
			for (int j=0; j<theirBoxes.length; j++) {
				yourBoxes[i].translate(-yourxTrans, -youryTrans);
				theirBoxes[j].translate(-theirxTrans, -theiryTrans);
			}
		}
			
	}
	
	@Override
	public Object clone() {
		return new BehaviorComponent();
	}
	
}