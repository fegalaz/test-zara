package com.test.espana.zara.exceptions;

public class ClientConnectionErrorException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClientConnectionErrorException(String msg, Throwable t) {
        super(msg, t);
    }
}
