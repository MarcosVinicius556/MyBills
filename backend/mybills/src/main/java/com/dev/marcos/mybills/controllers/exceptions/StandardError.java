package com.dev.marcos.mybills.controllers.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * Modelo de dados para serem retornados toda
 * vez que houver uma excessão na API
 */
@Getter
@Setter
public class StandardError implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING,
                pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
                timezone = "GMT")
    private Instant timestamp;

    private int status;

    private String error;

    private String message;

    private String path;

    public StandardError(Instant timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    

}
