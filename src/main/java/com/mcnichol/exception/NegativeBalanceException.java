package com.mcnichol.exception;

public class NegativeBalanceException extends Throwable {
    public NegativeBalanceException(String msg) {
        super(msg);
    }
}
