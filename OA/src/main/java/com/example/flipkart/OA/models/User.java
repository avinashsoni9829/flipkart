package com.example.flipkart.OA.models;

public  class User {
    protected String userName;
    public User(String userName){
         this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }
}
