package component;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Hole extends Obstacle {

	private Circle circle;
	private double radius = 20;

	public Hole(double centerX, double centerY) {
		circle = new Circle(centerX, centerY, radius, Color.BLACK);
		this.z = -200;
	}

	public Circle getCircle() {
		return circle;
	}

	public double getRadius() {
		return radius;
	}

	public void setPosition(double centerX, double centerY) {
		circle.setCenterX(centerX);
		circle.setCenterY(centerY);
	}

	public boolean isBallInHole(GolfBall ball) {
		double ballCenterX = ball.getX();
		double ballCenterY = ball.getY();
		double ballRadius = 10;
		double distance = Math
				.sqrt(Math.pow(ballCenterX - circle.getCenterX(), 2) + Math.pow(ballCenterY - circle.getCenterY(), 2));
		return distance <= (radius - ballRadius);
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.BLACK);
		gc.fillOval(this.circle.getCenterX() - this.circle.getRadius(),
				this.circle.getCenterY() - this.circle.getRadius(), this.circle.getRadius() * 2,
				this.circle.getRadius() * 2);
	}

	@Override
	public void onCollision(GolfBall golfBall) {
		// TODO Auto-generated method stub
		golfBall.setSpeed(golfBall.getSpeed() * 0.3);
	}
}