package bropals.tag16.draw;

import java.util.HashMap;

public class Animations {
	
	private static Animations animations = new Animations();
	
	private HashMap<String, Animation> animation;
	
	public Animations() {
		animation = new HashMap<String, Animation>();
		initAnimation();
	}
	
	public Animation getAnimation(String name) {
		return (Animation)animation.get(name).clone();
	}
	
	public final void initAnimation() {
		
	}
}