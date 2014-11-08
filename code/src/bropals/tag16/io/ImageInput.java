package bropals.tag16.io;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.HashMap;

public class ImageInput {
	
	private static HashMap<String, BufferedImage> images = new HashMap<>();

	public static void loadImage(String path, String key) {
		BufferedImage image = null;
		try {
			File file = new File(path);
			image = (BufferedImage) ImageIO.read(file);
		} catch(Exception e) {
			System.out.println("Error loading image: " + e.toString());
		}
		if (image != null) {
			images.put(key, image);
		} else {
			System.err.println("Could not find image in " + path);
		}
	}
	
	public static BufferedImage getImage(String key) {
		return images.get(key);
	}
	
}