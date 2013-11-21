package ca.proj.game.entities;

import ca.proj.game.Game;
import ca.proj.game.level.Level;

/**
 * 
 * Government.java represents the government of a specific level.
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
public class Government {

	/**
	 * Enum containing the two possible types of governments, DEMOCRACY and DICTATORSHIP.
	 */
	public enum Gov_Type {
		DEMOCRACY, DICTATORSHIP
	}

	Gov_Type gov;
	private double maxSupport = 0;
	Player leader = null;
	Level level;
	
	/**
	 * Creates a new Government object.
	 * 
	 * @param gov
	 * @param level
	 */
	public Government(Gov_Type gov, Level level) {
		this.gov = gov;
		this.level = level;
		chooseLeader();
	}

	/*public void chooseLeader(Level level) {  // elects player with highest support to 'leader'
		for (Entity e : level.entities) {
			if (e instanceof Player) {
				if (((Player)e).support >= maxSupport && ((Player)e).support >= 50) {
					leader = (Player) e;
					maxSupport = leader.support;
				}
			}

		}
		System.out.println(">> New player chosen as leader!");
	}*/

	/**
	 * Set the player as leader if support is great enough, done when a 
	 * government is created.
	 */
	public void chooseLeader(){
		if (Game.player.support >= 50){
			leader = Game.player;
			//Confirms that the player is the leader.
			System.out.println(leader + " Chosen as Leader");
			System.out.println(Game.player + " Is the player");
		}
	}
	
	/**
	 * Return the name of the governemnt leader.
	 * 
	 * @return the name of the leader
	 */
	public String getLeaderName(){
		return leader.name;
	}

}
