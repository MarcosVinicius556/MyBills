package com.dev.marcos.mybills.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dev.marcos.mybills.entities.User;
import com.dev.marcos.mybills.services.UserService;

@RestController("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping( value = "/{id}" )
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

}
