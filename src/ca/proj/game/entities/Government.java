package ca.proj.game.entities;

import ca.proj.game.level.Level;

public class Government {

	public enum Gov_Type {
		DEMOCRACY, DICTATORSHIP
	}

	Gov_Type gov;
	private int maxSupport = 0;
	Player leader = null;
	Level level;
	
	public Government(Gov_Type gov, Level level) {
		this.gov = gov;
		this.level = level;
		chooseLeader(level);
	}

	public void chooseLeader(Level level) {
		for (Entity e : level.entities) {
			if (e instanceof Player) {
				if (((Player)e).support > maxSupport){
					leader = (Player) e;
					maxSupport = leader.support;
				}
			}

		}
	}

}
