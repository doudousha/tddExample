package com.wangqing.ship;

public enum Direction {

    NORTH(0, "N"), // 北
    EAST(1, "E"),  // 东
    SOUTH(2, "S"), // 南
    WEST(3, "W"), // 西
    NONE(4, "X");

    private final int value;
    private final String shortName;

    private Direction(int value, String shortNameValue) {
        this.value = value;
        this.shortName = shortNameValue;
    }

    public static Direction getFromShortName(final String shortName) {
        for (Direction direction : Direction.values()) {
            if (direction.shortName.equals(shortName)) {
                return direction;
            }
        }
        return Direction.NONE;
    }

    public Direction turnLeft() {
        int index = (this.value + 3) % 4;
        return Direction.values()[index];
    }

    public Direction turnRight() {
        int index = (this.value + 1) % 4;
        return Direction.values()[index];
    }
}
