package tschib.game.projectShipMaidenSlick2d.menu;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

import tschib.game.projectShipMaidenSlick2d.Game;
import tschib.game.projectShipMaidenSlick2d.VirtualPlay;

public class StateNGMenu implements GameState {
	int state;
	private Image img;// del
	long timer = 0;
	long timeAtStart = 0;
	MouseOverArea moaNGEasy;
	MouseOverArea moaNGNormal;
	MouseOverArea moaNGHard;
	MouseOverArea moaBack;

	public StateNGMenu(int state) {
		this.state = state;
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {

		img = new Image("Assets/Hero1.png");
		timeAtStart = System.currentTimeMillis();

		// buttons
		Image imgNGEasy = new Image("Assets/NGEasy.png");
		Image imgNGNormal = new Image("Assets/NGNormal.png");
		Image imgNGHard = new Image("Assets/NGHard.png");
		Image imgBack = new Image("Assets/Back.png");

		moaNGEasy = new MouseOverArea(gc, imgNGEasy, 100, 100,
				imgNGEasy.getHeight(), imgNGEasy.getWidth());
		moaNGNormal = new MouseOverArea(gc, imgNGNormal, 100, 200,
				imgNGNormal.getHeight(), imgNGNormal.getWidth());
		moaNGHard = new MouseOverArea(gc, imgNGHard, 100, 300,
				imgNGHard.getHeight(), imgNGHard.getWidth());
		moaBack = new MouseOverArea(gc, imgBack, 100, 400, imgBack.getHeight(),
				imgBack.getWidth());

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
	public void enter(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		System.out.println("enters2");
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
		g.drawImage(img, 50, 50);
		g.drawString("NG Menu", gc.getWidth() / 2, gc.getHeight() / 2);
		moaNGEasy.render(gc, g);
		moaNGNormal.render(gc, g);
		moaNGHard.render(gc, g);
		moaBack.render(gc, g);
	}

	// public void loadTiledMap(String url) {
	// try {
	// Game.tiledMap = new TiledMap(url);
	// } catch (SlickException e) {
	// e.printStackTrace();
	// }
	// }

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)//
			throws SlickException {
		Input input = gc.getInput();

		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			sbg.enterState(1, new FadeOutTransition(Color.black),
					new FadeInTransition(Color.black));
		}

		if (moaNGEasy.isMouseOver()) {
			if (Mouse.isButtonDown(0)) {
				Game.tiledMap = new TiledMap("Assets/Map.tmx");
				sbg.enterState(10, new FadeOutTransition(Color.black),
						new FadeInTransition(Color.black));// TODO:tuorial?
			}
		}

		if (moaNGNormal.isMouseOver()) {
			if (Mouse.isButtonDown(0)) {
				Game.tiledMap = new TiledMap("Assets/Map2.tmx");
				sbg.enterState(10, new FadeOutTransition(Color.black),
						new FadeInTransition(Color.black));
			}
		}

		if (moaNGHard.isMouseOver()) {
			if (Mouse.isButtonDown(0)) {
				Game.tiledMap = new TiledMap("Assets/Map99.tmx");
				sbg.enterState(10, new FadeOutTransition(Color.black),
						new FadeInTransition(Color.black));
			}
		}

		if (moaBack.isMouseOver()) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(1, new FadeOutTransition(Color.black),
						new FadeInTransition(Color.black));
			}
		}
	}
}