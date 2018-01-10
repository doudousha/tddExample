package com.wangqing.ship;

import java.util.List;

public class Location {

    private int FORWARD = 1;
    private int BACKWARD = -1;
    private Point point;
    private Direction direction;

    public Location(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public Location copy() {
        return new Location(new Point(this.point.getX(), this.point.getY()), this.direction);
    }

    public boolean forward(Point max, List<Point> obstacles) {
        return move(this.FORWARD, max, obstacles);
    }

    public boolean forward(Point max, List<Point> obstacles, Direction direction) {
        this.direction = direction;
        return move(this.FORWARD, max, obstacles);
    }

    public boolean backward(Point max, List<Point> obstacles) {
        return move(this.BACKWARD, max, obstacles);
    }

    public boolean backward(Point max, List<Point> obstacles, Direction direction) {
        this.direction = direction;
        return move(this.BACKWARD, max, obstacles);
    }


    private boolean move(int fw, Point max, List<Point> obstracles) {
        int x = this.point.getX();
        int y = this.point.getY();

        switch (this.direction) {
            case NORTH:
                y = wrap(this.getY() - fw, max.getY());
                break;
            case SOUTH:
                y = wrap(this.getY() + fw, max.getY());
                break;
            case WEST:
                x = wrap(this.getX() - fw, max.getX());
                break;
            case EAST:
                x = wrap(this.getX() + fw, max.getX());
                break;
        }
        // 判断是否有障碍物
        if (isObstracle(new Point(x, y), obstracles)) {
            return false;
        }
        // 设置point
        point = new Point(x, y);
        return true;
    }

    private boolean isObstracle(Point point, List<Point> obstacles) {
        for (Point obstacle : obstacles) {
            if (obstacle.getX() == point.getX() && obstacle.getY() == point.getY()) {
                return true;
            }
        }
        return false;
    }

    private int wrap(int point, int maxPoint) {
        if (maxPoint > 0) {

            System.out.println(point +" : " + maxPoint);
            if (point > maxPoint) {
                return 1;
            } else if (point == 0) {
                return maxPoint;
            }
        }
        return point;
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


    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object obj) {
        // 相比较引用地址
        if (this != obj) return true;
        // obj不能为空， 比较是同一类型
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Location location = (Location) obj;
        // 比较x，y ，direction
        if (this.getX() != location.getX() || this.getY() != location.getY() || this.getDirection() != location.getDirection()) {
            return false;
        }
        return true;
    }
}
