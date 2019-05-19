package ball;

import ball.model.Ball;
import ball.model.BouncingBall;
import ball.model.ElasticBall;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTestHarness {
    public static void assertCenterYCoordinateIs(int expectedCenterY, Ball ball) {
        assertEquals(expectedCenterY, ball.center().y, "Ball is at the wrong y-coordinate!");
    }

    public static int oneStepDownFrom(int centerY) {
        return centerY + BouncingBall.MOVEMENT_SPEED;
    }

    public static int oneStepUpFrom(int centerY) {
        return centerY - BouncingBall.MOVEMENT_SPEED;
    }


    public static void assertRadiusIs(int expectedRadius, Ball ball) {
        assertEquals(expectedRadius, ball.radius(), "Ball does not have the correct radius");
    }

    public static int oneStepInwardsFrom(int radius) {
        return radius - ElasticBall.GROWTH_RATE;
    }

    public static int oneStepOutwardsFrom(int radius) {
        return radius + ElasticBall.GROWTH_RATE;
    }
}
