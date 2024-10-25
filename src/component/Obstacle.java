package component;

import logic.CollidableEntity;

public abstract class Obstacle extends CollidableEntity {
	public abstract void onCollision(GolfBall golfball);
}
