package com.followers.followers.exceptions;

public class FollowersNotFound extends RuntimeException{
    public FollowersNotFound(Long id) {
        super("Could not find followers for user " + id);
    }
}
