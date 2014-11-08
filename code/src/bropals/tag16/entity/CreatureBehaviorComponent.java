package bropals.tag16.entity;

public class CreatureBehaviorComponent extends BehaviorComponent {
	
	@Override
	public void updateParent() {
		// to override
	}
	
	@Override
	public void attack() {
		//to override. This is what happens when the Entity "attacks"
	}
	
	@Override
	public void onCollide(Entity e) {
		// to override. What happens during collisions
	}
	
	@Override
	public Object clone() {
		return new BehaviorComponent();
	}
	
}