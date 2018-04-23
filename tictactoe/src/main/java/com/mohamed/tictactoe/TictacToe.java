package com.mohamed.tictactoe;

import com.mohamed.tictactoe.factory.AIDifficultyFactory;
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
        AIDifficultyFactory aiDifficultyFactory = new AIDifficultyFactory();
        AIPlayerService aiPlayerService = aiDifficultyFactory.getAIDiffuclty(game.getDifficulty());
        String boardString = boardService.drawBoard(game.getBoard());
        System.out.println(boardString);
        //game loop
        while (true) {
            if (game.getCurrentPlayer().getType().equals(PlayerType.AI)) {
                System.out.println("AI player's turn.");
                aiPlayerService.placeAIMark(game.getBoard(), game.getCurrentPlayer().getSymbol());
            }else{
                System.out.println(String.format("Player %s, please enter row column", game.getCurrentPlayer().getId()));
                int row = sc.nextInt();
                int column = sc.nextInt();
                boolean isOutOfBounds = gameService.checkInputsOutOfBounds(row, column, game.getBoard().getSize());
                if(isOutOfBounds){
                    System.out.println("Please input numbers within the board!!");
                    continue;
                }
                if (!boardService.placeMark(game.getBoard(), game.getCurrentPlayer().getSymbol(), row, column)) {
                    System.out.println("Cell already occupied.");
                    continue;
                }
            }

            boardString = boardService.drawBoard(game.getBoard());
            System.out.println(boardString);
            Optional<Player> playerOptional = gameService.checkForWinner(game);
            if (playerOptional.isPresent()) {
                System.out.println(String.format("Congrats Player %s wins", game.getCurrentPlayer().getId()));
                break;
            }
            if (boardService.isBoardFull(game.getBoard())) {
                System.out.println("DRAW");
                break;
            }
            gameService.changePlayerTurn(game);

        }


    }

}
