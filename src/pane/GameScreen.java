package pane;

import input.InputUtility;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.VBox;
import logic.GameLogic;
import sharedObject.RenderableHolder;

public class GameScreen extends VBox {
	private GameLogic gameLogic;
	private GolfCourse golfCourse;
	private TopGamePane topGamePane;
	private RootPane rootPane;
	private AnimationTimer animation;

	public GameScreen(RootPane rootPane) {
		this.setPrefWidth(RenderableHolder.gameWidth);
		this.setPrefHeight(RenderableHolder.gameWidth);
		this.rootPane = rootPane;
		golfCourse = new GolfCourse();
		gameLogic = new GameLogic(rootPane);

		VBox gamePane = createPane(golfCourse);
		
		this.getChildren().add(gamePane);
		this.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
		animation = new AnimationTimer() {
			public void handle(long now) {
				gameLogic.logicUpdate();
				golfCourse.paintComponent();
				RenderableHolder.getInstance().update();
				InputUtility.updateInputState();
				topGamePane.setShotParameter(gameLogic.getShotCounter() + "");
			}
		};
	}

	public VBox createPane(GolfCourse golfCourse) {
		VBox gamePane = new VBox();
		topGamePane = new TopGamePane(rootPane);
		topGamePane.setMaxShot(gameLogic.getMaxShot());
		topGamePane.setShotParameter("0");
		gamePane.getChildren().addAll(topGamePane, golfCourse);
		return gamePane;
	}

	public void start() {
		animation.start();
		rootPane.setPane(this);
	}

	public void reset() {
		animation.stop();
		RenderableHolder.getInstance().getEntities().clear();
		gameLogic = new GameLogic(rootPane);
		golfCourse = new GolfCourse();
		VBox gamePane = createPane(golfCourse);
		this.getChildren().clear();
		this.getChildren().add(gamePane);
	}
}
