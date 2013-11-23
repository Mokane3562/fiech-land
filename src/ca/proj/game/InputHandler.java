package ca.proj.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import ca.proj.game.menus.HelpMenu;
import ca.proj.game.menus.Menu;
import ca.proj.game.menus.TeleportMenu;
import ca.proj.game.Key;

/**
 * 
 * InputHandler.java handles input from the keyboard.
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
public class InputHandler implements KeyListener {
	public static int lookDir;

	/**
	 * Creates a new input handler.
	 * 
	 * @param game the game to handle input from
	 */
	public InputHandler(Game game) {
		game.addKeyListener(this);
	}

	// MOVEMENT
	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();

	// ACTIONS
	public Key coords = new Key();
	// DOOR
	public Key enter = new Key();
	// PICK UP
	public Key investigate = new Key();
	// MENU
	public Key escape = new Key();
	// Hold Election
	public Key election = new Key();
	// Bring up the
	public Key startGovernment = new Key();
	// Teleport
	public Key teleport = new Key();

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Please add a description.
	 * 
	 * @param keyCode add a description
	 * @param isPressed add a description
	 */
	public void toggleKey(int keyCode, boolean isPressed) {
		// MOVEMENT
		if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
			lookDir = 0;
			up.toggle(isPressed);
		}

		if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
			lookDir = 1;
			down.toggle(isPressed);
		}

		if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
			lookDir = 2;
			left.toggle(isPressed);
		}

		if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
			lookDir = 3;
			right.toggle(isPressed);
		}

		// COORDS
		if (keyCode == KeyEvent.VK_K) {
			System.out.println("X:" + Game.player.x + " Y:" + Game.player.y);
			coords.toggle(isPressed);
		}

		// DOOR
		if (keyCode == KeyEvent.VK_ENTER) {
			enter.toggle(isPressed);
		}
		// INVESTIGATE
		if (keyCode == KeyEvent.VK_I) {
			investigate.toggle(isPressed);
		}
		// Hold an election
		if (keyCode == KeyEvent.VK_E) {
			election.toggle(isPressed);
		}
		// Hold an election
		if (keyCode == KeyEvent.VK_G) {
			// startGovernment.toggle(isPressed);
			if (Game.player.getLevelSupport() > 50) {
				Game.level.startDemocraticGovernment();
			}
		}
		// Menu / Quit
		if (keyCode == KeyEvent.VK_ESCAPE) {
			Menu.main(null);
		}
		// Teleport
		if (keyCode == KeyEvent.VK_T) {
			// teleport.toggle(isPressed);
			new TeleportMenu("Teleport to...");
		}
		// Display Help Menu
		if (keyCode == KeyEvent.VK_F1){
			new HelpMenu("Help");
		}

	}

}
