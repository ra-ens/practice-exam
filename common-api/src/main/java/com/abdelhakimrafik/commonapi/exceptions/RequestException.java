package com.abdelhakimrafik.commonapi.exceptions;

public abstract class RequestException extends RuntimeException {
    public RequestException(String message) {
        super(message);
    }
}
