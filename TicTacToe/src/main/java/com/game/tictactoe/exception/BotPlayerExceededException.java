package com.game.tictactoe.exception;

public class BotPlayerExceededException extends RuntimeException {
    public BotPlayerExceededException() {
    }

    public BotPlayerExceededException(String message) {
        super(message);
    }

    public BotPlayerExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public BotPlayerExceededException(Throwable cause) {
        super(cause);
    }

    public BotPlayerExceededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
