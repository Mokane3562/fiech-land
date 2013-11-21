package ca.proj.game.gfx;

/**
 * 
 * Screen.java the area where the game is rendered.
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
public class Screen {

	public static final int MAP_WIDTH = 64;
	public static final int MAP_WIDTH_MASK = MAP_WIDTH - 1;
	
	public static final byte BIT_MIRROR_X = 0x01;
	public static final byte BIT_MIRROR_Y = 0x02;
	
	public int[] pixels;
	
	
	public static int xOffset = 0;
	public static int yOffset = 0;
	
	public int width;
	public int height;
	
	public SpriteSheet sheet;
	
	/**
	 * Creates a new screen.
	 * 
	 * @param width add a description
	 * @param height add a description
	 * @param sheet add a description
	 */
	public Screen(int width, int height, SpriteSheet sheet) {
		
		this.width = width;
		this.height = height;
		this.sheet = sheet;
		
		pixels = new int[width * height];
		
	
	}

	/**
	 * Please add a description.
	 * 
	 * @param xPos add a description
	 * @param yPos add a description
	 * @param tile add a description
	 * @param colour add a description
	 * @param mirrorDir add a description
	 * @param scale add a description
	 */
	public void render(int xPos, int yPos, int tile, int colour, int mirrorDir, int scale) {
		xPos -= xOffset;
		yPos -= yOffset;
		
		boolean mirrorX = (mirrorDir & BIT_MIRROR_X) > 0;
		boolean mirrorY = (mirrorDir & BIT_MIRROR_Y) > 0;
		
		int scaleMap = scale -1;
		int xTile = tile % 32;
		int yTile = tile / 32;
		int tileOffset = (xTile << 3) + (yTile << 3) * sheet.width;
		for (int y = 0; y < 8; y++) {
			int ySheet = y;
			if(mirrorY) ySheet = 7 - y;
			
			int yPixel = y + yPos + (y * scaleMap) - ((scaleMap << 3)/2);
			
		    for (int x = 0; x<8; x++) {
				int xSheet = x;
				if(mirrorX) xSheet = 7 - x;
				int xPixel = x + xPos + (x * scaleMap) - ((scaleMap << 3)/2);
				int col = (colour >> (sheet.pixels[xSheet + ySheet * sheet.width + tileOffset] * 8))& 255;
			    if (col < 255) {
			    	for (int yScale = 0; yScale < scale; yScale ++) {
			    		if (yPixel + yScale < 0 || yPixel + yScale >= height) continue;
			    		for (int xScale = 0; xScale < scale; xScale++) {
			    			if (xPixel + xScale < 0 || xPixel + xScale >= width) continue;
			    			pixels[(xPixel + xScale) + (yPixel + yScale) * width] = col;
			    			
			    		}	
			    	}	
			    }
			}
		}
	}
	
	/**
	 * Please add a description.
	 * 
	 * @param xOffset add a description
	 * @param yOffset add a description
	 */
	public void setOffset(int xOffset, int yOffset) {
    	this.xOffset = xOffset;
    	this.yOffset = yOffset;
	}
	
	/**
	 * Returns the width of the screen.
	 * 
	 * @return the width of the screen
	 */
	public int getWidth(){
		return width;
	}
	
	/**
	 * Returns the height of the screen.
	 * 
	 * @return the height of the screen
	 */
	public int getHeight(){
		return height;
	}
}

