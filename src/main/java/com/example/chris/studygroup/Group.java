package com.example.chris.studygroup;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class Group extends AppCompatActivity implements View.OnClickListener {


    FloatingActionButton butSearch, butHome, butAdd, butPro, butCal;
    Button butCreate;
    EditText txtSub, txtGrp;
    Spinner spinSub;
    SpinnerAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        butHome = (FloatingActionButton) findViewById(R.id.butHome);
        butSearch = (FloatingActionButton) findViewById(R.id.butSearch);
        butAdd = (FloatingActionButton) findViewById(R.id.butAdd);
        butPro = (FloatingActionButton) findViewById(R.id.butPro);
        butCal = (FloatingActionButton) findViewById(R.id.butCal);

        butCreate = (Button) findViewById(R.id.butCreate);

        txtGrp = (EditText) findViewById(R.id.txtGrp);
        txtSub = (EditText) findViewById(R.id.txtSub);

        spinSub =(Spinner) findViewById(R.id.spinSub);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,MainActivity.subjects);

        butHome.setOnClickListener(this);
        butSearch.setOnClickListener(this);
        butAdd.setOnClickListener(this);
        butPro.setOnClickListener(this);
        butCal.setOnClickListener(this);

        butCreate.setOnClickListener(this);

        spinSub.setAdapter(adapter);



    }

    @Override
    public void onClick(View v) {
        if (v == butHome) {
            finish();
        } else if (v == butSearch) {
            startActivity(MainActivity.Search);
            finish();
        } else if (v == butAdd) {
        } else if (v == butPro) {
            startActivity(MainActivity.Profile);
            finish();
        } else if (v == butCal) {
            startActivity(MainActivity.Calendar);
            finish();
        } else if (v == butCreate) {

            if (txtGrp.getText().length()==0) {
                txtGrp.setError("Group Name Cannot be blank");
            } else {
                MainActivity.user.createGroup(txtGrp.getText().toString(), spinSub.getSelectedItem().toString());
                MainActivity.currentGrp=MainActivity.tpackage com.example.chris.studygroup;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class Group extends AppCompatActivity implements View.OnClickListener {


    FloatingActionButton butSearch, butHome, butAdd, butPro, butCal;
    Button butCreate;
    EditText txtSub, txtGrp;
    Spinner spinSub;
    SpinnerAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        butHome = (FloatingActionButton) findViewById(R.id.butHome);
        butSearch = (FloatingActionButton) findViewById(R.id.butSearch);
        butAdd = (FloatingActionButton) findViewById(R.id.butAdd);
        butPro = (FloatingActionButton) findViewById(R.id.butPro);
        butCal = (FloatingActionButton) findViewById(R.id.butCal);

        butCreate = (Button) findViewById(R.id.butCreate);

        txtGrp = (EditText) findViewById(R.id.txtGrp);
        txtSub = (EditText) findViewById(R.id.txtSub);

        spinSub =(Spinner) findViewById(R.id.spinSub);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,MainActivity.subjects);

        butHome.setOnClickListener(this);
        butSearch.setOnClickListener(this);
        butAdd.setOnClickListener(this);
        butPro.setOnClickListener(this);
        butCal.setOnClickListener(this);

        butCreate.setOnClickListener(this);

        spinSub.setAdapter(adapter);



    }

    @Override
    public void onClick(View v) {
        if (v == butHome) {
            finish();
        } else if (v == butSearch) {
            startActivity(MainActivity.Search);
            finish();
        } else if (v == butAdd) {
        } else if (v == butPro) {
            startActivity(MainActivity.Profile);
            finish();
        } else if (v == butCal) {
            startActivity(MainActivity.Calendar);
            finish();
        } else if (v == butCreate) {

            if (txtGrp.getText().length()==0) {
                txtGrp.setError("Group Name Cannot be blank");
            } else {
                MainActivity.user.createGroup(txtGrp.getText().toString(), spinSub.getSelectedItem().toString());
                MainActivity.currentGrp=MainActivity.tree.getGroup(txtGrp.getText().toString());

            }



        }


    }

}


ree.getGroup(txtGrp.getText().toString());

            }



        }


    }

}





