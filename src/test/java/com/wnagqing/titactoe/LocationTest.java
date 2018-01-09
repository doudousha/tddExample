package com.wnagqing.titactoe;

import com.wangqing.ship.Direction;
import com.wangqing.ship.Location;
import com.wangqing.ship.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class LocationTest {

    private Location location;
    private int x = 12;
    private int y = 32;
    private Direction direction = Direction.NORTH;
    private Point max;
    private List<Point> obstacles;

    @Before
    public void before() {
        this.location = new Location(new Point(this.x, this.y), this.direction);
    }

    @Test
    public void whenInstantiatedThenXIsStored() {
        assertEquals(this.location.getX(), this.x);
    }

    @Test
    public void whenInstantiatedThenYIsStored() {
        assertEquals(this.location.getY(), this.y);
    }

    @Test
    public void whenInstantiatedThenDirectionIsStored() {
        assertEquals(this.location.getDirection(), this.direction);
    }

    /**
     * y向北
     */
    @Test
    public void givenDirectionNWhenForwardThenYDecreases() {
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.y - 1, this.location.getY());
    }

    /**
     * y向南
     */
    @Test
    public void givenDirectionSWhenForwardThenYIncreases() {
        this.location.forward(this.max, this.obstacles, Direction.SOUTH);
        assertEquals(y + 1, this.location.getY());
    }

    /**
     * x向东
     */
    @Test
    public void givenDirectionEWhenForwardThenXIncreases() {
        this.location.forward(this.max, this.obstacles, Direction.EAST);
        assertEquals(x + 1, this.location.getX());
    }

    /**
     * x向西
     */
    @Test
    public void givenDirectionWWhenForwardThenXDecreases() {
        this.location.forward(this.max, this.obstacles, Direction.WEST);
        assertEquals(this.x - 1, this.location.getX());
    }

    // y向北 倒退
    @Test
    public void givenDirectionNWhenBackwardThenYIncreases() {
        this.location.backward(this.max, this.obstacles, Direction.NORTH);
        assertEquals(this.y + 1, this.location.getY());
    }

    // y 向南 倒退
    @Test
    public void givenDirectionSWhenBackwardThenYDecreases() {
        this.location.backward(this.max, this.obstacles, Direction.SOUTH);
        assertEquals(this.y - 1, this.location.getY());
    }

    // x 向东 倒退
    @Test
    public void givenDirectionEWhenBackwardThenXDecreases() {
        this.location.backward(this.max, this.obstacles, Direction.EAST);
        assertEquals(this.x - 1, this.location.getX());
    }

    // x 向西倒退
    @Test
    public void givenDirectionWWhenBackwardThenXIncreases() {
        this.location.backward(this.max, this.obstacles, Direction.WEST);
        assertEquals(this.x + 1, this.location.getX());
    }

    // 北向左移动=西
    @Test
    public void whenTurnleftThenDirectionIsSet() {
        this.location.turnLeft();
        assertEquals(Direction.WEST, this.location.getDirection());
    }

    // 北向右移动=东
    @Test
    public void whenTurnRightThenDirectionIsSet() {
        this.location.turnRight();
        assertEquals(Direction.EAST, this.location.getDirection());
    }

    // 一样的对象调用equals 返回true
    @Test
    public void givenSameObjectWhenEqualsThenTrue() {
        assertTrue(location.equals(this.location));
    }

    // 不一样的对象调用equals返回false
    @Test
    public void givenDifferentObjectWhenEqualsThenFalse() {
        assertFalse(location.equals("abc"));
    }

    // 不同的y调用equals 返回false
    @Test
    public void givenDifferentYWhenEqualsThenFalse() {
        Location locationCopy = new Location(new Point(999, this.location.getY()), this.location.getDirection());
        assertFalse(locationCopy.equals(this.location));
    }

    // 不同的drection 调用equals 返回false
    @Test
    public void givenDifferentDerectionWhenEqualsThenFalse() {
        Location locationCopy = new Location(new Point(this.location.getX(), this.location.getY()), Direction.EAST);
        assertFalse(locationCopy.equals(this.location));
    }

    // 相同的xy 和direction 调用equals 返回true
    @Test
    public void givenSameXYDirectionWhenEqualsThenTrue() {
        Location locationCopy = new Location(this.location.getPoint(), this.location.getDirection());
        assertTrue(locationCopy.equals(this.location));
    }


    // 比较引用地址是否一致
    @Test
    public void whenCopyThenDifferentObject() {
        Location copy = location.copy();
        assertNotSame(this.location, copy);
    }

    // 比较equal
    @Test
    public void whenCopyThenEquals() {
        Location copy = location.copy();
        assertEquals(copy, this.location);
    }

    // 当x等于max.x 返回的x等于1
    public void givenDirectionEAndXEqualsMaxXWhenForwardThen1() {
        this.location.setDirection(Direction.WEST);
        this.location.getPoint().setX(this.max.getX());
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.location.getX(), 1);
    }


    /*
    Decreases: 减少
    Increases: 增加
     */
}
