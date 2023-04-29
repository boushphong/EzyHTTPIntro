package com.boushphong.GitHub.controller;

import com.boushphong.GitHub.entity.User;
import com.boushphong.GitHub.service.UserService;
import com.tvd12.ezyhttp.core.exception.HttpConflictException;
import com.tvd12.ezyhttp.core.exception.HttpNotFoundException;
import com.tvd12.ezyhttp.core.response.ResponseEntity;
import com.tvd12.ezyhttp.server.core.annotation.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller("/api/v1/users")
public class UserController {
    private final UserService userService;

    @DoPost("/add")
    public ResponseEntity addUser(@RequestBody User user) {
        User existed = userService.addUser(user);
        if(existed == null)
            return ResponseEntity.ok(Boolean.TRUE);
        throw new HttpConflictException("user: " + user.getUsername() + " existed");
    }

    @DoGet("/{username}")
    public User getUser(@PathVariable("username") String username) {
        User user = userService.getUser(username);
        if(user != null)
            return user;
        throw new HttpNotFoundException("user: " + username + " not found");
    }
}
