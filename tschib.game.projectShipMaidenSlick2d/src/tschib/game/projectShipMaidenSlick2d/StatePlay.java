package tschib.game.projectShipMaidenSlick2d;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class StatePlay implements GameState {
	int state;
	VirtualPlay vP;
	MouseOverArea moaNorth;
	MouseOverArea moaEast;
	MouseOverArea moaSouth;
	MouseOverArea moaWest;
	int xAbsMin = 0;
	int yAbsMin = 0;
	int xMaxMap = 0;
	int yMaxMap = 0;
	int xRel = 0;
	int yRel = 0;
	int xCent = 0;
	int yCent = 0;
	int xCentMap = 0;
	int yCentMap = 0;
	final int XCORR = 26;// TODO: bullshit
	final int YCORR = 12;// TODO: bullshit
	private final int SCROLLSENSIVITY = 10;

	public StatePlay(int state) {
		this.state = state;
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// init mouse scroll areas
		moaNorth = new MouseOverArea(gc, null, 0, 0, gc.getWidth(), 5);
		moaEast = new MouseOverArea(gc, null, gc.getWidth() - 5, 0,
				gc.getWidth(), gc.getHeight());
		moaSouth = new MouseOverArea(gc, null, 0, gc.getHeight() - 5,
				gc.getWidth(), gc.getHeight());
		moaWest = new MouseOverArea(gc, null, 0, 0, 5, gc.getHeight());
	}

	@Override
	public void mouseClicked(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInput(Input arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(int arg0, char arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(int arg0, char arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerButtonPressed(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerButtonReleased(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerDownPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerDownReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerLeftPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerLeftReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerRightPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerRightReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerUpPressed(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerUpReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public int getID() {
		return state;
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.clear();
		Game.tiledMap.render(xRel-xCentMap, yRel-yCentMap);

		System.out.println("xRel: " + xRel + " xComb: " + (xRel + xCent)
				+ " - " + " yRel: " + yRel + " yComb: " + (yCent + yRel));
		g.drawOval(xCent, yCent, 10, 10);
		g.drawOval(0 + xRel, 0 + yRel, 20, 20);
		g.drawOval(XCORR + xRel, YCORR + yRel, 20, 20);
		g.drawOval(xMaxMap, yMaxMap, 10, 10);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		xCent = gc.getWidth() / 2;
		yCent = gc.getHeight() / 2;

		xCentMap = Game.tiledMap.getWidth()*Game.tiledMap.getTileWidth()/2;
		yCentMap = Game.tiledMap.getHeight()*Game.tiledMap.getTileHeight()/2;

		xMaxMap = Game.tiledMap.getWidth() * Game.tiledMap.getTileWidth()
				+ xRel;
		yMaxMap = Game.tiledMap.getHeight() * Game.tiledMap.getTileHeight()
				+ yRel;

		Input input = gc.getInput();

		// Map Scrolling
		if ((moaNorth.isMouseOver() || input.isKeyDown(Input.KEY_UP))) {
			yRel += SCROLLSENSIVITY;
		}
		if (moaEast.isMouseOver() || input.isKeyDown(Input.KEY_RIGHT)) {
			xRel -= SCROLLSENSIVITY;
		}
		if (moaSouth.isMouseOver() || input.isKeyDown(Input.KEY_DOWN)) {
			yRel -= SCROLLSENSIVITY;
		}
		if (moaWest.isMouseOver() || input.isKeyDown(Input.KEY_LEFT)) {
			xRel += SCROLLSENSIVITY;
		}
	}
}