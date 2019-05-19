package ball.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ball {
    protected static final int DEFAULT_RADIUS = 50;
    protected int x;
    protected int y;
    protected int radius;
    protected List<Behaviour> behaviours;
    private int direction;

    protected Ball(int x, int y, int radius, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.behaviours = new ArrayList<Behaviour>();
        this.direction = direction;
    }

    protected Ball(int x, int y) {
        this(x, y, DEFAULT_RADIUS, 1);
    }

    public Ball(int x, int y, int radius) {
        this.behaviours = new ArrayList<Behaviour>();
    }

    public void addBehaviour(Behaviour behaviour){
        behaviours.add(behaviour);
    }

    // DO NOT CHANGE
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    public Point center() {
        return new Point(x, y);
    }

    public void update() {
        for (Behaviour behaviour: behaviours) {
            behaviour.update(this);
        }
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public void setY(int y) {
        this.y = y;

    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public int getRadius() {
        return radius;
    }

}
