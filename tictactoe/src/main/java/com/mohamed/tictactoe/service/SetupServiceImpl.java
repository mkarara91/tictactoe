package com.mohamed.tictactoe.service;

import com.mohamed.tictactoe.model.*;

import java.util.*;

public class SetupServiceImpl implements SetupService {

    private static final String SETTINGS_FILE = "application";
    private static final String DIFFICULTY = "difficulty";
    private static final String BOARD_SIZE = "board-size";
    private static final String PLAYER1_SYMBOL = "player1-symbol";
    private static final String PLAYER2_SYMBOL = "player2-symbol";
    private static final String AI_PLAYER_SYMBOL = "ai-player-symbol";

    @Override
    public Game setupGame() {
        ResourceBundle rb = ResourceBundle.getBundle(SETTINGS_FILE);
        Difficulty difficulty =  Difficulty.valueOf(rb.getString(DIFFICULTY));
        Board board = setupBoardSize(Integer.parseInt(rb.getString(BOARD_SIZE)));
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
        char player1Symbol = rb.getString(PLAYER1_SYMBOL).charAt(0);
        Player player1 = new Player(1, player1Symbol, PlayerType.Human);

        char player2Symbol = rb.getString(PLAYER2_SYMBOL).charAt(0);
        Player player2 = new Player(2, player2Symbol, PlayerType.Human);

        char playerAISymbol = rb.getString(AI_PLAYER_SYMBOL).charAt(0);
        Player playerAI = new Player(3, playerAISymbol, PlayerType.AI);
        return new ArrayList<>(Arrays.asList(player1, player2, playerAI));
    }

    private Board setupBoardSize(int size){
        if(size < 3){
            System.out.println("Board size changed to 3 please set the board size accordingly");
            size = 3;
        }
        if(size > 10){
            System.out.println("Board size changed to 10 please set the board size accordingly");
            size =10;
        }
        return new Board(size);
    }


}
