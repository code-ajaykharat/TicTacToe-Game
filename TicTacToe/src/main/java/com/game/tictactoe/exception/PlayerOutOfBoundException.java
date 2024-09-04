package com.game.tictactoe.exception;

public class PlayerOutOfBoundException extends RuntimeException {
    public PlayerOutOfBoundException() {
    }

    public PlayerOutOfBoundException(String message) {
        super(message);
    }

    public PlayerOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlayerOutOfBoundException(Throwable cause) {
        super(cause);
    }

    public PlayerOutOfBoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
