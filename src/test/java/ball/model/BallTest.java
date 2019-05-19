package ball.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    public void shouldHaveAtLeastOneBehaviour(){
        Ball ball = new Ball(100, 100, new Bounce());

    }
}