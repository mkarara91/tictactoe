package com.mohamed.tictactoe.service;

import com.mohamed.tictactoe.model.Board;
import com.mohamed.tictactoe.model.Game;
import com.mohamed.tictactoe.model.Player;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class GameServiceImpl implements GameService {

    public Optional<Player> checkForWinner(Game game) {
        Optional<Player> winner = checkRowsForWinner(game.getBoard(),game.getPlayers());
        if(winner.isPresent()){
            return winner;
        }
        winner = checkColumnsForWinner(game.getBoard(),game.getPlayers());
        if(winner.isPresent()){
            return winner;
        }
        return checkDiagonalForWinner(game.getBoard(), game.getPlayers());
    }

    public Optional<Player> checkRowsForWinner(Board board, List<Player> players) {
        Character[][] cells = board.getCells();
        for (Character[] row : cells) {
            if (arrayContainsWinner(row)) {
                return findPlayerBySymbol(row[0], players);
            }
        }
        return Optional.empty();
    }

    private boolean arrayContainsWinner(Character[] row) {
        return Arrays.stream(row).distinct().count() == 1 && row[0] != '-';
    }

    public Optional<Player> checkColumnsForWinner(Board board, List<Player> players) {
        Character[][] cells = board.getCells();
        for (int i = 0; i < board.getSize(); i++) {
            if (searchColumn(cells, i)) {
                return findPlayerBySymbol(cells[i][0], players);
            }
        }
        return Optional.empty();
    }

    private boolean searchColumn(Character[][] cells, int index) {
        Character[] column = new Character[cells[0].length];
        for (int i = 0; i < column.length; i++) {
            column[i] = cells[i][index];
        }
        return arrayContainsWinner(column);
    }

    public Optional<Player> checkDiagonalForWinner(Board board, List<Player> players) {
        if (compareFirstDiagonal(board)) {
            return findPlayerBySymbol(board.getCells()[0][0], players);
        }
        if (compareSecondDiagonal(board)) {
            return findPlayerBySymbol(board.getCells()[0][board.getSize() - 1], players);
        }
        return Optional.empty();
    }

    private boolean compareFirstDiagonal(Board board) {
        Character[][] cells = board.getCells();
        Character compare = cells[0][0];
        int i = 1;
        while (compare != '-' && i < board.getSize()) {
            if (compare != cells[i][i]) {
                return false;
            }
            i++;
        }
        return compare != '-' && i == board.getSize();
    }

    private boolean compareSecondDiagonal(Board board) {
        Character[][] cells = board.getCells();
        int boardSizeZeroIndex = board.getSize() - 1;
        Character compare = cells[0][boardSizeZeroIndex];
        int i = 1;
        while (compare != '-' && i < board.getSize()) {
            if (compare != cells[i][boardSizeZeroIndex - i]) {
                return false;
            }
            i++;
        }
        return compare != '-' && i == board.getSize();
    }

    public Optional<Player> findPlayerBySymbol(final char symbol, List<Player> players) {
        return players.stream().filter(p -> p.getSymbol() == symbol).findFirst();
    }

    @Override
    public void changePlayerTurn(Game game) {
        int numberOfPlayers = game.getPlayers().size();
        int currentPlayerNum = (game.getCurrentPlayer().getId() + 1);
        if(currentPlayerNum > numberOfPlayers){
            currentPlayerNum = 1;
        }
        game.setCurrentPlayer(game.getPlayers().get(currentPlayerNum-1));
    }

    @Override
    public boolean checkInputsOutOfBounds(int row, int column, int boardSize) {
        return row > boardSize || row < 0 || column > boardSize || column < 0;
    }

}
