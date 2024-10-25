package pane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import sharedObject.RenderableHolder;

public class GameEndScreen extends StackPane {
	private RootPane rootPane;
	private HBox buttonSection;
	private Label titleLabel;
	private boolean isWin;
	private VBox temp;
	private ImageView backgroundImageView2 = new ImageView(RenderableHolder.backgroundImage2);

	public GameEndScreen(RootPane rootPane, boolean isWin) {
		temp = new VBox();
		this.setPrefWidth(RenderableHolder.gameWidth);
		this.setPrefHeight(RenderableHolder.gameHeight);
		this.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
		this.isWin = isWin;
		this.rootPane = rootPane;
		this.getStyleClass().add("ending");
		titleLabel = new Label();
		titleLabel.getStyleClass().add("text-title");
		createButtonSection();
		temp.setSpacing(20);
		temp.setPadding(new Insets(40));
		temp.setAlignment(Pos.CENTER);
	}

	public void createButtonSection() {
		buttonSection = new HBox();
		Button reset = new Button();
		reset.setText("Play Again");
		reset.setOnAction(event -> {
			RenderableHolder.clickSound.play();
			rootPane.getGameScreen().reset();
			rootPane.getGameScreen().start();
		});
		reset.getStyleClass().add("ending-reset");

		Button home = new Button();
		home.setText("Home");
		home.setOnAction(event -> {
			rootPane.setPane(rootPane.getWelcomePage());
			RenderableHolder.clickSound.play();
		});
		home.getStyleClass().add("ending-home");

		buttonSection.setSpacing(40);
		buttonSection.getChildren().addAll(reset, home);
		buttonSection.setAlignment(Pos.CENTER);

		chosingScene();
	}

	public void losingScene() {
		titleLabel.setText("YOU LOSE!");
		RenderableHolder.failSound.play();
		temp.getChildren().addAll(titleLabel, buttonSection);

		this.getChildren().add(temp);
		this.getChildren().add(0, backgroundImageView2);
	}

	public void winningScene() {
		titleLabel.setText("YOU WIN!");
		RenderableHolder.successSound.play();
		temp.getChildren().addAll(titleLabel, buttonSection);
		this.getChildren().add(temp);
		this.getChildren().add(0, backgroundImageView2);
	}

	public void chosingScene() {
		if (isWin) {
			winningScene();
		} else {
			losingScene();
		}
	}

}
