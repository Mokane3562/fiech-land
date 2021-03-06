package ca.proj.game.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import ca.proj.game.Game;
import ca.proj.game.InputHandler;
import ca.proj.game.gfx.Colours;
import ca.proj.game.gfx.Screen;
import ca.proj.game.level.Level;

/**
 * 
 * Player.java represents the playable character.
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
public class Player extends Mob{
	
	private transient InputHandler input;
	public int colour = Colours.get(-1, 000, 500, 543);
	private int scale = 1;
	public boolean isSwimming = false;
	private int tickCount;
	private long lastElectionTime = 0;
	public static int xPos;
	public static int yPos;
	
	// Happiness
	private  int happinessScore = 0;
	private  final int MAX_HAPPINESS = 1000;
	// Points are required to take certain in-game actions.
	private  int actionPoints = 0;
	//Attributes
	private  int wealthModifier = 0;
	private  int resourcesModifier = 0;
	private  int politicsModifier = 0;
	private  int solitudeModifier = 0;
	private  int militaryModifier = 0;
	private  final int ATTRIBUTE_TOTAL = 100;
	
	public static boolean triggeredFiechLand = false;
	public static boolean triggeredWaterGrass = false;
	public static boolean triggeredDesert = false;
	public static boolean triggeredThreeLakes = false;
	public static boolean triggeredAncient = false;
	
	//Used when saving the player
	public String currentLevel = Game.level.getImagePath();
	
	private Map<String, Double> supportMap = new HashMap<String, Double>();

	/**
	 * Creates a new Player.
	 * 
	 * @param level the level to add the player to
	 * @param x the x position on the level to add the player to
	 * @param y the y position on the level to add the player to
	 * @param input the input handler for the player
	 */
	public Player(Level level, int x, int y, InputHandler input) {
		super(level, "PLAYER", x, y, 1);
		this.input = input;
	}

	/* (non-Javadoc)
	 * @see ca.proj.game.entities.Entity#tick()
	 */
	@Override
	public void tick() {
		int xa = 0;
		int ya = 0;

		//Depending on the button pressed move the character.
		if (input.up.isPressed()) {
			ya--;
		}
		if (!hasCollided(xa, ya))

			if (input.down.isPressed()) {
				ya++;
			}
		if (!hasCollided(xa, ya))

			if (input.left.isPressed()) {
				xa--;
			}
		if (!hasCollided(xa, ya))

			if (input.right.isPressed()) {
				xa++;
			}
		if (!hasCollided(xa, ya))

			if (xa != 0 || ya != 0) {
				move(xa, ya);
				isMoving = true;
			} else {
				isMoving = false;

			}

		// SWIMMING
		if (level.getTile(this.x >> 3, this.y >> 3).getId() == 4) {
			isSwimming = true;
		}
		if (isSwimming && level.getTile(this.x >> 3, this.y >> 3).getId() != 4) {
			isSwimming = false;
		}
		if (level.getTile(this.x >> 3, this.y >> 3).getId() == 6) {
			isSwimming = true;
		}
		// Hold an election
		if (input.election.isPressed()) {
			if (System.currentTimeMillis() - lastElectionTime > 2000) {
				supportMap.put(level.getImagePath(), level.getNPCVote() / Game.NUM_NPCS * 100);
				System.out.println("Percentage of support: " + supportMap.get(level));
				lastElectionTime = System.currentTimeMillis();
			}
		}
		//Fiech land
		if(level.getTile(this.x >> 3,  this.y >> 3).getId() == 10) {
			triggeredFiechLand = true;
		}
		if (level.getTile(this.x >> 3, this.y >> 3 ).getId() != 10) {
			triggeredFiechLand = false;
		}
		
		//Water-grassland
		if(level.getTile(this.x >> 3,  this.y >> 3).getId() == 11) {
			triggeredWaterGrass = true;
		}
		if (level.getTile(this.x >> 3, this.y >> 3 ).getId() != 11) {
			triggeredWaterGrass = false;
		}

		//Desert
		if(level.getTile(this.x >> 3,  this.y >> 3).getId() == 12) {
			triggeredDesert = true;
		}
		if (level.getTile(this.x >> 3, this.y >> 3 ).getId() != 12) {
			triggeredDesert = false;
		}

		//Three-lakes
		if(level.getTile(this.x >> 3,  this.y >> 3).getId() == 13) {
			triggeredThreeLakes = true;
		}
		if (level.getTile(this.x >> 3, this.y >> 3 ).getId() != 13) {
			triggeredThreeLakes = false;
		}

		//Ancient ruins
		if(level.getTile(this.x >> 3,  this.y >> 3).getId() == 14) {
			triggeredAncient = true;
		}
		if (level.getTile(this.x >> 3, this.y >> 3 ).getId() != 14) {
			triggeredAncient = false;
		}


		tickCount++;
		
	}

	/* (non-Javadoc)
	 * @see ca.proj.game.entities.Entity#render(ca.proj.game.gfx.Screen)
	 */
	@Override
	public void render(Screen screen) {
		int xTile = 0;
		int yTile = 28;
		int walkingSpeed = 4;
		int flipTop = (numSteps >> walkingSpeed) & 1;
		int flipBottom = (numSteps >> walkingSpeed) & 1;

		if (movingDir == 1) {
			xTile += 2;
		} else if (movingDir > 1) {
			xTile += 4 + ((numSteps >> walkingSpeed) & 1) * 2;
			flipTop = (movingDir - 1) % 2;
		}
		int modifier = 8 * scale;
		int xOffset = x - modifier / 2;
		int yOffset = y - modifier / 2 - 4;
		if (isSwimming) {
			int waterColour = 0;
			yOffset += 4;
			if (tickCount % 60 < 15) {
				waterColour = Colours.get(-1, -1, 225, -1);
			} else if (15 <= tickCount % 60 && tickCount % 60 < 30) {
				yOffset -= 1;
				waterColour = Colours.get(-1, 225, 115, -1);
			} else if (30 <= tickCount % 60 && tickCount % 60 < 45) {
				waterColour = Colours.get(-1, 115, -1, 225);
			} else {
				yOffset -= 1;
				waterColour = Colours.get(-1, 225, 115, -1);
			}
			screen.render(xOffset, yOffset + 3, 0 + 27 * 32, waterColour, 0x00,
					1);
			screen.render(xOffset + 8, yOffset + 3, 0 + 27 * 32, waterColour,
					0x01, 1);
		}

		screen.render(xOffset + (modifier * flipTop), yOffset, xTile + yTile
				* 32, colour, flipTop, scale);
		screen.render(xOffset + modifier - (modifier * flipTop), yOffset, xTile
				+ 1 + yTile * 32, colour, flipTop, scale);

		if (!isSwimming) {
			screen.render(xOffset + (modifier * flipBottom),
					yOffset + modifier, xTile + (yTile + 1) * 32, colour,
					flipBottom, scale);
			screen.render(xOffset + modifier - (modifier * flipBottom), yOffset
					+ modifier, (xTile + 1) + (yTile + 1) * 32, colour,
					flipBottom, scale);

		}
	}

	/* (non-Javadoc)
	 * @see ca.proj.game.entities.Mob#hasCollided(int, int)
	 */
	@Override
	public boolean hasCollided(int xa, int ya) {
		int xMin = 0;
		int xMax = 7;
		int yMin = 3;
		int yMax = 7;
		for (int x = xMin; x < xMax; x++) {
			if (isSolidTile(xa, ya, x, yMin)) {
				return true;
			}
		}
		for (int x = xMin; x < xMax; x++) {
			if (isSolidTile(xa, ya, x, yMax)) {
				return true;
			}
		}
		for (int y = yMin; y < yMax; y++) {
			if (isSolidTile(xa, ya, xMin, y)) {
				return true;
			}
		}
		for (int y = yMin; y < yMax; y++) {
			if (isSolidTile(xa, ya, xMax, y)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return
	 */
	public  int getHappiness() {
		return happinessScore;
	}

	/**
	 * @param happiness
	 */
	public void setHappiness(int happiness) {
		this.happinessScore = happiness;
	}

	/**
	 * @return
	 */
	public int getActionPoints() {
		return actionPoints;
	}

	/**
	 * @param actionPoints
	 */
	public  void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}
	
	/**
	 * Returns the wealth of the player.
	 * 
	 * @return the player's wealth
	 */
	public int getWealth() {
		return wealthModifier;
	}

	/**
	 * Sets the wealth of the player to the specified value.
	 * 
	 * @param wealth the wealth to set
	 */
	public void setWealth(int wealth) {
		this.wealthModifier = wealth;
	}

	/**
	 * Returns the resources of the player.
	 * 
	 * @return the player's resources
	 */
	public int getResources() {
		return resourcesModifier;
	}

	/**
	 * Sets the recources of the player to the specified value.
	 * 
	 * @param resources the resources to set
	 */
	public void setResources(int resources) {
		this.resourcesModifier = resources;
	}

	/**
	 * Returns the expansion of the player.
	 * 
	 * @return the player's expansion
	 */
	public int getSolitude() {
		return solitudeModifier;
	}

	/**
	 * Sets the expansion of the player to the specified value.
	 * 
	 * @param expansion the expansion to set
	 */
	public void setSolitude(int expansion) {
		this.solitudeModifier = expansion;
	}

	/**
	 * Returns the politics of the player.
	 * 
	 * @return the player's politics
	 */
	public int getPolitics() {
		return politicsModifier;
	}

	/**
	 * Sets the politics of the player to the specified value.
	 * 
	 * @param politics the politics to set
	 */
	public void setPolitics(int politics) {
		this.politicsModifier = politics;
	}

	/**
	 * Returns the military of the player.
	 * 
	 * @return the player's military
	 */
	public int getMilitary() {
		return militaryModifier;
	}

	/**
	 * Sets the military of the player to the specified value.
	 * 
	 * @param military the military to set
	 */
	public void setMilitary(int military) {
		this.militaryModifier = military;
	}

	public double getLevelSupport() {
		return supportMap.get(level.getImagePath());
	}
	
	public Map<String, Double> getSupportMap() {
		return supportMap;
	}
	
	public void setInput(InputHandler i){
		input = i;
	}

}
