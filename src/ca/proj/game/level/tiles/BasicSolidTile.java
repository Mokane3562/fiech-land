package ca.proj.game.level.tiles;

/**
 * 
 * BasicSolidTile.java is a blocked tile that the character cannot walk on.
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
public class BasicSolidTile extends BasicTile {

	/**
	 * Creates a new basic solid tile.
	 * 
	 * @param id the id of the tile
	 * @param x the x coordinate of the tile on the level
	 * @param y the y coordinate of the tile on the level
	 * @param tileColour the colour of the tile
	 * @param levelColour the color of the corresponding pixel on a level's image
	 */
	public BasicSolidTile(int id, int x, int y, int tileColour, int levelColour) {
		super(id, x, y, tileColour, levelColour);
		this.solid = true;
	}

}
