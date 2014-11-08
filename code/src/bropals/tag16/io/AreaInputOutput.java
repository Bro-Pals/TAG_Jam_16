package bropals.tag16.io;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import bropals.tag16.world.Area;
import bropals.tag16.entity.Entities;

public class AreaInputOutput {
	
	/**
		Loads and returns the area that is described in the file represented by path
		@param path the path to the area file relative to the assets directory
	*/
	public static Area loadArea(String path) {
		Area area = new Area();
		try {
			BufferedReader rdr = new BufferedReader(new FileReader(new File("assets/" + path)));
			String currentLine = rdr.readLine();
			while(currentLine!=null) {
				String[] split = rdr.readLine();
				name = split[0];
				float x=0, y=0;
				try {
					x = Float.parseFloat(split[1]);
					y = Float.parseFloat(split[2]);
				} catch(NumberFormatException nfe) {
					System.out.println("Invalid float value " + nfe.toString());
				}
				area.addEntity(Entities.createEntity(name, x, y));
				currentLine = rdr.readLine();
			}
			rdr.close();
			System.out.println("Successfully read the area file " + path);
		} catch(Exception e) {
			System.err.println("Unable to load area in " + path + ", " + e.toString());
		}
		return area;
	}
	
	public static void writeArea(String path, Area area) {
		try {
			PrintStream pstr = new PrintStream(new File("assets/" + path));
			ArrayList<Entity> entities = new ArrayList<Entity>();
			for (Entity e : entities) {
				pstr.println(Entities.makeEntityParseString(e));
			}
			pstr.flush();
			pstr.close();
		} catch(Exception e) {
			System.out.println("Unable to write area " + path + ": " + e.toString());
		}
	}
}