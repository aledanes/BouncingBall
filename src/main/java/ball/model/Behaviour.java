package ball.model;

public interface Behaviour {
    void update(Ball ball);

    int reverseDirectionIfNecessary(Ball ball);

    int switchDirection(Ball ball);
}
