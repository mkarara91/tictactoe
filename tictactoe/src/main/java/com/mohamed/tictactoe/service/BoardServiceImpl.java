package com.mohamed.tictactoe.service;


import com.mohamed.tictactoe.model.Board;

public class BoardServiceImpl implements BoardService {

    @Override
    public boolean placeMark(Board board, Character symbol, int row, int column) {
        Character[][] cells = board.getCells();
        if(cells[row][column] != '-'){
            return false;
        }
        cells[row][column] = symbol;
        return true;
    }

    public String drawBoard(Board board) {
        StringBuilder boardStr = new StringBuilder();
        for (Character[] row : board.getCells()) {
            boardStr.append(drawRow(row));
        }
        return boardStr.toString();
    }

    public String drawRow(Character[] row) {
        StringBuilder str = new StringBuilder();
        for (char cell : row) {
            str.append("|").append(cell);
        }
        str.append("|\n");
        return str.toString();
    }

    public Boolean isBoardFull(Board board) {
        Boolean isFull = true;
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCells()[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        return isFull;

    }
}
