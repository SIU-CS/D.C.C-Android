package com.example.chris.studygroup;

/**
 * Created by DJE66 on 12/07/2016.
 */

public class groupdata {
    int Groupid;
    String Groupname;
    String GroupDescription;
    int leaderid;
    int[] userid=new int[5];
    int isFull;
    int index;
    String Subject;

    public groupdata(){

    }

    public groupdata(int groupid, String groupname, String groupdescription, int Userid, String subject){
        Groupid=groupid;
        Groupname=groupname;
        GroupDescription=groupdescription;
        leaderid=Userid;
        isFull=0;
        int index=0;
        Subject=subject;
    }

    public groupdata(int groupid, String groupname, String groupdescription, int Leaderid, int user1, int user2, int user3, int user4,int user5, int Index, int isfull, String subject){
        Groupid=groupid;
        Groupname=groupname;
        GroupDescription=groupdescription;
        leaderid=Leaderid;
        isFull=isfull;
        int index=Index;
        userid[0]=user1;
        userid[1]=user2;
        userid[2]=user3;
        userid[3]=user4;
        userid[4]=user5;
        Subject=subject;
    }

    public void setGroupid(int groupid){
        Groupid=groupid;
    }
    public int getGroupid(){
        return Groupid;
    }

    public void setGroupname(String groupname){
        Groupname=groupname;
    }
    public String getGroupName(){
        return Groupname;
    }

    public void setGroupDescription(String groupDescription){
        GroupDescription=groupDescription;
    }
    public String getGroupDescription(){
        return GroupDescription;
    }

    public boolean addUser(int user){
        if (isFull==1)
            return false;
        userid[index]=user;
        if(index==4)
            isFull=1;
        else
            index++;
        return true;
    }

    public boolean removeUser(int user){
        boolean check = false;
        for(int i=0;i<5;i++){
            if(userid[i]==user){
                userid[i]=userid[i+1];
                user=userid[i+1];
                check=true;
            }
        }
        if(check==true) {
            index--;
            isFull=0;
        }
        return check;
    }
    public int[] getUsers(){
        return userid;
    }
    public void addLeader(int user){
        leaderid=user;
    }
    public int getLeader(){
        return leaderid;
    }
    public void setUsers(int[] users){
        userid=users;
    }
    public void setIsFull(int i){
        isFull=i;
    }
    public void setIndex(int i){
        index=i;
    }
    public void setSubject(String subject){
        Subject=subject;
    }
    public String getSubject(){
        return Subject;
    }
}
