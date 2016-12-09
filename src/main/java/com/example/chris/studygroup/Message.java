package com.example.chris.studygroup;

/**
 * Created by Chris on 11/14/2016.
 */
// Code Review//
// Make ssure you write descritpion on what this code does, and how to implement //

public class Message extends GenData{
    String data;
    String ID;

    Message(String Id, String data){
        setData(data);
        setId(Id);
    }

    @Override
    public void setId(String Id) {
        this.ID=Id;
    }
    @Override
    public String getId(){
        return this.ID;
    }

    private void setData(String data) {
        this.data = data;
    }
    private String getData(){
        return this.data;
    }
    @Override
    public String toString(){
        return getData();
    }
}
