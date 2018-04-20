package com.mohamed.tictactoe.service;

import com.mohamed.tictactoe.model.Board;
import com.mohamed.tictactoe.model.Game;
import com.mohamed.tictactoe.model.Player;
import com.mohamed.tictactoe.model.PlayerType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SetupServiceImpl implements SetupService {
    @Override
    public Game setupGame() {
        ResourceBundle rb = ResourceBundle.getBundle("application");


        char player1Symbol = rb.getString("player1-symbol").charAt(0);
        Player player1 = new Player(1, player1Symbol, PlayerType.Human);

        char player2Symbol = rb.getString("player2-symbol").charAt(0);
        Player player2 = new Player(2, player2Symbol, PlayerType.Human);

        char playerAISymbol = rb.getString("ai-player-symbol").charAt(0);
        Player playerAI = new Player(3, playerAISymbol, PlayerType.AI);
        //todo limit board from 3-10

        int size = Integer.parseInt(rb.getString("board-size"));
        Board board = new Board(size);
        List<Player> players = new ArrayList<>(Arrays.asList(player1, player2, playerAI));
        Game game = new Game(players, board);
        return game;
    }
}
