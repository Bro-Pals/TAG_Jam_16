package bropals.tag16.entity;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import bropals.tag16.draw.GameWindow;

public class PlayerBehaviorComponent extends CreatureBehaviorComponent {
	
	private boolean left, right;
	private float playerSpeed; 
	
	public PlayerBehaviorComponent() {
		left=false;
		right=false;
		playerSpeed = 3; // in world coordinates????
	}
	
	@Override
	public void update() {
		// handle any key presses
		int keyPressed = GameWindow.getKeyBuffer();
		boolean keyDown = GameWindow.getKeyPressed();
		if (keyPressed != -1) {
			if (keyPressed == KeyEvent.VK_D) {
				right = keyDown;
				if (left == true) left = false;
			}
			if (keyPressed == KeyEvent.VK_A) {
				left = keyDown;
				if (right == true) right = false;
			}
		}
		
		if (right) {
			getParent().setVelX(playerSpeed);
		} else if (left) {
			getParent().setVelX(-playerSpeed);
		} else if (!left && !right) {
			getParent().setVelX(0); // stop moving
		}
	}
	
	@Override
	public void attack() {
		//to override
	}
	
	@Override
	public void onCollide(Entity e) {
			
	}
	
	@Override
	public Object clone() {
		return new BehaviorComponent();
	}
	
}