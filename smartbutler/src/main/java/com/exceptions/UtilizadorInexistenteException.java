package com.exceptions;

public class UtilizadorInexistenteException extends RuntimeException {
    public UtilizadorInexistenteException(String msg) {
        super(msg);
    }
}
