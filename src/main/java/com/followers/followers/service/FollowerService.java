package com.followers.followers.service;

import com.followers.followers.exceptions.UserNotFoundExceptions;
import com.followers.followers.respository.UserRepository;
import com.followers.followers.model.User;
import com.followers.followers.exceptions.FollowersNotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FollowerService {
    private static final Logger log = LoggerFactory.getLogger(FollowerService.class);
    @Autowired
    private UserRepository repository;

    /**
     * TODO: Add exceptions for failed addition
     * @param followerIds
     * @param userId
     * @return
     * @throws UserNotFoundExceptions
     */
    public User addFollowers(Set<Long> followerIds, Long userId) throws UserNotFoundExceptions {
        User user = getUserById(userId);
        return repository.addFollower(followerIds, user);
    }

    /**
     * TODO: Add exceptions for failed removal
     * @param followerIds
     * @param userId
     * @return
     * @throws UserNotFoundExceptions
     */
    public User removeFollowers(Set<Long> followerIds, Long userId) throws UserNotFoundExceptions {
        User user = getUserById(userId);
        return repository.removeFollower(followerIds, user);
    }

    /**
     * @param id
     * @return list of followers
     * @throws FollowersNotFound
     */
    public List<User> getFollowerForUserId(Long id) throws UserNotFoundExceptions, FollowersNotFound {
        User user = getUserById(id);
        return getFollowerForUser(user);
    }

    /**
     * @param user
     * @return list of followers
     * @throws FollowersNotFound
     */
    public List<User> getFollowerForUser(User user) throws FollowersNotFound {
        log.info("Calling user repository for followers of user : {}", user);
        return repository.findFollowersByUser(user)
                .orElseThrow(() -> new FollowersNotFound(user.getId()));
    }


    /**
     * @param userId
     * @return User
     * @throws UserNotFoundExceptions
     */
    public User getUserById(Long userId) throws UserNotFoundExceptions {
        log.info("Calling user repository for user : {}", userId);
        return repository.findById(userId)
                .orElseThrow(() -> new UserNotFoundExceptions(userId));
    }
}
