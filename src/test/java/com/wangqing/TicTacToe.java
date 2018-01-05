package com.wangqing;

public class TicTacToe {

    private char lastPlayer = '\0';
    private char[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    private int size = 3;

    public String play(int y, int x) throws RuntimeException {
        if (x < 1 || x > this.size) {
            throw new RuntimeException("X is outside board");
        }
        if (y < 1 || y > this.size) {
            throw new RuntimeException("Y is outside board");
        }

        this.lastPlayer = nextPlayer();
        setBox(y, x, this.lastPlayer);
        if (isWin(y, x)) {
            return (this.lastPlayer == '0' ? "Y" : this.lastPlayer) + " is the winner";
        }

        return "No winner";
    }

    private boolean isWin(int y, int x) {

        int playerTotal = this.lastPlayer * this.size;
        // 水平线
        char horizontal, vertical;
        horizontal = vertical = '\0';
        for (int index = 0; index < this.size; index++) {
            horizontal += this.board[y - 1][index]; //  水平
            vertical += this.board[index][x - 1]; // 垂直
        }

        if (horizontal == playerTotal || vertical == playerTotal) {
            return true;
        }
        return false;
    }

    private void setBox(int y, int x, char lastPlayer) {
        if (this.board[y - 1][x - 1] != '\0') {
            throw new RuntimeException("Box is occupied");
        }
        board[y - 1][x - 1] = lastPlayer;
    }

    public char nextPlayer() {
        if (this.lastPlayer == 'X') {
            return '0';
        }
        return 'X';
    }

    private void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.board[i][0] + " " + this.board[i][1] + " " + this.board[i][2]);
        }
    }
}
