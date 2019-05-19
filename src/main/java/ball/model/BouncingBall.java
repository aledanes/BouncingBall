package ball.model;

import ball.ui.BallWorld;

public class BouncingBall implements Behaviour {
    public static final int MOVEMENT_SPEED = 12;

    static final int DOWN = 1;
    static final int UP = -1;

    @Override
    public void update(Ball ball) {
        ball.setDirection(reverseDirectionIfNecessary(ball));
        ball.setY(move(ball));
    }

    /***********************************************************************************
     *
     * Do not change Bouncing ALGORITHM below.
     *
     ***********************************************************************************/

    public int reverseDirectionIfNecessary(Ball ball) {
        if (movingTooHigh(ball) || movingTooLow(ball)) {
            return switchDirection(ball);
        }
        return ball.getDirection();
    }

    private boolean movingTooLow(Ball ball) {
        return ball.getY() + ball.getRadius() >= BallWorld.BOX_HEIGHT && movingDown(ball);
    }

    private boolean movingTooHigh(Ball ball) {
        return ball.getY() - ball.getRadius() <= 0 && movingUp(ball);
    }

    public int switchDirection(Ball ball) {
        return movingDown(ball) ? UP : DOWN;
    }

    private int move(Ball ball) {
        return ball.getY() + (MOVEMENT_SPEED * ball.getDirection());
    }

    private boolean movingDown(Ball ball) {
        return ball.getDirection() == DOWN;
    }

    private boolean movingUp(Ball ball) {

        return ball.getDirection() == UP;
    }
}
