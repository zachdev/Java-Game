package com.zachdev.game.graphics;

public class AnimatedSprite extends Sprite {
	
	private Sprite sprite;
	
	private int frame = 0;

	private int rate = 10;
	
	private int time = 0;

	private int animationLength = -1;

	public AnimatedSprite(SpriteSheet spriteSheet, int width, int height,
			int animationLength) {

		super(spriteSheet, width, height);
		this.animationLength = animationLength;
		
		sprite = sheet.getSprites()[0];
		
		if (animationLength > sheet.getSprites().length) System.out.println("Sprite animation length too long");

	}

	public void tick() {
		time++;
		if (time % rate == 0) {
			
			if (frame >= animationLength - 1) frame = 0;
			else frame++;
			
			sprite = sheet.getSprites()[frame];
			
			
		}
		
		//System.out.println(sprite + ", Frame: " + frame);

	}

	public Sprite getSprite() {

		return sprite;
	}
	
	public void setFrame(int index) {
		
		// If the index is greater than the number of sprites in the sheet, exit out
		if (index > sheet.getSprites().length - 1) {
			
			System.out.println("index out of bounds in sprite sheet (AnimatedSprite.java)");
			return;
		}
		
		sprite = sheet.getSprites()[index];
	}

	/**
	 * Sets the rate of the animation
	 * 
	 * @param frameRate
	 */
	public void setFrameRate(int frameRate) {
		rate = frameRate;

	}

}
