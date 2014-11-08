package bropals.tag16;

import bropals.tag16.draw.GameWindow;

public class CoordinateSystem {
	
	public static int frameToScreenX(int x) {
		return x-GameWindow.getGameWindow().getInsetX();
	}
	
	public static int frameToScreenY(int y) {
		return y-GameWindow.getGameWindow().getInsetY();
	}
	
	public static int screenToCameraX(int x) {
		return (int)((float)GameWindow.BUFFER_WIDTH/(float)GameWindow.getGameWindow().getScreenWidth());
	}
	
	public static int screenToCameraY(int y) {
		return (int)((float)GameWindow.BUFFER_HEIGHT/(float)GameWindow.getGameWindow().getScreenHeight());
	}
	
	public static float worldToCameraX(float x) {
		return (GameWindow.getGameWindow().getZoomFactor()*x)-GameWindow.getGameWindow().getCameraX();
	}
	
	public static float worldToCameraX(float y) {
		return (GameWindow.getGameWindow().getZoomFactor()*y)-GameWindow.getGameWindow().getCameraY();
	}
	
	public static float cameraToWorldX(float x) {
		return (x-GameWindow.getGameWindow().getCameraX())/GameWindow.getGameWindow().getZoomFactor();
	}
	
	public static float cameraToWorldX(float y) {
		return (y-GameWindow.getGameWindow().getCameraY())/GameWindow.getGameWindow().getZoomFactor();
	}
}