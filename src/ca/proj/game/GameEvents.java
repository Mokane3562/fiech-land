package ca.proj.game;

import java.util.*;
import java.text.*;

import ca.proj.game.entities.Player;
import ca.proj.game.gfx.Colours;
import ca.proj.game.gfx.Font;
import ca.proj.game.gfx.Screen;
import ca.proj.game.level.Level;

public class GameEvents {
	static Random generator = new Random();
	static long lastTime;
	static boolean playerIsIndoor = false;

	// Colors for various levels of player stats.
	private int green = Colours.get(-1, 555, 141, 400);
	private int blue = Colours.get(-1, 555, 115, 400);
	private int orange = Colours.get(-1, 555, 542, 400);
	private int red = Colours.get(-1, 555, 500, 400);
	private int black = Colours.get(-1, 555, 000, 400);

	private int playerHealth = 3;
	private int water = 100;
	private int food = 100;

	public GameEvents() {

	}

	// Update the HUD based on Player stats.
	public void renderInterface(Screen screen, int x, int y) {
		// If the player is indoors dont render the HUD
		if (!playerIsIndoor)
			if (playerHealth == 3) // HEALTH
				Font.render("ccc", screen, x + 1, y,
						Colours.get(-1, 555, -1, 400), 1);
		if (playerHealth == 2)
			Font.render("cc", screen, x + 1, y, Colours.get(-1, 555, -1, 400),
					1);
		if (playerHealth == 1)
			Font.render("c", screen, x + 1, y, Colours.get(-1, 555, -1, 400), 1);

		if (water <= 100 && water > 50) // WATER
			Font.render("w", screen, x + 24, y, blue, 1);
		if (water <= 50 && water > 15)
			Font.render("w", screen, x + 24, y, orange, 1);
		if (water <= 15 && water > 0)
			Font.render("w", screen, x + 24, y, red, 1);
		if (water <= 0)
			Font.render("w", screen, x + 24, y, black, 1);

		/*if (food <= 100 && food > 50) // FOOD
			Font.render("f", screen, x + 31, y, green, 1);
		if (food <= 50 && food > 15)
			Font.render("f", screen, x + 31, y, orange, 1);
		if (food <= 15 && food > 0)
			Font.render("f", screen, x + 31, y, red, 1);
		if (food <= 0)
			Font.render("f", screen, x + 31, y, black, 1);*/
		double playerSupp=Player.support; // format playerSupp to 2 decimal places
		DecimalFormat df=new DecimalFormat("##.##");
		Font.render(df.format(playerSupp) + "%", screen, x + 31, y, black, 1);  // support percent displayed in-game
	}

	// Render text to help with in-game events.
	public void renderPlayerEvents(Screen screen, int x, int y,
			InputHandler input, Player player, Level level) {

		// Enter Africa
		if (Player.triggeredAfrica == true) {
			Font.render("ENTER-AFRICA", screen, x + 40, y + 37,
					Colours.get(-1, 135, -1, 530), 1);
			if (input.enter.isPressed()) {

				Game.startLevel("/levels/africa.png", 505, 475);
			}
		}
		// Enter FiechLand
		if (Player.triggeredFiechLand == true) {
			Font.render("ENTER-FIECH-LAND", screen, x + 30, y + 37,
					Colours.get(-1, 135, -1, 530), 1);
			if (input.enter.isPressed()) {
				Game.startLevel("/levels/fiech.png", 505, 475);
			}
		}
		
		// Regenerate health
		if (Player.gettingDamage == false && playerHealth < 3) {
			if (System.currentTimeMillis() >= lastTime) {
				lastTime = System.currentTimeMillis() + 3000;
				playerHealth++;
			}
		}
		
		// Display a message if the player dies.
		if (playerHealth <= 0) {
			Game.level = new Level("/levels/you_are_dead.png");
			Font.render("Y O U  A R E", screen, 28, 30,
					Colours.get(-1, 135, -1, 555), 2);
		}

	}

}