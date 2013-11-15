package com.proj.board;

/** This class controls the 2D Board in the game, as well as all necessary implementation */

public class Board {
	private int boardSize=15;
	private Tile[][] tiles;  // the 2D array of tiles
	
	public Board() {
		tiles=new Tile[boardSize][boardSize];
	}
	
	public boolean isOccupied(int width, int height) {
		if ((width>boardSize) || (height>boardSize)) {
			throw new IndexOutOfBoundsException(">> Invalid array bounds");
		}
		return tiles[width][height]==null;
	}
	
	
	
	

}
