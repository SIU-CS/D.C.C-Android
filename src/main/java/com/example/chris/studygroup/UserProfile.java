package com.example.chris.studygroup;

/**
 * Created by DJE66 on 11/05/2016.
 */

public class UserProfile extends GenData implements User  {
    private String ID,email,pass;
    LinkedList groups,current,created;

    public UserProfile(String Id, String Email, String Password){
        setId(Id);
        setEmail(Email);
        setPass(Password);
        groups= new LinkedList("myGroups");
        created= new LinkedList("createdGroups");
    }
    @Override
    public boolean addToGroup(String group) {
        current=MainActivity.tree.getGroup(group);
        if(current!=null){
            current.add(this);
            groups.add(current);
            return true;

        }
        return false;
    }

    @Override
    public boolean isMember(String group) {
        current=MainActivity.tree.getGroup(group);
        if(current!=null){


            return groups.contains(current);

        }
        return false;
    }

    @Override
    public boolean removeFromGroup(String group) {
        current=MainActivity.tree.getGroup(group);
        if(current!=null){
            current.remove(this);
            groups.remove(current);
            return true;

        }
        return false;
    }


    @Override
    public LinkedList getGroups() {
        return groups;
    }

    @Override
    public LinkedList getCreatedGroups() {
        return created;
    }

    @Override
    public boolean createGroup(String name,String sub) {
        return MainActivity.tree.addGroup(name,sub);
    }

    @Override
    public boolean removeGroup(String name) {
        return false;
    }
//-----------------------------------------------------------------------------------------------------------------------------------+
//                Get and Set Methods                                                                                                |
//-----------------------------------------------------------------------------------------------------------------------------------+
    @Override
    public void setId(String Id){
        this.ID=Id;
    }
    @Override
    public String getId(){
        return ID;
    }

    @Override
    public void setEmail(String email){
        this.email=email;
    }
    @Override
    public String getEmail(){
        return email;
    }

    @Override
    public void setPass(String password){
        this.pass=password;
    }
    @Override
    public String getPass(){
        return pass;
    }

    @Override
    public String toString(){
        return "( " + ID + ", " + email +" )\n";
    }

}
// Code Review //
// This code was written and organzied very well, //
