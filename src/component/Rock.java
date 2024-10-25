package component;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

public class Rock extends Obstacle {
	public Rock(int x, int y) {
		this.x = x;
		this.y = y;
		this.z = -100;
		this.radius = 20;
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.drawImage(RenderableHolder.rockSprite, x - radius, y - radius);

	}

	@Override
	public void onCollision(GolfBall golfball) {
		// TODO Auto-generated method stub
		golfball.hitObstacle();
		RenderableHolder.rockHit.play();
	}

}
