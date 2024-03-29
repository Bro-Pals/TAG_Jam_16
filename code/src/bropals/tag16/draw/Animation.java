package bropals.tag16.draw;

import java.awt.image.BufferedImage;

public class Animation {
	
	private BufferedImage[][] tracks;
	private int track, frame;
	private int millisecondsPerFrame;
	private long progress;
	
	public Animation(BufferedImage[][] tracks) {
		this.tracks=tracks;
		track = 0;
		frame = 0;
		progress = 0;
		millisecondsPerFrame = 200;
	}
	
	public void setTrack(int track) {
		this.track = track;
		frame = 0;
	}
	
	public void resetAnimation() {
		frame = 0;
	}
	
	/**
		Update the animation.
		@param milliseconds How many milliseconds go by every frame
	*/
	public void updateAnimation(long milliseconds) {
		progress += milliseconds;
		if (progress > millisecondsPerFrame) {
			progress = 0;
			frame++;
			if (frame>=tracks.length) {
				frame = 0;
			}
		}
	}

	public BufferedImage getCurrentFrame() {
		return tracks[track][frame];
	}
	
	@Override
	protected Object clone() {
		return new Animation(tracks);
	}
}