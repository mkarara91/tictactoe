package com.mohamed.tictactoe.service;

import com.mohamed.tictactoe.model.Game;


public interface SetupService {
    Game setupGame();
    void chooseStartingPlayer(Game game);
}
