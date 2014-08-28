package tschib.game.projectShipMaidenSlick2d;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import tschib.game.projectShipMaidenSlick2d.menu.StateMainMenu;
import tschib.game.projectShipMaidenSlick2d.menu.StateNGMenu;
import tschib.game.projectShipMaidenSlick2d.menu.StateSplash;

public class Game extends StateBasedGame {
	public static final String gameName = "GameName";
	public static final int stateSplash = 0;
	public static final int stateMainMenu = 1;
	public static final int stateNGMenu = 2;
	public static final int stateContinueMenu = 3;
	public static final int stateSettingsMenu = 4;

	public static final int statePlay = 10;
	public static final int stateMenu = 11;

	public static PipelineManager pM = new PipelineManager();
	public static KeyMonitor kM = new KeyMonitor();
	public static VirtualPlay vP = new VirtualPlay();
	public static TiledMap tiledMap;

	public Game(String gameName) {
		super(gameName);
		this.addState(new StateSplash(stateSplash));
		this.addState(new StateMainMenu(stateMainMenu));
		this.addState(new StateNGMenu(stateNGMenu));
		this.addState(new StateMenu(stateContinueMenu));// TODO: Klassen
														// erschaffen &
														// anpassen!!!
		this.addState(new StateMenu(stateSettingsMenu));

		this.addState(new StatePlay(statePlay));
		this.addState(new StateMenu(stateMenu));
	}

	public static void main(String[] args) {
		AppGameContainer appGC;
		try {
			appGC = new AppGameContainer(new Game(gameName));
			appGC.setDisplayMode(800, 600, false);// 3rd arg: fullscreen
			appGC.start();

			vP = new VirtualPlay();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		gc.setTargetFrameRate(30);
		this.getState(stateSplash).init(gc, this);
		this.getState(stateMainMenu).init(gc, this);
		this.getState(stateNGMenu).init(gc, this);
		this.getState(stateContinueMenu).init(gc, this);
		this.getState(stateSettingsMenu).init(gc, this);

		this.getState(statePlay).init(gc, this);
		this.getState(stateMenu).init(gc, this);

		this.enterState(stateSplash);// first screen/state to open
	}
}
