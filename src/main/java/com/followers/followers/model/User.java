package com.followers.followers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class User {
    private Long id;
    private String name;

    @JsonIgnore
    private Set<Long> followersList;

    public User(Long id, String name, Set<Long> followersList) {
        this.id = id;
        this.name = name;
        this.followersList = followersList;
    }

    public void addFollowers(Set<Long> followersList) {
        this.followersList.addAll(followersList);
    }

    public void deleteFollowers(Set<Long> followersList) {
        this.followersList.removeAll(followersList);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Long> getFollowersList() {
        return followersList;
    }

    public void setFollowersList(Set<Long> followersList) {
        this.followersList = followersList;
    }
}
