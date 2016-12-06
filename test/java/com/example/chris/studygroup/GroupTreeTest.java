package com.example.chris.studygroup;

import org.junit.Test;
import java.util.regex.Pattern;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * Created by Chris on 12/5/2016.
 */
public class GroupTreeTest {
    @Test
    public void addSub() throws Exception {
        GroupTree tree = new GroupTree();
        LinkedList sub= new LinkedList("testSub");
        tree.addSub(sub);
        if(tree.getSub("testSub")==sub){
            assert(true);
        }else assert(false);
    }

    @Test
    public void addGroup() throws Exception {
        GroupTree tree = new GroupTree();
        LinkedList sub= new LinkedList("testSub");
        tree.addSub(sub);
        tree.addGroup("testgroup","testSub");

        if(tree.getGroup("testgroup")!=null){
            assert(true);
        }else assert(false);
    }

    @Test
    public void addUser() throws Exception {
        GroupTree tree = new GroupTree();
        LinkedList sub= new LinkedList("testSub");
        UserProfile user = new UserProfile("testuser","email@test","pass");
        tree.addSub(sub);
        tree.addGroup("testgroup","testSub");
        tree.addUser(user,"testgroup");

        if(tree.getGroup("testgroup").contains(user)){
            assert(true);
        }else assert(false);
    }
}