package com.example.chris.studygroup;


/**
 * Created by Chris on 10/30/2016.
 */


public interface User {
    boolean addToGroup(String group);
    boolean isMember(String group);
    boolean removeFromGroup(String group);
    LinkedList getGroups();
    LinkedList getCreatedGroups();
    boolean createGroup(String name,String sub);
    boolean removeGroup(String name);
    String getPass();
    void setPass(String pass);
    String getId();
    void setId(String Id);
    String getEmail();
    void setEmail(String email);
    String toString();

}
