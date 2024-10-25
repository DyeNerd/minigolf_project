package pane;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import sharedObject.RenderableHolder;

public class BackButton extends StackPane {
	public BackButton(RootPane rootPane) {
		Circle c1 = new Circle(20, Color.BLACK);
		Text t1 = new Text("<");
		t1.setFill(Color.WHITE);
		this.setOnMouseClicked(event -> {
			rootPane.setPane(rootPane.getWelcomePage());
			RenderableHolder.clickSound.play();
		});
		this.getChildren().addAll(c1, t1);
	}

}
