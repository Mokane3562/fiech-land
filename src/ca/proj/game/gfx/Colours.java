package ca.proj.game.gfx;

/**
 * 
 * Colours.java generates a color based on a sudo-html-hex input.
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
public class Colours {
	
	/**
	 * Please add a description.
	 * 
	 * @param colour1 add a description
	 * @param colour2 add a description
	 * @param colour3 add a description
	 * @param colour4 add a description
	 * @return add a description
	 */
	public static int get(int colour1, int colour2, int colour3, int colour4) {
    return (get(colour4)<<24) + (get(colour3) <<16) + (get(colour2) <<8) + get(colour1); 
		
	}

	/**
	 * Please add a description.
	 * 
	 * @param colour add a description
	 * @return add a description
	 */
	private static int get(int colour) {
		if (colour < 0) return 255;
		int r = colour/100 % 10;
		int g = colour/10 % 10;
		int b = colour% 10;
		return r*36 + g*6 +b;
	}
	
}
