package com.example.chris.studygroup;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Profile extends AppCompatActivity  implements View.OnClickListener {



    FloatingActionButton butSearch, butHome, butAdd, butPro, butCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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

    }

    @Override
    public void onClick(View v) {
        if( v ==butHome){
            finish();
        }
        else if( v==butSearch){
            startActivity(MainActivity.Search);
            finish();
        }
        else if(v==butAdd){
            startActivity(MainActivity.Group);
            finish();
        }
        else if ( v==butPro){
        }
        else if (v == butCal){
            startActivity(MainActivity.Calendar);
            finish();
        }
    }
}
