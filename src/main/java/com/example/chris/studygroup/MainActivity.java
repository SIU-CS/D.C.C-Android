package com.example.chris.studygroup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static Intent Login,Group,Calendar,Profile,Search;

    static GroupTree test;

    FloatingActionButton butSearch, butHome, butAdd, butPro, butCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        butHome = (FloatingActionButton) findViewById(R.id.butHome);
        butSearch = (FloatingActionButton) findViewById(R.id.butSearch);
        butAdd = (FloatingActionButton) findViewById(R.id.butAdd);
        butPro = (FloatingActionButton) findViewById(R.id.butPro);
        butCal = (FloatingActionButton) findViewById(R.id.butCal);

        butHome.setOnClickListener(this);
        butSearch.setOnClickListener(this);
        butAdd.setOnClickListener(this);
        butPro.setOnClickListener(this);
        butCal.setOnClickListener(this);

        Group = new Intent(this, Group.class);
        Calendar = new Intent(this, Calendar.class);
        Profile = new Intent(this, Profile.class);
        Search = new Intent(this, Search.class);

        Login = new Intent(this, LoginScreen.class);
        startActivity(Login);



//-----------------------------------------------------------------------------------------------------------------------------------+
//                Test for Linked List                                                                                               |
//-----------------------------------------------------------------------------------------------------------------------------------+

        test = new GroupTree();

        GenData chris, demarco,colton, art, science, reading;

        art= new LinkedList("Art");
        science= new LinkedList("Science");
        reading= new LinkedList("Reading");

        GenData[]subjects = {art, science, reading};

        chris=new UserProfile("Chris","ckyser2@gmail.com","password");

        demarco=new UserProfile("Demarco","demarco2@gmail.com","password");

        colton=new UserProfile("Colton","colton@gmail.com","password");


        test.addSub(subjects);
        System.out.println(test.toString());
        chris.createGroup("group","Art");
        test.addUser(chris,"group");
        test.addUser(demarco,"group");
        test.addUser(colton,"group");
        System.out.println(test.toString());
        GenData group =test.getGroup("group");


    }
//-----------------------------------------------------------------------------------------------------------------------------------+
//                Button Handler                                                                                                     |
//-----------------------------------------------------------------------------------------------------------------------------------+

    @Override
    public void onClick(View v) {
        if( v ==butHome){

        }
        else if( v==butSearch){
            startActivity(Search);
        }
        else if(v==butAdd){
            startActivity(Group);
        }
        else if ( v==butPro){
            startActivity(Profile);
        }
        else if (v == butCal){
            startActivity(Calendar);
        }
    }
}
