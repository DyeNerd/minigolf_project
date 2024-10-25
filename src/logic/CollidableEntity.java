package logic;

import component.Entity;
import component.GolfBall;
import component.Wall;

public abstract class CollidableEntity extends Entity {
	protected int radius;

	protected boolean collideWith(CollidableEntity other) {
		if (other instanceof Wall) {
			return ((Wall) other).isBallColliding((GolfBall) this);
		} else {
			return Math.hypot(this.x - other.x, this.y - other.y) <= this.radius + other.radius;
		}
	}
}
