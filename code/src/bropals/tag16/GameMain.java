package bropals.tag16;

import bropals.tag16.state.GameStateRunner;
import bropals.tag16.draw.GameWindow;

public class GameMain {
	
	/**
		The name of the game
	*/
	public static final String GAME_NAME = "Untitled1";
	
	public static void main(String[] args) {
		System.out.println("Game");
		//Create the graphics
		GameWindow.getGameWindow().initGraphics();
		//Set the game to its initial state 
		//TO DO
		//Run the game
		GameStateRunner.getGameStateRunner().loop();
		System.out.println("Exiting normally");
	}
}