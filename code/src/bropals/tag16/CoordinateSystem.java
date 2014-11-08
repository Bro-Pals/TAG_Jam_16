package bropals.tag16;

import bropals.tag16.draw.GameWindow;

public class CoordinateSystem {
	
	public static int frameToScreenX(int x) {
		return x-GameWindow.getGameWindow().getInsetX();
	}
	
	public static int frameToScreenY(int y) {
		return y-GameWindow.getGameWindow().getInsetY();
	}
	
	public static int screenToBufferX(int x) {
		return (int)((float)GameWindow.BUFFER_WIDTH/(float)GameWindow.getGameWindow().getScreenWidth());
	}
	
	public static int screenToBufferY(int y) {
		return (int)((float)GameWindow.BUFFER_HEIGHT/(float)GameWindow.getGameWindow().getScreenHeight());
	}
	
	
}