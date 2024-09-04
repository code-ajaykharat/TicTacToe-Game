package com.game.tictactoe.service.bot;

import com.game.tictactoe.model.BotDifficultyLevel;

public class BotPlayingLevelFactory {
    public static BotPlayingLevel getBotPlayingLevel(BotDifficultyLevel level) {
        if (level.equals(BotDifficultyLevel.EASY)) {
            return new EasyBotPlayingLevel();
        } else if (level.equals(BotDifficultyLevel.MEDIUM)) {
            return new MediumBotPlayingLevel();
        } else if (level.equals(BotDifficultyLevel.HARD)) {
            return new HardBotPlayingLevel();
        }
        return null;
    }
}
