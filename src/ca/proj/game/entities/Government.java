package ca.proj.game.entities;

import ca.proj.game.Game;
import ca.proj.game.level.Level;

public class Government {

	public enum Gov_Type {
		DEMOCRACY, DICTATORSHIP
	}

	Gov_Type gov;
	private double maxSupport = 0;
	Player leader = null;
	Level level;
	
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
	public void chooseLeader(){
		if (Game.player.support >= 50){
			leader = Game.player;
			//Confirms that the player is the leader.
			System.out.println(leader + " Chosen as Leader");
			System.out.println(Game.player + " Is the player");
		}
	}
	public String getLeaderName(){
		return leader.name;
	}

}
