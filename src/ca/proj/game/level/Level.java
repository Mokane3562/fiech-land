package ca.proj.game.level;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

public class Level {

	public static byte[] tiles;
	public static int width;
	public static int height;
	public List<Entity> entities = new ArrayList<Entity>();
	private String imagePath;
	private BufferedImage image;
	public boolean getTileId;
	static Random generator = new Random();
	private static Government government = null;
	private static Gov_Type DEMOCRACY;
	
	public Level(String imagePath) {
		if (imagePath != null) {
			this.imagePath = imagePath;
			this.loadLevelFromFile();
		}
	}

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

	private void saveLevelToFile() {
		try {
			ImageIO.write(image, "png",
					new File(Level.class.getResource(this.imagePath).getFile()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void alterTile(int x, int y, Tile newTile) {
		tiles[x + y * width] = newTile.getId();
		image.setRGB(x, y, newTile.getLevelColour());

	}

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

	public void renderTiles(Screen screen, int xOffset, int yOffset) {
		if (xOffset < 0)
			xOffset = 0;
		if (xOffset > ((width << 3) - screen.width))
			xOffset = ((width << 3) - screen.width);
		if (yOffset < 0)
			yOffset = 0;
		if (yOffset > ((height << 3) - screen.height))
			yOffset = ((height << 3) - screen.height);

		screen.setOffset(xOffset, yOffset);

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				getTile(x, y).render(screen, this, x << 3, y << 3);
			}
		}
	}

	public void renderEntities(Screen screen) {
		for (Entity e : entities) {
			e.render(screen);
		}
	}

	public Tile getTile(int x, int y) {
		if (0 > x || x >= width || 0 > y || y >= height)
			return Tile.VOID;
		return Tile.tiles[tiles[x + y * width]];
	}

	public void addNPC(List<NPC> npcs) {
		this.entities.addAll(npcs);
	}

	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}

	public void removeEntity(Entity entity) {
		this.entities.remove(entity);
	}

	public double getNPCVote() {
		Random rand = new Random();
		int r = rand.nextInt(Game.NUM_NPCS);

		return r;
	}
	public void startDemocraticGovernment(){
		government = new Government(DEMOCRACY, this);
	}

	/**
	 * @return the government
	 */
	public Government getGovernment() {
		return government;
	}

	/**
	 * @param government the government to set
	 */
	public void setGovernment(Government government) {
		this.government = government;
	}
	
	public String getImagePath(){
		return imagePath;
	}
}
