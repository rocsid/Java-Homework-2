package ru.aston.hometask2.exception;

public class DataReadException extends RuntimeException {
    public DataReadException(final String message, final Throwable cause) {
        super(message, cause);
    }
}