package com.wnagqing.titactoe;

import com.wangqing.ship.Direction;
import com.wangqing.ship.Location;
import com.wangqing.ship.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/*
                     Y

                    -6
                    -5
                    -4
                    -3
                    -2
                    -1
  X -6 -5 -4 -3 -2 -1 0 1 2 3 4 5 6  X
                     1
                     2
                     3
                     4
                     5
                     6

                     Y
 */

public class LocationTest {

    private Location location;
    private int x = 12;
    private int y = 32;
    private Direction direction = Direction.NORTH;
    private List<Point> obstacles;
    private Point max;

    @Before
    public void before() {
        this.max = new Point(50, 50);
        this.location = new Location(new Point(this.x, this.y), this.direction);
        this.obstacles = new ArrayList<>();
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
     * 假定direction=NORTH,当forward被调用后，那么y应该被减少
     */
    @Test
    public void givenDirectionNWhenForwardThenYDecreases() {
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.y - 1, this.location.getY());
    }

    /**
     * y向南
     * 假定directioin=SOUTH ,当forward被调用后，那么y应该被增加
     */
    @Test
    public void givenDirectionSWhenForwardThenYIncreases() {
        this.location.forward(this.max, this.obstacles, Direction.SOUTH);
        assertEquals(y + 1, this.location.getY());
    }

    /**
     * x向东 前进
     * 假定direction = EAST ，当forward被调用后，那么x应该被增加
     */
    @Test
    public void givenDirectionEWhenForwardThenXIncreases() {
        this.location.forward(this.max, this.obstacles, Direction.EAST);
        assertEquals(x + 1, this.location.getX());
    }

    /**
     * x向西 前进
     * 假定dirctioin=WEST,当forward被调用，那么x应该被减少
     */
    @Test
    public void givenDirectionWWhenForwardThenXDecreases() {
        this.location.forward(this.max, this.obstacles, Direction.WEST);
        assertEquals(this.x - 1, this.location.getX());
    }

    // y向北 倒退
    // 假定direction = NORTH,当backward被调用后，那么Y应该被增加
    @Test
    public void givenDirectionNWhenBackwardThenYIncreases() {
        this.location.backward(this.max, this.obstacles, Direction.NORTH);
        assertEquals(this.y + 1, this.location.getY());
    }

    // y 向南 倒退
    // 假定direction =SOUTH ,当backward被调用后,那么Y 应该被减少
    @Test
    public void givenDirectionSWhenBackwardThenYDecreases() {
        this.location.backward(this.max, this.obstacles, Direction.SOUTH);
        assertEquals(this.y - 1, this.location.getY());
    }

    // x 向东 倒退
    // 假定direction=EAST ,当backward被调用后，那么x 应该被减少
    @Test
    public void givenDirectionEWhenBackwardThenXDecreases() {
        this.location.backward(this.max, this.obstacles, Direction.EAST);
        assertEquals(this.x - 1, this.location.getX());
    }

    // x 向西倒退
    // 假定desction等于WEST,当backward被调用后 ，那么 x 应该被增加
    @Test
    public void givenDirectionWWhenBackwardThenXIncreases() {
        this.location.backward(this.max, this.obstacles, Direction.WEST);
        assertEquals(this.x + 1, this.location.getX());
    }

    // 北向左移动=西
    // 当turnRight被调用后，那么dirction等于期望的值
    @Test
    public void whenTurnLeftThenDirectionIsSet() {
        this.location.turnLeft();
        assertEquals(Direction.WEST, this.location.getDirection());
    }

    // 北向右移动 = 东
    // 当turnRight被调用后，那么direction 等于期望的值
    @Test
    public void whenTurnRightThenDirectionIsSet() {
        this.location.turnRight();
        assertEquals(Direction.EAST, this.location.getDirection());
    }

    // 假定有一样的对象，当调用equals后，返回的结果等于true
    @Test
    public void givenSameObjectWhenEqualsThenTrue() {
        assertTrue(location.equals(this.location));
    }

    // 假定有不一样的对象，当调用equals后，返回的结果应该等于false
    @Test
    public void givenDifferentObjectWhenEqualsThenFalse() {
        assertFalse(location.equals("abc"));
    }

    // 假定有不同的y，当调用equals后，那么返回的结果应该等于false
    @Test
    public void givenDifferentYWhenEqualsThenFalse() {
        Location locationCopy = new Location(new Point(999, this.location.getY()), this.location.getDirection());
        assertFalse(locationCopy.equals(this.location));
    }

    // 假定有不同的drection ，当调用equals后，那么返回结果的等于false
    @Test
    public void givenDifferentDerectionWhenEqualsThenFalse() {
        Location locationCopy = new Location(new Point(this.location.getX(), this.location.getY()), Direction.EAST);
        assertFalse(locationCopy.equals(this.location));
    }

    // 假定有相同的xy 和direction， 当调用equals时，那么结果等于true
    @Test
    public void givenSameXYDirectionWhenEqualsThenTrue() {
        Location locationCopy = new Location(this.location.getPoint(), this.location.getDirection());
        assertTrue(locationCopy.equals(this.location));
    }


    // 比较引用地址是否一致
    // 当copy被调用后，那么返回结果是一个不同的对象
    @Test
    public void whenCopyThenDifferentObject() {
        Location copy = location.copy();
        assertNotSame(this.location, copy);
    }

    // 比较equal
    // 当copy被调用后，那么返回的结果是一个相同的对象
    @Test
    public void whenCopyThenEquals() {
        Location copy = location.copy();
        assertEquals(copy, this.location);
    }

    // 在坐标点(x=50)向西前进后,坐标点x等于1
    // 假定direction=EAST 且x=max.x ,当forward被调动后，那么返回的为1
    @Test
    public void givenDirectionEAndXEqualsMaxXWhenForwardThen1() {
        this.location.setDirection(Direction.EAST);
        this.location.getPoint().setX(this.max.getX());
        this.location.forward(this.max, this.obstacles);
        assertEquals(this.location.getX(), 1);
    }

    // 在坐标点(x=1) 向北前进1,坐标点x等于max.y
    // 假定direction=WEST且y=1,当forward被调用后，那么返回的结果等于max.x
    @Test
    public void givenDirectioinWAndYEquals1WhenForwardThenMaxX() {
        this.location.setDirection(Direction.WEST);
        this.location.getPoint().setX(1);
        this.location.forward(max, obstacles);
        assertEquals(this.location.getX(), max.getX());
    }

    // 在坐标点(y=50)向南前进后，y轴等于1
    // 假定drection=S 且y=max.y,当forward被调用后，那么返回的结果为1
    @Test
    public void givenDirectionSAndYEqualsMaxYWhenForwardThen1() {

        this.location.setDirection(Direction.SOUTH);
        this.location.getPoint().setY(this.max.getY());
        this.location.forward(this.max, this.obstacles);
        assertEquals(1, this.location.getY());
    }

    // 在坐标点(y=1) 向北前进后，坐标点Y 等max.y
    // 假定direction =NORTH且y=1，当forward被调用后，那么返回的记过等于max.y
    @Test
    public void givenDirectionNAndYEquals1WhenForwardThenMaxY() {
        this.location.setDirection(Direction.NORTH);
        this.location.getPoint().setY(1);
        this.location.forward(this.max, this.obstacles);
    }

    // 向东行驶，遇到障碍(冰山等)前进返回false
    // 假定设置障碍，当forward被调用，那么返回结果等于false
    @Test
    public void givenObstracleWhenForwardThenReturnFalse() {
        this.location.setDirection(Direction.EAST);
        obstacles.add(new Point(this.x + 1, y));
        assertFalse(this.location.forward(this.max, this.obstacles));
    }

    // 向东行驶,遇到障碍(冰山等)，后退返回false
    // 假定设置障碍，当backward被调用，那么返回结果返回false
    @Test
    public void givenObstracleWhenBackwardThenReturnFalse() {
        this.location.setDirection(Direction.EAST);
        obstacles.add(new Point(this.x - 1, y));
        assertFalse(location.backward(this.max, obstacles));
    }


    /*
    Decreases: 减少
    Increases: 增加
     */
}
