package com.followers.followers.respository;

import com.followers.followers.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private static final Logger log = LoggerFactory.getLogger(UserRepository.class);
    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        userList.add(new User(1L, "John", new HashSet<>(Arrays.asList(2L, 3L, 4L))));
        userList.add(new User(2L, "Dow", null));
        userList.add(new User(3L, "Harry", new HashSet<>()));
        userList.add(new User(4L, "Sally", new HashSet<>()));
    }

    public Optional<User> findById(Long id) {
        log.info("Getting user info by id: {}", id);
        User user = userList.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
        log.info("Retried user : {}", user);
        return Optional.of(user);
    }


    public Optional<List<User>> findFollowersByUser(User user) {
        log.info("Retrieving followers list for user : {}", user.getId());
        List<User> followers = userList.stream().filter(u -> user.getFollowersList().contains(u.getId())).collect(Collectors.toList());
        log.info("Found {} followers for user id : {}", followers.size(), user.getId());
        return Optional.of(followers);
    }


    public User addFollower(Set<Long> ids, User user) {
        log.info("adding followers: {} for user : {}", ids, user.getId());
        user.addFollowers(ids);
        return user;
    }

    public User removeFollower(Set<Long> ids, User user) {
        log.info("removing followers: {} for user : {}", ids, user.getId());
        user.deleteFollowers(ids);
        return user;
    }
}
