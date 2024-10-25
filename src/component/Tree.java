package component;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

public class Tree extends Obstacle {
	public Tree(int x, int y) {
		this.x = x;
		this.y = y;
		this.z = -100;
		this.radius = 20;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(RenderableHolder.treeSprite, x - radius, y - radius);
	}

	public void onCollision(GolfBall golfBall) {
		golfBall.hitObstacle();
		this.destroyed = true;
		RenderableHolder.treeHit.play();

	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}
}
