package bropals.tag16.state;

public class GameStateRunner {
	
	private static GameStateRunner gameStateRunner = new GameStateRunner();
	
	public static GameStateRunner getGameStateRunner() {
		return gameStateRunner;
	}
	
	public static long MILLISECONDS_PER_FRAME = 20;
	
	private GameState currentState;
	private GameState requestedState;
	private boolean gameRunning;
	
	/**
		Timing variables
	*/
	private long before, delta;
	
	public GameStateRunner() {
		currentState = null;
		requestedState = null;
		gameRunning = false;
	}
	
	public boolean isGameRunning() {
		return gameRunning;
	}
	
	public void stopGame() {
		gameRunning = false;
	}
	
	public void setGameState(GameState state) {
		this.requestedState = state;
	}
	
	public void loop() {
		gameRunning = true;
		before = 0;
		delta = 0;
		while(gameRunning) {
			before = System.currentTimeMillis();
			if (requestedState!=null) {
				currentState = requestedState;
			}
			if (currentState!=null) {
				//Run that game state!
				
			}
			delta = System.currentTimeMillis()-before;
			if (delta < MILLISECONDS_PER_FRAME) {
				try {
					Thread.sleep(MILLISECONDS_PER_FRAME - delta);
				} catch(Exception e) {
					
				}
			} else {
				System.err.println("A frame took longer than " + MILLISECONDS_PER_FRAME + " milliseconds");
			}
		}
		//Clean up
	}
}