package com.wangqing;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class TicTacToeSpec {

    private TicTacToe ticTacToe;
    private int size;

    @Before
    public final void before() {
        this.ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        // Arrange 配置
        int y = 2;
        int x5 = 5;
        int x0 = 0;
        // Act 操作
        Throwable thrownx5 = catchThrowable(() -> this.ticTacToe.play(x5, y));
        Throwable thrownx0 = catchThrowable(() -> this.ticTacToe.play(x0, y));
        // Assert 断言
        assertThat(thrownx5).isInstanceOf(RuntimeException.class).hasMessageContaining("X is outside board");
        assertThat(thrownx0).isInstanceOf(RuntimeException.class).hasMessageContaining("X is outside board");
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        // Arrange 配置
        int x = 2;
        int y5 = 5;
        int y0 = 0;
        // Act 操控
        Throwable throwy5 = catchThrowable(() -> this.ticTacToe.play(x, y5));
        Throwable throwy0 = catchThrowable(() -> this.ticTacToe.play(x, y0));
        // Assert 断言
        assertThat(throwy5).isInstanceOf(RuntimeException.class).hasMessageContaining("Y is outside board");
        assertThat(throwy0).isInstanceOf(RuntimeException.class).hasMessageContaining("Y is outside board");
    }

    @Test
    public void givenFirstTurnWhenNextPalyerThenX() {
        assertEquals("X", this.ticTacToe.nextPlayer());

    }

    @Test
    public void givenLastTurnWhenNextPlayerThenO() {
        ticTacToe.play(1, 1);
        assertEquals("O", this.ticTacToe.nextPlayer());
    }


    @Test
    public void whenOccupiedThenRuntimeException() {
        // Act 操控
        this.ticTacToe.play(2, 1);
        Throwable thrown = catchThrowable(() -> this.ticTacToe.play(2, 1));
        // 断言
        assertThat(thrown).isInstanceOf(RuntimeException.class).hasMessageContaining("Box is occupied");
    }

    @Test
    public void whenPlayThenNoWinner() {
        String actual = this.ticTacToe.play(1, 1);
        assertEquals("No winner", actual);
    }

    /**
     * 检查水平线
     * XXX
     * OO
     */
    @Test
    public void whenPalyAndWholeHorizontalLineThenWinner() {

        System.out.println("1: " + ('X' + 'X' + 'X'));
        this.ticTacToe.play(1, 1); //x
        this.ticTacToe.play(2, 1);//y
        this.ticTacToe.play(1, 2);//x
        this.ticTacToe.play(2, 2);// y
        String actual = this.ticTacToe.play(1, 3); // x
        assertEquals("X is the winner", actual);

    }

    /**
     * 检查垂直线
     * OXX
     * OX
     * O
     */
    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        System.out.println(('0'+'0'+'0' ));
        this.ticTacToe.play(1, 2);// X
        this.ticTacToe.play(1, 1); // O
        this.ticTacToe.play(1, 3); // X
        this.ticTacToe.play(2, 1);// O
        this.ticTacToe.play(2, 2); // X
        String actual = this.ticTacToe.play(3, 1);
        assertEquals("Y is the winner", actual);


    }

    /* 英语翻译
        first turn : 第一回合
        actual: 真实的

    */

}
