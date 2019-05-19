package ball.model;

public class BallFactory {

    public static Ball[] all() {

        return new Ball[]{
                bounceBehaviour(100, 100)
                //bouncingBall(75, 50, BouncingBall.DOWN),
                //elasticBall(250, 100, Ball.DEFAULT_RADIUS, ElasticBall.SHRINK),
               // bouncingElasticBall(400, 50, Ball.DEFAULT_RADIUS, BouncingElasticBall.SHRINK, BouncingElasticBall.DOWN)
        };
    }

//    public static Ball bouncingBall(int centerX, int centerY, int direction) {
//        return new BouncingBall(centerX, centerY, direction);
//    }
//
//    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
//        return new ElasticBall(centerX, centerY, radius, direction);
//    }
//
//    public static Ball bouncingElasticBall(int centerX, int centerY, int radius,int growDirection, int direction) {
//        return new BouncingElasticBall(centerX, centerY, radius, growDirection, direction);
//    }

    public static Ball bounceBehaviour(int x, int y) {
        Ball ball = new Ball(x, y);
        ball.addBehaviour(new BouncingBall());
        ball.addBehaviour(new ElasticBall());
        return ball;
    }
}
