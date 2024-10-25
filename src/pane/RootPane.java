package pane;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import sharedObject.RenderableHolder;

public class RootPane extends StackPane {
	private WelcomePage welcomePage;
	private GameScreen gameScreen;
	private String selectedMap;

	public RootPane() {
		this.setPrefWidth(RenderableHolder.gameWidth);
		this.setPrefHeight(RenderableHolder.gameHeight);
		welcomePage = new WelcomePage(this);
		gameScreen = new GameScreen(this);
		this.getChildren().add(welcomePage);
	}

	public void setPane(Pane pane) {
		this.getChildren().clear();
		this.getChildren().add(pane);
	}

	public WelcomePage getWelcomePage() {
		return welcomePage;
	}

	public void setWelcomePage(WelcomePage welcomePage) {
		this.welcomePage = welcomePage;
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}

	public String getSelectedMap() {
		return selectedMap;
	}

	public void setSelectedMap(String selectedMap) {
		this.selectedMap = selectedMap;
	}

}
