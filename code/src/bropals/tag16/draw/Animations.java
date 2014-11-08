package bropals.tag16.draw;

import java.util.HashMap;
import java.awt.image.BufferedImage;
import bropals.tag16.io.ImageInput;

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
		playerAnimImages[0] = new BufferedImage[]{superCoolAnimSheet.getSubimage(0, 0, 60, 100),
							   superCoolAnimSheet.getSubimage(60, 0, 60, 100),
							   superCoolAnimSheet.getSubimage(120, 0, 60, 100)};
							   
	    animation.put("Player", new Animation(playerAnimImages));
	}
}