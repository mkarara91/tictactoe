package com.mohamed.tictactoe.service;

import com.mohamed.tictactoe.model.Board;

public interface AIPlayerService {
    void placeAIMark(Board board, Character symbol);
    void placeMarkInHighestScoreCell(Integer[][] possibleMovesMatrix, Board board, Character symbol);
    Integer getColumnScore(Character[][] cells, int index, Character symbol);
    Integer countScoreForArray(Character[] arr, Character symbol);
}
