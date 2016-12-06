package com.example.chris.studygroup;

/**
 * Created by Chris on 11/14/2016.
 */

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
