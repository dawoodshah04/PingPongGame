package PingPong;


import java.awt.*;
import java.util.LinkedList;

public class Ball extends Rectangle {
    private static final int TRAIL_LENGTH = 50; // Number of trail points
    private final LinkedList<Point> trail = new LinkedList<>();
    int xVelocity, yVelocity;
    int initialSpeed = 3;

    public Ball(int x, int y, int width, int height) {
        super(x, y, width, height);
        xVelocity = initialSpeed;
        yVelocity = initialSpeed;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;

        // Add current position to the trail
        trail.addFirst(new Point(x + width / 2, y + height / 2));
        if (trail.size() > TRAIL_LENGTH) {
            trail.removeLast(); // Maintain fixed trail length
        }
    }

    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public void draw(Graphics g) {
        // Draw the trail with fading effect
        for (int i = 0; i < trail.size(); i++) {
            Point point = trail.get(i);
            int alpha = 255 - (i * (255 / TRAIL_LENGTH)); // Smooth fading
            g.setColor(new Color(255, 255, 0, Math.max(alpha, 0))); // Yellow color with fading
            g.fillOval(point.x - width / 2, point.y - height / 2, width, height);
        }

        // Draw the current ball
        g.setColor(Color.GREEN);
        g.fillOval(x, y, width, height);
    }

}
