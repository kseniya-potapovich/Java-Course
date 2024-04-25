package com.boot.springboot.exceptions;

public class SameUserInDatabase extends RuntimeException{
    String message;

    public SameUserInDatabase(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Problem with registration! We already have user with login: " + message;
    }
}
