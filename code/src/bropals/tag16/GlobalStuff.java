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
	private static Entity playerEntity = null, robotEntity = null;
	/**
		A boolean value that says whether or not the player is 
		in combat. The player is in combat when he is being chased
		by an enemy or in line of sight of an enemy.
	*/
	private static boolean inCombat = false;
	
	public static int getScrapAmount() { return scrapAmount; }
	public static void setScrapAmount(int s) { scrapAmount = s; }
	
	public static Entity getPlayerEntity() { return playerEntity; }
	public static void setPlayerEntity(Entity e) { playerEntity = e; }
	
	public static Entity getRobotEntity() { return robotEntity; }
	public static void setRobotEntity(Entity e) { robotEntity = e; }
	
	public static boolean isInCombat() { return inCombat; }
	public static void setInCombat(boolean c) { inCombat = c; }
}
