package com.game.tictactoe.model;

import com.game.tictactoe.service.BotPlayingLevel;
import com.game.tictactoe.service.BotPlayingLevelFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingLevel botPlayingLevel;

    public Bot(int id, BotDifficultyLevel botDifficultyLevel) {
        super(id, "G.ONE", PlayerType.BOT, 'G');
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingLevel = BotPlayingLevelFactory.getBotPlayingLevel(botDifficultyLevel);
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayingLevel getBotPlayingLevel() {
        return botPlayingLevel;
    }

    public void setBotPlayingLevel(BotPlayingLevel botPlayingLevel) {
        this.botPlayingLevel = botPlayingLevel;
    }

    public Move makeMove(Board board){
        return this.botPlayingLevel.makeMove(board, this);
    }
}
