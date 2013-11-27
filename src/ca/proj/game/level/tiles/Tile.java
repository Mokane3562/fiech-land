package ca.proj.game.level.tiles;

import ca.proj.game.gfx.Colours;
import ca.proj.game.gfx.Screen;
import ca.proj.game.level.Level;
/**
 * 
 * Tile.java is the class that represents the tiles in each level.
 * 
 * Copyright (C) 2013 
 * Tyler Stacey, Mark Gauci, Ryan Martin, Mike Singleton
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
public abstract class Tile {
	
	//BASIC TILES
	public static final Tile[] tiles = new Tile[256];
	public static final Tile VOID = new BasicSolidTile(0, 0, 0, Colours.get(000, -1, -1, -1), 0xFF000000);
	public static final Tile STONE = new BasicSolidTile(1, 1, 0, Colours.get(222, 333, 444, 333), 0xFF555555);
	public static final Tile GRASS = new BasicTile(2, 2, 0, Colours.get(-1, 131, 141, -1), 0x0FF00FF00);
	public static final Tile SAND = new BasicTile(3, 3, 0, Colours.get(-1, 542, 555, -1), 0x0FFFFF000);
	public static final Tile SKY = new BasicSolidTile(10, 0, 0, Colours.get(235, -1, -1, -1), 0xFF5DA9FF);
	public static final Tile BRIDGE = new BasicSolidTile(11, 0, 0, Colours.get(320, 320, 430, 320), 0xFF914800);
	
	//ANIMATED TILES
	public static final Tile WATER = new AnimatedTile(4, new int[][] {{0, 5}, {1, 5}, {2, 5}, {1, 5}}, Colours.get(-1, 004, 115, -1), 0x0FF0000FF, 900);
	public static final Tile WATERFALL = new AnimatedTile(5, new int[][] {{3, 5}, {4, 5}, {5, 5}, {4, 5}}, Colours.get(004, 335, 115, 225), 0x0FF009696, 250);
	public static final Tile WATERFALLSPLASH = new AnimatedTile(6, new int[][] {{6, 5}, {7, 5}, {8, 5}, {7, 5}}, Colours.get(004, 335, 115, 225), 0x0FF00FFFF, 200);
	public static final Tile CLOUD = new AnimatedTile(7, new int[][] {{0, 5}, {1, 5}, {2, 5}, {1, 5}}, Colours.get(-1, 555, 444, -1), 0x0FFFFFFFF, 1500);
	public static final Tile RAINBOW_1 = new AnimatedTile(8, new int[][] {{3, 5}, {4, 5}, {5, 5}, {4, 5}}, Colours.get(500, 530, 550, 050), 0x0FFFF0000, 250);
	public static final Tile RAINBOW_2 = new AnimatedTile(9, new int[][] {{3, 5}, {4, 5}, {5, 5}, {4, 5}}, Colours.get(035, 005, 305, 503), 0x0FFFF00FF, 250);
	
	//TRIGGER TILES
	public static final Tile TELEPORT_TILE = new BasicTile(13, 10, 0, Colours.get(321, 000, 444, 542), 0x0FF666666);
	
	protected byte id;
    protected boolean solid;
    protected boolean emitter;
    protected boolean trigger;
    private int levelColour;
  
    
    /**
     * Creates a new Tile.
     * 
     * @param id the id of the tile
     * @param isSolid true if the tile is a solid tile (collision)
     * @param isEmitter add a description
     * @param levelColour the color of the corresponding pixel on a level's image
     */
    public Tile(int id, boolean isSolid, boolean isEmitter, int levelColour) {
    	this.id = (byte) id;
    	if (tiles[id] != null) throw new RuntimeException("Duplicate tile id on " + id);
    	if (id == 5 || id == 8 || id == 9){
    		isSolid = true;
    	}
    	this.solid = isSolid;
    	this.emitter = isEmitter;
    	this.levelColour = levelColour;
    	tiles[id] = this;
    }
    
    /**
     * Returns the id of the tile.
     * 
     * @return the tile's id
     */
    public byte getId() {
    	return id;
    }
    
    /**
     * Checks if the tile is solid (collides).
     * 
     * @return true if the tile is solid
     */
    public boolean isSolid() {
    	return solid;
    }
    
    /**
     * Please add a description.
     * 
     * @return add a description
     */
    public boolean isEmitter() {
    	return emitter;
    }
    
    /**
     * Returns the color of the corresponding pixel on a level's image.
     * 
     * @return the color of the corresponding pixel on a level's image
     */
    public int getLevelColour() {
    	return levelColour;
    }
    
    /**
     * Please add a description.
     */
    public abstract void tick();
    
	/**
	 * Please add a description.
	 * 
	 * @param screen add a description
	 * @param level add a description
	 * @param x add a description
	 * @param y add a description
	 */
	public abstract void render(Screen screen, Level level, int x, int y);
		
	

}

