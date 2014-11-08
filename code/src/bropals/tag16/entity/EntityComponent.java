package bropals.tag16.entity;

public abstract class EntityComponent {
	
	/**
		A reference to the Entity this component is in
	*/
	private Entity parent;
	
	public void setParent(Entity parent) {
		this.parent=parent;
	}
	
	public Entity getParent() {
		return parent;
	}
}