package com.dev.marcos.mybills.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.marcos.mybills.dto.UserRegisterDTO;
import com.dev.marcos.mybills.entities.User;
import com.dev.marcos.mybills.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public User saveUser(UserRegisterDTO dto) {
        User user = new User();
        /**
         * TODO FIXME
         * Montar tratativas e exceções personalizadas para quando um usuário já existir, ou quando não for encontrado, etc...
         */
        user.setUserName(dto.username());
        user.setName(dto.name());
        user.setPass(dto.password());
        return userRepository.save(user);
    }

}
