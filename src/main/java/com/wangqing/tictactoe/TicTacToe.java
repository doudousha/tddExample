package com.wangqing.tictactoe;

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
        if(this.isDraw()){
            return "The result is draw";
        }

        return "No winner";
    }

    private boolean isWin(int y, int x) {

        int playerTotal = this.lastPlayer * this.size;
        // 水平线
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for (int index = 0; index < this.size; index++) {
            horizontal += this.board[y - 1][index]; //  水平
            vertical += this.board[index][x - 1]; // 垂直
            diagonal1 += this.board[index][index]; // 对角线1
            diagonal2 += this.board[index][this.size - index - 1];  // 对角线2
        }

        if (horizontal == playerTotal || vertical == playerTotal || diagonal1 == playerTotal || diagonal2 == playerTotal) {
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

    // 判断棋盘是否填满
    private boolean isDraw() {
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                if (this.board[y][x] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    public void reset() {
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                this.board[y][x] = '\0';
            }
        }
    }

    private void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.board[i][0] + " " + this.board[i][1] + " " + this.board[i][2]);
        }
    }
}
