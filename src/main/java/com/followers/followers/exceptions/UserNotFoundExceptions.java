package com.followers.followers.exceptions;

public class UserNotFoundExceptions extends RuntimeException{
    public UserNotFoundExceptions(Long id) {
        super("Could not find user " + id);
    }
}
