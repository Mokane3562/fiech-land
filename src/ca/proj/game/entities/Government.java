package ca.proj.game.entities;

import java.util.ArrayList;

import ca.proj.game.Game;

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
public class Government{
	/**
	 * Enum for the two government types, DEMOCRACY and DICTATORSHIP.
	 */
	public enum Gov_Type {
		DEMOCRACY, DICTATORSHIP
	}

	private Gov_Type gov;
	private Player leader = null;
	private ArrayList<Player> ministers = new ArrayList<Player>(10);
	private String countryName;
	
	/**
	 * Creates a new Government object.
	 * 
	 * @param gov the government type
	 */
	public Government(Gov_Type gov, String cName) {
		this.setGovType(gov);
		this.setCountryName(cName);
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
		if (Game.player.getLevelSupport() >= 50){
			leader = Game.player;
			//Confirms that the player is the leader.
			System.out.println(leader + " Chosen as Leader");
			System.out.println(Game.player + " Is the player");
		}
	}
	
	/**
	 * Return the name of the government leader.
	 * 
	 * @return name of the leader
	 */
	public String getLeaderName(){
		return leader.name;
	}

	/**
	 * Returns the government type.
	 * 
	 * @return the gov
	 */
	public Gov_Type getGovType() {
		return gov;
	}

	/**
	 * Sets the government to the specified government type.
	 * 
	 * @param gov the gov to set
	 */
	public void setGovType(Gov_Type gov) {
		this.gov = gov;
	}

	/**
	 * Adds the specified player as a minister.
	 * 
	 * @param player the player to be minister
	 */
	public void addMinister(Player player){
		ministers.add(player);
	}
	
	/**
	 * removes the specified player as a minister.
	 * 
	 * @param player the player to be removed as a minister
	 */
	public void removeMinister(Player player){
		ministers.remove(player);
	}
	
	/**
	 * Replaces one instance of a player with another as minister.
	 * 
	 * @param oldPlayer the player to be removed as a minister
	 * @param newPlayer the player to replace the other player as a minister
	 */
	public void replaceMinister(Player oldPlayer, Player newPlayer){
		ministers.set(ministers.indexOf(oldPlayer), newPlayer);
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	public Player getLeader(){
		return leader;
	}
}
