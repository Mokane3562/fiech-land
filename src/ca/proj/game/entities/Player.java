package ca.proj.game.entities;

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
public class Player extends Mob {

	private InputHandler input;
	public static int colour = Colours.get(-1, 000, 500, 543);
	private int scale = 1;
	protected boolean isSwimming = false;
	public static boolean gettingDamage;
	private int tickCount;
	private long lastElectionTime = 0;
	public static double support = 0;
	public static boolean triggeredTeleport = false;
	public static int xPos;
	public static int yPos;
	
	private static int wealth = 0;
	private static int resources = 0;
	private static int politics = 0;
	private static int expansion = 0;
	private static int military = 0;
	private static final int ATTRIBUTE_TOTAL = 100;

	/**
	 * Creates a new Player.
	 * 
	 * @param level
	 * @param x
	 * @param y
	 * @param input
	 */
	public Player(Level level, int x, int y, InputHandler input) {
		super(level, "PLAYER", x, y, 1);
		this.input = input;
	}

	/* (non-Javadoc)
	 * Called from the level to "tick" or update the character.
	 * 
	 * @see ca.proj.game.entities.Entity#tick()
	 */
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
				support = (level.getNPCVote() / Game.NUM_NPCS) * 100;
				System.out.println("Percentage of support: " + support);
				lastElectionTime = System.currentTimeMillis();
			}
		}
		tickCount++;
	}

	/* (non-Javadoc)
	 * Render any updates to the screen.
	 * 
	 * @see ca.proj.game.entities.Entity#render(ca.proj.game.gfx.Screen)
	 */
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
	 * Check to see if the character has collided with a solid tile.
	 * 
	 * @see ca.proj.game.entities.Mob#hasCollided(int, int)
	 */
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
	 * Returns the wealth of the player.
	 * 
	 * @return the player's wealth
	 */
	public static int getWealth() {
		return wealth;
	}

	/**
	 * Sets the wealth of the player to the specified value.
	 * 
	 * @param wealth the wealth to set
	 */
	public static void setWealth(int wealth) {
		Player.wealth = wealth;
	}

	/**
	 * Returns the resources of the player.
	 * 
	 * @return the player's resources
	 */
	public static int getResources() {
		return resources;
	}

	/**
	 * Sets the recources of the player to the specified value.
	 * 
	 * @param resources the resources to set
	 */
	public static void setResources(int resources) {
		Player.resources = resources;
	}

	/**
	 * Returns the expansion of the player.
	 * 
	 * @return the player's expansion
	 */
	public static int getExpansion() {
		return expansion;
	}

	/**
	 * Sets the expansion of the player to the specified value.
	 * 
	 * @param expansion the expansion to set
	 */
	public static void setExpansion(int expansion) {
		Player.expansion = expansion;
	}

	/**
	 * Returns the politics of the player.
	 * 
	 * @return the player's politics
	 */
	public static int getPolitics() {
		return politics;
	}

	/**
	 * Sets the politics of the player to the specified value.
	 * 
	 * @param politics the politics to set
	 */
	public static void setPolitics(int politics) {
		Player.politics = politics;
	}

	/**
	 * Returns the military of the player.
	 * 
	 * @return the player's military
	 */
	public static int getMilitary() {
		return military;
	}

	/**
	 * Sets the military of the player to the specified value.
	 * 
	 * @param military the military to set
	 */
	public static void setMilitary(int military) {
		Player.military = military;
	}

}
