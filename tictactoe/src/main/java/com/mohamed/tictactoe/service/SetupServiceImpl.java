package com.mohamed.tictactoe.service;

import com.mohamed.tictactoe.model.*;

import java.util.*;

public class SetupServiceImpl implements SetupService {
    @Override
    public Game setupGame() {
        ResourceBundle rb = ResourceBundle.getBundle("application");

        Difficulty difficulty =  Difficulty.valueOf(rb.getString("difficulty"));

        int size = Integer.parseInt(rb.getString("board-size"));
        if(size < 3){
            size = 3;
        }
        if(size > 10){
            size =10;
        }
        Board board = new Board(size);
        List<Player> players = getPlayers(rb);
        Game game = new Game(players, board, difficulty);
        chooseStartingPlayer(game);
        return game;
    }

    @Override
    public void chooseStartingPlayer(Game game) {
        Random r = new Random();
        int playerNum = r.ints(0, 3).findFirst().getAsInt();
        game.setCurrentPlayer(game.getPlayers().get(playerNum));
    }

    private List<Player> getPlayers(ResourceBundle rb){
        char player1Symbol = rb.getString("player1-symbol").charAt(0);
        Player player1 = new Player(1, player1Symbol, PlayerType.Human);

        char player2Symbol = rb.getString("player2-symbol").charAt(0);
        Player player2 = new Player(2, player2Symbol, PlayerType.Human);

        char playerAISymbol = rb.getString("ai-player-symbol").charAt(0);
        Player playerAI = new Player(3, playerAISymbol, PlayerType.AI);
        return new ArrayList<>(Arrays.asList(player1, player2, playerAI));
    }


}
