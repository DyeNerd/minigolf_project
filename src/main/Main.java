package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pane.RootPane;
import sharedObject.RenderableHolder;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		RootPane root = new RootPane();
		Scene scene = new Scene(root, 800, 640);
		stage.setScene(scene);
		stage.setTitle("MiniGolf");
		stage.setResizable(false);
		stage.getIcons().add(RenderableHolder.golfBall);
		stage.show();
		RenderableHolder.playBackgroundMusic();
	}

}