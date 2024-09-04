package com.game.tictactoe.exception;

public class BoardOutOfBoundException extends RuntimeException {
    public BoardOutOfBoundException() {
    }

    public BoardOutOfBoundException(String message) {
        super(message);
    }

    public BoardOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardOutOfBoundException(Throwable cause) {
        super(cause);
    }

    public BoardOutOfBoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
