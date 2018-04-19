package service;

import model.Board;

public class BoardServiceImpl implements BoardService{
	
	public String drawBoard(Board board){
		StringBuilder boardStr = new StringBuilder();
		for(char[] row : board.getCells()){
			boardStr.append(drawRow(row));
		}
		return boardStr.toString();
	}

	public String drawRow(char[] row) {
		StringBuilder str = new StringBuilder();
		for(char cell : row){
			str.append("|").append(cell);
		}
		str.append("|\n");
		return str.toString();
	}	
	
	public Boolean isBoardFull(Board board){
		Boolean isFull = true;
		for(int i = 0;i<board.getSize();i++){
			for(int j =0;j<board.getSize();j++){
				if (board.getCells()[i][j] == '-') {
					 isFull = false;
				}
			}
		}
		return isFull;
		
	}
}
