package bropals.tag16.entity;

import java.awt.Graphics2D;
import bropals.tag16.draw.Animation;

public class SpriteComponent extends EntityComponent {
	
	private Animation animation;
	
	public void draw(Graphics2D g2) {
		// to override in subclasses
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