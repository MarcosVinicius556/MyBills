package com.dev.marcos.mybills.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.marcos.mybills.dto.UserRegisterDTO;
import com.dev.marcos.mybills.entities.User;
import com.dev.marcos.mybills.repositories.UserRepository;
import com.dev.marcos.mybills.services.exceptions.ResourceNotFoundException;
import com.dev.marcos.mybills.services.exceptions.UserAlreadyExistsException;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User saveUser(UserRegisterDTO dto) {

        /**
         * Se já existir um usuário cadastrado com o
         * mesmo username irá retornar uma exceção para a requisição
         */
        if(userRepository.existsByUserName(dto.username())){
            throw new UserAlreadyExistsException(dto.username());
        }

        User user = new User();
        user.setUserName(dto.username());
        user.setName(dto.name());
        user.setPass(dto.password());
        return userRepository.save(user);
    }

}
