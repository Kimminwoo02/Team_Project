package com.example.team_project.exception;

public abstract class ExceptionRole extends RuntimeException{
    public ExceptionRole(String message){
        super(message);
    }
    public ExceptionRole(String message, Throwable cause){
        super(message, cause);
    }
    public abstract int getStatusCode();
}
