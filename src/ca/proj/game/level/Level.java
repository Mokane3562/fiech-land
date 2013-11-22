package ca.proj.game.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import ca.proj.game.Game;
import ca.proj.game.entities.Entity;
import ca.proj.game.entities.Government;
import ca.proj.game.entities.Government.Gov_Type;
import ca.proj.game.entities.NPC;
import ca.proj.game.entities.Player;
import ca.proj.game.gfx.Screen;
import ca.proj.game.level.tiles.Tile;

/**
 * 
 * Level.java a representation of in-game levels/territories.
 * 
 * Copyright (C) 2013 Tyler Stacey, Mark Gauci, Ryan Martin, Mike Singleton
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
public class Level implements Serializable{

	public static byte[] tiles;
	public static int width;
	public static int height;
	public List<Entity> entities = new ArrayList<Entity>();
	private String imagePath;
	private BufferedImage image;
	public boolean getTileId;
	static Random generator = new Random();
	private Government government = null;
	private static Gov_Type DEMOCRACY;

	/**
	 * Creates a level from the specified image.
	 * 
	 * @param imagePath the path to the image on the disk
	 */
	public Level(String imagePath) {
		if (imagePath != null) {
			this.imagePath = imagePath;
			this.loadLevelFromFile();
		}
	}

	/**
	 * Loads a level from the file.
	 */
	private void loadLevelFromFile() {
		try {
			this.image = ImageIO.read(Level.class.getResource(this.imagePath));
			this.width = image.getWidth();
			this.height = image.getHeight();
			tiles = new byte[width * height];
			this.loadTiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the tiles on a per pixel basis based on the level image.
	 */
	private void loadTiles() {
		int[] tileColours = this.image.getRGB(0, 0, width, height, null, 0,
				width);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tileCheck: for (Tile t : Tile.tiles) {
					if (t != null
							&& t.getLevelColour() == tileColours[x + y * width]) {
						tiles[x + y * width] = t.getId();
						break tileCheck;
					}
				}
			}
		}
	}

	/**
	 * Exports a level to a .png image.
	 */
	private void saveLevelToFile() {
		try {
			ImageIO.write(image, "png",
					new File(Level.class.getResource(this.imagePath).getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Alters a tile on the level by replacing it with another tile configuration.
	 * 
	 * @param x the x coordinate of the tile to be altered
	 * @param y the x coordinate of the tile to be altered
	 * @param newTile the tile to replace the altered tile
	 */
	public void alterTile(int x, int y, Tile newTile) {
		tiles[x + y * width] = newTile.getId();
		image.setRGB(x, y, newTile.getLevelColour());

	}

	/**
	 * Please add a description.
	 */
	public void tick() {
		for (Entity e : entities) {
			e.tick();
		}
		for (Tile t : Tile.tiles) {
			if (t == null) {
				break;
			}
			t.tick();
		}

	}

	/**
	 * Renders the tiles to the screen.
	 * 
	 * @param screen the screen to render the tiles to
	 * @param xOffset add a description
	 * @param yOffset add a description
	 */
	public void renderTiles(Screen screen, int xOffset, int yOffset) {
		if (xOffset < 0) {
			xOffset = 0;
		}
		if (xOffset > ((width << 3) - screen.width)) {
			xOffset = ((width << 3) - screen.width);
		}
		if (yOffset < 0) {
			yOffset = 0;
		}
		if (yOffset > ((height << 3) - screen.height)) {
			yOffset = ((height << 3) - screen.height);
		}

		screen.setOffset(xOffset, yOffset);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).render(screen, this, x << 3, y << 3);
			}
		}
	}

	/**
	 * Renders the level's entities to the screen.
	 * 
	 * @param screen the screen to render the entities to
	 */
	public void renderEntities(Screen screen) {
		for (Entity e : entities) {
			e.render(screen);
		}
	}

	/**
	 * Returns the tile at a specified location on the level.
	 * 
	 * @param x the x coordinate of the tile location
	 * @param y the y coordinate of the tile location
	 * @return the tile at the specific location
	 */
	public Tile getTile(int x, int y) {
		if (0 > x || x >= width || 0 > y || y >= height){
			return Tile.VOID;
		}
		return Tile.tiles[tiles[x + y * width]];
	}

	/**
	 * Adds a number of NPCs to the level's list of entities.
	 * 
	 * @param npcs the list of NPCs to add
	 */
	public void addNPC(List<NPC> npcs) {
		this.entities.addAll(npcs);
	}

	/**
	 * Adds a number of entities to the level's list of entities.
	 * 
	 * @param entity the list of entities to add
	 */
	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}

	/**
	 * Removes a specific instance of an entity from the level's list of entities.
	 * 
	 * @param entity the entity to be removed
	 */
	public void removeEntity(Entity entity) {
		this.entities.remove(entity);
	}

	/**
	 * Returns a vote from the NPCs.
	 * 
	 * @return the NPCs vote
	 */
	public double getNPCVote() {
		Random rand = new Random();
		int r = rand.nextInt(Game.NUM_NPCS);

		return r;
	}

	/**
	 * Starts a democratic government.
	 */
	public void startDemocraticGovernment() {
		government = new Government(DEMOCRACY);
		Game.getGovernmentMap().put(this.getImagePath(), government);
	}

	/**
	 * Returns the current government.
	 * 
	 * @return the current government
	 */
	public Government getGovernment() {
		return government;
	}

	/** 
	 * Sets the government to a specific type.
	 * 
	 * @param government the new government
	 */
	public void setGovernment(Government government) {
		this.government = government;
	}

	/**
	 * Returns the image path of the level.
	 * 
	 * @return the level's image path
	 */
	public String getImagePath() {
		return imagePath;
	}

	public Player getPlayer() {
		for(Entity e : entities){
			if(e instanceof Player){
				return (Player)e;
			}
		}
		return null;
	}
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
