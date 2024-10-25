package logic;

import java.util.ArrayList;
import java.util.List;

import component.Entity;
import component.Field;
import component.GolfBall;
import component.Hole;
import component.Map;
import component.Obstacle;
import pane.GameEndScreen;
import pane.RootPane;
import sharedObject.RenderableHolder;

public class GameLogic {
	private List<Entity> gameObjectContainer;
	private List<Obstacle> obstacle;
	private int shotCounter;
	private int maxShot;
	private boolean isWin;
	private GolfBall golfBall;
	private Hole hole;
	private RootPane rootPane;
	private final Map map = new Map();

	public GameLogic(RootPane rootPane) {
		this.rootPane = rootPane;
		Field field = new Field(); 
		isWin = true;
		shotCounter = 0;
		RenderableHolder.getInstance().add(field);

		this.gameObjectContainer = new ArrayList<Entity>();
		this.obstacle = new ArrayList<Obstacle>();

		selectMap(rootPane.getSelectedMap());
	}

	public void checkWinning() {
		if (shotCounter > maxShot) {
			isWin = false;
		} else {
			isWin = true;
		}
	}

	protected void addNewObject(Entity entity) {
		gameObjectContainer.add(entity);
		RenderableHolder.getInstance().add(entity);
		if (entity instanceof Obstacle) {
			obstacle.add((Obstacle) entity);
		}
	}

	public void selectMap(String selectedMap) {
		if (selectedMap.equals("Map 1")) {
			ArrayList<Entity> map1 = map.buildMap1();
			golfBall = new GolfBall(600, 400, this);
			hole = new Hole(50, 50);
			addNewObject(golfBall);
			addNewObject(hole);
			this.maxShot = 6;
			for (Entity e : map1) {
				addNewObject(e);
			}

		} else if (selectedMap.equals("Map 2")) {
			ArrayList<Entity> map2 = map.buildMap2();
			golfBall = new GolfBall(180, 180, this);
			hole = new Hole(500, 300);
			addNewObject(golfBall);
			addNewObject(hole);
			this.maxShot = 8;
			for (Entity e : map2) {
				addNewObject(e);
			}
		} else {
			ArrayList<Entity> map3 = map.buildMap3();
			golfBall = new GolfBall(400, 25, this);
			hole = new Hole(400, 520);
			addNewObject(golfBall);
			addNewObject(hole);
			this.maxShot = 400;
			for (Entity e : map3) {
				addNewObject(e);
			}
		}
	}

	public void logicUpdate() {
		shotCounter = golfBall.getShotCount();
		golfBall.update();
		checkWinning();
		for (Obstacle e : obstacle) {
			if (golfBall.collideWith(e) && !e.isDestroyed()) {
				e.onCollision(golfBall);
			}
		}
		if (hole.isBallInHole(golfBall) && golfBall.getSpeed() == 0) {
			showEndingScene();
			RenderableHolder.puttSound.play();
		}
		if (!isWin) {
			showEndingScene();
		}

	}

	public void showEndingScene() {
		this.rootPane.getGameScreen().reset();
		GameEndScreen endingScreen = new GameEndScreen(rootPane, isWin);
		rootPane.setPane(endingScreen);
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	public List<Entity> getGameObjectContainer() {
		return gameObjectContainer;
	}

	public void setGameObjectContainer(List<Entity> gameObjectContainer) {
		this.gameObjectContainer = gameObjectContainer;
	}

	public List<Obstacle> getObstacle() {
		return obstacle;
	}

	public int getMaxShot() {
		return maxShot;
	}

	public void setMaxShot(int maxShot) {
		this.maxShot = maxShot;
	}

	public void setObstacle(List<Obstacle> obstacle) {
		this.obstacle = obstacle;
	}

	public int getShotCounter() {
		return shotCounter;
	}

	public void setShotCounter(int shotCounter) {
		this.shotCounter = shotCounter;
	}
}
