package bropals.tag16.draw;

import java.awt.image.BufferedImage;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import bropals.tag16.GameMain;

public class GameWindow {
	
	private static GameWindow gameWindow = new GameWindow();
	
	public static GameWindow getGameWindow() {
		return gameWindow;
	}
	
	/**
		The size of the buffer
	*/
	public static final int BUFFER_WIDTH = 1280, BUFFER_HEIGHT = 720;
	
	/**
		The camera properties
	*/
	private float camX, camY;
	private float zoomFactor;
	
	/**
		The buffer that everything is drawn on
	*/
	private BufferedImage buffer;
	
	/**
		The buffer strategy
	*/
	private BufferStrategy bs;
	
	/**
		The input buffers
	*/
	private int keyBuffer;
	private int mouseXBuffer;
	private int mouseYBuffer;
	private int mousePositionX;
	private int mousePositionY;
	private boolean keyPressed;
	private boolean mousePressed;
	
	/**
		The game frame
	*/
	private Frame frame;
	
	public void initGraphics() {
		zoomFactor = 1.0f;
		camX = 0;
		camY = 0;
		bs = null;
		keyBuffer = -1;
		mouseXBuffer = -1;
		mouseYBuffer = -1;
		keyPressed = false;
		mousePressed = false;
		mousePositionX = -1;
		mousePositionY = -1;
		/*
			Make the graphics
		*/
		buffer = new BufferedImage(BUFFER_WIDTH, BUFFER_HEIGHT, BufferedImage.TYPE_INT_RGB);
		frame = new Frame(GameMain.GAME_NAME);
		frame.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				//Transform the mouse position to world coordinates
				
				mousePressed = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				//Transform the mouse position to world coordinates
				
				mousePressed = false;
			}
		});
		frame.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				keyBuffer = e.getKeyCode();
				keyPressed = true;
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				keyBuffer = e.getKeyCode();
				keyPressed = false;
			}
		});
		frame.addComponentListener(new ComponentAdapter() {
			
			@Override
			public void componentResized(ComponentEvent e) {
				resizeFrame();
			}
		});
		frame.setSize(800, 600);
		frame.setIgnoreRepaint(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		System.out.println("Created the game window");
	}
	
	public Graphics getDrawGraphics() {
		return buffer.getGraphics();
	}
	
	/**
		Draws the buffer to the screen so it is displayed.
		@param g The graphics object that was obtained through getDrawGraphics
	*/
	public void swapBuffers(Graphics g) {
		g.dispose();
		Graphics bg = bs.getDrawGraphics();
		bg.drawImage(buffer, getInsetX(), getInsetY(), getScreenWidth(), getScreenHeight(), null);
		bg.dispose();
		bs.show();
	}
	
	public void resizeFrame() {
		if (bs!=null) {
			bs.dispose();
		}
		frame.createBufferStrategy(2);
		bs = frame.getBufferStrategy();
	}
	
	public float getCameraX() {
		return camX;
	}
	
	public float getCameraY() {
		return camY;
	}
	
	public float getZoomFactor() {
		return zoomFactor;
	}
	
	public void setCameraPosition(float x, float y) {
		camX = x;
		camY = y;
	}
	
	public void setZoomFactor(float zoomFactor) {
		this.zoomFactor = zoomFactor;
	}
	
	public void translateCamera(float x, float y) {
		camX += x;
		camY += y;
	}
	
	public int getScreenWidth() {
		return frame.getWidth()-frame.getInsets().right-frame.getInsets().left;
	}
	
	public int getScreenHeight() {
		return frame.getHeight()-frame.getInsets().top-frame.getInsets().bottom;
	}
	
	public int getInsetX() {
		return frame.getInsets().left;
	}
	
	public int getInsetY() {
		return frame.getInsets().top;
	}
}