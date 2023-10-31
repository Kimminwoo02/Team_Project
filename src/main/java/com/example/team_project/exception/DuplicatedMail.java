package com.example.team_project.exception;

public class DuplicatedMail  extends ExceptionRole{
    private static final String MESSAGE= "이미 가입된 메일이에요!";

    public DuplicatedMail(){
        super(MESSAGE);
    }
    @Override
    public int getStatusCode() {
        return 400;
    }
}
