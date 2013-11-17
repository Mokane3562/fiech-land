package ca.proj.game.entities;

import java.util.Random;

import ca.proj.game.Game;
import ca.proj.game.gfx.Colours;
import ca.proj.game.gfx.Screen;
import ca.proj.game.level.Level;

public class NPC extends Mob {

	private int colour = Colours.get(-1, 000, 230, 543);
	private int scale = 1;
	protected boolean isSwimming = false;
	private int tickCount;
	Random generator = new Random();
	private int moveCount = 0;
	private int xa, ya;
	private boolean yIncr;
	private boolean yDecr;
	private boolean xIncr;
	private boolean xDecr;
	private boolean stayPut;

	public NPC(Level level, int x, int y) {
		super(level, "NPC", x, y, 1);
	}

	public void tick() {
		xa = 0;
		ya = 0;
		if (moveCount == 0) {
			Random rand = new Random();
			int r = rand.nextInt(201);
			if (r <= 25) {
				yIncr = true;
			} else if (r <= 50) {
				yDecr = true;
			} else if (r <= 75) {
				xIncr = true;
			} else if (r <= 100) {
				xDecr = true;
			} else if (r <= 200) {
				stayPut = true;
			}
		}
		if (yIncr == true) {
			moveCount++;
			if (!hasCollided(xa, ya)) {
				ya++;
			}
			if (moveCount == 10) {
				moveCount = 0;
				yIncr = false;
			}
		}
		if (yDecr == true) {
			moveCount++;
			if (!hasCollided(xa, ya)) {
				ya--;
			}
			if (moveCount == 10) {
				moveCount = 0;
				yDecr = false;
			}
		}
		if (xIncr == true) {
			moveCount++;
			if (!hasCollided(xa, ya)) {
				xa++;
			}
			if (moveCount == 10) {
				moveCount = 0;
				xIncr = false;
			}
		}
		if (xDecr == true) {
			moveCount++;
			if (!hasCollided(xa, ya)) {
				xa--;
			}
			if (moveCount == 10) {
				moveCount = 0;
				xDecr = false;
			}
		}
		if (stayPut == true) {
			moveCount++;
			if (!hasCollided(xa, ya)) {
				ya = 0;
				xa = 0;
			}
			if (moveCount == 30) {
				moveCount = 0;
				stayPut = false;
			}
		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			isMoving = true;
		} else {
			isMoving = false;
		}
		if (level.getTile(this.x >> 3, this.y >> 3).getId() == 3) {
			isSwimming = true;

		}
		if (isSwimming && level.getTile(this.x >> 3, this.y >> 3).getId() != 3) {
			isSwimming = false;
		}
		tickCount++;

	}

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
}
