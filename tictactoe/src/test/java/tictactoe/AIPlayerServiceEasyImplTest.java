package tictactoe;

import com.mohamed.tictactoe.model.Board;
import com.mohamed.tictactoe.service.AIPlayerService;
import com.mohamed.tictactoe.service.AIPlayerServiceEasyImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AIPlayerServiceEasyImplTest {
    AIPlayerService aiPlayerService = new AIPlayerServiceEasyImpl();

    @Test
    public void countScoreForArrayShouldReturn0ForEmptyArray()
    {
        //given
        Board board = new Board(3);
        Character symbol = 'x';
        //when
        Integer score = aiPlayerService.countScoreForArray(board.getCells()[0], symbol);
        //verify
        Assert.assertTrue(score == 0);

    }

    @Test
    public void countScoreForArrayShouldReturn10ForArrayWithOneSymbol()
    {
        //given
        Board board = new Board(3);
        Character symbol = 'x';
        board.getCells()[0][0] = 'x';
        //when
        Integer score = aiPlayerService.countScoreForArray(board.getCells()[0], symbol);
        //verify
        Assert.assertTrue(score == 10);
    }

    @Test
    public void countScoreForColumnShouldReturn0ForEmptyColumn()
    {
        //given
        Board board = new Board(3);
        Character symbol = 'x';
        //when
        Integer score = aiPlayerService.getColumnScore(board.getCells(), 0, symbol);
        //verify
        Assert.assertTrue(score == 0);

    }

    @Test
    public void countScoreForColumnShouldReturn10ForColumnWithOneSymbol()
    {
        //given
        Board board = new Board(3);
        Character symbol = 'x';
        board.getCells()[0][0] = 'x';
        //when
        Integer score = aiPlayerService.getColumnScore(board.getCells(),0, symbol);
        //verify
        Assert.assertTrue(score == 10);
    }

    @Test
    public void placeMarkInHighestScoreShouldPlaceMarkBottomRightWhenBoardIsEmpty()
    {
        //given
        Board board = new Board(3);
        Integer[][] possibleMoves = new Integer[3][3];
        Arrays.stream(possibleMoves).forEach(i -> Arrays.fill(i,0));
        Character symbol = 'x';
        //when
        aiPlayerService.placeMarkInHighestScoreCell(possibleMoves, board, symbol);
        //verify
        Assert.assertEquals(symbol, board.getCells()[2][2]);
    }

    @Test
    public void placeMarkInHighestScoreShouldPlaceMarkInColumnOrRowWithHighestScore(){
        //given
        Board board = new Board(3);
        Integer[][] possibleMoves = new Integer[][]{
            { 10, 0, -100},
            { 0, 20, 0},
            { -100, 0, -100}
        };

        Character symbol = 'x';
        //when
        aiPlayerService.placeMarkInHighestScoreCell(possibleMoves, board, symbol);
        //verify
        Assert.assertEquals(symbol, board.getCells()[1][1]);
    }

    @Test
    public void getCellScoreShouldReturnNegative100IfCellOccupied(){
        //given
        Board board = new Board(3);
        Character symbol = 'x';
        board.getCells()[0][0] = 'x';
        //when
        int result = aiPlayerService.getCellScore(board.getCells(),0,0,symbol);
        //verify
        Assert.assertEquals(-100, result);
    }

    @Test
    public void PlaceAIMarkshouldPlaceMarkBottomRightOnEmptyBoard(){
        //given
        Board board = new Board(3);
        Character symbol = 'x';
        //when
        aiPlayerService.placeAIMark(board,symbol);
        //verify
        Assert.assertEquals(symbol, board.getCells()[2][2]);
    }



}
