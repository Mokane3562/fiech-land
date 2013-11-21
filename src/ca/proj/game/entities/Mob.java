package ca.proj.game.entities;

import ca.proj.game.level.Level;
import ca.proj.game.level.tiles.Tile;

/**
 * 
 * Mob.java the base for any mobile character.
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
public abstract class Mob extends Entity {

	public static Mob mob = null;
	protected String name;
	protected int speed;
	protected int numSteps = 0;
	protected boolean isMoving;
	protected int movingDir = 1;
	protected int scale = 1;

	/**
	 * Creates a new Mob
	 * 
	 * @param level
	 * @param name
	 * @param x
	 * @param y
	 * @param speed
	 */
	public Mob(Level level, String name, int x, int y, int speed) {
		super(level);
		this.name = name;
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	/**
	 * Move the character to a new position.
	 * 
	 * @param xa x-increment to move
	 * @param ya y-increment to move
	 */
	public void move(int xa, int ya) {
		//Move diagonally.
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			numSteps--;
			return;
		}
		numSteps++;
		if (!hasCollided(xa, ya)) {
			if (ya < 0) {
				// Up
				movingDir = 0;
			}
			if (ya > 0) {
				// Down
				movingDir = 1;
			}
			if (xa < 0) {
				// Left
				movingDir = 2;
			}
			if (xa > 0) {
				// Right
				movingDir = 3;
			}
			// Move farther if the speed is greater.
			x += xa * speed;
			y += ya * speed;
		}

	}

	/**
	 * Please add a description
	 * 
	 * @param xa
	 * @param ya
	 * @return
	 */
	public abstract boolean hasCollided(int xa, int ya);

	/**
	 * Used when checking for a collision with a blocked tile.
	 * 
	 * @param xa x-position of character
	 * @param ya y-position of character
	 * @param x x-position of tile
	 * @param y y-position of tile
	 * @return
	 */
	protected boolean isSolidTile(int xa, int ya, int x, int y) {
		if (level == null) {
			return false;
		}
		Tile lastTile = level.getTile((this.x + x) >> 3, (this.y + y) >> 3);
		Tile newTile = level.getTile((this.x + x + xa) >> 3,
				(this.y + y + ya) >> 3);
		if (!lastTile.equals(newTile) && newTile.isSolid()) {
			return true;
		}
		return false;
	}

}
