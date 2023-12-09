package com.tawfeek.bookstore_admin.exception;

public class ConflictException extends RuntimeException {
    public ConflictException(){
        super();
    }
    public ConflictException(String message) {
        super(message);

    }
}
