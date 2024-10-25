package component;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

public class Water extends Obstacle {
	public Water(int x, int y) {
		this.x = x;
		this.y = y;
		this.z = -100;
		this.radius = 40;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(RenderableHolder.waterSprite, x - radius, y - radius);
	}

	public void onCollision(GolfBall golfBall) {
		golfBall.getGameLogic().setWin(false);
		RenderableHolder.waterBloopSound.play();
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
}
