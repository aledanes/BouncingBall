package ball.model;

public class ElasticBall implements Behaviour {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    @Override
    public void update(Ball ball) {
        ball.setGrowthDirection(reverseDirectionIfNecessary(ball));
        ball.setRadius(next(ball));
    }

    /***********************************************************************************
     *
     * Do not change Elastic ALGORITHM below.
     *
     ***********************************************************************************/

    @Override
    public int reverseDirectionIfNecessary(Ball ball) {
        if (growingTooBig(ball) || shrinkingTooSmall(ball)) {
            return switchDirection(ball);
        }

        return ball.getGrowthDirection();
    }

    private boolean shrinkingTooSmall(Ball ball) {
        return ball.getRadius() <= 0 && shrinking(ball);
    }

    private boolean growingTooBig(Ball ball) {
        return ball.getRadius() >= Ball.DEFAULT_RADIUS && growing(ball);
    }

    @Override
    public int switchDirection(Ball ball) {
        return growing(ball) ? SHRINK : GROW;
    }

    private int next(Ball ball) {
        return ball.getRadius() + (GROWTH_RATE * ball.getGrowthDirection());
    }

    private boolean shrinking(Ball ball) {
        return ball.getGrowthDirection() == SHRINK;
    }

    private boolean growing(Ball ball) {
        return ball.getGrowthDirection() == GROW;
    }
}
