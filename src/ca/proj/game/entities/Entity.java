package ca.proj.game.entities;

import ca.proj.game.gfx.Screen;
import ca.proj.game.level.Level;

/**
 * 
 * Entity.java any entity that can exist in the game, including items.
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
public abstract class Entity {

	public int x;
	public int y;
	protected static Level level;

	/**
	 * Creates a new Entity object.
	 * 
	 * @param level the level to add the entity to
	 */
	public Entity(Level level) {
		init(level);

	}

	/**
	 * Please add a description.
	 * 
	 * @param level add a description
	 */
	public final void init(Level level) {
		this.level = level;
	}

	/**
	 * Called from the level to "tick" or update the entity
	 */
	public abstract void tick();

	/**
	 * Render any updates to the screen.
	 * 
	 * @param screen add a description
	 */
	public abstract void render(Screen screen);

}
