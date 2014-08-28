package tschib.game.projectShipMaidenSlick2d;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class VirtualPlay {
	int xTiles = 0;
	int yTiles = 0;
	int xMax;
	int yMax;
	int tileWidth;
	int tileHeight;
	TiledMap tiledMap;
	int pxX = 0;
	int pxY = 0;
	int gameChoice = 2;
	int xCenter = 0;
	int yCenter = 0;

	public VirtualPlay() {
	}

	public void init() {// TODO: invoke somewhere after map is loaded
		xMax = Game.tiledMap.getWidth();
		yMax = Game.tiledMap.getHeight();
		xCenter = tiledMap.getObjectX(xMax, yMax);
		yCenter = tiledMap.getObjectY(xMax, yMax);

	}

	public void update() {
		// off screen logic
	}

	public void setGameChoice(int choice) {
		gameChoice = choice;
	}// difficulty in StateNGMenu

	public int getGameChoice() {
		return gameChoice;
	}

}