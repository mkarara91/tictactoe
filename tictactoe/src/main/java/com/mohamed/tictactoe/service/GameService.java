package com.mohamed.tictactoe.service;

import com.mohamed.tictactoe.model.Board;
import com.mohamed.tictactoe.model.Game;
import com.mohamed.tictactoe.model.Player;

import java.util.List;
import java.util.Optional;


public interface GameService {

    Optional<Player> checkForWinner(Game game);

    Optional<Player> checkRowsForWinner(Board board, List<Player> players);

    Optional<Player> checkColumnsForWinner(Board board, List<Player> players);

    Optional<Player> checkDiagonalForWinner(Board board, List<Player> players);

    Optional<Player> findPlayerBySymbol(char symbol, List<Player> players);

    void changePlayerTurn(Game game);

    boolean checkInputsOutOfBounds(int row, int column, int boardSize);


}
