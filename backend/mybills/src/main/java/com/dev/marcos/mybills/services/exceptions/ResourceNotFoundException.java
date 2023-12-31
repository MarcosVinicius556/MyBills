package com.dev.marcos.mybills.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Não foram encontrados registros com o ID. " + id);
    }
}
