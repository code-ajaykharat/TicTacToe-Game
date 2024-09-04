package com.game.tictactoe.exception;

public class SameSymbolException extends RuntimeException {
    public SameSymbolException() {
    }

    public SameSymbolException(String message) {
        super(message);
    }

    public SameSymbolException(String message, Throwable cause) {
        super(message, cause);
    }

    public SameSymbolException(Throwable cause) {
        super(cause);
    }

    public SameSymbolException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
