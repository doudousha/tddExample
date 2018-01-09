package com.wangqing.ship;

import java.util.List;

public class Location {

    private int forward = 1;
    private int backward = -1;
    private Point point;
    private Direction direction;

    public Location(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public void turnLeft() {

    }

    public void turnRight() {

    }

    public Location copy() {
        return new Location(new Point(this.point.getX(), this.point.getY()), this.direction);
    }

    public void forward(Point max , List<Point>  obstacles) {

    }
    public void forward(Point max , List<Point>  obstacles, Direction direction) {

    }

    public int getX() {
        return this.point.getX();
    }

    public int getY() {
        return this.point.getY();
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void backward(Point max, List<Point> obstacles, Direction north) {
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
