package com.mohamed.tictactoe.service;

import com.mohamed.tictactoe.model.Board;

public interface BoardService {

    boolean placeMark(Board board, Character symbol, int row, int column);

    String drawBoard(Board board);

    String drawRow(Character[] row);

    Boolean isBoardFull(Board board);
}
