package tictactoe;

import com.mohamed.tictactoe.model.Board;
import com.mohamed.tictactoe.model.Game;
import com.mohamed.tictactoe.model.Player;
import com.mohamed.tictactoe.model.PlayerType;
import com.mohamed.tictactoe.service.GameService;
import com.mohamed.tictactoe.service.GameServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class GameServiceTest {
    private GameService gameService = new GameServiceImpl();
    List<Player> players;
    Player player1;
    Player player2;

    @Before
    public void setup() {
        players = new ArrayList<>();
        player1 = new Player(1, 'x', PlayerType.Human);
        player2 = new Player(2, 'o', PlayerType.Human);
        players.addAll(Arrays.asList(player1, player2));
    }

    @Test
    public void checkRowsForWinnerShouldReturnNoPlayerWhenBoardIsEMpty() {
        //given
        Board board = new Board(3);
        //when
        Optional<Player> winner = gameService.checkRowsForWinner(board, players);
        //verify
        Assert.assertTrue(!winner.isPresent());
    }

    @Test
    public void checkRowsForWinnerShouldReturnPlayer1() {
        //given
        Board board = new Board(3);
        Character[][] cells = board.getCells();
        cells[0][0] = player1.getSymbol();
        cells[0][1] = player1.getSymbol();
        cells[0][2] = player1.getSymbol();
        //when
        Optional<Player> winner = gameService.checkRowsForWinner(board, players);
        //verify
        Assert.assertTrue(winner.isPresent());
        Assert.assertEquals(player1.getSymbol(), winner.get().getSymbol());
    }

    @Test
    public void checkColumnssForWinnerShouldReturnNoPlayerWhenBoardIsEmpty() {
        //given
        Board board = new Board(3);
        //when
        Optional<Player> winner = gameService.checkColumnsForWinner(board, players);
        //verify
        Assert.assertTrue(!winner.isPresent());
    }

    @Test
    public void checkColumnsForWinnerShouldReturnPlayer1() {
        //given
        Board board = new Board(3);
        Character[][] cells = board.getCells();
        cells[0][0] = player1.getSymbol();
        cells[1][0] = player1.getSymbol();
        cells[2][0] = player1.getSymbol();
        //when
        Optional<Player> winner = gameService.checkColumnsForWinner(board, players);
        //verify
        Assert.assertTrue(winner.isPresent());
        Assert.assertEquals(player1.getSymbol(), winner.get().getSymbol());
    }

    @Test
    public void findPlayerBySymbolShouldSelectTheRightPlayer() {
        //when
        Optional<Player> found = gameService.findPlayerBySymbol('x', players);
        //verify
        Assert.assertEquals(found.get().getSymbol(), players.get(0).getSymbol());
    }

    @Test
    public void checkDiagonalForWinnerShouldReturnNoPlayerWhenBoardIsEmpty() {
        //given
        Board board = new Board(3);
        //when
        Optional<Player> winner = gameService.checkDiagonalForWinner(board, players);
        //verify
        Assert.assertTrue(!winner.isPresent());
    }

    @Test
    public void checkDiagonalForWinnerShouldReturnPlayer1WhenFirstDiagonal() {
        //given
        Board board = new Board(3);
        Character[][] cells = board.getCells();
        cells[0][0] = player1.getSymbol();
        cells[1][1] = player1.getSymbol();
        cells[2][2] = player1.getSymbol();
        //when
        Optional<Player> winner = gameService.checkDiagonalForWinner(board, players);
        //verify
        Assert.assertTrue(winner.isPresent());
        Assert.assertEquals(player1.getSymbol(), winner.get().getSymbol());
    }

    @Test
    public void checkDiagonalForWinnerShouldReturnPlayer1WhenSecondDiagonal() {
        //given
        Board board = new Board(3);
        Character[][] cells = board.getCells();
        cells[0][2] = player1.getSymbol();
        cells[1][1] = player1.getSymbol();
        cells[2][0] = player1.getSymbol();
        //when
        Optional<Player> winner = gameService.checkDiagonalForWinner(board, players);
        //verify
        Assert.assertTrue(winner.isPresent());
        Assert.assertEquals(player1.getSymbol(), winner.get().getSymbol());
    }

    @Test
    public void findPlayerBySymbolShouldReturnNullWhenNotFound() {
        //when
        Optional<Player> found = gameService.findPlayerBySymbol('l', players);
        //verify
        Assert.assertEquals(found.isPresent(), false);
    }

    @Test
    public void changeCurrnetPlayerShouldchangeToNextPlayer(){
        //given
        Board board = new Board(3);
        Game game = new Game(players,board);
        //when
        gameService.changePlayerTurn(game);
        //verify
        Assert.assertEquals(2, game.getCurrentPlayer().getId());
    }

    @Test
    public void changeCurrentPlayerShouldStartAgainFromFirstPlayer(){
        //given
        Board board = new Board(3);
        Game game = new Game(players,board);
        //when
        gameService.changePlayerTurn(game);
        gameService.changePlayerTurn(game);
        //verify
        Assert.assertEquals(1, game.getCurrentPlayer().getId());
    }
}
