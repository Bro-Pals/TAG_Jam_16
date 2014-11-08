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
		
		//super cool player animations
		BufferedImage superCoolAnimSheet = ImageInput.loadImage("assets/img/playerSpriteSheet.png", "PlayerSheet");
		BufferedImage[][] playerAnimImages = new BufferedImage[1][3];
		playerAnimImages[0] = {superCoolAnimSheet.getSubImage(0, 0, 60, 100),
							   superCoolAnimSheet.getSubImage(60, 0, 60, 100),
							   superCoolAnimSheet.getSubImage(120, 0, 60, 100)}
							   
	    animation.put("Player", new Animation(playerAnimImages));
	}
}