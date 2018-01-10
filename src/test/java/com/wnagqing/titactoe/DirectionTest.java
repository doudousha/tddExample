package com.wnagqing.titactoe;

import com.wangqing.ship.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectionTest {

    @Test
    public void whenGetFormShortNameNThenReturnDirectionN() {
        Direction direction = Direction.getFromShortName("N");
        assertEquals(Direction.NORTH, direction);
    }

    @Test
    public void whenGetFormShortNameWThenReturnDirectionW() {
        Direction direction = Direction.getFromShortName("W");
        assertEquals(Direction.WEST, direction);
    }

    @Test
    public void whenGetFormShortNameBThenReturnDirectionNone() {
        Direction direction = Direction.getFromShortName("B");
        assertEquals(Direction.NONE, direction);
    }

    @Test
    public void givenSWhenLeftThenE() {
        assertEquals(Direction.SOUTH.turnLeft(), Direction.EAST);
    }

    @Test
    public void givenNWhenLeftThenW() {
        assertEquals(Direction.NORTH.turnLeft(), Direction.WEST);
    }

    @Test
    public void givenSWhenRightThenW() {
        assertEquals(Direction.SOUTH.turnRight(), Direction.WEST);
    }

    @Test
    public void givenWWhenRightThenN() {
        assertEquals(Direction.WEST.turnRight(), Direction.NORTH);
    }
}
