package bropals.tag16.entity;

import java.awt.Graphics2D;
import bropals.tag16.draw.Animation;
import static bropals.tag16.CoordinateSystem.*;

public class SpriteComponent extends EntityComponent {
	
	private Animation animation;
	
	public void draw(Graphics2D g2) {
		// to override in subclasses
		int x = worldToCameraX(getParent().getX());
		int y = worldToCameraY(getParent().getY());
		g2.drawImage(animation.getCurrentFrame(), x, y, null);
		System.out.println("Here");
		
	}
	
	@Override
	public Object clone() {
		return new SpriteComponent();
	}
	
	public void setAnimation(Animation a) {
		this.animation = a;
	}
	
	public Animation getAnimation() {
		return animation;
	}
}