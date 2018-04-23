package com.mohamed.tictactoe.factory;

import com.mohamed.tictactoe.model.Difficulty;
import com.mohamed.tictactoe.service.AIPlayerService;
import com.mohamed.tictactoe.service.AIPlayerServiceEasyImpl;

public class AIDifficultyFactory {

    public AIPlayerService getAIDiffuclty(Difficulty difficulty){
        switch (difficulty){
            case Easy:
                return new AIPlayerServiceEasyImpl();
            case Medium:
                //todo
                return null;
            case Hard:
                //todo
                return null;
        }
        return null;
    }
}
