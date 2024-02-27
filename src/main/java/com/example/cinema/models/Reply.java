package com.example.cinema.models;

public class Reply {

    private String message;

    public Reply(){
    }

    public Reply(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
