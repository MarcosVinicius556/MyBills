package com.dev.marcos.mybills.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.marcos.mybills.dto.UserRegisterDTO;
import com.dev.marcos.mybills.entities.User;
import com.dev.marcos.mybills.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping( value = "/{id}" )
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> createUser(
        @RequestBody UserRegisterDTO dto
    ) {
        /**
         * Ao salvar o usuário, retornar para a url de login,
         * automatizando assim o processo de login...
         */
        User temp = userService.saveUser(dto);
        return ResponseEntity.ok().body(temp != null ? true : false );
    }
}
