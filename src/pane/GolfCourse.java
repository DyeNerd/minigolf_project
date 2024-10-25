package pane;

import input.InputUtility;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;
import javafx.scene.input.KeyEvent;

public class GolfCourse extends Canvas {
	public GolfCourse() {
		super(RenderableHolder.gameWidth, RenderableHolder.golfCourseHeight);
		this.setVisible(true);
		addListerner();
	}

	public void addListerner() {
		this.setOnKeyPressed((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), true);
		});

		this.setOnKeyReleased((KeyEvent event) -> {
			InputUtility.setKeyPressed(event.getCode(), false);
		});

		this.setOnMousePressed((MouseEvent event) -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				InputUtility.isDrag = true;
				InputUtility.mouseLeftDown();
				InputUtility.mouseRelease = false;
			}

		});

		this.setOnMouseReleased((MouseEvent event) -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				InputUtility.mouseRelease = true;
				InputUtility.mouseLeftRelease();
				InputUtility.isDrag = false;
			}

		});

		this.setOnMouseEntered((MouseEvent event) -> {
			InputUtility.mouseOnScreen = true;
		});

		this.setOnMouseExited((MouseEvent event) -> {
			InputUtility.mouseOnScreen = false;
		});

		this.setOnMouseMoved((MouseEvent event) -> {
			if (InputUtility.mouseOnScreen) {
				InputUtility.mouseX = event.getX();
				InputUtility.mouseY = event.getY();
			}
		});

		this.setOnMouseDragged((MouseEvent event) -> {
			if (InputUtility.mouseOnScreen) {
				InputUtility.mouseX = event.getX();
				InputUtility.mouseY = event.getY();
				InputUtility.mousePosX = event.getX();
				InputUtility.mousePosY = event.getY();
				InputUtility.isDrag = true;
			}
		});
	}

	public void paintComponent() {
		GraphicsContext gc = this.getGraphicsContext2D();
		gc.setFill(Color.BLACK);
		for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.isVisible() && !entity.isDestroyed()) {
				entity.draw(gc);
			}
		}
	}
}
