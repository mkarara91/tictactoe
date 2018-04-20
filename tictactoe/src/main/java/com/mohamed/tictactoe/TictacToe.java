package com.mohamed.tictactoe;

import com.mohamed.tictactoe.model.Board;
import com.mohamed.tictactoe.model.Game;
import com.mohamed.tictactoe.model.Player;
import com.mohamed.tictactoe.model.PlayerType;
import com.mohamed.tictactoe.service.*;

import javax.swing.text.html.Option;
import java.util.*;


public class TictacToe {

    public static void main(String[] args) {
        BoardService boardService = new BoardServiceImpl();
        GameService gameService = new GameServiceImpl();
        SetupService setupService = new SetupServiceImpl();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe");

        Game game = setupService.setupGame();

        String boardString = boardService.drawBoard(game.getBoard());
        System.out.println(boardString);
        //todo random starting player
        //todo handle out of bounds input
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
