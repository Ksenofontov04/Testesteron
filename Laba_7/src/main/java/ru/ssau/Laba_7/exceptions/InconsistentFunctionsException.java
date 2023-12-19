package ru.ssau.Laba_7.exceptions;

public class InconsistentFunctionsException extends RuntimeException{
    public InconsistentFunctionsException() {
        super();
    }

    public InconsistentFunctionsException(String message) {
        super(message);
    }
}
