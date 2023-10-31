package com.example.team_project.exception;

public class MatchingNotFound extends ExceptionRole{

    private static final String MESSAGE = "존재하지 않는 매칭입니다!";

    public MatchingNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 0;
    }
}
