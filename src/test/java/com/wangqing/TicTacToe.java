package com.wangqing;

public class TicTacToe {

    private char lastPlayer = '\0';
    private char[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};

    public String play(int x, int y) throws RuntimeException {
        if (x < 1 || x > 3) {
            throw new RuntimeException("X is outside board");
        }
        if (y < 1 || y > 3) {
            throw new RuntimeException("Y is outside board");
        }

        this.lastPlayer = nextPlayer();
        setBox(x, y, this.lastPlayer);
        if (isWin()) return lastPlayer + " is the winner";

        return "No winner";
    }

    private boolean isWin() {

        for (int index = 0; index < 3; index++) {
            if (this.board[0][index] == this.lastPlayer &&
                    this.board[1][index] == this.lastPlayer &&
                    this.board[2][index] == this.lastPlayer) {
                return true;
            } else if (this.board[index][0] == this.lastPlayer &&
                    this.board[index][1] == this.lastPlayer &&
                    this.board[index][2] == this.lastPlayer) {
                return true;
            }
        }
        return false;
    }

    private void setBox(int x, int y, char lastPlayer) {
        if (this.board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        }
        board[x - 1][y - 1] = lastPlayer;
    }

    public char nextPlayer() {
        if (lastPlayer == 'X') {
            return '\0';
        }
        return 'X';
    }
}
