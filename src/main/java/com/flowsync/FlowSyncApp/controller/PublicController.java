package com.flowsync.FlowSyncApp.controller;

import com.flowsync.FlowSyncApp.entity.User;
import com.flowsync.FlowSyncApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping("/create-user")
    public void createUser(@RequestBody User newUser) {
            userService.saveNewUser(newUser);
    }
}
