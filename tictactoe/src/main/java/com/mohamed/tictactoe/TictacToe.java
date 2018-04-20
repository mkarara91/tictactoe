package com.mohamed.tictactoe;

import com.mohamed.tictactoe.model.Board;
import com.mohamed.tictactoe.model.Game;
import com.mohamed.tictactoe.model.Player;
import com.mohamed.tictactoe.model.PlayerType;
import com.mohamed.tictactoe.service.BoardService;
import com.mohamed.tictactoe.service.BoardServiceImpl;
import com.mohamed.tictactoe.service.GameService;
import com.mohamed.tictactoe.service.GameServiceImpl;

import java.util.*;


public class TictacToe {

    public static void main(String[] args) {
        BoardService boardService = new BoardServiceImpl();
        GameService gameService = new GameServiceImpl();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe");
        System.out.println("please enter symbol for player 1:");
        char player1Symbol = sc.next().charAt(0);
        Player player1 = new Player(1, player1Symbol, PlayerType.Human);
        System.out.println("please enter symbol for player 2:");
        char player2Symbol = sc.next().charAt(0);
        Player player2 = new Player(2, player2Symbol, PlayerType.Human);
        System.out.println("Please enter size of board:");
        int size = sc.nextInt();
        Board board = new Board(size);
        List<Player> players = new ArrayList<>(Arrays.asList(player1, player2));

        Game game = new Game(players,board);
        String boardString = boardService.drawBoard(game.getBoard());
        System.out.println(boardString);
        //game loop
        while(true){
            System.out.println(String.format("Player %s, please enter row column", game.getCurrentPlayer().getId()));
            int row = sc.nextInt();
            int column = sc.nextInt();
            if(!boardService.placeMark(game.getBoard(), game.getCurrentPlayer().getSymbol(),row, column)){
                System.out.println("Cell already occupied.");
                continue;
            }
            boardString = boardService.drawBoard(game.getBoard());
            System.out.println(boardString);
            Optional<Player> playerOptional = gameService.checkForWinner(game);
            if(playerOptional.isPresent()){
                System.out.println(String.format("Congrats Player %s wins", game.getCurrentPlayer().getId()));
                break;
            }
            if(boardService.isBoardFull(game.getBoard())){
                System.out.println("DRAW");
                break;
            }
            gameService.changePlayerTurn(game);

        }


    }

}
