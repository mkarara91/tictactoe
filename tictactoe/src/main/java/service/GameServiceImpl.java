package service;

import java.util.List;

import model.Board;
import model.Game;
import model.Player;

public class GameServiceImpl implements GameService{

	public Game setupGame(List<Player> players, int boardSize) {
		Board board = new Board(boardSize);
		return new Game(players, board);
	}

	public Player checkForWinner(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	public Player checkRowsForWinner(Board board) {
		
		return null;
	}

	public Player checkColumnsForWinner(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

	public Player checkDiagonalForWinner(Board board) {
		// TODO Auto-generated method stub
		return null;
	}

}
