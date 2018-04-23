package com.mohamed.tictactoe.service;

import com.mohamed.tictactoe.model.Board;

public class AIPlayerServiceEasyImpl implements AIPlayerService {
    @Override
    public void placeAIMark(Board board, Character symbol) {
        Integer[][] possibleMovesMatrix = new Integer[board.getSize()][board.getSize()];
        Character[][] cells = board.getCells();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (cells[i][j] != '-') {
                    possibleMovesMatrix[i][j] = -100;
                    continue;
                }
                int rowScore = countScoreForArray(cells[i], symbol);
                int columnScore = getColumnScore(cells, j, symbol);
                possibleMovesMatrix[i][j] = rowScore + columnScore;
            }
        }
        placeMarkInHighestScoreCell(possibleMovesMatrix, board, symbol);
    }

    @Override
    public void placeMarkInHighestScoreCell(Integer[][] possibleMovesMatrix, Board board, Character symbol) {
        int row = 0, column = 0;
        int maxScore = possibleMovesMatrix[0][0];
        Character[][] cells = board.getCells();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if(maxScore <= possibleMovesMatrix[i][j]){
                    row = i;
                    column = j;
                    maxScore = possibleMovesMatrix[i][j];
                }
            }
        }
        cells[row][column] = symbol;
    }

    @Override
    public Integer getColumnScore(Character[][] cells, int index, Character symbol) {
        Character[] column = new Character[cells[0].length];
        for (int i = 0; i < column.length; i++) {
            column[i] = cells[i][index];
        }
        return countScoreForArray(column, symbol);
    }

    @Override
    public Integer countScoreForArray(Character[] arr, Character symbol) {
        int score = 0;
        for (Character c : arr) {
            if (c == symbol) {
                score += 10;
            }
        }
        return score;
    }

}
