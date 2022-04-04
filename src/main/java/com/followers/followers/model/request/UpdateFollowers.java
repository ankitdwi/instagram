package com.followers.followers.model.request;

import java.util.Set;

public class UpdateFollowers {
    private Long userId;
    private Set<Long> followerIds;

    public UpdateFollowers(Long userId, Set<Long> followerIds) {
        this.userId = userId;
        this.followerIds = followerIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Long> getFollowerIds() {
        return followerIds;
    }

    public void setFollowerIds(Set<Long> followerIds) {
        this.followerIds = followerIds;
    }
}
