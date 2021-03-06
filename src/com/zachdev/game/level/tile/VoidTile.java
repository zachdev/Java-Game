package com.zachdev.game.level.tile;

import com.zachdev.game.graphics.Screen;
import com.zachdev.game.graphics.Sprite;

/**
 * A void tile is used as a placeholder 'nothing' tile
 * 
 * @author zach
 *
 */
public class VoidTile extends Tile {
	
	public VoidTile (Sprite sprite) {
		
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		
		screen.renderTile(x * Tile.TILE_SIZE, y * Tile.TILE_SIZE, this);
	}

}
