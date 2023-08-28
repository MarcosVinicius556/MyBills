package com.dev.marcos.mybills.services.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    
    private UserAlreadyExistsException(String username) {
        super("Já existe um usuário com a credencial '" + username + "' cadastrado no sistema");
    }

}
