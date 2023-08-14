package com.dev.marcos.mybills.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.marcos.mybills.dto.UserApplication;
import com.dev.marcos.mybills.dto.UserLogin;
import com.dev.marcos.mybills.entities.User;
import com.dev.marcos.mybills.services.TokenService;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<UserApplication> login(@RequestBody UserLogin userLogin){

        
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
                                    new UsernamePasswordAuthenticationToken(
                                                userLogin.userName(),
                                                 userLogin.password());

        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        User user = (User) authentication.getPrincipal();
        String accesToken = tokenService.generateToken(user);
        UserApplication dto = new UserApplication(user.getId(),
                                                  user.getName(), 
                                                  user.getAvatarImage(), 
                                                  user.getBalance(), 
                                                  user.getTelephone(), 
                                                  user.getBills(), 
                                                  accesToken);
        return ResponseEntity.ok().body(dto);
    }

}
