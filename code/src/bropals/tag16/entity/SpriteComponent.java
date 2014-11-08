package bropals.tag16.entity;

import java.awt.Graphics2D;

public class SpriteComponent extends EntityComponent {
	
	
	public void draw(Graphics2D g2) {
		// to override in subclasses
	}
	
	@Override
	public Object clone() {
		return new SpriteComponent();
	}
	
}