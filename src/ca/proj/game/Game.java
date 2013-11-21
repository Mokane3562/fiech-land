package ca.proj.game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import ca.proj.game.entities.NPC;
import ca.proj.game.entities.Player;
import ca.proj.game.gfx.Colours;
import ca.proj.game.gfx.Screen;
import ca.proj.game.gfx.SpriteSheet;
import ca.proj.game.level.Level;

/**
 * 
 * Game.java is the game-state manager.
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
public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 160;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 4;
	public static final String NAME = "Fiech Land";
	public static final int NUM_NPCS = 300;

	JFrame frame;
	Random generator = new Random();

	public static boolean running = false;
	public int tickCount = 0;
	long lastTime;
	// These act as the camera that follows the player
	public static int xOffset;
	public static int yOffset;

	// We fill the image with pixels later.
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();
	// We can have up to 6^3 colors in our game
	private int[] colours = new int[6 * 6 * 6];

	private Screen screen;

	// Handles keyboard inputs
	public static InputHandler input;
	// Each level is a "territory"
	public static Level level;
	// Handles different events that may happen in game, such as entering
	// another territory.
	public static GameEvents gameEvents;

	// ENTITIES
	public static Player player;
	public static NPC npc;

	private String initialLevel = "/levels/waterfall-grassland.png";

	/**
	 * Create the game and set properties for the window.
	 * 
	 * @param initialLevel
	 */
	public Game(String initialLevel) {
		this.initialLevel = initialLevel;
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

		frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	/**
	 * Initialize the values we will use for color.
	 */
	public void init() {
		// Fills th array with values that we can use as colors.
		int index = 0;
		for (int r = 0; r < 6; r++) {
			for (int g = 0; g < 6; g++) {
				for (int b = 0; b < 6; b++) {
					int rr = (r * 255 / 5);
					int gg = (g * 255 / 5);
					int bb = (b * 255 / 5);

					colours[index++] = rr << 16 | gg << 8 | bb;
				}
			}
		}
		// Tell the screen about the sprite sheet so it knows where to get the
		// images to load.
		screen = new Screen(WIDTH, HEIGHT, new SpriteSheet("/sprite_sheet.png"));
		// Tell the input handler to manage our game.
		input = new InputHandler(this);
		// Start the default level in the game.
		startLevel(initialLevel);
		addEntities();
	}

	/**
	 * Start the level and add the player, and GameEvent manager.
	 * 
	 * @param levelPath
	 */
	public static void startLevel(String levelPath) {
		Random rand = new Random();

		level = new Level(levelPath);
		level.setGovernment(null);
		int x = (int) (Math.sqrt(level.tiles.length)) * 4;
		int y = (int) (Math.sqrt(level.tiles.length)) * 4;
		player = new Player(level, x, y, input);
		level.addEntity(player);
		for (int i = 0; i < NUM_NPCS; i++) {
			int nx = rand.nextInt(x * 2);
			int ny = rand.nextInt(y * 2);
			while(level.getTile(nx >> 3, ny >> 3).isSolid()){
				nx = rand.nextInt(x * 2);
				ny = rand.nextInt(y * 2);
				
			}
			npc = new NPC(level, nx, ny);
			level.addEntity(npc);
		}
		gameEvents = new GameEvents();
	}

	/**
	 * Add any other entities to the level.
	 */
	public void addEntities() {

	}

	/**
	 * Starts a level where the player keeps their stats and enters a new level.
	 * 
	 * @param levelPath
	 * @param x
	 * @param y
	 */
	public static void startOtherLevel(String levelPath, int x, int y) {
		level = new Level(levelPath);
		level.addEntity(player);
	}

	/**
	 * Start the thread for the game
	 */
	public synchronized void start() {
		running = true;
		new Thread(this).start();

	}

	/**
	 * Stop the game thread.
	 */
	public synchronized void stop() {
		running = false;
	}

	/**
	 * Close the window.
	 */
	public void close() {
		frame.dispose();
	}

	/**
	 * Game implements runnable. A class that implements Runnable can run
	 * without subclassing Thread by instantiating a Thread instance and passing
	 * itself in as the target.
	 */
	public void run() {
		long lastTime = System.nanoTime();
		// 1 second
		double nsPerTick = 1000000000D / 60D;

		int ticks = 0;
		int frames = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		init();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean shouldRender = true;
			// Limit the amount of times we update the game.
			while (delta >= 1) {
				ticks++;
				tick();
				delta -= 1;
				shouldRender = true;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			if (shouldRender) {
				frames++;
				render();
			}
			// USed to debug and determine if the game is updating.
			// Game should run at ~60 frames, and 60 updates per second
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				System.out
						.println("" + ticks + " ticks, " + frames + " frames");
				System.out.println("The governemnt is: "
						+ level.getGovernment());
				System.out.println("The level is: " + level);

				System.out.println("Expansion: " + player.getExpansion());
				System.out.println("Mil: " + player.getMilitary());
				System.out.println("Politics: " + player.getPolitics());
				System.out.println("Resources: " + player.getResources());
				System.out.println("Wealth: " + player.getWealth());
				frames = 0;
				ticks = 0;
			}
		}
	}

	/**
	 * Keeps game logic in sync with rendering.
	 */
	public void tick() {
		tickCount++;
		level.tick();
	}

	/**
	 * Render the tiles on the board, the player, etc
	 */
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		// Set the "camera" position
		xOffset = player.x - (screen.width / 2);
		yOffset = player.y - (screen.height / 2);

		// Render the tiles first.
		level.renderTiles(screen, xOffset, yOffset);

		for (int x = 0; x < level.width; x++) {
			int colour = Colours.get(-1, -1, -1, 000);
			if (x % 10 == 0 && x != 0) {
				colour = Colours.get(-1, -1, -1, 500);
			}

		}
		// Render any objects or other entities to the screen.
		level.renderEntities(screen); // ENTITIES

		// Render the player stats HUD
		gameEvents.renderInterface(screen, xOffset, yOffset);
		// Show messages about events in the game, ie enter a territory.
		gameEvents.renderPlayerEvents(screen, xOffset, yOffset, input, player,
				level);

		for (int y = 0; y < screen.height; y++) {
			for (int x = 0; x < screen.width; x++) {
				int colourCode = screen.pixels[x + y * screen.width];
				if (colourCode < 255)
					pixels[x + y * WIDTH] = colours[colourCode];

			}
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		g.dispose();
		bs.show();

	}

	public static void quit() {
		System.exit(1);
	}

	public static boolean isRunning() {
		// TODO Auto-generated method stub
		return running;
	}

}
