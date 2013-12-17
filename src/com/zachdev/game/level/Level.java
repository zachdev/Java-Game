package com.zachdev.game.level;

import java.util.Random;

import com.zachdev.game.graphics.Screen;
import com.zachdev.game.graphics.Sprite;
import com.zachdev.game.level.tile.Tile;

public class Level {
	
	private static Random random = new Random();
	
	private final int TILE_SIZE = 16;			// Each tile is 16 * 16 pixels
	
	public int width, height;
	
	protected int[] tiles;
	
	private int animate = 0;
	
	/**
	 * Constructor that instantiates a new Level with a given width and height (in tile precision)
	 *
	 * @param width
	 * @param height
	 */
	public Level(int width, int height) {
		
		this.width = width;
		this.height = height;
		
		tiles = new int[width * height];
		
		generateLevel();
	}
	
	public Level (String filePath) {
		
		loadLevel(filePath);
	}
	
	protected void generateLevel() {
		
		
	}
	
	private void loadLevel(String filePath) {
		
		
	}
	
	/**
	 * Updates events in the level (mobs moving around, etc)
	 */
	public void tick() {
		
		if (animate < 10000) {
			
			animate++;				// Increase animation count
		}else {
			
			animate = 0;			// Else reset the animation count to 0 after 10000 ticks so game doesn't crash
		}
		
		
	}
	
	
	public void render(int xScroll, int yScroll, Screen screen) {
		
		screen.setOffset(xScroll, yScroll);	// Sets offset from location of player
		
		// Corner pins - x,y coordinates of top left and bottom right corners of the rendering area
		
		int x0	= xScroll / TILE_SIZE;					// leftmost X coordinate of the screen area we are rendering
		int x1 = (xScroll + screen.width + 16) / TILE_SIZE; 	// rightmost X coordinate of the screen area we are rendering
		
		int y0 = yScroll / TILE_SIZE;					// leftmost y coordinate
		int y1 = (yScroll + screen.height + 16) / TILE_SIZE;	// rightmost x coordinate
		
		
		for (int y = y0; y < y1; y++) { 			// Loops through the rendered window space and renders the tiles
			
			for (int x = x0; x < x1; x++) {
				
				getTile(x, y).render(x, y, screen);		// Renders the tile onto the screen
				
			}
		}
	}
	
	
	/**
	 * Returns the tile at the provided x and y coordinates (in the grid location)
	 * @param x
	 * @param y
	 * @return
	 */
	public Tile getTile(int x, int y) {
		
		
		if (x < 0 || y < 0 || x >= width || y >= height) {			// If we exceed the tile index just return a void tile
			
			return Tile.voidTile;
		}
		
		if (tiles[x + y * width]== 0) {
			
			return Tile.rock;
		}

		if (tiles[x + y * width]== 1 || tiles[x + y * width]== 2 || tiles[x + y * width]== 3) {
	
			
			if (animate % 90 > 10) {					// animate incrases by 60 each second
				// Whenever the remainder of anim and 20 is > 10 (50% of the time)
				return Tile.water;
			}
			else {

				return Tile.water1;
			}
		}
		
		return Tile.voidTile;		// Return a void tile if nothing else
		
		
	}
	
	private void time() {
		
		
	}

}
