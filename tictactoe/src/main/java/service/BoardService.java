package service;

import model.Board;

public interface BoardService {
	String drawBoard(Board board);
	String drawRow(char[] row);
	Boolean isBoardFull(Board board);
}
