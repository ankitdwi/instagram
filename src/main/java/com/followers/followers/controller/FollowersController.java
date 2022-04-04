package com.followers.followers.controller;

import com.followers.followers.model.User;
import com.followers.followers.model.request.UpdateFollowers;
import com.followers.followers.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/insta")
public class FollowersController {

    // in the future, we can use strategy pattern to implement many implementations of FollowerService interface
    @Autowired
    private FollowerService followerService;


    @GetMapping("/followers/{id}")
    public List<User> getFollowers(@PathVariable Long id) {
        return followerService.getFollowerForUserId(id);
    }


    @PostMapping("/followers")
    public ResponseEntity<User> addFollowers(@RequestBody UpdateFollowers updateFollowers) {
        User user = followerService.addFollowers(updateFollowers.getFollowerIds(), updateFollowers.getUserId());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping("/followers")
    public ResponseEntity<User> removeFollowers(@RequestBody UpdateFollowers updateFollowers) {
        User user = followerService.removeFollowers(updateFollowers.getFollowerIds(), updateFollowers.getUserId());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
