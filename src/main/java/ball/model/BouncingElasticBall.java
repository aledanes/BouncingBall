package ball.model;

import ball.ui.BallWorld;

public class BouncingElasticBall extends Ball{

    public static final int GROWTH_RATE = 2;
    public static final int MOVEMENT_SPEED = 12;

    static final int GROW = 1;
    static final int SHRINK = -1;
    static final int DOWN = 1;
    static final int UP = -1;

    private int direction;
    private int growthDirection;

    BouncingElasticBall(int x, int y, int radius, int growthDirection, int direction) {
        super(x, y, radius);
        this.growthDirection = growthDirection;
        this.direction = direction;
    }

    @Override
    public void update() {
        direction = reverseDirectionIfNecessary();
        y = move();
        growthDirection = reverseGrowthDirectionIfNecessary();
        radius = next();
    }

    private int reverseDirectionIfNecessary() {
        if (movingTooHigh() || movingTooLow()) {
            return switchMovingDirection();
        }

        return this.direction;
    }

    private int reverseGrowthDirectionIfNecessary() {
        if (growingTooBig() || shrinkingTooSmall()) {
            return switchDirection();
        }

        return this.growthDirection;
    }

    private boolean shrinkingTooSmall() {
        return radius <= 0 && shrinking();
    }

    private boolean growingTooBig() {
        return radius >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next() {
        return radius + (GROWTH_RATE * growthDirection);
    }

    private boolean shrinking() {
        return growthDirection == SHRINK;
    }

    private boolean growing() {
        return growthDirection == GROW;
    }

    private boolean movingTooLow() {
        return y + radius >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh() {
        return y - radius <= 0 && movingUp();
    }

    private int switchMovingDirection() {
        return movingDown() ? UP : DOWN;
    }

    private int move() {
        return y + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }
}
