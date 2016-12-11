package com.example.chris.studygroup;

/**
 * Created by DJE66 on 11/05/2016.
 */

public class UserProfile extends GenData implements User  {
    private String ID,email,pass, group1, group2, group3, group4, group5, grouplead;
    private int id;
    LinkedList groups,current,created;

    public UserProfile(int i, String Id, String Email, String Password){
        setId(Id);
        setEmail(Email);
        setPass(Password);
        groups= new LinkedList("myGroups");
        created= new LinkedList("createdGroups");
    }
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
            created.remove(current);
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

        GenData group = MainActivity.tree.addGroup(name,sub);
        created.add(group);
       group.add(this);

        System.out.println(group.toString()+"testmessage");
        return (group==null);
    }

    @Override
    public boolean getID(int error_incorrect_password) {
        return false;
    }

    @Override
    public boolean removeGroup(GenData group) {
        return created.remove(group);
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

    @Override
    public String getUser() {
        return null;
    }

    @Override
    public void setID(int ID) {

    }

    public UserProfile(){

    }

    public void setGroup1(String group){
        group1= group;
    }
    public String getGroup1(){
        return group1;
    }

    public void setGroup2(String group){
        group2= group;
    }
    public String getGroup2(){
        return group2;
    }

    public void setGroup3(String group){
        group3= group;
    }
    public String getGroup3(){
        return group3;
    }

    public void setGroup4(String group){
        group4= group;
    }
    public String getGroup4(){
        return group4;
    }

    public void setGroup5(String group){
        group5= group;
    }
    public String getGroup5(){
        return group5;
    }


}
