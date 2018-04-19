package service;

import java.util.List;

import model.Board;
import model.Game;
import model.Player;

public interface GameService {
	Game setupGame(List<Player> players, int boardSize);
	Player checkForWinner(Game game);
	Player checkRowsForWinner(Board board);
	Player checkColumnsForWinner(Board board);
	Player checkDiagonalForWinner(Board board);
}
