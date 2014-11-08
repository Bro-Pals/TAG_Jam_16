package bropals.tag16.io;

import java.io.File;
import java.util.HashMap;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SoundInput {
	
	private static HashMap<String, Clip> sounds = new HashMap<>();

	public static void loadSound(String path, String key) {
		Clip daClip = null;
		try {
			daClip = AudioSystem.getClip();
			File file = new File(path);
			daClip.open(AudioSystem.getAudioInputStream(file));
		} catch(Exception e) {
			System.out.println("Error loading sound: " + e.toString());
		}
		if (daClip != null) {
			sounds.put(key, daClip);
		} else {
			System.out.println("Could not load the sound in " + path);
		}
	}
	
	public static void playSound(String key) {
		sounds.get(key).loop(1);
	}
	
}