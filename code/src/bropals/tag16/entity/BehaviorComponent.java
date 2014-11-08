package bropals.tag16.entity;

public class BehaviorComponent extends EntityComponent {
	
	public void updateParent() {
		// to override
	}
	
	public void attack() {
		//to override. This is what happens when the Entity "attacks"
	}
	
	/**
		Called when another entity collides with this on.
		@param e The entity object that collided with the
				parent of the component
	*/
	public void onCollide(Entity e) {
		// to override. What happens during collisions
	}
	
	@Override
	public Object clone() {
		return new BehaviorComponent();
	}
	
}