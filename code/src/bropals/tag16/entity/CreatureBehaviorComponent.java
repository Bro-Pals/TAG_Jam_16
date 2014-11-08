package bropals.tag16.entity;

import java.awt.Rectangle;

public class CreatureBehaviorComponent extends BehaviorComponent {
	
	@Override
	public void update() {
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
		
			
	}
	
	@Override
	public Object clone() {
		return new BehaviorComponent();
	}
	
}