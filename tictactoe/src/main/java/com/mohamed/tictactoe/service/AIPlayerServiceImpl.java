package com.mohamed.tictactoe.service;

import com.mohamed.tictactoe.model.Board;

public class AIPlayerServiceImpl implements AIPlayerService {
    @Override
    public void placeAIMark(Board board, Character symbol) {
        Integer[][] possibleMovesMatrix = new Integer[board.getSize()][board.getSize()];
        Character[][] cells = board.getCells();
        for(int i = 0; i< board.getSize();i++){
            for(int j = 0;j<board.getSize();j++){

            }
        }
    }

//    public Character[] getColumn(Character[][] cells, int index){
//
//    }
//
//    public Character[] getDiagonal

    public Integer countScoreForArray(Character[] arr, Character symbol){
        int score = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == symbol){
                score += 10;
            }
        }
        return score;
    }

}
