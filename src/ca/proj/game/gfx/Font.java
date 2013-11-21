package ca.proj.game.gfx;

/**
 * 
 * Font.java renders font from the sprite sheet, and other small images based
 * on input string.
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
public class Font {
	
	private static String chars = "" + "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdm " + "0123456789.,:;'\"!?$%()-=+/wf    ";
	
	/**
	 * Please add a description.
	 * 
	 * @param msg add a description
	 * @param screen add a description
	 * @param x add a description
	 * @param y add a description
	 * @param colour add a description
	 * @param scale add a description
	 */
	public static void render(String msg, Screen screen, int x, int y, int colour, int scale) {
		msg = msg.toUpperCase();
		
		for (int i = 0; i < msg.length(); i++) {
			int charIndex = chars.indexOf(msg.charAt(i));
			if (charIndex >= 0) screen.render(x + (i*8), y, charIndex + 30*32, colour, 0x00, scale);
		}
	}
}
