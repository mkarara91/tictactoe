package tictactoe;

import org.junit.Assert;
import org.junit.Test;

import model.Board;
import service.BoardService;
import service.BoardServiceImpl;


public class BoardSerivceTest {
	
	BoardService boardService = new BoardServiceImpl();
	
	@Test
	public void drawBoardShouldDrawEmptyBoardWithNewBoard(){
		//given
		Board board = new Board(3);
		//when
		String strBoard = boardService.drawBoard(board);
		String expected = "|-|-|-|\n"+
						  "|-|-|-|\n"+
						  "|-|-|-|\n";
		//verify
		Assert.assertEquals(expected, strBoard);
		
	}
	@Test
	public void drawRowShouldReturnStringWithRow(){
		//given
		Board board = new Board(5);
		//when
		String row = boardService.drawRow(board.getCells()[0]);
		String expected = "|-|-|-|-|-|\n";
		//verify
		Assert.assertEquals(expected, row);
	}
	
	@Test
	public void isBoardFullShouldReturnFalseWhenBoardIsEmpty(){
		//given
		Board board = new Board(5);
		//when
		Boolean isFull = boardService.isBoardFull(board);
		//verify
		Assert.assertEquals(false, isFull);
	}
}
