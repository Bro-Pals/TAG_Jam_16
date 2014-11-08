package bropals.tag16;

import bropals.tag16.entity.Entity;

public class GlobalStuff {
	
	/**
		How much scrap the player is holding
	*/
	private static int scrapAmount = 0;
	
	/**
		The references to the Player entitiy and the Robot entity
	*/
	private Entity playerEntity = null, robotEntity = null;
	/**
		A boolean value that says whether or not the player is 
		in combat. The player is in combat when he is being chased
		by an enemy or in line of sight of an enemy.
	*/
	private boolean inCombat = false;
	
	public int getScrapAmount() { return scrapAmount; }
	public void setScrapAmount(int s) { scrapAmount = s; }
	
	public Entity getPlayerEntity() { return playerEntity; }
	public void setPlayerEntity(Entity e) { playerEntity = e; }
	
	public Entity getRobotEntity() { return robotEntity; }
	public void setRobotEntity(Entity e) { robotEntity = e; }
	
	public boolean isInCombat() { return inCombat; }
	public void setInCombat(boolean c) { inCombat = c; }
}
