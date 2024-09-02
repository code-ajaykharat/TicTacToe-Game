package com.game.tictactoe.service;

import com.game.tictactoe.model.BotDifficultyLevel;
import com.game.tictactoe.service.Impl.EasyBotPlayingLevel;

public class BotPlayingLevelFactory {
    public static BotPlayingLevel getBotPlayingLevel(BotDifficultyLevel level){
        if(level.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingLevel();
        }
        return null;
    }
}
