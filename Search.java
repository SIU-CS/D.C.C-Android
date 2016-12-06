package com.example.chris.studygroup;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Search extends AppCompatActivity implements View.OnClickListener {



    FloatingActionButton butSearch, butHome, butAdd, butPro, butCal;
    Button butFind;
    EditText txtSearch;
    TextView itemOne,itemTwo,itemThree,itemFour,itemFive,itemSix;
    TextView[] groupList;
    GenData[] groups;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        groupList=new TextView[6];

        butHome = (FloatingActionButton) findViewById(R.id.butHome);
        butSearch = (FloatingActionButton) findViewById(R.id.butSearch);
        butAdd = (FloatingActionButton) findViewById(R.id.butAdd);
        butPro = (FloatingActionButton) findViewById(R.id.butPro);
        butCal = (FloatingActionButton) findViewById(R.id.butCal);

        butFind = (Button) findViewById(R.id.butFind);
        txtSearch = (EditText) findViewById(R.id.txtSearch);

        itemOne =(TextView) findViewById(R.id.itemOne);
        itemTwo =(TextView) findViewById(R.id.itemTwo);
        itemThree =(TextView) findViewById(R.id.itemThree);
        itemFour =(TextView) findViewById(R.id.itemFour);
        itemFive =(TextView) findViewById(R.id.itemFive);
        itemSix =(TextView) findViewById(R.id.itemSix);

        butHome.setOnClickListener(this);
        butSearch.setOnClickListener(this);
        butAdd.setOnClickListener(this);
        butPro.setOnClickListener(this);
        butCal.setOnClickListener(this);

        butFind.setOnClickListener(this);

        groupList[0]=itemOne;
        groupList[1]=itemTwo;
        groupList[2]=itemThree;
        groupList[3]=itemFour;
        groupList[4]=itemFive;
        groupList[5]=itemSix;


        updateList();




    }

    @Override
    public void onClick(View v) {
        if( v ==butHome){
            finish();
        }
        else if( v==butSearch){
        }
        else if(v==butAdd){
            startActivity(MainActivity.Group);
            finish();
        }
        else if ( v==butPro){
            startActivity(MainActivity.Profile);
            finish();
        }
        else if (v == butCal){
            startActivity(MainActivity.Calendar);
            finish();
        }
        else if (v == butFind){
            updateList();
        }
    }
    public void updateList(){
        groups=MainActivity.tree.Search(txtSearch.getText().toString());
        System.out.println(groups.length);

        for(int x=0;x<groups.length&&x<5;x++){
            groupList[x].setText(" ");
            if(groups[x]!=null)groupList[x].setText(" "+groups[x].toString());

        }
    }

}
