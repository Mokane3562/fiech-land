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
	public static final Tile SAND = new BasicTile(6, 3, 0, Colours.get(-1, 542, 555, -1), 0x0FFFFF000);
	
	//ANIMATED TILES
	public static final Tile WATER = new AnimatedTile(3, new int[][] {{0, 5}, {1, 5}, {2, 5}, {1, 5}}, Colours.get(-1, 004, 115, -1), 0x0FF0000FF, 900);
	public static final Tile WATERFALL = new AnimatedTile(7, new int[][] {{3, 5}, {4, 5}, {5, 5}, {4, 5}}, Colours.get(004, 335, 115, 225), 0x0FF009696, 100);
	public static final Tile WATERFALLSPLASH = new AnimatedTile(9, new int[][] {{6, 5}, {7, 5}, {8, 5}, {7, 5}}, Colours.get(004, 335, 115, 225), 0x0FF00FFFF, 900);
	
	//TRIGGER TILES
	public static final Tile DOOR_ENTER = new BasicTile(13, 10, 0, Colours.get(321, 000, 444, 542), 0x0FF666666);
	public static final Tile DOOR_LEAVE = new BasicTile(14, 11, 0, Colours.get(-1, 000, 510, -1), 0x0FF820000);
	
	
	
	protected byte id;
    protected boolean solid;
    protected boolean emitter;
    protected boolean trigger;
    private int levelColour;
  
    
    public Tile(int id, boolean isSolid, boolean isEmitter, int levelColour) {
    	this.id = (byte) id;
    	if (tiles[id] != null) throw new RuntimeException("Duplicate tile id on " + id);
    	this.solid = isSolid;
    	this.emitter = isEmitter;
    	this.levelColour = levelColour;
    	tiles[id] = this;
    }
    
    public byte getId() {
    	return id;
    }
    
    public boolean isSolid() {
    	return solid;
    }
    
    public boolean isEmitter() {
    	return emitter;
    }
    
    public int getLevelColour() {
    	return levelColour;
    }
    
    public abstract void tick();
    
	public abstract void render(Screen screen, Level level, int x, int y);
		
	

}

