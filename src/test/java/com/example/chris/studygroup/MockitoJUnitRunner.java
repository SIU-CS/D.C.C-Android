package com.example.chris.studygroup;

//**
//* Created by DJE66 on 12/08/2016.
  //      */

        import org.junit.Test;
import org.junit.runner.RunWith;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class UnitTestSample {

    private static final String user_STRING = "Test Out";


    UserProfile mMockcontact;

    @Test
    public Integer readStringFromContext_LocalizedString() {
        // Given a mocked Context injected into the object under test...
        if (mMockcontact.getID(R.string.error_incorrect_password)) {
            return (Integer.valueOf(user_STRING));
        }
        User myObjectUnderTest = new User() {
            @Override
            public boolean addToGroup(String group) {
                return false;
            }

            @Override
            public boolean isMember(String group) {
                return false;
            }

            @Override
            public boolean removeFromGroup(String group) {
                return false;
            }

            @Override
            public LinkedList getGroups() {
                return null;
            }

            @Override
            public LinkedList getCreatedGroups() {
                return null;
            }

            @Override
            public boolean createGroup(String name, String sub) {
                return false;
            }

            @Override
            public boolean removeGroup(GenData group) {
                return false;
            }

            public boolean removeGroup(String name) {
                return false;
            }

            @Override
            public String getPass() {
                return null;
            }

            @Override
            public void setPass(String pass) {

            }

            @Override
            public String getId() {
                return null;
            }

            @Override
            public void setId(String Id) {

            }

            @Override
            public String getEmail() {
                return null;
            }

            @Override
            public void setEmail(String email) {

            }

            @Override
            public String toString() {
                return null;
            }

            @Override
            public String getUser() {
                return null;
            }

            @Override
            public void setID(int ID) {

            }
        };

        // ...when the string is returned from the object under test...
        String result = myObjectUnderTest.getUser();

        // ...then the result should be the expected one.
        assertThat(result, is(user_STRING));
    }
}
