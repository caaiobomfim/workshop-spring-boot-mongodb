package com.project.workshopmongo.services.exception;

import java.io.Serial;

public class ObjectNotFoundException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 2778423331468717431L;

    public ObjectNotFoundException(String msg){
        super(msg);
    }
}
