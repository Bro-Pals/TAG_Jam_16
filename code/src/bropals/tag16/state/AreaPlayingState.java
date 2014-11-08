package bropals.tag16.state;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import bropals.tag16.entity.PlayerBehaviorComponent;
import bropals.tag16.entity.CollisionComponent;
import bropals.tag16.entity.SpriteComponent;
import bropals.tag16.entity.Entity;
import java.awt.Rectangle;
import bropals.tag16.GlobalStuff;
import bropals.tag16.world.Area;
import bropals.tag16.io.AreaInputOutput;
import bropals.tag16.io.ImageInput;


public class AreaPlayingState extends GameState {
	
	private Area area;
	
	public AreaPlayingState() {
		area = AreaInputOutput.loadArea("areas/level1.data");
	}
	
	@Override
	public void update() {
		ArrayList<Entity> stuff = area.getEntities();
		for (int e=0; e<stuff.size(); e++) {
			Entity currentEntity = stuff.get(e);
			currentEntity.getBehavior().update(); // update it
			
			currentEntity.getSprite().getAnimation().updateAnimation(50);
			
			// collision check with EVERYTING
			for (int oth=0; oth<stuff.size(); oth++) {
				if (stuff.get(oth) == stuff.get(e)) {
					continue;
				}

				//collision 
				boolean canCollide = true;
				String[] stuffYouCantCollide = currentEntity.getBehavior().getThingsCantCollideWith();
				for (int i = 0; i<stuffYouCantCollide.length; i++) {
					if (currentEntity.getName().equals(stuffYouCantCollide[i])) {
						canCollide = false;
						break; // STOP becauses we can't collide with that thing
					}
				}
				
				if (canCollide) {
					Rectangle[] yourBoxes = stuff.get(e).getCollision().getBoxes();
					Rectangle[] theirBoxes = stuff.get(oth).getCollision().getBoxes();
					int yourxTrans = (int)currentEntity.getX();
					int youryTrans = (int)currentEntity.getY();
					int theirxTrans = (int)stuff.get(oth).getX();
					int theiryTrans = (int)stuff.get(oth).getY();
					for (int i=0; i<yourBoxes.length; i++) {
						for (int j=0; j<theirBoxes.length; j++) {
							// put them both in the extreme world coordinates for checking
							yourBoxes[i].translate(yourxTrans, youryTrans);
							theirBoxes[j].translate(theirxTrans, theiryTrans);
						}
					}
					
					// check collisions and then deal with it
					for (int i=0; i<yourBoxes.length; i++) {
						for (int j=0; j<theirBoxes.length; j++) {
							Rectangle ir = yourBoxes[i].intersection(theirBoxes[j]);
							if (ir.getWidth() > 0 || ir.getHeight() > 0) {
								// this should totally deal with it now and move everything
								currentEntity.setX(currentEntity.getX() - (float)ir.getWidth());
								currentEntity.setX(currentEntity.getY() - (float)ir.getHeight());
								break;
							}
						}
					}
					
					// put them both back into the local space
					for (int i=0; i<yourBoxes.length; i++) {
						for (int j=0; j<theirBoxes.length; j++) {
							yourBoxes[i].translate(-yourxTrans, -youryTrans);
							theirBoxes[j].translate(-theirxTrans, -theiryTrans);
						}
					}
				}
			} // end collision of everything *phew*
			
		}
	}
	
	@Override
	public void render(Graphics g) {
		for (Entity e : area.getEntities()) {
			e.getSprite().draw((Graphics2D)g);
		}
	}
	
}