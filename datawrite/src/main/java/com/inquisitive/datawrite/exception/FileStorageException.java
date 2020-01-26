package com.inquisitive.datawrite.exception;

/**
 * Created by ankitmishra on 27/01/20.
 */
public class FileStorageException extends RuntimeException {
    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
