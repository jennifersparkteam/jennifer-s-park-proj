package com.example.jennifers.jenniferspark;

/**
 * Created by Jennifer's Team on 10/4/2017.
 */

public class User {
    private String name;
    public User(){
        name="";
    }
    public User (String name){
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
