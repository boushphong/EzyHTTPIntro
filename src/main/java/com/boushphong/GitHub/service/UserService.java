package com.boushphong.GitHub.service;

import com.boushphong.GitHub.entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
    protected final Map<String, User> users = new ConcurrentHashMap<>();

    public User addUser(User user) {
        return users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
