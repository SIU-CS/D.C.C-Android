package com.example.chris.studygroup;

/**
 * Created by Chris on 11/13/2016.
 */

public abstract class GenData {





    @Override
    abstract public String toString();
    abstract public void setId(String Id);
    abstract public String getId();
//------------------------------------------------------------------------------------------------------------------
//           User Methods to Override
//----------------------------------------------------------------------------------------------------------------
    public boolean addToGroup(String group){return false;}
    public boolean isMember(String group){return false;}
    public boolean removeFromGroup(String group){return false;}

    public LinkedList GetGroups(){return null;}
    public LinkedList GetCreatedGroups(){return null;}
    public boolean createGroup(String name,String sub){return false;}
    public boolean removeGroup(String name){return false;}


//-------------------------------------------------------------------------------------------------------
//           LinkedList Methods to Override
//--------------------------------------------------------------------------------------------------------------
    public String getMessages(){return null;}
     public void add(GenData data){};

    //code review demarco
   public abstract boolean getID(int error_incorrect_password);
}

