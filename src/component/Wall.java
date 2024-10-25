package component;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Wall extends Obstacle{
	private double x;
    private double y;
    private double width;
    private double height;

    public Wall(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean isBallColliding(GolfBall ball) {
        double ballX = ball.getX();
        double ballY = ball.getY();
        double ballRadius = 10;

        // Check for collision using bounding boxes
        return ballX + ballRadius >= x &&
               ballX - ballRadius <= x + width &&
               ballY + ballRadius >= y &&
               ballY - ballRadius <= y + height;
    }

	@Override
	public void onCollision(GolfBall golfball) {
		// TODO Auto-generated method stub
		double ballX = golfball.getX();
        double ballY = golfball.getY();
        double ballRadius = 10;

        // Adjust the ball's velocity based on collision
        if (ballX - ballRadius <= x || ballX + ballRadius >= x + width) {
            golfball.reverseXVelocity();
        }

        if (ballY - ballRadius <= y || ballY + ballRadius >= y + height) {
            golfball.reverseYVelocity();
        }
	}

	@Override
	public void draw(GraphicsContext gc) {
		// TODO Auto-generated method stub
		gc.setFill(Color.GREY);
        gc.fillRect(x, y, width, height);
	}
}
