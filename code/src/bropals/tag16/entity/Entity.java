package bropals.tag16.entity;

public class Entity {
	
	private BehaviorComponent behavior;
	private CollisionComponent collision;
	private SpriteComponent sprite;
	
	private float x, y, velX, velY, accX, accY;
	
	public Entity(BehaviorComponent b, CollisionComponent c, SpriteComponent s, float x, float y) {
		behavior = b;
		behavior.setParent(this);
		collision = c;
		collision.setParent(this);
		sprite = s;
		sprite.setParent(this);
		this.x=x;
		this.y=y;
		velX = 0;
		velY = 0;
		accX = 0;
		accY = 0;
	}
	
	@Override
	public Object clone() {
		return new Entity((BehaviorComponent)behavior.clone(), 
			(CollisionComponent)collision.clone(),
			(SpriteComponent)sprite.clone(), x, yd);
	}
	
	public BehaviorComponent getBehavior() {
		return behavior;
	}
	
	public CollisionComponent getCollision() {
		return collision;
	}
	
	public SpriteComponent getSprite() {
		return sprite;
	}
	
	// Gettings for all the stuffers
	public float getX() { return x; }
	public float getY() { return y; }
	public float getVelY() { return velY; }
	public float getVelX() { return velX; }
	public float getAccX() { return accX; }
	public float getAccY() { return accY; }
	
	// Setters for all the stuffers
	public void setX(float x) { this.x=x; }
	public void setY(float y) { this.y=y; }
	public void setVelY(float vely) { this.velY=vely; }
	public void setVelX(float velx) { this.velX=velx; }
	public void setAccX(float accx) { this.accX=accx; }
	public void setAccY(float accy) { this.accY=accy; }
}