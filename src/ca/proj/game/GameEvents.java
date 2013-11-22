package ca.proj.game;

import java.util.*;
import java.text.*;

import ca.proj.game.entities.Player;
import ca.proj.game.gfx.Colours;
import ca.proj.game.gfx.Font;
import ca.proj.game.gfx.Screen;
import ca.proj.game.level.Level;
import ca.proj.game.menus.TeleportMenu;

/**
 * 
 * GameEvents.java renders events that happen in game and updates the HUD.
 * 
 * Copyright (C) 2013 Tyler Stacey, Mark Gauci, Ryan Martin, Mike Singleton
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
public class GameEvents {
	static Random generator = new Random();

	// Colors for various levels of player stats.
	private int green = Colours.get(-1, 555, 555, 050);
	private int cyan = Colours.get(-1, 555, 555, 055);
	private int orange = Colours.get(-1, 555, 555, 530);
	private int red = Colours.get(-1, 555, 555, 400);
	private int black = Colours.get(-1, 555, 555, 000);

	/**
	 * Please add a description.
	 */
	public GameEvents() {

	}

	/**
	 * Update the HUD based on Player stats.
	 * 
	 * @param screen
	 * @param x
	 * @param y
	 */
	public void renderInterface(Screen screen, int x, int y) {

		double playerSupp = Player.support; // playerSupp => player support value
		DecimalFormat df = new DecimalFormat("##.##");  // format playerSupp to 2 decimal places
		Font.render(df.format(playerSupp) + "%", screen, x + 50, y, cyan, 1); // support
		// percent
		// displayed
		// in-game
		if (Game.level.getGovernment() != null) {

			Font.render(Game.level.getGovernment().getLeaderName(), screen, x,
					y, orange, 1);
		} else {
			Font.render("null", screen, x, y, green, 1);
		}
	}

	/**
	 * Render text to help with in-game events.
	 * 
	 * @param screen
	 * @param x
	 * @param y
	 * @param input
	 * @param player
	 * @param level
	 */
	public void renderPlayerEvents(Screen screen, int x, int y,
			InputHandler input, Player player, Level level) {

	}

}